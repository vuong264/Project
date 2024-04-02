package project;
import java.util.Scanner;
public class TV_SONY extends TV {
  private double surcharge;
  
public TV_SONY(){
  
}
public TV_SONY(double surcharge, String tvID ,String mainfacturer, Date entryDate, double price, double num){
  super (tvID, manifacturer, entryDate, price, num);
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
