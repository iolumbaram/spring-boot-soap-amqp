package io.leiva.app.amqpControllers.publisher;

import io.leiva.app.config.AMQPMessagingConfig;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;

public class NumberPublisher {
    @Autowired
    private RabbitTemplate template;

    public void pubNumber(String number){
        template.convertAndSend(AMQPMessagingConfig.EXCHANGE, AMQPMessagingConfig.ROUTING_KEY, number);
    }

}
