package model;

public class Order {

	private int orderId;
	private double orderTotal;
	private int quantity;
	private OrderStatus orderStatus;
	
	public Order() {
		
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Order(int orderId, double orderTotal, int quantity, OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.orderTotal = orderTotal;
		this.quantity = quantity;
		this.orderStatus = orderStatus;
	}

	@Override
	public String toString() {
		return "Order [orderId=" + orderId + ", orderTotal=" + orderTotal + ", quantity=" + quantity + ", orderStatus="
				+ orderStatus + "]";
	}
	
	
	
	
		
}
