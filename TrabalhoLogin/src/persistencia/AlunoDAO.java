package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dominio.Aluno;

public class AlunoDAO {
	private Conexao conClasDAO;
	private String VERIFICARUSUARIO = "select * from \"Aluno\" where \"login\"=? and \"senha\"=?"; 
	private String VERIFICARLOGIN = "select * from\"Aluno\" where \"login\"=?";	
	private String RELATORIOGERAL = "select * from\"Aluno\""; 
	private String EXCLUIRUSUARIO = "delete from \"Aluno\" where \"login\"=?"; 
	private String ALTERARSENHA = "update \"Aluno\" set \"senha\"=? where \"login\"=? and \"email\"=?"; 
	private String ALTERARDAODOS = "update \"Aluno\" set \"email\"=?,\"nome\"=?, \"data\"=?" +
											"where \"login\"=?";
	private String CADASTRARUSUARIO = "insert into \"Aluno\" (\"senha\",\"email\",\"nome\",\"login\",\"data\") "
			+ "values (?,?,?,?,?)"; 
	
	public AlunoDAO() {
		conClasDAO = new Conexao("jdbc:postgresql://localhost:5432/AlunoDAO","postgres","123");
	}
	
	
	public boolean verificarUsuario(String login, int senha) { 
		try {
			conClasDAO.conectar();
			PreparedStatement instrucao = conClasDAO.getConexao().prepareStatement(VERIFICARUSUARIO);
			instrucao.setString(1,login);
			instrucao.setInt(2, senha);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next())
				return true;
			conClasDAO.desconectar();
		}catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
		
		return false;
	}
	
	public boolean verificarEmail(String email) {
		try {
			conClasDAO.conectar();
			PreparedStatement instrucao = conClasDAO.getConexao().prepareStatement(VERIFICARLOGIN);
			instrucao.setString(1,email);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next())
				return true;
			conClasDAO.desconectar();
		}catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
		return false;
	}
	
	public boolean verificarLogin(String login) { 
		try {
			conClasDAO.conectar();
			PreparedStatement instrucao = conClasDAO.getConexao().prepareStatement(VERIFICARLOGIN);
			instrucao.setString(1,login);
			ResultSet rs = instrucao.executeQuery();
			if(rs.next())
				return true;
			conClasDAO.desconectar();
		} catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
		return false;
	}
	
	public ArrayList <Aluno> relatorioGeral(){
		ArrayList <Aluno> aluno = new ArrayList <Aluno>();
		try {
			conClasDAO.conectar();
			Statement instrucao = conClasDAO.getConexao().createStatement();
			ResultSet rs = instrucao.executeQuery(RELATORIOGERAL);
			while(rs.next()) {
				Aluno a = new Aluno(rs.getInt("senha"),rs.getString("email"), rs.getString("nome")
						,rs.getString("login"), rs.getString("data"));
				aluno.add(a);
			}
			conClasDAO.desconectar();
		}catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
		return aluno;
	}
	
	public void excluirUsuario(String login) { 
		try {
			conClasDAO.conectar();
			PreparedStatement instrucao = conClasDAO.getConexao().prepareStatement(EXCLUIRUSUARIO);
			instrucao.setString(1, login);
			instrucao.execute();
			conClasDAO.desconectar();
		}catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
	
	}
	
	
	public void alterarSenha(int Senha, String login, String email) { 
		try {
			conClasDAO.conectar();
			PreparedStatement instrucao = conClasDAO.getConexao().prepareStatement(ALTERARSENHA);
			instrucao.setInt(1, Senha);
			instrucao.setString(2, login);
			instrucao.setString(3, email);
			instrucao.execute();
			conClasDAO.desconectar();
		}catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
	}
	
	public void alterarDados(String email, String nome, String data, String login) {
		try {
			conClasDAO.conectar();
			PreparedStatement instrucao = conClasDAO.getConexao().prepareStatement(ALTERARDAODOS);
			instrucao.setString(1, email);
			instrucao.setString(2, nome);
			instrucao.setString(3, data);
			instrucao.setString(4, login);
			instrucao.execute();
			conClasDAO.desconectar();
		}catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
		
	}
	
	public void cadastrarUsuario(Aluno a) { 
		try {
			conClasDAO.conectar();
			PreparedStatement instrucao = conClasDAO.getConexao().prepareStatement(CADASTRARUSUARIO);
			instrucao.setInt(1, a.getSenha());
			instrucao.setString(2, a.getEmailConfirmacao());
			instrucao.setString(3,  a.getNome());
			instrucao.setString(4, a.getLogin());
			instrucao.setString(5, a.getDataNascimento());
			instrucao.execute();
			conClasDAO.desconectar();
		}catch(Exception e) {
			System.out.println("Erro de conexão: " + e.getMessage());
		}
	}


	
}
