package test.com.zy.test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args)
    {
        //1.创建一个服务器Socket，即ServerSocket,指定绑定的端口，并坚挺
        try {
            ServerSocket serverSocket=new ServerSocket(8888);
            //2，调用accept()开始监听，等待客户端的链接
            System.out.println("****服务器即将启动，等待客户端的连接****");
            Socket socket=serverSocket.accept();
            //3.获取输入流并获取客户信息
            InputStream in=socket.getInputStream();

            InputStreamReader isr=new InputStreamReader(in,"utf-8");

            BufferedReader br=new BufferedReader(isr);

            String info;

            StringBuilder sb=new StringBuilder();
            while ((info=br.readLine())!=null)
            {
                sb.append(info);
            }
            System.out.println("我是服务器，客户端发来的消息为:"+sb);

            socket.shutdownInput();//关闭输入流

            //4.获取输出流，用于响应客户端的请求
            OutputStream os=socket.getOutputStream();
            PrintWriter pw=new PrintWriter(os);
            pw.write("欢迎您");
            pw.flush();//将缓冲输出

            //4.关闭相关资源
            pw.close();
            os.close();


            br.close();
            isr.close();
            in.close();
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
