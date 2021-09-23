package sample.spring.test;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	@Autowired
	SqlSessionTemplate SqlSessionTemplate;
	
	public int insert(Map<String, Object> map) {
		return this.SqlSessionTemplate.insert("book.insert", map);
	}
	
	public Map<String, Object> selectDetail(Map<String, Object> map){
		return this.SqlSessionTemplate.selectOne("book.select_detail", map);
		
	}
	
	public int update(Map<String, Object> map) {
		return this.SqlSessionTemplate.update("book.update", map);
	}
	
	public int delete(Map<String, Object>map) {
		return this.SqlSessionTemplate.delete("book.delete", map);
	}
	
	public List<Map<String, Object>>selectList(Map<String, Object> map){
		return this.SqlSessionTemplate.selectList("book.select_list", map);
	}
}
