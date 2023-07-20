package Questao3;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        List<ProdutoCarrinho> lista = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean op;

        do{
            op = true;
            System.out.println("Digite 1 para adicionar produto.\nDigite 2 para consulta de valor líquido do carrinho de compras.\nDigite 3 para encerrar.");
            int resp = input.nextInt();
            switch(resp){
                case 1:
                System.out.print("Digite o nome do produto...: ");
                String nome = input.nextLine();
                input.nextLine();
                System.out.print("Digite o preço unitário do produto...: ");
                double precoUnitario = input.nextDouble();
                input.nextLine();
                System.out.print("Digite a quantidade do produto...: ");
                double quantidade = input.nextDouble();
                input.nextLine();
                ProdutoCarrinho produto = new ProdutoCarrinho(nome, precoUnitario, quantidade);
                lista.add(produto);
                break;

                case 2:
                double valorTotal = 0;
                for(ProdutoCarrinho produtos : lista){
                    double valor =+ produtos.getValorProduto();
                    valorTotal += valor;
                }
                if(valorTotal >= 100){
                    valorTotal -= valorTotal*0.05;
                }
                System.out.println("Valor total: " + valorTotal);
                break;
                case 3:
                op = false;

            }

        } while(op);
        input.close();

    }
    
}
