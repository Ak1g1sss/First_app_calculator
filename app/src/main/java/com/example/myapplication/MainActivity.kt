package com.example.myapplication

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Вывод
        val result: TextView = findViewById(R.id.result_text)
        val operation: TextView = findViewById(R.id.math_operation)
/*
        //Операции
        val b_AC: TextView = findViewById(R.id.b_AC)
        val b_del: TextView = findViewById(R.id.b_del)
        val b_percent: TextView = findViewById(R.id.b_percent)
        val b_slash: TextView = findViewById(R.id.b_slash)
        val b_multiply: TextView = findViewById(R.id.b_multiply)
        val b_minus: TextView = findViewById(R.id.b_minus)
        val b_plus: TextView = findViewById(R.id.b_plus)
        val b_comma: TextView = findViewById(R.id.b_comma)
        val b_equal: TextView = findViewById(R.id.b_equal)

        //Цифры
        val num_one: TextView = findViewById(R.id.num_one)
        val num_two: TextView = findViewById(R.id.num_two)
        val num_three: TextView = findViewById(R.id.num_three)
        val num_four: TextView = findViewById(R.id.num_four)
        val num_five: TextView = findViewById(R.id.num_five)
        val num_six: TextView = findViewById(R.id.num_six)
        val num_seven: TextView = findViewById(R.id.num_seven)
        val num_eight: TextView = findViewById(R.id.num_eight)
        val num_nine: TextView = findViewById(R.id.num_nine)
        val num_zero: TextView = findViewById(R.id.num_zero)
*/
        //Операции
        binding.bAC.setOnClickListener {
            operation.text = ""
            result.text = ""
        }
        binding.bDel.setOnClickListener {
            val str = operation.text.toString()
            if (str != "")
                operation.text = str.substring(0, str.length-1)
        }
        binding.bPercent.setOnClickListener { operation.append("%") }
        binding.bSlash.setOnClickListener { operation.append("/") }
        binding.bMultiply.setOnClickListener { operation.append("*") }
        binding.bMinus.setOnClickListener { operation.append("-") }
        binding.bPlus.setOnClickListener { operation.append("+") }
        binding.bComma.setOnClickListener { operation.append(",") }
        binding.bEqual.setOnClickListener {
            val optext = operation.text.toString()
            if (optext != ""){
                try{
                    val expr = ExpressionBuilder(operation.text.toString()).build()
                    val res = expr.evaluate()
                    val longres = res.toLong()
                    if (longres.toDouble() == res){
                        result.text = longres.toString()
                    }else {
                        result.text = res.toString()
                    }
                } catch (e: Exception){
                    result.text = "Error"
                }
            }
        }
        //Цифры
        binding.numZero.setOnClickListener { operation.append("0") }
        binding.numOne.setOnClickListener { operation.append("1") }
        binding.numTwo.setOnClickListener { operation.append("2") }
        binding.numThree.setOnClickListener { operation.append("3") }
        binding.numFour.setOnClickListener { operation.append("4") }
        binding.numFive.setOnClickListener { operation.append("5") }
        binding.numSix.setOnClickListener { operation.append("6") }
        binding.numSeven.setOnClickListener { operation.append("7") }
        binding.numEight.setOnClickListener { operation.append("8") }
        binding.numNine.setOnClickListener { operation.append("9") }


    }
}