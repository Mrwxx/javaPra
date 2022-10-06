package mode;

public class ProxyDemo {
    public static void main(String[] args) {
        RealServer realServer = new RealServer();
        ProxyServer proxyServer = new ProxyServer(realServer);
        proxyServer.browse();
    }
}

interface Network{
    public void browse();
    int a = 1;
}

//真实服务器
class RealServer implements Network {
    int a = 2;
    @Override
    public void browse() {
        System.out.println("真实服务器");
    }
}

//代理服务器
class ProxyServer implements Network {

    private Network network;
    public ProxyServer(Network network){
        this.network = network;
    }
    public void check(){
        System.out.println("检查完毕");
    }
    @Override
    public void browse() {
        check();
        network.browse();
    }
}