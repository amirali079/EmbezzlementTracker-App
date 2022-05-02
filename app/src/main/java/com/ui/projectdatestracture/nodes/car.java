package com.ui.projectdatestracture.nodes;


public class car extends mamlok{

    private String pelak;
    private String meliCode;
    private String model;
    private String color;

    public car(String pelak, String meliCode, String model, String color) {
        this.pelak = pelak;
        this.meliCode = meliCode;
        this.model = model;
        this.color = color;
    }
    public car(String pelak) {
        this.pelak = pelak;
    }

    @Override
    public void setKey(String key){
        this.pelak = key;
    }
    @Override
    public String getKey(){ return this.pelak;}

    public String getPelak() {
        return pelak;
    }
    public void setPelak(String pelak) {
        this.pelak = pelak;
    }

    public String getMeliCode() {
        return meliCode;
    }
    public void setMeliCode(String meliCode) {
        this.meliCode = meliCode;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
