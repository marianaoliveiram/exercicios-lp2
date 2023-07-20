package QuestaoReplit;

import java.io.Serializable;

public class Funcionario implements Serializable {
	
	private String nome;
	private double salario;
	private int idade;

	public Funcionario(String nome, double salario, int idade) {
		this.nome = nome;
		this.salario = salario;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}
	
	public double getSalario() {
		return salario;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void reajustarSalario(double percentual) {		// reajuste de salário com base em percentual
		if (percentual > 0) {								// se percentual de reajuste válido...
			double reajuste = salario * percentual / 100;	// cálculo de reajuste
			salario += reajuste;							// incorporação de reajuste ao salário (atualização)
		}
	}
	
	public String toString() {
		return "[Nome: " + nome + ", " + 
			   "Salário: " + salario + ", " + 
			   "Idade: " + idade + "]";
	}

	public String toFormatoRegistro() {
		return nome + "|" + salario + "|" + idade;
	}

}