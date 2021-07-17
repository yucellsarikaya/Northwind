package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data; //@Data için gerekli kutuphane
import lombok.NoArgsConstructor;

@Entity
@Data // verilerin butun get/set/temel consructor larini getirir
@Table(name = "products") // db karsiligi
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id nin bir bir artacagini belirtiyor
	@Column(name = "product_id") // db de colon karsiligi
	private int id;

	// @Column(name = "category_id")
	// private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category;
}
