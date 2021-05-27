package io.github.nenodias.amqp.impl;

import io.github.nenodias.amqp.AmqpProducer;
import io.github.nenodias.configuration.QueueConfiguration;
import io.github.nenodias.model.dto.Message;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProducerRabbitMQ implements AmqpProducer<Message> {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private QueueConfiguration queueConfiguration;

    @Override
    public void produce(Message message) {
        try{
            rabbitTemplate.convertAndSend(queueConfiguration.getExchange(), queueConfiguration.getQueue(), message);
        }catch (Exception ex){
            throw new AmqpRejectAndDontRequeueException(ex);
        }
    }
}
