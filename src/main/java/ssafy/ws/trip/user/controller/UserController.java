package ssafy.ws.trip.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssafy.ws.trip.user.dto.UserDto;
import ssafy.ws.trip.user.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public ModelAndView joinUser(@RequestBody UserDto userDto) throws Exception {
		ModelAndView mv = new ModelAndView();
		userService.joinUser(userDto);
		
		mv.setViewName("redirect:index");
		return mv;
	}
	
	@PostMapping("/login")
	public ModelAndView login(UserDto userDto, HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserDto user = userService.loginUser(userDto.getId(), userDto.getPw());
		HttpSession session = req.getSession();
		session.setAttribute("userinfo", user);
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@GetMapping("/logout")
	public ModelAndView logout(HttpServletRequest req) throws Exception {
		ModelAndView mv = new ModelAndView();
		HttpSession session = req.getSession();
		session.invalidate();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PutMapping("/update")
	public ModelAndView userUpdate(UserDto userDto) throws Exception {
		ModelAndView mv = new ModelAndView();
		userService.modifyUserInfo(userDto);
		mv.setViewName("redirect:/index");
		
		return mv;
	}
	
	@DeleteMapping("/delete/{id}")
	public ModelAndView delete(@PathVariable("id") String id) throws Exception {
		ModelAndView mv = new ModelAndView();
		userService.deleteUser(id);
		
		mv.setViewName("redirect:/index");
		
		return mv;
	}

}