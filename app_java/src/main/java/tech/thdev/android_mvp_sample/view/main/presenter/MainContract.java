package tech.thdev.android_mvp_sample.view.main.presenter;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.android_mvp_sample.data.ImageItem;
import tech.thdev.android_mvp_sample.data.SampleImageData;

/**
 * Created by tae-hwan on 12/22/16.
 */

public interface MainContract {

    interface View {

        void addItems(ArrayList<ImageItem> items, boolean isClear);

        void notifyAdapter();
    }

    interface Presenter {

        void attachView(View view);

        void detachView();

        void setSampleImageData(SampleImageData sampleImageData);

        void loadItems(Context context, boolean isClear);
    }
}
