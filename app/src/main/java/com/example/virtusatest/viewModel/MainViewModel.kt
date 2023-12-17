package com.example.virtusatest.viewModel

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virtusatest.model.ModelItem
import com.example.virtusatest.repository.Repository
import com.squareup.picasso.Picasso
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel(private val repository: Repository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getCatData(10)
        }
    }

    val catData:LiveData<ArrayList<ModelItem>>
    get() = repository.cat


}

