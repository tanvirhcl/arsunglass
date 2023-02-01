package com.hcl.ar.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.google.ar.core.AugmentedFace
import com.google.ar.core.TrackingState
import com.google.ar.sceneform.FrameTime
import com.google.ar.sceneform.Scene
import com.google.ar.sceneform.rendering.Renderable
import com.google.ar.sceneform.rendering.Texture
import com.google.ar.sceneform.ux.AugmentedFaceNode
import com.hcl.ar.util.MakeupListner
import com.hcl.ar.R
import com.hcl.ar.databinding.ActivityMakeupBinding
import com.hcl.ar.model.MakeupDataModel
import com.hcl.ar.util.TextureDataHelper.getTextureMap
import com.hcl.ar.util.TextureDataHelper.textureSection
import com.hcl.ar.util.isSupportedDevice
import com.hcl.ar.util.updateFrame
import java.util.*

class MakeupActivity : AppCompatActivity(), View.OnClickListener, Scene.OnUpdateListener, MakeupListner {
    private lateinit var binding : ActivityMakeupBinding

    private lateinit var arFragment: ARFragment
    private var changeModel: Boolean = false
    private var dataMap : MutableMap<String,MutableList<MakeupDataModel>?> = HashMap()

    private var texture: Texture? = null
    private var texturesMap: MutableMap<String,Texture> = HashMap()
    private val faceNodeMap = HashMap<AugmentedFace, AugmentedFaceNode>()

    private var section : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMakeupBinding.inflate(layoutInflater)

        when(isSupportedDevice()){
            true -> {
                setContentView(binding.root)
                init()
                initCtrl()
                loadTexture()
                adapter()
            }
            else -> {
                Toast.makeText(this@MakeupActivity,"ARCore not supported in this device", Toast.LENGTH_LONG).show()
                finish()
            }
        }
    }


    private fun init() {
        arFragment = (supportFragmentManager.findFragmentById(R.id.arFragment)) as ARFragment
        arFragment.arSceneView.cameraStreamRenderPriority = Renderable.RENDER_PRIORITY_FIRST

        dataMap = getTextureMap()
    }

    private fun initCtrl() {
        binding.ivClose.setOnClickListener(this)
        arFragment.arSceneView.scene.addOnUpdateListener(this)
    }

    private fun adapter() {
        // Texture Sections
        binding.rvTexture.layoutManager = GridLayoutManager(this,dataMap.keys.size)
        binding.rvTexture.adapter = MakeupSectionAdapter(this,dataMap,this)

        // Texture Sub- Sections
        section = dataMap.keys.toTypedArray()[0]
        binding.rvTextureColor.adapter = MakeupModelAdapter(this,dataMap[section],this)
    }

    private fun loadTexture() {
        for((key,value) in dataMap){
            value?.forEach {
                Texture.builder()
                    .setSource(this, it.id)
                    .build()
                    .thenAccept { texture -> texturesMap[""+it.colorHex] = texture }
            }
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.ivClose ->{ finish() }
        }
    }

    override fun onUpdate(p0: FrameTime?) {
        updateFrame(arFragment,faceNodeMap,changeModel, null,texture)
        changeModel = true
    }

    override fun onSectionClick(key: String) {
        if(!section.equals(key,true)){
            dataMap[section]?.forEach { if(it.selection) it.selection = false else return@forEach }
            changeModel = true
            texture = null
        }
        section = key
        binding.rvTextureColor.adapter = MakeupModelAdapter(this,dataMap[section],this)
    }

    override fun onSectionItemClick(position: Int, data: MakeupDataModel?) {
        changeModel = true
        texture = texturesMap[""+data?.colorHex]

    }
}