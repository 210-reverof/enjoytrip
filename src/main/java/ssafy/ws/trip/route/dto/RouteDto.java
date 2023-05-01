package ssafy.ws.trip.route.dto;

import java.util.List;

public class RouteDto {
	int routeId;
	String userId;
	String title;
	List<Integer> attractions;
	String createdAt;
	
	public RouteDto(String userId, String title, List<Integer> attractions) {
		this.userId = userId;
		this.title = title;
		this.attractions = attractions;
	}
	
	public RouteDto(int routeId, String userId, String title, List<Integer> attractions, String createdAt) {
		this.routeId = routeId;
		this.userId = userId;
		this.title = title;
		this.attractions = attractions;
		this.createdAt = createdAt;
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
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<Integer> getAttractions() {
		return attractions;
	}
	public void setAttractions(List<Integer> attractions) {
		this.attractions = attractions;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "RouteDto [routeId=" + routeId + ", userId=" + userId + ", title=" + title + ", attractions="
				+ attractions + ", createdAt=" + createdAt + "]";
	}	
}
