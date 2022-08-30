package com.example.thecontest

class Counter(val name: String){
    var count = 0

    fun increment() {
        if (count < 15){
            count += 1
        }
    }

    fun decrement(){
        if (count > 0){
            count -= 1
        }
    }

    fun reset(){
        count = 0
    }

    fun count(): String{
        return count.toString()
    }
}