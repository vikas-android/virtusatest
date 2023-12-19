package com.example.virtusatest.viewModel

import android.R
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.virtusatest.model.ModelItem
import com.example.virtusatest.repository.NetworkResult
import com.example.virtusatest.repository.Repository
import com.squareup.picasso.Picasso
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository):ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            repository.getCatData(10)
        }
    }

    val catData:LiveData<NetworkResult<ArrayList<ModelItem>>>
    get() = repository.cat


}

