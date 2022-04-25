package com.xtremepixel.jettriva.screens

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xtremepixel.jettriva.data.ResultWrapper
import com.xtremepixel.jettriva.model.Question
import com.xtremepixel.jettriva.model.QuestionItem
import com.xtremepixel.jettriva.repository.QuestionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuestionViewModel @Inject constructor(private val questionRepository: QuestionRepository): ViewModel() {

    val data: MutableState<ResultWrapper<ArrayList<QuestionItem>, Boolean, Exception>> =
        mutableStateOf(ResultWrapper(null, true, Exception()))

    init {
        getAllQuestions()
    }

    private fun getAllQuestions(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = questionRepository.getAlQuestions()
            if (data.value.data.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }
}