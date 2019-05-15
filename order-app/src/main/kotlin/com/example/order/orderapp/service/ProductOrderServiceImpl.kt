package com.example.order.orderapp.service

import com.example.order.orderapp.model.ProductOrder
import com.example.order.orderapp.repository.ProductOrderRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductOrderServiceImpl @Autowired constructor(val productOrderRepository: ProductOrderRepository): ProductOrderService {
    override fun createOrder(productOrder: ProductOrder): ProductOrder {
        val createdOrder = productOrderRepository.save(productOrder)
        return createdOrder
    }

    override fun getAllOrders(): List<ProductOrder> {
        return productOrderRepository.findAll()
    }
}