package elevador;

public class Elevador {
	 private int andarAtual;
     private int totAndares;
     private int capElevador;
     private int qtdPessoasNele;
     
     public void inicializar(int totAndares, int capElevador) {
    	 this.totAndares = totAndares;
    	 this.capElevador = capElevador;
     }
     
     public void entrar() {
    	 if(qtdPessoasNele < capElevador)
    	 	qtdPessoasNele++;
    	 else
    		 System.out.println("Erro, elevador cheio!!");
     }
     
     public void sair() {
    	 if(qtdPessoasNele > 0)
    		 qtdPessoasNele --;
    	 else
    		 System.out.println("erro, não tem mais pessoas no elevador!!");
     }
     
     public void subir() {
    	 if(andarAtual < totAndares)
    		 andarAtual++;
    	 else
    		 System.out.println("Erro, não tem mais andares para subir!!");
     }
     
     public void descer() {
    	 if(andarAtual > 0)
    	 	andarAtual--;
    	 else
    		 System.out.println("Erro, não tem mais andares para descer!!");
     }


}
