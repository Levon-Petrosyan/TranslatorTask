package com.levonlight.translatortask.search

class SearchValidator {

    private val pattern = "[a-zA-Z]*".toRegex()

    fun isValidSearchText(text: String): Boolean {
        return text.matches(pattern)
    }

}