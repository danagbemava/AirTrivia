package com.nexus.airtrivia.data.local.db

import com.nexus.airtrivia.data.local.models.AirTriviaQuestion
import com.nexus.airtrivia.data.local.models.CompletedGame
import com.nexus.airtrivia.data.local.models.CurrentGameState
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

object TriviaDB {

    private val config = RealmConfiguration.Builder(
        schema = setOf(
            CurrentGameState::class,
            CompletedGame::class,
            AirTriviaQuestion::class
        )
    ).build()

    val realm: Realm = Realm.open(config)
}