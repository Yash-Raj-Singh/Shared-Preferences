package com.example.sharedprefences

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor  = sharedPref.edit()

        btnsave.setOnClickListener{
            val name = etName.text.toString()
            val age  = etAge.text.toString().toInt()

            val isAdult = cbCheck.isChecked

            editor.apply{
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }

        }

        btnload.setOnClickListener{
            val name = sharedPref.getString("name", null)
            val age = sharedPref.getInt("age", 0)
            val isAdult = sharedPref.getBoolean("isAdult",false)

            etName.setText(name)
            etAge.setText(age.toString())
            cbCheck.isChecked = isAdult
        }
    }
}