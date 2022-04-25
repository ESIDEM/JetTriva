package com.xtremepixel.jettriva.di

import com.xtremepixel.jettriva.network.QuestionsApi
import com.xtremepixel.jettriva.repository.QuestionRepository
import com.xtremepixel.jettriva.utils.Constant
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideQuestionApi(): QuestionsApi {

        return Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(QuestionsApi::class.java)
    }

    @Singleton
    @Provides
    fun provideQuestionRepo(questionsApi: QuestionsApi): QuestionRepository = QuestionRepository(questionsApi)
}