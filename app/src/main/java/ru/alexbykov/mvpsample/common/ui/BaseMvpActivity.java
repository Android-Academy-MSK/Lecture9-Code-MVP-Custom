package ru.alexbykov.mvpsample.common.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.HashMap;

import ru.alexbykov.mvpsample.App;
import ru.alexbykov.mvpsample.common.mvp.BaseMvpPresenter;
import ru.alexbykov.mvpsample.common.mvp.BaseMvpView;

public abstract class BaseMvpActivity extends AppCompatActivity {

    private App application;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        application = (App) getApplication();

        if (!(this instanceof BaseMvpView)) {
            throw new IllegalStateException();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        for (BaseMvpPresenter baseMvpPresenter : getPresenters().values()) {
            final BaseMvpView view = (BaseMvpView) this;
            baseMvpPresenter.onAttach(view);
        }
    }

    @Override
    protected void onStop() {
        for (BaseMvpPresenter baseMvpPresenter : getPresenters().values()) {
            baseMvpPresenter.onDetach();
        }
        super.onStop();
    }

    private HashMap<String, BaseMvpPresenter> getPresenters() {
        return application.getPresenters(getStoreKey());
    }



    @Override
    protected void onDestroy() {
        if (isFinishing()) {
            for (BaseMvpPresenter baseMvpPresenter : getPresenters().values()) {
                baseMvpPresenter.onDestroy();
            }
            application.clear(getStoreKey());
        }

        super.onDestroy();
    }

    private String getStoreKey() {
        return this.getClass().getSimpleName();
    }

    protected <T extends BaseMvpPresenter> T getPresenter(Class<T> presenter) {
        return application.getPresenter(getStoreKey(), presenter);
    }


}
