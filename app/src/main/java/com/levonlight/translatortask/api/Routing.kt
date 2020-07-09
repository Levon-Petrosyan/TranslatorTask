package com.levonlight.translatortask.api

import com.github.kittinunf.fuel.core.HeaderValues
import com.github.kittinunf.fuel.core.Method
import com.github.kittinunf.fuel.util.FuelRouting

sealed class Routing : FuelRouting {

    override val basePath = "https://dictionary.skyeng.ru/api/public/v1/words/"

    data class SearchWord(val search: String) : Routing()

    final override val body: String? = null

    final override val bytes: ByteArray?
        get() = null

    override val path: String
        get() {
            return when (this) {
                is SearchWord -> "search"
            }
        }

    override val method: Method
        get() {
            return when (this) {
                is SearchWord -> Method.GET
            }
        }

    override val params: List<Pair<String, Any?>>?
        get() {
            return when (this) {
                is SearchWord -> listOf("search" to this.search)
            }
        }


    override val headers: Map<String, HeaderValues>?
        get() {
            return null
        }
}
