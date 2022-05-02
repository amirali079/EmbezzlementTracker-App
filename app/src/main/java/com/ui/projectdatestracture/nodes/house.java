package com.ui.projectdatestracture.nodes;

public class house extends mamlok{

    private String meliCode;
    private String price;
    private String postCode;
    private String area;
    private String address;

    public house(String meliCode, String price, String postCode, String area, String address) {
        this.meliCode = meliCode;
        this.price = price;
        this.postCode = postCode;
        this.area = area;
        this.address = address;
    }
    public house(String postCode) {
        this.postCode = postCode;
    }

    @Override
    public void setKey(String key){
        this.postCode = key;
    }
    @Override
    public String getKey(){ return this.postCode;}

    public String getMeliCode() {
        return meliCode;
    }
    public void setMeliCode(String meliCode) {
        this.meliCode = meliCode;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    public String getPostCode() {
        return postCode;
    }
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getArea() {
        return area;
    }
    public void setArea(String area) {
        this.area = area;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
