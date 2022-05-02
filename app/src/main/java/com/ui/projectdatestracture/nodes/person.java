package com.ui.projectdatestracture.nodes;


import com.ui.projectdatestracture.edges.*;

import java.util.HashMap;
import java.util.Map;

public class person extends node{

    private String name;
    private String family;
    private String meliCode;
    private String birthdayDate;
    private String birthdayPlace;
    private String workPlace;
    private Map<String,relationship> rf = new HashMap<String,relationship>();
    private Map<String,relationship> rt = new HashMap<String,relationship>();
    private Map<String, ownership> os = new HashMap<String,ownership>();
    private Map<String,bankAccount> ac = new HashMap<String,bankAccount>();
    private Map<String,telephoneNumber> tl = new HashMap<String,telephoneNumber>();

    public Map<String, telephoneNumber> getTl() { return tl; }

    public Map<String, bankAccount> getAc() {
        return ac;
    }

    public void addRelationFrom(relationship person){rf.put(person.getKey(),person);}
    public relationship getRelationFrom(String key){return rf.get(key);}

    public void addRelationTo(relationship person){rt.put(person.getKey(),person);}
    public relationship getRelationTo(String key){return rt.get(key);}

    public void addOwnership(ownership ownership){os.put(ownership.getKey(),ownership);}
    public ownership getOwnership(String key){return os.get(key);}

    public void addAccount(bankAccount bankAccount){ac.put(bankAccount.getKey(),bankAccount);}
    public bankAccount getAccount(String key){return ac.get(key);}

    public void addTelephne(telephoneNumber telephoneNumber){tl.put(telephoneNumber.getKey(),telephoneNumber);}
    public telephoneNumber getTelephone(String key){return tl.get(key);}

    public person(String name, String family, String meliCode, String birthdayDate, String birthdayPlace, String workPlace) {
        this.name = name;
        this.family = family;
        this.meliCode = meliCode;
        this.birthdayDate = birthdayDate;
        this.birthdayPlace = birthdayPlace;
        this.workPlace = workPlace;
    }

    public person(String name, String meliCode, String workPlace) {
        this.name = name;
        this.meliCode = meliCode;
        this.workPlace = workPlace;
    }

    public person(String meliCode) {
        this.meliCode = meliCode;
    }
    public person(String name, String family, String meliCode, String birthdayDate, String birthdayPlace, String workPlace, Map<String, relationship> rf, Map<String, relationship> rt, Map<String, ownership> os, Map<String, bankAccount> ac, Map<String, telephoneNumber> tl) {
        this.name = name;
        this.family = family;
        this.meliCode = meliCode;
        this.birthdayDate = birthdayDate;
        this.birthdayPlace = birthdayPlace;
        this.workPlace = workPlace;
        this.rf = rf;
        this.rt = rt;
        this.os = os;
        this.ac = ac;
        this.tl = tl;
    }

    public Map<String, relationship> getRt() {
        return rt;
    }

    @Override
    public void setKey(String key){
        this.meliCode = key;
    }
    @Override
    public String getKey(){ return this.meliCode;}

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFamily() {
        return family;
    }
    public void setFamily(String family) {
        this.family = family;
    }

    public String getMeliCode() {
        return meliCode;
    }
    public void setMeliCode(String meliCode) {
        this.meliCode = meliCode;
    }

    public String getBirthdayDate() {
        return birthdayDate;
    }
    public void setBirthdayDate(String birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public Map<String,ownership> getOs() {
        return os;
    }

    public String getBirthdayPlace() {
        return birthdayPlace;
    }
    public void setBirthdayPlace(String birthdayPlace) {
        this.birthdayPlace = birthdayPlace;
    }

    public String getWorkPlace() {
        return workPlace;
    }
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %s %s ",name,family,meliCode,birthdayDate,birthdayPlace,workPlace);
    }
}
