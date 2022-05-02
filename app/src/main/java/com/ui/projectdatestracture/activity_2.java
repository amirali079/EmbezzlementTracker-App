package com.ui.projectdatestracture;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ui.projectdatestracture.edges.*;
import com.ui.projectdatestracture.nodes.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class activity_2 extends AppCompatActivity {

    int i = 0;
    static Scanner s;
    static graph g = new graph();
    static SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd ");
    static Calendar calendar = new GregorianCalendar();


    Button btn_1,btn_2,btn_3,btn_4,btn_info;

    public void init(){
        btn_1 = findViewById(R.id.btn_faze1);
        btn_2 = findViewById(R.id.btn_faze2);
        btn_3 = findViewById(R.id.btn_faze3);
        btn_4 = findViewById(R.id.btn_faze4);
        btn_info = findViewById(R.id.btn_info);
    }
    public void click(){

        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==0){
                input(); i++;}
                else{Toast.makeText(activity_2.this ,"اطلاعات خوانده شده لطفا مرحله بعدی را انجام دهید.",Toast.LENGTH_LONG).show();}
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==1){
                phaseTwo();
                startActivity(new Intent(activity_2.this, Activity_faze2.class)); i++;}
                else{ Toast.makeText(activity_2.this ,"ابتدا باید اطلاعات را دریافت کنید!",Toast.LENGTH_LONG).show(); }
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==2){
                phase3();
                startActivity(new Intent(activity_2.this, Activity_faze3.class)); i++;}
                else{ Toast.makeText(activity_2.this ,"باید مرحله قبل را انجام دهید!",Toast.LENGTH_LONG).show();}
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i==3){
                phase4();
                startActivity(new Intent(activity_2.this, Activity_faze4.class)); i=0;}
                else{Toast.makeText(activity_2.this ,"باید مرحله قبل را انجام دهید!",Toast.LENGTH_LONG).show();}
            }
        });
        btn_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(activity_2.this, Activity_info.class));
            }
        });

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        init();
       // MediaPlayer player = MediaPlayer.create(activity_2.this, R.raw.music_1);
      //  player.setLooping(true); // Set looping
       // player.setVolume(100, 100);
       // player.start();

        click();
    }

    public void input() {
        int ind=0;

        File dir = Environment.getExternalStorageDirectory();



        System.out.println(dir.toString()+"/data/cars.csv"+"----------------------------------------------------------------------------------");

        //String url = "/storage/emulated/0/data/";
        String url = dir.toString()+"/data/";

        System.out.println(url);

        Map<String, File> files = new HashMap<>();
        files.put("cars", new File(url+"cars.csv"));
        files.put("accounts", new File(url+"accounts.csv"));
        files.put("homes", new File(url+"homes.csv"));
        files.put("people", new File(url+"people.csv"));
        files.put("phones", new File(url+"phones.csv"));
        files.put("contacts", new File(url+"calls.csv"));
        files.put("ownerShips", new File(url+"ownerships.csv"));
        files.put("transactions", new File(url+"transactions.csv"));
        files.put("relationships", new File(url+"relationships.csv"));
        try {
            s = new Scanner(files.get("people"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        Toast.makeText(activity_2.this ,"در حال دریافت اطلاعات",Toast.LENGTH_LONG).show();

        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            person p = new person(str[0], str[1], str[2], str[3], str[4], str[5]);
            //Toast.makeText(this, str[0], Toast.LENGTH_SHORT).show();
            System.out.println("==========================="+ind+"           " +str[0] + " " + str[1] + " " + str[2]+ " "+ str[3]+ " "+ str[4] +" "+ str[5]);
            ind++;
            g.putNode(p, Enodes.person);
            if (str[5].equals("قاچاقچی"))
                g.putNode(p, Enodes.ghachaghchi);
            if (str[5].equals("سازمان بنادر") || str[5].equals("گمرک"))
                g.putNode(p, Enodes.maznun);
        }
        System.out.println("people end ");
        try {
            s = new Scanner(files.get("cars"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            car c = new car(str[0], str[1], str[2], str[3]);

            g.putNode(c, Enodes.mamlok);
        }
        System.out.println("==================================================================car end");
        try {
            s = new Scanner(files.get("homes"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            g.putNode(new house(str[0], str[1], str[2], str[3], str[4]), Enodes.mamlok);
        }
        System.out.println("============================================================home end");
        try {
            s = new Scanner(files.get("accounts"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            bankAccount account = new bankAccount(str[0], str[1], str[2], str[3]);
            //System.out.println(ind+"           " +str[0] + " " + str[1] + " " + str[2]+ " "+ str[3]);
            ind++;
            g.putNode(account, Enodes.bankAccount);
            //System.out.println(g.getPeople().containsKey(str[0]));
            g.getPerson(str[0]).addAccount(account);
        }
        System.out.println("===============================================================account end");
        try {
            s = new Scanner(files.get("phones"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            telephoneNumber phone = new telephoneNumber(str[0], str[1], str[2]);
            g.putNode(phone, Enodes.telephoneNumber);
            g.getPerson(str[0]).addTelephne(phone);
        }
        System.out.println("=============================================================phone end");

        try {
            s = new Scanner(files.get("contacts"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            contact c = new contact(g.gettelephoneNumber(str[0]), g.gettelephoneNumber(str[1]), str[2], str[3], str[4]);
            g.gettelephoneNumber(str[0]).addContact(c);
            g.gettelephoneNumber(str[1]).addContact(c);
            g.putcontact(c);
            //g.putEdge(new contact(str[0],str[1],str[2]),Eedges.cantact);
        }
        System.out.println("=======================================================contact end");
        try {
            s = new Scanner(files.get("ownerShips"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            ownership owners = new ownership(g.getPerson(str[0]), g.getmamlok(str[1]), str[2], str[3], str[4]);
            //g.putEdge(t,Eedges.transaction);
            g.getPerson(str[0]).addOwnership(owners);

        }
        System.out.println("================================================================ownership end");
        try {
            s = new Scanner(files.get("transactions"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");
            transaction t = new transaction(g.getbankAccount(str[0]), g.getbankAccount(str[1]), str[2], str[3], str[4]);
            g.getbankAccount(str[0]).addTransactionFrom(t);
            g.getbankAccount(str[1]).addTransactionTo(t);
            g.puttransaction(t);
        }
        System.out.println("================================================================transaction end");
        try {
            s = new Scanner(files.get("relationships"));
            s.nextLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (s.hasNextLine()) {
            String[] str = s.nextLine().replace("\"", "").split(",");

            relationship rel = new relationship(g.getPerson(str[0]), g.getPerson(str[1]), str[2], str[3]);
            // g.putEdge(new relationship(str[0],str[1]),Eedges.relationship);
            g.getPerson(str[0]).addRelationFrom(rel);
            g.getPerson(str[1]).addRelationTo(rel);
            //  System.out.println(ind++);
        }
        System.out.println("====================================================================relation end");
        System.out.println("==================================================================input ended.");

        Toast.makeText(activity_2.this ,"اطلاعات با موفقیت خوانده شد.",Toast.LENGTH_LONG).show();

    }

    public static boolean ismalek (person p){
        int currentYear = Integer.parseInt(sdf.format(calendar.getTime()).substring(0, 4));
        int currentMounth = Integer.parseInt(sdf.format(calendar.getTime()).substring(5, 7));
        int currentday = Integer.parseInt(sdf.format(calendar.getTime()).substring(8, 10));
        for (ownership o : p.getOs().values()) {
            int year = Integer.parseInt(o.getTime().substring(0, 4)) - currentYear;
            if (year > 2)
                return false;
            else if (year < 2)
                return true;
            else {
                int mounth = Integer.parseInt(o.getTime().substring(5, 7)) - currentMounth;
                if (mounth < 0)
                    return true;
                else if (mounth > 0)
                    return false;
                else {
                    int day = Integer.parseInt(o.getTime().substring(8, 10)) - currentday;
                    if (day > 0)
                        return false;
                    else
                        return true;
                }
            }
        }
        return false;
    }

    public static void phaseTwo() {


        System.out.println("faze2 is runing");
        for (person ma : g.getMaznonin().values()) {
            if (ismalek(ma)) {
                g.putNode(ma, Enodes.maznon2);
                continue;
            } else {
                for (relationship rel : ma.getRt().values()) {
                    if (ismalek((person) rel.getTo())) {
                        g.putNode((person) rel.getTo(), Enodes.maznon2);
                    }
                }
            }
        }
        System.out.println("faze2 is ended");
    }

    public static void phase3() {

        System.out.println("phase3 is runing");

       /* for(person pg: g.getGhachaghchi().values()){
            for(bankAccount bg: pg.getAc().values()){
                bg.setVaziat(vasiat.ghachaghchi);
            }
        }

        for(person pm: g.getMaznonin2().values()){
            for(bankAccount bg: pm.getAc().values()){
                bg.setVaziat(vasiat.maznon);
            }
        }

        for(transaction tr: g.getTransactions().values()){
            if(((bankAccount)tr.getFrom()).getVaziat()==vasiat.ghachaghchi){
                if(((bankAccount)tr.getTo()).getVaziat()==vasiat.maznon){
                    g.putNode(g.);
                    ((bankAccount) tr.getTo()).setVaziat(vasiat.h1);
                }

            }
        }*/

        ConcurrentHashMap<String,bankAccount> ac1 = new ConcurrentHashMap<String,bankAccount>();
        ConcurrentHashMap<String,bankAccount> ac2 = new ConcurrentHashMap<String,bankAccount>();
        ConcurrentHashMap<String,bankAccount> ac3 = new ConcurrentHashMap<String,bankAccount>();
        ConcurrentHashMap<String,bankAccount> ac4 = new ConcurrentHashMap<String,bankAccount>();
        ConcurrentHashMap<String,bankAccount> ac5 = new ConcurrentHashMap<String,bankAccount>();

        String str;

        for (person pg : g.getGhachaghchi().values()) {
            for (bankAccount bg : pg.getAc().values()) {
                for(transaction tg : bg.getTrFrom().values()){
                    str = ((bankAccount)tg.getTo()).getMeliCode();
                    ac1.put(((bankAccount)tg.getTo()).getKey(), (bankAccount) tg.getTo());
                    if(g.iscontains2(str))
                        g.putNode(g.getMaznon2(str),Enodes.maznon3);
                }
            }
        }
        boolean flg=false;
        System.out.println(ac1.size());

        System.out.println(ac1);

        for (bankAccount ba:ac1.values()) {
            for (transaction trf: ba.getTrFrom().values()){
                for (transaction trt: ba.getTrTo().values()){
                    if(g.getGhachaghchi().containsKey(((bankAccount)trf.getFrom()).getMeliCode())){
                        if(Integer.parseInt(trf.getTmieTransaction())-Integer.parseInt(trt.getTmieTransaction())<0)
                            flg=true;
                    }
                }
            }
            if(flg==false)
                ac1.remove(ba.getKey());
        }
        System.out.println(ac1.size());

        System.out.println(ac1);

        for(bankAccount tgb1 : ac1.values()){
            for(transaction tg1: tgb1.getTrFrom().values()){
                str = ((bankAccount)tg1.getTo()).getMeliCode();
                ac2.put(((bankAccount)tg1.getTo()).getKey(), (bankAccount) tg1.getTo());
                if(g.iscontains2(str))
                    g.putNode(g.getMaznon2(str),Enodes.maznon3);
            }}

        System.out.println(ac2.size());

        System.out.println(ac2);



        flg=false;
        for (bankAccount ba:ac2.values()) {
            for (transaction trf: ba.getTrFrom().values()){
                for (transaction trt: ba.getTrTo().values()){
                    if(ac1.containsKey(((bankAccount)trf.getFrom()).getMeliCode())){
                        if(Integer.parseInt(trf.getTmieTransaction())-Integer.parseInt(trt.getTmieTransaction())<0)
                            flg=true;
                    }
                }
            }
            if(flg==false)
                ac2.remove(ba.getKey());
        }
        System.out.println(ac2.size());

        System.out.println(ac2);

        for(bankAccount tgb1 : ac2.values()){
            for(transaction tg1: tgb1.getTrFrom().values()){
                str = ((bankAccount)tg1.getTo()).getMeliCode();
                ac3.put(((bankAccount)tg1.getTo()).getKey(), (bankAccount) tg1.getTo());
                if(g.iscontains2(str))
                    g.putNode(g.getMaznon2(str),Enodes.maznon3);
            }}
        flg=false;
        for (bankAccount ba:ac3.values()) {
            for (transaction trf: ba.getTrFrom().values()){
                for (transaction trt: ba.getTrTo().values()){
                    if(ac2.containsKey(((bankAccount)trf.getFrom()).getMeliCode())){
                        if(Integer.parseInt(trf.getTmieTransaction())-Integer.parseInt(trt.getTmieTransaction())<0)
                            flg=true;
                    }
                }
            }
            if(flg==false)
                ac3.remove(ba.getKey());
        }

        System.out.println(ac3.size());

        System.out.println(ac3);


        for(bankAccount tgb1 : ac3.values()){
            for(transaction tg1: tgb1.getTrFrom().values()){
                str = ((bankAccount)tg1.getTo()).getMeliCode();
                ac4.put(((bankAccount)tg1.getTo()).getKey(), (bankAccount) tg1.getTo());
                if(g.iscontains2(str))
                    g.putNode(g.getMaznon2(str),Enodes.maznon3);
            }}
        flg=false;
        for (bankAccount ba:ac4.values()) {
            for (transaction trf: ba.getTrFrom().values()){
                for (transaction trt: ba.getTrTo().values()){
                    if(ac3.containsKey(((bankAccount)trf.getFrom()).getMeliCode())){
                        if(Integer.parseInt(trf.getTmieTransaction())-Integer.parseInt(trt.getTmieTransaction())<0)
                            flg=true;
                    }
                }
            }
            if(flg==false)
                ac4.remove(ba.getKey());
        }

        System.out.println(ac4.size());

        System.out.println(ac4);


        for(bankAccount tgb1 : ac4.values()){
            for(transaction tg1: tgb1.getTrFrom().values()){
                str = (    (bankAccount)tg1.getTo()).getMeliCode();
                ac5.put(((bankAccount)tg1.getTo()).getKey(), (bankAccount) tg1.getTo());
                if(g.iscontains2(str))
                    g.putNode(g.getMaznon2(str),Enodes.maznon3);
            }}

        System.out.println("fase3 is ended");
    }

    public static void phase4(){

        System.out.println("faze4 is running");
       /* for(contact c: g.getContact().values()){
            if(g.getPerson(((telephoneNumber)c.getFrom()).getKey()).getWorkPlace().equals("قاچاقچی")){

            }
        }*/

        String str;
        for(person gh:g.getGhachaghchi().values()){
            for(telephoneNumber tl:gh.getTl().values()){
                for(contact cn:tl.getCo().values()){
                    str=((telephoneNumber)cn.getTo()).getMeliCode();
                    if(g.iscontains3(str))
                        g.putNode(g.getMaznon3(str),Enodes.maznon4);
                    str=((telephoneNumber)cn.getFrom()).getMeliCode();
                    if(g.iscontains3(str))
                        g.putNode(g.getMaznon3(str),Enodes.maznon4);
                }
            }
        }
    }

}
