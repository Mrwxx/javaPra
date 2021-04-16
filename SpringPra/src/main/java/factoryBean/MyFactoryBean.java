package factoryBean;

import org.springframework.beans.factory.FactoryBean;
import pojo.Person;
import sun.applet.AppletResourceLoader;

/**
 * @author Mr.wxx
 * @create 2021-04-09-10:26
 **/
public class MyFactoryBean implements FactoryBean<Person> {
    public Person getObject() throws Exception {
        Person person = new Person();
        person.setName("wangxu");
        return person;
    }

    public Class<?> getObjectType() {
        return Person.class;
    }

    public boolean isSingleton() {
        return false;
    }
}
