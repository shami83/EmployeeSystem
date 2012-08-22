package bean;

public class EmployeeBean implements MarkerBean{
	
	Integer id;
	String fname;
	String lname;
	String sex;
	String address;
	String dept;
	String password;
	Integer admin;
	
	public Integer getAdmin() {
		return admin;
	}
	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	public boolean isAdmin()
	{
		return admin==1;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


	

	@Override
	public String toString() {
		return "EmployeeBean [id=" + id + ", fname=" + fname + ", lname="
				+ lname + ", sex=" + sex + ", address=" + address + ", dept="
				+ dept + "]";
	}
	

}
