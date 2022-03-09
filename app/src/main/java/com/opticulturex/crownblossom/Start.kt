package com.opticulturex.crownblossom

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Start : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
    }

    fun go(view: View) {
        Intent(applicationContext, GameplayCB::class.java).also { startActivity(it) }
        finish()
    }
}