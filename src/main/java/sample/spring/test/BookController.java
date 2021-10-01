package sample.spring.test;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BookController {
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView main() {
		return new ModelAndView("book/index");
	}
	
	@Autowired // 서비스 호출하기 위해 BookService를 의존성 주입 (BookService 인터페이스가 사용되었음)
	BookService bookService; // 책 입력기능 컨트롤러 서비스 빈 추가
	
	// /create 주소에 접속하면 책 정보를 입력할 수 있는 화면을 보여줌.
	@RequestMapping(value = "/create", method = RequestMethod.GET) 
	//modelandview : 데이터와 이동하고자 하는 view page를 같이 저장함
	public ModelAndView create() { // 브라우저에서 /create 주소가 GET방식으로 입력되었을 때 book/create 경로의 뷰를 보여줌.
		return new ModelAndView("book/create");
	}

	// 책 입력기능 컨트롤러 메소드
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createPost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();

		String bookId = this.bookService.create(map);
		if (bookId == null) {
			mav.setViewName("redirect:/create");
		} else {
			mav.setViewName("redirect:/detail?bookId=" + bookId);
		}
		return mav;
	}
	
	// 책 상세 URL이 입력되면 실행되는 메소드
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public ModelAndView detail(@RequestParam Map<String, Object>map) { //@RequestParam을 통해 쿼리 스트링 파라미터를 읽을 수 있음.
		
		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		String bookId = map.get("bookId").toString();
		mav.addObject("bookId", bookId);
		mav.setViewName("/book/detail");
		return mav;
	}
	
	//책 수정 화면 메소드
	@RequestMapping(value="/update", method=RequestMethod.GET)
	public ModelAndView update(@RequestParam Map<String, Object> map) {
		
		Map<String, Object> detailMap = this.bookService.detail(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", detailMap);
		mav.setViewName("/book/update");
		return mav;
	}
	
	//책 수정 기능 컨트롤러 메소드
	@RequestMapping(value="update", method=RequestMethod.POST)
	public ModelAndView updatePost(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isUpdateSuccess = this.bookService.edit(map);
			if(isUpdateSuccess) { //정상적으로 데이터가 갱신되었을 경우 확인을 위해 상세페이지로 이동
				String bookId = map.get("bookId").toString();
				mav.setViewName("redirect:/detail?bookId=" + bookId);				
			}else {
				mav = this.update(map); //갱신이 안되었을 경우 수정화면을 다시 보여줌
			}
			return mav;
	}
	
	//책 삭제 기능 컨트롤러 메소드
	@RequestMapping(value="delete", method=RequestMethod.POST)
	public ModelAndView deletePost(@RequestParam Map<String, Object>map) {
		ModelAndView mav = new ModelAndView();
		
		boolean isDeleteSuccess = this.bookService.remove(map);
			if(isDeleteSuccess) {
				mav.setViewName("redirect:/list");
			}else {
				String bookId = map.get("bookId").toString();
				mav.setViewName("redirect:/detail?bookId=" + bookId);
			}
			return mav;
	}
	
	//책 목록, 검색 컨트롤러 메소드
	@RequestMapping(value="list")
	public ModelAndView list(@RequestParam Map<String, Object>map) {
		
		List<Map<String, Object>> list = this.bookService.list(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", list); 
			if(map.containsKey("keyword")) { //목록 페이지에 keyword HTTP파라미터가 있는지 검사
		mav.addObject("keyword", map.get("keyword"));
			}
			mav.setViewName("/book/list");
		return mav;
	}
	

}
