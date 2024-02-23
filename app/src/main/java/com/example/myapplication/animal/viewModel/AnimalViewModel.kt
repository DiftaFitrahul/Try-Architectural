package com.example.myapplication.animal.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.myapplication.AnimalApplication
import com.example.myapplication.animal.model.repository.AnimalRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class AnimalViewModel(private val animalRepository: AnimalRepository) : ViewModel(){
    private var _animalUiState = MutableStateFlow<AnimalState>(AnimalState.Initial())
    val animalUiState: StateFlow<AnimalState> = _animalUiState.asStateFlow()

    init {
        getAnimalData()
    }

    fun getAnimalData(){
        viewModelScope.launch {
            try {
                _animalUiState.update {
                    it.copy(animalStateStatus = AnimalStateStatus.LOADING)
                }
                val animalData = animalRepository.getAnimalData()
                _animalUiState.update {
                    it.copy(animalStateStatus = AnimalStateStatus.SUCCESS, animalData = animalData)
                }

            }catch (err: IOException){
                _animalUiState.update {
                    it.copy(animalStateStatus = AnimalStateStatus.ERROR)
                }
            }catch (err: HttpException){
                _animalUiState.update {
                    it.copy(animalStateStatus = AnimalStateStatus.ERROR)
                }
            }
        }
    }

    companion object{
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AnimalApplication)
                val animalRepository = application.container.animalRepository
                AnimalViewModel(animalRepository = animalRepository)
            }
        }
    }

}