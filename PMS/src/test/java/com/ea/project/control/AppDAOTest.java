package com.ea.project.control;

import com.ea.project.DAO.AppDAO;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * @author sureshadhikari
 *
 */
public class AppDAOTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppDAOTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppDAOTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {

		AppDAO.createProject();

	}
}
