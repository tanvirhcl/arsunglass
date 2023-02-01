package com.hcl.ar.util

import com.hcl.ar.R
import com.hcl.ar.model.GlassModel

object ModelDataHelper {
     val modelList = arrayListOf(
        GlassModel(key="aero_blue", id= R.drawable.sunglass_aero_blue, rawId = R.raw.sunglass_aero_blue),
        GlassModel(key = "black", id = R.drawable.sunglass_black, rawId = R.raw.sunglass_black),
        GlassModel(key = "blue_purple", id = R.drawable.sunglass_blue_purple, rawId = R.raw.sunglass_blue_purple),
        GlassModel(key = "french_lime", id = R.drawable.sunglass_french_lime, rawId = R.raw.sunglass_french_lime),
        GlassModel(key = "lavender_rose", id = R.drawable.sunglass_lavender_rose, rawId = R.raw.sunglass_lavender_rose),
        GlassModel(key = "medium_blue", id = R.drawable.sunglass_medium_blue, rawId = R.raw.sunglass_medium_blue),
        GlassModel(key = "pink", id = R.drawable.sunglass_pink, rawId = R.raw.sunglass_pink),
        GlassModel(key = "purple", id = R.drawable.sunglass_purple, rawId = R.raw.sunglass_purple),
        GlassModel(key = "sea_green", id = R.drawable.sunglass_sea_green, rawId = R.raw.sunglass_sea_green),
        GlassModel(key = "yellow", id = R.drawable.sunglass_yellow, rawId = R.raw.sunglass_yellow),
        GlassModel(key = "green_frame", id = R.drawable.sunglass_green_frame, rawId = R.raw.sunglasses_01)
    )
}