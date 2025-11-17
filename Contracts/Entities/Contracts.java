package Entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Contracts {
    private Integer number;
    private LocalDate date;
    private Double totalValue;
    private List<Installment> installments = new ArrayList<>();

    public Contracts(){

    }

    public Contracts(Integer number, LocalDate date, Double totalValue){
        this.number=number;
        this.date=date;
        this.totalValue=totalValue;
    }

    public void setDate(LocalDate date){
        this.date=date;
    }
    public LocalDate getDate(){
        return date;
    }

    public void setNumber(Integer number){
        this.number=number;
    }
    public Integer getNumber(){
        return number;
    }

    public void setTotalValue(Double totalValue){
        this.totalValue=totalValue;
    }
    public Double getTotalValue(){
        return totalValue;
    }

    public void addInstallment(Installment x){
        this.installments.add(x);
    }

    public void removeInstallment(Installment x){
        this.installments.remove(x);
    }

    public List<Installment> getInstallments(){
        return installments;
    }

}
