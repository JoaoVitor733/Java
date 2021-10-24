
package aluno;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		
		ArrayList <Aluno> aluno = new ArrayList <Aluno>  (); // Criando um array capaz de armazenar objetos dinámicamente
		
		
		Scanner input = new Scanner(System.in);
		
		int op;
		
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("MENU PRINCIPAL");
			System.out.println("---------------------------------------------------------");
			System.out.println("1 - CADASTRAR ALUNOS");
			System.out.println("2 - CADASTRAR NOTAS");
			System.out.println("3 - CALCULAR MÉDIAS");
			System.out.println("4 - INFORMAR SITUAÇÕES");
			System.out.println("5 - INFORMAR DADOS DE UM ALUNO"); 
			System.out.println("6 - ALTERAR NOTA");
			System.out.println("7 - SAIR");
		    System.out.println("---------------------------------------------------------");
		    op = input.nextInt();
		    
		    switch(op) {
		    case 1:
		    	System.out.println("CADASTRAMENTO DE ALUNOS\n");
		    	int resp;
		    	do {
		    		input.nextLine();
		    		Aluno a = new Aluno();
		    		System.out.println("Digite o nome do aluno: ");
		    		a.setNome(input.nextLine());
		    		System.out.println("Digite a matricula do aluno: ");
		    		a.setMatricula(input.nextInt());
		    		aluno.add(a);
	    		    System.out.println("Quer continuar cadastrando alunos? caso não digite 0");
	    		    resp = input.nextInt();
	    		    
		    	}while(resp != 0);
		    	System.out.println("\nAlunos cadastrados com sucesso!");
	
		    	break;
		    case 2:
		    	if(aluno.isEmpty()) //verifica se estar vazio o array
		    		System.out.println("Erro, não existe alunos cadastrados!!");
		    	else {
		    		System.out.println("CADASTRAMENTO DE NOTAS\n");
		    		for(int i = 0; i < aluno.size(); i++) {
		    			System.out.println("Digite as notas do " + (1+i) +"o. aluno: ");
		    			aluno.get(i).setNotas(input.nextInt(),input.nextInt(), input.nextInt());
		    		}
		    		System.out.println("\nNotas cadastradas com sucesso!");
		    	}
		    	break;
		    case 3:
		    	if(aluno.isEmpty()) //verifica se estar vazio o array
		    		System.out.println("Erro, não existe alunos cadastrados!!");
		    	else {
		    		System.out.println("Calculando a média");
		    		for(int i = 0; i < aluno.size(); i++) {
		    			aluno.get(i).calcularMedia();
		    		}
		    		System.out.println("Média calculada com sucesso");
		    	}
		    	break;
		    case 4:
		    	if(aluno.isEmpty()) //verifica se estar vazio o array
		    		System.out.println("Erro, não existe alunos cadastrados!!");
		    	else {
			    	System.out.println("Situação do(s) aluno(s)");
			    	for(int i = 0; i < aluno.size(); i++) {
			    		
			    		System.out.println("Situação do " +(i+1) +"o. aluno: "+ aluno.get(i).getSituacao());
			    	}	
		    	}
		    	break;
		    case 5:
		    	int m;
		    	boolean flag = true; // se existir aluno o flag fica desativado
		    	
		    	if(aluno.isEmpty()) //verifica se estar vazio o array
		    		System.out.println("Erro, não existe alunos cadastrados!!");
		    	else {
		    		System.out.println("Digite a matricula do aluno: ");
		    		m = input.nextInt();
		    		for(int i = 0; i < aluno.size(); i++) {
		    			if(aluno.get(i).buscarAluno(m)) {
		    				System.out.println("Nome do aluno: " + aluno.get(i).getNome() + "\nMatricula: " +
		    				aluno.get(i).getMatricula() + "\nNotas: " + aluno.get(i).getNota1() + " "+ aluno.get(i).getNota2() + " "+ 
		    				aluno.get(i).getNota3() + "\nMedia: " + aluno.get(i).getMedia() + "\nSituação: " + aluno.get(i).getSituacao());
		    				flag = false;
		    				i = aluno.size();
		    			}
		    		}
		    		if(flag)
		    			System.out.println("Aluno não encontrado!! ");
		    	}   		
		    	break;
		    case 6:
		    	int matricula;
		    	boolean flag2 = true;
		    	if(aluno.isEmpty()) //verifica se estar vazio o array
		    		System.out.println("Erro, não existe alunos cadastrados!!");
		    	else {
		    		System.out.println("Digite a matricula do aluno: ");
		    		matricula = input.nextInt();
		    		for(int i = 0; i < aluno.size(); i++) {
		    			if(aluno.get(i).buscarAluno(matricula)) {
		    				System.out.println("Digite qual nota você deseja alterar e o novo valor dela: ");
		    				aluno.get(i).alterarNota(input.nextInt(),input.nextInt());
		    				i = aluno.size();
		    				flag2 = false;
		    			}
		    		}
		    		if(flag2)
		    			System.out.println("Aluno não encontrado!! ");
		    		
		    	}
		    	break;
		    case 7: System.out.println("saindo...");
		    	break;
		    default: System.out.println("Erro, dígite novamente!!");
		    }
		    
		}while(op != 7);
	}

}
