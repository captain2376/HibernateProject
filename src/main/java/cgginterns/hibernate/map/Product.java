package cgginterns.hibernate.map;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Product {
		
		@Id
		@Column(name="product_id")
		private int productId;
		@Column(name="product_name")
		private String productName;
		
		@ManyToOne
		
		private Brand brand;
		
		public Product(int productId, String productName) {
			super();
			this.productId = productId;
			this.productName = productName;
		}
		public Product() {
			super();
			// TODO Auto-generated constructor stub
		}
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
		public Brand getBrand() {
			return brand;
		}
		public void setBrand(Brand brand) {
			this.brand = brand;
		}
		
		
}
