package com.yeung.pauleetech.nice.MainPageLayout.Fragment.ReclviewHR;

public class Mission {            //一个任务类
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
