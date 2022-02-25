package com.example.hospitalinfosystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmi.*
import kotlinx.android.synthetic.main.activity_meta.*

class ActivityBmi : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmi)
        var gender="female"
        radioGrup.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId==R.id.radioButtonF)
                gender="female"
            if(checkedId==R.id.radioButtonM)
                gender="male"
        }
        var op=0.0
        buttonCalcBmi.setOnClickListener {
            var weight=0
            if (editTextW.text.toString()!=""){
                weight=Integer.parseInt(editTextW.text.toString())
            }
            var height=0.0
            if(editTextH.text.toString()!=""){
                height=Integer.parseInt(editTextH.text.toString()).toDouble()
                height/=100
            }
            op=weight/(height*height)
            textViewResult.text="$op"
        }
    }
}