package ru.alexbykov.mvpsample.profile.common;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;

import ru.alexbykov.mvpsample.R;

public enum Gender {

    MALE(R.string.gender_male),
    FEMALE(R.string.gender_female),
    UNKNOWN(R.string.gender_unknown);

    private int resId;


    Gender(@StringRes int resId) {
        this.resId = resId;
    }




    @NonNull
    public static Gender fromBoolean(@Nullable Boolean gender) {
        if (gender == null) {
            return UNKNOWN;
        }
        if (gender) {
            return MALE;
        }
        return FEMALE;
    }

    @StringRes
    public int getStringResource(){
        return resId;
    }


}
