package elevador;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int op;
		
		Elevador e1 = new Elevador();
		Scanner input = new Scanner(System.in);
		
		
		
		System.out.println("Digite o total de andares e a capacidade do elevador: ");
		e1.inicializar(input.nextInt(), input.nextInt());
		
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("MENU PRINCIPAL");
			System.out.println("---------------------------------------------------------");
			System.out.println("1 - ENTRAR NO ELEVADOR");
			System.out.println("2 - SAIR NO ELEVADOR");
			System.out.println("3 - SUBIR DE ANDAR");
			System.out.println("4 - DESCER DE ANDAR");
			System.out.println("5 - SAIR");
		    System.out.println("---------------------------------------------------------");
			op = input.nextInt();
			
			switch(op) {
			case 1: e1.entrar(); 
			    break;
			case 2:  e1.sair();
			    break;
			case 3: e1.subir();
			    break;
			case 4: e1.descer();
			    break;
			case 5: System.out.println("Saindo...");
		    	break;
			default: System.out.println("Erro, digite novamente");
			}
		}while(op != 5);

	}

}
