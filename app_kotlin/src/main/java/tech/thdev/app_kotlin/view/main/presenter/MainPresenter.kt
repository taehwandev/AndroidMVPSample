package tech.thdev.app_kotlin.view.main.presenter

import android.content.Context
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.ImageItem
import tech.thdev.app_kotlin.data.source.image.SampleImageRepository
import tech.thdev.app_kotlin.data.source.image.SampleImageSource
import java.util.*

/**
 * Created by tae-hwan on 12/23/16.
 */
class MainPresenter(
    private val view: MainContract.View,
    private val imageData: SampleImageRepository,
    private val adapterModel: ImageAdapterContract.Model,
    private val adapterView: ImageAdapterContract.View
) : MainContract.Presenter {

    init {
        adapterView.onClickFunc = {
            onClickListener(it)
        }
    }

    override fun loadItems(context: Context, isClear: Boolean) {
        imageData.getImages(context, 10, object : SampleImageSource.LoadImageCallback {
            override fun onLoadImages(list: ArrayList<ImageItem>) {
                if (isClear) {
                    adapterModel.clearItem()
                }

                adapterModel.addItems(list)
                adapterView.notifyAdapter()
            }
        })
    }

    private fun onClickListener(position: Int) {
        adapterModel.getItem(position).let {
            view.showToast(it.title)
        }
    }
}