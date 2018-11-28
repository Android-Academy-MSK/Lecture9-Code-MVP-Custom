package ru.alexbykov.mvpsample.main.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.Button;

import ru.alexbykov.mvpsample.R;
import ru.alexbykov.mvpsample.common.ui.BaseMvpActivity;
import ru.alexbykov.mvpsample.main.mvp.MainActivityPresenter;
import ru.alexbykov.mvpsample.main.mvp.MainActivityView;
import ru.alexbykov.mvpsample.models.UserVO;
import ru.alexbykov.mvpsample.profile.mvp.ProfileActivity;

public class MainActivity extends BaseMvpActivity implements MainActivityView {

    private MainActivityPresenter mainActivityPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnOpenUSer = findViewById(R.id.btn_open_user);
        final Button btnOpenEmptyUser = findViewById(R.id.btn_open_empty);

        btnOpenUSer.setOnClickListener(v -> mainActivityPresenter.onClickOpenUser());
        btnOpenEmptyUser.setOnClickListener(v -> mainActivityPresenter.onClickOpenEmpty());

        mainActivityPresenter = getPresenter(MainActivityPresenter.class);
    }

    @Override
    public void openProfile(@NonNull UserVO user) {
        ProfileActivity.start(this, user);
    }
}
