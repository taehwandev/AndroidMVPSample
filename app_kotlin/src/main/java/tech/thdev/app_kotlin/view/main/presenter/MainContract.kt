package tech.thdev.app_kotlin.view.main.presenter

import android.content.Context
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.ImageData

/**
 * Created by tae-hwan on 12/23/16.
 */

interface MainContract {

    interface View

    interface Presenter {
        var view: MainContract.View
        var imageData: ImageData

        var adapterModel: ImageAdapterContract.Model
        var adapterView: ImageAdapterContract.View

        fun loadItems(context: Context, isClear: Boolean)
    }
}