/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.codegen.test;

import java.io.File;

import javax.swing.SwingUtilities;

import junit.extensions.TestSetup;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all test cases for the <i>TopCoder UML Tool Code Generation</i> tests.
 * </p>
 *
 * @author tweg
 * @version 1.0
 */
public class AllTests extends TestCase {
    /**
     * Returns all test cases for the <i>TopCoder UML Tool Code Generation</i> tests.
     *
     * @return all test cases for the <i>TopCoder UML Tool Code Generation</i> tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTest(FunctionalTests.suite());
        // functional tests
        suite.addTest(GUITests.suite());

        TestSetup wrapper = new TestSetup(suite) {
            protected void setUp() {
                Runnable r = new Runnable() {
                    public void run() {
                        com.topcoder.umltool.deploy.UMLToolDeploy.main(new String[0]);
                    }
                };

                try {
                    SwingUtilities.invokeAndWait(r);
                } catch (Exception e) {
                }
            }

            protected void tearDown() throws Exception {
                File generateCode = new File(TestHelper.getCodeGenBase() + "/c");
                if (generateCode.exists()) {
                    //deleteFolder(generateCode);
                }
                generateCode = new File(TestHelper.getCodeGenBase() + "/java");
                if (generateCode.exists()) {
                    //deleteFolder(generateCode);
                }
            }

            private void deleteFolder(File dir) {
                File filelist[] = dir.listFiles();
                int listlen = filelist.length;
                for (int i = 0; i < listlen; i++) {
                    if (filelist[i].isDirectory()) {
                        deleteFolder(filelist[i]);
                    } else {
                        filelist[i].delete();
                    }
                }
                dir.delete();
            }
        };

        return wrapper;
    }
}
