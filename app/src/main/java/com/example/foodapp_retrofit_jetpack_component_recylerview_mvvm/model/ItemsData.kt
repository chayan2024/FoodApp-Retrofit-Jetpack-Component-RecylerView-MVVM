package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemsData(
    val name: String,
    val description: String,
    val category: String // Category of the food item
) : Parcelable

