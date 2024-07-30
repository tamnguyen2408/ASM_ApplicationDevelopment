package com.example.campusexpensemanager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class InternalStorageActivity extends AppCompatActivity {
    private EditText edtMoney, edtExpense;
//    private Button btnSave, btnNext;
    private TextView tvPathFile;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internal_storage);
        edtMoney = findViewById(R.id.edtMoney);
        edtExpense = findViewById(R.id.edtExpense);
        tvPathFile = findViewById(R.id.tvPathFile);
    }
    public void saveData(View view) throws IOException {
        // xu ly luu du lieu vao internal storage
        // luu 1 file vao trong do
        String money = edtMoney.getText().toString().trim();
        String name = edtExpense.getText().toString().trim();
        File file = null;
        FileOutputStream fileOuputStream = null;
        try {
            // xu ly luu file
            money = money + "***";
            file = getFilesDir(); // lay ra thu muc noi chua file
            fileOuputStream = openFileOutput("asm.txt", Context.MODE_PRIVATE);
            fileOuputStream.write(money.getBytes());
            fileOuputStream.write(name.getBytes());
            edtMoney.setText("");
            edtExpense.setText("");
            tvPathFile.setText("");
            String myFile = "Path: " + file + "\\asm.txt";
            tvPathFile.setText(myFile);

        } catch (Exception ex){
            ex.printStackTrace();

        }finally {
            assert fileOuputStream != null;
            fileOuputStream.close();

        }
    }
    public void nextData(View view){
        Intent intent = new Intent(InternalStorageActivity.this, InternalStorageSecondActivity.class);
        startActivity(intent);
    }
}
