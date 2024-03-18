package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.R
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.model.ItemsData

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val itemsDataList = intent.getParcelableArrayListExtra<ItemsData>("itemList")
        val category = intent.getIntExtra("category", 0)
        Log.v("@@",""+category)

        for (i in 0..itemsDataList?.size!!-1){
            Log.v("@@",""+itemsDataList?.get(i)?.name)
        }
    }
}