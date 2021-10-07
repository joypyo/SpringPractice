package sample.spring.test;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
	@Autowired
	SqlSessionTemplate sqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.sqlSessionTemplate.insert("user.insert", map);
	}
	
	public Map<String, Object> login(Map<String, Object>map){
		return this.sqlSessionTemplate.selectOne("user.login", map);
	}
	
	
}
