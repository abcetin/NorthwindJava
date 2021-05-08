package kodlamaio.northwind.bussiness.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired; //beans proje classı
import org.springframework.stereotype.Service;

import kodlamaio.northwind.bussiness.abstracts.ProductService;
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
	public List<Product> getAll() {
		return this.productDao.findAll();
	}

}
