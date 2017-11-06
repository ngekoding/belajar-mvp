package com.ngekoding.belajarmvp.features.login;

/**
 * Created by Nur on 11/6/2017.
 */

public class LoginPresenterImp implements LoginPresenter {

    private LoginView loginView;

    public LoginPresenterImp(LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void validateCredentials(String username, String password) {
        loginView.showProgress();

        boolean error = false;
        if (username.isEmpty()) {
            this.onUsernameError("empty");
            error = true;
        }
        if (password.isEmpty()) {
            this.onPasswordError("empty");
            error = true;
        }

        if (!error) {
            if (!username.equals("ngekoding") && !password.equals("123456")) {
                this.onError();
            } else {
                this.onSuccess();
            }
        }
    }

    @Override
    public void onUsernameError(String errorType) {
        loginView.setUsernameError(errorType);
        loginView.hideProgress();
    }

    @Override
    public void onPasswordError(String errorType) {
        loginView.setPasswordError(errorType);
        loginView.hideProgress();
    }

    @Override
    public void onError() {
        loginView.setError();
        loginView.hideProgress();
    }

    @Override
    public void onSuccess() {
        loginView.hideProgress();
        loginView.navigateToHome();
    }
}
