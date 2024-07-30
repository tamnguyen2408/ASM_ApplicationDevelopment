package com.example.campusexpensemanager;

import static android.Manifest.permission.CALL_PHONE;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

public class IntentFirstActivity extends AppCompatActivity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_first);
        EditText edtUrl = findViewById(R.id.edtUrl);
        Button btnUrl = findViewById(R.id.btnUrl);
        EditText edtPhone = findViewById(R.id.edtPhone);
        Button btnCall = findViewById(R.id.btnCall);
        Button btnGotoActivity = findViewById(R.id.btnGotoActivity);
        Button btnSendData = findViewById(R.id.btnSendData);
        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String myUrl = edtUrl.getText().toString().trim();
                String myPhone = edtPhone.getText().toString().trim();
                // gui du lieu nay sang cac Activity khac
                Intent intent = new Intent(IntentFirstActivity.this, IntentSecondActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("MY_URL", myUrl);
                bundle.putString("MY_PHONE", myPhone);
                bundle.putInt("ID", 1);
                bundle.putBoolean("CHECKING", true);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
        btnGotoActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(IntentFirstActivity.this, IntentSecondActivity.class);
                startActivity(intent);
            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phone = edtPhone.getText().toString().trim();
                if (TextUtils.isEmpty(phone)) {
                    edtPhone.setError("Enter phone number, please");
                } else {
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:"+ phone));
                    if(ContextCompat.checkSelfPermission(getApplicationContext(), CALL_PHONE) == PackageManager.PERMISSION_GRANTED){
                        startActivity(intent);

                    } else {
                        requestPermissions(new String[]{CALL_PHONE},1);

                    }
                }
            }
        });
        btnUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = edtUrl.getText().toString().trim();
                if (TextUtils.isEmpty(url)){
                    Toast.makeText(IntentFirstActivity.this, "Enter url", Toast.LENGTH_SHORT).show();
                }  else {
                    // load website from url
                    Intent intent = new Intent(Intent.ACTION_VIEW);
                    intent.setData(Uri.parse(url));
                    startActivity(intent);
                }
            }
        });


    }
}
