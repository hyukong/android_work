package com.example.layoutclasswork;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText usernameEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Button log_button = (Button) findViewById(R.id.toindex);
        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();

                // 创建Intent对象，指定源Activity和目标Activity
                Intent intent = new Intent(LoginActivity.this, ListChat.class);
// 启动目标Activity
                startActivity(intent);

            }
        });

        usernameEditText = findViewById(R.id.username);
        passwordEditText = findViewById(R.id.password);
    }

    public void handleLogin(View view) {
        String username = usernameEditText.getText().toString();
        String password = passwordEditText.getText().toString();

        // 这里可以添加验证用户名和密码的逻辑
        // 在此示例中，我们将简单地显示一个Toast消息以确认登录操作


    }

    public void goToRegister(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
    }
}
