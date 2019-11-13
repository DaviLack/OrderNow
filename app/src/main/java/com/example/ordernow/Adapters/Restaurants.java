package com.example.ordernow.Adapters;

public class Restaurants {

    private String especialidade, imgrest ,nomer, nota, restid;


    public Restaurants(){

    }

    public Restaurants(String especialidade, String imgrest){
        this.especialidade = especialidade;
        this.imgrest = imgrest;
        this.nomer = nomer;
        this.nota = nota;
        this.restid = restid;

    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getNomer() {
        return nomer;
    }

    public void setNomer(String nomer) {
        this.nomer = nomer;
    }

    public String getImgrest() { return imgrest;}

    public void setImgrest(String imgrest) { this.imgrest = imgrest; }

    public String getNota() {return nota;}

    public void setNota(String nota){this.nota = nota;}

    public String getRestid(){return restid;}

    public void setRestid(String restid){this.restid = restid;}

}
