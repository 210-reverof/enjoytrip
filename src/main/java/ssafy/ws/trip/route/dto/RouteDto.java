package ssafy.ws.trip.route.dto;

import java.util.List;

public class RouteDto {
	int routeId;
	String userId;
	List<Integer> attractions;

	public RouteDto(int routeId, String userId, List<Integer> attractions) {
		this.routeId = routeId;
		this.userId = userId;
		this.attractions = attractions;
	}
	
	public int getRouteId() {
		return routeId;
	}
	
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public List<Integer> getAttractions() {
		return attractions;
	}
	
	public void setAttractions(List<Integer> attractions) {
		this.attractions = attractions;
	}

	@Override
	public String toString() {
		return "RouteDto [routeId=" + routeId + ", userId=" + userId + ", attractions=" + attractions + "]";
	}
	
}
