package com.intruders.kisho.studentbuddy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.intruders.kisho.studentbuddy.utils.LoginRegister;

public class RegisterActivity extends AppCompatActivity {
EditText username,password,email,mobile;
    Button btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        email = (EditText)findViewById(R.id.email);
        mobile = (EditText)findViewById(R.id.mobile);

        btnRegister = (Button)findViewById(R.id.btn_register);
    }

    public void registerUser(View view){
        String method = "register";
        String Username = username.getText().toString();
        String Password = password.getText().toString();
        String Email = email.getText().toString();
        String Mobile = mobile.getText().toString();
        LoginRegister background = new LoginRegister(this);
        background.execute(method,Username,Password,Email,Mobile);


        Intent i = new Intent(this,SignUpActivity.class);
        startActivity(i);
    }
}
