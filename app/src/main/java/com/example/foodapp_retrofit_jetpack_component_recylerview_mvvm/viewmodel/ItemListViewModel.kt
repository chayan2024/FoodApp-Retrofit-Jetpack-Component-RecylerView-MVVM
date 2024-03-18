package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.model.ItemsData

public class ItemListViewModel() : ViewModel() {

    private val _itemsLiveData = MutableLiveData<Map<String, List<ItemsData>>>()
    val itemsLiveData: LiveData<Map<String, List<ItemsData>>> = _itemsLiveData

    init {
        loadItems()
    }

    fun loadItems() {
        // Fetch your data here and update the LiveData
        val items = mapOf(
            "Burger" to listOf(
                ItemsData("Burger", "Delicious beef burger", "Main Course"),
                ItemsData("Pasta", "Classic Italian pasta", "Main Course")
            ),
            "Ice Cream" to listOf(
                ItemsData("Cheesecake", "Creamy cheesecake", "Desserts"),
                ItemsData("Ice Cream", "Vanilla ice cream", "Desserts")
            ),
            "Salad" to listOf(
                ItemsData("Coffee", "Freshly brewed coffee", "Beverages"),
                ItemsData("Tea", "Assorted tea flavors", "Beverages")
            ),
            "Fruits" to listOf(
                ItemsData("Coffee", "Freshly brewed coffee", "Beverages"),
                ItemsData("Tea", "Assorted tea flavors", "Beverages")
            )
        )
        _itemsLiveData.value = items
    }

}
