package dc.human.whosthebest.dto;

	public class GameDTO {
		
		private int gID;
		private String gTeamID;
		private String gTitle;
		private String gTag;
		private String gCreatedDate;
		private int gTime;
		private String gInfo;
		private int gMinMember;
		private String gResTime;
		private String gResDate;
		private int gStatus;
		private int tID;
		private int tAwayID;
		private int sID;
		private int sNum;
		private String createdID;
		private String createdDate;
		private String updateID;
		private String updatedDate;
	
	
	public GameDTO(int gID, String gTeamID, String gTitle, String gTag, String gCreatedDate, int gTime, String gInfo,
			int gMinMember, String gResTime, String gResDate, int gStatus, int tID, int tAwayID, int sID, int sNum,
			String createdID, String createdDate, String updateID, String updatedDate) {
		this.gID = gID;
		this.gTeamID = gTeamID;
		this.gTitle = gTitle;
		this.gTag = gTag;
		this.gCreatedDate = gCreatedDate;
		this.gTime = gTime;
		this.gInfo = gInfo;
		this.gMinMember = gMinMember;
		this.gResTime = gResTime;
		this.gResDate = gResDate;
		this.gStatus = gStatus;
		this.tID = tID;
		this.tAwayID = tAwayID;
		this.sID = sID;
		this.sNum = sNum;
		this.createdID = createdID;
		this.createdDate = createdDate;
		this.updateID = updateID;
		this.updatedDate = updatedDate;
	}
	
	public GameDTO() {
		
	}

	public int getgID() {
		return gID;
	}

	public void setgID(int gID) {
		this.gID = gID;
	}

	public String getgTeamID() {
		return gTeamID;
	}

	public void setgTeamID(String gTeamID) {
		this.gTeamID = gTeamID;
	}

	public String getgTitle() {
		return gTitle;
	}

	public void setgTitle(String gTitle) {
		this.gTitle = gTitle;
	}

	public String getgTag() {
		return gTag;
	}

	public void setgTag(String gTag) {
		this.gTag = gTag;
	}

	public String getgCreatedDate() {
		return gCreatedDate;
	}

	public void setgCreatedDate(String gCreatedDate) {
		this.gCreatedDate = gCreatedDate;
	}

	public int getgTime() {
		return gTime;
	}

	public void setgTime(int gTime) {
		this.gTime = gTime;
	}

	public String getgInfo() {
		return gInfo;
	}

	public void setgInfo(String gInfo) {
		this.gInfo = gInfo;
	}

	public int getgMinMember() {
		return gMinMember;
	}

	public void setgMinMember(int gMinMember) {
		this.gMinMember = gMinMember;
	}

	public String getgResTime() {
		return gResTime;
	}

	public void setgResTime(String gResTime) {
		this.gResTime = gResTime;
	}

	public String getgResDate() {
		return gResDate;
	}

	public void setgResDate(String gResDate) {
		this.gResDate = gResDate;
	}

	public int getgStatus() {
		return gStatus;
	}

	public void setgStatus(int gStatus) {
		this.gStatus = gStatus;
	}

	public int gettID() {
		return tID;
	}

	public void settID(int tID) {
		this.tID = tID;
	}
	
	

	public int gettAwayID() {
		return tAwayID;
	}

	public void settAwayID(int tAwayID) {
		this.tAwayID = tAwayID;
	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}
	
	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
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

	public String getUpdateID() {
		return updateID;
	}

	public void setUpdateID(String updateID) {
		this.updateID = updateID;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
	
	
	
	
}
