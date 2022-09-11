package com.nexus.airtrivia.utils

sealed class Either<T, U> {
    data class Success<T>(val data: T)
    data class Error(val error: String)
}
