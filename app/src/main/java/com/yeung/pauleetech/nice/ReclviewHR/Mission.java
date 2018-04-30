package com.yeung.pauleetech.nice.ReclviewHR;

public class Mission {
    private String name;
    private int imageId;

    public Mission(String name, int imageId){
        this.name=name;
        this.imageId=imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
