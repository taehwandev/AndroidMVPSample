package tech.thdev.android_mvp_sample.view.main.presenter;

import android.content.Context;

import tech.thdev.android_mvp_sample.adapter.contract.ImageAdapterContract;
import tech.thdev.android_mvp_sample.data.SampleImageData;

/**
 * Created by tae-hwan on 12/22/16.
 */
public interface MainContract {

    interface View {

    }

    interface Presenter {

        void attachView(View view);

        void setImageAdapterModel(ImageAdapterContract.Model adapterModel);

        void setImageAdapterView(ImageAdapterContract.View adapterView);

        void detachView();

        void setSampleImageData(SampleImageData sampleImageData);

        void loadItems(Context context, boolean isClear);
    }
}
