package tech.thdev.android_mvp_sample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.android_mvp_sample.data.ImageItem;

/**
 * Created by tae-hwan on 1/30/17.
 */

public interface SampleImageSource {

    interface LoadImageCallback {

        void onImageLoaded(ArrayList<ImageItem> list);
    }

    void getImages(Context context, int size, LoadImageCallback loadImageCallback);
}
