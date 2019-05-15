package com.example.productinventory.productinventoryapp.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

const val queueName = "ecom-queue-inventory"
const val exchangeName = "ecom-exchange"
const val routingKey = "ecom-inventory-routing"

const val queueName_order = "ecom-queue-order"
const val routingKey_order = "ecom-order-routing"

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

    @Bean
    fun queueOrder():Queue{
        return Queue(queueName_order)
    }

    @Bean
    fun bindingOrder(exchange: TopicExchange): Binding {
        println("Creating queue binding for order")
        return BindingBuilder.bind(queueOrder()).to(exchange).with(routingKey_order)
    }
}