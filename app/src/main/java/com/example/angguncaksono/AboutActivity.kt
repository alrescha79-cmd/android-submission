package com.example.angguncaksono

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class AboutActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.about_layout)
        supportActionBar?.apply {
            title = getString(R.string.about)
        }
    }
}