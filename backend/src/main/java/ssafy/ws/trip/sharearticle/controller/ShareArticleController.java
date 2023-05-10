package ssafy.ws.trip.sharearticle.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ch.qos.logback.classic.spi.STEUtil;
import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.sharearticle.dto.ShareArticleDto;
import ssafy.ws.trip.sharearticle.service.ShareArticleService;
import ssafy.ws.trip.user.dto.UserDto;

@Controller
@RequestMapping("/sharearticle")
public class ShareArticleController {
	
	@Autowired
	@Qualifier("ShareArticleMapperServiceImpl")
	private ShareArticleService shareArticleService;
	
//	@GetMapping("")
//	public ModelAndView list() throws Exception {
//		System.out.println("inform");
//		ModelAndView mav = new ModelAndView();
//		List<InformArticleDto> list = informArticleService.listArticle();
//		mav.addObject("articles", list);
//		mav.setViewName("/trip/informlist");
//		return mav;
//	}
	
	@GetMapping("")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		System.out.println("list parameter pgno : "+ map.get("pgno"));
		ModelAndView mav = new ModelAndView();
		List<ShareArticleDto> list = shareArticleService.listArticle(map);
		PageNavigation pageNavigation = shareArticleService.makePageNavigation(map);
		mav.addObject("articles", list);
		mav.addObject("navigation", pageNavigation);
		mav.addObject("pgno", map.get("pgno"));
		mav.addObject("key", map.get("key"));
		mav.addObject("word", map.get("word"));
		mav.setViewName("/trip/list");
		return mav;
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("articleno") int articleNo, HttpSession session, @RequestParam Map<String, String> map, Model model)
			throws Exception {
		System.out.println("view articleNo : "+ articleNo);
		ShareArticleDto shareArticleDto = shareArticleService.getArticle(articleNo);
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			shareArticleDto.setUserId(userDto.getId());
		}
		shareArticleDto.setArticleNo(articleNo);
		System.out.println("view obj ::"+shareArticleDto.toString());
		shareArticleService.updateHit(articleNo);
		model.addAttribute("article", shareArticleDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "/trip/list_contents";
	}
	
	@GetMapping("/makinglist")
	public String write(@RequestParam Map<String, String> map, Model model) {
		System.out.println("list parameter pgno : "+ map.get("pgno"));
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "/trip/makinglist";
	}
	
	@PostMapping("/write")
	public String write(ShareArticleDto shareArticleDto ,HttpSession session,
			RedirectAttributes redirectAttributes) throws SQLException {
		System.out.println("post write " + shareArticleDto.toString());
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		shareArticleDto.setUserId(userDto.getId());
		shareArticleService.writeArticle(shareArticleDto);
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		return "redirect:/sharearticle";
	}
	
	
	@GetMapping("/modify")
	public String modify(@RequestParam("articleno") int articleNo, HttpSession session, 
			@RequestParam Map<String, String> map, Model model)
			throws Exception {
		System.out.println("modify parameter pgno : "+ map.get("pgno"));
		ShareArticleDto shareArticleDto = shareArticleService.getArticle(articleNo);
		shareArticleDto.setArticleNo(articleNo);
		UserDto userDto = (UserDto) session.getAttribute("userinfo");
		if(userDto != null) {
			shareArticleDto.setUserId(userDto.getId());
		}
		System.out.println(shareArticleDto.toString());
		model.addAttribute("article", shareArticleDto);
		model.addAttribute("pgno", map.get("pgno"));
		model.addAttribute("key", map.get("key"));
		model.addAttribute("word", map.get("word"));
		return "trip/modifylist";
	}
//
	@PostMapping("/modify")
	public String modify(ShareArticleDto shareArticleDto, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("post modify parameter pgno : "+ map.get("pgno"));
		System.out.println(":: post modify ::" + shareArticleDto.toString());
		shareArticleService.modifyArticle(shareArticleDto);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		return "redirect:/sharearticle";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map,
			RedirectAttributes redirectAttributes) throws Exception {
		System.out.println("delete "+articleNo);
		shareArticleService.deleteArticle(articleNo);
		redirectAttributes.addAttribute("pgno", map.get("pgno"));
		redirectAttributes.addAttribute("key", map.get("key"));
		redirectAttributes.addAttribute("word", map.get("word"));
		return "redirect:/sharearticle";
	}
	
}
