package tech.thdev.app_kotlin.data.source.image

import android.content.Context
import tech.thdev.app_kotlin.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 1/30/17.
 */
object SampleImageLocalDataSource : SampleImageSource {

    override fun getImages(context: Context, size: Int, loadImageCallback: SampleImageSource.LoadImageCallback?) {
        val list = ArrayList<ImageItem>()
        for (index in 0..size) {
            val name = String.format("sample_%02d", (Math.random() * 15).toInt())
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource, name))
        }
        loadImageCallback?.onLoadImages(list)
    }
}