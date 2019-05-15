package com.example.productinventory.productinventoryapp.service

import com.example.productinventory.productinventoryapp.event.MessageSender
import com.example.productinventory.productinventoryapp.event.ProductQuantityCreatedUpdatedEvent
import com.example.productinventory.productinventoryapp.model.ProductQuantity
import com.example.productinventory.productinventoryapp.repository.ProductInventoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ProductInventoryServiceImpl
@Autowired constructor(val productInventoryRepository: ProductInventoryRepository,
                       val messageSender: MessageSender): ProductInventoryService {
    override fun createProductQuantity(productQuantity: ProductQuantity): ProductQuantity {
        val createdProductPrice = productInventoryRepository.save(productQuantity)
        messageSender.publishEvent(ProductQuantityCreatedUpdatedEvent(createdProductPrice))
        return createdProductPrice
    }

    override fun getProducQuantity(productId: Long): ProductQuantity? {
        return productInventoryRepository.findByIdOrNull(productId)
    }
}