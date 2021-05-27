package io.github.nenodias.service.impl;

import io.github.nenodias.amqp.AmqpProducer;
import io.github.nenodias.model.dto.Message;
import io.github.nenodias.service.AmqpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQService implements AmqpService {

    @Autowired
    private AmqpProducer<Message> amqpProducer;

    @Override
    public void sendToConsumer(Message message) {
        amqpProducer.produce(message);
    }
}
