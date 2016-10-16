// drawing from https://github.com/bulenkov/2048

package _1Game

import java.awt.*
import java.awt.event.KeyAdapter
import java.awt.event.KeyEvent
import javax.swing.JFrame
import javax.swing.JPanel
import javax.swing.WindowConstants

class GameViewer : JPanel() {
    private val board: Board = BoardImpl()

    init {
        isFocusable = true
        addKeyListener(object : KeyAdapter() {
            override fun keyPressed(e: KeyEvent) {
                if (board.has2048() == false && board.canMove()) {
                    val direction = when (e.keyCode) {
                        KeyEvent.VK_LEFT -> Direction.LEFT
                        KeyEvent.VK_RIGHT -> Direction.RIGHT
                        KeyEvent.VK_DOWN -> Direction.DOWN
                        KeyEvent.VK_UP -> Direction.UP
                        else -> null
                    }
                    if (direction != null) {
                        val moved = board.moveValues(direction)
                        if (moved) board.addRandomValue()
                    }
                }
                repaint()
            }
        })
        board.addRandomValue()
        board.addRandomValue()
    }

    override fun paint(g: Graphics) {
        super.paint(g)
        g.color = BG_COLOR
        g.fillRect(0, 0, this.size.width, this.size.height)
        for (y in 0..3) {
            for (x in 0..3) {
                drawTile(g as Graphics2D, board[y, x], x, y)
            }
        }
    }

    private fun offsetCoors(arg: Int): Int {
        return arg * (TILES_MARGIN + TILE_SIZE) + TILES_MARGIN
    }

    private fun drawTile(g: Graphics2D, value: Int, x: Int, y: Int) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON)
        g.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE)

        val xOffset = offsetCoors(x)
        val yOffset = offsetCoors(y)
        g.color = value.background
        g.fillRoundRect(xOffset, yOffset, TILE_SIZE, TILE_SIZE, 14, 14)
        g.color = value.foreground
        val size = if (value < 100) 36 else if (value < 1000) 32 else 24
        val font = Font(FONT_NAME, Font.BOLD, size)
        g.font = font

        val s = value.toString()
        val fm = getFontMetrics(font)

        val w = fm.stringWidth(s)
        val h = -fm.getLineMetrics(s, g).baselineOffsets[2].toInt()

        if (value != 0)
            g.drawString(s, xOffset + (TILE_SIZE - w) / 2, yOffset + TILE_SIZE - (TILE_SIZE - h) / 2 - 2)

        if (board.has2048() || board.canMove() == false) {
            g.color = Color(255, 255, 255, 30)
            g.fillRect(0, 0, width, height)
            g.color = Color(78, 139, 202)
            g.font = Font(FONT_NAME, Font.BOLD, 48)
            if (board.has2048()) {
                g.drawString("You won!", 68, 150)
            }
            if (!board.canMove()) {
                g.drawString("Game over!", 45, 160)
            }
        }
        g.font = Font(FONT_NAME, Font.PLAIN, 18)
    }

    val Int.foreground: Color
        get() = if (this < 16) Color(0x776e65) else Color(0xf9f6f2)

    val Int.background: Color
        get() = when (this) {
            2 -> Color(0xeee4da)
            4 -> Color(0xede0c8)
            8 -> Color(0xf2b179)
            16 -> Color(0xf59563)
            32 -> Color(0xf67c5f)
            64 -> Color(0xf65e3b)
            128 -> Color(0xedcf72)
            256 -> Color(0xedcc61)
            512 -> Color(0xedc850)
            1024 -> Color(0xedc53f)
            2048 -> Color(0xedc22e)
            else -> Color(0xcdc1b4)
        }
}

private val BG_COLOR = Color(0xbbada0)
private val FONT_NAME = "Arial"
private val TILE_SIZE = 64
private val TILES_MARGIN = 16

fun main(args: Array<String>) {
    val game = JFrame()
    game.title = "2048 Game"
    game.defaultCloseOperation = WindowConstants.EXIT_ON_CLOSE
    game.setSize(340, 400)
    game.isResizable = false

    game.add(GameViewer())

    game.setLocationRelativeTo(null)
    game.isVisible = true
}