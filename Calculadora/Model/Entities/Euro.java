package Model.Entities;

public class Euro extends Moeda {
    private static double cotacao = 6.22;

    public Euro(double valor){
        super(valor);
    }

    public static void setCotacao(double novaCotacao){
        cotacao = novaCotacao;
    }


    @Override
    public double converter() {
        return getValor()*cotacao;
    }
    public String info(){
        return "Moeda: Euro, Valor: " + converter();
    }
}
