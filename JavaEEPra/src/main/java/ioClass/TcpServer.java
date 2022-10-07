package ioClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Mr.wxx
 * @create 2022-10-06-16:26
 **/
public class TcpServer {
    public static void main(String[] args) {
        try {
            // 1.准备一个ServerSocket
            ServerSocket server = new ServerSocket(8888);

            // 2.监听一个客户端的连接，该方法是阻塞的，如果没有客户端连接则会持续等待
            Socket socket = server.accept();
            System.out.println("一个客户端连接成功！");

            // 3.获取输出流，用来发送数据
            OutputStream out = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            // 4.通信
            // 接受数据
            byte[] data = new byte[1024];
            int len;
            while((len = input.read(data)) != -1){
                System.out.println(new String(data, 0, len ));
                // 发送数据给客户端
                out.write(new String(data, 0, len ).toUpperCase().getBytes());
                out.flush();
            }

            // 发送数据
//            out.write("欢迎登陆".getBytes());

            // 5.关闭socket，input和output的流也关闭了
            socket.close();

            // 6.不再接受客户端通信，可以关闭ServerSocket
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }

    }
}
