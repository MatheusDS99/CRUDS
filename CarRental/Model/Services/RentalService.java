package Model.Services;

import Model.Entities.CarRental;
import Model.Entities.Invoice;

public class RentalService {

    private Double pricePerDay;
    private Double pricePerHour;
    private taxService taxService;

    public RentalService(){

    }

    public RentalService(Double pricePerDay, Double pricePerHour, taxService taxService){
        this.pricePerDay=pricePerDay;
        this.pricePerHour=pricePerHour;
        this.taxService=taxService;
    }

    public void processInvoice(CarRental carRental){
        long t1 = carRental.getStart().getTime();
        long t2 = carRental.getFinish().getTime();
        //(t2-t1) = x;
        //-->  x/1000/60/60
        //-->  x/1000/60 = x/1000 * 1/60 = x/60000;
        //-->  x/60000/60 = x/60000 * 1/60 = x/3600000
        double hours = (double)(t2-t1)/3600000;

        double basicPayment;
        if (hours<=12)
            basicPayment = Math.ceil(hours)*pricePerHour;
        else
            basicPayment = Math.ceil(hours/24)* pricePerDay;

        double tax = taxService.tax(basicPayment);
        carRental.setInvoice(new Invoice(basicPayment, tax));
    }



}
