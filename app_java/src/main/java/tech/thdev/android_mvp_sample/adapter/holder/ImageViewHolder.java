package tech.thdev.android_mvp_sample.adapter.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import tech.thdev.android_mvp_sample.R;
import tech.thdev.android_mvp_sample.data.ImageItem;
import tech.thdev.android_mvp_sample.listener.OnItemClickListener;
import tech.thdev.android_mvp_sample.util.ImageAsync;

/**
 * Created by tae-hwan on 12/26/16.
 */
public class ImageViewHolder extends RecyclerView.ViewHolder {

    private OnItemClickListener onItemClickListener;

    @BindView(R.id.img_view)
    ImageView imageView;

    public ImageViewHolder(ViewGroup parent, OnItemClickListener onItemClickListener) {
        super(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false));

        this.onItemClickListener = onItemClickListener;

        ButterKnife.bind(this, itemView);
    }

    public void onBind(ImageItem item, final int position) {
        itemView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    onItemClickListener.onItemClick(position);
                }
            }
        });

        new ImageAsync(imageView.getContext(), imageView).execute(item.getImageRes());
    }
}