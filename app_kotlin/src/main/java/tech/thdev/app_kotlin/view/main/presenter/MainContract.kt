package tech.thdev.app_kotlin.view.main.presenter

import android.content.Context
import tech.thdev.app_kotlin.data.ImageData
import tech.thdev.app_kotlin.data.ImageItem
import java.util.*

/**
 * Created by tae-hwan on 12/23/16.
 */

interface MainContract {
    interface View {

        fun updateItems(items: ArrayList<ImageItem>, isClear: Boolean)

        fun notifyAdapter()
    }

    interface Presenter {
        var view: MainContract.View
        var imageData: ImageData

        fun loadItems(context: Context, isClear: Boolean)
    }
}