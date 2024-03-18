package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel : ViewModel() {
    private val _selectedItemPosition = MutableLiveData<Int>()
    val selectedItemPosition: LiveData<Int> = _selectedItemPosition

    private val _verticalListData = MutableLiveData<List<String>>()
    val verticalListData: LiveData<List<String>> = _verticalListData

    private val horizontalData = listOf("Category 1", "Category 2", "Category 3", "Category 4")

    init {
        // Initializing vertical list data for the first category
        _verticalListData.value = listOf("Vertical Item A1", "Vertical Item A2", "Vertical Item A3")
    }

    fun setSelectedItemPosition(position: Int) {
        _selectedItemPosition.value = position
        _verticalListData.value = getVerticalDataForPosition(position)
    }

    fun getVerticalDataForPosition(position: Int): List<String> {
        // Mock data for demonstration, you should replace this with your own data source
        return when (position) {
            0 -> listOf("Vertical Item A1", "Vertical Item A2", "Vertical Item A3")
            1 -> listOf("Vertical Item B1", "Vertical Item B2", "Vertical Item B3")
            2 -> listOf("Vertical Item C1", "Vertical Item C2", "Vertical Item C3")
            3 -> listOf("Vertical Item D1", "Vertical Item D2", "Vertical Item D3")
            else -> emptyList()
        }
    }
}
