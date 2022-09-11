package com.nexus.airtrivia.data.remote.models

data class GetQuestionsRequestModel(
    val category: String,
    val numberOfQuestions: Int
) {
    fun toQueryParameters() : String {
        return "categories=$category&limit=$numberOfQuestions"
    }
}