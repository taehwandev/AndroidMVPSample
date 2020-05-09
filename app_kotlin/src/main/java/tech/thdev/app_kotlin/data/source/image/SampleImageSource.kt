package tech.thdev.app_kotlin.data.source.image

import android.content.Context
import tech.thdev.app_kotlin.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 1/30/17.
 */
interface SampleImageSource {

    interface LoadImageCallback {

        fun onLoadImages(list: ArrayList<ImageItem>)
    }

    fun getImages(context: Context, size: Int, loadImageCallback: LoadImageCallback?)
}