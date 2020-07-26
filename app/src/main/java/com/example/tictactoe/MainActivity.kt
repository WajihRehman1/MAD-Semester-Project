package com.example.tictactoe

import android.content.Intent
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*

var player1=ArrayList<Int>()
var player2=ArrayList<Int>()
var activePlayer=1
var device_model= ""
var flagDraw=0
class MainActivity : AppCompatActivity() {

    lateinit var db: DocumentReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //Firebase Data
        db = FirebaseFirestore.getInstance().document("TicTacToe/Move")
        try {
            val moves = HashMap<String, Any>()
            moves.put("Box_id:", 0)
            moves.put("Active_Player:", 0)
            db.collection("TicTacToe").document("Move").set(moves)


        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }

        download_data()
    }

    fun download_data() {
        var flag1 = 0
        var flag2 = 0
        var flag3 = 0
        var flag4 = 0
        var flag5 = 0
        var flag6 = 0
        var flag7 = 0
        var flag8 = 0
        var flag9 = 0

        //firestore getting data
        val thread: Thread = object : Thread() {

            override fun run() {

                try {

                    while (!this.isInterrupted) {
                        sleep(1000)
                        runOnUiThread {

                            val docRef = db.collection("TicTacToe").document("Move")
                            docRef.get()
                                .addOnSuccessListener { document ->
                                    if (document != null) {
                                        Log.d("exists", "DocumentSnapshot data: ${document.data}")
                                        device_model= Build.MODEL
                                        var box_id = document.get("Box_id:")
                                        var acPlayer = document.get("Active_Player:")
                                        var device=document.get("device:")


                                        if(device.toString().equals(device_model)){
                                            val toast=Toast.makeText(this@MainActivity,"Their turn",Toast.LENGTH_SHORT)
                                            toast.setGravity(Gravity.TOP,0,250)
                                            toast.show()
                                            bu1.isClickable=false
                                            bu2.isClickable=false
                                            bu3.isClickable=false
                                            bu4.isClickable=false
                                            bu5.isClickable=false
                                            bu6.isClickable=false
                                            bu7.isClickable=false
                                            bu8.isClickable=false
                                            bu9.isClickable=false
                                        }
                                        else{
                                            val toast=Toast.makeText(this@MainActivity,"Your turn",Toast.LENGTH_SHORT)
                                            toast.setGravity(Gravity.TOP,0,250)
                                            toast.show()
                                            bu1.isClickable=true
                                            bu2.isClickable=true
                                            bu3.isClickable=true
                                            bu4.isClickable=true
                                            bu5.isClickable=true
                                            bu6.isClickable=true
                                            bu7.isClickable=true
                                            bu8.isClickable=true
                                            bu9.isClickable=true
                                        }

                                        if (box_id.toString().equals("1") && flag1 == 0) {
                                            if (acPlayer.toString().equals("1")) {

                                                bu1.text = "X"
                                                bu1.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))

                                            } else {
                                                bu1.text = "0"
                                                bu1.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag1++


                                        } else if (box_id.toString().equals("2") && flag2 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu2.text = "X"
                                                bu2.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu2.text = "0"
                                                bu2.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag2++

                                        } else if (box_id.toString().equals("3") && flag3 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu3.text = "X"
                                                bu3.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu3.text = "0"
                                                bu3.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag3++

                                        } else if (box_id.toString().equals("4") && flag4 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu4.text = "X"
                                                bu4.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu4.text = "0"
                                                bu4.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag4++

                                        } else if (box_id.toString().equals("5") && flag5 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu5.text = "X"
                                                bu5.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu5.text = "0"
                                                bu5.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag5++

                                        } else if (box_id.toString().equals("6") && flag6 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu6.text = "X"
                                                bu6.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu6.text = "0"
                                                bu6.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag6++

                                        } else if (box_id.toString().equals("7") && flag7 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu7.text = "X"
                                                bu7.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu7.text = "0"
                                                bu7.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag7++

                                        } else if (box_id.toString().equals("8") && flag8 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu8.text = "X"
                                                bu8.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu8.text = "0"
                                                bu8.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag8++

                                        } else if (box_id.toString().equals("9") && flag9 == 0) {
                                            if (acPlayer.toString().equals("1")) {
                                                bu9.text = "X"
                                                bu9.setBackgroundColor(Color.YELLOW)
                                                activePlayer = 2
                                                player1.add(Integer.parseInt(box_id.toString()))
                                            } else {
                                                bu9.text = "0"
                                                bu9.setBackgroundColor(Color.GREEN)
                                                activePlayer = 1
                                                player2.add(Integer.parseInt(box_id.toString()))
                                            }
                                            flag9++

                                        }
                                        checkWinner()
                                    } else {
                                        Log.d("not exists ", "No such document")
                                    }
                                }
                                .addOnFailureListener { exception ->
                                    Log.d("error DB", "get failed with ", exception)
                                }
                        }
                    }
                } catch (e: InterruptedException) {
                }
            }
        }
        thread.start()


//        -------------------------

    }


    fun newGame() {
        player1.clear()
        player2.clear()

        //initilizing firebase for new game
        try {
            val moves = HashMap<String, Any>()
            moves.put("Box_id:", 0)
            moves.put("Active_Player:", activePlayer)
            db.collection("TicTacToe").document("Move").set(moves)


        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
//        //-----------------------------------------------
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent);
    }


    fun buClick(view: View) {
        //checking winner before next move
        val buSelected = view as Button

        var cellId = 0
        when (buSelected.id) {
            R.id.bu1 -> cellId = 1
            R.id.bu2 -> cellId = 2
            R.id.bu3 -> cellId = 3
            R.id.bu4 -> cellId = 4
            R.id.bu5 -> cellId = 5
            R.id.bu6 -> cellId = 6
            R.id.bu7 -> cellId = 7
            R.id.bu8 -> cellId = 8
            R.id.bu9 -> cellId = 9

        }
        //---------FIREBASE DATA-----------------
        try {
            val moves = HashMap<String, Any>()
            moves.put("Box_id:", cellId)
            moves.put("Active_Player:", activePlayer)
            moves.put("device:", device_model)
            db.collection("TicTacToe").document("Move").set(moves)



        } catch (e: Exception) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show()
        }
        //-----------------------------------------


    }


    fun checkWinner(): Boolean {
        var flag00 = 0
        var flag11 = 0
        var flag22 = 0
        var flag33 = 0
        var flag44 = 0
        var flag55 = 0
        var diag = 0
        var diag1 = 0
        var diag2 = 0
        var diag3 = 0
        var fcol = 0
        var fcol1 = 0
        var fcol2 = 0
        var fcol3 = 0
        var fcol4 = 0
        var fcol5 = 0
        var fcol6 = 0

        //for Row 1
        for (x in 1..3) {
            if (player1.contains(x)) {
                flag00 += 1

            }
            if (player2.contains(x)) {
                flag11 += 1
            }
            if (flag00 == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (flag11 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }
        for (x in 4..6) {
            if (player1.contains(x)) {
                flag22 += 1
            }
            if (player2.contains(x)) {
                flag33 += 1
            }
            if (flag22 == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (flag33 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }
        for (x in 7..9) {
            if (player1.contains(x)) {
                flag44 += 1
            }
            if (player2.contains(x)) {
                flag55 += 1
            }
            if (flag44 == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (flag55 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }

        for (x in listOf(1, 4, 7)) {
            if (player1.contains(x)) {
                fcol += 1
            }
            if (player2.contains(x)) {
                fcol1 += 1
            }
            if (fcol == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (fcol1 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }
        for (x in listOf(2, 5, 8)) {
            if (player1.contains(x)) {
                fcol2 += 1
            }
            if (player2.contains(x)) {
                fcol3 += 1
            }
            if (fcol2 == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (fcol3 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }
        for (x in listOf(3, 6, 9)) {
            if (player1.contains(x)) {
                fcol4 += 1
            }
            if (player2.contains(x)) {
                fcol5 += 1
            }
            if (fcol4 == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (fcol5 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }

        for (x in listOf(1, 5, 9)) {
            if (player1.contains(x)) {
                diag += 1
            }
            if (player2.contains(x)) {
                diag1 += 1
            }
            if (diag == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (diag1 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }
        for (x in listOf(3, 5, 7)) {
            if (player1.contains(x)) {
                diag2 += 1
            }
            if (player2.contains(x)) {
                diag3 += 1
            }
            if (diag2 == 3) {
                Toast.makeText(this, "Winner is Player 1", Toast.LENGTH_SHORT).show()
                newGame()
            }
            if (diag3 == 3) {
                Toast.makeText(this, "Winner is Player 2", Toast.LENGTH_SHORT).show()
                newGame()
            }
        }
        var game = false
        if (fcol == 3 || fcol1 == 3 || fcol2 == 3 || fcol3 == 3 || fcol4 == 3 || fcol5 == 3 || fcol6 == 3 || flag00 == 3
            || flag11 == 3 || flag22 == 3 || flag33 == 3 || flag44 == 3 || flag55 == 3 || diag == 3 || diag == 3
            || diag1 == 3 || diag2 == 3 || diag3 == 3
        ) {
            game = true
        }

        return game
    }




}
