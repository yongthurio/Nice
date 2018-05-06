package com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewVT;

public class Commodity {                       //一个商品类
    private String name;
    private int imageId;

    public Commodity(String name, int imageId){
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