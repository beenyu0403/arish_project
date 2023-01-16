package com.example.loginlogin;
import android.media.Image;
public class Product {
    String Name;
    String Cost;
    String Notification;
    int Pic;

    public Product(int pic) {
        Pic = pic;
    }

    public int getPic(){
        return Pic;
    }
    public void setPic(int pic){
        Pic = pic;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getCost() {
        return Cost;
    }

    public void setCost(String cost) {
        Cost = cost;
    }

    public String getNotification() {
        return Notification;
    }

    public void setNotification(String notification) {
        Notification = notification;
    }
}
