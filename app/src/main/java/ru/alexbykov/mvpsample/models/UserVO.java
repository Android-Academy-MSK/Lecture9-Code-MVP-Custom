package ru.alexbykov.mvpsample.models;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;

public class UserVO implements Serializable {

    public static UserVO createDefault() {
        return new UserVO();
    }

    public static UserVO create(@NonNull String name,
                                @NonNull String secondName,
                                @NonNull String imageUrl,
                                @NonNull String about,
                                @NonNull String jobTitle,
                                @NonNull Boolean gender) {
        return new UserVO(name, secondName, imageUrl, about, jobTitle, gender);

    }

    private String name;
    private String secondName;
    private String imageUrl;
    private String about;
    private String jobTitle;
    private Boolean gender;


    private UserVO() {

    }

    private UserVO(String name,
                   String secondName,
                   String imageUrl,
                   String about,
                   String jobTitle,
                   Boolean gender) {
        this.name = name;
        this.secondName = secondName;
        this.imageUrl = imageUrl;
        this.about = about;
        this.jobTitle = jobTitle;
        this.gender = gender;
    }

    @Nullable
    public String getName() {
        return name;
    }

    @Nullable
    public String getSecondName() {
        return secondName;
    }

    @Nullable
    public String getImageUrl() {
        return imageUrl;
    }

    @Nullable
    public String getAbout() {
        return about;
    }

    @Nullable
    public String getJobTitle() {
        return jobTitle;
    }

    @Nullable
    public Boolean getGender() {
        return gender;
    }
}
