package com.example.hospitalinfosystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_water.*

class ActivityWater : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water)
        var age=13
        var ages= arrayOfNulls<Int>(70)
        for(i in ages.indices){
            ages[i]=(i+13)
        }
        val agesAdapter=ArrayAdapter(this,android.R.layout.simple_spinner_item,ages)
        spinner.adapter=agesAdapter
        spinner.onItemSelectedListener=object :

                AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                age= ages[position]!!
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                age=13
            }

        }
        buttonCalc.setOnClickListener {
            var weight=0
            if(editTextNumber.text.toString()!=""){
                weight=Integer.parseInt(editTextNumber.text.toString())
            }

            Log.e("tag1",weight.toString())
            Log.e("tag2",age.toString())
            var sonuc=0
            if(age<30){
                sonuc=weight*40
            }
            else if(age<55){
                sonuc=weight*35
            }
            else{
                sonuc=weight*30
            }
            textViewOutput.text=" Your Need Is $sonuc ML"
        }
    }
}