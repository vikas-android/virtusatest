package com.example.virtusatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.virtusatest.adapter.RecyclerAdapter
import com.example.virtusatest.databinding.ActivityMainBinding
import com.example.virtusatest.model.ModelItem
import com.example.virtusatest.repository.NetworkResult
import com.example.virtusatest.viewModel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var mainViewModel: MainViewModel
    lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var myAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


        mainViewModel =
            ViewModelProvider(this).get(MainViewModel::class.java)


        mainViewModel.catData.observe(this) {
            when (it) {
                is NetworkResult.Success -> {
                    it.data?.let { data ->
                        myAdapter.arrList = data
                    }
                }
                is NetworkResult.Error -> {
                    it.errorMessage?.let { error ->
                        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
                    }
                }
                is NetworkResult.Loading -> {}
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