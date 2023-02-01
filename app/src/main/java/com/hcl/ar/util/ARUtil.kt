package com.hcl.ar.util

import android.app.Activity
import android.graphics.Bitmap
import android.graphics.Color
import com.google.ar.core.ArCoreApk
import com.google.ar.core.AugmentedFace
import com.google.ar.core.TrackingState
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Texture
import com.google.ar.sceneform.ux.AugmentedFaceNode
import com.hcl.ar.ui.ARFragment
import java.util.HashMap


fun Activity.isSupportedDevice() = ArCoreApk.getInstance().checkAvailability(this) != ArCoreApk.Availability.UNSUPPORTED_DEVICE_NOT_CAPABLE
 const val MODEL =0
 const val TEXTURE =1

fun updateFrame(
 arFragment: ARFragment, faceNodeMap: HashMap<AugmentedFace, AugmentedFaceNode>,
 changeModel: Boolean, model: ModelRenderable?, texture: Texture?
){
 val scene = arFragment.arSceneView.scene

 val collection: Collection<AugmentedFace>? = arFragment.arSceneView.session?.getAllTrackables(
  AugmentedFace::class.java)
 collection?.forEach { face ->
  when(!faceNodeMap.containsKey(face)) {
   true -> {
    val faceNode = AugmentedFaceNode(face)
    faceNode.apply {
     setParent(scene)
     faceRegionsRenderable = model
     faceMeshTexture = texture
     faceNodeMap[face] = faceNode
    }
   }
   false -> { if(changeModel) {
    faceNodeMap.getValue(face).apply {
     faceRegionsRenderable = model
     faceMeshTexture = texture
    }
   }
   }
  }
 }

 val iterator = faceNodeMap.entries.iterator()
 while (iterator.hasNext()) {
  val entry = iterator.next()
  val face = entry.key
  if (face.trackingState == TrackingState.STOPPED) {
   val faceNode = entry.value
   faceNode.setParent(null)
   iterator.remove()
  }
 }
}