<html>
<body>
<jsp:include page="header.jsp"></jsp:include>
<%
String theme = "blue";
theme="images/"+theme+"theme.jpg";
String imgPath ="images/"+"bpo.jpg";
%>
<form name="main" action="employee" method="post">
<table width="100%" align="center" style="background-image:url('<%=theme%>');">
<tr>
<td width="100%">
<img width="100%" height="300px" src ="<%=imgPath%>"/>
</td>
</tr>
<tr>
<td width="100%">
<fieldset>
  <legend style="color:orange;font-size:20px;font-weight:bold">Login Panel</legend>
	<table width="25%" align="center">
	<tr><td>Name:</td><td><input type="text" name="name"></td></tr>
	<tr><td>Password:</td><td><input type="password" name="password"></td></tr>
	<input type="hidden" name="param" value="login"/>
	<tr><td colspan="2"><input type="submit" value="sign in"></td></tr>
	</table>
	</fieldset>
</td>
</tr>
</table>
</form>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>