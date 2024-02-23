package com.example.myapplication

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.animal.view.AnimalListScreen
import com.example.myapplication.animal.viewModel.AnimalViewModel

@Preview
@Composable
fun MainApp(){
    Scaffold(
        topBar = {
            Text(text = "Amphibians")
        }
    ) {

        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
            val animalViewModel: AnimalViewModel = viewModel(factory = AnimalViewModel.Factory)
            val animalState by animalViewModel.animalUiState.collectAsState()
            AnimalListScreen(animalViewModel = animalViewModel, animalState = animalState, modifier = Modifier)
        }
    }
}