package tech.thdev.app_kotlin.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.widget.ImageView
import java.lang.ref.WeakReference

/**
 * Created by tae-hwan on 12/26/16.
 */
class ImageAsync(
    private val context: Context,
    imageView: ImageView?
) : AsyncTask<Int, Void, Bitmap>() {

    private val imageViewReference: WeakReference<ImageView?> = WeakReference(imageView)

    override fun doInBackground(vararg params: Int?): Bitmap? {
        val options = BitmapFactory.Options()
        options.inSampleSize = 2
        return BitmapFactory.decodeResource(context.resources, params[0] as Int, options)
    }

    override fun onPreExecute() {
        super.onPreExecute()
        imageViewReference.get()?.setImageResource(0)
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        result?.let { imageViewReference.get()?.setImageBitmap(result) }
    }
}