package com.example.submisiandroidpemula

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Vegetables(
    val name: String,
    val description: String,
    val image: Int
) : Parcelable
