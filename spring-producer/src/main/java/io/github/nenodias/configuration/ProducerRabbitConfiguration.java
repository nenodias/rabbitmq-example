package io.github.nenodias.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class ProducerRabbitConfiguration {

	@Autowired
	private QueueConfiguration queueConfiguration;

	@Bean
	DirectExchange exchange(){
		return new DirectExchange(queueConfiguration.getExchange());
	}

	@Bean
	Queue deadLetter(){
		return new Queue(queueConfiguration.getDeadLetter());
	}

	@Bean
	Queue queue(){
		Map<String, Object> args = new HashMap<>();
		args.put("x-dead-letter-exchange", queueConfiguration.getExchange());
		args.put("x-dead-letter-routing-key", queueConfiguration.getDeadLetter());
		final boolean durable = true;
		final boolean exclusive = false;
		final boolean autoDelete = false;
		return new Queue(queueConfiguration.getQueue(), durable, exclusive, autoDelete, args);
	}

	@Bean
	Binding bindingQueue(){
		return BindingBuilder
				.bind(queue())
				.to(exchange()).with(queueConfiguration.getQueue());
	}

	@Bean
	Binding bindingDeadLetter(){
		return BindingBuilder
				.bind(deadLetter())
				.to(exchange()).with(queueConfiguration.getDeadLetter());
	}
}
