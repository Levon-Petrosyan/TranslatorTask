package com.levonlight.translatortask.search

import com.levonlight.translatortask.api.Routing

/**
 * Created by Levon Petrosyan on 7/7/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */
class SearchRepository {

    fun searchWord(searchWord: String): Routing.SearchWord =
        Routing.SearchWord(searchWord)

}