package io.github.nenodias.service.impl;

import io.github.nenodias.model.dto.Message;
import io.github.nenodias.service.ConsumerService;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Override
    public void action(Message message) {
        System.out.println(message.getText());
        //throw new RuntimeException("Erro para ir para dlq");
    }
}
