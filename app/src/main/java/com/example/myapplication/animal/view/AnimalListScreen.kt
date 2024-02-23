package com.example.myapplication.animal.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.animal.model.entity.Animal
import com.example.myapplication.animal.viewModel.AnimalState
import com.example.myapplication.animal.viewModel.AnimalStateStatus
import com.example.myapplication.animal.viewModel.AnimalViewModel

@Composable
fun AnimalListScreen(
    animalViewModel: AnimalViewModel,
    animalState: AnimalState,
    modifier: Modifier
){
    when(animalState.animalStateStatus){
         AnimalStateStatus.INITIAL -> LoadingScreen()
        AnimalStateStatus.LOADING -> LoadingScreen()
        AnimalStateStatus.SUCCESS -> AnimalListScreenComp(animalData = animalState.animalData)
        AnimalStateStatus.ERROR -> ErrorScreen()
    }

}



@Composable
fun AnimalListScreenComp(modifier: Modifier = Modifier, animalData: List<Animal>){
    LazyColumn(){
        items(animalData){
            Text(text = it.name, modifier = Modifier.padding(bottom = 12.dp))
        }
    }

}

@Composable
fun LoadingScreen(modifier: Modifier = Modifier){
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        CircularProgressIndicator()
    }
}

@Preview
@Composable
fun ErrorScreen(modifier: Modifier = Modifier){
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = modifier.background(color = Color.White).fillMaxSize()
        ) {
            Icon(Icons.Default.Info, contentDescription = "")
            Text(text = "Error Terjadi")
        }

}