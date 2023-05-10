package ssafy.ws.trip.route.dto;

import java.util.ArrayList;
import java.util.List;

public class RouteResDto {
	int routeId;
	String userId;
	String title;
	List<RouteAttrDto> attractions = new ArrayList<>();
	String createdAt;
	
	public RouteResDto(int routeId, String userId, String title,  String createdAt) {
		this.routeId = routeId;
		this.userId = userId;
		this.title = title;
		this.createdAt = createdAt;
	}

	public RouteResDto(int routeId, String userId, String title, List<RouteAttrDto> attractions, String createdAt) {
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
	public List<RouteAttrDto> getAttractions() {
		return attractions;
	}
	public void setAttractions(List<RouteAttrDto> attractions) {
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
