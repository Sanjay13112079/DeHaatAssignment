package com.dehaat.dehaatassignment.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dehaat.dehaatassignment.R;
import com.dehaat.dehaatassignment.navigation.AppNavigator;
import com.dehaat.dehaatassignment.SharedPrefUtils;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    EditText emailText;
    EditText passwordText;
    Button loginBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(checkIfUserIsAlredyLoggedIn())
        {
            AppNavigator.navigateTo(this, MainActivity.class,null);
            finish();
            return;
        }
        setContentView(R.layout.activity_login);
        initViews();
    }


    private boolean checkIfUserIsAlredyLoggedIn()
    {
        return SharedPrefUtils.contains("data");
    }


    private void initViews()
    {
        emailText=findViewById(R.id.email);
        passwordText=findViewById(R.id.password);
        loginBtn=findViewById(R.id.loginBtn);
        loginBtn.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId())
        {
            case R.id.loginBtn:{

                //validate email
                String email=emailText.getText().toString();
                if(TextUtils.isEmpty(email) || !Patterns.EMAIL_ADDRESS.matcher(email).matches())
                {
                    Toast.makeText(this,"email not valid",Toast.LENGTH_LONG).show();
                    return;
                }


                //validate password
                String password=passwordText.getText().toString();
                if(TextUtils.isEmpty(password) || !TextUtils.isDigitsOnly(password))
                {
                    Toast.makeText(this,"email not valid",Toast.LENGTH_LONG).show();
                    return;
                }


                //now both are valid then shoot the API for auth token

                 SharedPrefUtils.updatePreference("data","123");
                AppNavigator.navigateTo(this, MainActivity.class,null);
                finish();

            }
        }
    }
}
