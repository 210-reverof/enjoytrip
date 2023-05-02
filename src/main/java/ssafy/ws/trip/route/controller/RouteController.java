package ssafy.ws.trip.route.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ssafy.ws.trip.route.dto.RouteDto;
import ssafy.ws.trip.route.service.RouteService;
import ssafy.ws.trip.user.dto.UserDto;

@Controller
@RequestMapping("/route")
public class RouteController {
	
	@Autowired
	RouteService routeService;
	
	@GetMapping("/mvroute")
	public ModelAndView mvmyroute(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		UserDto user = (UserDto) session.getAttribute("userinfo");
		
		if (user == null) {
			mv.addObject("msg", "로그인 후 이용가능합니다.");
			mv.setViewName("redirect:/");
			return mv;
		}
		 
		mv.addObject("myroute", routeService.selectMyList(user.getId()));
		mv.setViewName("/trip/myroute");
		return mv;
	} 
	
	@GetMapping("/mvinsertroute")
	public ModelAndView mvinsertroute(HttpSession session) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/trip/addroute");
		return mv;
	}
	
	@PostMapping("/insert")
	public String insert(@RequestBody Map<String, Object> requestBody, HttpSession session) throws Exception {
		UserDto user = (UserDto) session.getAttribute("userinfo");
		List<Integer> attrids = (List<Integer>) requestBody.get("attractions");
	    String title = (String) requestBody.get("title");
		
		routeService.insertRoute(new RouteDto(user.getId(), title, attrids));
		return "redirect:/route/mvroute";
	}
	 
	@PostMapping("/update")
	public ModelAndView update() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:/mvroute");
		return mv;
	}
	
	@PostMapping("/delete")
	public ModelAndView delete() throws Exception {
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:/mvroute");
		return mv;
	}
	
	@GetMapping("/{routeid}")
	public ModelAndView view(@PathVariable("routeid") int routeId) throws Exception {
		ModelAndView mv = new ModelAndView();
		mv.addObject("route", routeService.selectRoute(routeId));
		mv.setViewName("/trip/viewroute");
		return mv;
	}

}
