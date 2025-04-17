<%@ page contentType="text/html; charset=UTF-8" %>
<%
    String user = (String)request.getAttribute("user");
    int javaScore = (int)request.getAttribute("javaScore");
    int pythonScore = (int)request.getAttribute("pythonScore");
%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Sample</title>
</head>
<body>
<h2>display</h2>
결과 : ${user}님의 총점은 ${javaScore + pythonScore} 평균은 ${(javaScore + pythonScore) / 2}
</body>
</html>
