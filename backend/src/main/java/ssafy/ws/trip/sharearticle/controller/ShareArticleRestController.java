package ssafy.ws.trip.sharearticle.controller;

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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ssafy.ws.trip.config.PageNavigation;
import ssafy.ws.trip.sharearticle.dto.ShareArticleDto;
import ssafy.ws.trip.sharearticle.service.ShareArticleService;
import ssafy.ws.trip.user.dto.UserDto;

// http://localhost:8080/enjoytrip/sharearticlerest/share?pgno=1&key&word


@RestController
@RequestMapping("/sharearticlerest")
@CrossOrigin("*")
public class ShareArticleRestController {
	
	@Autowired
	@Qualifier("ShareArticleMapperServiceImpl")
	private ShareArticleService shareArticleService;
	
	@RequestMapping(value = "/share", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public Map<String, Object> shareBoardList(@RequestParam Map<String, String> map) throws Exception {
		List<ShareArticleDto> list = shareArticleService.listArticle(map);
		PageNavigation pageNavigation = shareArticleService.makePageNavigation(map);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("articles", list);
		ret.put("navigation", pageNavigation);
		return ret;
	}
	

	
	@RequestMapping(value = "/share/{articleno}", method = RequestMethod.GET, headers = { "Content-type=application/json" })
	public Map<String, Object> shareBoardView(@PathVariable("articleno") int articleNo) throws Exception {
		ShareArticleDto shareArticleDto = shareArticleService.getArticle(articleNo);
		shareArticleDto.setArticleNo(articleNo);
		System.out.println("view obj ::"+shareArticleDto.toString());
		shareArticleService.updateHit(articleNo);
		Map<String, Object> ret = new HashMap<String, Object>();
		ret.put("article", shareArticleDto);
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}

	
	@RequestMapping(value = "/share", method = RequestMethod.POST, headers = { "Content-type=application/json" })
	public Map<String, Object> shareBoardWrite(@RequestBody Map<String, Object> map) throws Exception {
//		ShareArticleDto shareArticleDto = (ShareArticleDto) map.get("shareArticleDto");
		ShareArticleDto shareArticleDto = new ShareArticleDto();
		shareArticleDto.setUserId("1234");
		shareArticleDto.setTitle((String)map.get("title"));
		shareArticleDto.setContent((String)map.get("content"));
		shareArticleService.writeArticle(shareArticleDto);
		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}
	
	

	@RequestMapping(value = "/share", method = RequestMethod.PUT, headers = { "Content-type=application/json" })
	public Map<String, Object> shareBoardModify(@RequestBody Map<String, Object> map) throws Exception {
		ShareArticleDto shareArticleDto = new ShareArticleDto();
		shareArticleDto.setUserId("1234");
		shareArticleDto.setArticleNo((int)map.get("articleNo"));
		shareArticleDto.setTitle((String)map.get("title"));
		shareArticleDto.setContent((String)map.get("content"));
		shareArticleService.modifyArticle(shareArticleDto);
		Map<String, Object> ret = new HashMap<String, Object>();
//		ret.put("pgno", map.get("pgno"));
//		ret.put("key", map.get("key"));
//		ret.put("word", map.get("word"));
		return ret;
	}

	
	@RequestMapping(value = "/share/{articleno}", method = RequestMethod.DELETE, headers = { "Content-type=application/json" })
	public Map<String, Object> shareBoardDelete(@PathVariable("articleno") int articleNo) throws Exception {
		shareArticleService.deleteArticle(articleNo);
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
//		List<shareArticleDto> list = shareArticleService.listArticle(map);
//		PageNavigation pageNavigation = shareArticleService.makePageNavigation(map);
//		mav.addObject("articles", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
//		mav.setViewName("/trip/sharelist");
//		return mav;
//	}
	
//	@GetMapping("/view")
//	public String view(@RequestParam("articleno") int articleNo, HttpSession session, @RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		System.out.println("view articleNo : "+ articleNo);
//		shareArticleDto shareArticleDto = shareArticleService.getArticle(articleNo);
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		if(userDto != null) {
//			shareArticleDto.setUserId(userDto.getId());
//		}
//		shareArticleDto.setArticleNo(articleNo);
//		System.out.println("view obj ::"+shareArticleDto.toString());
//		shareArticleService.updateHit(articleNo);
//		model.addAttribute("article", shareArticleDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "/trip/sharelist_contents";
//	}
	
//	@GetMapping("/makinglist")
//	public String write(@RequestParam Map<String, String> map, Model model) {
//		System.out.println("list parameter pgno : "+ map.get("pgno"));
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "/trip/makingsharelist";
//	}
	
//	@PostMapping("/write")
//	public String write(shareArticleDto shareArticleDto ,HttpSession session,
//			RedirectAttributes redirectAttributes) throws SQLException {
//		System.out.println("post write " + shareArticleDto.toString());
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		shareArticleDto.setUserId(userDto.getId());
//		shareArticleService.writeArticle(shareArticleDto);
//		redirectAttributes.addAttribute("pgno", "1");
//		redirectAttributes.addAttribute("key", "");
//		redirectAttributes.addAttribute("word", "");
//		return "redirect:/sharearticle";
//	}
	
//	@GetMapping("/modify")
//	public String modify(@RequestParam("articleno") int articleNo, HttpSession session, 
//			@RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		System.out.println("modify parameter pgno : "+ map.get("pgno"));
//		shareArticleDto shareArticleDto = shareArticleService.getArticle(articleNo);
//		shareArticleDto.setArticleNo(articleNo);
//		UserDto userDto = (UserDto) session.getAttribute("userinfo");
//		if(userDto != null) {
//			shareArticleDto.setUserId(userDto.getId());
//		}
//		System.out.println(shareArticleDto.toString());
//		model.addAttribute("article", shareArticleDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "trip/modifysharelist";
//	}
	
//	@PostMapping("/modify")
//	public String modify(shareArticleDto shareArticleDto, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		System.out.println("post modify parameter pgno : "+ map.get("pgno"));
//		System.out.println(":: post modify ::" + shareArticleDto.toString());
//		shareArticleService.modifyArticle(shareArticleDto);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/sharearticle";
//	}

//	@GetMapping("/delete")
//	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		System.out.println("delete "+articleNo);
//		shareArticleService.deleteArticle(articleNo);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/sharearticle";
//	}
	
}
