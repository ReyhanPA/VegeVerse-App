package com.example.submisiandroidpemula

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        supportActionBar?.title = "Tentang Pengembang"

        val imgPhoto: ImageView = findViewById(R.id.img_about_photo)
        val tvName: TextView = findViewById(R.id.tv_about_name)
        val tvEmail: TextView = findViewById(R.id.tv_about_email)

        imgPhoto.setImageResource(R.drawable.foto_diri)
        tvName.text = getString(R.string.about_name)
        tvEmail.text = getString(R.string.about_email)
    }
}