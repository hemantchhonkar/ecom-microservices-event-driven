package com.example.product.productapp.event

import com.example.product.productapp.configuration.exchangeName
import com.example.product.productapp.configuration.routingKey
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageSender @Autowired constructor(val rabbitTemplate: RabbitTemplate) {

    fun publishEvent(productCreatedOrUpdateEvent: ProductCreatedOrUpdateEvent) {
        println("Sending event $productCreatedOrUpdateEvent")
        rabbitTemplate.convertAndSend(exchangeName, routingKey, productCreatedOrUpdateEvent)

    }
}