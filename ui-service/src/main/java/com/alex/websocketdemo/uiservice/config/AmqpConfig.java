package com.alex.websocketdemo.uiservice.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AmqpConfig {

    @Bean
    public DirectExchange myExchange() {
        return new DirectExchange("my-exchange");
    }

    @Bean
    public Queue signUpQueue() {
        return new Queue("sign-up-queue");
    }

    @Bean
    public Queue catRequestQueue() {
        return new Queue("cat-request-queue");
    }

    @Bean
    public Queue catReplyQueue() {
        return new Queue("cat-reply-queue");
    }

    @Bean
    public Binding signUpQueueBinding() {
        return BindingBuilder
                .bind(signUpQueue())
                .to(myExchange())
                .with("sign-up");
    }

    @Bean
    public Binding catRequestQueueBinding() {
        return BindingBuilder
                .bind(catRequestQueue())
                .to(myExchange())
                .with("cat-request");
    }

    @Bean
    public Binding catReplyQueueBinding() {
        return BindingBuilder
                .bind(catReplyQueue())
                .to(myExchange())
                .with("cat-reply");
    }
}
