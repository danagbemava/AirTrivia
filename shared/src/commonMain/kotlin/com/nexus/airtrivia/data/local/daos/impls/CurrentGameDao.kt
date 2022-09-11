package com.nexus.airtrivia.data.local.daos.impls

import com.nexus.airtrivia.data.local.daos.interfaces.ICurrentGameDao
import com.nexus.airtrivia.data.local.models.CurrentGameState
import io.realm.kotlin.Realm
import org.koin.core.component.KoinComponent

class CurrentGameDao(val realm: Realm) : ICurrentGameDao, KoinComponent {
    override suspend fun updateCurrentGame(currentGame: CurrentGameState) {
        TODO("Not yet implemented")
    }

    override suspend fun getCurrentGame() : CurrentGameState {
        TODO("Not yet implemented")
    }

    override suspend fun finishGame(currentGame: CurrentGameState) {
        TODO("Not yet implemented")
    }
}