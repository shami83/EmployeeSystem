<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*,bean.*"%>
 <%
 List result =(List)request.getAttribute("EmployeeList");
 int counter=0;
 Map<String,String> map = new HashMap<String,String>();
 map.put("male", "Male");
 map.put("female", "Female");
 String theme = "blue";
 theme="images/"+theme+"theme.jpg";
 %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function confirmDelete(delUrl) {
  if (confirm("Are you sure you want to delete")) {
    document.location = delUrl;
  }
}
</script>

</head>
<body>
<jsp:include page="header.jsp"></jsp:include>
<fieldset>
  <legend style="color:orange;font-size:20px;font-weight:bold">Search Criteria</legend>
  <form action="employee?param=viewAll" method="post">
  <table width="100%" style="background-image:url('<%=theme%>');">
  <tr>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">FirstName :</td><td><input type="text" name="fname"/></td>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">LastName :</td><td><input type="text" name="lname"/></td>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">Sex :</td>
  <td>
  <select name="sex">
  <option value="all">-------</option>
  <%
  for(String key : map.keySet())
  {
	   out.println("<option value=\""+key+"\">"+map.get(key)+"</option>");
  }
  %>
  </select>
  </td>
  </tr>
  <tr>
  <td style="font-family:arial;font-size:15px;color:blue;font-weight:bold">Depertment :</td><td><input type="text" name="dept"/></td>
  </tr>
   <tr>
  	<td colspan="2" align="center"><input type="submit" value="search"/></td>
   </tr>
 
  </table>
  </form>
 </fieldset>
<fieldset>
  <legend style="color:orange;font-size:20px;font-weight:bold">All Player(<%=result!=null?result.size():"0" %>)</legend>
<table width ="100%" style="background-image:url('<%=theme%>');">
<tr>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">FirstName</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">LastName</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Depertment</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Sex</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Administrator</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Address</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Edit</td>
<td style="font-family:arial;font-size:20px;color:blue;font-weight:bold">Delete</td>
</tr>
<% for(Object obj : result){
	EmployeeBean bean = (EmployeeBean)obj;
	String isAdmin = bean.isAdmin()?"Yes":"No";
	if(counter%2 == 0)
	{
		out.println("<tr bgcolor=\"#FFF284\">");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getFname()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getLname()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getDept()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getSex()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+isAdmin+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getAddress()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"employee?param=edit&id="+bean.getId()+"\">"+"Edit"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"javascript:confirmDelete('employee?param=delete&id="+bean.getId()+"')\">"+"Delete"+"</a></td>");
		out.println("</tr>");
	}
	else
	{
		out.println("<tr bgcolor=\"#FFF284\">");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getFname()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getLname()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getDept()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getSex()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+isAdmin+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\">"+bean.getAddress()+"</td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"employee?param=edit&id="+bean.getId()+"\">"+"Edit"+"</a></td>");
		out.println("<td style=\"font-family:arial;font-size:15px;color:green;font-weight:bold\"><a href=\"javascript:confirmDelete('employee?param=delete&id="+bean.getId()+"')\">"+"Delete"+"</a></td>");
		out.println("</tr>");
	}
	counter++;
%>

<tr>

</tr>
<%}%> 

</table>
</fieldset>
<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>