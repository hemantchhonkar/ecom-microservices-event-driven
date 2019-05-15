package com.example.search.searchapp.model

import org.springframework.data.annotation.Id

data class SearchResponse(
        @Id
        val productId: Long,
        val productName: String,
        val productSpecification: String,
        val productPrice: Double, val availableUnits: Int)