package com.berke.mytvseriesapp.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.berke.mytvseriesapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

    }
}