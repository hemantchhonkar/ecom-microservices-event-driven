package com.example.search.searchapp

import com.example.search.searchapp.model.SearchResponse
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller("/")
class SearchController {

    @GetMapping("/productSearch")
    fun getSearchResults(@RequestParam("searchStr") searchStr: String): ResponseEntity<List<SearchResponse>> {
        val searchResults = listOf(SearchResponse(123,
                "MacBook Pro",
                "Intel i7",
                2500.00,
                100
                ),
                SearchResponse(345,
                        "Microsoft Surface Pro",
                        "Intel i9",
                        1800.00,
                        75
                ),
                SearchResponse(567,
                        "Dell Predator",
                        "Intel i7 Turbo",
                        2200.00,
                        120
                ))



        return ResponseEntity.ok(searchResults)
    }

}