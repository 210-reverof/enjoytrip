package ssafy.ws.trip.user.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public UserDto login(UserDto userDto) throws Exception {
		UserDto user = userService.loginUser(userDto.getId(), userDto.getPw());
		return user;
	}
	
	@PostMapping("/logout")
	public void logout() throws Exception {
		
		return ;
	}
	
	@PutMapping("/")
	public UserDto update(UserDto userDto) throws Exception {
		UserDto user = userService.modifyUserInfo(userDto);
		return user;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") String userId) throws Exception {
		userService.deleteUser(userId);
		
	}
	
}
