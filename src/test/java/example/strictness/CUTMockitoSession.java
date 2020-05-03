package example.strictness;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.quality.Strictness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CUTMockitoSession {
    @Mock
    private UselessClass a;
    private MockitoSession mockito;

    @Before
    public void setUp() {
        mockito = Mockito.mockitoSession()
                .initMocks(this)
                .strictness(Strictness.STRICT_STUBS)
                .startMocking();
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

    @After
    public void tearDown() {
        mockito.finishMocking();
    }


}
