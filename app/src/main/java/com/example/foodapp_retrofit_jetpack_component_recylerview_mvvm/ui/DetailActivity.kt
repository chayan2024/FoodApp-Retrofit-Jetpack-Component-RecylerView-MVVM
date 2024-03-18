package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.R
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.adapter.HorizontalAdapter
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.adapter.VerticalAdapter
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.model.ItemsData
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.viewmodel.MyViewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var verticalAdapter: VerticalAdapter
    private lateinit var verticalRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val itemsDataList = intent.getParcelableArrayListExtra<ItemsData>("itemList")
        val category = intent.getIntExtra("category", 0)
        Log.v("@@", "" + category)

        for (i in 0..itemsDataList?.size!! - 1) {
            Log.v("@@", "" + itemsDataList?.get(i)?.name)
        }

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        horizontalAdapter = HorizontalAdapter { position ->
            viewModel.setSelectedItemPosition(position)
        }
        verticalAdapter = VerticalAdapter(emptyList())

        val horizontalRecyclerView: RecyclerView = findViewById(R.id.horizontalRecyclerView)
        verticalRecyclerView = findViewById(R.id.verticalRecyclerView)

        horizontalRecyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        horizontalRecyclerView.adapter = horizontalAdapter

        verticalRecyclerView.layoutManager = LinearLayoutManager(this)
        verticalRecyclerView.adapter = verticalAdapter

            viewModel.selectedItemPosition.observe(this) { position ->
                position?.let {
                        val dataForSelectedPosition = viewModel.getVerticalDataForPosition(position)
                        if (dataForSelectedPosition.isNotEmpty()) {
                            verticalAdapter = VerticalAdapter(dataForSelectedPosition)
                            verticalRecyclerView.adapter = verticalAdapter
                            verticalRecyclerView.visibility = View.VISIBLE
                        } else {
                            verticalRecyclerView.visibility = View.GONE
                        }
                }
            }

        val horizontalData = listOf("Category 1", "Category 2", "Category 3", "Category 4")
        horizontalAdapter.setItems(horizontalData)

    }

}