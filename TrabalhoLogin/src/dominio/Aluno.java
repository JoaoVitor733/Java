package dominio;

public class Aluno {
	private int senha;
	private String emailConfirmacao;
	private String nome;
	private String login;
	private String dataNascimento;
	
	
	public Aluno() {
		
	}
	
	public Aluno(int senha,String emailConfirmacao , String nome, String login, String data) {
		this.nome = nome;
		this.senha = senha;
		this.login = login;
		this.dataNascimento = data;
		this.emailConfirmacao = emailConfirmacao;

	}

	public int getSenha() {
		return senha;
	}
	public void setSenha(int senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmailConfirmacao() {
		return emailConfirmacao;
	}
	public void setEmailConfirmacao(String emailConfirmacao) {
		this.emailConfirmacao = emailConfirmacao;
	}

}
