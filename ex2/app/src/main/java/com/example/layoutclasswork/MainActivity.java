package com.example.layoutclasswork;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import com.example.layoutclasswork.Friend; // 根据实际包名和文件路径进行导入
import com.example.layoutclasswork.R; // 根据实际包名和文件路径进行导入

public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter customAdapter;
    private List<Friend> friendList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button log_button = (Button) findViewById(R.id.log);
        Button res_button = (Button) findViewById(R.id.res);

        log_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象，指定源Activity和目标Activity
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
// 启动目标Activity
                startActivity(intent);

            }
        });
        res_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 创建Intent对象，指定源Activity和目标Activity
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
// 启动目标Activity
                startActivity(intent);

            }
        });

    }

}
