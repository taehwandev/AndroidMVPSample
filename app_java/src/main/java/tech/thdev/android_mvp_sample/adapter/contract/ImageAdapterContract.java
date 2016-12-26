package tech.thdev.android_mvp_sample.adapter.contract;

import java.util.ArrayList;

import tech.thdev.android_mvp_sample.data.ImageItem;

/**
 * Created by tae-hwan on 12/27/16.
 */

public interface ImageAdapterContract {

    interface View {

        void notifyAdapter();
    }

    interface Model {

        void addItems(ArrayList<ImageItem> imageItems);

        void clearItem();
    }
}
