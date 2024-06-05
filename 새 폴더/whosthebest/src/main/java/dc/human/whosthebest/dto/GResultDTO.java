package dc.human.whosthebest.dto;

public class GResultDTO {
	
	
	private int gID;
	private int tHomeID;
	private int tAwayID;
	private int homeGoal;
	private int awayGoal;
	private String uID;
	private String createdDate;
	private String updatedID;
	private String updatedDate;
	
	
	public GResultDTO(int gID, int tHomeID, int tAwayID, int homeGoal, int awayGoal, String uID, String createdDate,
			String updatedID, String updatedDate) {
		this.gID = gID;
		this.tHomeID = tHomeID;
		this.tAwayID = tAwayID;
		this.homeGoal = homeGoal;
		this.awayGoal = awayGoal;
		this.uID = uID;
		this.createdDate = createdDate;
		this.updatedID = updatedID;
		this.updatedDate = updatedDate;
	}
	
	
	public GResultDTO() {

	}


	public int getgID() {
		return gID;
	}


	public void setgID(int gID) {
		this.gID = gID;
	}


	public int gettHomeID() {
		return tHomeID;
	}


	public void settHomeID(int tHomeID) {
		this.tHomeID = tHomeID;
	}


	public int gettAwayID() {
		return tAwayID;
	}


	public void settAwayID(int tAwayID) {
		this.tAwayID = tAwayID;
	}


	public int getHomeGoal() {
		return homeGoal;
	}


	public void setHomeGoal(int homeGoal) {
		this.homeGoal = homeGoal;
	}


	public int getAwayGoal() {
		return awayGoal;
	}


	public void setAwayGoal(int awayGoal) {
		this.awayGoal = awayGoal;
	}


	public String getuID() {
		return uID;
	}


	public void setuID(String uID) {
		this.uID = uID;
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
