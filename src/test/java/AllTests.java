import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AccountTestCases.class, CheckingTestCases.class, SavingTestCases.class })
public class AllTests {

}
