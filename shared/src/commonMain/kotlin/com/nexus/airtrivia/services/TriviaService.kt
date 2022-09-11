package com.nexus.airtrivia.services

import com.nexus.airtrivia.data.remote.models.GetQuestionsRequestModel
import com.nexus.airtrivia.data.remote.models.Question
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.request.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import org.koin.core.component.KoinComponent

class TriviaService(private val baseUrl: String) : ITriviaService, KoinComponent {

    private val httpClient = HttpClient {
        install(ContentNegotiation) {
            json(Json {
                prettyPrint = true
                isLenient = true
            })
        }
    }

    override suspend fun getQuestions(model: GetQuestionsRequestModel): List<Question> {

        return httpClient.get(urlString = "$baseUrl/questions?${model.toQueryParameters()}")
            .body() ?: emptyList()
    }
}