package tech.thdev.app_kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.app_kotlin.data.ImageItem
import tech.thdev.app_kotlin.listener.OnItemClickListener
import java.util.*

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageAdapter(val context: Context) : RecyclerView.Adapter<ImageViewHolder>() {

    var imageList: ArrayList<ImageItem>? = null

    var onItemClickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ImageViewHolder?, position: Int) {
        imageList?.get(position)?.let {
            holder?.onBind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = ImageViewHolder(context, parent, onItemClickListener)

    override fun getItemCount() = imageList?.size ?: 0
}