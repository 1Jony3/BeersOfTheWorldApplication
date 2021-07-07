package ru.cft.shift2021summer

class AsteroidRepository {
    private val asteroids = mutableListOf(
        Asteroid(
            id = 1,
            name = "Arethusa",
            weight = "2,6⋅10^18 кг",
            density = "2,000 г/см³",
            temperature = listOf("−114 °C", "−106 °C")
        ),
        Asteroid(
            id = 2,
            name = "Antiope",
            weight = "1,0⋅10^18 кг",
            density = "2,700 г/см³",
            temperature = listOf("−115 °C", "−106 °C")
        ),
        Asteroid(
            id = 3,
            name = "Hecate",
            weight = "2,6⋅10^18 кг",
            density = "2,000 г/см³",
            temperature = listOf("−119 °C", "−56 °C")
        ),
        Asteroid(
            id = 4,
            name = "Egle",
            weight = "5,1⋅10^18 кг",
            density = "2,000 г/см³",
            temperature = listOf("−114 °C", "−96 °C")
        ),
        Asteroid(
            id = 5,
            name = "Silvia",
            weight = "(1,478 ± 0,006)10^19 кг",
            density = "1,200 ± 0,100 г/см³",
            temperature = listOf("−122 °C", "−106 °C")
        ),
        Asteroid(
            id = 6,
            name = "Ianta",
            weight = "2,6⋅10^18 кг",
            density = "2,000 г/см³",
            temperature = listOf("−103  °C", "−97 °C")
        ),
        Asteroid(
            id = 7,
            name = "Minerva",
            weight = "3,7⋅10^18 кг",
            density = "1,900 г/см³",
            temperature = listOf("−105 °C", "−98 °C")
        ),
        Asteroid(
            id = 8,
            name = "Io",
            weight = "3,4⋅10^18 кг",
            density = "1,400 г/см³",
            temperature = listOf("−101 °C", "−95 °C")
        ),
        Asteroid(
            id = 9,
            name = "Clio",
            weight = "5,2⋅10^17 кг",
            density = "2,000 г/см³",
            temperature = listOf("−92 °C", "−89 °C")
        )
    )


    fun getAll(): List<Asteroid> = asteroids

    fun get(id: Long): Asteroid? = asteroids.firstOrNull { it.id == id }


    fun set(asteroid: Asteroid) {
        val asteroidIndex = asteroids.indexOfFirst { it.id == asteroid.id }
        asteroids[asteroidIndex] = asteroid
    }
}