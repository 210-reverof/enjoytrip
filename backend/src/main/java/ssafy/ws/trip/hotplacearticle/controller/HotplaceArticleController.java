package ssafy.ws.trip.hotplacearticle.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ch.qos.logback.classic.spi.STEUtil;
import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.hotplacearticle.dto.HotplaceArticleDto;
import ssafy.ws.trip.hotplacearticle.service.HotplaceArticleService;
import ssafy.ws.trip.informarticle.dto.InformArticleDto;
import ssafy.ws.trip.informarticle.service.InformArticleService;
import ssafy.ws.trip.user.dto.UserDto;

@Controller
@RequestMapping("/hotplacearticle")
public class HotplaceArticleController {
	
	@Autowired
	@Qualifier("HotplaceArticleMapperServiceImpl")
	private HotplaceArticleService hotplaceArticleService;

	
	@GetMapping("")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		System.out.println("list parameter pgno : "+ map.get("pgno"));
		ModelAndView mav = new ModelAndView();
		List<HotplaceArticleDto> list = hotplaceArticleService.listArticle(map);
		PageNavigation pageNavigation = hotplaceArticleService.makePageNavigation(map);
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("/trip/hotplacelist");
		return mav;
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("articleno") int articleNo, HttpSession session, @RequestParam Map<String, String> map, Model model)
			throws Exception {
		System.out.println("view articleNo : "+ articleNo);
		HotplaceArticleDto hotplaceArticleDto = hotplaceArticleService.getArticle(articleNo);
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			hotplaceArticleDto.setUserId(userDto.getId());
		}
		hotplaceArticleDto.setArticleNo(articleNo);
		System.out.println("view obj ::"+hotplaceArticleDto.toString());
		hotplaceArticleService.updateHit(articleNo);
		model.addAttribute("article", hotplaceArticleDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "/trip/hotplacelist_contents";
	}
	
	@GetMapping("/makinglist")
	public String write(@RequestParam Map<String, String> map, Model model) {
		System.out.println("list parameter pgno : "+ map.get("pgno"));
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "/trip/hotplacemakinglist";
	}
	
//	@PostMapping("/write")
//	public ModelAndView write(HotplaceArticleDto hotplaceArticleDto ,HttpSession session,
//			RedirectAttributes redirectAttributes, MultipartFile file) throws Exception {
//		System.out.println("post write " + hotplaceArticleDto.toString());
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		hotplaceArticleDto.setUserId(userDto.getId());
//		hotplaceArticleService.writeArticle(hotplaceArticleDto, file);
//		ModelAndView mav = new ModelAndView();
//		mav.a
//		mav.addObject("pgno", "1");
//		mav.addObject("key", "");
//		mav.addObject("word", "");
//		mav.setViewName("/trip/hotplacelist_contents");
//		return mav;
//	}
	
	@PostMapping("/write")
	public String write(HotplaceArticleDto hotplaceArticleDto ,HttpSession session,
			RedirectAttributes redirectAttributes, MultipartFile file) throws Exception {
		System.out.println("post write " + hotplaceArticleDto.toString());
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		hotplaceArticleDto.setUserId(userDto.getId());
		hotplaceArticleService.writeArticle(hotplaceArticleDto, file);
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		
		return "redirect:/hotplacearticle";
	}
	
	
	@GetMapping("/modify")
	public String modify(@RequestParam("articleno") int articleNo, HttpSession session, 
			@RequestParam Map<String, String> map, Model model)
			throws Exception {
		System.out.println("modify parameter pgno : "+ map.get("pgno"));
		HotplaceArticleDto hotplaceArticleDto = hotplaceArticleService.getArticle(articleNo);
		hotplaceArticleDto.setArticleNo(articleNo);
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			hotplaceArticleDto.setUserId(userDto.getId());
		}
		System.out.println(hotplaceArticleDto.toString());
		model.addAttribute("article", hotplaceArticleDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "trip/hotplacemodifylist";
	}
//
	@PostMapping("/modify")
	public String modify(HotplaceArticleDto hotplaceArticleDto, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes, MultipartFile file) throws Exception {
		System.out.println("post modify parameter pgno : "+ map.get("pgno"));
		System.out.println(":: post modify ::" + hotplaceArticleDto.toString());
		hotplaceArticleService.modifyArticle(hotplaceArticleDto, file);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		return "redirect:/hotplacearticle";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("delete "+articleNo);
		hotplaceArticleService.deleteArticle(articleNo);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		return "redirect:/hotplacearticle";
	}
	
}
