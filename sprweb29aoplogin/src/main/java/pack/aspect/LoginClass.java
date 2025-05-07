package pack.aspect;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;

@Controller
public class LoginClass { // 로그인이 관심사항
    public boolean loginCheck(HttpServletRequest request, HttpServletResponse response) throws Exception {
        HttpSession httpSession = request.getSession(false); // 웹서버가 저장해  둔 쿠키값(세션) 읽기 => 기존 세션만 읽음
        
        if(httpSession == null || httpSession.getAttribute("nameok") == null) {
            return false;
        } else {
            return true;
        }
    }
}
