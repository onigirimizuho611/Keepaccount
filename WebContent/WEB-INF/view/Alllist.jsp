<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import ="dto.Keepaccount" %>
<%@page import ="dto.Returnl" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%request.setCharacterEncoding("UTF-8"); %>
<%Returnl i = (Returnl) request.getAttribute("lnum"); %>
<table border="1">
<tr>
<th>
	income</th>
<th>
	spending</th>
</tr>
<%String strK[] = new String[i.getl()];
for(int K = 0; K <strK.length; K++){
	String str = "rs" + K;
	strK[K] = str;
}
%>
<%for(int k = 0; k < strK.length; k++){
	%>
<%Keepaccount data = (Keepaccount) request.getAttribute(strK[k]); %>
<tr>
<td>
<%=data.getincome() %>
</td>
<td>
<%=data.getspending() %>
</td>
</tr>
<%} %>
</table>
</body>
</html>