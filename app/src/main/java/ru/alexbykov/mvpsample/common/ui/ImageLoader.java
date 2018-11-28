package ru.alexbykov.mvpsample.common.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import ru.alexbykov.mvpsample.R;

public final class ImageLoader {

    private ImageLoader() {
        //no instance
    }


    public static void load(@Nullable String url,
                            @NonNull ImageView into){
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.ic_photo_placeholder)
                .into(into);
    }
}
