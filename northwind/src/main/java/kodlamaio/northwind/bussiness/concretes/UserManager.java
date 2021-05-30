package kodlamaio.northwind.bussiness.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.bussiness.abstracts.UserService;
import kodlamaio.northwind.core.dataAccess.UserDao;
import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.*;


@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> findByEmail(String email) {
		return new SuccessDataResult<User>(this.userDao.findByEmail(email),"Email Bilgisine Göre Getirildi");
	}

	@Override
	public DataResult<User> getById(int id) {
		return new SuccessDataResult<User>(this.userDao.findById(id).get(),"İd Bilgisine Göre Getirildi");
	}

	@Override
	public Result add(User user) {
		 this.userDao.save(user);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(User user) {
		this.userDao.saveAndFlush(user);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(User user) {
		this.userDao.delete(user);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

}
