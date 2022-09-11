package com.nexus.airtrivia.repostories

import arrow.core.Either
import com.nexus.airtrivia.data.local.daos.interfaces.IQuestionsDao
import com.nexus.airtrivia.data.local.models.AirTriviaQuestion
import com.nexus.airtrivia.data.remote.models.GetQuestionsRequestModel
import com.nexus.airtrivia.services.ITriviaService
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow

class QuestionsRepo(
    private val localDataSource: IQuestionsDao,
    private val remoteDataSource: ITriviaService
) {

    suspend fun loadQuestions(model: GetQuestionsRequestModel) : Either<Boolean, String?> {
        return try {
            val remoteData = remoteDataSource.getQuestions(model)

            val questionsToSave = remoteData.map { it.toAirTriviaQuestion() }.toList()

            localDataSource.saveAllQuestions(questionsToSave)

            Either.Left(true)
        } catch (e: Exception) {
            print("An error occurred: $e")
            Either.Right(e.message)
        }
    }

    fun getQuestions(): Flow<ResultsChange<AirTriviaQuestion>> = localDataSource.getAllQuestions()
}