package ssafy.ws.trip.route.service;

import java.util.List;

import ssafy.ws.trip.route.dto.RouteDto;
import ssafy.ws.trip.route.dto.RouteResDto;

public interface RouteService {
	List<RouteResDto> selectMyList() throws Exception;
	void insertRoute(RouteDto routes) throws Exception;
	void updateRoute(RouteDto routes) throws Exception;
	void deleteRoute(int routeId) throws Exception;
	RouteResDto selectRoute(int routeId) throws Exception;
}
