package Questao1;
//original da prova sem iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App{
    public static void main(String[] args) {
        List<Conta> lista  = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        boolean op;

        do{
            op = true;
            System.out.println("Digite 1 para criar nova conta.\nDigite 2 para Sacar.\nDigite 3 para Depositar.\nDigite 4 para consultar uma conta.\nDigite 5 para encerrar.");
            int resp = input.nextInt();
            input.nextLine();
            switch(resp){
                case 1:
                System.out.print("Digite o nome do Titular...: ");
                String titular = input.nextLine();
                Conta contas = new Conta(titular);
                lista.add(contas);
                break;
                case 2:
                System.out.print("Digite o número da conta em que deseja sacar...: ");
                int numero = input.nextInt();
                System.out.print("Digite o valor que deseja sacar...: ");
                double valor = input.nextInt();
                for(Conta numeroConta : lista){
                        if(numeroConta == lista.get(numero-1)){
                            numeroConta.sacar(valor);
                        }
                }
                break;
                case 3: 
                System.out.print("Digite o número da conta em que deseja depositar...: ");
                numero = input.nextInt();
                System.out.print("Digite o valor que deseja depositar...: ");
                valor = input.nextInt();
                for(Conta numeroConta : lista){
                    if(numeroConta == lista.get(numero-1)){
                        numeroConta.depositar(valor);
                    }
                }
                break;
                case 4:
                System.out.print("Digite o número da conta que deseja fazer a consulta...: ");
                numero = input.nextInt();
                System.out.println(lista.get(numero-1));
                break;
                case 5:
                op = false;
                break;
            }

        } while(op);
        input.close();
    }
}