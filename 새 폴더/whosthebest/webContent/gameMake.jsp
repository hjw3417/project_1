<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="dc.human.whosthebest.dto.*" %>
<%@ page import="dc.human.whosthebest.gamemake.*" %>

<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>   
<%
	session.setAttribute("gTeamID", 123);
	session.setAttribute("tID", 1);
	session.setAttribute("tAwayID", 1);
	session.setAttribute("createdID", "1");
	session.setAttribute("updateID", "1");
	
%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link rel="stylesheet" href="css/style.css">
  <title>경기 만들기</title>
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
  <main style="height: 750px; text-align: center;">
    <div style="height: 70px;">　</div>
    <div class="sec-container">
      <section>
        <form class="frmCreateMatch" name="frmCreateMatch" method="get" action="./makegame">
          <table class="inputTable">
            <tr>
              <td colspan="3">
                <select name="selectTeam">
                  <option selected>팀 선택하기</option>
                  <option>문주군단</option>
                  <option>개발냥발</option>
                  <option>김방박이</option>
                </select>
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <input type="text" name="gTitle" placeholder="경기 제목을 입력하세요.">
              </td>
            </tr>
            <tr>
              <td colspan="3">
                <input type="text" name="gTag" placeholder="해시태그를 입력해주세요.(#로 구분)">
              </td>
            </tr>
            <tr>
              <td colspan="3" style="background-color: rgb(146, 172, 101); height: 40px;">
<%
				String run2 = (String) session.getAttribute("run2"); 
				if(run2 == null) {
%>
				<a href="resStadium.jsp" name="sID" value="<%=session.getAttribute("sID")  %>">
                경기장 선택하기
                </a>
<%
				} else {
%>
                <a href="resStadium.jsp" name="sID" value="<%=session.getAttribute("sID")%>">
                <%=session.getAttribute("sName")  %>
                <%
                System.out.println("여기 : " + session.getAttribute("sID"));
                System.out.println("여기 : " + session.getAttribute("sName"));
                %>
                </a>
<%
				}
%>
              </td>
            </tr>
            <tr>

<tr>
    <td style="font-size: 8pt; background-color: rgb(146, 172, 101); height: 30px;">
    
    <%
	if(run2 == null) {
%>
		<span>선택 정보 없음</span>
<%
	} else {
%>
        <input type="hidden" id="gResDate" name="gResDate" value="<%=session.getAttribute("gResDate") %>">
        <span id="gResDate"><%=session.getAttribute("gResDate") %></span>
        <input type="hidden" id="sTime" name="gResTime" value="<%=session.getAttribute("sTime") %>">
        <span id="sTime"><%=session.getAttribute("sTime") %></span> : 00
<%
	}
%>

    </td>
    <td style="font-size: 8pt; background-color: rgb(146, 172, 101); height: 30px;">
<%
	if(run2 == null) {
%>
		<span>선택 정보 없음</span>
<%
	} else {
%>
        주소: <%=session.getAttribute("sAddr") %>
<%
	}
%>
    </td>
</tr>
<tr>
    <td colspan="1" style="background-color: rgb(146, 172, 101); height: 30px;">
<%
	if(run2 == null) {
%>
		<span>선택 정보 없음</span>
<%
	} else {
%>
        <input type="hidden" id="gTime" name="gTime" value="<%=session.getAttribute("gTime") %>">
        <span id="gTime"><%=session.getAttribute("gTime") %></span> 시간
<%
	}
%>


    </td>
    <td style="background-color: rgb(146, 172, 101); height: 30px;">
<%
	if(run2 == null) {
%>
		<span>선택 정보 없음</span>
<%
	} else {
%>
        <input type="hidden" id="sNum" name="sNum" value="<%=session.getAttribute("sNum") %>">
        <span id="sNum"><%=session.getAttribute("sNum")%></span> 경기장
<%
	}
%>


    </td>
</tr>
<%
    session.removeAttribute("run2");

%>

            <tr>
              <td colspan="3">
                <input type="text" name="gMinMember" placeholder="참여 인원 설정하기">
              </td>
            </tr>
            <tr>
              <td colspan="3"  style="height: 300px; margin: 0;">
                <input type="textarea" name="gInfo" placeholder="공지사항을 입력하기">
              </td>
            </tr>
            <tr>
              <td style="background-color: rgb(146, 172, 101); height: 40px;">
                <a>저장</a>
              </td>
              <td style="background-color: rgb(146, 172, 101); height: 40px;">
               <input type="submit" value="경기 만들기">
              </td>
            </tr>
          </table>
        </form>
      </section>
    </div>
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


<%-- 
<%
session.removeAttribute("sName");
session.removeAttribute("sAddr");
session.removeAttribute("gResDate");
session.removeAttribute("sTime");
session.removeAttribute("eTime");
session.removeAttribute("gTime");
%> 
--%>
