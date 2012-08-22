 <%
 String ribon = "blue"+"ribon.jpg";
 String theme ="images/"+"blue"+".jpg";
 String themeFont = "white";
 ribon="images/"+ribon;
 %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
<table width="100%" height="120" style="background-image:url('<%=ribon%>');">
<tr><td>&nbsp;</td></tr>
</table>
<table width="100%" style="background-image:url('<%=theme%>');">
<tr><td align="center"  style="font-family:arial;font-size:12px;color:<%=themeFont%>">Employee Management Site.</td></tr>
<tr><td align="center"  style="font-family:arial;font-size:12px;color:<%=themeFont%>">We can easily Manage Employee Data.</td></tr>
<tr><td align="center" style="font-family:arial;font-size:15px;color:<%=themeFont%>">© Copyright 2012 Simple Employee Manager All rights Reserved</td></tr>
</table>
</body>
</html>