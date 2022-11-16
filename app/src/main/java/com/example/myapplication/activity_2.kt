package com.example.myapplication

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class activity_2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        val intent = intent
        val username = intent.getStringExtra("Username");

        Toast.makeText(this, "El usuari es $username ha iniciat sessio.", Toast.LENGTH_LONG).show();

        val botoAnarCorreu = findViewById<Button>(R.id.botoCorreuElectronic);
        val botoAnarTelefon = findViewById<Button>(R.id.botoTelefon);
        val botoAnarPaginaWeb = findViewById<Button>(R.id.botoPaginaWeb);
        val botoAnarMapa = findViewById<Button>(R.id.botoMapa);

        botoAnarCorreu.setOnClickListener {
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "message/rfc822"
            val mailer = Intent.createChooser(intent, null)
            startActivity(mailer)
        }

        botoAnarMapa.setOnClickListener {
            val mapIntent: Intent = Uri.parse(
                "geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"
            ).let { location ->
                Intent(Intent.ACTION_VIEW, location)
            }
            startActivity(mapIntent);
        }

        botoAnarPaginaWeb.setOnClickListener {
            val webIntent: Intent = Uri.parse("https://www.android.com").let { webpage ->
                Intent(Intent.ACTION_VIEW, webpage)
            }
            startActivity(webIntent);
        }

        botoAnarTelefon.setOnClickListener {
            val callIntent: Intent = Uri.parse("tel:5551234").let { number ->
                Intent(Intent.ACTION_DIAL, number)
            }
            startActivity(callIntent);
        }

    }
}