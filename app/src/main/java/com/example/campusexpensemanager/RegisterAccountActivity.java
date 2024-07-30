package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.campusexpensemanager.DatabaseSQLite.UserDatabase;

public class RegisterAccountActivity extends AppCompatActivity {
    private EditText edtUsername, edtPassword, edtEmail, edtPhone;
    private Button btnSignUp;
    public UserDatabase userDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_account);
        edtUsername = findViewById(R.id.edtUserAccount);
        edtPassword = findViewById(R.id.edtPasswordAccount);
        edtEmail = findViewById(R.id.edtEmailAccount);
        edtPhone = findViewById(R.id.edtPhoneAccount);
        btnSignUp = findViewById(R.id.btnSignUp);
        userDatabase = new UserDatabase(RegisterAccountActivity.this);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
                //chuyen sang trang dang nhap
                Intent intent = new Intent(RegisterAccountActivity.this, SignInAccountActivity.class);
                startActivity(intent);
            }
        });
    }
    public void signUp(){
        String user = edtUsername.getText().toString().trim();
        String password = edtPassword.getText().toString().trim();
        String email = edtEmail.getText().toString().trim();
        String phone = edtPhone.getText().toString().trim();
        if (TextUtils.isEmpty(user)){
            edtUsername.setError("Username can be not empty");
            return;
        }
        if (TextUtils.isEmpty(password)){
            edtPassword.setError("Password can be not empty");
            return;
        }
        if (TextUtils.isEmpty(email)){
            edtEmail.setError("Email can be not empty");
            return;
        }
        if (TextUtils.isEmpty(phone)){
            edtPhone.setError("Phone can be not empty");
            return;
        }
        long insert = userDatabase.addNewUser(user, password, email, phone);
        if (insert == -1){
            // loi
            Toast.makeText(RegisterAccountActivity.this, "Insert Failure", Toast.LENGTH_LONG).show();
            return;
        } else {
            // Thanh cong
            Toast.makeText(RegisterAccountActivity.this, "Insert Successfully", Toast.LENGTH_LONG).show();

        }

    }
}
