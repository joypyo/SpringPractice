package sample.spring.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDao bookDao;
		
	@Override
	public String create(Map<String, Object>map) { //책 입력 기능 서비스 클래스 메소드
		int affectRowCount = this.bookDao.insert(map);
		if(affectRowCount == 1) {
			return map.get("book_id").toString();
		}
		return null;
	}
	
	@Override
	public Map<String, Object> detail(Map<String, Object>map){
		return this.bookDao.selectDetail(map);
	}
	
	@Override
	public boolean edit(Map<String, Object>map) { //책 수정기능 서비스 클래스 메소드
		int affectRowCount = this.bookDao.update(map);
		return affectRowCount == 1; //수정의 경우 입력과는 다르게 pk를 가져오거나 하는 절차가 필요없으므로 1개의 행이 제대로 영향 받았는지만 검사함
		
	}
	
	@Override
	public boolean remove(Map<String, Object>map) {
		int affectRowCount = this.bookDao.delete(map);
		return affectRowCount == 1;
	}
	
	@Override
	public List<Map<String, Object>> list(Map<String, Object> map) {
		return this.bookDao.selectList(map);
	}
}


