package com.levonlight.translatortask.search

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */
class SearchValidator {

    private val pattern = "[a-zA-Z]*".toRegex()

    fun isValidSearchText(text: String): Boolean {
        return text.matches(pattern)
    }

}