/*
 * Copyright 2013 The British Library/SCAPE Project Consortium
 * Author: William Palmer (William.Palmer@bl.uk)
 *
 * License TBD
 */
package jhove1x;

import java.io.BufferedReader;
import java.io.CharArrayWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import edu.harvard.hul.ois.jhove.App;
import edu.harvard.hul.ois.jhove.JhoveBase;
import edu.harvard.hul.ois.jhove.JhoveException;
import edu.harvard.hul.ois.jhove.handler.XmlHandler;

/**
 * This class wraps and hides Jhove - a call to isValid() will return true or false if
 * Jhove thinks the file is valid or not
 * @author wpalmer
 *
 */
public class JhoveAPI {

	private static JhoveBase jhove = null;
	private static App app = null;
	private static XmlHandler handler = null;
	
	private JhoveAPI() {
		// TODO Auto-generated constructor stub
	}
	
	private static void initJhove() {
		//http://www.garymcgath.com/jhovenote.html
		//and https://github.com/openplanets/planets-suite/blob/59d1517b5493815a0f59927d6c97ca5462d1ed8d/services/jhove/src/main/java/eu/planets_project/ifr/core/services/identification/jhove/impl/JhoveIdentification.java
		try {
			jhove = new JhoveBase();
		} catch (JhoveException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		//note that the app name must be "Jhove" to match the released binaries
		app = new App("Jhove", JhoveBase._release, JhoveBase.DATE, "", "");
		handler = new XmlHandler();
		try {
			//init and set the conf file location
			jhove.init("conf/jhove.conf", JhoveBase.getSaxClassFromProperties());
		} catch (JhoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jhove.setEncoding("utf-8");
		jhove.setTempDirectory(System.getProperty("java.io.tmpdir"));
		jhove.setBufferSize(4096);
		//we may as well add the checksums to the output
		jhove.setChecksumFlag(true);
		jhove.setShowRawFlag(false);
		jhove.setSignatureFlag(false);
	}

	/**
	 * Calls Jhove and returns XML output
	 * @param pFile file to check
	 * @return char array containing XML output
	 */
	public static char[] process(File pFile) {
		if(null==jhove) initJhove();

		try {
			File temp = File.createTempFile("jhove-output-", ".xml");
			temp.deleteOnExit();
			String[] inputs = new String[] { pFile.getAbsolutePath() };
			jhove.dispatch(app, null, null, handler, temp.getAbsolutePath(), inputs);
			
			//now copy xml in to a buffer
			return loadXML(temp);

		} catch (JhoveException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * Load a Jhove XML output into memory.  This will ignore temporal info (by means of a bit of a hack)
	 * @param pFile xml results file to load
	 * @return char array containing text
	 */
	private static char[] loadXML(File pFile) {
		//copy xml in to a buffer
		BufferedReader bufReader = null;
		try {
			bufReader = new BufferedReader(new FileReader(pFile));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		CharArrayWriter charWriter = new CharArrayWriter((int)pFile.length());

		try {
			String line = "";
			while(bufReader.ready()) {
				line = bufReader.readLine().trim();
				//System.out.println(line);
				//MASSIVE HACK: ignore the date the test was run,
				// the last modified time
				// *and* where the file is stored
				if(!(line.startsWith("<date>")&line.endsWith("</date>"))) {
					if(!(line.startsWith("<repInfo")&line.endsWith(">"))) {
						if(!(line.startsWith("<lastModified>")&line.endsWith("</lastModified>"))) {
							//may also need to remove <lastModified> depending on git
							charWriter.append(line);	
						}
					}
				} 
			}
			bufReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		charWriter.close();
		return charWriter.toCharArray();
	}
	
	/**
	 * Check if two Jhove outputs match
	 * @param pGroundTruth ground truth file
	 * @param pCurrentCheck output from Jhove
	 * @return true if outputs match
	 */
	public static boolean check(File pGroundTruth, char[] pCurrentCheck) {

		String current = new String(pCurrentCheck);
		String groundTruth = new String(loadXML(pGroundTruth));
		
		return current.equals(groundTruth);
	}

}
