package withoutAnnotations;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import application.EmployeeSvc;
import application.IEmployeeDao;
import application.IEmployeeSvc;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeSvcTest {

	@Test
	public void testFetchEmployeeById() {
		/*mocking without annotations*/
		IEmployeeDao employeeDao = mock(IEmployeeDao.class);
		EmployeeSvc employeeSvc = new EmployeeSvc();
		employeeSvc.setDao(employeeDao);
		ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
		
		// stubbing
		when(employeeDao.fetchEmployeeById(1)).thenReturn("tamajit");
		// validate method output
		Assert.assertEquals("tamajit", employeeSvc.fetchEmployeeById(1));
		// validate method invocation
		verify(employeeDao).fetchEmployeeById(captor.capture());
		// validate method input
		Assert.assertEquals(new Integer(1), captor.getValue());
	}
}
