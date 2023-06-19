package ru.perelyginva.composition.data

import ru.perelyginva.composition.domain.entity.GameSettings
import ru.perelyginva.composition.domain.entity.Level
import ru.perelyginva.composition.domain.entity.Question
import ru.perelyginva.composition.domain.repository.GameRepository
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

object GameRepositoryImpl : GameRepository {
    private const val MIN_SUM_VALUE = 2
    private const val MIN_ANSWER_VALUE = 1

    override fun generateQuestions(maxSumValue: Int, countOfOptions: Int): Question {
        //получаем случайное значение суммы
        val sum = Random.nextInt(MIN_SUM_VALUE, maxSumValue + 1)
        //случайное видимое значение
        val visibleNumber = Random.nextInt(MIN_ANSWER_VALUE, sum)
        //генерируем варианты ответов
        val options = HashSet<Int>()
        //сумма минус то значение что видимо и будет правильный ответ
        val rightAnswer = sum - visibleNumber
        //правильный ответ нужно положить в наш вариант ответа
        options.add(rightAnswer)
        //определяем диапазон в катором мы будем генерировать ответы. Нижняя граница
        val from = max(rightAnswer - countOfOptions, MIN_ANSWER_VALUE)
        //Верхняя граница
        val to = min(maxSumValue, rightAnswer + countOfOptions)
        //генерируем варианты ответа до тех пор пока options не будет == countOfOptions
        while (options.size < countOfOptions) {
            options.add(Random.nextInt(from, to))
        }
        return Question(sum, visibleNumber, options.toList())
    }

    override fun getGameSettings(level: Level): GameSettings {
        return  when(level){
            Level.TEST -> {
                GameSettings(
                    10,
                    3,
                    50,
                    8
                )
            }
            Level.EASY -> {
                GameSettings(
                    10,
                    10,
                    70,
                    60
                )
            }
            Level.NORMAL -> {
                GameSettings(
                    20,
                    20,
                    80,
                    40
                )
            }
            Level.HARD -> {
                GameSettings(
                    30,
                    30,
                    90,
                    40
                )
            }

        }
    }

}