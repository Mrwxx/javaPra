package ioClass;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Mr.wxx
 * @create 2022-10-06-16:41
 **/
public class TcpClient {
    public static void main(String[] args) {
        try {
            // 1.准备socket连接server
            Socket socket = new Socket("127.0.0.1", 8888);

            // 2.获取输出流，发送数据给server
            OutputStream out = socket.getOutputStream();
            InputStream input = socket.getInputStream();

            // 3.发送数据
            out.write("lalala".getBytes());
            out.flush();
            // 在输出流的末尾写入结尾标记，对方才能够读到-1，否则对方的读取方法会一直阻塞
            socket.shutdownOutput();

            // 4.接收数据
            byte[] data = new byte[1024];
            int len;
            while((len = input.read(data)) != -1){
                System.out.println(new String(data, 0, len));
            }

            // 5.关闭socket，不再与server通信
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
        }


    }
}
