package ru.alexbykov.mvpsample.profile.mvp.utils;

import android.support.annotation.Nullable;

public final class UserValidator {

    private UserValidator() {
        //no instance
    }

    public static boolean isValidField(@Nullable String name) {
        return name != null && !name.isEmpty();
    }
}
