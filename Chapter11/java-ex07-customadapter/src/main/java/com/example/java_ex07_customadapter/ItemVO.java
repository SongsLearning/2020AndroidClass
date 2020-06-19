package com.example.java_ex07_customadapter;

// data 저장하기 위한 클래스
public class ItemVO {
    String typeStr;
    String title;
    String contentsStr;

    public void setTypeStr(String typeStr) {
        this.typeStr = typeStr;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContentsStr(String contentsStr) {
        this.contentsStr = contentsStr;
    }

    public String getTypeStr() {
        return typeStr;
    }

    public String getTitle() {
        return title;
    }

    public String getContentsStr() {
        return contentsStr;
    }

    public ItemVO(String typeStr, String title, String contentsStr) {
        this.typeStr = typeStr;
        this.title = title;
        this.contentsStr = contentsStr;
    }
}
