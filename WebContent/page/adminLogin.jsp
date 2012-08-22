 <%@page import="bean.*" %>
<html>
<body>
<%
String theme = "blue";
theme="images/"+theme+"theme.jpg";
%>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend>Utility links:</legend>
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="createEmployee.jsp"%>Create Employee.</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to create a new Employee.</td></tr>
<tr><td style="font-family:arial;font-size:15;text-decoration:none"><a style="text-decoration:none" href="employee?param=viewAll">View All Employee</a>:</td>
<td style="font-family:arial;font-size:15">Please click this url to View & Search  all Employees.</td></tr>
</table>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>