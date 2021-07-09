package ru.cft.shift2021summer.feature.asteroid

data class Asteroid
(
    val id: Long,
    val name: String,
    val density: String,
    val weight: String, //surface area
    val temperature: List<String>, //maximum and average
    val dangerous: String? = null)