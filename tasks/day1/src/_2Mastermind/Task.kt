package _2Mastermind

/*
You need to implement a part of the 'mastermind' game (in another version "Bulls and Cows").

Our rules:
The computer generates a secret string consisting of 4 letters from A, B, C, D, E, F.
The player has to guess it and has an infinite number of tries.
For each attempt the computer tells the number of right positions and right letters.
Position - the right letter on the right position,
letter - the right letter on the wrong position (see example below and in tests).

You have to implement the evaluation of the number of positions and letters for a given secret string and guess.
The task is to do that for two versions of the game: when all letters are different and when some letters may be repeated.

After you implement it you can run 'Play mastermind' run configuration and play. :)
*/

data class Evaluation(val positions: Int, val letters: Int) {
    val complete: Boolean
        get() = positions == CODE_LENGTH
}

// https://en.wikipedia.org/wiki/Mastermind_(board_game)

// ACEB & BCDF -> 1 position (C), 1 letter (B)

fun evaluateGuessForDifferentLetters(secret: String, guess: String): Evaluation {

    val pos = (0 .. CODE_LENGTH-1).count { i -> secret[i] == guess[i] }
    val let = secret.count { it in guess }

    return Evaluation(pos, let-pos)
}

// AAAF & ABCA -> 1 position (A), 1 letter (A)

fun evaluateGuessForRepetitiveLetters(secret: String, guess: String): Evaluation {

    val pos = (0 .. CODE_LENGTH-1).count { i -> secret[i] == guess[i] }

    val let = ALPHABET.sumBy { ch -> Math.min(secret.count { it == ch }, guess.count { it == ch }) }

    return Evaluation(pos, let-pos)
}