package apresentacao;

import dominio.Musica;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		 Scanner input = new Scanner(System.in);
		 ArrayList <Musica> musica = new ArrayList <Musica>();
		 Random gerador = new Random();
		 int op, min, seg ;
		 boolean flag;
		 String nome, nomeC;
		 do {
			  System.out.println("------------------------------------------------------------");
			  System.out.println("PLAYLIST");
			  System.out.println("------------------------------------------------------------");
			  System.out.println("1 – Adicionar uma música");
			  System.out.println("2 – Excluir uma música");
			  System.out.println("3 – Tocar uma música específica (pelo título)");
			  System.out.println("4 – Tocar as músicas de um cantor");
			  System.out.println("5 – Tocar as músicas em sequência");
			  System.out.println("6 – Tocar as músicas embaralhadas (random)");
			  System.out.println("7 – Ver as músicas da playlist");
			  System.out.println("8 – Sair");
			  System.out.println("------------------------------------------------------------");
			  op = input.nextInt();
			  switch(op) {
			  case 1:
				  	System.out.println("Cadastramento de músicas: ");
					Musica m = new Musica();
				  	input.nextLine();
				  	
				  	if(musica.isEmpty()) { //Cadastrando a primeira música
				  		System.out.println("\nDigite o nome da música");
					  	m.setNomeMusica(input.nextLine());
					  	System.out.println("Digite o nome do cantor");	
					  	m.setNomeCantor(input.nextLine());
				  	}else {
				  		  				  					  		
				  		do {
				  			flag = true;
				  			System.out.println("\nDigite o nome da música");
					  		nome = input.nextLine();
					  		m.setNomeMusica(nome);
						  	System.out.println("Digite o nome do cantor");	
						  	nomeC = input.nextLine();
						  	m.setNomeCantor(nomeC);
						  	
						  	for(int i = 0; i < musica.size(); i++) {
						  		if(musica.get(i).getNomeMusica().equals(nome) && musica.get(i).getNomeMusica().equals(nomeC)) {
						  			flag = false;
						  			i =  musica.size();
						  			System.out.println("Essa musica ja existe, digite outra!!");
						  		}
						  	}
						  	
				  		}while(!flag);
				  	}
				  	System.out.println("Quantos minutos a música tem? é os segundos?");
				  	m.setDuracao(input.nextInt(),input.nextInt());
				  	musica.add(m);	 				  
				  break;
			  case 2:	
				      flag = true;
					  if(musica.isEmpty()) {
						  System.out.println("Não tem nenhuma música ainda na PLAYLIST ");
					  }else {
						 input.nextLine();
						 System.out.println("Digite o nome da musica desejada: ") ;
						 nome = input.nextLine();
						 for(int i = 0; i < musica.size(); i++) {
							 if(musica.get(i).getNomeMusica().equals(nome)) { 
								 musica.remove(i);
								 flag = false;
								 System.out.println("Música apagada com sucesso!!!");
								 i = musica.size();
							 }
						 }
						 if(flag) System.out.println("Música não encontrada ");
					  }
				  break;
			  case 3:
				 
				  int duracao;
				  seg = 0;
				  min = 0;
				  flag = true;
				  System.out.println("Digite o nome da música: ");
				  input.nextLine();
				  nome = input.nextLine();
				  if(musica.isEmpty()) {
					  System.out.println("Não tem nenhuma música ainda na PLAYLIST ");
				  }else {
					  for(int i = 0; i < musica.size(); i++) {
						   if(musica.get(i).getNomeMusica().equals(nome)) {
							   flag = false;
							   duracao = musica.get(i).getDuracao();
							   for(i=0;i< duracao; i++) {
								   seg++;
								   try{
									   Thread.sleep(1000); // pausa de 1 segundo
								    }catch(InterruptedException e){
								    	System.out.println("Erro na execução da música: "+e.getMessage());
								   }
								    if(seg == 60) {
								    	seg = 0;
								    	min++;
								    }	
								    for(int j = 0; j < 100; j++) {
								           System.out.println("");
								    }
								    System.out.println("---------------------------");
								    System.out.println("|\tPLAYLIST          |");
								    System.out.println("---------------------------");
								    System.out.println("| " + nome);
								   	System.out.println("| " + min + ":" + seg );
								    System.out.println("---------------------------");							    
							   	}
						   }
					  }
					  if(flag) System.out.println("Música não encontrada ");
				  }
				  System.out.println("\n");
				  break;
			  case 4:

				  flag = true;
				  input.nextLine();
				  System.out.println("Digite o nome do cantor: ");
				  nomeC = input.nextLine();
				  
				  if(musica.isEmpty()) {
					  System.out.println("Não tem nenhuma música ainda na PLAYLIST ");
				  }else {
					  for(int i = 0; i < musica.size(); i++) {
						  if(musica.get(i).getNomeCantor().equals(nomeC)) {
							   duracao = musica.get(i).getDuracao();
							   flag = false;
							   seg = 0;
							   min = 0;
							   nome = musica.get(i).getNomeMusica();
							   for(int k = 0;k < duracao; k++) {
								   seg++;
								   try{
									   Thread.sleep(1000); // pausa de 1 segundo
								    }catch(InterruptedException e){
								    	System.out.println("Erro na execução da música: "+e.getMessage());
								   }
								    if(seg == 60) {
								    	seg = 0;
								    	min++;
								    }	
								    for(int j = 0; j < 100; j++) {
								           System.out.println("");
								    }
								    System.out.println("---------------------------");
								    System.out.println("|\tPLAYLIST          |");
								    System.out.println("---------------------------");
								    System.out.println("| " + nome);
								   	System.out.println("| " + min + ":" + seg );
								    System.out.println("---------------------------");	
								    
								    
							   	}
						  }
					  }
					  if(flag) System.out.println("Música não encontrada ");
					  
				  }
				  break;
			  case 5:
				  flag = true;
				  if(musica.isEmpty()) {
					  System.out.println("Não tem nenhuma música cadastrada!! ");
				  }else {
					  for(int i = 0; i < musica.size(); i++) {
						   duracao = musica.get(i).getDuracao();
						   flag = false;
						   seg = 0;
						   min = 0;
						   nome = musica.get(i).getNomeMusica();
						   for(int k = 0;k < duracao; k++) {
							   seg++;
							   try{
								   Thread.sleep(1000); // pausa de 1 segundo
							    }catch(InterruptedException e){
							    	System.out.println("Erro na execução da música: "+e.getMessage());
							   }
							    if(seg == 60) {
							    	seg = 0;
							    	min++;
							    }	
							    for(int j = 0; j < 100; j++) {
							           System.out.println("");
							    }
							    System.out.println("---------------------------");
							    System.out.println("|\tPLAYLIST          |");
							    System.out.println("---------------------------");
							    System.out.println("| " + nome);
							   	System.out.println("| " + min + ":" + seg );
							    System.out.println("---------------------------");	
							    
							    
						   	}
					  }
					  if(flag) System.out.println("Música não encontrada ");
				  }
				  break;
			  case 6:
				  flag = true;
				  int random;
				  if(musica.isEmpty()) {
					  System.out.println("Não tem nenhuma música ainda na PLAYLIST ");
				  }else {
					  for(int i = 0; i < musica.size(); i++) {
						   random = gerador.nextInt(musica.size()); // gerando valores inteiro aleatorios do 0 até o tamanho da PLAYLIST
						   duracao = musica.get(random).getDuracao();
						   flag = false;
						   seg = 0;
						   min = 0;
						   nome = musica.get(random).getNomeMusica();
						   for(int k = 0;k < duracao; k++) {
							   seg++;
							   try{
								   Thread.sleep(1000); // pausa de 1 segundo
							    }catch(InterruptedException e){
							    	System.out.println("Erro na execução da música: "+e.getMessage());
							   }
							    if(seg == 60) {
							    	seg = 0;
							    	min++;
							    }	
							    for(int j = 0; j < 100; j++) {
							           System.out.println("");
							    }
							    System.out.println("---------------------------");
							    System.out.println("|\tPLAYLIST          |");
							    System.out.println("---------------------------");
							    System.out.println("| " + nome);
							   	System.out.println("| " + min + ":" + seg );
							    System.out.println("---------------------------");								    
							    
						   	}						
					  }
					  if(flag) System.out.println("Música não encontrada ");
				  }
				  break;
			  case 7:
				  if(musica.isEmpty()) {
					  System.out.println("Não tem nenhuma música cadastrada!! ");
				  }else {
					  for(int i = 0; i < musica.size(); i++) {
						  System.out.println("Nome da música: " + musica.get(i).getNomeMusica());
						  System.out.println("Nome do cantor: " + musica.get(i).getNomeCantor());
						  System.out.println("Duração da música " + musica.get(i).getDuracao());
						  System.out.println("");
					  }
				  }
				  break;
			  case 8: System.out.println("Saindo...");
				  break;
			  default: System.out.println("Erro, digite novamente!!");
			  }
		 }while(op != 8);

	}

}
