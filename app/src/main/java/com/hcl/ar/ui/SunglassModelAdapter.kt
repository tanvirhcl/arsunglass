package com.hcl.ar.ui

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hcl.ar.R
import com.hcl.ar.databinding.AdapterModelMakeupBinding
import com.hcl.ar.databinding.AdapterModelSunglassBinding
import com.hcl.ar.model.GlassModel
import com.hcl.ar.util.MODEL
import java.util.*

class SunglassModelAdapter(private var context: Context?,
                           private var list : MutableList<GlassModel>,
                           private var listner: ( (Int,Int) -> Unit)? = null ) : RecyclerView.Adapter<SunglassModelAdapter.ViewHolder>() {


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder = ViewHolder(AdapterModelSunglassBinding.inflate(LayoutInflater.from(context),p0,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.iv.setImageResource(list[position].id)
        holder.binding.clGlass.background = if(list[position].selected) context?.getDrawable(R.drawable.drawable_stroke) else null
    }


    override fun getItemId(position: Int) = position.toLong()

    override fun getItemCount(): Int  = list.size

    inner class ViewHolder( var binding: AdapterModelSunglassBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
           binding.root.setOnClickListener {
               listner?.invoke(MODEL,absoluteAdapterPosition)
           }
        }
    }
}