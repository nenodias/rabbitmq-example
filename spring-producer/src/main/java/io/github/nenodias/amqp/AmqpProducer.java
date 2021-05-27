package io.github.nenodias.amqp;

public interface AmqpProducer<T> {
    void produce(T t);
}
