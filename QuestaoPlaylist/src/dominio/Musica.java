package dominio;

public class Musica {
	private String nomeMusica;
	private String nomeCantor;
	private int duracao;
	
	public String getNomeMusica() {
		return nomeMusica;
	}
	public void setNomeMusica(String nomeMusica) {
		this.nomeMusica = nomeMusica;
	}
	public String getNomeCantor() {
		return nomeCantor;
	}
	public void setNomeCantor(String nomeCantor) {
		this.nomeCantor = nomeCantor;
	}
	public int getDuracao() {
		return duracao;
	}
	public void setDuracao(int minutos, int segundos) {
		this.duracao = (minutos*60)+segundos;
	}
  
}
