package com.nexus.airtrivia.data.local.daos.interfaces

import com.nexus.airtrivia.data.local.models.AirTriviaQuestion
import com.nexus.airtrivia.data.remote.models.Question
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow

interface IQuestionsDao {

    suspend fun saveQuestion(question: AirTriviaQuestion)

    suspend fun saveAllQuestions(questions: List<AirTriviaQuestion>)

    fun getAllQuestions() : Flow<ResultsChange<AirTriviaQuestion>>

    suspend fun clearQuestions()
}