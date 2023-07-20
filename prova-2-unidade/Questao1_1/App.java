package Questao1_1;
//com iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class App {

    private static List<Conta> lista = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu(){
        System.out.println();
        System.out.println("******** OPERAÇÕES ********");
        System.out.println("* 1 - criar nova conta    *");
        System.out.println("* 2 - sacar               *");
        System.out.println("* 3 - depositar           *");
        System.out.println("* 4 - consultar uma conta *");
        System.out.println("* 5 - encerrar            *");
        System.out.println("***************************");
    }
    public static void criarConta(){
        System.out.println();
        System.out.println("***** NOVA CONTA *****");
        System.out.print("Nome do titular...: ");
        String titular = scanner.next();
        scanner.nextLine();
        Conta conta = new Conta(titular);
        lista.add(conta);
    }
    public static void sacar(){
        System.out.println();
        System.out.println("********* SAQUE **********");
        System.out.print("Digite o índice da conta...: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Valor do saque...: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();
        
        Iterator<Conta> it = lista.iterator();

        while(it.hasNext()){
            Conta conta = it.next();
            if(lista.get(indice) == conta){
                conta.sacar(valor);
            }
        }
    }
    public static void depositar(){
        System.out.println();
        System.out.println("******** DEPÓSITO ********");
        System.out.print("Digite o índice da conta...: ");
        int indice = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Valor do depósito...: ");
        double valor = scanner.nextDouble();
        scanner.nextLine();

        Iterator<Conta> it = lista.iterator();

        while(it.hasNext()){
            Conta conta = it.next();
            if(lista.get(indice) == conta){
                conta.depositar(valor);
            }
        }
    }
    public static void consultarConta(){
        System.out.println();
        System.out.println("******** CONSULTA ********");
        System.out.print("Digite o índice da conta...: ");
        int indice = scanner.nextInt();

        System.out.println(lista.get(indice));
    }

    public static void main(String[] args) {
        int op;

        do{
            mostrarMenu();
            System.out.print("Operação (1-5)...: ");
            op = scanner.nextInt();

            switch(op){
                case 1: criarConta(); break;
                case 2: sacar(); break;
                case 3: depositar(); break;
                case 4: consultarConta(); break;
            }
        } while(op != 5);
        scanner.close();
    }
}
