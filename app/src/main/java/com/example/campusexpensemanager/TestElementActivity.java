package com.example.campusexpensemanager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class TestElementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_element);
        // bat sk nguoi dung bam button
        Button myToast = findViewById(R.id.btnShowToast);
        myToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast("你好 IT0602 - Android Studio");
            }
        });
        Button myAlertDialog = findViewById(R.id.btn_alertDialog);
        myAlertDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAlertDialog("Dialog", "Do you want to exit");
            }
        });

    }
    private void showToast(String message){
        Toast.makeText(TestElementActivity.this, message, Toast.LENGTH_SHORT).show();
    }
    private void showAlertDialog(String title, String message){
        AlertDialog.Builder builder = new AlertDialog.Builder(TestElementActivity.this);
        builder.setTitle(title);
        builder.setMessage(message);
        // xu ly button Yes
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast(message);
            }
        });
        // xu ly button Cancel
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showToast("You cancel Action !");
            }
        });
        AlertDialog dialog = builder.create();
        dialog.setCancelable(false);
        dialog.show(); // hien thi alertdialog
    }
}
