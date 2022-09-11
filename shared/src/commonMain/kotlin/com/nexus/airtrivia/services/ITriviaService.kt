package com.nexus.airtrivia.services

import com.nexus.airtrivia.data.remote.models.GetQuestionsRequestModel
import com.nexus.airtrivia.data.remote.models.Question

interface ITriviaService {

    suspend fun getQuestions(model: GetQuestionsRequestModel) : List<Question>
}