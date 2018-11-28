package ru.alexbykov.mvpsample.main.mvp;

import android.support.annotation.NonNull;
import android.util.Log;

import ru.alexbykov.mvpsample.common.mvp.BaseMvpPresenter;
import ru.alexbykov.mvpsample.models.UserVO;

public class MainActivityPresenter extends BaseMvpPresenter<MainActivityView> {


    @Override
    public void onAttach(@NonNull MainActivityView view) {
        super.onAttach(view);
        Log.d(MainActivityPresenter.class.toString(), "onAttach: ");
    }

    @Override
    public void onDetach() {
        Log.d(MainActivityPresenter.class.toString(), "onDetach: ");
    }

    @Override
    public void onDestroy() {
        Log.d(MainActivityPresenter.class.toString(), "onDestroy:");
    }

    public void onClickOpenUser() {
        final MainActivityView view = getView();
        if (view == null) {
            return;
        }
        view.openProfile(createMockUser());
    }

    @NonNull
    private UserVO createMockUser() {
        return UserVO.create("Bojack",
                "Horseman",
                "https://ewedit.files.wordpress.com/2017/09/bojack-horseman-season-4.jpg",
                "Hate myself",
                "Superstar",
                true);
    }

    public void onClickOpenEmpty() {
        final MainActivityView view = getView();
        if (view == null) {
            return;
        }
        view.openProfile(UserVO.createDefault());
    }
}
