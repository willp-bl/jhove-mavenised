/**
 * 
 */
package jhove1.output.test;

import static org.junit.Assert.*;

import java.io.File;

import jhove1x.JhoveAPI;

import org.junit.Test;

/**
 * @author wpalmer
 *
 */
public class JPGTests {

	/*
	 * NOTE that these tests ignore <date> and <repInfo> in Jhove outputs as they are temporal 
	 * -> see Jhove1Wrapper.loadXML()
	 */
	
	final static String RESDIR_GOVDOCS = "src/test/resources/govdocs/jpg/";
	
	/*
	 * THE FOLLOWING TESTS SHOULD PASS
	 */
	
	@Test
	public void testJPGShouldPass_1() {
		File testFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldPass_2() {
		File testFile = new File(RESDIR_GOVDOCS+"000515.jpg");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldPass_3() {
		File testFile = new File(RESDIR_GOVDOCS+"000540.jpg");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldPass_4() {
		File testFile = new File(RESDIR_GOVDOCS+"000546.jpg");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldPass_5() {
		File testFile = new File(RESDIR_GOVDOCS+"000874.jpg");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldPass_6() {
		File testFile = new File(RESDIR_GOVDOCS+"000969.jpg");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}

	/*
	 * THE FOLLOWING TESTS SHOULD FAIL
	 */
	
	@Test
	public void testJPGShouldFail_1() {
		File testFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000515.jpg");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldFail_2() {
		File testFile = new File(RESDIR_GOVDOCS+"000515.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldFail_3() {
		File testFile = new File(RESDIR_GOVDOCS+"000540.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldFail_4() {
		File testFile = new File(RESDIR_GOVDOCS+"000546.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldFail_5() {
		File testFile = new File(RESDIR_GOVDOCS+"000874.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGShouldFail_6() {
		File testFile = new File(RESDIR_GOVDOCS+"000969.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	/*
	 * THE FOLLOWING TESTS SHOULD FAIL - comparing truncated files
	 */	
	
	@Test
	public void testJPGTruncatedShouldFail_1() {
		File testFile = new File(RESDIR_GOVDOCS+"000245.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.truncated.jpg");
		if(JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(otherFile))) {
			fail("Truncated file not detected: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGTruncatedShouldFail_2() {
		File testFile = new File(RESDIR_GOVDOCS+"000515.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000515.truncated.jpg");
		if(JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(otherFile))) {
			fail("Truncated file not detected: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGTruncatedShouldFail_3() {
		File testFile = new File(RESDIR_GOVDOCS+"000540.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000540.truncated.jpg");
		if(JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(otherFile))) {
			fail("Truncated file not detected: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGTruncatedShouldFail_4() {
		File testFile = new File(RESDIR_GOVDOCS+"000546.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000546.truncated.jpg");
		if(JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(otherFile))) {
			fail("Truncated file not detected: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGTruncatedShouldFail_5() {
		File testFile = new File(RESDIR_GOVDOCS+"000874.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000874.truncated.jpg");
		if(JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(otherFile))) {
			fail("Truncated file not detected: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testJPGTruncatedShouldFail_6() {
		File testFile = new File(RESDIR_GOVDOCS+"000969.jpg");
		File otherFile = new File(RESDIR_GOVDOCS+"000969.truncated.jpg");
		if(JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(otherFile))) {
			fail("Truncated file not detected: "+testFile.getAbsolutePath());
		}
	}
	
	
}
