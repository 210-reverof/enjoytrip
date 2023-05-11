package ssafy.ws.trip.informarticle.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.informarticle.dto.InformArticleDto;
import ssafy.ws.trip.informarticle.service.InformArticleService;
import ssafy.ws.trip.user.dto.UserDto;

// http://localhost:8080/enjoytrip/informarticlerest/inform?pgno=1&key&word


@RestController
@RequestMapping("/informarticlerest")
@CrossOrigin("*")
public class InformArticleRestController {
	
	@Autowired
	@Qualifier("InformArticleMapperServiceImpl")
	private InformArticleService informArticleService;
	
//	@RequestMapping(value = "/inform", method = RequestMethod.GET, headers = { "Content-type=application/json" })
//	public Map<String, Object> informBoardList(@RequestParam Map<String, String> map) throws Exception {
//		List<InformArticleDto> list = informArticleService.listArticle(map);
//		PageNavigation pageNavigation = informArticleService.makePageNavigation(map);
//		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("articles", list);
//		ret.put("navigation", pageNavigation);
//		return ret;
//	}
	@GetMapping("/inform")
	public Map<String, Object> informBoardList(@RequestParam Map<String, String> map) throws Exception {
		List<InformArticleDto> list = informArticleService.listArticle(map);
		PageNavigation pageNavigation = informArticleService.makePageNavigation(map);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("articles", list);
		ret.put("navigation", pageNavigation);
		return ret;
	}
	

	
	@GetMapping("/inform/{articleno}")
	public Map<String, Object> informBoardView(@PathVariable("articleno") int articleNo) throws Exception {
		System.out.println(articleNo);
		InformArticleDto informArticleDto = informArticleService.getArticle(articleNo);
//		UserDto userDto = (UserDto) map.get("userinfo");
//		if(userDto != null) {
//			informArticleDto.setUserId(userDto.getId());
//		}
		informArticleDto.setArticleNo(articleNo);
		System.out.println("view obj ::"+informArticleDto.toString());
		informArticleService.updateHit(articleNo);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("article", informArticleDto);
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}

	
	@PostMapping("/inform")
	public Map<String, Object> informBoardWrite(@RequestBody Map<String, Object> map) throws Exception {
		InformArticleDto informArticleDto = (InformArticleDto) map.get("informArticleDto");
		UserDto userDto = (UserDto) map.get("userinfo");
		informArticleService.writeArticle(informArticleDto);
		if(userDto != null) informArticleDto.setUserId(userDto.getId());
		else informArticleDto.setUserId("1234");
		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}
	
	

	@PutMapping("/inform")
	public int informBoardModify(@RequestBody Map<String, Object> map) throws Exception {
		InformArticleDto informArticleDto = (InformArticleDto) map.get("informArticleDto");
		informArticleService.modifyArticle(informArticleDto);
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return informArticleDto.getArticleNo();
	}

	
	@DeleteMapping("/inform/{articleno}")
//	public Map<String, Object> informBoardDelete(@RequestParam Map<String, Object> map) throws Exception {
	public void informBoardDelete(@PathVariable("articleno") int articleNo) throws Exception {
		informArticleService.deleteArticle(articleNo);
//		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
//		return ret;
	}
	
	
	
	
	
//	@GetMapping("")
//	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
//		System.out.println("list parameter pgno : "+ map.get("pgno"));
//		ModelAndView mav = new ModelAndView();
//		List<InformArticleDto> list = informArticleService.listArticle(map);
//		PageNavigation pageNavigation = informArticleService.makePageNavigation(map);
//		mav.addObject("articles", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
//		mav.setViewName("/trip/informlist");
//		return mav;
//	}
	
//	@GetMapping("/view")
//	public String view(@RequestParam("articleno") int articleNo, HttpSession session, @RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		System.out.println("view articleNo : "+ articleNo);
//		InformArticleDto informArticleDto = informArticleService.getArticle(articleNo);
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		if(userDto != null) {
//			informArticleDto.setUserId(userDto.getId());
//		}
//		informArticleDto.setArticleNo(articleNo);
//		System.out.println("view obj ::"+informArticleDto.toString());
//		informArticleService.updateHit(articleNo);
//		model.addAttribute("article", informArticleDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "/trip/informlist_contents";
//	}
	
//	@GetMapping("/makinglist")
//	public String write(@RequestParam Map<String, String> map, Model model) {
//		System.out.println("list parameter pgno : "+ map.get("pgno"));
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "/trip/makinginformlist";
//	}
	
//	@PostMapping("/write")
//	public String write(InformArticleDto informArticleDto ,HttpSession session,
//			RedirectAttributes redirectAttributes) throws SQLException {
//		System.out.println("post write " + informArticleDto.toString());
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		informArticleDto.setUserId(userDto.getId());
//		informArticleService.writeArticle(informArticleDto);
//		redirectAttributes.addAttribute("pgno", "1");
//		redirectAttributes.addAttribute("key", "");
//		redirectAttributes.addAttribute("word", "");
//		return "redirect:/informarticle";
//	}
	
//	@GetMapping("/modify")
//	public String modify(@RequestParam("articleno") int articleNo, HttpSession session, 
//			@RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		System.out.println("modify parameter pgno : "+ map.get("pgno"));
//		InformArticleDto informArticleDto = informArticleService.getArticle(articleNo);
//		informArticleDto.setArticleNo(articleNo);
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		if(userDto != null) {
//			informArticleDto.setUserId(userDto.getId());
//		}
//		System.out.println(informArticleDto.toString());
//		model.addAttribute("article", informArticleDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "trip/modifyinformlist";
//	}
	
//	@PostMapping("/modify")
//	public String modify(InformArticleDto informArticleDto, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		System.out.println("post modify parameter pgno : "+ map.get("pgno"));
//		System.out.println(":: post modify ::" + informArticleDto.toString());
//		informArticleService.modifyArticle(informArticleDto);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/informarticle";
//	}

//	@GetMapping("/delete")
//	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		System.out.println("delete "+articleNo);
//		informArticleService.deleteArticle(articleNo);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/informarticle";
//	}
	
}
