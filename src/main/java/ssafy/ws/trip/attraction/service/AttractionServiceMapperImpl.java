package ssafy.ws.trip.attraction.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssafy.ws.trip.attraction.dto.AttractionDto;
import ssafy.ws.trip.attraction.repository.AttractionRepository;

@Service
public class AttractionServiceMapperImpl implements AttractionService {
	
	@Autowired
	private SqlSession session;


	@Override
	public AttractionDto selectOne(int contentId) {
		return session.getMapper(AttractionRepository.class).selectOne(contentId);
	}

}
