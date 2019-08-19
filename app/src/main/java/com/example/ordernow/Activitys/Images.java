package com.example.ordernow.Activitys;

public class Images {

    private String description, url, preco, nome;


    public Images(){

    }

    public Images(String description, String url){
        this.description = description;
        this.url = url;
        this.preco = preco;
        this.nome = nome;

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

    public String getPreco() {return preco;}

    public void setPreco(String preco){this.preco = preco;}

    public String getNome(){return nome;}

    public void setNome(String nome){this.nome = nome;}
}
