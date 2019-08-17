package com.example.ordernow.Activitys;

public class Images {

    private String description, url;


    public Images(){

    }

    public Images(String description, String url){
        this.description = description;
        this.url = url;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
