package ssafy.ws.trip.sharearticle.dto;


public class ShareArticleDto {
	private int articleNo;
	private String userId;
	private String title;
	private String content;
	private int hit;
	private String createdAt;
	
	
	public int getArticleNo() {
		return articleNo;
	}
	public void setArticleNo(int articleNo) {
		this.articleNo = articleNo;
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
	@Override
	public String toString() {
		return "ShareArticleDto [articleNo=" + articleNo + ", userId=" + userId + ", title=" + title + ", content="
				+ content + ", hit=" + hit + ", createdAt=" + createdAt + "]";
	}
	
}
