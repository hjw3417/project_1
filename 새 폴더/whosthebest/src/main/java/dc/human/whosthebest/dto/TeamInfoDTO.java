package dc.human.whosthebest.dto;

public class TeamInfoDTO {
	private int tID;
	private String tName;
	private byte[] tLogo;
	private String tregion;
	private String tphone;
	private int tRankScore;
	private int tMinAge;
	private int tMaxAge;
	private int tMaxMember;
	private int tMember;
	private int tInfo;
	private String createdID;
	private String createdDate;
	private String updatedID;
	private String updatedDate;
	
	
	public int gettID() {
		return tID;
	}
	public void settID(int tID) {
		this.tID = tID;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public byte[] gettLogo() {
		return tLogo;
	}
	public void settLogo(byte[] tLogo) {
		this.tLogo = tLogo;
	}
	public String getTregion() {
		return tregion;
	}
	public void setTregion(String tregion) {
		this.tregion = tregion;
	}
	public String getTphone() {
		return tphone;
	}
	public void setTphone(String tphone) {
		this.tphone = tphone;
	}
	public int gettRankScore() {
		return tRankScore;
	}
	public void settRankScore(int tRankScore) {
		this.tRankScore = tRankScore;
	}
	public int gettMinAge() {
		return tMinAge;
	}
	public void settMinAge(int tMinAge) {
		this.tMinAge = tMinAge;
	}
	public int gettMaxAge() {
		return tMaxAge;
	}
	public void settMaxAge(int tMaxAge) {
		this.tMaxAge = tMaxAge;
	}
	public int gettMaxMember() {
		return tMaxMember;
	}
	public void settMaxMember(int tMaxMember) {
		this.tMaxMember = tMaxMember;
	}
	public int gettMember() {
		return tMember;
	}
	public void settMember(int tMember) {
		this.tMember = tMember;
	}
	public int gettInfo() {
		return tInfo;
	}
	public void settInfo(int tInfo) {
		this.tInfo = tInfo;
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
