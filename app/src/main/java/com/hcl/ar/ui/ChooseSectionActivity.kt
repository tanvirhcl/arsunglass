package com.hcl.ar.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.hcl.ar.R
import com.hcl.ar.databinding.ActivityChooseSectionBinding

class ChooseSectionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityChooseSectionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ivSunglass.setOnClickListener {
            startActivity(Intent(this@ChooseSectionActivity,SunglassARActivity::class.java))

        }
        binding.ivMakeup.setOnClickListener {
            startActivity(Intent(this@ChooseSectionActivity,MakeupActivity::class.java))

        }
        Glide.with(this).load(R.drawable.sunglasses).into(binding.ivSunglass)
        Glide.with(this).load(R.drawable.make).into(binding.ivMakeup)
    }
}