package project;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public abstract class TV implements IELECTRONIC_DEVICE{
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
