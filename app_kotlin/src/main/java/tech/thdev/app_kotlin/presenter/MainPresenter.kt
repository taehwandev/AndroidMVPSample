package tech.thdev.app_kotlin.presenter

import android.content.Context
import tech.thdev.app_kotlin.data.ImageData

/**
 * Created by tae-hwan on 12/23/16.
 */

class MainPresenter : MainContract.Presenter {

    lateinit override var view: MainContract.View
    lateinit override var imageData: ImageData

    override fun loadItems(context: Context, isClear: Boolean) {
        imageData.getSampleList(context, 10).let {
            view.updateItems(it, isClear)
            view.notifyAdapter()
        }
    }
}