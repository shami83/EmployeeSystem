<%@ page language="java"%>
<%@ page import="java.util.*" %>

<%
String title = (String)request.getAttribute("title");
Map<String,String> map =(Map<String,String>)request.getAttribute("status");
String theme = "blue";
theme="images/"+theme+"theme.jpg";
%>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend><%=title%></legend>
  
<table width="100%" style="background-image:url('<%=theme%>');">
<%for(String key : map.keySet()){ 
	if(!key.equalsIgnoreCase("action"))
	{
%>

<tr><td style="color:red"><%=key%>:<td><td style="color:red"><%=map.get(key) %></td></tr>
<%}}%>
<tr><td><a href="<%=map.get("action")%>">Back</td></tr>
</table>
</fieldset>
</body>
</html>