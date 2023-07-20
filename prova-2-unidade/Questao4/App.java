package Questao4;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Deque<Integer> pilha = new ArrayDeque<>();
        int numero = 1;
        int quant = 0;

        do{
            System.out.print("Digite um número inteiro...: ");
            numero = input.nextInt();
            pilha.add(numero);
            int ultimo = pilha.getLast();
            for(Integer numeros : pilha){
                if(numeros == ultimo){
                    quant++;
                }
            }

        } while(numero != 0);
        System.out.println(pilha);
        System.out.println(quant);
    }
    
}
