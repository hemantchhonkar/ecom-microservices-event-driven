package com.example.order.orderapp.event

import com.example.order.orderapp.model.ProductOrder
import java.io.Serializable

data class OrderCreatedEvent(val productOrder: ProductOrder): Serializable