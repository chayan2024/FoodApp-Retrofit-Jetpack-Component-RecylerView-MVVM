package com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.adapter.ItemListAdapter
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.databinding.ActivityMainBinding
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.model.ItemsData
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.ui.DetailActivity
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.utils.SeparatorItemDecoration
import com.example.foodapp_retrofit_jetpack_component_recylerview_mvvm.viewmodel.ItemListViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: ItemListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val adapter = ItemListAdapter({ itemList, category ->
            val intent = Intent(this, DetailActivity::class.java).apply {
                putParcelableArrayListExtra("itemList", ArrayList(itemList))
                // Optionally, you can also pass the category string if needed
                putExtra("category", category)
            }
            startActivity(intent)
        }, emptyMap())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        // Apply separator decoration
        binding.recyclerView.addItemDecoration(
            SeparatorItemDecoration(
                this,
                R.drawable.separator_drawable // replace with your separator drawable resource
            )
        )

        viewModel.itemsLiveData.observe(this) { items ->
            adapter.apply {
                adapter.setData(items)            }
        }
    }
}
