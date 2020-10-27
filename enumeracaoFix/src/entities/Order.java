package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.num.OrderStatus;

public class Order {
	
	private Date moment;
	private OrderStatus status;
	
	private List<OrderItem> orderItens = new ArrayList<>();
	private Client client;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	
	public Order(Date moment, OrderStatus status, Client client) {
		this.moment = moment;
		this.status = status;
		this.client = client;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public List<OrderItem> getOrderItens() {
		return orderItens;
	}
	
	public void addItem(OrderItem item) {
		orderItens.add(item);
	}
	
	public void removeItem(OrderItem item) {
		orderItens.remove(item);
	}
	
	public Double total() {
		Double soma = 0.0;
		for (OrderItem orderItem : orderItens) {
			soma += orderItem.subTotal();
		}
		return soma;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Order Moment: " + sdf.format(moment));
		sb.append("\nOrder status: " + status.toString());
		sb.append("\nClient: " + client.getName() + " " + sdf.format(client.getBirthDate()) + " " + client.getEmail());
		sb.append("\nOrder Items: ");
		
		for (OrderItem orderItem : orderItens) {
			sb.append("\n"+orderItem.getProduct().getName() + ", ");
			sb.append("$"+String.format("%.2f", orderItem.getProduct().getPrice())+ ", ");
			sb.append("Quantity: "+orderItem.getQuantity()+ ", ");
			sb.append("Subtotal: $"+String.format("%.2f", orderItem.subTotal()));
		}
		
		sb.append("\nTotal price: $" + total());
		return sb.toString();
	}
	
}
