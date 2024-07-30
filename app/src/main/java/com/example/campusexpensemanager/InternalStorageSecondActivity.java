package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;

public class InternalStorageSecondActivity extends AppCompatActivity {
    private EditText edtMoneyView, edtExpenseView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage_second);
        edtMoneyView = findViewById(R.id.edtMoneyView);
        edtExpenseView = findViewById(R.id.edtExpenseView);

    }
    public void getData(View view){
        try{
            FileInputStream fileInputStream = openFileInput("asm.txt");
            int read = -1;
            StringBuilder builder = new StringBuilder();
            while ((read = fileInputStream.read()) != -1){
                builder.append((char)read);
            }
            String money = builder.substring(0, builder.indexOf("***"));
            String expense = builder.substring(builder.indexOf("***") +3);
            edtMoneyView.setText(money);
            edtExpenseView.setText(expense);
            Toast.makeText(this, "Get data successfully", Toast.LENGTH_SHORT).show();
        } catch (Exception ex)
        {
            ex.printStackTrace();
            Toast.makeText(this, "Get data Failure", Toast.LENGTH_SHORT).show();
        }
    }
    public void backPage(View view){
        Intent intent = new Intent(InternalStorageSecondActivity.this, InternalStorageActivity.class);
        startActivity(intent);
    }
}
