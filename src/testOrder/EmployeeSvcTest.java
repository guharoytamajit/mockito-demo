package testOrder;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InOrder;
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
	@Mock
	IEmployeeDao employeeDao;

	@InjectMocks
	IEmployeeSvc employeeSvc = new EmployeeSvc();

	@Test
	public void testFetchEmployeeById() {
		// you can pass multiple mock objects seperated with comma
		InOrder inOrder = inOrder(employeeDao);

		when(employeeDao.fetchEmployeeById(1)).thenReturn("tamajit");
		// calling stubbed method of mock object
		Assert.assertEquals("tamajit", employeeSvc.fetchEmployeeById(1));
		// calling unstubbed method of mock object, so it should returns null
		Assert.assertEquals(null, employeeSvc.fetchEmployeeById(2));
		// verify order of invocation(if you change the order it should report error)
		inOrder.verify(employeeDao, times(1)).fetchEmployeeById(1);
		inOrder.verify(employeeDao, times(1)).fetchEmployeeById(2);

	}
}
