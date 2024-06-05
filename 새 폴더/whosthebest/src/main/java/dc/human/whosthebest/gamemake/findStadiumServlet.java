package dc.human.whosthebest.gamemake;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dc.human.whosthebest.dto.StadiumDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/findstadium")
public class FindStadiumServlet extends HttpServlet {
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
	  HttpSession session = request.getSession();
	  
	  request.setCharacterEncoding("utf-8");
	  response.setContentType("text/html;charset=utf-8");
	
	  String sRegion = "전체";
	
	  String search = null;
	
	  if(request.getParameter("sRegion") != null) {
		  sRegion = request.getParameter("sRegion");
	  }
	 

	
	  if(request.getParameter("search") != null) {
		  search = request.getParameter("search");
		  System.out.println("search: " + search);
	  }
      
	  ArrayList<StadiumDTO> stadiumList = new ArrayList<StadiumDTO>();
	  stadiumList = new GameMakeDAO().selectStadium(sRegion, search);
	  
	  System.out.println("adf" + stadiumList.get(0).getsAddr());
	  
	  session.setAttribute("stadiumList", stadiumList);

      PrintWriter script = response.getWriter();
      script.println("<script>");
      script.println("location.href = 'resStadium.jsp';");
      script.println("</script>");
      script.close();
	}

}
