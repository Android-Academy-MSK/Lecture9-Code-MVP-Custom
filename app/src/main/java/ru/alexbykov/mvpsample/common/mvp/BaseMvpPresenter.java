package ru.alexbykov.mvpsample.common.mvp;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public abstract class BaseMvpPresenter<V extends BaseMvpView> {

    private V view;


    public void onAttach(@NonNull V view) {
        this.view = view;
    }

    @Nullable
    protected V getView() {
        return view;
    }

    public void onDetach() {
        view = null;
    }

    public void onDestroy() {

    }
}
