package dominio;

public class Robo {
	private int x;
	private int y;
	private int passo;
	
	String[][] posicao = new String[10][10];
	
	public Robo() {
		this.x = 1;
		this.y = 1;
		this.passo = 1;
		
	}
	
	public String[][] mostrarPosicaoAtual() {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				if( j == 9 || j == 0 || i == 0 || i == 9 ) 
					posicao[i][j] = ".";
				else 
					posicao[i][j] = " ";
					
			}  
		}	
		posicao[this.x][this.y] = "=";
		
		return posicao;
	}
	
	public void andarEsquerda() {
		if(y-passo > 0)
			this.y -= this.passo;
		this.mostrarPosicaoAtual();
	}
	
	public void andarDireita() {
		if(y+passo < 9)
			this.y += this.passo;
		this.mostrarPosicaoAtual();
	}
	
	public void andarBaixo() {
		if(x+passo < 9)
			this.x += this.passo;
		this.mostrarPosicaoAtual();
	}
	  
	public void andarCima() {
		if(x-passo > 0)
			this.x -= this.passo;
		this.mostrarPosicaoAtual();
	}

	public void setPasso(int passo) {
		this.passo = passo;
	}
	
}
