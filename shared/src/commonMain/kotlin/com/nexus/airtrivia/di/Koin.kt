package com.nexus.airtrivia.di

import com.nexus.airtrivia.data.local.daos.impls.CurrentGameDao
import com.nexus.airtrivia.data.local.daos.impls.GameStateDao
import com.nexus.airtrivia.data.local.daos.impls.QuestionsDao
import com.nexus.airtrivia.data.local.daos.interfaces.ICurrentGameDao
import com.nexus.airtrivia.data.local.daos.interfaces.IGameStatsDao
import com.nexus.airtrivia.data.local.daos.interfaces.IQuestionsDao
import com.nexus.airtrivia.data.local.db.TriviaDB
import com.nexus.airtrivia.repostories.QuestionsRepo
import com.nexus.airtrivia.services.ITriviaService
import com.nexus.airtrivia.services.TriviaService
import com.nexus.airtrivia.utils.Constants
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule)
}

// called by iOS
fun initKoin() = initKoin {}

val commonModule = module {

    // db injection
    single { TriviaDB.realm }

    //
    single<ITriviaService> { TriviaService(Constants.baseUrl) }

    //
    single<IGameStatsDao> { GameStateDao() }
    single<IQuestionsDao> { QuestionsDao() }
    single<ICurrentGameDao> { CurrentGameDao(it.get()) }

    single { QuestionsRepo(it.get(), it.get()) }

}