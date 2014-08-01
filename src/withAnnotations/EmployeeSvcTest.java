package withAnnotations;

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
	 @Mock
	 IEmployeeDao employeeDao;

	 @InjectMocks
	 IEmployeeSvc employeeSvc=new EmployeeSvc();
	 /*alternative injectmock*/
//	 @InjectMocks
//	 EmployeeSvc employeeSvc;;
	 @Captor ArgumentCaptor<Integer> captor;
	@Test
	public void testFetchEmployeeById() {

		
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
