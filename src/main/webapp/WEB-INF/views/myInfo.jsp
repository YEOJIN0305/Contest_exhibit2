<%@ page import="kopo.poly.dto.UserInfoDTO" %>
<%@ page import="kopo.poly.util.CmmUtil" %>
<%@ page import="kopo.poly.util.EncryptUtil" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    UserInfoDTO uDTO = (UserInfoDTO) request.getAttribute("rDTO");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>웹페이지 제목</title>
</head>
<body>
<h1>내 정보</h1>
<form action="/myInfoUpdate" method="post">
    <div>
        아이디 : <%=CmmUtil.nvl(uDTO.getUser_id())%>
    </div>
    <div>
        이메일 : <%=EncryptUtil.decAES128CBC(CmmUtil.nvl(uDTO.getUser_email()))%>
    </div>
    <div>
        이름 : <%=CmmUtil.nvl(uDTO.getUser_name())%>
    </div>
    <button type="submit">수정하기</button>
</form>
</body>
</html>