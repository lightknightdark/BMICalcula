package com.example.bmicalcula

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val weightText = findViewById<EditText>(R.id.etWeight)
        val heightText = findViewById<EditText>(R.id.etHeight)
        val calcButton = findViewById<Button>(R.id.btnCalculate)

        calcButton.setOnClickListener {
            val weight = weightText.text.toString()
            val height = heightText.text.toString()

            val bmi = weight.toFloat()/((height.toFloat()/100)*(height.toFloat()/100))

            val bmi2Digits = String.format("%.2f",bmi).toFloat()


        }


    }

    private fun displayResult(bmi :Float){
        val resultIndex = findViewById<TextView>(R.id.tvIndex)
        val resultDescription = findViewById<TextView>(R.id.tvResult)
        val info = findViewById<TextView>(R.id.tvInfo)

        resultIndex.Text = bmi.toString()
        info.Text = "normal set from 18.9 to 24.5"


        var resultText = ""
        var color = 0

        when{
            bmi<18.5 ->{
                resultText = "underweight"
                color= R.color.under_weight
            }
            bmi in 18.50..24.99->{
                resultText = "health"
                color= R.color.normal
            }
            bmi in 25.50..29.99->{
                resultText = "overweight"
                color= R.color.over_weight
            }


        }




    }
}