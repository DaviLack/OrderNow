package com.example.ordernow.Carrinho;

import java.util.List;

public class Requests {
        private String name;
        private String total;
        private String codigo;
        private String phone;
        private String mesa;
        private List<Order> foods;


        public Requests(){
        }

    public Requests(String name, String total, String codigo, String phone, String mesa, List<Order> foods) {
        this.name = name;
        this.total = total;
        this.codigo = codigo;
        this.phone = phone;
        this.mesa = mesa;
        this.foods = foods;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
