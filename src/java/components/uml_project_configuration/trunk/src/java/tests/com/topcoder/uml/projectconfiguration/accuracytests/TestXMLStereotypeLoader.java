/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.projectconfiguration.accuracytests;

import java.util.List;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.projectconfiguration.stereotypeloader.XMLStereotypeLoader;

import junit.framework.TestCase;

/**
 * Contains accuracy tests for the XMLStereotypeLoader class.
 *
 * @author TheCois
 */
public class TestXMLStereotypeLoader extends TestCase {
    /**
     * The namespace used to create the XMLStereotypeLoader.
     */
    private static final String testNamespace =
        "com.topcoder.uml.projectconfiguration.ProjectConfigurationManager";

    /**
     * A XMLStereotypeLoader instance used for tests.
     */
    private XMLStereotypeLoader testObject;

    /**
     * <p>
     * Set up testing enviroment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.loadConfigFile("accuracy/config.xml");
        testObject = new XMLStereotypeLoader(testNamespace);
    }

    /**
     * <p>
     * Tear down testing enviroment.
     * </p>
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.clearConfig();
        testObject = null;
    }

    /**
     * Makes sure the constructor produces a proper object.
     * @throws Exception
     */
    public void testCtor_1() throws Exception {
        assertNotNull("Constructor failed.", testObject);
    }

    /**
     * Makes sure getStereotypes(String language, String elementType)
     * returns the correct value.
     * In the Java case
     * @throws Exception
     */
    public void testGetStereotypes_Java() throws Exception {
        String[][] names = new String[][] {{"exception", "abstract"}
                                        , {"final", "abstract"}};
        String[] types = new String[] {"Class", "Operation"};

        for(int i = 0; i < types.length; ++i)
        {
            List<Stereotype> result = testObject.getStereotypes("Java", types[i]);
            assertEquals("There should be two Stereotypes", result.size(), names[i].length);
            for(int j = 0; j < names.length; ++j)
            {
                Stereotype type = result.get(j);
                assertEquals("check name of the result", type.getName(), names[i][j]);
                assertEquals("check the class of the result", type.getBaseClass(), types[i]);
            }
        }
    }

    /**
     * Makes sure getStereotypes(String, String)
     * returns the correct value.
     *
     * In the CSharp case
     * @throws Exception
     */
    public void testGetStereotypes_Csharp() throws Exception {
        String[] names = new String[] {"exception", "abstract"};
        String[] types = new String[] {"Class"};

        for(int i = 0; i < types.length; ++i)
        {
            List<Stereotype> result = testObject.getStereotypes("CSharp", types[i]);
            assertEquals("There should be two Stereotypes", result.size(), names.length);
            for(int j = 0; j < names.length; ++j)
            {
                Stereotype type = result.get(j);
                assertEquals("check name of the result", type.getName(), names[j]);
                assertEquals("check the class of the result", type.getBaseClass(), types[i]);
            }
        }
    }
}
