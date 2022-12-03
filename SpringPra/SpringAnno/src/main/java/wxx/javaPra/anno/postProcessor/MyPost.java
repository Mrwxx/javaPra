package wxx.javaPra.anno.postProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * bean后置处理器
 *
 * 添加bean后置处理器后bean的生命周期
 * [1]通过构造器或工厂方法创建bean实例
 * [2]为bean的属性设置值和对其他bean的引用
 * [3]将bean实例传递给bean后置处理器的postProcessBeforeInitialization()方法
 * [4]调用bean的初始化方法
 * [5]将bean实例传递给bean后置处理器的postProcessAfterInitialization()方法
 * [6]bean可以使用了
 * [7]当容器关闭时调用bean的销毁方法
 * @author Mr.wxx
 * @create 2021-04-17-11:15
 **/
@Component
public class MyPost implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessBeforeInitialization " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("postProcessAfterInitialization " + beanName);
        return bean;
    }
}
