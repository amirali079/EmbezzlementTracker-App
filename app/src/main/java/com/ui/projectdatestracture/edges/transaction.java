package com.ui.projectdatestracture.edges;


import com.ui.projectdatestracture.nodes.bankAccount;

public class transaction extends edge{

    private bankAccount from;
    private bankAccount to;
    private String tmieTransaction;
    private String numberTransaction;
    private String priceTransaction;

    public transaction(bankAccount originAccount, bankAccount destinationAccount, String tmieTransaction, String numberTransaction, String priceTransaction) {
        this.from = originAccount;
        this.to = destinationAccount;
        this.tmieTransaction = tmieTransaction;
        this.numberTransaction = numberTransaction;
        this.priceTransaction = priceTransaction;
    }
    public transaction(String numberTransaction) {
        this.numberTransaction = numberTransaction;
    }
    public transaction(bankAccount from, bankAccount to) {
        this.from = from;
        this.to = to;
    }

    public transaction(String tmieTransaction, String numberTransaction, String priceTransaction) {
        this.tmieTransaction = tmieTransaction;
        this.numberTransaction = numberTransaction;
        this.priceTransaction = priceTransaction;
    }

    @Override
    public void setKey(String key){
        this.numberTransaction = key;
    }
    @Override
    public String getKey(){ return this.numberTransaction;}

    @Override
    public void setFrom(Object from){
        this.from = (bankAccount) from;
    }
    @Override
    public Object getFrom(){ return from;}

    @Override
    public void setTo(Object to){
        this.to = (bankAccount) to;
    }
    @Override
    public Object getTo(){ return to;}

    public String getTmieTransaction() {
        return tmieTransaction;
    }
    public void setTmieTransaction(String tmieTransaction) {
        this.tmieTransaction = tmieTransaction;
    }

    public String getNumberTransaction() {
        return numberTransaction;
    }
    public void setNumberTransaction(String numberTransaction) {
        this.numberTransaction = numberTransaction;
    }

    public String getPriceTransaction() {
        return priceTransaction;
    }
    public void setPriceTransaction(String priceTransaction) {
        this.priceTransaction = priceTransaction;
    }
}
