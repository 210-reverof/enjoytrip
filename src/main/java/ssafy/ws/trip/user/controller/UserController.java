package ssafy.ws.trip.user.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import ssafy.ws.trip.user.dto.UserDto;
import ssafy.ws.trip.user.service.UserService;


@Controller
public class UserController {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public ModelAndView joinUser(@RequestBody UserDto user) throws Exception {
		ModelAndView mv = new ModelAndView();
		
		
		return mv;
	}

}