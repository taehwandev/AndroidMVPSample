package tech.thdev.android_mvp_sample.presenter;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.android_mvp_sample.data.ImageItem;
import tech.thdev.android_mvp_sample.data.SampleImageData;

/**
 * Created by tae-hwan on 12/22/16.
 */
public class MainPresenter implements MainContract.Presenter {

    private MainContract.View view;

    private SampleImageData sampleImageData;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setSampleImageData(SampleImageData sampleImageData) {
        this.sampleImageData = sampleImageData;
    }

    @Override
    public void loadItems(Context context, boolean isClear) {
        ArrayList<ImageItem> items = sampleImageData.getImages(context, 10);
        view.addItems(items, isClear);
        view.notifyAdapter();
    }
}
