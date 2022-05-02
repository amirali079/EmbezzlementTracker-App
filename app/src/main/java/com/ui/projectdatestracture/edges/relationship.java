package com.ui.projectdatestracture.edges;


import com.ui.projectdatestracture.nodes.person;

public class relationship extends edge{

    private person from;
    private person to;
    private String relative;
    private String time;
    private String key;

    public relationship(person origin, person destination, String relative, String time) {
        this.from = origin;
        this.to = destination;
        this.relative = relative;
        this.time = time;
        this.key = origin.getMeliCode() + destination.getMeliCode();
    }
    public relationship(person from, person to) {
        this.from = from;
        this.to = to;
    }
    public relationship(){}

    @Override
    public void setKey(String key){
        this.key = from.getMeliCode() + to.getMeliCode();
    }
    @Override
    public String getKey(){ return this.key;}

    @Override
    public void setFrom(Object from){
        this.from = (person) from;
    }
    @Override
    public Object getFrom(){ return from;}

    @Override
    public void setTo(Object to){
        this.to = (person) to;
    }
    @Override
    public Object getTo(){ return to;}

    public String getRelative() {
        return relative;
    }
    public void setRelative(String relative) {
        this.relative = relative;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }
}
