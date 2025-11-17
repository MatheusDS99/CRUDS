package Program;

import Entities.*;
import Services.*;
import java.util.Scanner;
import java.util.Locale;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class App {
    public static void main (String[]args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Entre com os dados do contrato: ");
        System.out.print("Numero: ");
        int number = input.nextInt();
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(input.next(), dtf);
        System.out.print("Valor do contrato: ");
        double totalValue = input.nextDouble();

        Contracts contract = new Contracts(number, date, totalValue);

        System.out.print("Entre com o número de parcelas: ");
        int x = input.nextInt();

        ContractService contractService = new ContractService(new PaypalService());
        contractService.processContract(contract, x);

        System.out.println("Parcelas: ");


        for (Installment installment : contract.getInstallments()){
            System.out.println(installment);
        }

        input.close();



    }
}
