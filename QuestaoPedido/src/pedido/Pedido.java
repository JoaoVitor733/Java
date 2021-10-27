package pedido;

public class Pedido {
	private String horaPedido;
	private String localEntrega;
	private int qtdBotijoes;
	private int totalCompra;
	private String cartaoCredito;
	private boolean compraConfirmada = false;
	private String codigoPedido;
	private boolean pedidoEntregue = false;
	
	public boolean getPedidoEntregue() {
		return pedidoEntregue ;
	}
	public int getQtdBotijoes() {
		return qtdBotijoes;
	}
	public void setQtdBotijoes(int qtdBotijoes) {
		this.qtdBotijoes = qtdBotijoes;
	}
	public String getHoraPedido() {
		return horaPedido;
	}
	public void setHoraPedido(String horaPedido) {
		this.horaPedido = horaPedido;
	}
	public String getLocalEntrega() {
		return localEntrega;
	}
	public void setLocalEntrega(String localEntrega) {
		this.localEntrega = localEntrega;
	}
	
	private void totalCompra() {
		this.totalCompra = (qtdBotijoes*60);
	}
	
	public int getTotalCompra() {
		return totalCompra;
	}
	
	public boolean getCompraConfirmada() {
		return compraConfirmada;
	}
	public void setCartaoCredito(String cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
		compraConfirmada = true;
		this.totalCompra();
		codigoPedido = (this.totalCompra+localEntrega);
  	
	}
	
	public String getCodigoPedido() {
		return codigoPedido;
	}
	
	public void setPedidoEntregue(boolean pedidoEntregue) {
		this.pedidoEntregue = pedidoEntregue ;
	}

}
