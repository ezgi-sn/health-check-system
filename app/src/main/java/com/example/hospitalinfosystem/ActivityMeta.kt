package com.example.hospitalinfosystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_meta.*
import kotlinx.android.synthetic.main.activity_water.*
import kotlinx.android.synthetic.main.activity_water.spinner

class ActivityMeta : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meta)
        var age=13
        var ages= arrayOfNulls<Int>(70)
        for(i in ages.indices){
            ages[i]=(i+13)
        }
        val agesAdapter= ArrayAdapter(this,android.R.layout.simple_spinner_item,ages)
        spinnerAge.adapter=agesAdapter
        spinnerAge.onItemSelectedListener=object :

                AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                age= ages[position]!!
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                age=13
            }
        }
        var genders= arrayListOf<String>("Female","Male")
        var gender="Female"
        val gendersAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,genders)
        spinnerGender.adapter=gendersAdapter
        spinnerGender.onItemSelectedListener=object :


                AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                gender=genders[position]!!
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                gender="Female"
            }

        }
        var result=0.0
        buttonCakcM.setOnClickListener {
            var weight=0
            if (editTextWeight.text.toString()!=""){
                weight=Integer.parseInt(editTextWeight.text.toString())
            }
            var height=0
            if(editTextHeight.text.toString()!=""){
                height=Integer.parseInt(editTextHeight.text.toString())
            }

            if(gender=="Male"){
                result=88.362+(13.397*weight)+(4.799*height)-(5.677*age)
                textViewOut.text="$result"
            }
            else{
                result=447.593+(9.247*weight)+(3.098*height)-(4.430*age)
                textViewOut.text="$result"
            }
        }
    }

}