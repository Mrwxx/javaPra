package proxy;

/**
 * 代理类，作用是增强被代理类的功能，既能够调用代理类的方法，也能够增强其他的方法
 *
 * @author Mr.wxx
 * @create 2022-10-02-8:22
 **/
public class ProxyServer implements Network {
    private Network network;

    // 传入Network对象，即被代理类对象，就可以调用被代理类对象的方法
    public ProxyServer(Network network){
        this.network = network;
    }

    // 增强方法
    public void check(){
        System.out.println("检查网络连接情况");
    }

    @Override
    public void browse() {
        // 调用增强方法
        check();
        // 调用被代理类中方法
        network.browse();
    }
}
