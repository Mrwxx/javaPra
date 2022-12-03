package wxx.javaPra.anno.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import wxx.javaPra.anno.out.Yellow;

/**
 * Bean对象的工厂类
 * 只要在xml中配置了该工厂类，class设置为工厂类的全类名，注册组件是getObject()返回的对象，且不论该对象是否为单例，
 * ioc容器都不会在初始时创建该对象，只会在请求该对象时创建
 *
 * @author Mr.wxx
 * @create 2021-04-17-10:26
 **/
public class YellowFac implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        Yellow yellow = new Yellow();
        return yellow;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
