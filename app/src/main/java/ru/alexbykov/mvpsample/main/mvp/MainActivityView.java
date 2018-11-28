package ru.alexbykov.mvpsample.main.mvp;

import android.support.annotation.NonNull;

import ru.alexbykov.mvpsample.common.mvp.BaseMvpView;
import ru.alexbykov.mvpsample.models.UserVO;

public interface MainActivityView extends BaseMvpView {


    void openProfile(@NonNull UserVO user);

}
