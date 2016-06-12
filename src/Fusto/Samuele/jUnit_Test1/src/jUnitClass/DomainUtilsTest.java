package jUnitClass;

/**
 * Created by Samuele on 06/05/2016.
 */
import static org.junit.Assert.assertEquals;
import java.util.Arrays;
import Utils.DomainUtils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class DomainUtilsTest {
    private String domain;
    private boolean expected;

    public DomainUtilsTest(String domain, boolean expected) {
        this.domain = domain;
        this.expected = expected;
    }

    @Parameters(name= "{index}: isValid({0})={1}")
    public static Iterable<Object[]> data() {
        return Arrays.asList(new Object[][] {
                        { "prova.com", true },
                        { "test.com", true },
                        { "bah-.com", false },
                        { "fdsgd.com", true },
                        { "aofajfa", false },
                        { "124#ò.com", false }
                }
        );
    }

    @Test
    public void validDomainsTest() {
        assertEquals(expected, DomainUtils.isValidDomainName(domain));
    }

}