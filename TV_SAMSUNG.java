package project;

public class TV_SAMSUNG {
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
