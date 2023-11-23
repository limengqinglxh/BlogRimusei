package blog.com.models.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="products")
public class BlogEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long productId;
	
	private String productCategory;
	
	private String productDescription;
	
	private String productImage;
	
	private String productName;
	
	public BlogEntity() {
		
	}

	public BlogEntity(String productCategory, String productDescription, String productImage, String productName) {
		super();
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productName = productName;
	}

	public BlogEntity(Long productId, String productCategory, String productDescription, String productImage,
			String productName) {
		super();
		this.productId = productId;
		this.productCategory = productCategory;
		this.productDescription = productDescription;
		this.productImage = productImage;
		this.productName = productName;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	
}
