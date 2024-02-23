package com.example.myapplication.animal.model.dataSource

import com.example.myapplication.animal.model.entity.Animal
import retrofit2.http.GET

interface AnimalDataSource {
    @GET("amphibians")
    suspend fun getAnimal(): List<Animal>
}