package com.hcl.ar.ui

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.ar.core.AugmentedFace
import com.google.ar.sceneform.FrameTime
import com.google.ar.sceneform.Scene
import com.google.ar.sceneform.rendering.ModelRenderable
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.ux.AugmentedFaceNode
import com.hcl.ar.R
import com.hcl.ar.databinding.ActivityArSunglassBinding
import com.hcl.ar.util.ModelDataHelper.modelList
import com.hcl.ar.util.isSupportedDevice
import com.hcl.ar.util.shareScreenShot
import com.hcl.ar.util.updateFrame
import java.util.*


class SunglassARActivity : AppCompatActivity(), Scene.OnUpdateListener, (Int, Int) -> Unit, View.OnClickListener {

    private lateinit var binding: ActivityArSunglassBinding
    private lateinit var arFragment: ARFragment

    private var model : ModelRenderable? = null
    private val faceNodeMap = HashMap<AugmentedFace, AugmentedFaceNode>()

    private var modelMap: MutableMap<String,ModelRenderable> = HashMap()
    private var changeModel: Boolean = false



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityArSunglassBinding.inflate(layoutInflater)

        when(isSupportedDevice()){
            true ->{
                setContentView(binding.root)
                init()
                initCtrl()
                load3DModel()

                binding.rvModel.adapter = SunglassModelAdapter(this,modelList,this)

            }
            else -> {
                Toast.makeText(this@SunglassARActivity,"ARCore not supported in this device",Toast.LENGTH_LONG).show()
                finish()
            }
        }

    }

    private fun init() {
        arFragment = (supportFragmentManager.findFragmentById(R.id.arFragment)) as ARFragment
        arFragment.arSceneView.cameraStreamRenderPriority = Renderable.RENDER_PRIORITY_FIRST
    }

    private fun initCtrl() {
        arFragment.arSceneView.scene.addOnUpdateListener(this)
        binding.ivClose.setOnClickListener(this@SunglassARActivity)
        binding.ivShare.setOnClickListener(this@SunglassARActivity)
    }
    
    private fun load3DModel() {
        modelList.shuffle()
        for (i in modelList.indices) {
            ModelRenderable.builder()
                .setSource(this, modelList[i].rawId)
                .build()
                .thenAccept { model ->
                    model.apply {
                        modelMap[modelList[i].key] = model
                        isShadowCaster = false
                        isShadowReceiver = false
            }
         }
        }

    }




    override fun onUpdate(p0: FrameTime?) {
        updateFrame(arFragment,faceNodeMap,changeModel, model,null)
        changeModel = true
    }

    override fun invoke(type: Int, position: Int) {
        changeModel = true
        modelList.forEach { if(it.selected) it.selected = false else return@forEach }
        modelList[position].selected = true
        model = modelMap[modelList[position].key]
        binding.rvModel.adapter?.notifyDataSetChanged()
    }

    override fun onClick(p0: View?) {
        when(p0?.id) {
            R.id.ivClose -> { finish() }
            R.id.ivShare -> { shareScreenShot(arFragment.arSceneView) }
        }
    }

}
