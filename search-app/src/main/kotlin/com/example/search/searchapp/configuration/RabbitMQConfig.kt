package com.example.search.searchapp.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.annotation.EnableRabbit
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Component

const val queueName_pricing = "ecom-queue-pricing"
const val routingKey_pricing = "ecom-pricing-routing"

const val queueName_product= "ecom-queue-product"
const val exchangeName = "ecom-exchange"
const val routingKey_product = "ecom-product-routing"

@Component
@Configuration
@EnableRabbit
class RabbitMQConfig {

    @Bean
    fun queue1(): Queue{
        return Queue(queueName_product)
    }

    @Bean
    fun queue2(): Queue{
        return Queue(queueName_pricing)
    }

    @Bean
    fun exchange(): TopicExchange {
        return TopicExchange(exchangeName)
    }

    @Bean
    fun binding1(exchange: TopicExchange): Binding {
        println("Creating queue binding Product")
        return BindingBuilder.bind(queue1()).to(exchange).with(routingKey_product)
    }

    @Bean
    fun binding2(exchange: TopicExchange): Binding {
        println("Creating queue binding pricing")
        return BindingBuilder.bind(queue2()).to(exchange).with(routingKey_pricing)
    }
}