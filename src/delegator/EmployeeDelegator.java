package delegator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import dao.DataType;
import dao.EmployeeDao;
import bean.*;


/**
 * Servlet implementation class EmployeeDelegator
 */
public class EmployeeDelegator extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private static final String forwardURL = "/employeeLogin.jsp";
	private static final String adminForwardURL = "/adminLogin.jsp";
	private static final String errorUrl = "/globalError.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeDelegator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String param = request.getParameter("param");
		if(param == null)
		{
			return;
		}
		if(param.equalsIgnoreCase("create"))
		{
			create(request,response);
		}
		else if(param.equalsIgnoreCase("login"))
		{
			try {
				login(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("viewAll"))
		{
			try {
				viewAll(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("update"))
		{
			try {
				updateEmployee(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("edit"))
		{
			try {
				editEmployee(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else if(param.equalsIgnoreCase("delete"))
		{
			try {
				deleteEmployee(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private void create(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			String fname = request.getParameter("fname");
			String lname = request.getParameter("lname");
			String sex = request.getParameter("sex");
			String address = request.getParameter("address");
			String dept = request.getParameter("dept");
			String password = request.getParameter("password");
			Integer admin=0;
			Date date =new Date();
			DataType fnameType =new DataType(DataType.Text,fname);
			DataType lnameType =new DataType(DataType.Text,lname);
			DataType sexType =new DataType(DataType.Text,sex);
			DataType adressType =new DataType(DataType.Text,address);
			DataType deptType =new DataType(DataType.Text,dept);
			DataType adminType =new DataType(DataType.Integer,admin);
			DataType passwordType =new DataType(DataType.Text,password);
			Map<String,String> map =new HashMap<String,String>();
			map.put("First Name", fname);
			map.put("Last Name", lname);
			map.put("Sex", sex);
			map.put("Address", address);
			map.put("Depertment", dept);
			List list = new ArrayList();
			list.add(fnameType);
			list.add(lnameType);
			list.add(sexType);
			list.add(adressType);
			list.add(deptType);
			list.add(adminType);
			list.add(passwordType);
			
			List columnList =new ArrayList();
			columnList.add("firstname");
			columnList.add("lastname");
			columnList.add("sex");
			columnList.add("address");
			columnList.add("dept");
			columnList.add("isadmin");
			columnList.add("password");
			EmployeeDao dao =new EmployeeDao();
			dao.insert("employee", list,columnList);
			request.setAttribute("title","Employee Created Successfull!!!");
			request.setAttribute("status",map);
			this.getServletContext().getRequestDispatcher("/outcome.jsp").forward(request, response);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		
		
	}
	private void editEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empId = request.getParameter("id");
		Integer id = Integer.parseInt(empId.trim());
		EmployeeDao dao =new EmployeeDao();
		EmployeeBean bean = dao.findByID(id);
		request.setAttribute("Employee", bean);
		this.getServletContext().getRequestDispatcher("/editEmployee.jsp").forward(request, response);
	}	
	
	private void updateEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empId = request.getParameter("id");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String sex = request.getParameter("sex");
		String address = request.getParameter("address");
		String dept = request.getParameter("dept");
		EmployeeBean  loggedEmployee = (EmployeeBean)request.getSession().getAttribute("EMPLOYEE");
		Integer id = Integer.parseInt(empId.trim());
		EmployeeDao dao =new EmployeeDao();
		dao.updateEmployee(id, fname,lname,sex,dept,address);
		EmployeeBean bean = dao.findByID(id,true);
		request.getSession().setAttribute("EMPLOYEE", bean);
		if(loggedEmployee.isAdmin())
		{
			Map map =(Map)request.getSession().getAttribute("SEARCH_MAP");
			List list = dao.findAllEmployee(map,"firstname");
			request.setAttribute("EmployeeList", list);
			this.getServletContext().getRequestDispatcher("/AllEmployeeView.jsp").forward(request, response);
			
		}
		this.getServletContext().getRequestDispatcher("/employeeLogin.jsp").forward(request, response);
		
	}
	
	private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String empId = request.getParameter("id");
		Integer id = Integer.parseInt(empId.trim());
		EmployeeDao dao =new EmployeeDao();
		dao.deleteEmployee(id);
		Map map =(Map)request.getSession().getAttribute("SEARCH_MAP");
		List list = dao.findAllEmployee(map,"firstname");
		request.setAttribute("EmployeeList", list);
		this.getServletContext().getRequestDispatcher("/AllEmployeeView.jsp").forward(request, response);
		
	}
	private void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String name =request.getParameter("name");
		String pass =request.getParameter("password");
		EmployeeBean bean =new EmployeeBean();
		bean.setFname(name);
		bean.setPassword(pass);
		try
		{
			EmployeeDao dao =new EmployeeDao();
			bean = dao.findByNameAndPassword(bean);
			if(bean == null)
			{
				HashMap<String,String> errorMap = new HashMap<String,String>();
				errorMap.put("Cause","Either username or password is wrong.");
				errorMap.put("action","welcome.jsp");
				request.setAttribute("status", errorMap);
				getServletContext().getRequestDispatcher(errorUrl).forward(request, response);
			}
			else
			{
				System.out.println(bean);
				request.getSession().setAttribute("EMPLOYEE", bean);
				request.getSession().setAttribute("LOGIN", "true");
				request.getSession().setAttribute("ISADMIN", bean.isAdmin());
				if(bean.isAdmin())
				{
					getServletContext().getRequestDispatcher(adminForwardURL).forward(request, response);
				}
				getServletContext().getRequestDispatcher(forwardURL).forward(request, response);
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		
	
	}
	
	private void viewAll(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String dept = request.getParameter("dept");
		String sex =request.getParameter("sex");
		
		Map map =null;
		if(fname!= null || lname!= null || dept!=null || sex !=null)
		{
			map =new HashMap();
			if(fname != null)
			{
				map.put("firstname", fname);
			}
			if(lname != null)
			{
				map.put("lastname", lname);
			}
			if(dept != null)
			{
				map.put("dept", dept);
			}
			if(sex!=null && !sex.equalsIgnoreCase("all"))
			{
				map.put("sex", sex.toLowerCase());
			}
			
			
		}
		EmployeeDao dao =new EmployeeDao();
		request.getSession().setAttribute("SEARCH_MAP", map);
		List list = dao.findAllEmployee(map,"firstname");
		request.setAttribute("EmployeeList", list);
		this.getServletContext().getRequestDispatcher("/AllEmployeeView.jsp").forward(request, response);
	}
	

}
