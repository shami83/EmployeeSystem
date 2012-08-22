package bean;

public class EmployeeLeaveBean implements MarkerBean{
	
	Integer id;
	Integer emp;
	String from;
	String to;
	Integer status;
	String days;
	EmployeeBean employee;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmp() {
		return emp;
	}
	public void setEmp(Integer emp) {
		this.emp = emp;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getDays() {
		return days;
	}
	public void setDays(String days) {
		this.days = days;
	}
	
	public EmployeeBean getEmployee() {
		return employee;
	}
	public void setEmployee(EmployeeBean employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "EmployeeLeaveBean [id=" + id + ", emp=" + emp + ", from="
				+ from + ", to=" + to + ", status=" + status + ", days=" + days
				+ "]";
	}
	
	
	
	

}
