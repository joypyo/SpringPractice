package sample.spring.test;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service("userService")
public interface UserService {

	String join(Map<String, Object> map);//회원가입

	Map<String, Object> login(Map<String, Object> map); //로그인

}
