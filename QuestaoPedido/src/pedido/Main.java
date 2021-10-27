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
						System.out.println("MENU CONFIRMAÇÃO");
						System.out.println("---------------------------------------------------------");
						System.out.println("1 - CONFIRMAR DADOS");
						System.out.println("2 - ALTERAR DADOS");
						resp = input.nextInt(); 
			    	    switch(resp) {
			    	    case 1:
			    	    	System.out.println("Digite a quantidade de botijões que serão comprados: ");
			    	    	p.setQtdBotijoes(input.nextInt());
			    	        break;
			    	    case 2:
			    	    	input.nextLine();
					    	System.out.println("Digite a hora da compra: ");
					    	p.setHoraPedido(input.nextLine());
   
					    	System.out.println("Digite o local da entrega:");
					    	p.setLocalEntrega(input.nextLine());	 
						    System.out.println("Hora da compra: " + p.getHoraPedido() + "\nLocal de entrega dos pedidos: " + p.getLocalEntrega());
						    System.out.println("Digite a quantidade de botijões que serão comprados: ");
			    	    	p.setQtdBotijoes(input.nextInt());
						    break;
			    	    default: System.out.println("Erro, digite novamente");
			    	    }
			    	    
			    	}while(resp < 1 || resp > 2);
			    	input.nextLine();
			    	System.out.println("Digite o número do seu cartão de crédito: ");
			    	p.setCartaoCredito(input.nextLine());
			    	
			    	pedido.add(p);
		    	break;
		    case 2:
		    	
		    	flag = false;
                String cod;
                input.nextLine();
		    	System.out.println("Informe o código do pedido: ");
		    	 cod = input.nextLine();
		    	for(int i=0; i<pedido.size();i++) {
		    			if(pedido.get(i).getCodigoPedido().equals(cod)) {
		    				pedido.get(i).setPedidoEntregue(true);
		    				flag = true;
		    			}
		    	}
		    	if(!flag)
		    		System.out.println("Pedido não foi entregado!! ");
		    	break;
		    case 3: 
		    	flag = false;
		    	System.out.println("PEDIDOS CONFIRMADOS: ");
		    	for(int i=0; i < pedido.size(); i++) {
		    		if(pedido.get(i).getCompraConfirmada()) {
		    			System.out.println("Códigos: " + pedido.get(i).getCodigoPedido());
		    			flag = true;
		    		}
		    	}
		    	if(!flag)
		    		System.out.println("Não tem nenhum pedido confirmado ainda!! ");
		    	break;
		    case 4:
		    	flag = false;
		    	System.out.println("PEDIDOS ENTREGUES:");
		    	for(int i=0; i < pedido.size(); i++) {
		    		if(pedido.get(i).getPedidoEntregue()) {
		    			System.out.println("Códigos: " + pedido.get(i).getCodigoPedido());
		    			flag = true;
		    		}
		    	}
		    	if(!flag)
		    		System.out.println("Não tem nenhuma entrega confirmada ainda!! ");
		    	break;
		    case 5: System.out.println("Saindo...");
		         break;
		    default: System.out.println("Erro, digite novamente");
		    }
		    
		}while(op != 5);
	}

}
