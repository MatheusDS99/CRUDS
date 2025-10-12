package Model.Entities;

import java.util.List;
import java.util.ArrayList;

public class Cofre {

    private List<Moeda> moedas = new ArrayList<>();

    public void addMoeda(Moeda moeda){
        this.moedas.add(moeda);
    }

    public List<Moeda> getMoedas(){
        return moedas;
    }

    public void removeMoeda(int indice, double quantidade){
        if (indice>0 && indice<=moedas.size()) {
            Moeda moeda = moedas.get(indice - 1);

            if (quantidade>=moeda.getValor())
                moedas.remove(indice-1);
            else{
                moeda.setValor(moeda.getValor()-quantidade);
            }
        }

    }

    public void listarMoedas(){
     if (moedas.isEmpty()){
         System.out.println("O Cofre está vazio.");
         return;
     }
     else{
         for (int i = 0;i<moedas.size();i++){
             System.out.println((i + 1) + " - " + moedas.get(i).info());
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
