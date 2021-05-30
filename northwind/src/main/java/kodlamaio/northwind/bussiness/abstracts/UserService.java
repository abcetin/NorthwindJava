package kodlamaio.northwind.bussiness.abstracts;

import kodlamaio.northwind.core.entities.User;
import kodlamaio.northwind.core.utilities.results.*;

public interface UserService {

	DataResult<User> findByEmail(String email);
	DataResult<User> getById(int id);
	Result add(User user);
	Result update(User user);
	Result delete(User user);
}
