package com.ui.projectdatestracture;
import com.ui.projectdatestracture.edges.*;
import com.ui.projectdatestracture.nodes.*;
import java.util.HashMap;

enum Enodes{ person,mamlok,telephoneNumber,bankAccount,ghachaghchi,maznun,maznon2,maznon3,maznon4}
enum Eedges{transaction,cantact,ownership,relationship}

public class graph {

    private HashMap<String,node> nodes = new HashMap<String,node>();
    //private HashMap<edge> edges = new HashMap<edge>();

    private HashMap<String,person> people = new HashMap<String,person>();
    private HashMap<String,bankAccount> accounts = new HashMap<String,bankAccount>();
    private HashMap<String,telephoneNumber> telephoneNumbers = new HashMap<String,telephoneNumber>();
    private HashMap<String,mamlok> mamlok = new HashMap<String,mamlok>();

    private HashMap<String,transaction> transactions = new HashMap<String,transaction>();
    private HashMap<String,contact> contacts = new HashMap<String, contact>();

    private HashMap<String,person> ghachaghchi= new HashMap<String,person>();
    private HashMap<String,person> maznonin = new HashMap<String,person>();
    private HashMap<String,person> maznunphasetwo =new HashMap<String,person>();
    private HashMap<String,person> maznunphasethree =new HashMap<String,person>();
    private HashMap<String,person> maznunphasefour =new HashMap<String,person>();


    public node getNode(int nodei){
        return nodes.get(nodei);
    }
    public void putNode(node node,Enodes type){nodes.put(node.getKey(),node);

        switch (type){
            case mamlok:mamlok.put(node.getKey(),(mamlok) node);
                break;
            case person:people.put(node.getKey(),(person)node);
                break;
            case bankAccount:accounts.put(node.getKey(),(bankAccount)node);
                break;
            case telephoneNumber:telephoneNumbers.put(node.getKey(),(telephoneNumber)node);
                break;
            case ghachaghchi:ghachaghchi.put(node.getKey(),(person)node);
                break;
            case maznun:maznonin.put(node.getKey(),(person)node);
                break;
            case maznon2:maznunphasetwo.put(node.getKey(),(person)node);
                break;
            case maznon3:maznunphasethree.put(node.getKey(),(person)node);
                break;
            case maznon4:maznunphasefour.put(node.getKey(),(person)node);
                break;
        }
    }

    public person getPerson(String key){return people.get(key);}
    public bankAccount getbankAccount(String key){return accounts.get(key);}
    public telephoneNumber gettelephoneNumber(String  key){return telephoneNumbers.get(key);}
    public mamlok getmamlok(String key){return mamlok.get(key);}

    public HashMap<String, person> getPeople() {
        return people;
    }
    public HashMap<String, bankAccount> getAccounts() { return accounts; }
    public HashMap<String, telephoneNumber> getTelephoneNumbers() {
        return telephoneNumbers;
    }
    public HashMap<String, mamlok> getMamlok() {
        return mamlok;
    }

    public void puttransaction(transaction t){ transactions.put(t.getKey(),t);}
    public transaction gettransaction(String key){return transactions.get(key);}
    public HashMap<String, transaction> getTransactions() {return transactions;}

    public void putcontact(contact t){ contacts.put(t.getKey(),t);}
    public contact getcontact(String key){return contacts.get(key);}
    public HashMap<String, contact> getContact() {return contacts;}

    public HashMap<String, person> getGhachaghchi() {
        return ghachaghchi;
    }

    public HashMap<String, person> getMaznonin() {
        return maznonin;
    }

    public HashMap<String, person> getMaznonin2(){
        return maznunphasetwo;
    }
    public person getMaznon2(String key){return maznunphasetwo.get(key);}
    public boolean iscontains2(String key){
        return maznunphasetwo.containsKey(key);
    }


    public HashMap<String, person> getMaznunphasethree() {
        return maznunphasethree;
    }
    public person getMaznon3(String key){return maznunphasethree.get(key);}
    public boolean iscontains3(String key){
        return maznunphasethree.containsKey(key);
    }

    public HashMap<String, person> getMaznonin4() {
        return maznunphasefour;
    }








//    public ownership getownership(int i){return ownerships.get(i);}
//    public relationship getrelationship(int i){return relationships.get(i);}
//    public contact getcontact(int i){return contacts.get(i);}
//    public transaction gettransaction(int i){return transactions.get(i);}


   /* public void putEdge(edge edge,Eedges type){edges.put(edge);
        switch (type){
            case cantact:contacts.put((contact)edge);
            break;
            case ownership:ownerships.put((ownership)edge);
            break;
            case transaction:transactions.put((transaction)edge);
            break;
            case relationship:relationships.put((relationship)edge);
            break;

        }
    }
    public edge getEdge(int edgei){ return edges.get(edgei);}*/

}
