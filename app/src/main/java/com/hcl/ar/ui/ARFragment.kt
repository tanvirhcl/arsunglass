package com.hcl.ar.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.google.ar.core.Config
import com.google.ar.core.Session
import com.google.ar.sceneform.ux.ArFragment
import java.util.*

class ARFragment : ArFragment() {

    override fun getSessionConfiguration(session: Session?) = Config(session).apply { augmentedFaceMode = Config.AugmentedFaceMode.MESH3D }
    override fun getSessionFeatures(): MutableSet<Session.Feature> = EnumSet.of(Session.Feature.FRONT_CAMERA)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val layout = super.onCreateView(inflater, container, savedInstanceState) as FrameLayout
        planeDiscoveryController.apply {
            hide()
            setInstructionView(null)
        }
        return layout
    }
}
