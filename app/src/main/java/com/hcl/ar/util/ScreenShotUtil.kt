package com.hcl.ar.util

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Environment
import android.text.format.DateFormat
import android.view.View
import java.io.File
import java.io.FileOutputStream
import java.util.*


fun Activity.shareScreenShot(view : View) {
        shareIntent(storeScreenShot(takeScreenShot(view)))
    }


   private fun Activity.shareIntent(file: File?) {
       val intent = Intent()
       intent.action = Intent.ACTION_VIEW
       val uri: Uri = Uri.fromFile(file)
       intent.setDataAndType(uri, "image/*")
       startActivity(intent)
   }


    private fun takeScreenShot(view : View) : Bitmap? {
        val v1: View = view.rootView
        v1.isDrawingCacheEnabled = true
        val bitmap = Bitmap.createBitmap(v1.drawingCache)
        v1.isDrawingCacheEnabled = false
        return bitmap
    }

    fun storeScreenShot(bitmap: Bitmap?) : File? {
        val now = Date()
        DateFormat.format("yyyy-MM-dd_hh:mm:ss", now)
        return try {
            val mPath = Environment.getExternalStorageDirectory().toString() + "/" + now + ".jpg"
            val imageFile = File(mPath)
            val outputStream = FileOutputStream(imageFile)
            bitmap?.compress(Bitmap.CompressFormat.JPEG, 100, outputStream)
            outputStream.flush()
            outputStream.close()
            imageFile
        } catch (e: Throwable) {
            e.printStackTrace()
            null
        }
    }

