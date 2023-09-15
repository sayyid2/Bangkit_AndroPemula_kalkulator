package com.example.atry

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.atry.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var edwidth: EditText
    private lateinit var edheight: EditText
    private lateinit var edlenght: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    companion object {
        private const val STATE_RESUlT = "state_result"
    }

    private lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        setContentView(R.layout.activity_main)
//        edwidth = findViewById(R.id.edt_width)
//        edheight=findViewById(R.id.edt_height)
//        edlenght=findViewById(R.id.edt_lenght)
//        btnCalculate=findViewById(R.id.btn_calculate)
//        tvResult=findViewById(R.id.tv_result)
        binding.btnCalculate.setOnClickListener(this)
        if (savedInstanceState!=null){
            val result= savedInstanceState.getString(STATE_RESUlT)
            binding.tvResult.text=result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESUlT,tvResult.text.toString())
    }
    override fun onClick(view: View?) {
        if (view?.id==R.id.btn_calculate){
            val inputLenght = edlenght.text.toString().trim()
            val inputHeight = edheight.text.toString().trim()
            val inputwidth = edwidth.text.toString().trim()
            var isEmptyField = false
            if(inputHeight.isEmpty()){
                isEmptyField=true
                edheight.error="Tidak boleh kosong ya ges"
            }
            if(inputLenght.isEmpty()){
                isEmptyField=true
                edlenght.error="Tidak boleh kosong ya ges"
            }
            if(inputwidth.isEmpty()){
                isEmptyField=true
                edwidth.error="Tidak boleh kosong ya ges"
            }



            if ( !isEmptyField) {
                val result = inputLenght.toInt() * inputHeight.toInt() * inputwidth.toInt()
                tvResult.text = result.toString()
            }
        }
    }
}
