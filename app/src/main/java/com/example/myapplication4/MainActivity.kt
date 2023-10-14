package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.myapplication4.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editWeight: EditText = findViewById(R.id.editWeight)
        val heightFt: EditText = findViewById(R.id.editHeightFt)
        val heightInch: EditText = findViewById(R.id.editHeightInch)
        val calcButton: Button = findViewById(R.id.calcButton)
        val editResult: TextView = findViewById(R.id.result)
        val llMain: LinearLayout = findViewById(R.id.llMain)

        calcButton.setOnClickListener {
            try {
                val weight: Int = editWeight.text.toString().toInt()
                val ft: Int = heightFt.text.toString().toInt()
                val inch: Int = heightInch.text.toString().toInt()

                if (ft == 0) {
                    editResult.text = "Height cannot be 0"
                    llMain.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
                } else {
                    val totalInch: Int = ft * 12 + inch
                    val totalCm: Float = (totalInch * 2.53).toFloat()
                    val totalM: Float = totalCm / 100
                    val bmi = weight / (totalM * totalM)
                    when {
                        bmi > 25 -> {
                            editResult.text = "You are overweight"
                            llMain.setBackgroundColor(ContextCompat.getColor(this, R.color.yellow))
                        }
                        bmi < 19 -> {
                            editResult.text = "You are underweight"
                            llMain.setBackgroundColor(ContextCompat.getColor(this, R.color.red))
                        }
                        else -> {
                            editResult.text = "You are healthy"
                            llMain.setBackgroundColor(ContextCompat.getColor(this, R.color.green))
                        }
                    }
                }
            } catch (e: NumberFormatException) {
                editResult.text = "Invalid input"
                llMain.setBackgroundColor(ContextCompat.getColor(this, R.color.white))
            }
        }
    }
}
