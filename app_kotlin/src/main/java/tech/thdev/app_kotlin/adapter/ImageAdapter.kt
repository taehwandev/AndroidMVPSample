package tech.thdev.app_kotlin.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.ImageItem
import tech.thdev.app_kotlin.listener.OnItemClickListener
import java.util.*

/**
 * Created by tae-hwan on 10/23/16.
 */
class ImageAdapter(val context: Context) : ImageAdapterContract.View, RecyclerView.Adapter<ImageViewHolder>(), ImageAdapterContract.Model {

    private lateinit var imageList: ArrayList<ImageItem>

    var onItemClickListener: OnItemClickListener? = null

    override fun onBindViewHolder(holder: ImageViewHolder?, position: Int) {
        imageList[position].let {
            holder?.onBind(it, position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = ImageViewHolder(context, parent, onItemClickListener)

    override fun getItemCount() = imageList.size

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