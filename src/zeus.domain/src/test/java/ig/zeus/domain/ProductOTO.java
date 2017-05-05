package ig.zeus.domain;

import org.dozer.Mapping;

public class ProductOTO {
	 @Mapping("id")
     private int productId;
     @Mapping("name")
    private String productName;
    @Mapping("description")
    private int desc;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getDesc() {
		return desc;
	}
	public void setDesc(int desc) {
		this.desc = desc;
	}
    
}
