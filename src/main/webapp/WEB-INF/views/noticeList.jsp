<%@ page import="kopo.poly.dto.NoticeDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    List<NoticeDTO> rList = (List<NoticeDTO>)request.getAttribute("rList");
    String name = CmmUtil.nvl((String)session.getAttribute("sessionId"));
    String uno = CmmUtil.nvl((String)session.getAttribute("sessionNo"));
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>게시판 목록</title>
</head>
<body>
<% if(name != "") { %>
<h1><%=name%>님 어서오세요! (로그인세션)</h1>
<button onclick="location.href='/logoutSession'">로그아웃</button>
<button onclick="location.href='/userDelete?uno=<%=uno%>'">회원탈퇴</button>
<%} else {%>
<button onclick="location.href='/login'">로그인</button>
<% } %>
<div style="margin: auto; width: 800px;">
    <table style="border-collapse: collapse; margin: 0 auto; width:500px; border: 1px solid cornflowerblue">
        <tr style="border-bottom: 2px solid cornflowerblue">
            <td>순번</td>
            <td>제목</td>
            <td>게시자</td>
            <td>등록일</td>
        </tr>
        <% for(int i=0; i < rList.size(); i++){ %>
        <tr style="border-bottom: 1px solid cornflowerblue">
            <td><%= rList.get(i).getNotice_seq()%></td>
            <td><a href="noticeDetail?no=<%=rList.get(i).getNotice_seq()%>"><%=rList.get(i).getTitle()%></a></td>
            <td><%= rList.get(i).getReg_id()%></td>
            <td><%= rList.get(i).getRegdate()%></td>
        </tr>
        <% } %>
    </table>
    <div style="width:100%; text-align: right; margin-top: 5px;">
        <button type="button" onclick="location.href = 'noticeInfo'">새글</button>
    </div>
</div>
</body>
</html>