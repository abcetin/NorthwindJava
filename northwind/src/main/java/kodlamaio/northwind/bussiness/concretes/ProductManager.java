package kodlamaio.northwind.bussiness.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //beans proje classı
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.bussiness.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service//bu class service görevi görecek diye belirtiyoruz
public class ProductManager implements ProductService {

	private ProductDao productDao;
	
	@Autowired //sprign arka planda buna karşı gelecek bir tane sınıfı üretip onu veriyor
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	public DataResult<List<Product>> getAll() {
		return new SuccessDataResult<List<Product>>(productDao.findAll(),"Başarıyla Listelendi");
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Başarıyla Eklendi");
	}

	@Override
	public DataResult<Product> getByProductName(String productName) {
		return new SuccessDataResult<Product>
		(productDao.getByProductName(productName),"Başarıyla Listelendi");
	}

	@Override
	public DataResult<Product> getByProductNameAndCategoryId(String productName, int categoryId) 
	{
		return new SuccessDataResult<Product> 
		(productDao.getByProductNameAndCategory_CategoryId(productName,categoryId),"Başarıyla Listelendi"); 
	}

	@Override
	public DataResult<List<Product>> getByProductNameOrCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>
		(productDao.getByProductNameOrCategory_CategoryId(productName, categoryId),"Başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByCategoryInId(List<Integer> categories) {
		
		return new SuccessDataResult<List<Product>>
		(productDao.getByCategoryIn(categories),"Başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameContains(String productName) {
		
		return new SuccessDataResult<List<Product>>
		(productDao.getByProductNameContains(productName),"Başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByProductNameStartsWith(String productName) {
		
		return new SuccessDataResult<List<Product>>
		(productDao.getByProductNameStartsWith(productName),"Başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Product>> getByNameAndCategoryId(String productName, int categoryId) {
		
		return new SuccessDataResult<List<Product>>
		(productDao.getByNameAndCategory_CategoryId(productName, categoryId),"Başarıyla Listelendi");
	}

	@Override
	public DataResult<List<Product>> getAllPageNo(int pageNo, int pageSize) {
		
		Pageable pageable = PageRequest.of(pageNo-1, pageSize);
		
		return new SuccessDataResult<List<Product>>
		(productDao.findAll(pageable).getContent());
	}

	@Override
	public DataResult<List<Product>> getAllSorted() {
		Sort sort = Sort.by(Sort.Direction.DESC,"productName");
		return new SuccessDataResult<List<Product>>(productDao.findAll(sort));
	}

}
