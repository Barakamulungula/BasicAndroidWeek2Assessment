package com.example.rodneytressler.week2assessment;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * BARAKA MULUNGULA*/

public class MainActivity extends AppCompatActivity {

    public final static String USER_INFO = "user";
    @BindView(R.id.input_name)
    protected EditText inputName;
    @BindView(R.id.input_email)
    protected EditText inputEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    private void toastRegistrationFailure() {
        Toast.makeText(this, getString(R.string.input_check), Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.button_register)
    protected void buttonRegisterClicked() {
        WelcomeFragment welcomeFragment = WelcomeFragment.newInstance();
        if (!inputName.getText().toString().isEmpty() && !inputEmail.getText().toString().isEmpty()) {
            Account account = new Account(inputName.getText().toString(), inputEmail.getText().toString());
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_holder, welcomeFragment).commit();
            Bundle bundle = new Bundle();
            bundle.putParcelable(USER_INFO, account);
            welcomeFragment.setArguments(bundle);
        } else {
            toastRegistrationFailure();
        }

    }
}
