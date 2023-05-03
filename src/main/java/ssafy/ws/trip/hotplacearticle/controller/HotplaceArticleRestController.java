package ssafy.ws.trip.hotplacearticle.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.hotplacearticle.dto.HotplaceArticleDto;
import ssafy.ws.trip.hotplacearticle.service.HotplaceArticleService;
import ssafy.ws.trip.user.dto.UserDto;

// http://localhost:8080/enjoytrip/hotplacearticlerest/hotplace?pgno=1&key&word


@RestController
@RequestMapping("/hotplacearticlerest")
@CrossOrigin("*")
public class HotplaceArticleRestController {
	
	@Autowired
	@Qualifier("HotplaceArticleMapperServiceImpl")
	private HotplaceArticleService hotplaceArticleService;
	
	@RequestMapping(value = "/hotplace", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public Map<String, Object> hotplaceBoardList(@RequestParam Map<String, String> map) throws Exception {
		List<HotplaceArticleDto> list = hotplaceArticleService.listArticle(map);
		PageNavigation pageNavigation = hotplaceArticleService.makePageNavigation(map);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("articles", list);
		ret.put("navigation", pageNavigation);
		return ret;
	}

	
	@RequestMapping(value = "/hotplace/{articleno}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public Map<String, Object> hotplaceBoardView(@RequestParam Map<String, Object> map) throws Exception {
		int articleNo = (int)map.get("articleNo");
		HotplaceArticleDto hotplaceArticleDto = hotplaceArticleService.getArticle(articleNo);
		UserDto userDto = (UserDto) map.get("userinfo");
		if(userDto != null) {
			hotplaceArticleDto.setUserId(userDto.getId());
		}
		hotplaceArticleDto.setArticleNo(articleNo);
		System.out.println("view obj ::"+hotplaceArticleDto.toString());
		hotplaceArticleService.updateHit(articleNo);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("article", hotplaceArticleDto);
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}

	
	@RequestMapping(value = "/hotplace", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public Map<String, Object> hotplaceBoardWrite(@RequestBody Map<String, Object> map) throws Exception {
		HotplaceArticleDto hotplaceArticleDto = (HotplaceArticleDto) map.get("hotplaceArticleDto");
		UserDto userDto = (UserDto) map.get("userinfo");
		hotplaceArticleService.writeArticle(hotplaceArticleDto, (MultipartFile)map.get("file"));
		hotplaceArticleDto.setUserId(userDto.getId());
		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}
	

	@RequestMapping(value = "/hotplace", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public Map<String, Object> hotplaceBoardModify(@RequestBody Map<String, Object> map) throws Exception {
		HotplaceArticleDto hotplaceArticleDto = (HotplaceArticleDto) map.get("hotplaceArticleDto");
		hotplaceArticleService.modifyArticle(hotplaceArticleDto, (MultipartFile)map.get("file"));
		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}

	
	@RequestMapping(value = "/hotplace/{articleno}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public Map<String, Object> hotplaceBoardDelete(@RequestParam Map<String, Object> map) throws Exception {
		int articleNo = (int)map.get("articleNo");
		hotplaceArticleService.deleteArticle(articleNo);
		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}
	
	
	
	
	
//	@GetMapping("")
//	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
//		System.out.println("list parameter pgno : "+ map.get("pgno"));
//		ModelAndView mav = new ModelAndView();
//		List<hotplaceArticleDto> list = hotplaceArticleService.listArticle(map);
//		PageNavigation pageNavigation = hotplaceArticleService.makePageNavigation(map);
//		mav.addObject("articles", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
//		mav.setViewName("/trip/hotplacelist");
//		return mav;
//	}
	
//	@GetMapping("/view")
//	public String view(@RequestParam("articleno") int articleNo, HttpSession session, @RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		System.out.println("view articleNo : "+ articleNo);
//		hotplaceArticleDto hotplaceArticleDto = hotplaceArticleService.getArticle(articleNo);
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		if(userDto != null) {
//			hotplaceArticleDto.setUserId(userDto.getId());
//		}
//		hotplaceArticleDto.setArticleNo(articleNo);
//		System.out.println("view obj ::"+hotplaceArticleDto.toString());
//		hotplaceArticleService.updateHit(articleNo);
//		model.addAttribute("article", hotplaceArticleDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "/trip/hotplacelist_contents";
//	}
	
//	@GetMapping("/makinglist")
//	public String write(@RequestParam Map<String, String> map, Model model) {
//		System.out.println("list parameter pgno : "+ map.get("pgno"));
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "/trip/makinghotplacelist";
//	}
	
//	@PostMapping("/write")
//	public String write(hotplaceArticleDto hotplaceArticleDto ,HttpSession session,
//			RedirectAttributes redirectAttributes) throws SQLException {
//		System.out.println("post write " + hotplaceArticleDto.toString());
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		hotplaceArticleDto.setUserId(userDto.getId());
//		hotplaceArticleService.writeArticle(hotplaceArticleDto);
//		redirectAttributes.addAttribute("pgno", "1");
//		redirectAttributes.addAttribute("key", "");
//		redirectAttributes.addAttribute("word", "");
//		return "redirect:/hotplacearticle";
//	}
	
//	@GetMapping("/modify")
//	public String modify(@RequestParam("articleno") int articleNo, HttpSession session, 
//			@RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		System.out.println("modify parameter pgno : "+ map.get("pgno"));
//		hotplaceArticleDto hotplaceArticleDto = hotplaceArticleService.getArticle(articleNo);
//		hotplaceArticleDto.setArticleNo(articleNo);
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		if(userDto != null) {
//			hotplaceArticleDto.setUserId(userDto.getId());
//		}
//		System.out.println(hotplaceArticleDto.toString());
//		model.addAttribute("article", hotplaceArticleDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "trip/modifyhotplacelist";
//	}
	
//	@PostMapping("/modify")
//	public String modify(hotplaceArticleDto hotplaceArticleDto, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		System.out.println("post modify parameter pgno : "+ map.get("pgno"));
//		System.out.println(":: post modify ::" + hotplaceArticleDto.toString());
//		hotplaceArticleService.modifyArticle(hotplaceArticleDto);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/hotplacearticle";
//	}

//	@GetMapping("/delete")
//	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		System.out.println("delete "+articleNo);
//		hotplaceArticleService.deleteArticle(articleNo);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/hotplacearticle";
//	}
	
}
