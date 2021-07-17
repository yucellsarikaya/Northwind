package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.absracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController // classin controller oldugunu belirtik
@RequestMapping("api/products") // birden fazla controller varsa onun icin ekledik
@CrossOrigin
public class ProductsController {
	private ProductService prodoctService;

	@Autowired // ProductService new len classi arar arkada o classa erisiyor
	public ProductsController(ProductService prodoctService) {
		super();
		this.prodoctService = prodoctService;
	}

	@GetMapping("/getall") // veri istenildigi icin eklendi
	public DataResult<List<Product>> getAll() {
		return this.prodoctService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody Product product) {
		return this.prodoctService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.prodoctService.getByProductName(productName);
	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
			@RequestParam("categoryId") int categoryId) {
		return this.prodoctService.getByProductNameAndCategoryId(productName, categoryId);

	}

	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.prodoctService.getByProductNameContains(productName);
	}

	@GetMapping("/getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.prodoctService.getAll(pageNo - 1, pageSize);
	}

	@GetMapping("/getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.prodoctService.getAllSorted();
	}

	@GetMapping("/getProductWithCategoryDetails") // veri istenildigi icin eklendi
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.prodoctService.getProductWithCategoryDetails();
	}

}
