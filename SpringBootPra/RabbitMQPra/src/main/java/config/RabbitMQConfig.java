package config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mr.wxx
 * @create 2021-07-03-8:22
 **/
@Configuration
public class RabbitMQConfig {

    final String EX_Name = "ex1";
    final String qu_Name = "q1";

    @Bean(name = "ex1")
    public Exchange ex1(){
        return ExchangeBuilder.directExchange(EX_Name).durable(true).build();
    }

    @Bean(name = "q1")
    public Queue q1(){
        return QueueBuilder.durable(qu_Name).build();
    }

    @Bean
    public Binding Ex_Qu_Bind(Exchange ex, Queue qu){
        return BindingBuilder.bind(qu).to(ex).with("").noargs();
    }


}
