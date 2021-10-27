package pedido;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		int op;
		
		ArrayList <Pedido> pedido = new ArrayList <Pedido>();
		
		do {
			System.out.println("---------------------------------------------------------");
			System.out.println("MENU PRINCIPAL");
			System.out.println("---------------------------------------------------------");
			System.out.println("1 - FAZER PEDIDO");
			System.out.println("2 - CONFIRMAR ENTREGA ");
			System.out.println("3 - VER PEDIDOS CONFIRMADOS");
			System.out.println("4 - VER PEDIDOS ENTREGUES ");
			System.out.println("5 - SAIR ");
		    System.out.println("---------------------------------------------------------");
		    
		    op = input.nextInt();
		    boolean flag;
		    
		    switch(op) {
		    case 1:	    	     
		    	    int resp;
			    	Pedido p = new Pedido();
			    	input.nextLine();
			    	System.out.println("Digite a hora da compra: ");
			    	p.setHoraPedido(input.nextLine());
			    	//input.nextLine();
			    	System.out.println("Digite o local da entrega:");
			    	p.setLocalEntrega(input.nextLine());
			    	do { 
				    	System.out.println("Hora da compra: " + p.getHoraPedido() + "\nLocal de entrega dos pedidos: " + p.getLocalEntrega());
				    	System.out.println("---------------------------------------------------------");
						System.out.println("MENU CONFIRMA��O");
						System.out.println("---------------------------------------------------------");
						System.out.println("1 - CONFIRMAR DADOS");
						System.out.println("2 - ALTERAR DADOS");
						resp = input.nextInt(); 
			    	    switch(resp) {
			    	    case 1:
			    	    	System.out.println("Digite a quantidade de botij�es que ser�o comprados: ");
			    	    	p.setQtdBotijoes(input.nextInt());
			    	        break;
			    	    case 2:
			    	    	input.nextLine();
					    	System.out.println("Digite a hora da compra: ");
					    	p.setHoraPedido(input.nextLine());
   
					    	System.out.println("Digite o local da entrega:");
					    	p.setLocalEntrega(input.nextLine());	 
						    System.out.println("Hora da compra: " + p.getHoraPedido() + "\nLocal de entrega dos pedidos: " + p.getLocalEntrega());
						    System.out.println("Digite a quantidade de botij�es que ser�o comprados: ");
			    	    	p.setQtdBotijoes(input.nextInt());
						    break;
			    	    default: System.out.println("Erro, digite novamente");
			    	    }
			    	    
			    	}while(resp < 1 || resp > 2);
			    	input.nextLine();
			    	System.out.println("Digite o n�mero do seu cart�o de cr�dito: ");
			    	p.setCartaoCredito(input.nextLine());
			    	
			    	pedido.add(p);
		    	break;
		    case 2:
		    	
		    	flag = false;
                String cod;
                input.nextLine();
		    	System.out.println("Informe o c�digo do pedido: ");
		    	 cod = input.nextLine();
		    	for(int i=0; i<pedido.size();i++) {
		    			if(pedido.get(i).getCodigoPedido().equals(cod)) {
		    				pedido.get(i).setPedidoEntregue(true);
		    				flag = true;
		    			}
		    	}
		    	if(!flag)
		    		System.out.println("Pedido n�o foi entregado!! ");
		    	break;
		    case 3: 
		    	flag = false;
		    	System.out.println("PEDIDOS CONFIRMADOS: ");
		    	for(int i=0; i < pedido.size(); i++) {
		    		if(pedido.get(i).getCompraConfirmada()) {
		    			System.out.println("C�digos: " + pedido.get(i).getCodigoPedido());
		    			flag = true;
		    		}
		    	}
		    	if(!flag)
		    		System.out.println("N�o tem nenhum pedido confirmado ainda!! ");
		    	break;
		    case 4:
		    	flag = false;
		    	System.out.println("PEDIDOS ENTREGUES:");
		    	for(int i=0; i < pedido.size(); i++) {
		    		if(pedido.get(i).getPedidoEntregue()) {
		    			System.out.println("C�digos: " + pedido.get(i).getCodigoPedido());
		    			flag = true;
		    		}
		    	}
		    	if(!flag)
		    		System.out.println("N�o tem nenhuma entrega confirmada ainda!! ");
		    	break;
		    case 5: System.out.println("Saindo...");
		         break;
		    default: System.out.println("Erro, digite novamente");
		    }
		    
		}while(op != 5);
	}

}
