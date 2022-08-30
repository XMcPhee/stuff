package com.example.thecontest

import android.content.Context
import android.graphics.Color
import android.media.Image
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.ViewModel
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    val imageViewModel: CounterViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("LifeCycle", "onCreate ${imageViewModel.counter.count}")
        //Assign all UI fields a variable
        val plusScore = findViewById<Button>(R.id.button4)
        val minusScore = findViewById<Button>(R.id.button5)
        val resetScore = findViewById<Button>(R.id.button6)
        val currentScore = findViewById<TextView>(R.id.textView2)
        var mediaPlayer = MediaPlayer.create(this, R.raw.beep_short)
        currentScore.text = imageViewModel.counter.count()
        imageViewModel.changeColour(currentScore)
        //val mediaPlayer = MediaPlayer.create(this, R.raw)


        //Adds one to the score
        plusScore.setOnClickListener{
            imageViewModel.counter.increment()
            if (imageViewModel.counter.count == 15){
                mediaPlayer.start()
            }
            imageViewModel.changeColour(currentScore)
            currentScore.text = imageViewModel.counter.count()
        }

        //Minus one to the score
        minusScore.setOnClickListener{
            imageViewModel.counter.decrement()
            imageViewModel.changeColour(currentScore)
            currentScore.text = imageViewModel.counter.count()
        }

        //Reset score
        resetScore.setOnClickListener{
            imageViewModel.counter.reset()
            imageViewModel.changeColour(currentScore)
            currentScore.text = imageViewModel.counter.count()
        }



    }


}