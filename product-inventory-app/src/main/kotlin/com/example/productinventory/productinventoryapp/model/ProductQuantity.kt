package com.example.productinventory.productinventoryapp.model

import org.springframework.data.annotation.Id
import java.io.Serializable

class ProductQuantity(
        @Id
        val productId: Long,
        val quantity: Long
): Serializable