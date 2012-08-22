<%@page import="bean.*" %>
<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
EmployeeBean emp = (EmployeeBean)request.getAttribute("Employee");
String theme = "blue";
theme="images/"+theme+"theme.jpg";
%>
<fieldset>
  <legend>Edit Employee</legend>
  <form action="employee" method="post">
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td>FirstName:<td><td><input type="text" name="fname" value="<%=emp.getFname()%>"></td></tr>
<tr><td>LastName:<td><td><input type="text" name="lname" value="<%=emp.getLname()%>"></td></tr>
<tr><td>Sex:<td><td><input type="text" name="sex" value="<%=emp.getSex()%>"></td></tr>
<tr><td>Depertment:<td><td><input type="text" name="dept"  value="<%=emp.getDept()%>"></td></tr>
<tr><td>Address:<td><td><input type="text" name="address" value="<%=emp.getAddress()%>"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="update"></td></tr>
<input type="hidden" name="param" value="update"/>
<input type="hidden" name="id" value="<%=emp.getId()%>"/>
</table>
</form>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>