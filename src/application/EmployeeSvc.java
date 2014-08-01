package application;

public class EmployeeSvc implements IEmployeeSvc {
IEmployeeDao dao=new EmployeeDao();
	@Override
	public String fetchEmployeeById(int id) {
		return dao.fetchEmployeeById(id);
	}
	public void setDao(IEmployeeDao dao) {
		this.dao = dao;
	}

}
