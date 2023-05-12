package ssafy.ws.trip.route.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ssafy.ws.trip.route.dto.RouteDto;
import ssafy.ws.trip.route.dto.RouteResDto;
import ssafy.ws.trip.route.service.RouteService;
import ssafy.ws.trip.user.dto.UserDto;

@RestController
@RequestMapping("/api/route")
public class RouteRestController {
	
	@Autowired
	RouteService routeService;
	
	@GetMapping("/")
	public List<RouteResDto> list(String userId) throws Exception {
		List<RouteResDto> list = routeService.selectMyList(userId);
		return list;
	}
	
	@PostMapping("/")
	public void insert(@RequestBody Map<String, Object> requestBody, HttpSession session) throws Exception {
		List<Integer> attrids = (List<Integer>) requestBody.get("attractions");
	    String title = (String) requestBody.get("title");
		
		routeService.insertRoute(new RouteDto("ww", title, attrids));
	}
	 
	@PutMapping("/")
	public void update(@RequestBody RouteDto routeDto) throws Exception {
		routeService.updateRoute(routeDto);
	}
	
	@DeleteMapping("/{routeid}")
	public void delete(@PathVariable("routeid") int routeId) throws Exception {
		routeService.deleteRoute(routeId);
	}
	
	@GetMapping("/{routeid}")
	public RouteResDto view(@PathVariable("routeid") int routeId) throws Exception {
		RouteResDto routeDto = routeService.selectRoute(routeId);
		return routeDto;
	}

}
