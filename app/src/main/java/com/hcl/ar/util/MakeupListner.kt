package com.hcl.ar.util

import com.hcl.ar.model.MakeupDataModel

interface MakeupListner {
    fun onSectionClick(key: String)
    fun onSectionItemClick(position: Int, data : MakeupDataModel?)
}