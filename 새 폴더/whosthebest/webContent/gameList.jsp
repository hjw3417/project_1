<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dc.human.whosthebest.dto.*" %>
<%@ page import="dc.human.whosthebest.gamemake.*" %>

<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%

    String sRegion = "전체";
    String search = null;
    if (request.getParameter("sRegion") != null) {
        sRegion = request.getParameter("sRegion");
    }
	
    if(request.getParameter("search") != null) {
	   search = request.getParameter("search");
    }
    
  	String sOwner = null;
  	String sAddr = null;
  	String sPhone = null;
  	String sName = null;
  	String gResDate = null;
  	String gResTime = null;
  	String sTime = null;
  	String eTime = null;
  	String sNum = null;
      
      if(request.getParameter("sOwner") != null) {
  		sOwner = request.getParameter("sOwner");
  	}
  	
  	if(request.getParameter("sAddr") != null) {
  		sAddr = request.getParameter("sAddr");
  	}
  	
  	if(request.getParameter("sPhone") != null) {
  		sPhone = request.getParameter("sPhone");
  	}
  	
  	if(request.getParameter("sName") != null) {
  		sName = request.getParameter("sName");
  	}
  	
  	if(request.getParameter("gResDate") != null) {
  		gResDate = request.getParameter("gResDate");
  	}
  	
  	if(request.getParameter("gResTime") != null) {
  		gResTime = request.getParameter("gResTime");
  	}
  	
  	if(request.getParameter("sTime") != null) {
  		sTime = request.getParameter("sTime");
  	}
  	
  	if(request.getParameter("eTime") != null) {
  		eTime = request.getParameter("eTime");
  	}
  	if(request.getParameter("sNum") != null) {
  		sNum = request.getParameter("sNum");
  	}
    
%>

<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <title>경기 만들기</title>
  <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
  <script>
    function refreshPageWithSelectedValue() {
      var sRegion = document.getElementById("sRegion").value;
      window.location.href = "resStadium.jsp?sRegion=" + sRegion;
    }
  </script>
</head>
<body>
<header>
   <div class="logo">
     <img src="image/logo.png">
   </div>
   <div>
     <span><a href="#">로그아웃</a>&nbsp;&nbsp;|&nbsp;</span>
     <span><a href="#">마이페이지</a></span>
   </div>
   <div>
     <ul>
       <li>
         <a href="#">팀</a>
         <div>
           <ul>
             <li><a href="#">팀 목록</a></li>
             <li><a href="#">나의 팀</a></li>
           </ul>
         </div>
       </li>
       <li><a href="#">경기 목록</a></li>
       <li><a href="#">경기장 목록</a></li>
       <li><a href="#">랭킹</a></li>
       <li><a href="#">게시판</a></li>
     </ul>
   </div>
 </header>
  <main style="text-align: center; height: 700px;">
    <div style="height: 70px;">　</div>
    <section>
   
      <table class="resStadiumTable">
        <form method="get" action="./resStadium.jsp">
        <tr>
            <td>
              <select name="sRegion">
                <option value="전체"<% if(sRegion.equals("전체")) out.print("seleteted"); %>>전체</option>
                <option value="서울"<% if(sRegion.equals("서울")) out.print("seleteted"); %>>서울</option>
                <option value="인천"<% if(sRegion.equals("인천")) out.print("seleteted"); %>>인천</option>
                <option value="경기"<% if(sRegion.equals("경기")) out.print("seleteted"); %>>경기</option>
                <option value="충남"<% if(sRegion.equals("충남")) out.print("seleteted"); %>>충남</option>
                <option value="충북"<% if(sRegion.equals("충북")) out.print("seleteted"); %>>충북</option>
                <option value="대전"<% if(sRegion.equals("대전")) out.print("seleteted"); %>>대전</option>
                <option value="대구"<% if(sRegion.equals("대구")) out.print("seleteted"); %>>대구</option>
                <option value="경북"<% if(sRegion.equals("경북")) out.print("seleteted"); %>>경북</option>
                <option value="경남"<% if(sRegion.equals("경남")) out.print("seleteted"); %>>경남</option>
                <option value="울산"<% if(sRegion.equals("울산")) out.print("seleteted"); %>>울산</option>
                <option value="부산"<% if(sRegion.equals("부산")) out.print("seleteted"); %>>부산</option>
                <option value="전남"<% if(sRegion.equals("전남")) out.print("seleteted"); %>>전남</option>
                <option value="전북"<% if(sRegion.equals("전북")) out.print("seleteted"); %>>전북</option>
                <option value="광주"<% if(sRegion.equals("광주")) out.print("seleteted"); %>>광주</option>
                <option value="강원"<% if(sRegion.equals("강원")) out.print("seleteted"); %>>강원</option>
              </select>
            </td>
            <td ></td>
            <td colspan="3">
              <input type="text" name="search" placeholder="팀, 경기 명 및 해시태그로 경기 검색">
            </td>
            <td style="width: 30px;">
              <input type="submit" value="검색">
            </td>
            <td style="width: 50px;"></td>
          </tr>
          </form>
          <tr style="height: 50px;"></tr>
          <tr>
            <td colspan="2" style="border: 2pt solid rgb(184, 206, 146); height: 150px; v-align: top; overflow-y: auto;">
<ul style="height: 150px;">
  <li><경기장 목록></li>
<%
   ArrayList<StadiumDTO> stadiumList = new GameMakeDAO().selectStadium(sRegion, search);
   
   // 예외 처리를 추가하여 stadiumList가 null인 경우를 방지합니다.
   if (stadiumList != null && !stadiumList.isEmpty()) {
      System.out.println("주소2 : " + stadiumList.get(0).getsAddr());
      System.out.println(stadiumList.isEmpty());
      
      for (int i = 0; i < stadiumList.size(); i++) {
         StadiumDTO stadiumDTO = stadiumList.get(i);
         String sID = URLEncoder.encode(String.valueOf(stadiumDTO.getsID()), StandardCharsets.UTF_8.toString());
%>
         <li>
            <form method="get" action="./stadiumdetail">
               <input type="hidden" name="sID" value="<%= sID %>">
               <button type="submit" class="studiumInfo" id="sID"><%=stadiumDTO.getsName() %></button>
            </form>
         </li>
<%
      }
   } else {
%>
      <li>경기장 없음</li>
<%
   }
%>
</ul>

            </td>
            <td colspan="4" style="border: 2pt solid rgb(184, 206, 146);">
              <ul>
              	<li><상세정보></li>

<%
	if(session.getAttribute("run") == null) {
%>
	<li>경기장을 선택해주세요.</li>
<%
	} else {
%>
              	<li name="sName" value="<%=session.getAttribute("sName") %>">경기장 명 : <%=session.getAttribute("sName") %></li>
                <li name="sAddr" value="<%=session.getAttribute("sAddr") %>">주소 : <%=session.getAttribute("sAddr") %></li>
                <li name="sOwner" value="<%=session.getAttribute("sOwner") %>">관리주체 : <%=session.getAttribute("sOwner") %></li>
                <li name="sPhone" value="<%=session.getAttribute("sPhone") %>">연락처 : <%=session.getAttribute("sPhone") %></li>
<%
	}
	session.removeAttribute("run");
%>
              </ul>
            </td>
          </tr>
          <form method="get" action="commitstadium">
          <tr><td rowspan="5" style="width: 200px;"></td></tr>
          <tr>
            <td colspan="3" style="text-align: left;">
              예약일 : 
            </td>
            <td>
              <input type="date" style="width: 200px;" name="gResDate">
            </td>
          </tr>
          <tr>
            <td colspan="3" style="text-align: left;" name="sTime">
              시작 시작 : 
              </td>
              <td>
              <select style="width: 200px;" name="sTime">
                <option value="8">08 : 00</option>
                <option value="9">09 : 00</option>
                <option value="10">10 : 00</option>
                <option value="11">11 : 00</option>
                <option value="12">12 : 00</option>
                <option value="13">01 : 00</option>
                <option value="14">02 : 00</option>
                <option value="15">03 : 00</option>
                <option value="16">04 : 00</option>
                <option value="17">05 : 00</option>
              </select>
            </td>
          </tr>
          <tr>
            <td colspan="3" style="text-align: left;">
              종료 시작 : 
            </td>
            <td>
              <select style="width: 200px;" name="eTime">
                <option value="8">08 : 00</option>
                <option value="9">09 : 00</option>
                <option value="10">10 : 00</option>
                <option value="11">11 : 00</option>
                <option value="12">12 : 00</option>
                <option value="13">01 : 00</option>
                <option value="14">02 : 00</option>
                <option value="15">03 : 00</option>
                <option value="16">04 : 00</option>
                <option value="17">05 : 00</option>
              </select>
            </td>
          </tr>
         <tr style="text-align: right;">
          <td colspan="3" style="text-align: left;">
            <label>경기장 선택 : </label>
          </td>
          <td>
            <select style="width: 200px;" name="sNum">
            <option disabled selected>경기장 선택하기</option>
<%
		// 세션에서 sNum 값을 가져와 정수로 변환
		int sNumInt = 0;
		try {
		    String sNumStr = session.getAttribute("sNum").toString();
		    sNumInt = Integer.parseInt(sNumStr);
		} catch (NumberFormatException e) {
		    // sNum이 정수로 변환될 수 없는 경우
		    out.println("Invalid number format for sNum: " + e.getMessage());
		} catch (NullPointerException e) {
		    // sNum이 세션에 없는 경우
		    out.println("sNum attribute is missing in the session: " + e.getMessage());
		}
		for(int i=1; i <= sNumInt; i++) {	
%>
              <option><%=i %> 경기장</option>
<%
		}
%>   
            </select>
          </td>
         </tr>
        <tr>
          <td colspan="5" style="text-align: right; height: 50px;">
            <a  class="a-button"  href="gameMake.jsp">취소하기</a>
          </td>
          	<td colspan="2" style="text-align: right;"><button class="a-button" type="submit">선택 완료</button></td>
          </form>
          <td></td>
        </tr>     
    </table>
    </section>
  </main>


  <footer>
    <div>
      <ul>
        <li><a href="#">이용약관</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">개인정보처리방침</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">오류/건의</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">광고/후원문의</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">고객센터</a>&nbsp;&nbsp;|&nbsp;&nbsp;</li>
        <li><a href="#">&copy;누가잘차</a></li>
      </ul>
    </div>
    <div>&copy;2024.MunjuGangz All rights reserved.</div>
  </footer>
</body>
</html>

