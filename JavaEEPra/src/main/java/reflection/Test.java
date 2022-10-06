package reflection;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.util.Properties;

/**
 * @author Mr.wxx
 * @create 2021-03-26-16:25
 **/
public class Test {

    @org.junit.Test
    public void test8() throws IllegalAccessException, InstantiationException {
        Class<? extends Test> aClass = this.getClass();
        Test test = aClass.newInstance();
//        test.test8();
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        ClassLoader classLoader = aClass.getClassLoader();

    }



    @org.junit.Test
    public void test(){
        // 三种类加载器
        ClassLoader classLoader = this.getClass().getClassLoader();
        ClassLoader parent = classLoader.getParent();
        System.out.println(parent);
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);
        System.out.println(classLoader);
    }

    @org.junit.Test
    public void test2() throws IOException {
        //类加载器加载配置文件
        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream("jdbc.properties");
        // 当前module下
//        properties.load(fileInputStream);
//        System.out.println(properties.getProperty("name"));
//        System.out.println(properties.getProperty("age"));
        // src下
        InputStream resourceAsStream = this.getClass().getClassLoader().getResourceAsStream("jdbc.properties");
        properties.load(resourceAsStream);
        System.out.println(properties.getProperty("name"));
        System.out.println(properties.getProperty("age"));
    }

    @org.junit.Test
    public void test3() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        // 构建运行时类对象
        Class<String> stringClass = String.class;
        String s = stringClass.newInstance();
        System.out.println(s);

        Constructor<String> declaredConstructor = stringClass.getDeclaredConstructor(String.class);
        String aaa = declaredConstructor.newInstance(new String("aaa"));
        System.out.println(aaa);
    }

    @org.junit.Test
    public void  test4(){
        String a = "111";
        Class<? extends String> aClass = a.getClass();
        Field[] fields = aClass.getFields();
        Class<?> superclass = aClass.getSuperclass();
        System.out.println(superclass);
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getAnnotations());
            System.out.println(method);
        }
        for (Field field : fields) {
            int modifiers = field.getModifiers();
            Annotation[] annotations = field.getAnnotations();
            for (Annotation annotation : annotations) {
                Class<? extends Annotation> aClass1 = annotation.annotationType();
            }
            Class<?> type = field.getType();
            String name = field.getName();
            System.out.println(Modifier.toString(modifiers) +" "+ type + " "  + name);
        }
        // 获取父类泛型
        Type genericSuperclass = aClass.getGenericSuperclass();
        // 转换为泛型类型
        ParameterizedType parameterizedType = (ParameterizedType)genericSuperclass;
        // 获取实际赋予的泛型参数
        Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
        for (Type actualTypeArgument : actualTypeArguments) {
            System.out.println(actualTypeArgument);
        }
    }

    @org.junit.Test
    public void test5() throws IllegalAccessException, InstantiationException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException {
        Class<Person> personClass = Person.class;
        Person person = personClass.newInstance();
        //调用属性
        Field name = personClass.getDeclaredField("name");
        name.setAccessible(true);
        name.set(person, "wxx");
        System.out.println(name.get(person));

        //调用方法
        Method show = personClass.getDeclaredMethod("show", String.class);
        Object invoke = show.invoke(person, "123456");
        System.out.println(invoke);

        //调用static方法
        Method test = personClass.getDeclaredMethod("test");
        test.setAccessible(true);
        Object invoke1 = test.invoke(null);
        System.out.println(invoke1);
    }

}
