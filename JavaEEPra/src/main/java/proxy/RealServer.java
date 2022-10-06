package proxy;

/**
 * 被代理类
 *
 * @author Mr.wxx
 * @create 2022-10-02-8:22
 **/
public class RealServer implements Network{
    @Override
    public void browse() {
        System.out.println("真实服务器浏览器");
    }
}
