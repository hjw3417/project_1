package dc.human.whosthebest.gamemake;

import java.io.IOException;
import java.io.PrintWriter;

import dc.human.whosthebest.dto.GameDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/makegame")
public class MakeGameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}


	protected void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	  response.setContentType("text/html;charset=utf-8");
	  request.setCharacterEncoding("utf-8");
      PrintWriter out = response.getWriter();
      GameMakeDAO gameMakeDAO = new GameMakeDAO();
      GameDTO gameDTO = new GameDTO();
	  HttpSession session = request.getSession();
	  
	  int gTeamID = 0;
      String gTitle = null;
      String gTag = null;
      int gTime = 0;
      String gInfo = null;
      int gMinMember = 0;
      String gResTime = null;
      String gResDate = null;
      int tID = 0;
      int tAwayID = 0;
      int sID = 0;
      int sNum = 0;
      String createdID = null;
      String updateID = null;
      
//==========================================

      if(session.getAttribute("gTeamID") != null) {
    	  try {
    		  gTeamID = Integer.parseInt(session.getAttribute("gTeamID").toString());
  		} catch (Exception e) {
  			System.out.println("gTeamID 데이터 오류");
  			}
  		}
      if(session.getAttribute("tID") != null) {
    	  try {
    		  tID = Integer.parseInt(session.getAttribute("tID").toString());
  		} catch (Exception e) {
  			System.out.println("tID 데이터 오류");
  			}
  		}
      if(session.getAttribute("tAwayID") != null) {
    	  try {
    		  tAwayID = Integer.parseInt(session.getAttribute("tAwayID").toString());
  		} catch (Exception e) {
  			System.out.println("tAwayID 데이터 오류");
  			}
  		}
      if(session.getAttribute("createdID") != null) {
    	  createdID = (String) session.getAttribute("createdID");
  		}
      if(session.getAttribute("updateID") != null) {
    	  updateID = (String) session.getAttribute("updateID");
  		}
      
      //=========================================================
      
      if(request.getParameter("gTitle") != null) {
    	  gTitle = (String) request.getParameter("gTitle");
  		}
      
      if(request.getParameter("gTag") != null) {
    	  gTag = (String) request.getParameter("gTag");
  		}
      
      if(request.getParameter("gTime") != null) {
    	  try {
    		  gTime = Integer.parseInt(request.getParameter("gTime"));
  		} catch (Exception e) {
  			System.out.println("gTime 데이터 오류");
  			}
  		}
      
      if(request.getParameter("gInfo") != null) {
    	  gInfo = (String) request.getParameter("gInfo");
  		}
      
      if(request.getParameter("gMinMember") != null) {
    	  try {
    		  gMinMember = Integer.parseInt(request.getParameter("gMinMember"));
  		} catch (Exception e) {
  			System.out.println("gMinMember 데이터 오류");
  			}
  		}
      if(request.getParameter("gResTime") != null) {
    	  gResTime = (String) request.getParameter("gResTime");
  		}
      
      if(request.getParameter("gResDate") != null) {
    	  gResDate = (String) request.getParameter("gResDate");
  		}
      System.out.println("sID밖 : " + session.getAttribute("sID"));
      Object sIDObj = session.getAttribute("sID");
      if(session.getAttribute("sID") != null) {
    	  System.out.println("sID안 : " + session.getAttribute("sID") );
    	  try {
//    		  sID = Integer.parseInt(request.getParameter("sID").toString());
    		  sID = (Integer) sIDObj;
    		  System.out.println("sIDtry : " + session.getAttribute("sID") );
  		} catch (Exception e) {
  			System.out.println("sIDcatch : " + session.getAttribute("sID") );
  			System.out.println("sID 데이터 오류");
  			}
  		}
      System.out.println("sNum밖 : " + request.getParameter("sNum"));
      if(request.getParameter("sNum") != null) {
    	  System.out.println("sNum안 : " + request.getParameter("sNum"));
    	  try {
    		  sNum = Integer.parseInt(request.getParameter("sNum"));
  		} catch (Exception e) {
  			System.out.println("sNum 데이터 오류");
  			}
  		}
      if(gMinMember == 0) {
          PrintWriter script = response.getWriter();
          script.println("<script>");
          script.println("alert('게임 참여 인원은 0 이상의 숫자로 입력해야합니다.');");
          script.println("location.href = 'gameMake.jsp';");
          script.println("</script>");
          script.close();
      } else {
	      if(gTeamID == 0 || gTitle == null || gTag == null || gTime == 0 || gInfo == null ||
	    		   gResTime == null || gResDate == null || tID == 0 || tAwayID == 0
	    		   || sID == 0 || sNum == 0 || createdID == null || updateID == null) {
	    	  
	    	  System.out.println(" 0 : " + gTeamID + ", 1 : " + gTitle + ", 2 : " + gTag + ", 3 : " + gTime
	    			  + ", 4 : " + gInfo + ", 5 : " + gMinMember + ", 6 : " + gResTime + ", 7 : " + gResDate
	    			  + ", 8 : " + tID + ", 9 : " + tAwayID + ", 10 : " + sID + ", 11 : " + sNum + ", 12 : " + createdID
	    			  + ", 13 : " + updateID);
		  		PrintWriter script = response.getWriter();
		  		script.println("<script>");
		  		script.println("alert('입력이 안된 사항이 있습니다.')");
	            script.println("location.href = 'gameMake.jsp';");
		  		script.println("</script>");
		  		script.close();
		  		return;
	      } else {
	          int result = gameMakeDAO.registGame(gTeamID, gTitle, gTag, gTime , gInfo , gMinMember, 
	        		  gResTime , gResDate ,tID, tAwayID, sID, sNum, createdID, updateID);
	          if(result == -1) {
	              PrintWriter script = response.getWriter();
	              script.println("<script>");
	              script.println("alert('게임 생성에 실패했습니다.');");
	              script.println("location.href = 'gameMake.jsp';");
	              script.println("</script>");
	              script.close();
	          } else {
	              PrintWriter script = response.getWriter();
	              script.println("<script>");
	              script.println("alert('게임이 생성되었습니다.');");
	              script.println("location.href = 'gameMake.jsp';");
	              script.println("</script>");
	              script.close();
	          }
	      }
      }

      
      
      
      

      

      


	}

}
