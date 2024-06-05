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

@WebServlet("/commitstadium")
public class CommitStadiumServlet extends HttpServlet {
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
	  
      PrintWriter out=response.getWriter();
      
      
      String gResDate = request.getParameter("gResDate");
      String sTime = request.getParameter("sTime");
      String eTime = request.getParameter("eTime");
      
      int gTime = Integer.parseInt(eTime) - Integer.parseInt(sTime);
      
      if(gResDate == null) {
    	  session.setAttribute("gResDate", "선택 정보 없음");
      } else {
    	  session.setAttribute("gResDate", gResDate);
      }
      if(sTime == null) {
    	  session.setAttribute("sTime", "");
      } else {
    	  session.setAttribute("sTime", sTime);
      }
      if(eTime == null) {
    	  session.setAttribute("eTime", "");
      } else {
    	  session.setAttribute("eTime", eTime);
      }
      if(gTime == 0) {
    	  session.setAttribute("eTime", "선택 정보 없음");
      } else {
    	  session.setAttribute("gTime", gTime);
      }
      
      session.setAttribute("run2", "run2");
    		  
      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("location.href = 'gameMake.jsp';");
      script.println("</script>");
      script.close();
	}

}
