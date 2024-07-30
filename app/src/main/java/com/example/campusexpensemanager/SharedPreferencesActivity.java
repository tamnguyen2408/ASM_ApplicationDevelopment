package com.example.campusexpensemanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SharedPreferencesActivity  extends AppCompatActivity {
    private EditText edtNumber1, edtNumber2, edtResult;
    private Button btnPlus, btnClearData;
    private TextView tvHistory;
    private String history = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);
        edtNumber1 = findViewById(R.id.edtNumber1);
        edtNumber2 = findViewById(R.id.edtNumber2);
        edtResult = findViewById(R.id.edtResult);
        btnPlus = findViewById(R.id.btnPlus);
        btnClearData = findViewById(R.id.btnClearData);
        tvHistory = findViewById(R.id.tvHistory);
        edtResult.setEnabled(false);
        // lay du lieu tu SharedPreferences
        SharedPreferences myPrefs = getSharedPreferences("myMath", MODE_PRIVATE);
        history = myPrefs.getString("myHistoryMath", "");
        tvHistory.setText(history);
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number1 = Integer.parseInt(edtNumber1.getText().toString().trim());
                int number2 = Integer.parseInt(edtNumber2.getText().toString().trim());
                int result = number1 + number2;
                edtResult.setText(String.format("%d", result));
                history += number1 + " + " + number2 + " = " + result;
                tvHistory.setText(history);
                history += "\n";
            }
        });
        btnClearData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                history = "";
                tvHistory.setText(history);
                edtNumber1.setText(history);
                edtNumber2.setText(history);
                edtResult.setText(history);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        // SharedPreferences : luu duoi dang 1 file .xml(myHistoryMath.xml)
        SharedPreferences myPrefs = getSharedPreferences("myMath", MODE_PRIVATE);
        SharedPreferences.Editor myEditer = myPrefs.edit();
        myEditer.putString("myHistoryMath", history);
        myEditer.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences myPrefs = getSharedPreferences("myMath", MODE_PRIVATE);
        String dataPrefs = myPrefs.getString("myHistoryMath", "");
        if (TextUtils.isEmpty(dataPrefs)){
            // luu lai vao SharedPreferences
            SharedPreferences.Editor myEditor = myPrefs.edit();
            myEditor.putString("myHistoryMath", history);
            myEditor.apply();
        }
    }
}


