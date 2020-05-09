package tech.thdev.app_kotlin.adapter.contract

import tech.thdev.app_kotlin.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 12/27/16.
 */
interface ImageAdapterContract {

    interface View {

        var onClickFunc : ((Int) -> Unit)?

        fun notifyAdapter()
    }

    interface Model {

        fun addItems(imageItems: ArrayList<ImageItem>)

        fun clearItem()

        fun getItem(position: Int): ImageItem
    }
}