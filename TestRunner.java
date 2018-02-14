import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class TestRunner {
  public static void main() {
    Result result = JUnitCore.runClasses(HashMapTester.class);
    
    for (Failure failure : result.getFailures()) {
      System.out.println(failure.getTrace());
    }
    
    if ( result.wasSuccessful() )
      System.out.println("All tests successful.");
    else
      System.out.println("There were problems. " + result.getFailureCount() + " failures out of " + result.getRunCount() + " tests run.");
  }
}
