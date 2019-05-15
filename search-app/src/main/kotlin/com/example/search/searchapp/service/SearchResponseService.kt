package com.example.search.searchapp.service

import com.example.search.searchapp.model.SearchResponse

interface SearchResponseService {
    fun getAllSearchResults(): List<SearchResponse>
    fun createSearchResult(searchResponse: SearchResponse): SearchResponse
    fun getSearchResponse(productId: Long): SearchResponse?
}