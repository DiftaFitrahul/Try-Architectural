package com.example.myapplication.animal.viewModel

import com.example.myapplication.animal.model.entity.Animal

enum class AnimalStateStatus{
    INITIAL,
    LOADING,
    SUCCESS,
    ERROR
}

data class AnimalState(
    val animalStateStatus: AnimalStateStatus,
    val animalData : List<Animal>
){
    companion object{
        fun Initial(): AnimalState{
            return AnimalState(AnimalStateStatus.INITIAL, emptyList())
        }
    }
}
