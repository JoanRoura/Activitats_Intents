package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.inflate
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botoCanviarActivity = findViewById<Button>(R.id.botoCanviarActivity);
        val textPassarActivity = findViewById<TextView>(R.id.textPassarActivity);

        val intent1 = Intent(this, activity_2::class.java);

        botoCanviarActivity.setOnClickListener {
            intent1.putExtra("Username", textPassarActivity.text.toString());
            startActivity(intent1);
        };

        val botoAfegirCategoria = findViewById<Button>(R.id.botoAnarCategoria);

        val intent2 = Intent(this, activity_3::class.java);

        var resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            val data: Intent? = result.data
            if (result.resultCode == RESULT_OK) {
                val categoria = data?.getStringExtra("Category");

                Toast.makeText(this, "La categoria $categoria s'ha creat.", Toast.LENGTH_LONG).show();
            } else if (result.resultCode == RESULT_CANCELED) {
                Toast.makeText(this, "No s'ha introduit ningun text en el camp categoria.", Toast.LENGTH_LONG).show();
            }
        }

        botoAfegirCategoria.setOnClickListener {
            resultLauncher.launch(intent2)
        }


    }
}