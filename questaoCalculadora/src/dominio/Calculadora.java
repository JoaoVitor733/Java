package dominio;

public class Calculadora {
	private int operador;
	private float operando1;
	private float operando2;
	protected float resul;
	
	public Calculadora() {
		operador = 0;
		operando1 = 0;
		operando2 = 0;
	}
	
	private void somar(float operando1, float operando2) {
		resul = operando1 + operando2;
	}
	
	private void subtracao(float operando1, float operando2) {
		resul =operando1 - operando2;
	}
	private void multiplicao(float operando1, float operando2) {
		resul = operando1 * operando2;
	}
	private void divisao(float operando1, float operando2) {
		resul = operando1 / operando2;
	}
	
	public void calcular(float operando1, int operador, float operando2) {
		if(operador == 1)  this.somar(operando1, operando2 );
		if(operador == 2)  this.subtracao(operando1, operando2 );	
		if(operador == 3)  this.multiplicao(operando1, operando2 );
		if(operador == 4)  this.divisao(operando1, operando2 );
	}
	
	public int getOperador() {
		return operador;
	}
	
	public float getResul() {
		return resul;
	}
	
	

}