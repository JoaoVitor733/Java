package dominio;

public class Fornecedor extends Pessoa{
	private float valorCredito;
	private float valorDivida;
	
	public float obterSaldo() {
		return valorCredito-valorDivida;
	}

	public float getValorCredito() {
		return valorCredito;
	}

	public void setValorCredito(float valorCredito) {
		this.valorCredito = valorCredito;
	}

	public float getValorDivida() {
		return valorDivida;
	}

	public void setValorDivida(float valorDivida) {
		this.valorDivida = valorDivida;
	}

	
}
