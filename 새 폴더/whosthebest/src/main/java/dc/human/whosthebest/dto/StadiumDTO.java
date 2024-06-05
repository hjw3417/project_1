package dc.human.whosthebest.dto;

public class StadiumDTO {
	private int sID;
	private String sName;
	private String sRegion;
	private String sAddr;
	private String sOwner;
	private String sPhone;
	private int sNum;
	public StadiumDTO(int sID, String sName, String sRegion, String sAddr, String sOwner, String sPhone, int sNum) {
		this.sID = sID;
		this.sName = sName;
		this.sRegion = sRegion;
		this.sAddr = sAddr;
		this.sOwner = sOwner;
		this.sPhone = sPhone;
		this.sNum = sNum;
	}
	
	public StadiumDTO() {

	}

	public int getsID() {
		return sID;
	}

	public void setsID(int sID) {
		this.sID = sID;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsRegion() {
		return sRegion;
	}

	public void setsRegion(String sRegion) {
		this.sRegion = sRegion;
	}

	public String getsAddr() {
		return sAddr;
	}

	public void setsAddr(String sAddr) {
		this.sAddr = sAddr;
	}

	public String getsOwner() {
		return sOwner;
	}

	public void setsOwner(String sOwner) {
		this.sOwner = sOwner;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public int getsNum() {
		return sNum;
	}

	public void setsNum(int sNum) {
		this.sNum = sNum;
	}
	
	
}
