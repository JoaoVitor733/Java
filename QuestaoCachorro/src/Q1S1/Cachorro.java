package Q1S1;

public class Cachorro {
	//Atributos encapsulados
	private String nome;
	private String raca;
	private int idade;
	
	//construtor
	public Cachorro(String nome,String raca,int idade) {
		this.nome = nome;
		this.raca = raca;
		this.idade = idade;
	}
	
	//Metodos
	
	public void comer() {
		System.out.println("O cachorro de nome: " + nome + ", raça: " + raca + " e idade:"
				+ idade +" estar comendo");
	}
	
	public void dormir() {
		System.out.println("O cachorro de nome: " + nome + ", raça: " + raca + " e idade:"
				+ idade +" estar dormindo");
	}
	
	public void passear() {
		System.out.println("O cachorro de nome: " + nome + ", raça: " + raca + " e idade:"
				+ idade +" estar passeando");
	}

}
