package _2Mastermind

import java.util.*

val DIFFERENT_LETTERS_ALLOWED = false
val ALPHABET = "ABCDEF"
val CODE_LENGTH = 4

fun main(args: Array<String>) {
    playMastermind(DIFFERENT_LETTERS_ALLOWED)
}

fun playMastermind(
        differentLetters: Boolean,
        player: Player = RealPlayer()
) {
    val secret = generateSecret(differentLetters)
    var evaluation: Evaluation
    do {
        val guess = player.guess()
        checkInput(guess)
        evaluation = if (differentLetters)
            evaluateGuessForDifferentLetters(secret, guess)
        else
            evaluateGuessForRepetitiveLetters(secret, guess)

        player.receiveEvaluation(evaluation.complete, evaluation.positions, evaluation.letters)
    } while (!evaluation.complete)
}

class IncorrectInputException(message: String): Exception(message)
fun checkInput(guess: String) {
    val possibleLetters = ALPHABET.toSet()
    val incorrectInput = guess.length != CODE_LENGTH || guess.any { it !in possibleLetters }
    if (incorrectInput) {
        throw IncorrectInputException("Incorrect input: $guess. " +
                "It should consist of $CODE_LENGTH letters (${ALPHABET.toList().joinToString()}). Try again.")
    }
}

fun generateSecret(differentLetters: Boolean = false): String {
    val chars = ALPHABET.toMutableList()
    val random = Random()
    return buildString {
        for (i in 1..CODE_LENGTH) {
            val letter = chars[random.nextInt(chars.size)]
            append(letter)
            if (differentLetters) {
                chars.remove(letter)
            }
        }
    }
}

interface Player {
    fun guess(): String
    fun receiveEvaluation(complete: Boolean, positions: Int, letters: Int)
}

class RealPlayer : Player {
    private val scanner = Scanner(System.`in`)

    override fun guess(): String {
        print("Your guess: ")
        return scanner.next()
    }

    override fun receiveEvaluation(complete: Boolean, positions: Int, letters: Int) {
        if (complete) {
            println("You are correct!")
        } else {
            println("Positions: $positions; letters: $letters.")
        }
    }
}