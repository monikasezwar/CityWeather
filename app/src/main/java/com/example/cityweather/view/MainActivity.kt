package com.example.cityweather.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.cityweather.R

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById<Button>(R.id.look_up)
        val editText: EditText = findViewById<EditText>(R.id.city_name)
        button.setOnClickListener {
            val intent = Intent(this, CityActivity::class.java)
            intent.putExtra("city_name",editText.text.toString().trim())
            startActivity(intent)
        }
    }
}