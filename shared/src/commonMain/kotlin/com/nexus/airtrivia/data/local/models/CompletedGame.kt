package com.nexus.airtrivia.data.local.models

import io.realm.kotlin.types.ObjectId
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey


class CompletedGame : RealmObject {

    @PrimaryKey
    var _id: ObjectId = ObjectId.create()
    var score: Double = 0.0
    var category: String = ""
    var numberOfQuestions: Int = 10

}
