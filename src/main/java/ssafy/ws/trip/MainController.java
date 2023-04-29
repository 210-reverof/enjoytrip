package ssafy.ws.trip;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/") 
	public String index() {
		return "index";
	}
	
	@GetMapping("/searchpage") 
	public String search() {
		return "/trip/search";
	}
	
	@GetMapping("/routepage") 
	public String route() {
		return "/trip/my_route";
	}
	
	
	// TODO :: 수정 요함
	@GetMapping("/sharelistpage") 
	public String sharelist() {
		return "/sharearticle/list";
	}
	
	// TODO :: 수정 요함
	@GetMapping("/informlistpage") 
	public String informlist() {
		return "/informarticle/list";
	}
}
