package io.github.nenodias.service;

import io.github.nenodias.model.dto.Message;

public interface AmqpService {
    void sendToConsumer(Message message);
}
