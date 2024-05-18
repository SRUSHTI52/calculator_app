package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

lateinit var enter: TextView
lateinit var ans: TextView
lateinit var add: Button
lateinit var sub: Button
lateinit var mul: Button
lateinit var div: Button
lateinit var equal: Button
lateinit var seven: Button
lateinit var eight: Button
lateinit var nine: Button
lateinit var four: Button
lateinit var five: Button
lateinit var six: Button
lateinit var one: Button
lateinit var two: Button
lateinit var three: Button
lateinit var clear: Button
lateinit var zero: Button
lateinit var dot: Button
lateinit var backspace: Button

var operand1 = ""
var operand2 = ""
var operator = ""
var res=0.0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        enter = findViewById(R.id.enter)
        ans = findViewById(R.id.ans)
        add = findViewById(R.id.add)
        sub = findViewById(R.id.sub)
        mul = findViewById(R.id.mul)
        div = findViewById(R.id.div)
        equal = findViewById(R.id.equal)
        seven = findViewById(R.id.seven)
        eight = findViewById(R.id.eight)
        nine = findViewById(R.id.nine)
        four = findViewById(R.id.four)
        five = findViewById(R.id.five)
        six = findViewById(R.id.six)
        one = findViewById(R.id.one)
        two = findViewById(R.id.two)
        three = findViewById(R.id.three)
        clear = findViewById(R.id.clear)
        zero = findViewById(R.id.zero)
        dot = findViewById(R.id.dot)
        backspace = findViewById(R.id.backspace)

        clear.setOnClickListener {
            enter.text = ""
            ans.text = "0"
        }
        fun numberClickListener(button: Button) {
            if (enter.text == "") {
                enter.text = button.text
            } else {
                enter.append(button.text)
            }
        }

        fun operatorClickListener1(op: String) {
            val data = enter.text.toString()
            if (op != "=") {
                if (data.isNotEmpty()) {
                    operand1 = data
                    operator = op
                    enter.append(op)
                }
            } else {
                if (operator.isNotEmpty()) {
                    operand2 = data.substring(operand1.length + 1)
                    when (operator) {
                        "+" -> res = operand1.toDouble() + operand2.toDouble()
                        "-" -> res = operand1.toDouble() - operand2.toDouble()
                        "*" -> res = operand1.toDouble() * operand2.toDouble()
                        "/" -> {
                            if (operand2.toDouble() != 0.0) {
                                res = operand1.toDouble() / operand2.toDouble()
                            } else {
                                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show()
                                return
                            }
                        }
                    }
                    ans.text = res.toString()
                    operand1 = res.toString()
                    operator = ""
                    operand2 = ""
                    enter.text = operand1
                }
            }
        }

        zero.setOnClickListener { numberClickListener(zero) }
        one.setOnClickListener { numberClickListener(one) }
        two.setOnClickListener { numberClickListener(two) }
        three.setOnClickListener { numberClickListener(three) }
        four.setOnClickListener { numberClickListener(four) }
        five.setOnClickListener { numberClickListener(five) }
        six.setOnClickListener { numberClickListener(six) }
        seven.setOnClickListener { numberClickListener(seven) }
        eight.setOnClickListener { numberClickListener(eight) }
        nine.setOnClickListener { numberClickListener(nine) }

        add.setOnClickListener{ operatorClickListener1("+") }
        sub.setOnClickListener{ operatorClickListener1("-") }
        mul.setOnClickListener{ operatorClickListener1("*") }
        div.setOnClickListener{ operatorClickListener1("/") }
        equal.setOnClickListener{ operatorClickListener1("=") }

        backspace.setOnClickListener{
           enter.text = enter.text.toString().substring(0,enter.length()-1)

        }

        dot.setOnClickListener {
            enter.text = enter.append(".").toString()
        }
    }
}

