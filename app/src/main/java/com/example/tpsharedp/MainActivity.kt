package com.example.tpsharedp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    lateinit var Name:EditText
    lateinit var Password:EditText
    lateinit var login:Button
    lateinit var remember:CheckBox

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val SharedPreference:SharedPreference= SharedPreference(this)

        Name=findViewById(R.id.Name);
        Password=findViewById(R.id.Password);
        login=findViewById(R.id.login);
        remember=findViewById(R.id.remember);

        if(SharedPreference.getValueBoolien("remember",true)) {
        Name.setText(SharedPreference.getValueString("name"))
        Password.setText(SharedPreference.getValueString("password"))
        remember.isChecked=true
        }
else {
            remember.isChecked=false
        }

                login.setOnClickListener{
                    val name = Name.text.toString()
                    val password = Password.text.toString()
                    SharedPreference.save("name",name)
                    SharedPreference.save("password",password)
                    Toast.makeText(this@MainActivity,"Remebered Data",Toast.LENGTH_LONG).show()
        }
    }
}