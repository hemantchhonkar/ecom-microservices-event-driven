package com.example.product.productapp.model

import org.springframework.data.annotation.Id
import java.io.Serializable

data class Product(
        @Id
        val productId: Long,
        val productName: String,
        val productSpecification: String) : Serializable {
    override fun toString(): String {
        return "Product(productId=$productId, productName='$productName', productSpecification='$productSpecification')"
    }
}