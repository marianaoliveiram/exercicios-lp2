package QuestaoReplit;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ListaFuncionarios {
	
	private static ArrayList<Funcionario> listFunc = new ArrayList<>();
	

  
 
  private static Scanner scanner = new Scanner(System.in);
	
  
  private static final String caminhoArquivo = "lista-funcionarios.obj";

	public static void exibirMenuOperacoes() {
		System.out.println("************** OPERAÇÕES **************");
		System.out.println("* 1 - Inserir Funcionário             *");
		System.out.println("* 2 - Listar Funcionários             *");
		System.out.println("* 3 - Reajustar Salários              *");
		System.out.println("* 4 - Sair                            *");
		System.out.println("***************************************");
	}
	
	public static void inserirFuncionario() {
		System.out.println("INSERÇÃO DE NOVO FUNCIONÁRIO");

		// entrada de nome
		System.out.print("Nome...: ");
		String nome = scanner.nextLine();

		// entrada de salário
		System.out.print("Salário: ");
		double salario = scanner.nextDouble();
		scanner.nextLine();				// descarte de caracteres
		
		// entrada de idade
		System.out.print("Idade..: ");
		int idade = scanner.nextInt();
		scanner.nextLine();				// descarte de caracteres
		
		// instanciação de funcionário
		Funcionario f = new Funcionario(nome, salario, idade);
		
		listFunc.add(f);				// inserção de funcionário em lista
	}
	
	public static void listarFuncionario() {		
		// verificação de ausência de funcionários inseridos
		if (listFunc.size() == 0)
			System.out.println("Não há funcionários!");
		// caso contrário (há funcionários inseridos)...
		else {
			System.out.println("LISTAGEM DE FUNCIONÁRIOS");
			
			Iterator<Funcionario> it = listFunc.iterator();		// iterador de funcionários
			
			System.out.printf("%-40s | %10s | %5s\n", "NOME", "SALÁRIO", "IDADE");
			
			// iteração entre funcionários da lista
			while (it.hasNext()) {
				Funcionario f = it.next();
				
				// listagem de dados de enésimo funcionário
				System.out.printf("%-40s | %10.2f | %5d\n", f.getNome(), f.getSalario(), f.getIdade());
			}
			
			System.out.println();
		}
	}

	public static void salvarFuncionario() {	
	
        System.out.println("Salvando arquivos...");

        try{
            FileOutputStream fluxoArquivo = new FileOutputStream(caminhoArquivo);
            ObjectOutputStream fluxoObjetos = new ObjectOutputStream(fluxoArquivo);

            fluxoObjetos.writeObject(listFunc);

			fluxoObjetos.close();
			fluxoArquivo.close();

			System.out.println("Dados salvos!");

        }catch(IOException e){
            System.out.println("Erro ao salvar. " + e.getMessage());
            e.printStackTrace();
        }
	}
	
	public static void lerFuncionarios() {
		try{
		listFunc.clear();

		FileInputStream fluxoArquivo = new FileInputStream(caminhoArquivo);
		ObjectInputStream fluxoObjetos = new ObjectInputStream(fluxoArquivo);

		listFunc = (ArrayList<Funcionario>)fluxoObjetos.readObject();

		fluxoObjetos.close();
		fluxoArquivo.close();

		System.out.println("Arquivo recuperado!");
		
		}catch(IOException | ClassNotFoundException e){
			System.out.println("Erro ao ler o arquivo." + e.getMessage());
			e.printStackTrace();
		}
		
	}

	public static void reajustarSalarios() {		
		// verificação de ausência de funcionários inseridos
		if (listFunc.size() == 0)
			System.out.println("Não há funcionários!");
		// caso contrário (há funcionários inseridos)...
		else {
			// entra de percentual de reajuste
			System.out.print("Reajuste (%): ");
			double pr = scanner.nextDouble();
			
			Iterator<Funcionario> it = listFunc.iterator();		// iterador de funcionários
			
			// iteração entre funcionários da lista
			while (it.hasNext()) {
				Funcionario f = it.next();
				
				f.reajustarSalario(pr);							// reajuste de salário de enésimo funcionário
			}
			
			System.out.println("REAJUSTE DE FUNCIONÁRIOS CONCLUÍDO!");
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int op;			// operação
		
		lerFuncionarios();
		
		do {
			exibirMenuOperacoes();
			
			System.out.print("Operação [1-4]: ");
			op = scanner.nextInt();		// entrada de operação a realizar
			scanner.nextLine();			// descarte de caracteres
			
			System.out.println();
			
			switch(op) {
				case 1: inserirFuncionario(); break;
				case 2: listarFuncionario(); break;
				case 3: reajustarSalarios(); break;
			}
			
			System.out.println();
		} while (op != 4);
		
		salvarFuncionario();
		
		scanner.close();
	}

}
