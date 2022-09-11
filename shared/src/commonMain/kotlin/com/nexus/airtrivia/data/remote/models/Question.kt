package com.nexus.airtrivia.data.remote.models

import com.nexus.airtrivia.data.local.models.AirTriviaQuestion
import kotlinx.serialization.Serializable

@Serializable
data class Question(
    val category: String,
    val id: String,
    val correctAnswer: String,
    val incorrectAnswers: List<String>,
    val question: String,
    val type: String,
    val difficulty: String,
) {
    fun toAirTriviaQuestion() = AirTriviaQuestion().fromQuestion(this)
}