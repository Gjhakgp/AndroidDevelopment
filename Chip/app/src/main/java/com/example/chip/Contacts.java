package com.example.chip;

public class Contacts {
    private String profileName;
    private int picId;

    public Contacts(String name,int picId){
        this.profileName=name;
        this.picId=picId;
    }
    public String getProfileName() {
        return profileName;
    }

    public int getPicId() {
        return picId;
    }
}
