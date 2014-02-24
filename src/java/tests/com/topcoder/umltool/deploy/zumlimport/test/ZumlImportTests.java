package com.topcoder.umltool.deploy.zumlimport.test;


import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class ZumlImportTests extends TestCase {
	
	/**
     * Aggregates all test cases.
     * @return the aggregated test cases
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTestSuite(FunctionalTests_ClassDiagram.class);
        return suite;
    }
}
