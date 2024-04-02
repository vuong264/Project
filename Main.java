
package pkgfinal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

interface IELECTRONIC_DEVICE {
    double sum_Total();
}

abstract class TV implements IELECTRONIC_DEVICE{
    private String tvID;
    private String manifacturer;
    private Date entryDate;
    private double price;
    private double num;

    public TV() {
    }

    public TV(String tvID, String manifacturer, Date entryDate, double price, double num) {
        this.tvID = tvID;
        this.manifacturer = manifacturer;
        this.entryDate = entryDate;
        this.price = price;
        this.num = num;
    }
    
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    
    public void Input(){
        System.out.print("Moi nhap ID: ");
        tvID = sc.next();
        sc.nextLine();
        System.out.print("Moi nhap Manifacturer: ");
        manifacturer = sc.nextLine();
        System.out.print("Moi nhap Entry Date (dd/MM/yyyy): ");
        do{
            try {
                entryDate = df.parse(sc.nextLine());
                break;
            } catch (ParseException ex) {
                System.out.println("Phai nhap theo dinh dang (dd/MM/yyyy)!");
            }
        }while(true);
        System.out.print("Moi nhap Price: ");
        price = sc.nextDouble();
        System.out.print("Moi nhap Num: ");
        num = sc.nextDouble();
    }
       
    public void Output(){
        System.out.println("ID: "+tvID);
        System.out.println("Manifacturer: "+manifacturer);
        System.out.println("Entry Date: "+df.format(entryDate));
        System.out.println("Price: "+price);
        System.out.println("Num: "+num);
    }
    
    public String getTvID() {
        return tvID;
    }

    public void setTvID(String tvID) {
        this.tvID = tvID;
    }

    public String getManifacturer() {
        return manifacturer;
    }

    public void setManifacturer(String manifacturer) {
        this.manifacturer = manifacturer;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }
    
    abstract double discount();
}

class TV_SAMSUNG extends TV{
    private String state;

    public TV_SAMSUNG() {
    }

    public TV_SAMSUNG(String state, String tvID, String manifacturer, Date entryDate, double price, double num) {
        super(tvID, manifacturer, entryDate, price, num);
        this.state = state;
    }

    @Override
    public void Input(){
        super.Input();
        System.out.print("Moi nhap State (new or old): ");
        sc.nextLine();
        state = sc.nextLine();
    }
    
    @Override
    public void Output(){
        super.Output();
        System.out.println("State: "+state);
        System.out.println("Total: "+sum_Total());
        System.out.println("Discount: "+discount());
    }
    
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
    
    @Override
    public double sum_Total(){
        return getNum()*getPrice()-discount();
    }
    
    @Override
    public double discount(){
        if("new".equals(state)){
            return getNum()*getPrice()*10/100;
        }
        else if("old".equals(state)){
            return getNum()*getPrice()*60/100;
        }
        else return 0;
    }
}

class TV_SONY extends TV{
    private double surcharge;

    public TV_SONY() {
    }

    public TV_SONY(double surcharge, String tvID, String manifacturer, Date entryDate, double price, double num) {
        super(tvID, manifacturer, entryDate, price, num);
        this.surcharge = surcharge;
    }

    @Override
    public void Input(){
        super.Input();
        System.out.print("Moi nhap Surcharge: ");
        surcharge = sc.nextDouble();
    }
    
    @Override
    public void Output(){
        super.Output();
        System.out.println("Surcharge: "+surcharge);
        System.out.println("Total: "+sum_Total());
        System.out.println("Discount: "+discount());
    }
    
    public double getSurcharge() {
        return surcharge;
    }

    public void setSurcharge(double surcharge) {
        this.surcharge = surcharge;
    }
    
    @Override
    public double sum_Total(){
        return getNum()*getPrice()+surcharge-discount();
    }
    
    @Override
    public double discount(){
        return getNum()*getPrice()*5/100;
    }
}

class TVLIST {
    Scanner sc = new Scanner(System.in);
    ArrayList<TV> list = new ArrayList<>();
    TV tv;
    String id ;
    int tmp = 0;
    
    void AddNew(){
        System.out.println("Ban muon them loai TV nao: ");
        System.out.println("1: TV_SAMSUNG\n2: TV_SONY");
        tmp = sc.nextInt();
        if(tmp == 1){
            tv = new TV_SAMSUNG();
            tv.Input();
            list.add(tv);
        }
        if(tmp == 2){
            tv = new TV_SONY();
            tv.Input();
            list.add(tv);
        }
    }
    
    void Update(){
        sc.nextLine();
        System.out.print("Moi ban nhap ID can Update: ");
        id = sc.nextLine();
        for(TV tv:list){
            if(tv.getTvID().equals(id)){
                System.out.println("Moi ban nhap lai thong tin: ");
                tv.Input();
            }
        }
    }
    
    void Delete(){
        sc.nextLine();
        System.out.println("Moi ban nhap ID can Delete: ");
        id = sc.nextLine();
        for(TV tv:list){
            if(tv.getTvID().equals(id)){
                list.remove(tv);
            }
        }
    }
    
    void Find(){
        sc.nextLine();
        System.out.println("Moi ban nhap ID can Find: ");
        id = sc.nextLine();
        for(TV tv:list){
            if(tv.getTvID().equals(id)){
                tv.Output();
            }
        }
    }
    
    void Menu(){
        tmp = 0;
        while(tmp != 5){
            System.out.println("Ban muon chon chuc nang nao:");
            System.out.println("1: Add New\n2: Update\n3: Delete\n4: Find\n5: Exit");
            tmp = sc.nextInt();
            switch(tmp){
                case 1:
                    AddNew();
                    break;
                case 2:
                    Update();
                    break;
                case 3:
                    Delete();
                    break;
                case 4:
                    Find();
                    break;
            }
        }
    }     
}

public class Main {
    public static void main(String[] args) {
        TVLIST list = new TVLIST();
        list.Menu();
    }
}
