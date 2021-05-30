package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.bussiness.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

//farklı uygulamalara controller ile veri aktarımı yapıyoruz 
@RestController // sen bir controllersın dedik
@RequestMapping("/api/products")
public class ProductsController {

	private ProductService productService;

	@Autowired
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();

	}
	
	@GetMapping("/getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetail() {
		return this.productService.getProductWithCategoryDetails();

	}

	@PostMapping("/addProduct")
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	@GetMapping("/getByProductName")
	public DataResult<Product> getAllByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);

	}

	@GetMapping("/getByProductNameAndCategoryId")
	public DataResult<Product> getAllByProductNameAndCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);

	}

	@GetMapping("/getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam("productName") String productName, @RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);

	}

	@GetMapping("/getByCategoryInId")
	public DataResult<List<Product>> getByCategoryInId(@RequestParam List<Integer> categories) {
		return this.productService.getByCategoryInId(categories);

	}
	
	@GetMapping("/getByProductNameContains")
	public DataResult<List<Product>>  getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);

	}
	
	@GetMapping("/getAllPageNo")
	public DataResult<List<Product>>  getAllPageNo(@RequestParam int pageNo, int pageSize) {
		return this.productService.getAllPageNo(pageNo,pageSize);

	}
	
	
	@GetMapping("/getAllDesc")
	public DataResult<List<Product>>  getAllSorted() {
		return this.productService.getAllSorted();

	}
}
