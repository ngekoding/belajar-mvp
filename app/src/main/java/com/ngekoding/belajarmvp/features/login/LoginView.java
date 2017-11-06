package com.ngekoding.belajarmvp.features.login;

/**
 * Created by Nur on 11/6/2017.
 */

public interface LoginView {
    void showProgress();

    void hideProgress();

    void setUsernameError(String errorType);

    void setPasswordError(String errorType);

    void setError();

    void navigateToHome();
}
