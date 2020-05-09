package tech.thdev.app_kotlin.view.main.presenter

import android.content.Context

/**
 * Created by tae-hwan on 12/23/16.
 */
interface MainContract {

    interface View {

        fun showToast(title: String)
    }

    interface Presenter {
        fun loadItems(context: Context, isClear: Boolean)
    }
}