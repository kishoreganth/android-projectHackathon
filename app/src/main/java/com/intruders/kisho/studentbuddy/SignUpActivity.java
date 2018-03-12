package com.intruders.kisho.studentbuddy;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.speech.tts.Voice;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.INotificationSideChannel;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.intruders.kisho.studentbuddy.utils.LoginRegister;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class SignUpActivity extends AppCompatActivity {
    Button btn_login;
    private TextInputLayout inputlayoutusername,inputlayoutpassword;
    private EditText mPassword,mUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        btn_login = (Button)findViewById(R.id.btn_login);
        inputlayoutusername = (TextInputLayout)findViewById(R.id.input_layout_username);
        inputlayoutpassword = (TextInputLayout)findViewById(R.id.input_layout_password);

        mPassword = (EditText)findViewById(R.id.password);
        mUsername = (EditText)findViewById(R.id.username);

        mUsername.addTextChangedListener(new MyTextWatcher(mUsername));
        mPassword.addTextChangedListener(new MyTextWatcher(mPassword));

        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        if(networkInfo!=null && networkInfo.isConnected()){
            btn_login.setEnabled(true);
        }else{
            btn_login.setEnabled(false);
            Toast.makeText(getApplicationContext(),"Network is off !",Toast.LENGTH_LONG).show();

        }


    }

    public void login(View view){

        String method ="login";

        String Username = mUsername.getText().toString();
        String Password = mPassword.getText().toString();

        LoginRegister backgrounTask = new LoginRegister(this);
        backgrounTask.execute(method,Username,Password);



    }

    public void register(View view){
        Intent i = new Intent(SignUpActivity.this,RegisterActivity.class);
        startActivity(i);
    }

    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }


        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.username:

                    break;
                case R.id.password:
                    break;


            }
        }
    }

}
