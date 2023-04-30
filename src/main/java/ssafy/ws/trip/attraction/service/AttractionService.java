package ssafy.ws.trip.attraction.service;

import ssafy.ws.trip.attraction.dto.AttractionDto;

public interface AttractionService {
	AttractionDto selectOne(int contentId);
}
