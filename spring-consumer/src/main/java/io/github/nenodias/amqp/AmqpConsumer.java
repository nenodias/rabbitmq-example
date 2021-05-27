package io.github.nenodias.amqp;

public interface AmqpConsumer<T> {

    void consumer(T message);

}
