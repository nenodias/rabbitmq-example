package io.github.nenodias.service;

import io.github.nenodias.model.dto.Message;

public interface ConsumerService {
    void action(Message message);
}
