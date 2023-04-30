package ssafy.ws.trip.attraction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ssafy.ws.trip.attraction.service.AttractionService;

@Controller
@RequestMapping("/attraction")
public class AttractionController {
	
	@Autowired
	AttractionService attractionService;
	
	@GetMapping("/one")
	public ModelAndView one() throws Exception {
		ModelAndView mv = new ModelAndView();
		System.out.println(attractionService.selectOne(125405));
		
		
		mv.setViewName("redirect:/");
		return mv;
	}


}