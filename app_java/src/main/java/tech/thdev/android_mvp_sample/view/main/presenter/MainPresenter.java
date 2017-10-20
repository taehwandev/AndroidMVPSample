package tech.thdev.android_mvp_sample.view.main.presenter;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.android_mvp_sample.adapter.contract.ImageAdapterContract;
import tech.thdev.android_mvp_sample.data.ImageItem;
import tech.thdev.android_mvp_sample.data.source.image.SampleImageRepository;
import tech.thdev.android_mvp_sample.data.source.image.SampleImageSource;
import tech.thdev.android_mvp_sample.listener.OnItemClickListener;

/**
 * Created by tae-hwan on 12/22/16.
 */

public class MainPresenter implements MainContract.Presenter, OnItemClickListener {

    private MainContract.View view;

    private ImageAdapterContract.Model adapterModel;
    private ImageAdapterContract.View adapterView;

    private SampleImageRepository sampleImageData;

    @Override
    public void attachView(MainContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        view = null;
    }

    @Override
    public void setSampleImageData(SampleImageRepository sampleImageData) {
        this.sampleImageData = sampleImageData;
    }

    @Override
    public void loadItems(Context context, final boolean isClear) {
        sampleImageData.getImages(context, 10, new SampleImageSource.LoadImageCallback() {
            @Override
            public void onImageLoaded(ArrayList<ImageItem> list) {
                if (list != null) {
                    if (isClear) {
                        adapterModel.clearItem();
                    }
                    adapterModel.addItems(list);
                    adapterView.notifyAdapter();
                }
            }
        });


    }

    @Override
    public void setImageAdapterModel(ImageAdapterContract.Model adapterModel) {
        this.adapterModel = adapterModel;
    }

    @Override
    public void setImageAdapterView(ImageAdapterContract.View adapterView) {
        this.adapterView = adapterView;

        this.adapterView.setOnClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        ImageItem imageItem = adapterModel.getItem(position);
        view.showToast(imageItem.getTitle());
    }
}
