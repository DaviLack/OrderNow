package com.example.ordernow.Usuarios;

public class User {

    private String id;
    private String username;
    private String imageURL;
    private String ddd;
    private String cell;

    public User(String id, String username, String imageURL, String ddd, String cell) {
        this.id = id;
        this.username = username;
        this.imageURL = imageURL;
        this.ddd = ddd;
        this.cell = cell;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getCell() {
        return cell;
    }

    public void setCell(String cell) {
        this.cell = cell;
    }

    public User(){


    }


}
