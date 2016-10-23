package tech.thdev.app_kotlin.data

import android.content.Context
import java.util.*

/**
 * Created by tae-hwan on 10/23/16.
 */
object ImageData {

    fun getSampleList(context: Context, size: Int) : ArrayList<ImageItem> {
        val list = ArrayList<ImageItem>()
        for (index in 0..size) {
            val name = String.format("sample_%02d", (Math.random() * 15).toInt())
            val resource = context.resources.getIdentifier(name, "drawable", context.packageName)
            list.add(ImageItem(resource, name))
        }
        return list
    }
}