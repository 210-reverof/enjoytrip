package ssafy.ws.trip.attraction.repository;

import ssafy.ws.trip.attraction.dto.AttractionDto;

public interface AttractionRepository {
	AttractionDto selectOne(int contentId);
}
