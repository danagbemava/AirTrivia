package com.nexus.airtrivia.data.local.daos.interfaces

import com.nexus.airtrivia.data.local.models.CompletedGame
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow

interface IGameStatsDao {

    fun getAllGameInfo() : Flow<ResultsChange<CompletedGame>>

}