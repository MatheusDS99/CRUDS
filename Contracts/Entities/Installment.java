package Entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
    private LocalDate date;
    private Double amount;
    private static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Installment(){

    }

    public Installment(LocalDate date, Double amount){
        this.date=date;
        this.amount=amount;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }

    public LocalDate getDate(){
        return date;
    }

    public void setAmount(Double amount){
        this.amount=amount;
    }


    public Double getAmount(){
        return amount;
    }

    @Override
    public String toString(){
        return date.format(dtf) + " - " + String.format("%.2f", amount);
    }


}
