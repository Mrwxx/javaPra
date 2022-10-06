package io;

import org.junit.Test;

import java.io.*;
import java.net.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

/**
 * @author Mr.wxx
 * @create 2021-03-25-8:55
 **/
public class TEst {
    public static void main(String[] args) {
        File file = new File("1.txt");
        System.out.println(file.getAbsolutePath());
    }

    @Test
    public void test1(){
        File file = new File("1.txt");
        System.out.println(file.getAbsolutePath());

        FileReader fr = null;
        try {
            fr = new FileReader(file);
            int read;
            char[] cha = new char[128];
            while((read = fr.read(cha)) != -1){
                System.out.println(new String(cha, 0, read));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test2(){
        File file = new File("1.txt");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file, true);
            char[] ch = new char[128];
            int w ;
            fw.write("wxx");
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    // 复制操作
    public void test3(){
        File f1 = new File("1.txt");
        File f2 = new File("2.txt");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            if(!f1.exists()){
                f1.createNewFile();
            }
//        if(!f2.exists()){
//            f2.createNewFile();
//        }
            fr = new FileReader(f1);
            fw = new FileWriter(f2);
            char[] ch = new char[128];
            int read;
            while((read = fr.read(ch)) != -1){
                fw.write(ch, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fr != null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(fw != null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test4(){
        File f1 = new File("1.txt");
        File f2 = new File("2.txt");
        FileInputStream fr = null;
        FileOutputStream fw = null;
        InputStreamReader isr = null;
        OutputStreamWriter osw = null;
        try {
            if(!f1.exists()){
                f1.createNewFile();
            }
//        if(!f2.exists()){
//            f2.createNewFile();
//        }
            fr = new FileInputStream(f1);
            isr = new InputStreamReader(fr, "UTF-8");
            fw = new FileOutputStream(f2);
            osw = new OutputStreamWriter(fw, "UTF-8");
            char[] ch = new char[128];
            int read;
            while((read = isr.read(ch)) != -1){
                osw.write(ch, 0, read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(isr != null)
                    isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(osw != null)
                    osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test5(){
        InputStreamReader sir = null;
        BufferedReader br = null;
        try {
            sir = new InputStreamReader(System.in);
            br = new BufferedReader(sir);
            String data;
            while((data = br.readLine()) != null){
                System.out.println(data.toUpperCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br != null)
                    br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test6(){
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File("D:\\1.txt"));
            PrintStream ps = new PrintStream(fos);
            if(ps != null){
                System.setOut(ps);
            }
            for(int i  = 0; i < 5; ++i){
                System.out.println(i);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(fos != null)
                    fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test7(){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream(new File("3.txt")));
            oos.writeObject(new String("wxx"));
            oos.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(oos != null)
                    oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test8(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(new File("3.txt")));
            Object o = ois.readObject();
            String os = (String)o;
            System.out.println(os);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {
            try {
                if(ois != null)
                    ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test9() throws IOException {
        File file = new File("5.txt");
        file.createNewFile();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write("abc".getBytes());
        RandomAccessFile r = new RandomAccessFile(new File("5.txt"), "r");
        RandomAccessFile rw = new RandomAccessFile(new File("7.txt"), "rw");
        byte[] buffer = new byte[1024];
        int read;
        while((read = r.read(buffer)) != -1){
            rw.write(buffer, 0, read);
        }
        rw.close();
        r.close();
    }

    @Test
    public void test10(){
        Path path = Paths.get("1.txt");
        Path path1 = path.toAbsolutePath();
        System.out.println(path1);

    }

    @Test
    public void test11(){
        try {
            InetAddress i1 = InetAddress.getByName("localhost");
            System.out.println(i1.getHostAddress());
            i1.getHostName();
//            InetAddress i2 = InetAddress.getByName("www.baidu.com");
//            System.out.println(i2);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test12(){
        InetAddress i1 = null;
        Socket socket = null;
        OutputStream os = null;
        try {
            i1 = InetAddress.getByName("localhost");
//            System.out.println(i1);
            socket = new Socket(i1, 8866);
            os = socket.getOutputStream();
            os.write("wxx".getBytes());
            //需要显式地停止，因为read方法是阻塞式的
            socket.shutdownOutput();
            // 接受反馈
            InputStream is = socket.getInputStream();
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] array = new byte[1024];
            int read;
            while((read = is.read(array)) != -1){
                bos.write(array);
            }
            System.out.println(bos.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(os != null)
                    os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(socket != null)
                    socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test13()  {
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream bos = null;

        try {
            ss = new ServerSocket(8866);
            accept = ss.accept();
            is = accept.getInputStream();
            bos = new ByteArrayOutputStream();
            byte[] array = new byte[20];
            int read;
            while((read = is.read(array)) != -1){
                bos.write(array);
            }
            System.out.println(bos.toString());
            //反馈
            OutputStream os = accept.getOutputStream();
            os.write("get it".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(bos != null)
                    bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(is != null)
                    is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(accept != null)
                    accept.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if(ss != null)
                    ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void test14(){
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();
            InetAddress localHost = InetAddress.getLocalHost();
            String msg = "wxx";
            DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(), 0, msg.getBytes().length, localHost, 8866);
            socket.send(datagramPacket);
            
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            socket.close();
        }
    }

    @Test
    public void test15(){
        DatagramSocket datagramSocket = null;
        try {
            datagramSocket = new DatagramSocket(8866);
            byte[] bytes = new byte[20];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
            datagramSocket.receive(datagramPacket);
//            datagramPacket.get\\
            System.out.println(new String(datagramPacket.getData(), 0, 3));
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            datagramSocket.close();
        }
    }

    @Test
    public void test16(){
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL("https://jingyan.baidu.com/article/60ccbceb1aac7a64cab197a8.html");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPath());
            System.out.println(url.getPort());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
            System.out.println(url.getRef());
            InputStream inputStream = url.openStream();
            URLConnection urlConnection = url.openConnection();

            fileOutputStream = new FileOutputStream(new File("1.html"));
            byte[] array = new byte[1024];
            int read;
            while((read = inputStream.read(array)) != -1){
                fileOutputStream.write(array, 0, read);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(fileOutputStream != null)
                    fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test17(){
        Runnable aaa = () -> {
            System.out.println("aaa");
        };
        Thread thread = new Thread(aaa);
        thread.start();
        List<Integer> ints = Arrays.asList(1,2);
        String s = "aaa";
        Class<? extends String> aClass = s.getClass();
        System.out.println(aClass);
        System.out.println(String.class);
        System.out.println("java.lang.String".getClass());
        try {
            System.out.println(Class.forName("java.lang.String"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        ClassLoader classLoader = this.getClass().getClassLoader();
        try {
            Class<?> aClass1 = classLoader.loadClass("java.lang.String");
            System.out.println(aClass1);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    //UDP发送端
    @Test
    public void test18(){
        DatagramSocket ds = null;
        try {
            //socket创建
            ds = new DatagramSocket();
            //要发送的信息
            byte[] buffer = "wxx".getBytes();
            //packet创建，包含目的IP和port
            DatagramPacket dp = new DatagramPacket(buffer, 0, buffer.length, InetAddress.getLocalHost(), 8866);
            //指定通过ds socket发送
            ds.send(dp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ds != null){
                ds.close();
            }
        }
    }
    
    //UDP接收端
    @Test
    public void test19(){
        DatagramSocket ds = null;
        try {
            //监听UDP端口
            ds =  new DatagramSocket(8866);
            //缓存数组
            byte[] buffer = new byte[1024];
            //DatagramPacket镀锡
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
            //监听端口
            ds.receive(dp);
            //接受对象
            String str = new String(dp.getData(), 0, dp.getLength());
            System.out.println("ip = " + dp.getAddress() + str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(ds != null){
                ds.close();
            }
        }

    }
}
