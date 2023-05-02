package ssafy.ws.trip.hotplacearticle.dto;


public class HotplaceArticleDto {
	private int articleNo;
	private int routeId;
	private int attractionId;
	private int orderId;
	private String userId;
	private String title;
	private String content;
	private int hit;
	private String createdAt;
	private String filename;
	private String filepath;
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
	}
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public int getAttractionId() {
		return attractionId;
	}
	public void setAttractionId(int attractionId) {
		this.attractionId = attractionId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	@Override
	public String toString() {
		return "HotplaceArticleDto [articleNo=" + articleNo + ", routeId=" + routeId + ", attractionId=" + attractionId
				+ ", orderId=" + orderId + ", userId=" + userId + ", title=" + title + ", content=" + content + ", hit="
				+ hit + ", createdAt=" + createdAt + ", filename=" + filename + ", filepath=" + filepath + "]";
	}
	
	
	
}
