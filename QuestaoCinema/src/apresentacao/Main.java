package apresentacao;
import java.util.Scanner;
import dominio.Ingresso;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		
		ArrayList <Ingresso> sala = new ArrayList <Ingresso>();
		
		int[] numerosPoltronas = new int[120];
		
		Scanner input = new Scanner(System.in);
		
		for(int i = 0; i < 120; i++) numerosPoltronas[i] = i+1;
		
		int op, poltrona, cont;
		String noFi, CPF;
		boolean flag;
	
		System.out.println("Digite o nome do filme: ");
		noFi = input.nextLine();
		
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("MENU PRINCIPAL");
			System.out.println("---------------------------------------------------------");
			System.out.println("1 - COMPRAR INGRESSO");
			System.out.println("2 - ALTERAR INGRESSO");
			System.out.println("3 - DESISTIR INGRESSO");
			System.out.println("4 - CONSULTAR INGRESSO");
			System.out.println("5 - SAIR");
		    System.out.println("---------------------------------------------------------");
		    op = input.nextInt();
		    
		    switch(op) {
		    case 1:
		    	int  valor;
		    	Ingresso c1 = new Ingresso();
		    	input.nextLine();
		    	flag = true;
		    	cont = 0;
		    	c1.setNomeFilme(noFi);
		    	System.out.println("Digite o seu CPF: ");
		    	CPF = input.nextLine();
		    	c1.setCpf(CPF);
		    	
		    	
		    	if(!sala.isEmpty()) { //Procurando se o usuário ja comprou algum ingresso		
		    		
		    		for(int i = 0; i < sala.size(); i++) {
		    			if(sala.get(i).getCpf().equals(CPF)) {
		    				flag = false;
		    				i = sala.size();
		    			}
		    		}	    		
		    	}
		    	
		    	
	    		if(flag) {
		    		
			    	System.out.println("Poltronas disponiveis: ");
			    	for(int i = 0; i < 120; i++) {
			    	    if(cont < 11) {
			    	    	cont++;
			    			System.out.print(numerosPoltronas[i]+ " ");
			    	    }else {
			    	    	System.out.println( numerosPoltronas[i]);
			    	    	cont = 0;
			    	    }
			    	}		    	
			    	do {
			    		System.out.println("\nDigite o numero da poltrona desejada: ");
			    		poltrona = input.nextInt();
			    	}while(numerosPoltronas[poltrona-1] == 0);
			    	
			    	c1.setNumerosPoltronas(poltrona-1);			    	
			    	numerosPoltronas[poltrona-1] = 0;		
			    	
			    	do {
			    		System.out.println("Digite 1 para comprar o ingresso inteiro(16) e 2 meio(8)");
			    		valor = input.nextInt();
			    	}while(valor != 1 && valor != 2);
			    	
			    	c1.setValorIngresso(valor);
			    	sala.add(c1);
	    		}else {
	    			System.out.println("Indisponível, você ja comprou um ingresso!");
	    		}
		    	
		    	break;
		    case 2: 
		    	
		    	int op1, indice ;
		    	input.nextLine();
		    	indice = -2;
		    	cont = 0;
		    	flag = false;
		    	if(sala.isEmpty()) {
		    		System.out.println("Nenhuma pessoa foi cadastrada ainda!!!");
		    	}else {
		    		System.out.println("Digite o CPF informado: ");
		    		CPF = input.nextLine();
		    		for(int i = 0; i < sala.size(); i++) {
		    			if(sala.get(i).getCpf().equals(CPF)) {
		    				indice = i;
		    				flag = true;
		    			}
		    			
		    		}
		    		if(flag) {
				    	do {
					    	System.out.println("---------------------------------------------------------");
							System.out.println("MENU SECUNDARIO");
							System.out.println("---------------------------------------------------------");
							System.out.println("1 - ALTERAR POLTRONA");
							System.out.println("2 - ALTERAR VALOR INGRESSO");
							System.out.println("3 - SAIR");
							System.out.println("---------------------------------------------------------");
							op1 = input.nextInt();
							
							switch(op1) {
							case 1:								
								System.out.println("Poltronas disponiveis: ");
						    	for(int i = 0; i < 120; i++) {
						    	    if(cont < 11) {
						    	    	cont++;
						    			System.out.print(numerosPoltronas[i]+ " ");
						    	    }else {
						    	    	System.out.println( numerosPoltronas[i]);
						    	    	cont = 0;
						    	    }
						    	}
						    							  
						    	
						    	do {
						    		System.out.println("\nDigite o numero da poltrona desejada: ");
						    		poltrona = input.nextInt();
						    	}while(numerosPoltronas[poltrona-1] == 0);
						    	
						    	numerosPoltronas[sala.get(indice).getNumerosPoltronas()] = sala.get(indice).getNumerosPoltronas() ;
						    	
						    	sala.get(indice).setNumerosPoltronas(poltrona-1);			    	
						    	numerosPoltronas[poltrona-1] = 0;		
								break;
							case 2:						
						    	do {
						    		System.out.println("Digite 1 para comprar o ingresso inteiro(16) e 2 meio(8)");
						    		valor = input.nextInt();
						    	}while(valor != 1 && valor != 2);
						    	sala.get(indice).setValorIngresso(valor);
								break;
							case 3 : System.out.println("Saindo...");							
								break; 
							default: System.out.println("Erro, digite novamente!!");
							}
							
				    	}while(op1 != 3);
		    		}else {
		    			if(!flag) System.out.println("CPF não encontrado!");
		    		}
		    	}
		    	break;
		    case 3:
		    	flag = false;
		    	input.nextLine();
		    	if(sala.isEmpty()) {
		    		System.out.println("Nenhuma pessoa foi cadastrada ainda!!!");
		    	}else {
			    	System.out.println("Informe o seu CPF: ");
			    	CPF = input.nextLine();
			    	for(int i =0 ; i < sala.size(); i++) {
			    		if(sala.get(i).getCpf().equals(CPF)) {
			    			poltrona = sala.get(i).getNumerosPoltronas();
			    	     	sala.remove(i);
			    			numerosPoltronas[poltrona] = poltrona+1;
			    			flag = true;
			    			break;
			    		}
			    	}
		    	if(!flag) System.out.println("CPF não encontrado!");
		    	}
		        break;
		    case 4:
		    	flag = false;
		    	if(sala.isEmpty()) {
		    		System.out.println("Nenhuma pessoa foi cadastrada ainda!!!");
		    	}else {
		    		input.nextLine();
			    	System.out.println("Informe o seu CPF: ");
			    	CPF = input.nextLine();
			    	for(int i =0 ; i < sala.size(); i++) {
			    		if(sala.get(i).getCpf().equals(CPF)) {
			    			System.out.println(sala.get(i).toString());   
			    			flag = true;
			    		}
			    	}
			    	if(!flag) System.out.println("CPF não encontrado!");
		    	}
		    	break;
		    case 5: System.out.println("Saindo...");
		         break;
		    default: System.out.println("Erro, digite novamente!!");
		    }
		}while(op != 5);


	}

}





