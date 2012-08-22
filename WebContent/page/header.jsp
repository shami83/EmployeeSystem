<%
String login = (String)session.getAttribute("LOGIN");
Boolean admin= (Boolean)session.getAttribute("ISADMIN");
boolean isAdmin = admin==null?false:admin.booleanValue();
String theme = "blue";
String themeFont ="white";
theme ="images/"+theme+".jpg";
%>
<table width="100%" height="70" style="background-image:url('<%=theme%>');">
<tr>
<td width="1%">
&nbsp;
</td>
<td align="right" valign="top" style="font-family:arial;font-size:12px;color:<%=themeFont%>">
<%
if(login != null && isAdmin)
{
%>
<a href="adminLogin.jsp" style="font-family:arial;font-size:12px;color:<%=themeFont%>">Home</a> 
<%} else if(login != null && !isAdmin){%>
<a href="employeeLogin.jsp" style="font-family:arial;font-size:12px;color:<%=themeFont%>">Home</a>
<%}%> 
</tr>

</table>