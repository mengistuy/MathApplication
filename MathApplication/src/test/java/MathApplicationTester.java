import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

// @RunWith attaches a runner with the test class to initialize the test data
@RunWith(MockitoJUnitRunner.class)
public class MathApplicationTester {

    //@InjectMocks annotation is used to create and inject the mock object
    @InjectMocks
    MathApplication mathApplication = new MathApplication();

    //@Mock annotation is used to create the mock object to be injected
    @Mock
    CalculatorService calcService;

    @Test
    public void testAdd(){
        //add the behavior of calc service to add two numbers
        when(calcService.add(10.0,20.0)).thenReturn(30.00);

        //test the add functionality
        Assert.assertEquals(mathApplication.add(10.0, 20.0),30.0,0);

        verify(calcService).add(10.0,20.0);

        //limit the method call to 1, no less and no more calls are allowed
        verify(calcService, times(1)).add(10.0, 20.0);

        //check a minimum 1 call count
        verify(calcService, atLeastOnce()).add(10.0, 20.0);

      /*  //check if add function is called minimum 2 times
        verify(calcService, atLeast(2)).add(10.0, 20.0);

        //check if add function is called maximum 3 times
        verify(calcService, atMost(3)).add(10.0,20.0);*/
        reset(calcService);
    }
    @Test
    public void testSubtract(){
        //add the behavior of calc service to subtract two numbers
        when(calcService.subtract(50.0,20.0)).thenReturn(30.00);

        //test the subtract functionality
        Assert.assertEquals(mathApplication.subtract(50.0, 20.0),30.0,0);

        verify(calcService).subtract(50.0,20.0);

        //add the behavior of calc service to subtract two numbers
        when(calcService.subtract(50.0,20.0)).thenReturn(30.00);

        //limit the method call to 1, no less and no more calls are allowed
        verify(calcService, times(1)).subtract(50.0, 20.0);

        reset(calcService);
    }
    @Test
    public void testMultiplication()
    {
        when(calcService.multiply(10,5)).thenReturn(50.00);
        Assert.assertEquals(mathApplication.multiply(10.0,5.0),50.00,0);
        verify(calcService).multiply(10.0,5.0);
        reset(calcService);
    }
    @Test
    public void testdivide()
    {
        when(calcService.divide(10,5)).thenReturn(2.00);
        Assert.assertEquals(mathApplication.divide(10.0,5.0),2.00,0);
        verify(calcService).divide(10.0,5.0);
        reset(calcService);
    }
}
