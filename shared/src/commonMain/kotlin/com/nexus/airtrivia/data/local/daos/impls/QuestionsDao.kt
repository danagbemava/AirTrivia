package com.nexus.airtrivia.data.local.daos.impls

import com.nexus.airtrivia.data.local.daos.interfaces.IQuestionsDao
import com.nexus.airtrivia.data.local.models.AirTriviaQuestion
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class QuestionsDao : IQuestionsDao, KoinComponent {

    private val db: Realm by inject()

    override suspend fun saveQuestion(question: AirTriviaQuestion) {
        db.write {
            copyToRealm(question)
        }
    }

    override suspend fun saveAllQuestions(questions: List<AirTriviaQuestion>) {
        db.write {
            questions.map {
                copyToRealm(it)
            }
        }
    }

    override fun getAllQuestions(): Flow<ResultsChange<AirTriviaQuestion>> =
        db.query<AirTriviaQuestion>().find().asFlow()

    override suspend fun clearQuestions() {
        db.write {
            val questions = db.query<AirTriviaQuestion>().find()
            delete(questions)
        }
    }
}