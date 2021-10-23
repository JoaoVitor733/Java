package Q1S1;

import java.util.Scanner; //importando a classe do Scanner

public class main {
	
	public static void main(String[] args) {
		Cachorro c1; // Criando a referência
		c1 = new Cachorro("Jacaré", "Vira-lata", 2); // Criando o objeto 
		
		Scanner input = new Scanner(System.in); // Criando um objeto capaz de pegar o valor dígitado pelo usuário
		
		int op;
		
		System.out.println("-----------------");
		System.out.println("MENU PRINCIPAL");
		System.out.println("1 - comer");
		System.out.println("2 - dormir");
		System.out.println("3 - passear");
		do {
			System.out.println("Qual dessas ações o cachorro deve executar?");
			op = input.nextInt();
		}while(op > 3 || op < 1);
		
		switch(op) {
		case 1:
			c1.comer();
			break;
		case 2:
			c1.dormir();
			break;
		case 3:
			c1.passear();
		 	break;
		}
	}

}
