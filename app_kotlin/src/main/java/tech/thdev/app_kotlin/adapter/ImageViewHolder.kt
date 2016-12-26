package tech.thdev.app_kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import tech.thdev.app_kotlin.R
import tech.thdev.app_kotlin.data.ImageItem
import tech.thdev.app_kotlin.listener.OnItemClickListener
import tech.thdev.app_kotlin.util.ImageAsync

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageViewHolder(val context: Context, parent: ViewGroup?, val onItemClickListener: OnItemClickListener?)
    : RecyclerView.ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_image, parent, false)) {

    val imageView by lazy {
        itemView.findViewById(R.id.img_view) as ImageView
    }

    val textView by lazy {
        itemView.findViewById(R.id.text) as TextView
    }

    fun onBind(item: ImageItem, position: Int) {
        ImageAsync(context, imageView).execute(item.resource)
        textView.text = item.title

        itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }
    }
}