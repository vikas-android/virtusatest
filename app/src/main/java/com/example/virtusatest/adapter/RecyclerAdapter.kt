package com.example.virtusatest.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.recyclerview.widget.RecyclerView
import com.example.virtusatest.R
import com.example.virtusatest.model.ModelItem
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import javax.inject.Inject


class RecyclerAdapter @Inject constructor():
    RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var arrList:List<ModelItem> = emptyList()
    set(value) {
        field=value
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.layout_item,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return arrList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        Picasso.get()
            .load(arrList[position].url)
            .fit()
            .centerCrop()
            .into(holder.imageView, object : Callback{
                override fun onSuccess() {
                    holder.progressBar.visibility = View.GONE
                }
                override fun onError(e: java.lang.Exception?) {

                }

            })
    }

    inner  class MyViewHolder(view: View): RecyclerView.ViewHolder(view) {
        var imageView: ImageView
        var progressBar: ProgressBar

        init {
            imageView = view.findViewById(R.id.imageView)
            progressBar = view.findViewById(R.id.progressBar)

        }
    }
}