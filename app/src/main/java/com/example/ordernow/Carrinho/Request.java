package com.example.ordernow.Carrinho;

import java.util.List;

public class Request {

    private String phone;
    private String name;
    private String mesa;
    private String total;
    private List<Order> foods;

    public Request() {
    }

    public Request(String phone, String name, String mesa, String total, List<Order> foods) {
        this.phone = phone;
        this.name = name;
        this.mesa = mesa;
        this.total = total;
        this.foods = foods;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Order> getFoods() {
        return foods;
    }

    public void setFoods(List<Order> foods) {
        this.foods = foods;
    }
}
