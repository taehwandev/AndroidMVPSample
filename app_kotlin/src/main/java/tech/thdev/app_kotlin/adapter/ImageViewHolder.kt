package tech.thdev.app_kotlin.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app_kotlin.R

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val imageView by lazy {
        itemView.findViewById(R.id.img_view) as ImageView
    }

    val textView by lazy {
        itemView.findViewById(R.id.text) as TextView
    }
}