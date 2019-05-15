package com.example.search.searchapp.repository

import com.example.search.searchapp.model.SearchResponse
import org.springframework.data.mongodb.repository.MongoRepository

interface SearchResponseRepository: MongoRepository<SearchResponse, Long>