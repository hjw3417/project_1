package dc.human.whosthebest.dto;

public class UserInfoDTO {

	private String uID;
	private String uName;
	private String uBday;
	private String uAddr1;
	private String uAddr2;
	private String uEmail;
	private String uPhone;
	private String uPW;
	private byte[] uPhoto;
	private String createdID;
	private String createdDate;
	private String updatedID;
	private String updatedDate;
	
	
	public String getuID() {
		return uID;
	}
	public void setuID(String uID) {
		this.uID = uID;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public String getuBday() {
		return uBday;
	}
	public void setuBday(String uBday) {
		this.uBday = uBday;
	}
	public String getuAddr1() {
		return uAddr1;
	}
	public void setuAddr1(String uAddr1) {
		this.uAddr1 = uAddr1;
	}
	public String getuAddr2() {
		return uAddr2;
	}
	public void setuAddr2(String uAddr2) {
		this.uAddr2 = uAddr2;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPhone() {
		return uPhone;
	}
	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}
	public String getuPW() {
		return uPW;
	}
	public void setuPW(String uPW) {
		this.uPW = uPW;
	}
	public byte[] getuPhoto() {
		return uPhoto;
	}
	public void setuPhoto(byte[] uPhoto) {
		this.uPhoto = uPhoto;
	}
	public String getCreatedID() {
		return createdID;
	}
	public void setCreatedID(String createdID) {
		this.createdID = createdID;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getUpdatedID() {
		return updatedID;
	}
	public void setUpdatedID(String updatedID) {
		this.updatedID = updatedID;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
	
}
