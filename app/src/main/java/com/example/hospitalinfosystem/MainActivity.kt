package com.example.hospitalinfosystem

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_in.*
import kotlinx.android.synthetic.main.activity_sign_up.*

class MainActivity : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val db=DatabaseHelper(this)


        textView.setOnClickListener{
            val newIntent=Intent(this@MainActivity,ActivitySignUp::class.java)
            startActivity(newIntent)

        }
        buttonSignIn.setOnClickListener{
            val username=textInputUsername.text.toString()
            val password=textInputPassword.text.toString()
            val searchUsername=listDao().searchUsername(db,username)
            val searchPassword=listDao().searchPassword(db,password)
            val data=intent.getSerializableExtra("data") as? list
            if((searchPassword==true && searchUsername==true)) {
                val buttonIntent = Intent(this@MainActivity, ActivitySignIn::class.java)
                val loggedInUser=username
                buttonIntent.putExtra("username",loggedInUser)
                startActivity(buttonIntent)
            }
            else if (data != null) {
                if((data.username==username && data.password==password)){
                    val buttonIntent = Intent(this@MainActivity, ActivitySignIn::class.java)
                    val loggedInUser=username
                    buttonIntent.putExtra("username",loggedInUser)
                    startActivity(buttonIntent)
                }
                else{
                    Toast.makeText(applicationContext,"User Couldn't Find", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}
