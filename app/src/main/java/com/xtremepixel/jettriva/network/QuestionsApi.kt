package com.xtremepixel.jettriva.network

import com.xtremepixel.jettriva.model.Question
import retrofit2.http.GET

interface QuestionsApi {

    @GET("world.json")
    suspend fun getAllQuestions(): Question
}