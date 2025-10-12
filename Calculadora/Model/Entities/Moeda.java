package Model.Entities;

public abstract class Moeda {
    private double valor;

    public Moeda(){

    }

    public Moeda(double valor){
        this.valor=valor;
    }

    public void setValor(double valor){
        this.valor=valor;
    }

    public double getValor(){
        return valor;
    }


    public abstract double converter();

    public abstract String info();



}
