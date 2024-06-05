package dc.human.whosthebest.gamemake;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dc.human.whosthebest.dto.GameDTO;
import dc.human.whosthebest.dto.StadiumDTO;

public class GameMakeDAO {
	
	//기초 필드 초기화
	GameDTO gameDTO = new GameDTO();
	StadiumDTO stadiumDTO = new StadiumDTO();
	
	private Connection con;
	private PreparedStatement pstmt;
	private DataSource dataFactory;
	private ResultSet rs;
	
	//생자 및 oracle 연결
	public GameMakeDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//sRegion 선택 시 그 지역에 해당 하는 StadiumDTO 객체를 생성하여 stadiumList에 추가 메소드
	public ArrayList<StadiumDTO> selectStadium(String sRegion, String search) {
		PreparedStatement pstmt = null;
		String sql = null;
		ArrayList<StadiumDTO> stadiumList = new ArrayList<>();
		System.out.println("search: " + search);
		try {
			con = dataFactory.getConnection();
			System.out.println(sRegion + " dao");

			if ("전체".equals(sRegion) && (search == null || search.isEmpty())) {
			    sql = "SELECT * FROM stadium";
			    pstmt = con.prepareStatement(sql);
			} else if ("전체".equals(sRegion)) {
			    sql = "SELECT * FROM stadium WHERE s_name || s_region || s_addr || s_owner LIKE ?";
			    pstmt = con.prepareStatement(sql);
			    pstmt.setString(1, "%" + search + "%");
			} else if (search == null || search.isEmpty()) {
			    sql = "SELECT * FROM stadium WHERE s_region = ?";
			    pstmt = con.prepareStatement(sql);
			    pstmt.setString(1, sRegion);
			} else {
			    sql = "SELECT * FROM stadium WHERE s_region = ? AND (s_name || s_region || s_addr || s_owner LIKE ?)";
			    pstmt = con.prepareStatement(sql);
			    pstmt.setString(1, sRegion);
			    pstmt.setString(2, "%" + search + "%");
			}

			rs = pstmt.executeQuery();
			rs = pstmt.executeQuery();
			while(rs.next()) {
				StadiumDTO stadiumDTO = new StadiumDTO(
	                    rs.getInt("s_id"),
	                    rs.getString("s_name"),
	                    rs.getString("s_region"),
	                    rs.getString("s_addr"),
	                    rs.getString("s_owner"),
	                    rs.getString("s_phone"),
	                    rs.getInt("s_num")
						);
				stadiumList.add(stadiumDTO);
			}
			System.out.println("주소 : " + stadiumList.get(0).getsAddr());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stadiumList;
	}
	
	
	//sID를 통해 select
	public StadiumDTO stadiumDetail(String sID) {
		PreparedStatement pstmt = null;
		String sql = null;
		System.out.println("sID : " + sID);
		StadiumDTO stadiumDTO = null;
		try {
			con = dataFactory.getConnection();
			sql = "SELECT s_id, s_name, s_region, s_addr, s_owner, s_phone, s_num from stadium where s_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sID);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				stadiumDTO = new StadiumDTO(
	                    rs.getInt("s_id"),
	                    rs.getString("s_name"),
	                    rs.getString("s_region"),
	                    rs.getString("s_addr"),
	                    rs.getString("s_owner"),
	                    rs.getString("s_phone"),
	                    rs.getInt("s_num")
						);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return stadiumDTO;
	}
	
	public int registGame(String gTitle, String gTag, int gTime, String gInfo, int gMinMember, String gResTime,
		String gResDate, int sID, int sNum) {
		String sql = null;
		try {
			con = dataFactory.getConnection();
			sql = "INSERT INTO GAME " +
					"(G_TITLE, G_TAG, G_TIME, G_INFO, "
					+ "G_MINMEMBER, G_RESTIME, G_RESDATE, S_ID, S_NUM) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, gTitle);
			pstmt.setString(2, gTag);
			pstmt.setInt(3, gTime);
			pstmt.setString(4, gInfo);
			pstmt.setInt(5, gMinMember);
			pstmt.setString(6, gResTime);
			pstmt.setString(7, gResDate);
			pstmt.setInt(8, sID);
			pstmt.setInt(9, sNum);
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return -1;
	}
	
}
