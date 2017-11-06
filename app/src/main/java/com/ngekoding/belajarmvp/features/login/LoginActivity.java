package com.ngekoding.belajarmvp.features.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.ngekoding.belajarmvp.R;

public class LoginActivity extends AppCompatActivity implements LoginView {

    private EditText loginUsername, loginPassword;
    private Button loginButton;
    private ProgressBar loginProgress;
    private LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginUsername = (EditText) findViewById(R.id.et_login_username);
        loginPassword = (EditText) findViewById(R.id.et_login_password);
        loginButton = (Button) findViewById(R.id.btn_login);
        loginProgress = (ProgressBar) findViewById(R.id.pb_login);

        loginPresenter = new LoginPresenterImp(this);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.validateCredentials(loginUsername.getText().toString(), loginPassword.getText().toString());
            }
        });
    }

    @Override
    public void showProgress() {
        loginProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        loginProgress.setVisibility(View.GONE);
    }

    @Override
    public void setUsernameError(String errorType) {
        switch (errorType) {
            case "empty":
                loginUsername.setError(getString(R.string.error_login_username));
                break;
        }
    }

    @Override
    public void setPasswordError(String errorType) {
        switch (errorType) {
            case "empty":
                loginPassword.setError(getString(R.string.error_login_password));
                break;
        }
    }

    @Override
    public void setError() {
        Toast.makeText(this, "Incorrect username or password!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void navigateToHome() {
        Toast.makeText(this, "Login success! Go to home.", Toast.LENGTH_SHORT).show();
    }
}
