package wxx.javaPra.anno.factoryBean;

import org.springframework.beans.factory.FactoryBean;
import wxx.javaPra.anno.out.Yellow;

/**
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
