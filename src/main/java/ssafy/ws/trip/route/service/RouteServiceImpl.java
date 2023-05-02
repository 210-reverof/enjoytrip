package ssafy.ws.trip.route.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ssafy.ws.trip.route.dto.RouteAttrDto;
import ssafy.ws.trip.route.dto.RouteDto;
import ssafy.ws.trip.route.dto.RouteResDto;
import ssafy.ws.trip.route.repository.RouteRepository;
import ssafy.ws.trip.user.repository.UserRepository;

@Service
public class RouteServiceImpl implements RouteService {
	
	@Autowired
	private SqlSession session; 
 
	@Override
	public List<RouteResDto> selectMyList(String userId) throws Exception {
		return session.getMapper(RouteRepository.class).selectMyList(userId);
	}

	@Override 
	public void insertRoute(RouteDto routeDto) throws Exception {
		int cnt = session.getMapper(RouteRepository.class).insertRoute(routeDto);
		for (int i = 0; i < routeDto.getAttractions().size(); i++) {
			session.getMapper(RouteRepository.class).insertRouteAttrs(routeDto.getRouteId(), routeDto.getAttractions().get(i), (i+1));
		}
	}

	@Override
	public void updateRoute(RouteDto routeDto) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRoute(int routeId) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public RouteResDto selectRoute(int routeId) throws Exception {
		RouteResDto dto = session.getMapper(RouteRepository.class).selectRoute(routeId);
		dto.setAttractions(session.getMapper(RouteRepository.class).selectRouteAttrs(routeId));
		return dto;
	}

}
