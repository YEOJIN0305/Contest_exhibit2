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
<form action="/userInfoUpdate" method="post">
    <div>
        아이디 : <input name="user_id" type="text" value="<%=CmmUtil.nvl(uDTO.getUser_id())%>"/>
    </div>
    <div>
        이메일 : <input name="user_email" type="email" value="<%=EncryptUtil.decAES128CBC(CmmUtil.nvl(uDTO.getUser_email()))%>"/>
    </div>
    <div>
        이름 : <input name="user_name" type="text" value="<%=CmmUtil.nvl(uDTO.getUser_name())%>" />
    </div>
    <button type="submit">확인</button>
</form>
</body>
</html>