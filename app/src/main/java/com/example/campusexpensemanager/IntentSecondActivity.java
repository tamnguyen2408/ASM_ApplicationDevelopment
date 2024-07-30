package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButtonToggleGroup;

import org.w3c.dom.Text;

public class IntentSecondActivity  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_second);
        Button btnBackActivity = findViewById(R.id.btnBackActivity);
        TextView tvID = findViewById(R.id.tvID);
        TextView tvPhone = findViewById(R.id.tvPhone);
        TextView tvUrl = findViewById(R.id.tvUrl);
        // nhan du lieu ma tu activity khac truyen sang
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras(); // lay du lieu
        if (bundle != null){
            int id = bundle.getInt("ID", 0);
            String phone = bundle.getString("MY_PHONE", "");
            String url = bundle.getString("MY_URL", "");
            tvID.setText(String.format("%d", id));
            tvPhone.setText(phone);
            tvUrl.setText(url);
        }
        btnBackActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentSecondActivity.this, IntentFirstActivity.class);
                startActivity(intent);
            }
        });
    }
}
