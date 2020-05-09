package tech.thdev.app_kotlin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app_kotlin.R
import tech.thdev.app_kotlin.data.ImageItem
import tech.thdev.app_kotlin.listener.OnItemClickListener
import tech.thdev.app_kotlin.util.ImageAsync

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageViewHolder(
    parent: ViewGroup,
    private val onItemClickListener: OnItemClickListener?
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_image, parent, false)
) {

    private val imageView by lazy {
        itemView.findViewById(R.id.img_view) as ImageView
    }

    private val textView by lazy {
        itemView.findViewById(R.id.text) as TextView
    }

    fun onBind(item: ImageItem, position: Int) {
        ImageAsync(imageView.context, imageView).execute(item.resource)
        textView.text = item.title

        itemView.setOnClickListener {
            onItemClickListener?.onItemClick(position)
        }
    }
}