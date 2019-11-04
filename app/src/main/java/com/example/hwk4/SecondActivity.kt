package com.example.hwk4

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.name_edittext
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        camera_button.setOnClickListener { _ ->
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 777)
        }

        val userIn: User = intent?.getParcelableExtra("my_user_key") as User

        userIn.let { user ->
           name_textView.text=user.name
           phone_textView.text=user.phone
           email_textView.text=user.email

        }

         fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode == 777 && resultCode == Activity.RESULT_OK) {
                val bitmap: Bitmap = (data?.extras?.get("data") as Bitmap)
                my_imageview.setImageBitmap(bitmap)
            }
        }


    }


}


