package proxy;

/**
 * @author Mr.wxx
 * @create 2022-10-02-8:27
 **/
public class ProxyDemo {
    public static void main(String[] args) {
        Network net = new ProxyServer(new RealServer());
        net.browse();
    }
}
