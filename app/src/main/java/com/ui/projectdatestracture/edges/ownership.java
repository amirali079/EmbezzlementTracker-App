package com.ui.projectdatestracture.edges;



import com.ui.projectdatestracture.nodes.*;

public class ownership extends edge{

    private person from;
    private mamlok to;
    private String documentNumber;
    private String time;
    private String price;

    public ownership(person person, mamlok momlok, String documentNumber, String time, String price) {
        this.from = person;
        this.to = momlok;
        this.documentNumber = documentNumber;
        this.time = time;
        this.price = price;
    }

    public ownership(String documentNumber, String time, String price) {
        this.documentNumber = documentNumber;
        this.time = time;
        this.price = price;
    }

    public ownership(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    public ownership(person from, mamlok to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void setKey(String key){
        this.documentNumber = key;
    }
    @Override
    public String getKey(){ return this.documentNumber;}

    @Override
    public void setFrom(Object from){
        this.from = (person) from;
    }
    @Override
    public Object getFrom(){ return from;}

    @Override
    public void setTo(Object to){
        this.to = (mamlok) to;
    }
    @Override
    public Object getTo(){ return to;}

    public String getDocumentNumber() {
        return documentNumber;
    }
    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public String getPrice() {
        return price;
    }
    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format(" %s %s %s",documentNumber,time,price);
    }
}
