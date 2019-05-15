package com.example.search.searchapp

import com.example.search.searchapp.model.SearchResponse
import com.example.search.searchapp.service.SearchResponseServiceImpl
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller("/productSearch")
class SearchController @Autowired constructor(val searchResponseServiceImpl: SearchResponseServiceImpl) {

    @GetMapping
    fun getSearchResults(): ResponseEntity<List<SearchResponse>> {
                return ResponseEntity.ok(searchResponseServiceImpl.getAllSearchResults())
    }

}