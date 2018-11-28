package ru.alexbykov.mvpsample.profile.ui;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ru.alexbykov.mvpsample.common.mvp.BaseMvpView;
import ru.alexbykov.mvpsample.profile.common.Field;
import ru.alexbykov.mvpsample.profile.common.Gender;

public interface ProfileView extends BaseMvpView {

    void setupName(@NonNull String name);

    void setupSecondName(@NonNull String secondName);

    void setupPhoto(@Nullable String photoUrl);

    void setupAbout(@NonNull String about);

    void setupGender(@NonNull Gender gender);

    void setupNoData(@NonNull Field field);

    void setupJobTitle(@NonNull String jobTitle);

}
