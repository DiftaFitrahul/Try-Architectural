package com.example.myapplication.animal.model.repository

import com.example.myapplication.animal.model.dataSource.AnimalDataSource
import com.example.myapplication.animal.model.entity.Animal

interface AnimalRepository {
    suspend fun getAnimalData(): List<Animal>
}

class NetworkAnimalRepository(
    private val animalDataSource: AnimalDataSource
): AnimalRepository{
    override suspend fun getAnimalData(): List<Animal> = animalDataSource.getAnimal()
}