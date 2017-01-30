package tech.thdev.app_kotlin.view.main.presenter

import android.content.Context
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.source.image.SampleImageRepository

/**
 * Created by tae-hwan on 12/23/16.
 */

interface MainContract {

    interface View {

        fun showToast(title: String)
    }

    interface Presenter {
        var view: MainContract.View
        var imageData: SampleImageRepository

        var adapterModel: ImageAdapterContract.Model
        var adapterView: ImageAdapterContract.View?

        fun loadItems(context: Context, isClear: Boolean)
    }
}