package wxx.javaPra.anno.listener;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr.wxx
 * @create 2021-04-17-19:20
 **/
@Component
public class AppListener implements ApplicationListener {
    @Override
    public void onApplicationEvent(ApplicationEvent applicationEvent) {
        System.out.println(applicationEvent.getSource());
    }
}
