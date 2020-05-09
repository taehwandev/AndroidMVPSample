package tech.thdev.android_mvp_sample.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.lang.ref.WeakReference;

/**
 * Created by tae-hwan on 12/26/16.
 */
public class ImageAsync extends AsyncTask<Integer, Void, Bitmap> {

    private Context context;
    private final WeakReference<ImageView> imageViewReference;

    public ImageAsync(Context context, ImageView imageView) {
        this.context = context;
        imageViewReference = new WeakReference<>(imageView);
    }

    @Override
    protected Bitmap doInBackground(Integer... params) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = 2;
        return BitmapFactory.decodeResource(context.getResources(), params[0], options);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        imageViewReference.get().setImageResource(0);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        super.onPostExecute(bitmap);
        imageViewReference.get().setImageBitmap(bitmap);
    }
}