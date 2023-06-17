package ru.perelyginva.composition.domain.repository

import ru.perelyginva.composition.domain.entity.GameSettings
import ru.perelyginva.composition.domain.entity.Level
import ru.perelyginva.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestions(
        maxSumValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}