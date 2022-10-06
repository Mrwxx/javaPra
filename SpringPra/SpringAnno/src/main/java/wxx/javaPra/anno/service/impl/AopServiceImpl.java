package wxx.javaPra.anno.service.impl;

import org.springframework.stereotype.Service;
import wxx.javaPra.anno.service.AopService;

/**
 * @author Mr.wxx
 * @create 2021-06-26-13:31
 **/
@Service
public class AopServiceImpl implements AopService {
    @Override
    public int add(int a, int b) {
        System.out.println("目标方法执行");
        return a + b;
    }
}
