package com.levonlight.translatortask.extensions

import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.gson.responseObject
import com.levonlight.translatortask.api.Routing

inline fun <reified T : Any> fuelRequest(
    fuelParameters: Routing.SearchWord,
    crossinline success: Success<T?>,
    crossinline error: Error<String?>
) {
    Fuel.request(fuelParameters)
        .responseObject<T> { _, _, result ->
            result.fold({
                success(it)
            }, {
                error(it.message)
            })
        }
}

/**
 * success response type
 */
typealias Success<T> = (T) -> Unit
/**
 * error by client side
 */
typealias Error<T> = (T) -> Unit


