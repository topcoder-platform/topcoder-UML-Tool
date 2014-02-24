/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.accuracytests;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.writer.transformers.model.AttributeDescription;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;
import com.topcoder.xmi.writer.transformers.model.xmidescription.ReflectedXMIDescription;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>ReflectedXMIDescription</c>.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class ReflectedXMIDescriptionAccuracyTests extends TestCase {

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String EMPTY_CONFIG = "accuracy/EmptyDescription.xml";

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String SINGLE_CONFIG = "accuracy/SingleDescription.xml";

    /**
     * <p>
     * The path of config file used for test.
     * </p>
     */
    private static final String MUTI_CONFIG = "accuracy/MutiDescription.xml";

    /** Represents the namespace. */
    private static final String NAMESPACE = "com.topcoder.xmi.writer.transformers.model.ReflectedXMIDescription";

    /** Represents the configuration file. */
    private static final String CONFIG_FILE = "accuracy/full_element_description_config.xml";

    /**
     * Represent the instance of <c>ReflectedXMIDescription</c> used for test
     */
    private ReflectedXMIDescription description;

    /**
     * <p>
     * Set up test environment.
     * </p>
     * 
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        TestsHelper.removeAllCMNamespaces();
    }

    /**
     * <p>
     * Tear down test environment.
     * </p>
     * 
     * @throws Exception
     *         if any error occurs when tear down
     */
    protected void tearDown() throws Exception {
        TestsHelper.removeAllCMNamespaces();
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ReflectedXMIDescription(String)</code> with single description, The
     * instance of <code>ReflectedXMIDescription</code> should be created successfully.
     * </p>
     * 
     * @throws Exception
     *         throw the Exception to JUnit
     */
    public void testConstructorAccuracy() throws Exception {
        ConfigManager.getInstance().add(SINGLE_CONFIG);
        description = new ReflectedXMIDescription(NAMESPACE);
        assertNotNull("instance of ReflectedXMIDescription should be created", description);
        Map<String, Set<String>> excludedMethods = (Map<String, Set<String>>) TestsHelper.getPrivateField(
                        ReflectedXMIDescription.class, description, "excludedMethods");
        assertNotNull("excludedMethods should be returned", excludedMethods);
        assertEquals(1, excludedMethods.size());
        assertEquals(5, excludedMethods.get("ModelElement").size());

        Map<String, Set<String>> containedNodes = (Map<String, Set<String>>) TestsHelper.getPrivateField(
                        ReflectedXMIDescription.class, description, "containedNodes");
        assertNotNull("containedNodes should be returned", containedNodes);

        assertEquals(1, containedNodes.size());

        assertEquals(2, containedNodes.get("ModelElement").size());
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ReflectedXMIDescription(String)</code> with multiplex description, The
     * instance of <code>ReflectedXMIDescription</code> should be created successfully.
     * </p>
     * 
     * @throws Exception
     *         throw the Exception to JUnit
     */
    public void testConstructorAccuracy2() throws Exception {
        ConfigManager.getInstance().add(MUTI_CONFIG);
        description = new ReflectedXMIDescription(NAMESPACE);
        assertNotNull("instance of ReflectedXMIDescription should be created", description);
        Map<String, Set<String>> excludedMethods = (Map<String, Set<String>>) TestsHelper.getPrivateField(
                        ReflectedXMIDescription.class, description, "excludedMethods");
        assertNotNull("excludedMethods should be returned", excludedMethods);

        assertEquals(5, excludedMethods.get("ModelElement").size());

        Map<String, Set<String>> containedNodes = (Map<String, Set<String>>) TestsHelper.getPrivateField(
                        ReflectedXMIDescription.class, description, "containedNodes");
        assertNotNull("containedNodes should be returned", containedNodes);

        assertEquals(2, containedNodes.size());

        assertEquals(2, containedNodes.get("ModelElement").size());
        assertEquals(1, containedNodes.get("Package").size());
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ReflectedXMIDescription(String)</code> with Empty description, The
     * instance of <code>ReflectedXMIDescription</code> should be created successfully.
     * </p>
     * 
     * @throws Exception
     *         throw the Exception to JUnit
     */
    public void testConstructorAccuracy3() throws Exception {
        ConfigManager.getInstance().add(EMPTY_CONFIG);
        description = new ReflectedXMIDescription(NAMESPACE);
        assertNotNull("instance of ReflectedXMIDescription should be created", description);
        Map<String, Set<String>> excludedMethods = (Map<String, Set<String>>) TestsHelper.getPrivateField(
                        ReflectedXMIDescription.class, description, "excludedMethods");
        assertNotNull("excludedMethods should be returned", excludedMethods);
        assertEquals(0, excludedMethods.size());

        Map<String, Set<String>> containedNodes = (Map<String, Set<String>>) TestsHelper.getPrivateField(
                        ReflectedXMIDescription.class, description, "containedNodes");
        assertNotNull("containedNodes should be returned", containedNodes);

        assertEquals(0, containedNodes.size());
    }

    /**
     * Accuracy test of method <code>getXMIElementDescription(Class)</code>. With <tt>ModelElement</tt> type. Should
     * return the proper <tt>XMIElementDescription</tt>.
     * 
     * @throws Exception
     *         to JUnit
     */
    public void testGetXMIElementDescriptionAccuracyModelElementType() throws Exception {
        ConfigManager.getInstance().add(CONFIG_FILE);
        description = new ReflectedXMIDescription(NAMESPACE);

        XMIElementDescription elementDesc = description.getXMIElementDescription(ModelElement.class);

        // verify the result
        assertNotNull(elementDesc);

        // verify attributes
        Set<String> attrNames = new HashSet<String>();
        for (AttributeDescription attrDesc : elementDesc.getAttributes()) {
            attrNames.add(attrDesc.getName());
        }
        assertEquals(2, attrNames.size());
        assertTrue(attrNames.contains("visibility")); // Enum
        assertTrue(attrNames.contains("isSpecification")); // Boolean

        // verify child nodes
        Set<String> childNames = new HashSet<String>();
        for (ChildDescription childDesc : elementDesc.getChildren()) {
            childNames.add(childDesc.getName());
        }
        assertEquals(7, childNames.size());
        assertTrue(childNames.contains("UML:ModelElement.name"));
        assertTrue(childNames.contains("UML:ModelElement.stereotype"));
        assertTrue(childNames.contains("UML:ModelElement.taggedValue"));
        assertTrue(childNames.contains("UML:ModelElement.namespace"));
        assertTrue(childNames.contains("UML:ModelElement.clientDependency"));
        assertTrue(childNames.contains("UML:ModelElement.comment"));
        assertTrue(childNames.contains("UML:ModelElement.templateParameter"));
    }
    
    /**
     * Test the getXMIElementDescription with class whose package name not start with <code>KNOWN_PACKAGE</code> Expect
     * to return <code>null</code>.
     * 
     * @throws Exception
     *         to JUnit
     */
    public void testGetXMIElementDescriptionAccuracy2() throws Exception {
        ConfigManager.getInstance().add(CONFIG_FILE);
        description = new ReflectedXMIDescription(NAMESPACE);
        XMIElementDescription xmiDes = description.getXMIElementDescription(Object.class);
        // if the class is not in the package which start with
        // "com.topcoder.uml"
        // return null.
        assertNull(xmiDes);

    }

}
