/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.stresstests;

import java.util.List;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;

import junit.framework.TestCase;

/**
 * Stress test for <code>XMLStereotypeLoader</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class XMLStereotypeLoaderStressTests extends TestCase {

    /**
     * The <code>XMLStereotypeLoader</code> instance used to test against.
     */
    private XMLStereotypeLoader loader = null;

    /**
     * Set up the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.setUpConfigManager();
        loader = new XMLStereotypeLoader(XMLStereotypeLoader.class.getName());
    }

    /**
     * Tear down the test environment.
     *
     * @throws Exception
     *             throws to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.tearDownConfigManager();
    }

    /**
     * Stress test for the method <code>XMLStereotypeLoader#getStereotypes(String, String)</code>.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testGetStereotypes() throws Exception {
        TestHelper.startTimer();
        for (int i = 0; i < TestHelper.NUMBER; i++) {
            List<Stereotype> stereotypes = loader.getStereotypes("Java", "Class");
            if (i == 0) {
                assertTrue("Stereotype number is not correct.", stereotypes.size() == 10);
                for (int j = 1; j <= 10; j++) {
                    assertTrue("Stereotype name is not correct.",
                        stereotypes.get(j - 1).getName().equals(String.valueOf(j)));
                }
            }
        }
        TestHelper.printResultMulTimes("XMLStereotypeLoader#getStereotypes(String, String)");
    }
}
