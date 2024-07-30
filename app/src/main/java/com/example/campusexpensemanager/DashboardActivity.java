package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DashboardActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        TextView tvID = findViewById(R.id.tvID);
        TextView tvUsername = findViewById(R.id.tvUsername);
        TextView tvEmail = findViewById(R.id.tvEmail);
        TextView tvPhone = findViewById(R.id.tvPhone);
        TextView tvJob = findViewById(R.id.tvJob);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        if (bundle != null){
            int id = bundle.getInt("USER_ID",0);
            String username = bundle.getString("USERNAME", "");
            String email = bundle.getString("EMAIL", "");
            String phone = bundle.getString("USER_PHONE", "" );
            String job  = bundle.getString("USER_JOB", "");
            tvID.setText(String.format("%d", id));
            tvUsername.setText(username);
            tvEmail.setText(email);
            tvPhone.setText(phone);
            tvJob.setText(job);
        }
    }
}
