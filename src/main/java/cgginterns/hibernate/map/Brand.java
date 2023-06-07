package cgginterns.hibernate.map;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Brand {
		
		@Id
		@Column(name="brand_id")
		private int brandId;
		@Column(name="brand_name")
		private String brandName;
		
		@OneToMany(mappedBy="brand",fetch=FetchType.LAZY,cascade=CascadeType.ALL)
		//if join is not there productbrand table is not created
		List<Product> products;
	
		public Brand() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Brand(int brandId, String brandName) {
			super();
			this.brandId = brandId;
			this.brandName = brandName;
		}

		public int getBrandId() {
			return brandId;
		}

		public void setBrandId(int brandId) {
			this.brandId = brandId;
		}

		public String getBrandName() {
			return brandName;
		}

		public void setBrandName(String brandName) {
			this.brandName = brandName;
		}

		public List<Product> getProducts() {
			return products;
		}

		public void setProducts(List<Product> products) {
			this.products = products;
		}

		
	
}
