package App;

import java.util.Scanner;
import java.util.Locale;
import Model.Entities.*;


public class Program {

    public static void main (String [] args){
        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);
        Cofre cofrinho = new Cofre();
        int x;

        do {
            System.out.println("----MENU DO COFRE----");
            System.out.println();
            System.out.println("1.Adicionar Moedas\n2.Remover Moedas\n3.Listar Moedas\n4.Calcular total em Real.\n0.Sair");
            System.out.print("Digite uma opção: ");
            x = input.nextInt();
            input.nextLine();

            switch (x) {
                case 1:
                    System.out.print("Qual tipo de moeda: Real(1), Dolar (2) ou Euro(3): ");
                    int n = input.nextInt();
                    System.out.print("Digite o valor: ");
                    double valor = input.nextDouble();
                    Moeda moeda = null;
                    switch (n) {
                        case 1:
                            moeda = new Real(valor);
                            break;
                        case 2:
                            moeda = new Dolar(valor);
                            break;
                        case 3:
                            moeda = new Euro(valor);
                            break;
                        default:
                            System.out.println("Opção inválida.");
                            break;
                    }
                    if (moeda != null) {
                        cofrinho.addMoeda(moeda);
                    }
                    break;

                case 2:
                    if (cofrinho.getMoedas().isEmpty()) {
                        System.out.println("Cofrinho vazio. Nada para remover.");
                        break;
                    }
                    System.out.println("Escolha uma moeda para remover: ");
                    cofrinho.listarMoedas();
                    System.out.println("Digite o numero da moeda: ");
                    int indice = input.nextInt();
                    System.out.println("O quanto deseja remover da moeda: ");
                    double quantidade = input.nextDouble();
                    if (quantidade<=0)
                        System.out.println("Quantidade inválida.");
                    else if (indice > 0 && indice <= cofrinho.getMoedas().size()) {
                        cofrinho.removeMoeda(indice, quantidade);
                        System.out.println("Moeda removida com sucesso.");
                    } else {
                        System.out.println("Opção inválida.");
                    }
                    break;
                case 3:
                    cofrinho.listarMoedas();
                    break;
                case 4:
                    System.out.println("Total em real: R$ " + cofrinho.somaMoedas());
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        }while (x!=0);

        System.out.println("----Programa finalizado!----");



    }


}
