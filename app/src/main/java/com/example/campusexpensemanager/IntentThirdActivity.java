package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class IntentThirdActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_third);
        Button btnLogin = findViewById(R.id.btnLogin);
        EditText edtUsername = findViewById(R.id.edtUsername);
        EditText edtPassword = findViewById(R.id.edtPassword);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtUsername.getText().toString().trim();
                String password = edtPassword.getText().toString().trim();
                if (username.equals("admin") && password.equals("123")){
                    // chuyen sang dashboard
                    // truyen du lieu sang dashboard
                    Intent intent = new Intent(IntentThirdActivity.this, DashboardActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("USER_ID", 1);
                    bundle.putString("USERNAME", username );
                    bundle.putString("EMAIL", "tamnn08@gmail.com");
                    bundle.putString("USER_PHONE", "0327290190");
                    bundle.putString("USER_JOB", "Student");
                    intent.putExtras(bundle);
                    startActivity(intent);
                    finish();
                } else {
                    edtUsername.setError("Account invalid");
                }

            }
        });
    }
}
