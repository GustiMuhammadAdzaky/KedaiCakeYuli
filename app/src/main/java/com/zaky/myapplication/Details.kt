package com.zaky.myapplication

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.item_row_kue.*

class Details : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_age"
        const val EXTRA_DETAIL = "extra_detail"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val tvDataReceived: TextView = findViewById(R.id.tv_item_name)
        val tvDataReceived2: TextView = findViewById(R.id.tv_item_detail)
        val tvDataReceived3 = findViewById<ImageView>(R.id.img_item_photo)


        val name = intent.getStringExtra(EXTRA_NAME)
        val detail = intent.getStringExtra(EXTRA_DETAIL)
//        val photo = intent.getParcelableExtra<>(MainActivity.INTENT_PARCALABLE)

        val text = name

        tvDataReceived.text = text
        tvDataReceived2.text = detail

    }
}
