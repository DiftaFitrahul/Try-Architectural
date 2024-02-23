package com.example.myapplication.animal.model.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Animal(
    val name: String,
    val type: String,
    val description: String,
    @SerialName(value = "img_src")
    val imgUrl: String

)
