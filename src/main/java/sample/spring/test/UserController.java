package sample.spring.test;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping("/join")
	public ModelAndView join() {
		return new ModelAndView("user/join");
	}
	
	@PostMapping ("/join")
	public ModelAndView joinUser(@RequestParam Map<String, Object> map) {
		ModelAndView mav = new ModelAndView();
		
		String userNum = this.userService.join(map);
		if(userNum == null) {
			mav.setViewName("redirect:/join");
		}else {
			mav.setViewName("/redirect");
			mav.addObject("msg", "회원가입이 완료 되었습니다!");
			mav.addObject("url", "/index");
		}
		return mav;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		return new ModelAndView("user/login");
	}
	
	@PostMapping("/login")
	public ModelAndView login(@RequestParam Map<String, Object>map, HttpSession session) {
		Map<String, Object> loginMap = this.userService.login(map);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("data", loginMap);
		
		if(loginMap == null) {
			mav.setViewName("/redirect");
			mav.addObject("msg", "아이디 또는 비밀번호를 확인 해주세요.");
			mav.addObject("url", "/login");
		}
		
		if(loginMap != null) {
			session.setAttribute("data", loginMap);
			mav.setViewName("redirect:/index");
			
		}
	return mav;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/redirect");
		mav.addObject("msg", "로그아웃 되었습니다.");
		mav.addObject("url", "/index");
		session.invalidate();
		
		return mav;
	}
}
