package Questao13;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        String sequencia;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.print("Sequência de números separados por vírgula: ");
            sequencia = scanner.nextLine();
        
        } while(!sequenciaValida(sequencia));

        int soma = calcularSoma(sequencia);

        System.out.println("Soma = " + soma);
        scanner.close();
    }

    private static boolean sequenciaValida(String sequencia){
        String numeros[] = sequencia.split(",");
        try{
            for(String numero: numeros){
                Integer.parseInt(numero);
            }
        } catch(NumberFormatException e){
            System.err.println("Sequêcia inválida. Digite novamente!");
            return false;
        }
        return true;
    }
    
    private static int calcularSoma(String sequencia){
        String numeros[] = sequencia.split(",");
        int soma = 0;
        for(String numero: numeros){
            soma += Integer.parseInt(numero);
        }
        return soma;
    }
}
