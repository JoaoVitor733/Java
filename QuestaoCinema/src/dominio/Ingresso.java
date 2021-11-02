package dominio;

public class Ingresso {
	private int codIngresso;
	private String cpf;
	private String nomeFilme;
	private int numerosPoltronas;
	private int valorIngresso;
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf; 	
	}
	public int getNumerosPoltronas() {
		return numerosPoltronas;
	}
	public void setNumerosPoltronas(int numerosPoltronas) {
		this.numerosPoltronas = numerosPoltronas;
	}
	public int getValorIngresso() {
		return valorIngresso;
	}
	public void setValorIngresso(int valorIngresso) {
		this.valorIngresso = 16/valorIngresso;
		this.codIngresso = (1+numerosPoltronas)*2021;
	}

	@Override
	public String toString() {
		return "Ingresso [codIngresso=" + codIngresso  +  ", nomeFilme=" + nomeFilme
				+ ", numerosPoltronas=" + (numerosPoltronas+1) + ", valorIngresso=" + valorIngresso + "]";
	}

	public void setNomeFilme(String nomeFilme) {
		this.nomeFilme = nomeFilme;
	}
	
	

}