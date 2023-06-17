package ru.perelyginva.composition.domain.usecases

import ru.perelyginva.composition.domain.entity.GameSettings
import ru.perelyginva.composition.domain.entity.Level
import ru.perelyginva.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val repository: GameRepository,
) {

    operator fun invoke(level: Level): GameSettings {
        return repository.getGameSettings(level)
    }

}