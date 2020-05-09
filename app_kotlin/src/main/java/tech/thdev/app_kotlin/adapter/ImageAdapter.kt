package tech.thdev.app_kotlin.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.ImageItem
import tech.thdev.app_kotlin.listener.OnItemClickListener

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageAdapter: ImageAdapterContract.View, RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.Model {

    private lateinit var imageList: ArrayList<ImageItem>

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder =
        ImageViewHolder(parent, onItemClickListener)

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        imageList[position].let {
            holder.onBind(it, position)
        }
    }

    override fun getItemCount() =
        imageList.size

    override fun notifyAdapter() {
        notifyDataSetChanged()
    }

    override fun addItems(imageItems: ArrayList<ImageItem>) {
        this.imageList = imageItems
    }

    override fun clearItem() {
        imageList.clear()
    }
}