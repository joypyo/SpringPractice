package sample.spring.test;

import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;


@Service("bookService")
public interface BookService {

	String create(Map<String, Object> map); //책 입력 기능 인터페이스 메소드 시그니쳐 생성

	Map<String, Object> detail(Map<String, Object> map); //책 상세 서비스 인터페이스 메소드 시그니쳐 생성

	boolean edit(Map<String, Object> map); //책 수정 기능 서비스 인터페이스 메소드 시그니쳐 생성

	boolean remove(Map<String, Object> map); //책 삭제 기능 서비스 인터페이스 메소드 시그니쳐 생성

	List<Map<String, Object>> list(Map<String, Object> map); //책 목록 서비스 인터페이스 메소드 시그니쳐 생성

}
