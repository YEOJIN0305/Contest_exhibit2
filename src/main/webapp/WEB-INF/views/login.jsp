<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <title>웹페이지 제목</title>
</head>
<body>
<form action="/userCheck" method="post">
    <div>
        아이디 : <input type="text" name="user_id" />
    </div>
    <div>
        비밀번호 : <input type="password" name="user_pwd" />
    </div>
    <button type="submit">로그인하기</button>
</form>
</body>
</html>