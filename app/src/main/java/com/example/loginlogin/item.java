package com.example.loginlogin;

public class item {
    private String title;
    private String img_url;


    public item(String title, String img) {
        this.title= title;
        this.img_url = img;

    }

    public String getTitle(){
        return title;
    }
    public String getImg_url() { return img_url; }


}


