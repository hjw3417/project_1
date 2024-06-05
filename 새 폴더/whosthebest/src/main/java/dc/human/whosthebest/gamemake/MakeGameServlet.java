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
	  
      String gTitle = null;
      String gTag = null;
      int gTime = 0;
      String gInfo = null;
      int gMinMember = 0;
      String gResTime = null;
      String gResDate = null;
      int sID = 0;
      int sNum = 0;
      
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
      
      if(request.getParameter("sID") != null) {
    	  System.out.println("sID : " + request.getParameter("sID"));
    	  try {
    		  sID = Integer.parseInt(request.getParameter("sID"));
  		} catch (Exception e) {
  			System.out.println("sID 데이터 오류");
  			}
  		}
      
      if(request.getParameter("sID") != null) {
    	  try {
    		  sNum = Integer.parseInt(request.getParameter("sNum"));
  		} catch (Exception e) {
  			System.out.println("sNum 데이터 오류");
  			}
  		}
      
      int result = gameMakeDAO.registGame(gTitle, gTag, gTime , gInfo , gMinMember , gResTime , gResDate , sID, sNum );
      
      
      
      PrintWriter script = response.getWriter();
          script.println("<script>");
          script.println("location.href = 'resStadium.jsp';");
          script.println("</script>");
          script.close();

	}

}
