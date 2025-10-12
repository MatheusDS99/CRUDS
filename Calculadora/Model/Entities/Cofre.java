package Model.Entities;

import java.util.List;
import java.util.ArrayList;

public class Cofre {

    private List<Moeda> moedas = new ArrayList<>();

    public void addMoeda(Moeda moeda){
        this.moedas.add(moeda);
    }

    public void removeMoeda(Moeda moeda){
        this.moedas.remove(moeda);
    }

    public void listarMoedas(){
     if (moedas.isEmpty()){
         System.out.println("O Cofre está vazio.");
         return;
     }
     else{
         for (Moeda m : moedas){
             System.out.println(m.info());
         }
     }
    }



    public double somaMoedas(){
        double total = 0;
        for (Moeda m : moedas){
            total+=m.converter();
        }
        return total;
    }
}
