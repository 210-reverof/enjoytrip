package ssafy.ws.trip.route.repository;

import java.util.List;

import ssafy.ws.trip.route.dto.RouteAttrDto;
import ssafy.ws.trip.route.dto.RouteDto;
import ssafy.ws.trip.route.dto.RouteResDto;

public interface RouteRepository {
	List<RouteResDto> selectMyList(String userId) throws Exception;
	int insertRoute(RouteDto routes) throws Exception;
	void insertRouteAttrs(int routeId, int attractionId, int order);
	void updateRoute(RouteDto routes) throws Exception;
	void deleteRoute(int routeId) throws Exception;
	void deleteRouteAttrs(int routeId) throws Exception;
	RouteResDto selectRoute(int routeId) throws Exception;
	List<RouteAttrDto> selectRouteAttrs(int routeId);
}
