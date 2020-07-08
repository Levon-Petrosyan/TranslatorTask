package com.levonlight.translatortask

import com.levonlight.translatortask.search.SearchValidator
import junit.framework.Assert.assertTrue
import org.junit.Test

/**
 * Created by Levon Petrosyan on 7/8/20.
 * Company name:  Digitain
 * E-Mail: levon.petrosyan.a@digitain.com
 */
class SearchValidatorTest {

    private var searchValidator = SearchValidator()

    @Test
    fun search_validator_correct_text() {
        assertTrue(!searchValidator.isValidSearchText("name@email.com"))
    }

    @Test
    fun search_validator_numbers() {
        assertTrue(!searchValidator.isValidSearchText("43234"))
    }

    @Test
    fun search_validator_text_with_numbers() {
        assertTrue(!searchValidator.isValidSearchText("dasd43234"))
    }

    @Test
    fun search_validator_text_with_simbols() {
        assertTrue(!searchValidator.isValidSearchText("dasd-#"))
    }

    @Test
    fun search_validator__symbols() {
        assertTrue(!searchValidator.isValidSearchText("$$#$#"))
    }
}