package com.levonlight.translatortask.search

import com.levonlight.translatortask.api.Routing

class SearchRepository {

    fun searchWord(searchWord: String): Routing.SearchWord =
        Routing.SearchWord(searchWord)

}