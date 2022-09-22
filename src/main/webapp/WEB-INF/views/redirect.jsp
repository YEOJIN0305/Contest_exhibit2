<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="kopo.poly.util.CmmUtil" %>

<%
    String msg = (String)request.getAttribute("msg");
    String url = (String)request.getAttribute("url");
    String icon = CmmUtil.nvl((String)request.getAttribute("icon"));
    String contents = CmmUtil.nvl((String)request.getAttribute("contents"));
%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>good</title>


</head>
<body>

</body>
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
<script type="text/javascript">

    swal( "<%=msg%>", "<%=contents%>","<%=icon%>")
        .then(function(){
            location.href="<%=url%>";
        });
</script>
</html>