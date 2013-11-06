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
public class TIFFTests {

	/*
	 * NOTE that these tests ignore <date> and <repInfo> in Jhove outputs as they are temporal 
	 * -> see Jhove1Wrapper.loadXML()
	 */
	
	final static String RESDIR_GOVDOCS = "src/test/resources/govdocs/jpg_to_tif/";
	
	/*
	 * THE FOLLOWING TESTS SHOULD PASS
	 */
	
	@Test
	public void testTIFFShouldPass_1() {
		File testFile = new File(RESDIR_GOVDOCS+"000245.jpg.tif");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldPass_2() {
		File testFile = new File(RESDIR_GOVDOCS+"000515.jpg.tif");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldPass_3() {
		File testFile = new File(RESDIR_GOVDOCS+"000540.jpg.tif");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldPass_4() {
		File testFile = new File(RESDIR_GOVDOCS+"000546.jpg.tif");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldPass_5() {
		File testFile = new File(RESDIR_GOVDOCS+"000874.jpg.tif");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldPass_6() {
		File testFile = new File(RESDIR_GOVDOCS+"000969.jpg.tif");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}

	/*
	 * THE FOLLOWING TESTS SHOULD FAIL
	 */
	
	@Test
	public void testTIFFShouldFail_1() {
		File testFile = new File(RESDIR_GOVDOCS+"000245.jpg.tif");
		File otherFile = new File(RESDIR_GOVDOCS+"000515.jpg.tif");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldFail_2() {
		File testFile = new File(RESDIR_GOVDOCS+"000515.jpg.tif");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg.tif");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldFail_3() {
		File testFile = new File(RESDIR_GOVDOCS+"000540.jpg.tif");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg.tif");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldFail_4() {
		File testFile = new File(RESDIR_GOVDOCS+"000546.jpg.tif");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg.tif");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldFail_5() {
		File testFile = new File(RESDIR_GOVDOCS+"000874.jpg.tif");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg.tif");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testTIFFShouldFail_6() {
		File testFile = new File(RESDIR_GOVDOCS+"000969.jpg.tif");
		File otherFile = new File(RESDIR_GOVDOCS+"000245.jpg.tif");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
}
