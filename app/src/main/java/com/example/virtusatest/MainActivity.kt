package com.example.virtusatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtusatest.adapter.RecyclerAdapter
import com.example.virtusatest.databinding.ActivityMainBinding
import com.example.virtusatest.model.ModelItem
import com.example.virtusatest.network.ApiService
import com.example.virtusatest.network.RetrofitHelper
import com.example.virtusatest.repository.Repository
import com.example.virtusatest.viewModel.MainViewModel
import com.example.virtusatest.viewModel.MainViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    private var myAdapter: RecyclerAdapter? = null
    private var arrayList: ArrayList<ModelItem> = ArrayList<ModelItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        val apiService = RetrofitHelper.getInstance().create(ApiService::class.java)
        val repository = Repository(apiService)
        mainViewModel =
            ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)

        myAdapter = RecyclerAdapter(this, arrayList!!)

        mainViewModel.catData.observe(this) {
            it.forEach { e ->
                arrayList.add(e)
            }
            binding.recyclerView.adapter!!.notifyDataSetChanged()
        }
        binding.recyclerView.adapter = myAdapter
        binding.recyclerView.addItemDecoration(
            DividerItemDecoration(
                this,
                LinearLayoutManager.VERTICAL
            )
        )

    }
}