package com.example.campusexpensemanager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DemoActivity2 extends AppCompatActivity {
    private RadioButton rad5, rad6, rad7, rad8;
    private TextView tvDialog;
    private Button btnCheck;
    private RadioGroup radioGroup;
    private boolean isAnswerCorrect = false; // Biến để kiểm tra xem đáp án có đúng không

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homework1);

        radioGroup = findViewById(R.id.rad_group1);
        rad5 = findViewById(R.id.rad5);
        rad6 = findViewById(R.id.rad6);
        rad7 = findViewById(R.id.rad7);
        rad8 = findViewById(R.id.rad8);
        btnCheck = findViewById(R.id.btn_check1);
        tvDialog = findViewById(R.id.tv_dialog1);

        // Gán sự kiện cho các RadioButton
        rad5.setOnCheckedChangeListener(listenerRadio);
        rad6.setOnCheckedChangeListener(listenerRadio);
        rad7.setOnCheckedChangeListener(listenerRadio);
        rad8.setOnCheckedChangeListener(listenerRadio);

        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId == -1) {
                    Toast.makeText(DemoActivity2.this, "Vui lòng chọn một đáp án", Toast.LENGTH_SHORT).show();
                } else {
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String answer = selectedRadioButton.getText().toString();
                    if (answer.equals("Con tim")) {
                        tvDialog.setText("Chính xác!");
                        isAnswerCorrect = true; // Đánh dấu đáp án đúng
                    } else {
                        tvDialog.setText("Sai rồi! Đáp án đúng là 'Con tim'");
                        isAnswerCorrect = false; // Đánh dấu đáp án sai
                    }
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
        // Cập nhật lại trạng thái của biến isAnswerCorrect khi quay lại DemoActivity1
        if (isAnswerCorrect) {
            // Nếu đáp án trước đó là đúng, cho phép nút "Câu tiếp theo" ở DemoActivity1
            ((DemoActivity1) getParent()).enableNextButton();
        }
    }
}
