package sample.spring.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public String join(Map<String, Object>map) {
		int rowCount = this.userDao.insert(map);
		if(rowCount == 1) {
			return map.get("user_num").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object>  login(Map<String, Object>map) {
		return this.userDao.login(map);
	}
	
}
