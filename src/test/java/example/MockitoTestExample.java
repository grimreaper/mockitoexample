package example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class MockitoTestExample {

    private static class A {
        public int returnItself(int argument, int xxx) {
            return 0;
        }
    }


    @Mock
    private A a;

    @Test
    public void testMockitoProblem() {
        when(a.returnItself(1, 0)).thenReturn(1);
        when(a.returnItself(2, 0)).thenReturn(2);

        assertEquals(1, a.returnItself(1, 0));
        assertEquals(2, a.returnItself(2, 0));
    }

}
