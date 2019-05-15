package com.example.product.productapp.repository

import com.example.product.productapp.model.Product
import org.springframework.data.mongodb.repository.MongoRepository

interface ProductRepository: MongoRepository<Product, Long>