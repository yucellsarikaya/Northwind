package kodlamaio.northwind.dataAccess.absracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

// JpaRepository=> esas olarak CRUD islevleri saglar.<entitiy modeli, pk alan tipi>
public interface ProductDao extends JpaRepository<Product, Integer> {
	Product getByProductName(String productName);

	Product getByProductNameAndCategory_CategoryId(String productName, int categoryId);

	List<Product> getByProductNameOrCategory(String productName, int categoryId);

	List<Product> getByCategoryIn(List<Integer> caregories);

	List<Product> getByProductNameContains(String productName);

	List<Product> getByProductNameStartsWith(String productName);

	@Query("From Product where productName=:productName and category.categoryId=:categoryId")
	List<Product> getByNameAndCatagory(String productName, int categoryId);
	// select * from products where product_name=bisey and categoryId=bisey

	@Query("Select new kodlamaio.northwind.entities.dtos.ProductWithCategoryDto(p.id, p.productName, c.categoryName) From Category c Inner join c.products p")
	List<ProductWithCategoryDto> getProductWithCategoryDetails();
	// select p.pruduct, p.productName, c.categoryName from Category c inner join
	// product p on c.category=p.categoryId
}
