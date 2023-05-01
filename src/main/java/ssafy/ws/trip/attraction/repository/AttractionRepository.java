package ssafy.ws.trip.attraction.repository;

import java.util.List;

import ssafy.ws.trip.attraction.dto.AttractionDto;
import ssafy.ws.trip.attraction.dto.GugunDto;
import ssafy.ws.trip.attraction.dto.SidoDto;

public interface AttractionRepository {
	AttractionDto selectOne(int contentId);
	List<AttractionDto> selectList(int sidoCode, int gugunCode, int[] types);
	List<SidoDto> selectSidoList();
	List<GugunDto> selectGugunList(int sidoCode);
}
