package com.example.hospitalinfosystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_blood.*

class ActivityBlood : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood)
        negatives.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId==R.id.radioButton0neg){
                textViewReceive.text="0 Rh-"
                textViewGive.text="All Blood Types"
            }
            if(checkedId==R.id.radioButtonAneg){
                textViewReceive.text="A Rh- ,O Rh-"
                textViewGive.text="A Rh-, A Rh+, AB Rh-, AB Rh+ "
            }
            if(checkedId==R.id.radioButtonBneg){
                textViewGive.text="B Rh-, B Rh+, AB Rh-, AB Rh+"
                textViewReceive.text="B Rh-, O Rh-"
            }
            if(checkedId==R.id.radioButtonABneg){
                textViewGive.text="AB Rh-, AB Rh+"
                textViewReceive.text="AB Rh-, A Rh-, B Rh-, O Rh-"
            }
        }
        positives.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId==R.id.radioButton0pos){
                textViewReceive.text="0 Rh-, O Rh+"
                textViewGive.text="0 Rh+, A Rh+, B Rh+, AB Rh+"
            }
            if(checkedId==R.id.radioButtonApos){
                textViewReceive.text="A Rh+ ,A Rh- ,O Rh-, 0 Rh+"
                textViewGive.text="A Rh+, AB Rh+ "
            }
            if(checkedId==R.id.radioButtonBpos){
                textViewGive.text="B Rh+, AB Rh+"
                textViewReceive.text="B Rh-, B Rh+, O Rh-, 0 Rh+"
            }
            if(checkedId==R.id.radioButtonABpos){
                textViewGive.text="AB Rh+"
                textViewReceive.text="All Blood Types"
            }
        }
    }
}