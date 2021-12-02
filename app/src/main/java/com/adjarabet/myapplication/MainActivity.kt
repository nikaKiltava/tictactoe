package com.adjarabet.myapplication

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var button4 : Button
    private lateinit var button5 : Button
    private lateinit var button6 : Button
    private lateinit var button7 : Button
    private lateinit var button8 : Button
    private lateinit var button9 : Button
    private lateinit var restart : Button

    var firstPlayer = ArrayList<Int>()
    var secondPlayer = ArrayList<Int>()
    var activePlayer = 1
    var turns = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
    }

    private fun init(){

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        button5 = findViewById(R.id.button5)
        button6 = findViewById(R.id.button6)
        button7 = findViewById(R.id.button7)
        button8 = findViewById(R.id.button8)
        button9 = findViewById(R.id.button9)
        restart = findViewById(R.id.restartButton)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        button5.setOnClickListener(this)
        button6.setOnClickListener(this)
        button7.setOnClickListener(this)
        button8.setOnClickListener(this)
        button9.setOnClickListener(this)

        restart.setOnClickListener {
            activePlayer = 0;
            turns = 0;
            firstPlayer = ArrayList<Int>();
            secondPlayer = ArrayList<Int>();
            button1.setText("")
            button1.setBackgroundColor(Color.CYAN)
            button1.isEnabled = true;
            button2.setText("")
            button2.setBackgroundColor(Color.CYAN)
            button2.isEnabled = true;
            button3.setText("")
            button3.setBackgroundColor(Color.CYAN)
            button3.isEnabled = true;
            button4.setText("")
            button4.setBackgroundColor(Color.CYAN)
            button4.isEnabled = true;
            button5.setText("")
            button5.setBackgroundColor(Color.CYAN)
            button5.isEnabled = true;
            button6.setText("")
            button6.setBackgroundColor(Color.CYAN)
            button6.isEnabled = true;
            button7.setText("")
            button7.setBackgroundColor(Color.CYAN)
            button7.isEnabled = true;
            button8.setText("")
            button8.setBackgroundColor(Color.CYAN)
            button8.isEnabled = true;
            button9.setText("")
            button9.setBackgroundColor(Color.CYAN)
            button9.isEnabled = true;
        }

    }

    private fun playGame(clickedView: Button, buttonNumber: Int){
        if (activePlayer == 1){
            clickedView.text = "X"
            clickedView.setBackgroundColor(Color.RED)
            activePlayer = 2
            firstPlayer.add(buttonNumber)
            turns++

        } else {
            clickedView.text = "0"
            clickedView.setBackgroundColor(Color.BLUE)
            activePlayer = 1
            secondPlayer.add(buttonNumber)
            turns++
        }
        clickedView.isEnabled = false
        check()
    }

    private fun check(){
        var winner = 0
        if (firstPlayer.contains(1) && firstPlayer.contains(2) && firstPlayer.contains(3)){
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(2) && secondPlayer.contains(3)){
            winner = 2
        }
        if (firstPlayer.contains(4) && firstPlayer.contains(5) && firstPlayer.contains(6)){
            winner = 1
        }
        if (secondPlayer.contains(4) && secondPlayer.contains(5) && secondPlayer.contains(6)){
            winner = 2
        }
        if (firstPlayer.contains(7) && firstPlayer.contains(8) && firstPlayer.contains(9)){
            winner = 1
        }
        if (secondPlayer.contains(7) && secondPlayer.contains(8) && secondPlayer.contains(9)){
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(4) && firstPlayer.contains(7)){
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(4) && secondPlayer.contains(7)){
            winner = 2
        }
        if (firstPlayer.contains(2) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winner = 1
        }
        if (secondPlayer.contains(5) && secondPlayer.contains(2) && secondPlayer.contains(7)){
            winner = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(6) && firstPlayer.contains(9)){
            winner = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(6) && secondPlayer.contains(9)){
            winner = 2
        }
        if (firstPlayer.contains(1) && firstPlayer.contains(5) && firstPlayer.contains(9)){
            winner = 1
        }
        if (secondPlayer.contains(1) && secondPlayer.contains(5) && secondPlayer.contains(9)){
            winner = 2
        }
        if (firstPlayer.contains(3) && firstPlayer.contains(5) && firstPlayer.contains(7)){
            winner = 1
        }
        if (secondPlayer.contains(3) && secondPlayer.contains(5) && secondPlayer.contains(7)){
            winner = 2
        }

        if (winner == 1){
            Toast.makeText(this, "first player won", Toast.LENGTH_SHORT).show()
        } else if (winner == 2){
            Toast.makeText(this, "second player won", Toast.LENGTH_SHORT).show()
        } else if (winner == 0 && turns == 9){
            Toast.makeText(this, "draw", Toast.LENGTH_SHORT).show()
        }

    }

    override fun onClick(clickedView: View?) {
        if (clickedView is Button){
            var buttonNumber = 0
            when (clickedView.id){
                R.id.button1 -> buttonNumber = 1
                R.id.button2 -> buttonNumber = 2
                R.id.button3 -> buttonNumber = 3
                R.id.button4 -> buttonNumber = 4
                R.id.button5 -> buttonNumber = 5
                R.id.button6 -> buttonNumber = 6
                R.id.button7 -> buttonNumber = 7
                R.id.button8 -> buttonNumber = 8
                R.id.button9 -> buttonNumber = 9
            }

            if (buttonNumber != 0){
                playGame(clickedView, buttonNumber)
            }
        }
    }


}