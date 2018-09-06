package test.com.zy.test;

import java.io.*;
import java.net.Socket;

public class SocketClient {
    public static void main(String[] args)
    {
        //1.创建客户端Socket,指定服务器端地址和端口号
        try {
            Socket socket=new Socket("localhost",12345);
            //2.获取输出流，用来向服务器端发送登录信息
            OutputStream os=socket.getOutputStream();

            PrintWriter pw=new PrintWriter(os);//将输出流打包成打印流
            pw.write("用户名:codingxiaxw;密码:123");
            System.out.println("数据已经写入！！");
            pw.flush();//刷新缓存

            socket.shutdownOutput();//关闭输出流

            //3.获取服务器传过来的输入流，读取服务器的响应信息
            InputStream in=socket.getInputStream();
            BufferedReader br=new BufferedReader(new InputStreamReader(in,"utf-8"));
            String info;

            StringBuilder sb=new StringBuilder();
            while ((info=br.readLine())!=null)
            {
                sb.append(info);
            }
            System.out.println("我是客户端，服务器给我的信息为:"+sb);


            //3.关闭资源

            br.close();
            in.close();


            pw.close();
            os.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
