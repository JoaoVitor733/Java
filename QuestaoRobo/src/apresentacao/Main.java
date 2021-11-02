package apresentacao;

import java.util.Scanner;

import dominio.Robo;

public class Main {

	public static void main(String[] args) {
		  Robo r1 = new Robo();
		  String[][] sala = new String[10][10];
		  Scanner input = new Scanner(System.in);
          int op;
          
          
          do {
  
  		    sala = r1.mostrarPosicaoAtual() ;
  			  for(int i = 0; i < 10; i++) {
  					for(int j = 0; j < 10; j++) {
  						System.out.print(sala[i][j]+ " ");
  					}
  					System.out.println("");
  			  }
  			  
		  	System.out.println("---------------------------------------------------------");
			System.out.println("MENU PRINCIPAL");
			System.out.println("---------------------------------------------------------");
			System.out.println("1 - Andar para cima");
			System.out.println("2 - Andar para baixo");
			System.out.println("3 - Andar para Direita");
			System.out.println("4 - Andar para Esquerda");
			System.out.println("5 - Alterar passo");
			System.out.println("6 - sair");
		    System.out.println("---------------------------------------------------------");
		    System.out.print("Digite a sua opção: ");
		    op = input.nextInt();
		    
		    
		     
		    switch(op) {
		    case 1: 
		    	 r1.andarCima();
		    	break;
		    case 2:
		    	r1.andarBaixo();
		    	break;
		    case 3:
		    	r1.andarDireita();
		    	break;
		    case 4:
		    	r1.andarEsquerda();
		    	break;
		    case 5:
		    	int passo;
		    	do {
			    	System.out.println("Digite o valor do passo(que seja < 5 para uma melhor experiência): ");
			    	passo = input.nextInt();
			    	r1.setPasso(passo);
		    	}while(passo > 5 || passo < 1);
		    	break;
		    case 6: System.out.println("Saindo...");
		    	break;
		    default: System.out.println("Opção inválida, digite novamente!");
		    }
			  
          }while(op != 6);
          
          
		
	}

}
