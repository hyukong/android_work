package com.example.layoutclasswork;

public class Friend {
    private int avatarResId;
    private String name;
    private String content;
    private String time;

    public Friend(int avatarResId, String name, String content, String time) {
        this.avatarResId = avatarResId;
        this.name = name;
        this.content = content;
        this.time = time;
    }

    public int getAvatarResId() {
        return avatarResId;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }
}

