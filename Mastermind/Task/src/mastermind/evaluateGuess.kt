package mastermind

data class Evaluation(val rightPosition: Int, val wrongPosition: Int)

fun evaluateGuess(secret: String, guess: String): Evaluation {
    val rightPosition = secret.zip(guess).count { TODO() }
    val commonLetters = "ABCDEF".sumBy { ch ->
        Math.min(secret.count { TODO() }, guess.count { TODO() })
    }

    return Evaluation(rightPosition, commonLetters - rightPosition)
}

fun rightPositions(secret: String, guess: String): Int {
    var n = 0
    for (i in 0 until 4) {
        if (guess[i] == secret[i]) n++
    }
    return n
}

fun wrongPositions(secret: String, guess: String): Int {
    var n = 0
    var sub = mutableListOf(secret[0], secret[1], secret[2], secret[3])
    for (i in 0 until 4) {
        if (guess[i] == secret[i]) sub[i] = 'Z'
    }
    for (i in 0 until 4) {
        if (guess[i] != secret[i] && guess[i] in sub) {
            n++
            sub[sub.indexOf(guess[i])] = 'Z'
        }
    }
    return n
}
