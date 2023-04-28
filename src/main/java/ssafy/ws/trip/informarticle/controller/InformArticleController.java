package ssafy.ws.trip.informarticle.controller;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import ch.qos.logback.classic.spi.STEUtil;
import ssafy.ws.trip.informarticle.dto.InformArticleDto;
import ssafy.ws.trip.informarticle.service.InformArticleService;

@Controller
@RequestMapping("/informarticle")
public class InformArticleController {
	
	private InformArticleService informArticleService;

	public InformArticleController(InformArticleService informArticleService) {
		super();
		this.informArticleService = informArticleService;
	}
	
	@GetMapping("/list")
	public ModelAndView list(@RequestParam Map<String, String> map) throws Exception {
		System.out.printf("list parameter pgno : {}\n", map.get("pgno"));
		ModelAndView mav = new ModelAndView();
//		List<InformArticleDto> list = informArticleService.listArticle(map);
		List<InformArticleDto> list = informArticleService.listArticle();
//		PageNavigation pageNavigation = informArticleService.makePageNavigation(map);
		mav.addObject("articles", list);
//		mav.addObject("navigation", pageNavigation);
//		mav.addObject("pgno", map.get("pgno"));
//		mav.addObject("key", map.get("key"));
//		mav.addObject("word", map.get("word"));
		mav.setViewName("/trip/informlist");
		return mav;
	}
	
	@GetMapping("/view")
	public String view(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model)
			throws Exception {
		System.out.printf("view articleNo : {}", articleNo);
		InformArticleDto informArticleDto = informArticleService.getArticle(articleNo);
		informArticleService.updateHit(articleNo);
		model.addAttribute("article", informArticleDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
		return "/trip/informlist_contents";
	}
	
	@GetMapping("/makinglist")
	public String write(@RequestParam Map<String, String> map, Model model) {
		System.out.printf("write call parameter {}", map);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
		return "trip/makinginformlist";
	}
	
	@PostMapping("/write")
	public String write(InformArticleDto informArticleDt,HttpSession session,
			RedirectAttributes redirectAttributes) throws SQLException {
		informArticleService.writeArticle(informArticleDt);
		redirectAttributes.addAttribute("pgno", "1");
		redirectAttributes.addAttribute("key", "");
		redirectAttributes.addAttribute("word", "");
		return "redirect:/article/list";
	}
	
	
//	@GetMapping("/modify")
//	public String modify(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map, Model model)
//			throws Exception {
//		logger.debug("modify articleNo : {}", articleNo);
//		BoardDto boardDto = boardService.getArticle(articleNo);
//		model.addAttribute("article", boardDto);
//		model.addAttribute("pgno", map.get("pgno"));
//		model.addAttribute("key", map.get("key"));
//		model.addAttribute("word", map.get("word"));
//		return "board/modify";
//	}
//
//	@PostMapping("/modify")
//	public String modify(BoardDto boardDto, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		logger.debug("modify boardDto : {}", boardDto);
//		boardService.modifyArticle(boardDto);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/article/list";
//	}
//
//	@GetMapping("/delete")
//	public String delete(@RequestParam("articleno") int articleNo, @RequestParam Map<String, String> map,
//			RedirectAttributes redirectAttributes) throws Exception {
//		logger.debug("delete articleNo : {}", articleNo);
//		boardService.deleteArticle(articleNo, uploadPath);
//		redirectAttributes.addAttribute("pgno", map.get("pgno"));
//		redirectAttributes.addAttribute("key", map.get("key"));
//		redirectAttributes.addAttribute("word", map.get("word"));
//		return "redirect:/article/list";
//	}
//
//	@GetMapping("/download")
//	public ModelAndView downloadFile(@RequestParam("sfolder") String sfolder, @RequestParam("ofile") String ofile,
//			@RequestParam("sfile") String sfile) {
//		Map<String, Object> fileInfo = new HashMap<String, Object>();
//		fileInfo.put("sfolder", sfolder);
//		fileInfo.put("ofile", ofile);
//		fileInfo.put("sfile", sfile);
//		return new ModelAndView("fileDownLoadView", "downloadFile", fileInfo);
//	}
	
}
