package com.example.productinventory.productinventoryapp.event

import com.example.order.orderapp.event.OrderCreatedEvent
import com.example.productinventory.productinventoryapp.configuration.queueName_order
import com.example.productinventory.productinventoryapp.model.ProductQuantity
import com.example.productinventory.productinventoryapp.service.ProductInventoryService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class MessageListener @Autowired constructor(val productInventoryService: ProductInventoryService) {

    @RabbitListener(queues = [queueName_order])
    fun listenOrderEvent(orderCreatedEvent: OrderCreatedEvent) {
        println("Order message received")
        println("Looking inventory details for product id ${orderCreatedEvent.productOrder.productId}")
        val productQuantity = productInventoryService.getProducQuantity(orderCreatedEvent.productOrder.productId)
        if(productQuantity != null){
            val newQuantity = productQuantity.quantity - orderCreatedEvent.productOrder.quantity
            productInventoryService.createProductQuantity(ProductQuantity(
                    orderCreatedEvent.productOrder.productId,
                    newQuantity
            ))
        }else {
            println("No product details found")
        }
    }
}