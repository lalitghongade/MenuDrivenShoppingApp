package model;

public class ProductCategory {
	
	private int productCategoryId;
	private String productCategoryName;
	
	public ProductCategory() {
		
	}

	public int getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(int productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public ProductCategory(int productCategoryId, String productCategoryName) {
		super();
		this.productCategoryId = productCategoryId;
		this.productCategoryName = productCategoryName;
	}

	@Override
	public String toString() {
		return "ProductCategory [productCategoryId=" + productCategoryId + ", productCategoryName="
				+ productCategoryName + "]";
	}
	


}
