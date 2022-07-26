package com.example.quickjob.activity

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.quickjob.MainActivity
import com.example.quickjob.R

class ProfileActivity : AppCompatActivity() {

    private lateinit var userVoornaam: TextView
    private lateinit var userAchternaam: TextView
    private lateinit var userEmail: TextView
    private lateinit var userGsmnummer: TextView

    private lateinit var voornaam : String
    private lateinit var achternaam : String
    private lateinit var email : String
    private lateinit var wachtwoord : String
    private lateinit var gsmnummer : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        initialiseViews()
        setUserData()

    }

    private fun initialiseViews() {
        userVoornaam = findViewById(R.id.voornaam)
        userAchternaam = findViewById(R.id.achternaam)
        userEmail = findViewById(R.id.email)
        userGsmnummer = findViewById(R.id.gsmnummer)
    }

    private fun setUserData() {
        voornaam = intent.getStringExtra("VOORNAAM").toString()
        achternaam = intent.getStringExtra("ACHTERNAAM").toString()
        email = intent.getStringExtra("EMAIL").toString()
        wachtwoord = intent.getStringExtra("WACHTWOORD").toString()
        gsmnummer = intent.getStringExtra("GSMNUMMER").toString()

        userVoornaam.text = voornaam
        userAchternaam.text = achternaam
        userEmail.text = email
        userGsmnummer.text = gsmnummer
    }

    fun hoofdmenu(view: View) {
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }
}