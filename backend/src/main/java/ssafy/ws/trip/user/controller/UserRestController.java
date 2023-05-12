package ssafy.ws.trip.user.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ssafy.ws.trip.user.dto.UserDto;
import ssafy.ws.trip.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/")
	public boolean join(@RequestBody Map<String, String> map) throws Exception {
		String pw = map.get("pw");
		String pwcheck = map.get("pwcheck");
		if (!pw.equals(pwcheck)) return false;
		
		userService.joinUser(new UserDto(map.get("id"), pw, map.get("name"), map.get("email")));
		return true;
	}
	
	@PostMapping("/login")
	public UserDto login(@RequestBody UserDto userDto, HttpServletRequest req) throws Exception {
		UserDto user = userService.loginUser(userDto.getId(), userDto.getPw());
		HttpSession session = req.getSession();
		session.setAttribute("userinfo", user);
		return user;
	}
	
	@GetMapping("/logout")
	public void logout(HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		session.invalidate();
	}
	
	@GetMapping("/userinfo")
    public UserDto getUserInfo(HttpSession session) {
        return (UserDto) session.getAttribute("userinfo");
    }
	
	@PutMapping("/")
	public UserDto update(UserDto userDto, HttpServletRequest req) throws Exception {
		UserDto user = userService.modifyUserInfo(userDto);
		HttpSession session = req.getSession();
		session.setAttribute("userinfo", user);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String userId, HttpServletRequest req) throws Exception {
		HttpSession session = req.getSession();
		session.invalidate();
		userService.deleteUser(userId);
	}
	
}
