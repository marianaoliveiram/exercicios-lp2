package Questao2;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Queue<Integer> fila = new ArrayDeque<>();
        Scanner input = new Scanner(System.in);
        int numero;
        boolean repetido;
        int tam = 10;

        do{
            repetido = true;
            for(int i = 0; i < tam; i++){
                System.out.print("Digite um número inteiro...: ");
                numero = input.nextInt();
                if(fila.contains(numero)){
                    System.out.println("Número repetido.");
                    tam++;
                }
                else{
                    fila.add(numero);
                }
                repetido = false;
    }
        } while(repetido);
            
        System.out.println("Fila: " + fila);
        input.close();
    }
}