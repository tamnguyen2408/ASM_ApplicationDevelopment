package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    private final String Tag = "FirstActivity";
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        findViewById(R.id.btn_start_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // chuyen sang Second Activity
                startActivity(new Intent(getApplicationContext(), SecondActivity.class));

            }
        });
        // ghi log kiem tra
        Log.i(Tag,"******** onCreate run ********");

        }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(Tag,"******* onStart run **********");
        Toast.makeText(this,"onStart run",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(Tag,"******** onResume run *******");
        Toast.makeText(this,"onResume run",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(Tag,"******** onPause run ******");
        Toast.makeText(this,"onPause run",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(Tag,"******* onStop run *********");
        Toast.makeText(this,"onStop run",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(Tag,"******* onRestart run *******");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(Tag,"******** onDestroy run **********");
    }
}


