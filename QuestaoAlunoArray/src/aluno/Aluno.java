package aluno;

public class Aluno {
	private String nome;
	private int matricula;
	private float nota1;
	private float nota2;
	private float nota3;
	private float media;
	private String situacao;
	
	public Aluno() {
		
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getMatricula() {
		return matricula;
	}
	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}
	public float getNota1() {
		return nota1;
	}
	
	public void setNotas(float nota1, float nota2, float nota3) {
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.nota3 = nota3;
	}
	
	public float getNota2() {
		return nota2;
	}
	
	public float getNota3() {
		return nota3;
	}
	
	public float getMedia() {
		return media;
	}

	public String getSituacao() {
		return situacao;
	}
	
	public void calcularMedia() {
		media = ((nota1*4)+(nota2*5)+(nota3*6))/15;
		if(media < 3 && media >= 0)
			situacao = "Reprovado";
		else
			if(media >= 7 && media <= 10)
				situacao = "Aprovado";
			else
				if(media > 3 && media < 7)
					situacao = "Recuperação";
	}
	
	public boolean buscarAluno(int m) {
		calcularMedia();
		if(m == matricula) 
			return true;
		else
			return false;
	}
	
	public String alterarNota(int codNota, float valorNota) {
		if(codNota == 1) 
			this.nota1 = valorNota;
		else	
			if(codNota == 2) 
				this.nota2 = valorNota;
			else
				if(codNota == 3) 
					this.nota3 = valorNota;
		calcularMedia();
		
		return situacao;
	}
	
}
