package com.nexus.airtrivia.data.local.daos.interfaces

import com.nexus.airtrivia.data.local.models.CurrentGameState

interface ICurrentGameDao {

    suspend fun updateCurrentGame(currentGame: CurrentGameState)

    suspend fun getCurrentGame() : CurrentGameState

    suspend fun finishGame(currentGame: CurrentGameState)
}