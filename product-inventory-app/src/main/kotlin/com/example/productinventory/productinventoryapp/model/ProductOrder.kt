package com.example.order.orderapp.model

import org.springframework.data.annotation.Id
import java.io.Serializable

class ProductOrder (
        @Id
        val orderId: Long,
        val productId: Long,
        val userId: Long,
        val quantity: Int
): Serializable