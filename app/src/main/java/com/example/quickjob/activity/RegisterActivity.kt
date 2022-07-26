package com.example.quickjob.activity

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.quickjob.R
import org.w3c.dom.Text

class RegisterActivity : AppCompatActivity() {

    private lateinit var userVoornaam: EditText
    private lateinit var userAchternaam: EditText
    private lateinit var userEmail: EditText
    private lateinit var userPassword: EditText
    private lateinit var userGsmnummer: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        initialiseViews()
    }

    private fun initialiseViews() {
        userVoornaam = findViewById(R.id.voornaam)
        userAchternaam = findViewById(R.id.achternaam)
        userEmail = findViewById(R.id.email)
        userPassword = findViewById(R.id.wachtwoord)
        userGsmnummer = findViewById(R.id.gsmnummer)
    }

    fun register(view: View) {
        var intent = Intent(this,ProfileActivity::class.java).apply {
            putExtra("VOORNAAM",userVoornaam.text.toString())
            putExtra("ACHTERNAAM",userAchternaam.text.toString())
            putExtra("EMAIL",userEmail.text.toString())
            putExtra("WACHTWOORD",userPassword.text.toString())
            putExtra("GSMNUMMER",userGsmnummer.text.toString())
        }
        startActivity(intent)
    }
}