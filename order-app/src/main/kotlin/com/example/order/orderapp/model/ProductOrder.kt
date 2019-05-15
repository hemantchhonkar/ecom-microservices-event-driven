package com.example.order.orderapp.model

import org.springframework.data.annotation.Id

class ProductOrder (
        @Id
        val orderId: Long,
        val productId: Long,
        val userId: Long,
        val quantity: Int
)