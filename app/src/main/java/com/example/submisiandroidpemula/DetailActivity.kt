package com.example.submisiandroidpemula

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        supportActionBar?.title = "Detail Sayuran"

        val imgPhoto: ImageView = findViewById(R.id.img_detail_photo)
        val tvName: TextView = findViewById(R.id.tv_detail_name)
        val tvDesc: TextView = findViewById(R.id.tv_desc)
        val tvDescription: TextView = findViewById(R.id.tv_detail_description)
        val btnShare: Button = findViewById(R.id.action_share)

        val vegetable = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra<Vegetables>("key_vegetable", Vegetables::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra<Vegetables>("key_vegetable")
        }
        if (vegetable != null) {
            imgPhoto.setImageResource(vegetable.image)
            tvName.text = vegetable.name
            tvDesc.text = getString(R.string.description)
            tvDescription.text = vegetable.description
            btnShare.setOnClickListener {
                val shareIntent = Intent(Intent.ACTION_SEND)
                shareIntent.putExtra(Intent.EXTRA_TEXT, vegetable.name)
                shareIntent.type = "text/plain"
                startActivity(shareIntent)
            }
        }
    }
}