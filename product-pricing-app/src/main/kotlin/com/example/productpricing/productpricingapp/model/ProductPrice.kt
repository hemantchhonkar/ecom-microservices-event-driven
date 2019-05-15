package com.example.productpricing.productpricingapp.model

import org.springframework.data.annotation.Id
import java.io.Serializable

class ProductPrice(
        @Id
        val productId: Long,
        val price: Double
): Serializable