package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText mUsername;
    private EditText mPassword;
    private Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // nap view giao dien
        setContentView(R.layout.activity_login);
        // xu ly dang nhap
        login();
    }
    private void login(){
        mUsername = findViewById(R.id.username); // tim ra duoc EditText de nhap username
        mPassword = findViewById(R.id.password);
        btnSubmit = findViewById(R.id.submit);
        // bat su kien khi nguoi touch(click) vao button submit
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lay gia tri username va password nguoi dung da nhap
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();
                // kiem tra xem nguoi dung co nhap lieu hay khong?
                if(TextUtils.isEmpty(username)){
                    mUsername.setError("Username cannot be empty");
                    return;
                }
                if(TextUtils.isEmpty(password)){
                    mPassword.setError("Password cannot be empty");
                    return;
                }
                if(username.equals("tamnn08") && password.equals("12345")){
                    // dang nhap thanh cong
                    // cho vao trang Main Activity
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();

                }else {
                    // dang nhap ko thanh cong
                    mUsername.setError("Username or Password invalid");
                }

            }
        });
    }
}
