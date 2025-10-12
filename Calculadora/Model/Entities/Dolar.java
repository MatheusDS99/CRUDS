package Model.Entities;

public class Dolar extends Moeda{

    private static double cotacao = 5.53;

    public Dolar(double valor){
        super(valor);
    }

    @Override
    public double converter() {
        return getValor()*cotacao;
    }

    public String info(){
        return "Moeda: Dolar, Valor: " + converter();
    }
}
