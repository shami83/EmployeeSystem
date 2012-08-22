<%@ page import="util.*" %>
<html>
<body>
<%
String theme = "blue";
theme="images/"+theme+"theme.jpg";
%>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend>Create Employee</legend>
  <form action="employee" method="post">
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td>First Name:<td><td><input type="text" name="fname"></td></tr>
<tr><td>Last Name:<td><td><input type="text" name="lname"></td></tr>
<tr><td>Password:<td><td><input type="password" name="password"></td></tr>
<tr><td>Sex:<td><td><input type="radio" name="sex" value="Male" checked> Male<input type="radio" name="sex" value="Female">Female</td></tr>
<tr><td>Address:<td><td><input type="text" name="address"></td></tr>
<tr><td>Depertment:<td><td><input type="text" name="dept"></td></tr>
<tr><td colspan="2" align="center"><input type="submit" value="create"></td></tr>
<input type="hidden" name="param" value="create"/>
</table>
</form>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>