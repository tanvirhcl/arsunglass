package com.hcl.ar.ui

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hcl.ar.util.MakeupListner
import com.hcl.ar.databinding.AdapterMakeupSectionBinding
import com.hcl.ar.model.MakeupDataModel

class MakeupSectionAdapter(private var context: Context?,
                           private var map : MutableMap<String,MutableList<MakeupDataModel>?>,
                           private var listner: MakeupListner?) : RecyclerView.Adapter<MakeupSectionAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder = ViewHolder(AdapterMakeupSectionBinding.inflate(LayoutInflater.from(context),p0,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }


    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount(): Int  = map.keys.size

    inner class ViewHolder( var binding: AdapterMakeupSectionBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind() {
            init()
            initCtrl()
        }

        private fun init() {
            binding.tvTitle.text = map.keys.toTypedArray()[absoluteAdapterPosition]
        }
        private fun initCtrl() {
            binding.root.setOnClickListener {
                listner?.onSectionClick(map.keys.toTypedArray()[absoluteAdapterPosition])
            }
        }
    }

}