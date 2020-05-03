package example.strictness;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.StrictStubs.class)
public class CUTJUnitRunnerStrict {
    @Mock
    private UselessClass a;

    @Before
    public void setUp() {
        when(a.returnItself(1)).thenReturn(2);
    }

    @Test
    public void testOne() {
        assertEquals(1, 1);
    }

    @Test
    public void testTwo() {
        assertEquals(2, a.returnItself(1));
    }

}
