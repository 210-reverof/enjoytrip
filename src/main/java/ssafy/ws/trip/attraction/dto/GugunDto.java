package ssafy.ws.trip.attraction.dto;

public class GugunDto {
	int gugunCode;
	String gugunName;
	int sidoCode;
	
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
	
	public int getSidoCode() {
		return sidoCode;
	}
	
	public void setSidoCode(int sidoCode) {
		this.sidoCode = sidoCode;
	}
	
	@Override
	public String toString() {
		return "GugunDto [gugunCode=" + gugunCode + ", gugunName=" + gugunName + ", sidoCode=" + sidoCode + "]";
	}

}
