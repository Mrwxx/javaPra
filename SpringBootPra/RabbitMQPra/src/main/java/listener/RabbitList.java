package listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Mr.wxx
 * @create 2021-07-03-8:45
 **/
@Component
public class RabbitList {

    @RabbitListener(id = "q1")
    public void lisQueue(Message message){
        System.out.println(message.getMessageProperties().getConsumerQueue());
    }
}
