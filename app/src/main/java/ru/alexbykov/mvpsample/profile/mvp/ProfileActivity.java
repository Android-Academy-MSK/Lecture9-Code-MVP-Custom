package ru.alexbykov.mvpsample.profile.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import ru.alexbykov.mvpsample.R;
import ru.alexbykov.mvpsample.common.ui.BaseMvpActivity;
import ru.alexbykov.mvpsample.common.ui.ImageLoader;
import ru.alexbykov.mvpsample.models.UserVO;
import ru.alexbykov.mvpsample.profile.common.Field;
import ru.alexbykov.mvpsample.profile.common.Gender;
import ru.alexbykov.mvpsample.profile.ui.ProfilePresenter;
import ru.alexbykov.mvpsample.profile.ui.ProfileView;

public class ProfileActivity extends BaseMvpActivity implements ProfileView {

    private static final int LAYOUT = R.layout.activity_profile;
    private static final String EXTRA_USER = "User";

    public static void start(@NonNull Context context,
                             @NonNull UserVO user) {
        Intent starter = new Intent(context, ProfileActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable(EXTRA_USER, user);
        starter.putExtras(bundle);
        context.startActivity(starter);
    }


    private TextView tvName;
    private TextView tvSecondName;
    private TextView tvAbout;
    private TextView tvGender;
    private TextView tvJobTitle;
    private ImageView ivPhoto;


    private ProfilePresenter profilePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);
        findViews();

        profilePresenter = getPresenter(ProfilePresenter.class);
        final UserVO user = (UserVO) getIntent().getSerializableExtra(EXTRA_USER);
        profilePresenter.setUser(user);
    }

    @Override
    public void setupName(@NonNull String name) {
        tvName.setText(name);
    }

    @Override
    public void setupSecondName(@NonNull String secondName) {
        tvSecondName.setText(secondName);
    }

    @Override
    public void setupPhoto(@Nullable String photoUrl) {
        ImageLoader.load(photoUrl, ivPhoto);
    }

    @Override
    public void setupAbout(@NonNull String about) {
        tvAbout.setText(about);
    }

    @Override
    public void setupGender(@NonNull Gender gender) {
        tvGender.setText(gender.getStringResource());

    }

    @Override
    public void setupNoData(@NonNull Field field) {
        final String unknown = getString(R.string.field_unknown);
        switch (field) {
            case Name:
                setupName(unknown);
                break;
            case About:
                setupAbout(unknown);
                break;
            case JobTitle:
                setupJobTitle(unknown);
                break;
            case SecondName:
                setupSecondName(unknown);
                break;
            default:
                throw new IllegalStateException("Field " + field + "is not processed right now");

        }
    }

    @Override
    public void setupJobTitle(@NonNull String jobTitle) {
        tvJobTitle.setText(jobTitle);
    }


    private void findViews() {
        tvName = findViewById(R.id.tv_name);
        tvSecondName = findViewById(R.id.tv_second_name);
        tvAbout = findViewById(R.id.tv_about);
        tvGender = findViewById(R.id.tv_gender);
        ivPhoto = findViewById(R.id.iv_photo);
        tvJobTitle = findViewById(R.id.tv_job_title);
    }
}
