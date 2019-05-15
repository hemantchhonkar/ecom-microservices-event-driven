package com.example.product.productapp.service

import com.example.product.productapp.model.Product
import org.springframework.stereotype.Service

@Service
interface ProductService {
    fun createProduct(product: Product): Product
    fun getAllProducts(): List<Product>
}