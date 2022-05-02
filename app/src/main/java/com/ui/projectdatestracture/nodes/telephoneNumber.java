package com.ui.projectdatestracture.nodes;


import com.ui.projectdatestracture.edges.*;

import java.util.HashMap;
import java.util.Map;

public class telephoneNumber extends node{

    private String meliCode;
    private String simcartNumber;
    private String operatorName;
    private Map<String, contact> co = new HashMap<String,contact>();

    public void addContact(contact contact){co.put(contact.getKey(),contact);}
    public contact getContact(String key){return co.get(key);}
    public Map<String, contact> getCo() {
        return co;
    }

    public telephoneNumber(String meliCode, String simcartNumber, String operatorName) {
        this.meliCode = meliCode;
        this.simcartNumber = simcartNumber;
        this.operatorName = operatorName;
    }
    public telephoneNumber(String simcartNumber) {
        this.simcartNumber = simcartNumber;
    }
    public telephoneNumber(String meliCode, String simcartNumber, String operatorName, Map<String, contact> co) {
        this.meliCode = meliCode;
        this.simcartNumber = simcartNumber;
        this.operatorName = operatorName;
        this.co = co;
    }

    @Override
    public void setKey(String key){
        this.simcartNumber = key;
    }
    @Override
    public String getKey(){ return this.simcartNumber;}

    public String getMeliCode() {
        return meliCode;
    }
    public void setMeliCode(String meliCode) {
        this.meliCode = meliCode;
    }

    public String getSimcartNumber() {
        return simcartNumber;
    }
    public void setSimcartNumber(String simcartNumber) {
        this.simcartNumber = simcartNumber;
    }

    public String getOperatorName() {
        return operatorName;
    }
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
