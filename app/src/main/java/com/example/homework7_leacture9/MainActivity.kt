package com.example.homework7_leacture9

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import com.example.homework7_leacture9.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    private lateinit var linearLayout: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        linearLayout = binding.linLayout

        binding.addBtn.setOnClickListener{
            val name = binding.nameEdtext.text.toString()
            addNewEditText(binding.chkBx.isChecked,name)
        }


    }

    private fun addNewEditText(isNumber:Boolean,name:String) {
        val editText = EditText(this)
        editText.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        if(isNumber){
            editText.hint = "age of $name in numbers"
            editText.inputType = InputType.TYPE_CLASS_NUMBER
        }else{
            editText.hint = "age of $name in words"
            editText.inputType = InputType.TYPE_CLASS_TEXT
        }

        linearLayout.addView(editText)
    }
}