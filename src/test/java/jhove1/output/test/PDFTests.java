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
public class PDFTests {

	/*
	 * NOTE that these tests ignore <date> and <repInfo> in Jhove outputs as they are temporal 
	 * -> see Jhove1Wrapper.loadXML()
	 */
	
	final static String RESDIR_GOVDOCS = "src/test/resources/govdocs/pdf/";
	final static String RESDIR_LISBON = "src/test/resources/lisbon_set/";
	
	/*
	 * THE FOLLOWING TESTS SHOULD PASS
	 */
	
	@Test
	public void testPDFShouldPass_1() {
		File testFile = new File(RESDIR_GOVDOCS+"000369.pdf");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldPass_2() {
		File testFile = new File(RESDIR_GOVDOCS+"000577.pdf");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldPass_3() {
		File testFile = new File(RESDIR_GOVDOCS+"000606.pdf");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldPass_4() {
		File testFile = new File(RESDIR_GOVDOCS+"000663.pdf");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldPass_5() {
		File testFile = new File(RESDIR_LISBON+"lisbon_set_1_pdf14_ok.pdf");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldPass_6() {
		File testFile = new File(RESDIR_LISBON+"lisbon_set_2_pdf14_bad_font_name.pdf");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldPass_7() {
		File testFile = new File(RESDIR_LISBON+"lisbon_set_7_pdfa1b.pdf");
		if(!JhoveAPI.check(new File(testFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output does not match Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	/*
	 * THE FOLLOWING TESTS SHOULD FAIL
	 */
	
	@Test
	public void testPDFShouldFail_1() {
		File testFile = new File(RESDIR_GOVDOCS+"000369.pdf");
		File otherFile = new File(RESDIR_GOVDOCS+"000577.pdf");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldFail_2() {
		File testFile = new File(RESDIR_GOVDOCS+"000577.pdf");
		File otherFile = new File(RESDIR_GOVDOCS+"000369.pdf");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldFail_3() {
		File testFile = new File(RESDIR_GOVDOCS+"000606.pdf");
		File otherFile = new File(RESDIR_GOVDOCS+"000663.pdf");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldFail_4() {
		File testFile = new File(RESDIR_GOVDOCS+"000663.pdf");
		File otherFile = new File(RESDIR_GOVDOCS+"000606.pdf");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldFail_5() {
		File testFile = new File(RESDIR_LISBON+"lisbon_set_1_pdf14_ok.pdf");
		File otherFile = new File(RESDIR_LISBON+"lisbon_set_2_pdf14_bad_font_name.pdf");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldFail_6() {
		File testFile = new File(RESDIR_LISBON+"lisbon_set_2_pdf14_bad_font_name.pdf");
		File otherFile = new File(RESDIR_LISBON+"lisbon_set_1_pdf14_ok.pdf");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
	@Test
	public void testPDFShouldFail_7() {
		File testFile = new File(RESDIR_LISBON+"lisbon_set_7_pdfa1b.pdf");
		File otherFile = new File(RESDIR_LISBON+"lisbon_set_1_pdf14_ok.pdf");
		if(JhoveAPI.check(new File(otherFile.getAbsolutePath()+".xml"), JhoveAPI.process(testFile))) {
			fail("Output incorrectly matches wrong Jhove ground truth file for test file: "+testFile.getAbsolutePath());
		}
	}
	
}
