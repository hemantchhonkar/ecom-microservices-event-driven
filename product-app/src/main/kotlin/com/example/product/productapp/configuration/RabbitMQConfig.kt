package com.example.product.productapp.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

const val queueName = "ecom-queue-product"
const val exchangeName = "ecom-exchange"
const val routingKey = "ecom-product-routing"

@Component
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
    fun binding(queue: Queue, exchange: TopicExchange): Binding {
        println("Creating queue binding")
        return BindingBuilder.bind(queue).to(exchange).with(routingKey)
    }
}