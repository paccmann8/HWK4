package com.example.hwk4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_user_button.setOnClickListener{_ ->
            val name = name_edittext.text.toString()
            val phone = phonenumber_edittext.text.toString()
            val email = email_edittext.text.toString()

            val myUser = User(name,phone,email)

            val userIntent = Intent(this, SecondActivity::class.java)
            userIntent.putExtra("MY_USER_KEY", myUser)

            startActivity(userIntent)






        }


    }

}
