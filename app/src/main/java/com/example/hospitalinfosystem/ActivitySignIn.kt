package com.example.hospitalinfosystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import android.content.Intent
class ActivitySignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val loggedUser=intent.getStringExtra("username")
        textViewHeader.text="Calculate $loggedUser's..."
        buttonBki.setOnClickListener {
            val newIntent=Intent(this,ActivityBmi::class.java)
            startActivity(newIntent)
        }
        buttonBlood.setOnClickListener {
            val newIntent=Intent(this,ActivityBlood::class.java)
            startActivity(newIntent)
        }
        buttonMeta.setOnClickListener {
            val newIntent=Intent(this,ActivityMeta::class.java)
            startActivity(newIntent)
        }
        buttonWater.setOnClickListener {
            val newIntent=Intent(this,ActivityWater::class.java)
            startActivity(newIntent)
        }

    }
}