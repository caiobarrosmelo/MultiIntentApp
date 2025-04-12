package com.example.multiintentapp

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var edtPhoneNumber: EditText
    private lateinit var btnOpenBrowser: Button
    private lateinit var btnMakeCall: Button
    private lateinit var btnSendSMS: Button
    private lateinit var btnOpenMap: Button
    private lateinit var btnShareText: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtPhoneNumber = findViewById(R.id.edtPhoneNumber)
        btnOpenBrowser = findViewById(R.id.btnOpenBrowser)
        btnMakeCall = findViewById(R.id.btnMakeCall)
        btnSendSMS = findViewById(R.id.btnSendSMS)
        btnOpenMap = findViewById(R.id.btnOpenMap)
        btnShareText = findViewById(R.id.btnShareText)

        btnOpenBrowser.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com"))
            startActivity(browserIntent)
        }

        btnMakeCall.setOnClickListener {
            val phone = edtPhoneNumber.text.toString()
            val callIntent = Intent(Intent.ACTION_DIAL)
            callIntent.data = Uri.parse("tel:$phone")
            startActivity(callIntent)
        }

        btnSendSMS.setOnClickListener {
            val smsUri = Uri.parse("sms:81999999999") // Substitua por número real
            val intent = Intent(Intent.ACTION_SENDTO, smsUri)
            intent.putExtra("sms_body", "Olá, essa é uma mensagem de teste!")
            startActivity(intent)
        }

        btnOpenMap.setOnClickListener {
            val mapIntent = Intent(Intent.ACTION_VIEW)
            mapIntent.data = Uri.parse("geo:-8.0476,-34.8770")
            startActivity(mapIntent)
        }

        btnShareText.setOnClickListener {
            val shareIntent = Intent(Intent.ACTION_SEND)
            shareIntent.type = "text/plain"
            shareIntent.putExtra(Intent.EXTRA_TEXT, "Olá, estou aprendendo Android!")
            startActivity(Intent.createChooser(shareIntent, "Compartilhar via"))
        }
    }
}
