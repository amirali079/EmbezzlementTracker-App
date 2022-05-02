package com.ui.projectdatestracture.edges;


import com.ui.projectdatestracture.nodes.telephoneNumber;

public class contact extends edge{

    private telephoneNumber from;
    private telephoneNumber to;
    private String phoneNumber;
    private String timeContact;
    private String duration;

    public contact(telephoneNumber originContact, telephoneNumber destinationContact, String phoneNumber, String timeContact, String duration) {
        this.from = originContact;
        this.to = destinationContact;
        this.phoneNumber = phoneNumber;
        this.timeContact = timeContact;
        this.duration = duration;
    }

    public contact(String phoneNumber, String timeContact, String duration) {
        this.phoneNumber = phoneNumber;
        this.timeContact = timeContact;
        this.duration = duration;
    }

    public contact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public contact(telephoneNumber from, telephoneNumber to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public void setKey(String key){
        this.phoneNumber = key;
    }
    @Override
    public String getKey(){ return this.phoneNumber;}

    @Override
    public void setFrom(Object from){
        this.from = (telephoneNumber) from;
    }
    @Override
    public Object getFrom(){ return from;}

    @Override
    public void setTo(Object to){
        this.to = (telephoneNumber) to;
    }
    @Override
    public Object getTo(){ return to;}

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getTimeContact() {
        return timeContact;
    }
    public void setTimeContact(String timeContact) {
        this.timeContact = timeContact;
    }

    public String getDuration() {
        return duration;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
}

