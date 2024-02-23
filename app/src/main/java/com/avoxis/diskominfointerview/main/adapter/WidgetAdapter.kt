package com.avoxis.diskominfointerview.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avoxis.diskominfointerview.databinding.ItemWidgetBinding
import com.avoxis.diskominfointerview.main.model.WidgetModel

class WidgetAdapter(): RecyclerView.Adapter<WidgetAdapter.ViewHolder>() {
    var list: MutableList<WidgetModel> = arrayListOf()

    inner class ViewHolder(val binding: ItemWidgetBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemWidgetBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list.get(position)

        holder.binding.tvWidgetName.text = item.title
        holder.binding.tvWidgetMessage.text = item.message
    }

    fun addAllWidget(newList: List<WidgetModel>?){
        if (!newList.isNullOrEmpty()) {
            list.addAll(newList)
        }
    }

    fun addWidget(data: WidgetModel){
        list.add(data)
    }
}