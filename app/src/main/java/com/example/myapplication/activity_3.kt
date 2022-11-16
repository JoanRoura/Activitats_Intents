package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class activity_3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)

        val botoAfegirCategoria = findViewById<Button>(R.id.botoAfegirCategoria);
        val textCategoria = findViewById<TextView>(R.id.textCategoria);

        val intent = intent

        botoAfegirCategoria.setOnClickListener {
            if (textCategoria != null) {
                intent.putExtra("Category", textCategoria.text.toString());
                setResult(Activity.RESULT_OK, intent);
                finish()
            } else {
                setResult(Activity.RESULT_CANCELED, intent)
                finish()
            }
        }
    }
}