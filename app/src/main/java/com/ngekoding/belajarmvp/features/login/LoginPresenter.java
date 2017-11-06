package com.ngekoding.belajarmvp.features.login;

/**
 * Created by Nur on 11/6/2017.
 */

public interface LoginPresenter {
    void validateCredentials(String username, String password);

    void onUsernameError(String errorType);

    void onPasswordError(String errorType);

    void onError();

    void onSuccess();
}
