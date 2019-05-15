package com.example.productpricing.productpricingapp.event

import com.example.productpricing.productpricingapp.model.ProductPrice
import java.io.Serializable

data class ProductPriceAddedUpdatedEvent(val productPrice: ProductPrice): Serializable