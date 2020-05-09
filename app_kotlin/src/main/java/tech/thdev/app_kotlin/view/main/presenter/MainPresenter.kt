package tech.thdev.app_kotlin.view.main.presenter

import android.content.Context
import tech.thdev.app_kotlin.adapter.contract.ImageAdapterContract
import tech.thdev.app_kotlin.data.ImageData

/**
 * Created by tae-hwan on 12/23/16.
 */
class MainPresenter(
    private val view: MainContract.View,
    private val imageData: ImageData,
    private val adapterModel: ImageAdapterContract.Model,
    private val adapterView: ImageAdapterContract.View
) : MainContract.Presenter {

    init {
        adapterView.onClickFunc = {
            onClickListener(it)
        }
    }

    override fun loadItems(context: Context, isClear: Boolean) {
        imageData.getSampleList(context, 10).let {
            if (isClear) {
                adapterModel.clearItem()
            }

            adapterModel.addItems(it)
            adapterView.notifyAdapter()
        }
    }

    private fun onClickListener(position: Int) {
        adapterModel.getItem(position).let {
            view.showToast(it.title)
        }
    }
}