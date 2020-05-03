package example.strictness;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoSession;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.junit.MockitoTestRule;
import org.mockito.quality.Strictness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

public class CUTTestRule {
    @Mock
    private UselessClass a;

    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);

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
