package wxx.javaPra.anno.contidion;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;
import wxx.javaPra.anno.out.Blue;

/**
 * @author Mr.wxx
 * @create 2021-04-17-10:14
 **/
public class MyImport implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry, BeanNameGenerator importBeanNameGenerator) {
        String className = importingClassMetadata.getClassName();
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        boolean red = registry.containsBeanDefinition("wxx.javaPra.anno.out.Red");
        if(red){
            BeanDefinition beanDefinition = new RootBeanDefinition(Blue.class);
            registry.registerBeanDefinition("blue", beanDefinition);
            
        }
    }
}
