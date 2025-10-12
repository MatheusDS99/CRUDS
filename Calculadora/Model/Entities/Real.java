package Model.Entities;

public class Real extends Moeda{



    public Real(double valor){
        super(valor);
    }

    @Override
    public double converter() {
        return getValor();
    }

    public String info(){
        return "Moeda: Real, Valor: " + getValor();
    }
}
