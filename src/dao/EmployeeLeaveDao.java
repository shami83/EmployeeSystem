package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.EmployeeBean;
import bean.EmployeeLeaveBean;
import bean.MarkerBean;


public class EmployeeLeaveDao extends JDBCDao{
	public EmployeeLeaveDao()throws Exception
	{
		super();
	}
	
	public void updateLeave(Integer id,String from,String to,String days,String dept,String address) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(UPDATE);
		query.append(getTable()+" ");
		query.append("set");
		query.append(" from = ");
		query.append("'");
		query.append(from);
		query.append("'");
		query.append(",");
		
		query.append(" to = ");
		query.append("'");
		query.append(to);
		query.append("'");
		query.append(",");
		
		query.append(" days = ");
		query.append("'");
		query.append(days);
		query.append("'");
		query.append(",");
				
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		//closeAll();
		
	}
	public void updateLeaveStatus(Integer id,Integer status) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(UPDATE);
		query.append(getTable()+" ");
		query.append("set");
		query.append(" status = ");
		query.append(status);
			
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		//closeAll();
		
	}
	public void deleteLeave(Integer id) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(DELETE);
		query.append(getTable());
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		//closeAll();
		
	}
	public EmployeeLeaveBean findByID(Integer id,boolean doNotClosed) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append(getTable());
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		EmployeeLeaveBean bean =(EmployeeLeaveBean)processSingleRow(result);
		if(!doNotClosed)
		closeAll();
		return bean;
	}
	
	
	public EmployeeLeaveBean findByID(Integer id) throws Exception
	{
		return findByID(id,false);
	}
	
	public List findAllEmployeeByStausAndID(Integer id,Integer status) throws Exception
	{
		List list =null;
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append("Select el.id,el.emp_id,el.from,el.to,el.days,el.status from employee e emp_leave el");
		query.append(WHERE);
		query.append(" e.id =  ");
		query.append(id);
		query.append(" AND ");
		query.append(" el.status = ");
		query.append(status);
		query.append(" AND ");
		query.append(" e.id = el.emp_id");
		
		
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		list =(List)processRow(result);
		
		closeAll();
		return list;
	}
	
	public List findAllEmployeeByStausAndName(String name,Integer status) throws Exception
	{
		List list =null;
		EmployeeDao dao =new EmployeeDao();
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append("Select el.id,el.emp_id,el.from,el.to,el.days,el.status from employee e emp_leave el");
		query.append(WHERE);
		if(name !=  null)
		{
			query.append(" e.firstname like ");
			query.append("'");
			query.append(name+"%");
			query.append("'");
			query.append(" AND ");
		}
		query.append(" el.status = ");
		query.append(status);
		query.append(" AND ");
		query.append(" e.id = el.emp_id");
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		list =(List)dao.processRow(result);
		
		closeAll();
		return list;
	}


	@Override
	public List processRow(ResultSet set) throws Exception {
		List list = new ArrayList();
		EmployeeLeaveBean bean  = null;
		EmployeeBean eBean=null;
		EmployeeDao dao =new EmployeeDao();
		while(set.next())
		{
		
			 bean = new  EmployeeLeaveBean();
			 bean.setId(set.getInt(1));
			 bean.setEmp(set.getInt(2));
			 eBean = dao.findByID(set.getInt(2), true);
			 bean.setEmployee(eBean);
			 bean.setFrom(set.getString(3));
			 bean.setTo(set.getString(4));
			 bean.setDays(set.getString(5));
			 bean.setStatus(set.getInt(6));
			 System.out.println(bean);
			 
			 list.add(bean);
		}
		return list;
	}

	@Override
	public MarkerBean processSingleRow(ResultSet set) throws Exception {
		EmployeeLeaveBean bean  = null;
		EmployeeBean eBean=null;
		EmployeeDao dao =new EmployeeDao();
		while(set.next())
		{
			 bean = new  EmployeeLeaveBean();
			 bean.setId(set.getInt(1));
			 bean.setEmp(set.getInt(2));
			 eBean = dao.findByID(set.getInt(2), true);
			 bean.setEmployee(eBean);
			 bean.setFrom(set.getString(3));
			 bean.setTo(set.getString(4));
			 bean.setDays(set.getString(5));
			 bean.setStatus(set.getInt(6));
			 System.out.println(bean);
		}
		return bean;
	}
	
	public EmployeeBean findByNameAndPassword(EmployeeBean bean) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append("employee");
		query.append(WHERE);
		query.append(" firstname = '");
		query.append(bean.getFname());
		query.append("'");
		query.append(AND);
		query.append(" password = '");
		query.append(bean.getPassword());
		query.append("'");
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		bean =(EmployeeBean)processSingleRow(result);
		closeAll();
		return bean;
	}
	
	
		
	
	public String getTable()
	{
		String table="emp_leave";
		return table;
	}
	


}
