package ssafy.ws.trip.attraction.controller;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import ssafy.ws.trip.attraction.dto.AttractionDto;
import ssafy.ws.trip.attraction.dto.GugunDto;
import ssafy.ws.trip.attraction.dto.SidoDto;
import ssafy.ws.trip.attraction.service.AttractionService;

@RestController
@RequestMapping("/attraction")
public class AttractionController {
	
	@Autowired
	AttractionService attractionService;
	
	@GetMapping("/{id}")
	public AttractionDto one(@PathVariable("id") int contentId) throws Exception {
		return attractionService.selectOne(contentId);
	}
	
	@GetMapping("/list")
	public List<AttractionDto> list(int sido, int gugun, @RequestParam("types") int[] types) throws Exception {
		return attractionService.selectList(sido, gugun, types);
	}
	
	@GetMapping("/idlist")
	public List<AttractionDto> idlist(@RequestParam("types") int[] ids) throws Exception {
		System.out.println("idlist: " + attractionService.selectIdList(ids));
		return attractionService.selectIdList(ids);
	}
	
	@GetMapping("/sido")
	public List<SidoDto> sido() throws Exception {
		return attractionService.selectSidoList();
	}
	
	@GetMapping("/gugun/{sidoCode}")
	public List<GugunDto> gugun(@PathVariable("sidoCode") int sidoCode) throws Exception {
		return attractionService.selectGugunList(sidoCode);
	}
}