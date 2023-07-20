package Questao1_3;

import java.io.Serializable;
public class Conta implements Serializable{
    
    private static int ultimoNumero = 0;
    private int numero;
    private String titular;
    private double saldo;

    public Conta (String titular){
        this.numero = ultimoNumero+1;
        this.titular = titular;
        this.saldo = 0;
        ultimoNumero++;
    }
    public int getNumero(){
        return numero;
    }
    public String getTitular(){
        return titular;
    }
    public double getSaldo(){
        return saldo;
    }

    public boolean sacar(double saque){
        if(saldo >= saque){
            saldo -= saque;
            return true;
        }
        else{
            return false;
        }
    }
    public void depositar(double deposito){
        saldo += deposito;
    }
    public String toString(){
        return "Conta [Número: " + numero + ", Titular: " + titular + ", Saldo atual: " + saldo + "]";
    }
}
