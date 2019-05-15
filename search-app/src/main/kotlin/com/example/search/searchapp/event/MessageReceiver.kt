package com.example.search.searchapp.event

import com.example.product.productapp.event.ProductCreatedOrUpdateEvent
import com.example.productinventory.productinventoryapp.event.ProductQuantityCreatedUpdatedEvent
import com.example.productpricing.productpricingapp.event.ProductPriceAddedUpdatedEvent
import com.example.search.searchapp.configuration.queueName_inventory
import com.example.search.searchapp.configuration.queueName_pricing
import com.example.search.searchapp.configuration.queueName_product
import com.example.search.searchapp.model.SearchResponse
import com.example.search.searchapp.service.SearchResponseService
import org.springframework.amqp.rabbit.annotation.RabbitListener
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageReceiver @Autowired constructor(val searchResponseService: SearchResponseService) {

    @RabbitListener(queues = [queueName_product])
    fun productCreatedUpdated(productCreatedOrUpdateEvent: ProductCreatedOrUpdateEvent) {
        println("Product Created or Updated Event received $productCreatedOrUpdateEvent")
        val createdSearchResult =
                searchResponseService.createSearchResult(
                        SearchResponse(productId = productCreatedOrUpdateEvent.product.productId,
                                productName = productCreatedOrUpdateEvent.product.productName,
                                productSpecification = productCreatedOrUpdateEvent.product.productSpecification,
                                availableUnits = 0,
                                productPrice = 0.0)
                )
        println("Search response created $createdSearchResult")
    }

    @RabbitListener(queues = [queueName_inventory])
    fun productQuantityCreatedUpdated(productQuantityCreatedUpdatedEvent: ProductQuantityCreatedUpdatedEvent) {
        println("Product Quantity Created or Updated Event received $productQuantityCreatedUpdatedEvent")
        val searchResultFromDB =
                searchResponseService.getSearchResponse(productQuantityCreatedUpdatedEvent.productQuantity.productId)
        if (searchResultFromDB != null) {
            searchResponseService.createSearchResult(
                    searchResultFromDB.copy(availableUnits =
                    productQuantityCreatedUpdatedEvent.productQuantity.quantity.toInt())
            )
            println("Search response updated with quantity  ${productQuantityCreatedUpdatedEvent.productQuantity.quantity}")
        } else {
            println("No Product found for this event")
        }

    }

    @RabbitListener(queues = [queueName_pricing])
    fun productPriceCreatedUpdated(productPriceAddedUpdatedEvent: ProductPriceAddedUpdatedEvent) {
        println("Product Price Created or Updated Event received $productPriceAddedUpdatedEvent")
        val searchResultFromDB =
                searchResponseService.getSearchResponse(productPriceAddedUpdatedEvent.productPrice.productId)
        if (searchResultFromDB != null) {
            searchResponseService.createSearchResult(
                    searchResultFromDB.copy(productPrice =
                    productPriceAddedUpdatedEvent.productPrice.price)
            )
            println("Search response updated with price  ${productPriceAddedUpdatedEvent.productPrice.price}")
        } else {
            println("No Product found for this event")
        }
    }

}