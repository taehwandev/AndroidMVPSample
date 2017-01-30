package tech.thdev.app_kotlin.data.source.image

import android.content.Context
import tech.thdev.app_kotlin.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 1/30/17.
 */
object SampleImageRepository : SampleImageSource {

    private val sampleImageLocalDataSource = SampleImageLocalDataSource

    override fun getImages(context: Context, size: Int, loadImageCallback: SampleImageSource.LoadImageCallback?) {
        sampleImageLocalDataSource.getImages(context, size, object : SampleImageSource.LoadImageCallback {
            override fun onLoadImages(list: ArrayList<ImageItem>) {
                loadImageCallback?.onLoadImages(list)
            }
        })
    }
}