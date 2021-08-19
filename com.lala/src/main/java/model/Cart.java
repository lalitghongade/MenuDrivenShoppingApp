package model;

public class Cart {
	
	private Product product;
	private Customer customer;
	private int cartProductQuantity;
	private double cartProductTotal;
	public Cart() {
		
		// TODO Auto-generated constructor stub
	}
	public Cart(Product product, Customer customer, int cartProductQuantity, double cartProductTotal) {
		super();
		this.product = product;
		this.customer = customer;
		this.cartProductQuantity = cartProductQuantity;
		this.cartProductTotal = cartProductTotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public int getCartProductQuantity() {
		return cartProductQuantity;
	}
	public void setCartProductQuantity(int cartProductQuantity) {
		this.cartProductQuantity = cartProductQuantity;
	}
	public double getCartProductTotal() {
		return cartProductTotal;
	}
	public void setCartProductTotal(double cartProductTotal) {
		this.cartProductTotal = cartProductTotal;
	}
	@Override
	public String toString() {
		return "Cart [product=" + product + ", customer=" + customer + ", cartProductQuantity=" + cartProductQuantity
				+ ", cartProductTotal=" + cartProductTotal + "]";
	}
	

}
