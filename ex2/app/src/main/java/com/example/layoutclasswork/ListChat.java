package com.example.layoutclasswork;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class ListChat extends AppCompatActivity {
    private ListView listView;
    private CustomAdapter customAdapter;
    private List<Friend> friendList;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_item);
        // 初始化数据源
        friendList = generateFriendList();

        // 初始化 ListView
//        RelativeLayout relativeLayout = findViewById(R.id.relativeLayout);
        listView = findViewById(R.id.listView);
        customAdapter = new CustomAdapter(friendList, this);
//        listView.setAdapter(customAdapter);

        if (listView != null) {
            // 调用 setAdapter() 方法
            listView.setAdapter(customAdapter);
        }
    }
    private List<Friend> generateFriendList() {
        List<Friend> friendList = new ArrayList<>();
        // 添加 Friend 对象到列表
        friendList.add(new Friend(R.drawable.head1, "Alice", "Hello!", "09:30 AM"));
        friendList.add(new Friend(R.drawable.head2, "Bob", "How are you?", "10:15 AM"));
        friendList.add(new Friend(R.drawable.head7, "zzx", "go!", "13:20 AM"));
        friendList.add(new Friend(R.drawable.head4, "lmj", "what?", "14:20 AM"));
        friendList.add(new Friend(R.drawable.head5, "hxc", "[图片]", "16:20 AM"));
        friendList.add(new Friend(R.drawable.head6, "mdl", "9.9 for new!", "21:20 AM"));
        friendList.add(new Friend(R.drawable.head8, "文件传输助手", "[文件]", "23:20 AM"));
        friendList.add(new Friend(R.drawable.head3, "Charlie", "Nice to meet you!", "23:30 AM"));




        // ...
        return friendList;
    }


}
