package io.leiva.app.amqpControllers.consumer;

import com.fasterxml.jackson.annotation.JsonAlias;
import io.leiva.app.config.AMQPMessagingConfig;
import io.leiva.app.dto.Payload;
import io.leiva.app.soap.SoapClient;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {
    @Autowired
    private SoapClient soapClient;

    @RabbitListener(queues = AMQPMessagingConfig.QUEUE)
    public void consumerMessageFromQueue(Payload receivedNumber){
        //AMQP로 메세지를 받은 다음에
        //SOAP service 요청함
        System.out.println("Message Received From queue : " +receivedNumber);
        String conversion = soapClient.convertirNumeroPalabras(receivedNumber.hello);
        System.out.println("Message Returned From SOAP ws : " +conversion);
    }
}
