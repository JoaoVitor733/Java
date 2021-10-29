package apresentacao;

import dominio.*;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args ) {
    	  Calculadora c1 = new Calculadora();
    	  CalculadoraMelhorada cm1 = new CalculadoraMelhorada();
    	  Scanner input = new Scanner(System.in);
    	  int operando1, operando2;
    	  String operando;
    	  
    	  System.out.println("------------------------"); 
    	  System.out.println("|\tCALCULADORA    |");
    	  System.out.println("------------------------"); 
    	  System.out.println("|somar(+)              | "
    	  		+ "\n|subtraçãor(-)         |"
    	  		+ " \n|multiplicação(*)      | "
    	  		+ "\n|divisão(/)            |"
    	  		+ "\n|potência(^)           |");
    	  System.out.println("------------------------"); 
    	   do {
    		 operando1 = input.nextInt(); 
    		 input.nextLine();
    		 operando = input.nextLine();
    		 operando2 = input.nextInt();
    		 
    		 switch(operando) {
    		 case "+": c1.calcular(operando1,1,operando2);
    		 			System.out.println(" = " + c1.getResul());
    			 break;
    		 case "-": c1.calcular(operando1,2,operando2);
    		 			System.out.println(" = " + c1.getResul());
    			 break;
    		 case "*": c1.calcular(operando1,3,operando2);
    		 			System.out.println(" = " + c1.getResul());
    			 break;
    		 case "/": c1.calcular(operando1,4,operando2);
    		 		   System.out.println(" = " + c1.getResul());
    			 break;
    		 case "^" : cm1.calcular(operando1,operando2);
    		 			System.out.println(" = " + cm1.getResul());
			 break;
    		
    			 
    		 }
    	  }while(true);
     }
}
