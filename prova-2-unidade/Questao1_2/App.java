package Questao1_2;
//com iterator, adicionando arquivos usando FileReader e PrintWriter;
import java.util.List;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class App {

    private static List<Conta> lista = new ArrayList<>();
    private static final String caminhoArquivo = "arquivoContas.txt";
    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu(){
        System.out.println();
        System.out.println("******** OPERAÇÕES ********");
        System.out.println("* 1 - criar nova conta    *");
        System.out.println("* 2 - sacar               *");
        System.out.println("* 3 - depositar           *");
        System.out.println("* 4 - consultar uma conta *");
        System.out.println("* 5 - salvar dados        *");
        System.out.println("* 6 - ler dados           *");
        System.out.println("* 7 - encerrar            *");
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
    public static void salvarConta(){
        if(lista.size() == 0){
            System.out.println("Não há contas registradas.");
        } else{
            System.out.println("Salvando dados...");

            try{
                PrintWriter escritorArquivo = new PrintWriter(caminhoArquivo);
    
                Iterator<Conta> it = lista.iterator();
    
                while(it.hasNext()){
                    Conta conta = it.next();
                    escritorArquivo.printf("%d, %s, %f", conta.getNumero(), conta.getTitular(), conta.getSaldo());
                }
                escritorArquivo.close();
                System.out.println("Dados salvos!");
    
            } catch(IOException e){
                System.out.println("Erro ao salvar os dados." + e.getMessage());
                e.getStackTrace();
            }
            System.out.println();
        } 
    }
    public static void lerConta(){
        try{
            lista.clear();
            FileReader leitorArquivo = new FileReader(caminhoArquivo);
            Scanner fluxoLeitura = new Scanner(leitorArquivo);

            while(fluxoLeitura.hasNext()){
                String linha = fluxoLeitura.nextLine();
                String campos[] = linha.split("[|]");
                //int numero = Integer.parseInt(campos[0]);
                String titular = campos[0];
                //double saldo = Double.parseDouble(campos[2].replace(",", "."));

                Conta conta = new Conta(titular);
                lista.add(conta);
            }
            leitorArquivo.close();
            fluxoLeitura.close();

            System.out.println("Dados restaurados!");
        } catch(IOException e){
            System.out.println("Erro ao ler dados."+ e.getMessage());
            e.getStackTrace();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int op;

        lerConta();
        do{
            mostrarMenu();
            System.out.print("Operação (1-7)...: ");
            op = scanner.nextInt();

            switch(op){
                case 1: criarConta(); break;
                case 2: sacar(); break;
                case 3: depositar(); break;
                case 4: consultarConta(); break;
                case 5: salvarConta(); break;
                case 6: lerConta(); break;
            }
        } while(op != 7);
        
        salvarConta();
        scanner.close();
    }
}