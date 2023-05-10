package ssafy.ws.trip.attraction.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssafy.ws.trip.attraction.dto.AttractionDto;
import ssafy.ws.trip.attraction.dto.GugunDto;
import ssafy.ws.trip.attraction.dto.SidoDto;
import ssafy.ws.trip.attraction.repository.AttractionRepository;

@Service
public class AttractionServiceMapperImpl implements AttractionService {
	
	@Autowired
	private SqlSession session;


	@Override
	public AttractionDto selectOne(int contentId) {
		return session.getMapper(AttractionRepository.class).selectOne(contentId);
	}


	@Override
	public List<AttractionDto> selectList(int sidoCode, int gugunCode, int[] types) {
		return session.getMapper(AttractionRepository.class).selectList(sidoCode, gugunCode, types);
	}


	@Override
	public List<SidoDto> selectSidoList() {
		return session.getMapper(AttractionRepository.class).selectSidoList();
	}


	@Override
	public List<GugunDto> selectGugunList(int sidoCode) {
		return session.getMapper(AttractionRepository.class).selectGugunList(sidoCode);
	}


	@Override
	public List<AttractionDto> selectIdList(int[] types) {
		return session.getMapper(AttractionRepository.class).selectIdList(types);
	}

}