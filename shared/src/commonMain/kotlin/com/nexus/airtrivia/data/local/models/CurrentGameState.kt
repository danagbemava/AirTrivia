package com.nexus.airtrivia.data.local.models

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey

class CurrentGameState : RealmObject {

  @PrimaryKey
  var gameId: String = ""
  var currentQuestionId: String = ""
  var numberOfQuestionsAnswered: Int = 0

}
