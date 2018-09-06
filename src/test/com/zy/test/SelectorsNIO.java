package test.com.zy.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Logger;

public class SelectorsNIO {
    public static void main(String[] args) throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.configureBlocking(false);

        ServerSocket ss = ssc.socket();
//        InetSocketAddress address = new InetSocketAddress( ports[i] );
        InetSocketAddress address = new InetSocketAddress(12345);
        ss.bind(address);
        SelectionKey selectionKey = ssc.register(selector, SelectionKey.OP_ACCEPT);
        ByteBuffer byteBuffer = ByteBuffer.allocate(4096);
        ByteBuffer echoBuffer = ByteBuffer.allocate(4096);
        while (true) {
            int num = selector.select();

            Set selectedKeys = selector.selectedKeys();
            Iterator it = selectedKeys.iterator();

            while (it.hasNext()) {
                SelectionKey key = (SelectionKey) it.next();

                if ((key.readyOps() & SelectionKey.OP_ACCEPT)
                        == SelectionKey.OP_ACCEPT) {
// Accept the new connection
                    ServerSocketChannel ssc2 = (ServerSocketChannel) key.channel();
                    SocketChannel sc = ssc2.accept();
                    sc.configureBlocking(false);

// Add the new connection to the selector
                    SelectionKey newKey = sc.register(selector, SelectionKey.OP_READ);
                    it.remove();

                    System.out.println("Got connection from " + sc);
                } else if ((key.readyOps() & SelectionKey.OP_READ)
                        == SelectionKey.OP_READ) {
// Read the data
                    SocketChannel sc = (SocketChannel) key.channel();

// Echo data
                    int bytesEchoed = 0;
                    while (true) {
                        echoBuffer.clear();
                        int r;
                        try{
                            r = sc.read(echoBuffer);
                            int count = sc.read(echoBuffer);
                            if (r < 0){
                                key.cancel();
                                sc.close();
                                System.out.println("cancel key for < 0");
                                break;
                            }else if (r == 0){
                                break;
                            }
                        } catch (IOException e){
                            e.printStackTrace();
                            key.cancel();
                            System.out.println("cancel key for Exception");
                            break;
                        }
                        if (r <= 0) {
                            break;
                        }

                        echoBuffer.flip();

                        sc.write(echoBuffer);
                        bytesEchoed += r;
                    }

                    System.out.println("Echoed " + bytesEchoed + " from " + sc);

                    it.remove();
                }

            }

            System.out.println("going to clear");
            selectedKeys.clear();
            System.out.println("cleared");
        }
    }
}
