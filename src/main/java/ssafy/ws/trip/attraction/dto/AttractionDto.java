package ssafy.ws.trip.attraction.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

public class AttractionDto {
	int contentId;
	int contentTypeId;	// 관광타입(12:관광지, 14:문화시설, 15:축제공연행사, 25:여행코스, 28:레포츠, 32:숙박, 38:쇼핑, 39:음식점)
	String overview;
	String title;
	String addr1;
	String firstImage;
	int sidoCode;
	String sidoName;
	int gugunCode;
	String gugunName;
	double latitude;
	double longitude;
	
	public int getContentId() {
		return contentId;
	}
	
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	public int getContentTypeId() {
		return contentTypeId;
	}
	
	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}
	
	public String getOverview() {
		return overview;
	}
	
	public void setOverview(String overview) {
		this.overview = overview;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getAddr1() {
		return addr1;
	}
	
	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}
	
	public String getFirstImage() {
		return firstImage;
	}
	
	public void setFirstImage(String firstImage) {
		this.firstImage = firstImage;
	}
	
	public int getSidoCode() {
		return sidoCode;
	}
	
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	
	public String getSidoName() {
		return sidoName;
	}
	
	public void setSidoName(String sidoName) {
		this.sidoName = sidoName;
	}
	
	public int getGugunCode() {
		return gugunCode;
	}
	
	public void setGugunCode(int gugunCode) {
		this.gugunCode = gugunCode;
	}
	
	public String getGugunName() {
		return gugunName;
	}
	
	public void setGugunName(String gugunName) {
		this.gugunName = gugunName;
	}
	
	public double getLatitude() {
		return latitude;
	}
	
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "AttractionDto [contentId=" + contentId + ", contentTypeId=" + contentTypeId + ","
				+ ", title=" + title + ", addr1=" + addr1 + ", firstImage=" + firstImage + ", sidoCode=" + sidoCode
				+ ", sidoName=" + sidoName + ", gugunCode=" + gugunCode + ", gugunName=" + gugunName + ", latitude="
				+ latitude + ", longitude=" + longitude + "]";
	}
	
	
}
