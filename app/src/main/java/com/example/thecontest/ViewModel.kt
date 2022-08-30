package com.example.thecontest

import android.graphics.Color
import android.widget.TextView
import androidx.lifecycle.ViewModel

class CounterViewModel: ViewModel() {
    val counter = Counter("score")

    //Check what current score is and change text colour accordingly
    fun changeColour(text: TextView) {
        if (counter.count in 0..4){
            text.setTextColor(Color.BLACK)
        }
        if (counter.count in 5..9){
            text.setTextColor(Color.BLUE)
        }
        if (counter.count in 10..15){
            text.setTextColor(Color.GREEN)
        }
    }
}