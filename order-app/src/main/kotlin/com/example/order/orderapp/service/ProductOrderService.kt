package com.example.order.orderapp.service

import com.example.order.orderapp.model.ProductOrder

interface ProductOrderService {
    fun createOrder(productOrder: ProductOrder): ProductOrder
    fun getAllOrders(): List<ProductOrder>
}