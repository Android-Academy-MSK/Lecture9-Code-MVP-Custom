package ru.alexbykov.mvpsample.profile.ui;

import android.support.annotation.NonNull;

import ru.alexbykov.mvpsample.common.mvp.BaseMvpPresenter;
import ru.alexbykov.mvpsample.models.UserVO;
import ru.alexbykov.mvpsample.profile.common.Field;
import ru.alexbykov.mvpsample.profile.common.Gender;
import ru.alexbykov.mvpsample.profile.mvp.utils.UserValidator;

public class ProfilePresenter extends BaseMvpPresenter<ProfileView> {

    private UserVO user;

    @Override
    public void onAttach(@NonNull ProfileView view) {
        super.onAttach(view);
        setupName(view);
        setupSecondName(view);
        setupPhoto(view);
        setupJobTitle(view);
        setupAbout(view);
        setupGender(view);
    }

    public void setUser(@NonNull UserVO user) {
        this.user = user;
    }
    
    private void setupName(@NonNull ProfileView view) {
        final String name = user.getName();

        if (!UserValidator.isValidField(name)) {
            view.setupNoData(Field.Name);
            return;
        }
        view.setupName(name);
    }

    private void setupSecondName(@NonNull ProfileView view) {
        final String secondName = user.getSecondName();

        if (!UserValidator.isValidField(secondName)) {
            view.setupNoData(Field.SecondName);
            return;
        }
        view.setupSecondName(secondName);
    }

    private void setupGender(@NonNull ProfileView view) {
        final Boolean gender = user.getGender();
        final Gender validGender = Gender.fromBoolean(gender);
        view.setupGender(validGender);
    }

    private void setupAbout(@NonNull ProfileView view) {
        final String about = user.getAbout();

        if (!UserValidator.isValidField(about)) {
            view.setupNoData(Field.About);
            return;
        }
        view.setupAbout(about);
    }

    private void setupJobTitle(@NonNull ProfileView view) {
        final String jobTitle = user.getJobTitle();

        if (!UserValidator.isValidField(jobTitle)) {
            view.setupNoData(Field.JobTitle);
            return;
        }
        view.setupJobTitle(jobTitle);
    }

    private void setupPhoto(@NonNull ProfileView view) {
        final String imageUrl = user.getImageUrl();
        view.setupPhoto(imageUrl);
    }


}
