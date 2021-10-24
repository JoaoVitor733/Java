package aluno;

import java.util.Scanner;

public class main {

	public static void main(String[] args) {
		Aluno a1 = new Aluno();
		Aluno a2 = new Aluno();
		Aluno a3 = new Aluno();
		
		int op;
		
		Scanner input = new Scanner(System.in);
		
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
		    		System.out.println("CADASTRAMENTO DE ALUNOS:");
			    	for(int l = 0; l < 3; l++) {
			    		input.nextLine();
			    		System.out.println("nome e matricula do " + l + " aluno:");
			    		if(l == 0) {
			    			a1.setNome(input.nextLine());
			    		    a1.setMatricula(input.nextInt());
			    		}else {
			    			if(l == 1) {
			    				a2.setNome(input.nextLine());
			    				a2.setMatricula(input.nextInt());
			    			}else {
			    				if(l == 2) {
			    					a3.setNome(input.nextLine());
		    		    			a3.setMatricula(input.nextInt());
			    				}
			    			}
			    		}
			    	}
			    	System.out.println("Alunos cadastradas com sucesso!!!");
		    	break;
		    case 2:
		    	System.out.println("CADASTRAMENTO DE NOTAS");
		    	int aux = 0; //Contador 
		    	for(int i = 0; i < 3; i++) { //Alunos
		    		aux ++;
		    		System.out.println(aux+"o. Aluno: ");
		    		System.out.println("Digite as notas 1,2 e 3:");
		    		if(i == 0)	a1.setNotas(input.nextInt(), input.nextInt(), input.nextInt());
		    		else
		    			if(i == 1) a2.setNotas(input.nextInt(), input.nextInt(), input.nextInt());
		    			else
		    				if(i == 2) a3.setNotas(input.nextInt(), input.nextInt(), input.nextInt());
		    	}
		    	System.out.println("Notas cadastradas com sucesso!!!");
		    	break;
		    case 3:
		    	System.out.println("Calculando a média...");
		    	a1.calcularMedia();
		    	a2.calcularMedia();
		    	a3.calcularMedia();
		    	System.out.println("Médias calculadas com sucesso");
		    	break;
		    case 4:
		    	System.out.println("Situações dos alunos: ");
		    	System.out.println("Aluno " + a1.getNome() + ", estar: " + a1.getSituacao());
		    	System.out.println("Aluno " + a2.getNome() + ", estar: " + a2.getSituacao());
		    	System.out.println("Aluno " + a3.getNome() + ", estar: " + a3.getSituacao());
		    	break;
		    case 5:
		    	System.out.println("Digite a matricula do aluno desejado: ");
		    	int matricula = input.nextInt();
		    	if(a1.buscarAluno(matricula)) 
		    		System.out.println("Nome do aluno: " + a1.getNome() + "\nMatricula: " +
		    		a1.getMatricula() + "\nNotas: " + a1.getNota1() + " "+ a1.getNota2() + " "+ a1.getNota3()
		    		+ "\nMedia: " + a1.getMedia() + "\nSituação: " + a1.getSituacao());
		    	else 
		    		if(a2.buscarAluno(matricula)) 
		    			System.out.println("Nome do aluno: " + a2.getNome() + "\nMatricula: " +
		    		    a2.getMatricula() + "\nNotas: " + a2.getNota1() + " " + a2.getNota2() + " "+ a2.getNota3()
		    		    + "\nMedia: " + a2.getMedia() + "\nSituação: " + a2.getSituacao());
		    	    else 
		    			if(a3.buscarAluno(matricula)) 
		    				System.out.println("Nome do aluno: " + a3.getNome() + "\nMatricula: " +
		    			    a3.getMatricula() + "\nNotas: " + a3.getNota1() + " "+ a3.getNota2() + " "+ a3.getNota3()
		    			    + "\nMedia: " + a3.getMedia() + "\nSituação: " + a3.getSituacao());
		    	break;
		    case 6:
		    	int mat;
		    	System.out.println("Digite a do aluno desejado: ");
		    	mat = input.nextInt();
		    	if(a1.buscarAluno(mat) || a2.buscarAluno(mat) || a3.buscarAluno(mat)) {
		    		System.out.println("Digite qual nota que deve ser alterada e seu valor: ");
			    	if(a1.buscarAluno(mat))
			    		a1.alterarNota(input.nextInt(), input.nextInt());
			    	else
			    		if(a2.buscarAluno(mat))
			    			a2.alterarNota(input.nextInt(), input.nextInt());
			    		else
			    			if(a3.buscarAluno(mat))
			    				a3.alterarNota(input.nextInt(), input.nextInt());
		    	}
		    	break;
		    case 7: System.out.println("Saindo...");
		    	break;
		    default: System.out.println("erro, tente novamente");
		    }
		    
		}while(op !=  7);
	}

}
