package com.wjl.springmq.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    //声明队列
    @Bean("test1")
    public Queue queue1() {
        return new Queue("test1", true);
    }

    @Bean("test2")
    public Queue queue2() {
        return new Queue("test2", true);
    }

    //声明转换器
    @Bean("topicExchange")
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }

    @Bean("binding1")
    public Binding binding1() {
        return BindingBuilder.bind(queue1()).to(topicExchange()).with("key.1");
    }

    @Bean("binding2")
    public Binding binding2() {
        return BindingBuilder.bind(queue2()).to(topicExchange()).with("key.#");
    }

}
