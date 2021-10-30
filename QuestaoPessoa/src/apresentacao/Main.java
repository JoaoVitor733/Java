package apresentacao;

import java.util.ArrayList;
import java.util.Scanner;

import dominio.*;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList <Pessoa> pessoa = new ArrayList <Pessoa>();
		Pessoa p;
		Fornecedor f;
	
		int op;
		
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("MENU PRINCIPAL");
			System.out.println("---------------------------------------------------------");
			System.out.println("1 - ADICIONAR UMA NOVA PESSOA");
			System.out.println("2 - ADICIONAR UM NOVO FORNECEDOR");
			System.out.println("3 - MOSTRAR TODAS PESSOAS CADASTRADAS");
			System.out.println("4 - SAIR ");
		    System.out.println("---------------------------------------------------------");
			op = input.nextInt();
			
			switch(op) {
			case 1:
				p = new Pessoa();
				input.nextLine();
				System.out.println("Digite o nome: ");
				p.setNome(input.nextLine());
				System.out.println("Digite o cpf: ");
				p.setCpf(input.nextLine());
				System.out.println("Digite o email: ");
				p.setEmail(input.nextLine());
				pessoa.add(p);
				break;
			case 2:
				f = new Fornecedor();
				input.nextLine();
				System.out.println("Digite o nome: ");
				f.setNome(input.nextLine());
				System.out.println("Digite o cpf: ");
				f.setCpf(input.nextLine());
				System.out.println("Digite o email: ");
				f.setEmail(input.nextLine());
				System.out.println("Informe o seu credito: ");
				f.setValorCredito(input.nextFloat());
				System.out.println("Informe sua divida: ");
				f.setValorDivida(input.nextFloat());
			    System.out.println("Saldo: " + f.obterSaldo());
				pessoa.add(f);
				break;
			case 3:
				for(int i = 0; i < pessoa.size(); i++) {
					System.out.println("nome:" + pessoa.get(i).getNome());
				}
				break;
			case 4: System.out.println("Saindo...");
				break;
			default: System.out.println("Erro, digite novamente");
			}
		}while(op != 4);

	}

}
