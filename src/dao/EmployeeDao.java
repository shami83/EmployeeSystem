package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import bean.EmployeeBean;
import bean.MarkerBean;


public class EmployeeDao extends JDBCDao{
	public EmployeeDao()throws Exception
	{
		super();
	}
	
	public void updateEmployee(Integer id,String fname,String lname,String sex,String dept,String address) throws Exception
	{
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(UPDATE);
		query.append(getTable()+" ");
		query.append("set");
		query.append(" firstname = ");
		query.append("'");
		query.append(fname);
		query.append("'");
		query.append(",");
		
		query.append(" lastname = ");
		query.append("'");
		query.append(lname);
		query.append("'");
		query.append(",");
		
		query.append(" sex = ");
		query.append("'");
		query.append(sex);
		query.append("'");
		query.append(",");
		
		query.append(" address = ");
		query.append("'");
		query.append(address);
		query.append("'");
		query.append(",");
		
		query.append(" dept = ");
		query.append("'");
		query.append(dept);
		query.append("'");
		
		
		
		query.append(WHERE);
		query.append(" id = ");
		query.append(id);
		System.out.println(this.getClass()+": " + query.toString());
		st.executeUpdate(query.toString());
		//closeAll();
		
	}
	public void deleteEmployee(Integer id) throws Exception
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
	public EmployeeBean findByID(Integer id,boolean doNotClosed) throws Exception
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
		EmployeeBean bean =(EmployeeBean)processSingleRow(result);
		if(!doNotClosed)
		closeAll();
		return bean;
	}
	
	
	public EmployeeBean findByID(Integer id) throws Exception
	{
		return findByID(id,false);
	}
	
	public List findAllEmployee(Map paramMap,String orderColumn) throws Exception
	{
		List list =null;
		st =con.createStatement();
		StringBuffer query =new StringBuffer();
		query.append(SELECT_ALL);
		query.append(getTable());
		if(paramMap != null && paramMap.size()>0)
		{
			query.append(WHERE);
			for(Iterator it=paramMap.keySet().iterator();it.hasNext();)
			{
				String key = (String)it.next();
				query.append(key + " LIKE '");
				query.append(paramMap.get(key));
				query.append("%'");
				if(it.hasNext())
				{
					query.append(" AND ");
				}
			}
		}
		query.append(ORDER_BY);
		query.append(orderColumn);
		
		
		System.out.println(this.getClass()+": " + query.toString());
		ResultSet result = st.executeQuery(query.toString());
		list =(List)processRow(result);
		closeAll();
		return list;
	}

	@Override
	public List processRow(ResultSet set) throws Exception {
		List list = new ArrayList();
		EmployeeBean bean  = null;
		while(set.next())
		{
		
			 bean = new  EmployeeBean();
			 bean.setId(set.getInt(1));
			 bean.setFname(set.getString(2));
			 bean.setLname(set.getString(3));
			 bean.setSex(set.getString(4));
			 bean.setAddress(set.getString(5));
			 bean.setDept(set.getString(6));
			 bean.setAdmin(set.getInt(7));
			 bean.setPassword(set.getString(8));
			 System.out.println(bean);
			 
			 list.add(bean);
		}
		return list;
	}

	@Override
	public MarkerBean processSingleRow(ResultSet set) throws Exception {
		EmployeeBean bean  = null;
		while(set.next())
		{
			 bean = new  EmployeeBean();
			 bean.setId(set.getInt(1));
			 bean.setFname(set.getString(2));
			 bean.setLname(set.getString(3));
			 bean.setSex(set.getString(4));
			 bean.setAddress(set.getString(5));
			 bean.setDept(set.getString(6));
			 bean.setAdmin(set.getInt(7));
			 bean.setPassword(set.getString(8));
			 			 
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
		String table="employee";
		return table;
	}
	


}
