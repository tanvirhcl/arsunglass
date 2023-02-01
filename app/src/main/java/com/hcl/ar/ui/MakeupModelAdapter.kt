package com.hcl.ar.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hcl.ar.util.MakeupListner
import com.hcl.ar.databinding.AdapterModelMakeupBinding
import com.hcl.ar.model.MakeupDataModel

class MakeupModelAdapter(private var context: Context?,
                         private var list : MutableList<MakeupDataModel>?,
                         private var listner: MakeupListner?) : RecyclerView.Adapter<MakeupModelAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder = ViewHolder(AdapterModelMakeupBinding.inflate(LayoutInflater.from(context),p0,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.iv.strokeWidth = if(list?.get(position)?.selection == true) 2f else 0f
        holder.binding.iv.setBackgroundColor(Color.parseColor(""+list?.get(position)?.colorHex))
    }


    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount(): Int  = list?.size?:0

    inner class ViewHolder( var binding: AdapterModelMakeupBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
           binding.root.setOnClickListener {
               list?.forEach { if(it.selection) it.selection = false else return@forEach }
               list?.get(absoluteAdapterPosition)?.selection = true
               listner?.onSectionItemClick(absoluteAdapterPosition,list?.get(absoluteAdapterPosition))
               notifyDataSetChanged()
           }
        }
    }
}