package io.github.nenodias.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class QueueConfiguration {

    @Value("${spring.rabbitmq.request.routing-key}")
    private String queue;

    @Value("${spring.rabbitmq.request.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.request.deadletter}")
    private String deadLetter;

    public String getQueue() {
        return queue;
    }

    public String getExchange() {
        return exchange;
    }

    public String getDeadLetter() {
        return deadLetter;
    }
}
