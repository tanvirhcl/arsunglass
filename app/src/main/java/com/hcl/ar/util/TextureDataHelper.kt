package com.hcl.ar.util

import com.hcl.ar.R
import com.hcl.ar.model.MakeupDataModel
import kotlin.collections.HashMap

object TextureDataHelper {

    var textureSection = arrayOf("LIPS","FOUNDATION","EYE")


    fun getTextureMap() : MutableMap<String,MutableList<MakeupDataModel>?> {

        val dataMap : MutableMap<String,MutableList<MakeupDataModel>?> = HashMap()
        dataMap[textureSection[0]] = getLipsData()
        dataMap[textureSection[1]] = getFoundationData()
        dataMap[textureSection[2]] = getEye()

        return dataMap
    }

    private fun getLipsData() : MutableList<MakeupDataModel> {

       return arrayListOf(
        /* LIPS */
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_blue_magenta_violet,
            colorHex = "#5A3F99"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_brown,
            colorHex = "#BE583D"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_brown_chocolate,
            colorHex = "#5C142D"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_dark_purple,
            colorHex = "#3B1730"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_deep_chestnut,
            colorHex = "#C55A47"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_fuchsia_rose,
            colorHex = "#C34471"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_magenta_haze,
            colorHex = "#9F407B"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_oxley,
            colorHex = "#74B288"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_pastel_brown,
            colorHex = "#88705D"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_philippine_brown,
            colorHex = "#5D1611"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_pink,
            colorHex = "#856A8D"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_puce_red,
            colorHex = "#712235"
        ),
        MakeupDataModel(
            key = textureSection[0],
            selection = false,
            id = R.drawable.lips_silver_lake_blue,
            colorHex = "#5AA1C5"
        ))

    }


    private fun getFoundationData() : MutableList<MakeupDataModel> {
        return arrayListOf(
            /* FOUNDATION */
            MakeupDataModel(
                key = textureSection[1],
                selection = false,
                id = R.drawable.foundation_boy_red,
                colorHex = "#726A43"
            ),
            MakeupDataModel(
                key = textureSection[1],
                selection = false,
                id = R.drawable.foundation_deep_taupe,
                colorHex = "#7B5F5E"
            ),
            MakeupDataModel(
                key = textureSection[1],
                selection = false,
                id = R.drawable.foundation_gold_fusion,
                colorHex = "#797148"
            ),
            MakeupDataModel(
                key = textureSection[1],
                selection = false,
                id = R.drawable.foundation_grey,
                colorHex = "#75746A"
            ),
            MakeupDataModel(
                key = textureSection[1],
                selection = false,
                id = R.drawable.foundation_old_sliver,
                colorHex = "#838586"
            ),
            MakeupDataModel(
                key = textureSection[1],
                selection = false,
                id = R.drawable.foundation_puce_red,
                colorHex = "#773031"
            ),
            MakeupDataModel(
                key = textureSection[1],
                selection = false,
                id = R.drawable.foundation_sonic_silver,
                colorHex = "#76746A"
            ),

            )
    }

    private fun getEye(): MutableList<MakeupDataModel>{
        return  arrayListOf(
            /* EYE */
            MakeupDataModel(
                key = textureSection[2],
                selection = false,
                id = R.drawable.eye_bazaar,
                colorHex = "#937A7B"
            ),
            MakeupDataModel(
                key = textureSection[2],
                selection = false,
                id = R.drawable.eye_burnished_brown,
                colorHex = "#967374"
            ),
            MakeupDataModel(
                key = textureSection[2],
                selection = false,
                id = R.drawable.eye_burnt_umber,
                colorHex = "#7F2E2F"
            ),
            MakeupDataModel(
                key = textureSection[2],
                selection = false,
                id = R.drawable.eye_dim_gray,
                colorHex = "#726263"
            ),MakeupDataModel(
                key = textureSection[2],
                selection = false,
                id = R.drawable.eye_grey,
                colorHex = "#9C9D9E"
            ),MakeupDataModel(
                key = textureSection[2],
                selection = false,
                id = R.drawable.eye_mauve_taupe,
                colorHex = "#87696A"
            ),MakeupDataModel(
                key = textureSection[2],
                selection = false,
                id = R.drawable.eye_philippine_gray,
                colorHex = "#978A8B"
            ),
        )
    }


}