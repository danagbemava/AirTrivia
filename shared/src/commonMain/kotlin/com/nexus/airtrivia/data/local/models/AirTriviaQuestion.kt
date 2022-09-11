package com.nexus.airtrivia.data.local.models

import com.nexus.airtrivia.data.remote.models.Question
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.Ignore
import io.realm.kotlin.types.annotations.PrimaryKey

class AirTriviaQuestion : RealmObject {

    var category: String = ""

    @PrimaryKey
    var id: String? = ""
    var correctAnswer: String? = ""
    var incorrectAnswers: List<String> = emptyList()
    var answers : List<String> = emptyList()
    var question: String = ""
    var type: String = ""

    var difficultyFallback : String? = ""

    @Ignore
    var difficulty: Difficulty? = Difficulty.fromName(this.difficultyFallback!!)

    fun fromQuestion(currentQuestion: Question) = AirTriviaQuestion().apply {
        category = currentQuestion.category
        id = currentQuestion.id
        correctAnswer = currentQuestion.correctAnswer
        incorrectAnswers = currentQuestion.incorrectAnswers
        answers = buildList<String> {
            currentQuestion.incorrectAnswers
            currentQuestion.correctAnswer
        }.shuffled()
        question = currentQuestion.question
        type = currentQuestion.type
        difficultyFallback = currentQuestion.difficulty
        difficulty = Difficulty.fromName(currentQuestion.difficulty)
    }
}


enum class Difficulty(val points: Double) {
    easy(5.0),
    medium(10.0),
    hard(15.0);

    companion object {
        fun fromName(name: String): Difficulty {
            return values().first { name.lowercase() == it.name }
        }
    }
}
