package com.nexus.airtrivia.data.local.daos.impls

import com.nexus.airtrivia.data.local.daos.interfaces.IGameStatsDao
import com.nexus.airtrivia.data.local.models.CompletedGame
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import io.realm.kotlin.notifications.ResultsChange
import kotlinx.coroutines.flow.Flow
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class GameStateDao(/*private val realm: Realm*/) : IGameStatsDao, KoinComponent {

    private val db: Realm by inject()

    override fun getAllGameInfo(): Flow<ResultsChange<CompletedGame>> {
       return db.query<CompletedGame>().asFlow()
    }
}