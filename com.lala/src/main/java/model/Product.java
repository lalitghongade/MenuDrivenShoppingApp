package model;

public class Product {
	private int productId;
	private String ProductName;
	private double productPrice;
	private ProductCategory productCategory;
	
	public Product() {
		
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return ProductName;
	}

	public void setProductName(String productName) {
		ProductName = productName;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	public ProductCategory getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}

	public Product(int productId, String productName, double productPrice, ProductCategory productCategory) {
		super();
		this.productId = productId;
		ProductName = productName;
		this.productPrice = productPrice;
		this.productCategory = productCategory;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", ProductName=" + ProductName + ", productPrice=" + productPrice
				+ ", productCategory=" + productCategory + "]";
	}
	
	
	
	

}
