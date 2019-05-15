package com.example.order.orderapp.repository

import com.example.order.orderapp.model.ProductOrder
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductOrderRepository: MongoRepository<ProductOrder, Long>