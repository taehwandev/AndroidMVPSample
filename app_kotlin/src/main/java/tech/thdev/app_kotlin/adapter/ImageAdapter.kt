package tech.thdev.app_kotlin.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageAdapter : ImageAdapterContract.View, RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.Model {

    private lateinit var imageList: ArrayList<ImageItem>

    override var onClickFunc: ((Int) -> Unit)? = null

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        imageList[position].let {
            holder.onBind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(parent, onClickFunc)

    override fun getItemCount() = imageList.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun getItem(position: Int) = imageList[position]

    override fun addItems(imageItems: ArrayList<ImageItem>) {
        this.imageList = imageItems
    }

    override fun clearItem() {
        imageList.clear()
    }
}