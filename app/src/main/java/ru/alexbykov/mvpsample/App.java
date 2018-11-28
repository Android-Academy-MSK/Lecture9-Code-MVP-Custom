package ru.alexbykov.mvpsample;

import android.app.Application;
import android.support.annotation.NonNull;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

import ru.alexbykov.mvpsample.common.mvp.BaseMvpPresenter;

public class App extends Application {

    private final HashMap<String, HashMap<String, BaseMvpPresenter>> presenterStore = new HashMap<>();


    @Override
    public void onCreate() {
        super.onCreate();

        final Picasso picasso = new Picasso.Builder(this)
                .loggingEnabled(true)
                .build();

        Picasso.setSingletonInstance(picasso);
    }

    @SuppressWarnings("unchecked cast")
    private <T extends BaseMvpPresenter> T savePresenter(String storeKey,
                                                         String presenterKey,
                                                         Class<T> presenterClass) {
        HashMap<String, BaseMvpPresenter> presenters = getPresenters(storeKey);

        final BaseMvpPresenter presenter = presenters.get(presenterKey);
        if (presenter != null) {
            return (T) presenter;
        }

        try {
            final T newPresenter = presenterClass.newInstance();
            presenters.put(presenterKey, newPresenter);
            presenterStore.put(storeKey, presenters);
            return newPresenter;
        } catch (IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
            throw new IllegalStateException();
        }

    }


    public <T extends BaseMvpPresenter> T getPresenter(String storeKey,
                                                       Class<T> presenter) {

        final String presenterKey = presenter.getSimpleName();
        return savePresenter(storeKey, presenterKey, presenter);
    }


    public void clear(String store) {
        presenterStore.remove(store);
    }


    public HashMap<String, BaseMvpPresenter> getPresenters(@NonNull String storeKey) {

        HashMap<String, BaseMvpPresenter> presenters = presenterStore.get(storeKey);
        if (presenters == null) {
            presenters = new HashMap<>();
        }
        return presenters;
    }
}
