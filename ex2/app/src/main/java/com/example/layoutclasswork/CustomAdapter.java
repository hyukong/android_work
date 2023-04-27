package com.example.layoutclasswork;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    private List<Friend> dataList;
    private Context context;

    public CustomAdapter(List<Friend> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 获取当前位置的数据
        Friend friend = dataList.get(position);

        // 判断 convertView 是否为空，为空时需要创建一个新的视图
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_item, parent, false);
        }

        // 根据 friend 对象设置视图的数据
        ImageView avatarImageView = convertView.findViewById(R.id.avatarImageView);
        TextView nameTextView = convertView.findViewById(R.id.nameTextView);
        TextView contentTextView = convertView.findViewById(R.id.contentTextView);
        TextView timeTextView = convertView.findViewById(R.id.timeTextView);

        // 设置头像、姓名、文本内容和时间的数据
        avatarImageView.setImageResource(friend.getAvatarResId());
        nameTextView.setText(friend.getName());
        contentTextView.setText(friend.getContent());
        timeTextView.setText(friend.getTime());
        return convertView;
    }

}

