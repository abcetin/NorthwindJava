package kodlamaio.northwind.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //beans proje classı
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

}
