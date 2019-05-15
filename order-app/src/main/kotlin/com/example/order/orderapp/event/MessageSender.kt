package com.example.order.orderapp.event

import com.example.order.orderapp.configuration.exchangeName
import com.example.order.orderapp.configuration.routingKey
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageSender @Autowired constructor(val rabbitTemplate: RabbitTemplate) {


    fun sendOrderCreatedEvent(orderCreatedEvent: OrderCreatedEvent) {
        this.rabbitTemplate.convertAndSend(exchangeName, routingKey, orderCreatedEvent)
        println("Order created event send")
    }
}
