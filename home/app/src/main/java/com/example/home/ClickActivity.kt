package com.example.home

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_click.*

class ClickActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click)


        val actionBar : ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        actionBar!!.setDisplayShowHomeEnabled(true)
        //also set in mainfest file, that which activity to move our anthor

        var intent = intent
        var aTitle = intent.getStringExtra("iTitle")
        val aDescription = intent.getStringExtra("iDescription")
        val aImageView = intent.getIntExtra("iImageView",0)

        //set title in anther activity
        actionBar.title = aTitle
        a_title.text = aTitle
        a_description.text = aDescription
        imageView.setImageResource(aImageView)


        //so this is done, let's check
        }
    }
