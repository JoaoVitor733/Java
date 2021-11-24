
package visao;
import java.util.ArrayList;
import java.util.Scanner;

import dominio.Aluno;
import persistencia.*;
public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);	
		ArrayList <Aluno> alunoA = new ArrayList <Aluno>();
		AlunoDAO alunoDAO = new AlunoDAO();
		Aluno aluno;
		int op, senha,cont;
		String login, email;

		do {
			System.out.println("------------------------");
			System.out.println("\tAUTENTICA��O");
			System.out.println("------------------------");
			System.out.println("1 - ENTRAR");
			System.out.println("2 - CADASTRA-SE");
			System.out.println("3 - ESQUECEU A SENHA?");
			System.out.println("4 - SAIR");
			System.out.println("-------------------------");
			System.out.println("Digite a sua op��o: ");
			op = input.nextInt();
			input.nextLine();
			
			switch(op) {
			case 1:
				int opaux;
				aluno = new Aluno();		
				System.out.println("Digite seu login: ");
				login = input.nextLine();
				System.out.println("Digite sua senha: ");
				senha = input.nextInt();

				if(alunoDAO.verificarUsuario(login, senha)) {
					do {
						System.out.println("-------------------------------------");
						System.out.println("\tBEM VINDO AO SISTEMA!!");
						System.out.println("-------------------------------------");
						System.out.println("1 - EXCLUIR USU�RIO");
						System.out.println("2 - RELAT�RIO GERAL");
						System.out.println("3 - ALTERAR DADOS");
						System.out.println("4 - SAIR");
						System.out.println("-------------------------------------");
						System.out.println("Digite a sua op��o: ");
						opaux = input.nextInt();
						input.nextLine();
						
						switch(opaux) {
						case 1:
							System.out.println("Tem certeza que deseja excluir o usi�rio(1-sim, 2 n�o): ");
							if(input.nextInt() == 1) {
								alunoDAO.excluirUsuario(login);
								System.out.println("Usu�rio excluido com sucesso!!\n");
							}
							break;
						case 2:
							System.out.println("Relat�rio geral: \n");
							alunoA = alunoDAO.relatorioGeral();
							for(int i = 0; i < alunoA.size(); i++) {
								System.out.println("nome: " + alunoA.get(i).getNome());						
								System.out.println("email de confirma��o: " + alunoA.get(i).getEmailConfirmacao());								
								System.out.println("data de nascimento: " + alunoA.get(i).getDataNascimento());													
								System.out.println("login: " + alunoA.get(i).getLogin());							
								System.out.println();

							}
							break;
						case 3:
							String nome, data;
							System.out.println("Digite o seu nome: ");
							nome = input.nextLine();
							System.out.println("Digite um email de confirma��o: ");
							email = input.nextLine();
							System.out.println("Digite sua data de nascimento: ");
							data = input.nextLine();
							alunoDAO.alterarDados(email, nome, data, login);
							System.out.println("Atualiza��es realizadas com sucesso!!\n");
							break;
						case 4:  System.out.println("Saindo...\n");
							break;
						default: System.out.println("Erro, n�mero inv�lido\n");	
						}
						
					}while(opaux != 4 && alunoDAO.verificarEmail(login));
					
				}else {
					System.out.println("Login ou senha inv�lida!!!\n");
					
				}
				break;
			case 2:
				System.out.println("CADASTRAMENTO: \n");
				cont = 0;
				aluno = new Aluno();
				System.out.println("Digite o seu nome: ");
				aluno.setNome(input.nextLine());
				System.out.println("Digite um email de confirma��o: ");
				aluno.setEmailConfirmacao(input.nextLine());
				System.out.println("Digite sua data de nascimento: ");
				aluno.setDataNascimento(input.nextLine());
				do {
					if(cont > 0) System.out.println("Esse login ja existe, digite outro!!\n");
					System.out.println("Digite um login: ");
					login = input.nextLine();
					aluno.setLogin(login);
					cont++;
				}while(alunoDAO.verificarLogin(login) == true);
				System.out.println("Digite a sua senha: ");
				aluno.setSenha(input.nextInt());
				alunoDAO.cadastrarUsuario(aluno);
				System.out.println("USU�RIO CADASTRADO COM SUCESSO\n");
				break;
			case 3:
				System.out.println("ALTERA��O DE SENHA: \n");
				System.out.println("Digite seu login: ");
				login = input.nextLine();
				if(alunoDAO.verificarLogin(login)) {
					System.out.println("Digite seu email de confirma��o: ");
					email = input.nextLine();	
					if(alunoDAO.verificarEmail(email)) {
						System.out.println("Digite sua nova senha: ");
						senha = input.nextInt();
						alunoDAO.alterarSenha(senha, login, email);
						System.out.println("SENHA ALTERADA COM SUCESSO\n");
					}else {
						System.out.println("Email inv�lido!!!\n");
					}
				}else {
					System.out.println("login inv�lido!!\n");
				}
				break;
			case 4:  System.out.println("Saindo...");
				break;
			default: System.out.println("Erro, n�mero inv�lido!!n");
			}
		}while(op != 4);
	}
	

}
