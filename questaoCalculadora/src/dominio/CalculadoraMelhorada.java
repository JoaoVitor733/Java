package dominio;

public class CalculadoraMelhorada extends Calculadora {
     private int memoria = super.getOperador();

	 public  CalculadoraMelhorada() {
	     super();
	 }
    
    private void potencia(float operando1, float operando2) {
    	super.resul = (float) Math.pow(operando1,operando2);
    }
    
    public int verUltimaOperacao() {
    	return memoria;
    	
    }
    
    public void calcular(float operando1, float operando2) {
    	 this.potencia(operando1, operando2 );
    }
   
    
}
