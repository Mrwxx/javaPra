package control;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author Mr.wxx
 * @create 2021-07-03-8:37
 **/
@Controller
public class RabbitController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String test1(){
//        rabbitTemplate.convertAndSend();
//        rabbitTemplate.setConfirmCallback();
        return "";
    }
}



