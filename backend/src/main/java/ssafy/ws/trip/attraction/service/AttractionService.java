package ssafy.ws.trip.attraction.service;

import java.util.List;

import ssafy.ws.trip.attraction.dto.AttractionDto;
import ssafy.ws.trip.attraction.dto.GugunDto;
import ssafy.ws.trip.attraction.dto.SidoDto;

public interface AttractionService {
	AttractionDto selectOne(int contentId);
	List<AttractionDto> selectList(int sidoCode, int gugunCode, int[] types);
	List<SidoDto> selectSidoList();
	List<GugunDto> selectGugunList(int sidoCode);
	List<AttractionDto> selectIdList(int[] types);
}
