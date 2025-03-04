package testClasses;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class LogsTest {
	
	private static Logger logger = LogManager.getLogger(LogsTest.class);
	

	@Test
	public void testMethod1() {
		System.out.println("testMethod1 LogsTest ");
		logger.info("testMethod1 is executed info");
		logger.error("testMethod1 not executed error");
		logger.warn("testMethod1 get warnings warning");
		logger.fatal("testMethod1 had stopped fatal");
		System.out.println("test completed");

	}
	@Test
	public void testMethod2() {
		System.out.println("testMethod2 LogsTest ");
		logger.info("testMethod2 is executed info");
		logger.error("testMethod2 not executed error");
		logger.warn("testMethod2 get warnings warning");
		logger.fatal("testMethod2 had stopped fatal");
		System.out.println("testMethod2 completed");

	}
	@Test
	public void testMethod3() {
		System.out.println("testMethod3 LogsTest ");
		logger.info("testMethod3 is executed info");
		logger.error("testMethod3 not executed error");
		logger.warn("testMethod3 get warnings warning");
		logger.fatal("testMethod3 had stopped fatal");
		System.out.println("testMethod3 completed");

	}
	@Test
	public void testMethod4() {
		System.out.println("testMethod4 LogsTest");
		logger.info("testMethod4 is executed info");
		logger.error("testMethod4 not executed error");
		logger.warn("testMethod4 get warnings warning");
		logger.fatal("testMethod4 had stopped fatal");
		System.out.println("testMethod4 completed");

	}

}
