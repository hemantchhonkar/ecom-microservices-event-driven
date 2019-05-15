package com.example.search.searchapp.service

import com.example.search.searchapp.model.SearchResponse
import com.example.search.searchapp.repository.SearchResponseRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class SearchResponseServiceImpl
@Autowired constructor(val searchResponseRepository: SearchResponseRepository) : SearchResponseService {
    override fun createSearchResult(searchResponse: SearchResponse): SearchResponse {
        return searchResponseRepository.save(searchResponse)
    }

    override fun getAllSearchResults(): List<SearchResponse> {
        return searchResponseRepository.findAll()
    }

    override fun getSearchResponse(productId: Long): SearchResponse? {
        return searchResponseRepository.findByIdOrNull(productId)
    }

}