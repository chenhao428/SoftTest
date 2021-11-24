package util;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
import junit.framework.JUnit4TestAdapter;
import junit.framework.Test;
import junit.framework.TestSuite;
@RunWith(Suite.class)
@SuiteClasses({ MyListTest.class })
public class TestSuit {
    public static Test suite() {
        TestSuite suite = new TestSuite("All JUnit test");
        suite.addTest(new JUnit4TestAdapter(MyList.class));
        return suite;
    }
}
