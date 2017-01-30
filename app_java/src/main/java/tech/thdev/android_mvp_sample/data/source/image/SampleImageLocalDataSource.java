package tech.thdev.android_mvp_sample.data.source.image;

import android.content.Context;

import java.util.ArrayList;

import tech.thdev.android_mvp_sample.data.ImageItem;

/**
 * Created by tae-hwan on 1/30/17.
 */

public class SampleImageLocalDataSource implements SampleImageSource {

    @Override
    public void getImages(Context context, int size, LoadImageCallback loadImageCallback) {
        ArrayList<ImageItem> items = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            final int random = (int) (Math.random() * 15);
            final String name = String.format("sample_%02d", random);
            final int resource = context.getResources().getIdentifier(name, "drawable", context.getApplicationContext().getPackageName());
            items.add(new ImageItem(resource, name));
        }

        if (loadImageCallback != null) {
            loadImageCallback.onImageLoaded(items);
        }
    }
}
