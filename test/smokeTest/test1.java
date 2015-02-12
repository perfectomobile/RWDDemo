package smokeTest;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class test1 {
   @BeforeSuite
   public void before() {
		  System.out.println("BEFORE");
	  }
   
   @Test(groups = { "ios","android","checkLogin","P1" })
  public void a() {
	  System.out.println("Test1 A");
  }
  @Test(groups = { "ios","android","checkLogin","P2" })
  public void B() {
	  System.out.println("Test1 B");

  }
  @AfterSuite
  public void after() {
		  System.out.println("AFTER");
	  }
}
