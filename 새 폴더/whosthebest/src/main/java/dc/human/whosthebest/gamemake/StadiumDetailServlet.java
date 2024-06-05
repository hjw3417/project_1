package dc.human.whosthebest.gamemake;

import java.io.IOException;
import java.io.PrintWriter;

import dc.human.whosthebest.dto.StadiumDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/stadiumdetail")
public class StadiumDetailServlet extends HttpServlet {
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
	  HttpSession session = request.getSession();
	  
      PrintWriter out = response.getWriter();
      String sID = request.getParameter("sID");
      GameMakeDAO stadiumDAO = new GameMakeDAO();
      session.setAttribute("run", "run");
      
      StadiumDTO stadiumDTO = stadiumDAO.stadiumDetail(sID);
      
      if(stadiumDTO.getsID() == 0) {
    	  request.setAttribute("sID", 0);
      } else {
    	  session.setAttribute("sID", stadiumDTO.getsID());
      }
      System.out.println("stadiumDTO.getsID() : " + stadiumDTO.getsID());
      if(stadiumDTO.getsName() == null) {
    	  session.setAttribute("sName", "없음");
      } else {
    	  session.setAttribute("sName", stadiumDTO.getsName());
      }
      
      if(stadiumDTO.getsName() == null) {
    	  request.setAttribute("sName", "없음");
      } else {
    	  request.setAttribute("sName", stadiumDTO.getsName());
      }
      
      if(stadiumDTO.getsOwner() == null) {
    	  session.setAttribute("sOwner", "없음");
      } else {
    	  session.setAttribute("sOwner", stadiumDTO.getsOwner());
      }
      
      if(stadiumDTO.getsAddr() == null) {
    	  session.setAttribute("sAddr", "없음");
      } else {
    	  session.setAttribute("sAddr", stadiumDTO.getsAddr());
      }
      
      if(stadiumDTO.getsPhone() == null) {
    	  session.setAttribute("sPhone", "없음");
      } else {
    	  session.setAttribute("sPhone", stadiumDTO.getsPhone());
      }
      
      if(stadiumDTO.getsNum() == 0) {
    	  session.setAttribute("sNum", "선택 정보 없음");
      } else {
    	  session.setAttribute("sNum", stadiumDTO.getsNum());
      }

      
      
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("location.href = 'resStadium.jsp';");
      script.println("</script>");
      script.close();
	}

}
