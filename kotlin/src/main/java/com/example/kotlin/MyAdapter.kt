package com.example.kotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter


class MyAdapter(private val context:Context, private val data:List<String>): Adapter<MyAdapter.MyHolder>() {

    private var listener: ((Int, String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false))
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        holder.tvJojo.text = data[position]
        holder.itemView.setOnClickListener{
            listener?.invoke(position,data[position])
        }
    }


    inner class MyHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
        var tvJojo:TextView = itemView.findViewById(R.id.tv_jojo)
    }

    fun setOnItemClickListener(listener:(position:Int, name:String) -> Unit){
        this.listener = listener
    }



}

