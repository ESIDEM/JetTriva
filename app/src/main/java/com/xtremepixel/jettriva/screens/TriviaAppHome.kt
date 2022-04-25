package com.xtremepixel.jettriva.screens

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.xtremepixel.jettriva.component.Questions

@Composable
fun TriviaAppHome(viewModel: QuestionViewModel = hiltViewModel()){
    Questions(viewModel = viewModel)
}