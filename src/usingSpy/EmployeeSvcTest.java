package usingSpy;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;

import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import application.EmployeeDao;
import application.EmployeeSvc;
import application.IEmployeeDao;
import application.IEmployeeSvc;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeSvcTest {
	 @Spy
	 IEmployeeDao employeeDao=new EmployeeDao();

	 @InjectMocks
	 IEmployeeSvc employeeSvc=new EmployeeSvc();

	@Test
	public void testFetchEmployeeById() {

		
	
		when(employeeDao.fetchEmployeeById(1)).thenReturn("tamajit");

		Assert.assertEquals("tamajit", employeeSvc.fetchEmployeeById(1));
		Assert.assertEquals("jack", employeeSvc.fetchEmployeeById(2));
		
		verify(employeeDao,times(1)).fetchEmployeeById(1);
		verify(employeeDao,times(1)).fetchEmployeeById(2);
		
	}
}
