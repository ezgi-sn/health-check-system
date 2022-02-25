package com.example.hospitalinfosystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class ActivitySignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        val db=DatabaseHelper(this)

        signUpButton.setOnClickListener {
            val newUsername=sUsernameEditText.text.toString()
            val newPassword=sPasswordEditText.text.toString()
            val confPassword=sConfPasswordEditText.text.toString()

            if(newPassword!=confPassword){
                Toast.makeText(applicationContext,"Passwords Do Not Match ", Toast.LENGTH_LONG).show()

            }
            else if(listDao().searchUsername(db,newUsername)){
                Toast.makeText(applicationContext,"Username Has Already Taken ", Toast.LENGTH_LONG).show()
                //username has already taken
            }
            else if(newUsername.isEmpty() || newPassword.isEmpty() || confPassword.isEmpty()){
                Toast.makeText(applicationContext,"One Of The Required Field Is Empty", Toast.LENGTH_LONG).show()
            }
            else{
                listDao().addToList(db,newUsername,newPassword)
                val backIntent= Intent(applicationContext,MainActivity::class.java)
                val dataToWrite=list(newUsername,newPassword)
                backIntent.putExtra("data",dataToWrite)
                startActivity(backIntent)
            }
        }
    }

}