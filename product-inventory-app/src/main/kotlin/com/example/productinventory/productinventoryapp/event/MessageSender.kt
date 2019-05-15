package com.example.productinventory.productinventoryapp.event

import com.example.productinventory.productinventoryapp.configuration.exchangeName
import com.example.productinventory.productinventoryapp.configuration.routingKey
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageSender @Autowired constructor(val rabbitTemplate: RabbitTemplate) {

    fun publishEvent(productQuantityCreatedUpdatedEvent: ProductQuantityCreatedUpdatedEvent) {
        println("Sending Product Price event $productQuantityCreatedUpdatedEvent")
        rabbitTemplate.convertAndSend(exchangeName, routingKey, productQuantityCreatedUpdatedEvent)

    }
}