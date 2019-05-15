package com.example.product.productapp.service

import com.example.product.productapp.event.MessageSender
import com.example.product.productapp.event.ProductCreatedOrUpdateEvent
import com.example.product.productapp.model.Product
import com.example.product.productapp.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl @Autowired constructor(val productRepository: ProductRepository,
                                                val messageSender: MessageSender): ProductService {
    override fun getAllProducts(): List<Product> {
        return productRepository.findAll()
    }

    override fun createProduct(product: Product): Product {
        val createdProduct = productRepository.save(product)
        messageSender.publishEvent(ProductCreatedOrUpdateEvent(createdProduct))
        return createdProduct
    }

}