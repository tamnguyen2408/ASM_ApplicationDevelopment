package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DemoActivity extends AppCompatActivity {
    private CheckBox Agree;
    private Button Submit;
    private RadioButton Age;
    private Button Confirm;
    private RadioButton radNormal, radGood, radVeryGood;
    private TextView tvDiaLog;
    CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            tvDiaLog = findViewById(R.id.tv_dialog);
            if(isChecked){
                tvDiaLog.setText("You choose : " + buttonView.getText());
            }
        }
    };
    private final String FlagTag = "DemoActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        Agree = findViewById(R.id.cb_agree); // tim ra checkbox
        Submit = findViewById(R.id.btn_submit); // khoa button submit
        Submit.setEnabled(false);
        Confirm = findViewById(R.id.btn_confirm); // tim ra button confirm
        Confirm.setEnabled(false); // khoa button confirm
        Age = findViewById(R.id.rad_age);
        Age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Confirm.setEnabled(true);
            }
        });
        Agree.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked){
                    Submit.setEnabled(true); // mo button
                    Log.i(FlagTag,"******** checkbox is checked");
                }else{
                    Submit.setEnabled(false); // dong button
                    Log.i(FlagTag,"******* checkbox is not checked");

                }

            }
        });
        Submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));
            }
        });
        radNormal = findViewById(R.id.rad_normal);
        radGood = findViewById(R.id.rad_good);
        radVeryGood = findViewById(R.id.rad_verygood);
        radNormal.setOnCheckedChangeListener(listenerRadio);
        radGood.setOnCheckedChangeListener(listenerRadio);
        radVeryGood.setOnCheckedChangeListener(listenerRadio);
    }
}
