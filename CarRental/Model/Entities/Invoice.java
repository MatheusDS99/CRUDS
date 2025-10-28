package Model.Entities;

public class Invoice {

    private double basicPayment;
    private double tax;

    public Invoice(){

    }

    public Invoice(double basicPayment, double tax){
        this.basicPayment=basicPayment;
        this.tax=tax;
    }

    public void setBasicPayment(double basicPayment){
        this.basicPayment=basicPayment;
    }

    public double getBasicPayment(){
        return basicPayment;
    }

    public void setTax(double tax){
        this.tax=tax;
    }

    public double getTax(){
        return tax;
    }

    public double getTotalPayment(){
        return getBasicPayment()+getTax();
    }


}
