package com.example.campusexpensemanager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DemoActivity1 extends AppCompatActivity {
    private RadioButton rad1, rad2, rad3, rad4;
    private TextView tvDialog;
    private Button btnCheck, btnNext;
    private RadioGroup radioGroup;
    private boolean isAnswerCorrect = false; // Biến để kiểm tra xem đáp án có đúng không

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework);

        radioGroup = findViewById(R.id.rad_group);
        rad1 = findViewById(R.id.rad1);
        rad2 = findViewById(R.id.rad2);
        rad3 = findViewById(R.id.rad3);
        rad4 = findViewById(R.id.rad4);
        btnCheck = findViewById(R.id.btn_check);
        btnNext = findViewById(R.id.btn_next);
        tvDialog = findViewById(R.id.tv_dialog);

        // Gán sự kiện cho các RadioButton
        rad1.setOnCheckedChangeListener(listenerRadio);
        rad2.setOnCheckedChangeListener(listenerRadio);
        rad3.setOnCheckedChangeListener(listenerRadio);
        rad4.setOnCheckedChangeListener(listenerRadio);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(DemoActivity1.this, "Vui lòng chọn một đáp án", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String answer = selectedRadioButton.getText().toString();
                    if (answer.equals("Miếng bọt biển")) {
                        tvDialog.setText("Chính xác!");
                        isAnswerCorrect = true; // Đánh dấu đáp án đúng
                        btnNext.setEnabled(true); // Enable the "Next" button if the answer is correct
                    } else {
                        tvDialog.setText("Sai rồi! Đáp án đúng là 'Miếng bọt biển'");
                        isAnswerCorrect = false; // Đánh dấu đáp án sai
                        btnNext.setEnabled(false); // Keep the "Next" button disabled if the answer is incorrect
                    }
                }
            }
        });

        // Xử lý sự kiện cho nút "Câu tiếp theo"
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnswerCorrect) { // Chỉ cho phép chuyển sang DemoActivity2 nếu đáp án đúng
                    Intent intent = new Intent(DemoActivity1.this, DemoActivity2.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(DemoActivity1.this, "Vui lòng kiểm tra đáp án trước khi chuyển tiếp", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    CompoundButton.OnCheckedChangeListener listenerRadio = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if (isChecked) {
                tvDialog.setText("Bạn chọn đáp án: " + buttonView.getText());
            }
        }
    };
    @Override
    protected void onResume() {
        super.onResume();
        // Reset lại trạng thái của biến isAnswerCorrect khi quay lại DemoActivity1
        isAnswerCorrect = false;
    }

    // Phương thức này để cho phép kích hoạt nút "Câu tiếp theo" khi đáp án đúng
    public void enableNextButton() {
        btnNext.setEnabled(true);
    }
}
