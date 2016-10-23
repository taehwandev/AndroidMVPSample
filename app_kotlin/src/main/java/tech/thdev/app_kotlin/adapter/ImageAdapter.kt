package tech.thdev.app_kotlin.adapter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import tech.thdev.app_kotlin.R
import tech.thdev.app_kotlin.data.ImageItem
import java.lang.ref.WeakReference
import java.util.*

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageViewHolder>() {

    var imageList: ArrayList<ImageItem>? = null

    override fun onBindViewHolder(holder: ImageViewHolder?, position: Int) {
        val item = imageList?.get(position)

        ImageAsync(holder?.imageView).execute(item?.resource)
        holder?.textView?.text = item?.title

        holder?.itemView?.setOnClickListener {
            Toast.makeText(context, "Show ${item?.title}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = ImageViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false))

    override fun getItemCount() = imageList?.size ?: 0

    inner class ImageAsync(imageView: ImageView?) : AsyncTask<Int, Void, Bitmap>() {

        val imageViewReference: WeakReference<ImageView?>

        init {
            imageViewReference = WeakReference(imageView)
        }

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
}