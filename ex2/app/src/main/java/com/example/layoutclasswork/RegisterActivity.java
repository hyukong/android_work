package com.example.layoutclasswork;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class RegisterActivity extends AppCompatActivity {
    private EditText etDate;
    private String gender = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.res);
        etDate = findViewById(R.id.etDate);
        Button sub=(Button) findViewById(R.id.sub);
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                EditText passwordEditText = findViewById(R.id.passwordEditText);
                EditText confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText);
                RadioGroup genderRadioGroup = findViewById(R.id.genderRadioGroup);
                EditText dateEditText = findViewById(R.id.etDate);

                String password = passwordEditText.getText().toString();
                String confirmPassword = confirmPasswordEditText.getText().toString();
                int checkedRadioButtonId = genderRadioGroup.getCheckedRadioButtonId();
                RadioButton checkedRadioButton = findViewById(checkedRadioButtonId);

// 密码匹配
                if (!password.equals(confirmPassword)) {
                    Toast.makeText(getApplicationContext(), "密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                }

// 性别选择
                if (checkedRadioButtonId == -1) {
                    Toast.makeText(RegisterActivity.this, "请选择性别", Toast.LENGTH_SHORT).show();
                    return;
                }

// 日期选择
                String dateString = dateEditText.getText().toString();
                if (TextUtils.isEmpty(dateString)) {
                    Toast.makeText(RegisterActivity.this, "请输入日期", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    try {
                        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
                        if (!dateString.trim().isEmpty()) {
                            dateFormat.setLenient(false);
                            Date date = dateFormat.parse(dateString);
                        } else {
                            Toast.makeText(RegisterActivity.this, "请输入日期", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    } catch (ParseException e) {
                        Toast.makeText(RegisterActivity.this, "日期格式错误", Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        return;
                    }
                }
                // 执行注册操作
//                // TODO: 在这里编写注册操作的逻辑
//                // 注册成功后跳转到登录界面
                String gender = checkedRadioButton.getText().toString();
                Intent intent = new Intent(RegisterActivity.this, ListChat.class);
                startActivity(intent);
            }
        });

        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePicker();
            }
        });

        etDate.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    showDatePicker();
                    return true;
                }
                return false;
            }
        });
    }
    private void showDatePicker() {
        // 隐藏键盘
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(etDate.getWindowToken(), 0);

        // 显示日期选择对话框
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(RegisterActivity.this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        String dateString = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        etDate.setText(dateString);
                    }
                }, year, month, day);
        datePickerDialog.show();
    }
}