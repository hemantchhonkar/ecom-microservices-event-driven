package com.example.productpricing.productpricingapp.event

import com.example.productpricing.productpricingapp.configuration.exchangeName
import com.example.productpricing.productpricingapp.configuration.routingKey
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageSender @Autowired constructor(val rabbitTemplate: RabbitTemplate) {

    fun sendProcutPriceAddedUpdatedEvent(productPriceAddedUpdatedEvent: ProductPriceAddedUpdatedEvent) {
        this.rabbitTemplate.convertAndSend(exchangeName, routingKey, productPriceAddedUpdatedEvent)
        println("Procu Proce created event sent ..................")
    }
}