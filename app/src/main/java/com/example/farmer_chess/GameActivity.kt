package com.example.farmer_chess

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

class GameActivity : AppCompatActivity(){

    private var currentPlayer:Int = 1
    private val currentPlayerMark: String
        get() {
            return if (currentPlayer == 1) "X" else "O"
        }

//    val currentPlayerMark: String
//        get() {
//            return if (option == "a/b") {
//                if (currentPlayer == 1) "A" else "B"
//            } else{
//                if (currentPlayer == 1) "X" else "O"
//            }
//        }

//    private var state = arrayOf( // 2D Array
//        intArrayOf(0, 0, 0),
//        intArrayOf(0, 0, 0),
//        intArrayOf(0, 0, 0)
//    )

    private var count_x: Int = 0
    private var count_o: Int = 0

    private lateinit var one: TextView
    private lateinit var two: TextView
    private lateinit var three: TextView
    private lateinit var four: TextView
    private lateinit var five: TextView
    private lateinit var six: TextView
    private lateinit var seven: TextView
    private lateinit var eight: TextView
    private lateinit var nine: TextView
    private lateinit var reset: Button
    private lateinit var back: Button
    private lateinit var next_move: TextView
    private lateinit var move_count_x: TextView
    private lateinit var move_count_o: TextView

    private val TEXT_VIEW_KEY_1 = "one"
    private val TEXT_VIEW_KEY_2 = "two"
    private val TEXT_VIEW_KEY_3 = "three"
    private val TEXT_VIEW_KEY_4 = "four"
    private val TEXT_VIEW_KEY_5 = "five"
    private val TEXT_VIEW_KEY_6 = "six"
    private val TEXT_VIEW_KEY_7 = "seven"
    private val TEXT_VIEW_KEY_8 = "eight"
    private val TEXT_VIEW_KEY_9 = "nine"
    private val TEXT_VIEW_KEY_NEXT_MOVE = "next_move"
//    private val TEXT_VIEW_KEY_MOVE_X = "move_count_x"
//    private val TEXT_VIEW_KEY_MOVE_O = "move_count_o"

    private val GAME_STATE_COUNT_X = "count_x"
    private val GAME_STATE_COUNT_O = "count_o"
    private val GAME_STATE_CURRENT_PLAYER= "current_player"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (savedInstanceState != null) {
            currentPlayer = savedInstanceState.getInt(GAME_STATE_CURRENT_PLAYER)
            count_x = savedInstanceState.getInt(GAME_STATE_COUNT_X)
            count_o = savedInstanceState.getInt(GAME_STATE_COUNT_O)
        }

        setContentView(R.layout.activity_game)

        one = findViewById<TextView>(R.id.one)
        two = findViewById<TextView>(R.id.two)
        three = findViewById<TextView>(R.id.three)
        four = findViewById<TextView>(R.id.four)
        five = findViewById<TextView>(R.id.five)
        six = findViewById<TextView>(R.id.six)
        seven = findViewById<TextView>(R.id.seven)
        eight = findViewById<TextView>(R.id.eight)
        nine = findViewById<TextView>(R.id.nine)
        reset = findViewById<Button>(R.id.reset)
        back = findViewById<Button>(R.id.back)
        next_move = findViewById<TextView>(R.id.next_move)

//        one.setOnClickListener { onBoxClicked(one, Position(0, 0)) }
//        two.setOnClickListener { onBoxClicked(two, Position(0, 1)) }
//        three.setOnClickListener { onBoxClicked(three, Position(0, 2)) }
//        four.setOnClickListener { onBoxClicked(four, Position(1, 0)) }
//        five.setOnClickListener { onBoxClicked(five, Position(1, 1)) }
//        six.setOnClickListener { onBoxClicked(six, Position(1, 2)) }
//        seven.setOnClickListener { onBoxClicked(seven, Position(2, 0)) }
//        eight.setOnClickListener { onBoxClicked(eight, Position(2, 1)) }
//        nine.setOnClickListener { onBoxClicked(nine, Position(2, 2)) }
        one.setOnClickListener { onBoxClicked(one) }
        two.setOnClickListener { onBoxClicked(two) }
        three.setOnClickListener { onBoxClicked(three) }
        four.setOnClickListener { onBoxClicked(four) }
        five.setOnClickListener { onBoxClicked(five) }
        six.setOnClickListener { onBoxClicked(six) }
        seven.setOnClickListener { onBoxClicked(seven) }
        eight.setOnClickListener { onBoxClicked(eight) }
        nine.setOnClickListener { onBoxClicked(nine) }
        reset.setOnClickListener{
            startActivity(Intent(this@GameActivity, GameActivity::class.java))
        }
        back.setOnClickListener{
            startActivity(Intent(this@GameActivity, MainActivity::class.java))
        }
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        one.text = savedInstanceState.getString(TEXT_VIEW_KEY_1)
        two.text = savedInstanceState.getString(TEXT_VIEW_KEY_2)
        three.text = savedInstanceState.getString(TEXT_VIEW_KEY_3)
        four.text = savedInstanceState.getString(TEXT_VIEW_KEY_4)
        five.text = savedInstanceState.getString(TEXT_VIEW_KEY_5)
        six.text = savedInstanceState.getString(TEXT_VIEW_KEY_6)
        seven.text = savedInstanceState.getString(TEXT_VIEW_KEY_7)
        eight.text = savedInstanceState.getString(TEXT_VIEW_KEY_8)
        nine.text = savedInstanceState.getString(TEXT_VIEW_KEY_9)
        next_move.text = savedInstanceState.getString(TEXT_VIEW_KEY_NEXT_MOVE)
//        move_count_x.text = savedInstanceState.getString(TEXT_VIEW_KEY_MOVE_X)
//        move_count_o.text = savedInstanceState.getString(TEXT_VIEW_KEY_MOVE_O)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.run {
            putString(TEXT_VIEW_KEY_1, one.text.toString())
            putString(TEXT_VIEW_KEY_2, two.text.toString())
            putString(TEXT_VIEW_KEY_3, three.text.toString())
            putString(TEXT_VIEW_KEY_4, four.text.toString())
            putString(TEXT_VIEW_KEY_5, five.text.toString())
            putString(TEXT_VIEW_KEY_6, six.text.toString())
            putString(TEXT_VIEW_KEY_7, seven.text.toString())
            putString(TEXT_VIEW_KEY_8, eight.text.toString())
            putString(TEXT_VIEW_KEY_9, nine.text.toString())
            putString(TEXT_VIEW_KEY_NEXT_MOVE, next_move.text.toString())
//            putString(TEXT_VIEW_KEY_MOVE_X, move_count_x.text.toString())
//            putString(TEXT_VIEW_KEY_MOVE_O, move_count_o.text.toString())

            putInt(GAME_STATE_CURRENT_PLAYER, currentPlayer)
            putInt(GAME_STATE_COUNT_O, count_o)
            putInt(GAME_STATE_COUNT_X, count_x)
        }
        // call superclass to save any view hierarchy
//
    }

    override fun onBackPressed() {
        super.onBackPressed()
        startActivity(Intent(this@GameActivity, MainActivity::class.java))
    }

    fun makeMove(): WinningLine? {
//        state[position.row][position.column] = currentPlayer
        val winningLine = hasGameEnded()

        if (winningLine == null) {
            currentPlayer = 3 - currentPlayer
        }
        return winningLine
    }

    private fun hasGameEnded(): WinningLine? {
        if (one.text == two.text && two.text == three.text && one.text == three.text && one.text != ""){
            return WinningLine.ROW_0
        } else if (four.text == five.text && five.text == six.text && four.text == six.text && four.text != ""){
            return WinningLine.ROW_1
        } else if (seven.text == eight.text && eight.text == nine.text && seven.text == nine.text && seven.text != ""){
            return WinningLine.ROW_2
        } else if (one.text == four.text && eight.text == nine.text && one.text == nine.text && one.text != ""){
            return WinningLine.COLUMN_0
        } else if (two.text == five.text && five.text == eight.text && two.text == eight.text && two.text != ""){
            return WinningLine.COLUMN_1
        } else if (three.text == six.text && six.text == nine.text && three.text == nine.text && three.text != ""){
            return WinningLine.COLUMN_2
        } else if (one.text == five.text && five.text == nine.text && one.text == nine.text && one.text != ""){
            return WinningLine.DIAGONAL_LEFT
        } else if (three.text == five.text && five.text == seven.text && three.text == seven.text && three.text != ""){
            return WinningLine.DIAGONAL_RIGHT
        }
        return null
//        if (state[0][0] == currentPlayer && state[0][1] == currentPlayer && state[0][2] == currentPlayer) {
//            return WinningLine.ROW_0
//        } else if (state[1][0] == currentPlayer && state[1][1] == currentPlayer && state[1][2] == currentPlayer) {
//            return WinningLine.ROW_1
//        } else if (state[2][0] == currentPlayer && state[2][1] == currentPlayer && state[2][2] == currentPlayer) {
//            return WinningLine.ROW_2
//        } else if (state[0][0] == currentPlayer && state[1][0] == currentPlayer && state[2][0] == currentPlayer) {
//            return WinningLine.COLUMN_0
//        } else if (state[0][1] == currentPlayer && state[1][1] == currentPlayer && state[2][1] == currentPlayer) {
//            return WinningLine.COLUMN_1
//        } else if (state[0][2] == currentPlayer && state[1][2] == currentPlayer && state[2][2] == currentPlayer) {
//            return WinningLine.COLUMN_2
//        } else if (state[0][0] == currentPlayer && state[1][1] == currentPlayer && state[2][2] == currentPlayer) {
//            return WinningLine.DIAGONAL_LEFT
//        } else if (state[0][2] == currentPlayer && state[1][1] == currentPlayer && state[2][0] == currentPlayer) {
//            return WinningLine.DIAGONAL_RIGHT
//        }
//        return null
    }

    private fun onBoxClicked(box: TextView) {
        if (box.text.isEmpty()) {
            box.text = currentPlayerMark
            find_next(currentPlayerMark)

            val winningLine = makeMove()
            if (winningLine != null) {
                disableBoxes()
                showWinner(winningLine)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun find_next(item:Any){
        next_move = findViewById<TextView>(R.id.next_move)
        move_count_o = findViewById<TextView>(R.id.move_count_o)
        move_count_x = findViewById<TextView>(R.id.move_count_x)

        if (item == "X"){
            next_move.text = " O"
            count_x += 1
            move_count_x.text = " ${count_x.toString()}"
        }
        else if (item == "O"){
            next_move.text = " X"
            count_o += 1
            move_count_o.text = " ${count_o.toString()}"
        }
    }

    private fun disableBoxes() {
        one.isEnabled = false
        two.isEnabled = false
        three.isEnabled = false
        four.isEnabled = false
        five.isEnabled = false
        six.isEnabled = false
        seven.isEnabled = false
        eight.isEnabled = false
        nine.isEnabled = false
    }



    private fun showWinner(winningLine: WinningLine) {
        val (winningBoxes, background) = when (winningLine) {
            WinningLine.ROW_0 -> Pair(listOf(one, two, three), R.drawable.winning_background)
            WinningLine.ROW_1 -> Pair(listOf(four, five, six), R.drawable.winning_background)
            WinningLine.ROW_2 -> Pair(listOf(seven, eight, nine), R.drawable.winning_background)
            WinningLine.COLUMN_0 -> Pair(listOf(one, four, seven), R.drawable.winning_background)
            WinningLine.COLUMN_1 -> Pair(listOf(two, five, eight), R.drawable.winning_background)
            WinningLine.COLUMN_2 -> Pair(listOf(three, six, nine), R.drawable.winning_background)
            WinningLine.DIAGONAL_LEFT -> Pair(listOf(one, five, nine),
                R.drawable.winning_background
            )
            WinningLine.DIAGONAL_RIGHT -> Pair(listOf(three, five, seven),
                R.drawable.winning_background
            )
        }

        winningBoxes.forEach { box ->
            box.background = ContextCompat.getDrawable(GameActivity@ this, background)
        }
    }

}


