package com.example.spdemo

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var nameText:EditText
    private lateinit var ageText:EditText
    private lateinit var sf:SharedPreferences
    private lateinit var editor:SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameText = findViewById(R.id.etName)
        ageText = findViewById(R.id.etAge)
        sf = getSharedPreferences("MY_SF", MODE_PRIVATE)
        editor = sf.edit()
    }

    override fun onPause() {
        super.onPause()
        val name = nameText.text.toString()
        val age = ageText.text.toString().toInt()
        editor.apply {
            putString("SF_NAME", name)
            putInt("SF_AGE", age)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        val name = sf.getString("SF_NAME", null)
        val age = sf.getInt("SF_AGE",0)
        nameText.setText(name)
        if (age !=0){
            ageText.setText(age.toString())

        }
    }
}