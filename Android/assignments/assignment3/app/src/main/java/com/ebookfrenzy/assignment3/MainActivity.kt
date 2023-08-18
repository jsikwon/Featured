package com.ebookfrenzy.assignment3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText


import com.ebookfrenzy.assignment3.databinding.ActivityMainBinding
import java.math.BigDecimal

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tipBtn.setOnClickListener {
            tipCalculation()
        }
    }

    private fun tipCalculation() {
        val editTextNumberDecimal: EditText = findViewById(R.id.editTextNumberDecimal)

        val billAmount = editTextNumberDecimal.text.toString()
            if(billAmount.isEmpty()) {
                val errorMessage = "YOU MUST ENTER A BILL AMOUNT"
                binding.output.text = errorMessage
            } else {
                val tip10: BigDecimal = (billAmount.toBigDecimal()) * "1.10".toBigDecimal()
                val tip15: BigDecimal = (billAmount.toBigDecimal()) * "1.15".toBigDecimal()
                val tip20: BigDecimal = (billAmount.toBigDecimal()) * "1.20".toBigDecimal()
                val tipMessage = "The tips are as follows: \n\n 10% = $tip10\n15% = $tip15\n 20% = $tip20"
                binding.output.text = tipMessage
            }
    }
}


