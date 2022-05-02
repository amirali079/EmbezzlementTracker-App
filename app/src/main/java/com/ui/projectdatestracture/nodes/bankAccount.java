package com.ui.projectdatestracture.nodes;

import com.ui.projectdatestracture.edges.*;
import java.util.HashMap;
import java.util.Map;


public class bankAccount extends node{

    private String meliCode;
    private String bankName;
    private String accountNumber;
    private String shabaNumber;
    private vasiat vaziat=vasiat.fALSE;

    private Map<String,transaction> trFrom = new HashMap<String,transaction>();
    private Map<String,transaction> trTo = new HashMap<String,transaction>();

    public Map<String, transaction> getTrFrom() {
        return trFrom;
    }
    public Map<String, transaction> getTrTo() {
        return trTo;
    }

    public vasiat getVaziat() {
        return vaziat;
    }
    public void setVaziat(vasiat vaziat) {
        this.vaziat = vaziat;
    }

    public void addTransactionFrom(transaction transaction){trFrom.put(transaction.getKey(),transaction);}
    public transaction getTransactionFrom(String key){return trFrom.get(key);}

    public void addTransactionTo(transaction transaction){trTo.put(transaction.getKey(),transaction);}
    public transaction getTransactionTo(String key){return trTo.get(key);}


    public bankAccount(String meliCode, String bankName, String accountNumber, String shabaNumber) {
        this.meliCode = meliCode;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.shabaNumber = shabaNumber;
    }
    public bankAccount(String shabaNumber) {
        this.shabaNumber = shabaNumber;
    }
    public bankAccount(String meliCode, String bankName, String accountNumber, String shabaNumber, Map<String, transaction> tr) {
        this.meliCode = meliCode;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.shabaNumber = shabaNumber;
        this.trFrom = tr;
    }

    @Override
    public void setKey(String key){
        this.shabaNumber = key;
    }
    @Override
    public String getKey(){ return this.shabaNumber;}

    public String getMeliCode() {
        return meliCode;
    }
    public void setMeliCode(String meliCode) {
        this.meliCode = meliCode;
    }

    public String getBankName() {
        return bankName;
    }
    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getShabaNumber() {
        return shabaNumber;
    }
    public void setShabaNumber(String shabaNumber) {
        this.shabaNumber = shabaNumber;
    }
}
