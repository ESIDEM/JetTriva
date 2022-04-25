package com.xtremepixel.jettriva.repository

import com.xtremepixel.jettriva.data.ResultWrapper
import com.xtremepixel.jettriva.model.QuestionItem
import com.xtremepixel.jettriva.network.QuestionsApi
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val questionsApi: QuestionsApi) {

    private var result = ResultWrapper<ArrayList<QuestionItem>, Boolean, Exception>()

    suspend fun getAlQuestions(): ResultWrapper<ArrayList<QuestionItem>, Boolean, Exception>{

        try {
            result.loading = true
            result.data = questionsApi.getAllQuestions()
            if (result.data.toString().isNotEmpty()) result.loading = false

        } catch (e: Exception){

            result.e = e
        }
        return result
    }
}