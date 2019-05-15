package com.example.product.productapp.event

import com.example.product.productapp.model.Product
import java.io.Serializable

class ProductCreatedOrUpdateEvent (val product: Product): Serializable {
    override fun toString(): String {
        return "ProductCreatedOrUpdateEvent(product=$product)"
    }
}