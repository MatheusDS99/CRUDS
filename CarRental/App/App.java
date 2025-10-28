package App;

import Model.Entities.CarRental;
import Model.Entities.Vehicle;
import Model.Services.BrazilTaxService;
import Model.Services.RentalService;

import java.text.ParseException;
import java.util.Scanner;
import java.util.Locale;
import java.util.Date;
import java.text.SimpleDateFormat;

public class App {
    public static void main (String [] args) throws ParseException{
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm");

        System.out.println("Enter rental data: ");
        System.out.print("Car model: ");
        String carModel = input.nextLine();
        System.out.print("Pickup (dd/MM/yyyy HH:mm): ");
        Date start = sdf.parse(input.nextLine());
        System.out.print("Return (dd/MM/yyyy HH:mm): ");
        Date finish = sdf.parse(input.nextLine());

        CarRental cr = new CarRental(start, finish, new Vehicle(carModel));

        System.out.print("Enter price per hour: ");
        double pricePerHour = input.nextDouble();
        System.out.print("Enter price per Day: ");
        double pricePerDay = input.nextDouble();



        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
        rentalService.processInvoice(cr);
        System.out.println("INVOICE: ");

        System.out.println("Basic Payment: " + String.format("%.2f", cr.getInvoice().getBasicPayment()));
        System.out.println("Tax: " + String.format("%.2f", cr.getInvoice().getTax()));
        System.out.println("Total Payment: " + String.format("%.2f", cr.getInvoice().getTotalPayment()));




    }

}
