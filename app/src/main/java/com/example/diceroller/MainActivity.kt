package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rollButton.setOnClickListener { tappedRollButton() }
    }

    private fun tappedRollButton() {
        val diceRollResult = Dice.roll();

        //Show the message that dice rolled
        val toast = Toast.makeText(this, R.string.diceRolled, Toast.LENGTH_SHORT)
        toast.show()

        binding.diceImageView.setImageResource(diceRollResult)
    }

}

class Dice {
    companion object {
        private val diceImages = arrayOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
        )

        // Returns a reference to image
        fun roll(): Int {
            return diceImages.random()
        }
    }
}

