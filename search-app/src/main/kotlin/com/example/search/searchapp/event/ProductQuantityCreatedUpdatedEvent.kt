package com.example.productinventory.productinventoryapp.event

import com.example.productinventory.productinventoryapp.model.ProductQuantity
import java.io.Serializable

data class ProductQuantityCreatedUpdatedEvent (val productQuantity: ProductQuantity): Serializable