package com.example.order.orderapp.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

const val queueName = "ecom-queue-order"
const val routingKey = "ecom-order-routing"
const val exchangeName = "ecom-exchange"

@Configuration
@EnableRabbit
class RabbitMQConfig {

    @Bean
    fun queue(): Queue{
        return Queue(queueName)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(exchangeName)
    }

    @Bean
    fun binding(topicExchange: TopicExchange): Binding{
        println("Creating binding for $queueName")
        return BindingBuilder.bind(queue()).to(topicExchange).with(routingKey)
    }
}