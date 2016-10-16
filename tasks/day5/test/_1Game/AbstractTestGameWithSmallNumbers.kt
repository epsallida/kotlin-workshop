package _1Game

abstract class AbstractTestGameWithSmallNumbers {
    fun String.toValues(): List<List<Int>> = split(' ').map { row -> row.map { ch -> (ch - '0').toInt() } }

    fun valuesToString(getElement: (Int, Int) -> Int) = buildString {
        for (i in 0..3) {
            for (j in 0..3) {
                append(getElement(i, j))
            }
            append(' ')
        }
    }.trim()

    fun createBoard(input: String): Board {
        val data = input.toValues()
        val board = BoardImpl()
        for (i in 0..3) {
            for (j in 0..3) {
                if (data[i][j] != 0) {
                    board[i, j] = data[i][j]
                }
            }
        }
        return board
    }

    fun Board.print() = valuesToString { i, j -> this[i, j] }
}