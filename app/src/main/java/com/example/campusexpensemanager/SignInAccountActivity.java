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
import com.example.campusexpensemanager.Model.User;

public class SignInAccountActivity extends AppCompatActivity {
    private Button btnLogin, btnSignUp;
    private EditText edtUser, edtPassword;
    public UserDatabase userDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin_account);
        btnLogin =findViewById(R.id.btnLogin);
        btnSignUp =findViewById(R.id.btnRegister);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPass);
        userDatabase = new UserDatabase(SignInAccountActivity.this);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString().trim();
                String pass = edtPassword.getText().toString().trim();
                if (TextUtils.isEmpty(user)){
                    edtUser.setError("Username can be not empty");
                }
                if (TextUtils.isEmpty(pass)){
                    edtPassword.setError("Password can be not empty");
                    return;
                }
                User data = userDatabase.getInfoUser(user, pass);
                assert data != null;
                if (data.getEmail() != null && data.getId() > 0){
                    // thanh cong
                    String email = data.getEmail();
                    Toast.makeText(SignInAccountActivity.this, email,  Toast.LENGTH_LONG).show();
                } else {
                    // dang nhap linh tinh
                    Toast.makeText(SignInAccountActivity.this, "Account Invalid", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intent = new Intent(SignInAccountActivity.this, RegisterAccountActivity.class);
        startActivity(intent);
    }
});
    }
}
