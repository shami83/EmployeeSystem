 <%@page import="bean.*" %>
<html>
<body>
<%
String theme = "blue";
theme="images/"+theme+"theme.jpg";
EmployeeBean bean = (EmployeeBean)request.getSession().getAttribute("EMPLOYEE");
%>
<jsp:include page="header.jsp"></jsp:include>
<table width="100%" style="background-image:url('<%=theme%>');">
<tr>
<td width ="40%" valign="top">
<fieldset>
  <legend>Personal Details:</legend>
  <table width="100%">
  <tr>
  <td style="font-family:arial;font-size:12;text-decoration:none">Name</td>
  <td><%=bean.getFname()%><%=bean.getLname() %></td>
  </tr>
  <tr>
  <td style="font-family:arial;font-size:12;text-decoration:none">Sex</td>
  <td><%=bean.getSex()%></td>
  </tr>
  <tr>
  <td style="font-family:arial;font-size:12;text-decoration:none">Depertment</td>
  <td><%=bean.getDept()%></td>
  </tr>
  <tr>
  <td style="font-family:arial;font-size:12;text-decoration:none">Address</td>
  <td><%=bean.getAddress()%></td>
  </tr>
  </table>
  </fieldset>
</td>
<td width="60%" valign="top">
<fieldset>
  <legend>Utility links:</legend>
  <table width="100%">
  <tr><td style="font-family:arial;font-size:12;text-decoration:none"><a style="text-decoration:none" href="employee?param=edit&id=<%=bean.getId()%>">Edit<%=bean.getFname()%><%=bean.getLname()%></a>:</td>
  <td style="font-family:arial;font-size:15">Please click this url to edit personal information</td></tr>
  </table>
  </fieldset>
</td>
</tr>
</table>




<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>