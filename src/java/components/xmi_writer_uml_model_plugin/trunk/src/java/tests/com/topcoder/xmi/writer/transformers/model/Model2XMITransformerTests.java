/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.xmi.writer.transformers.model.Implement1;
import com.topcoder.uml.xmi.writer.transformers.model.Implement2;
import com.topcoder.uml.xmi.writer.transformers.model.InnerBean;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.model.ConfigurationException;
import com.topcoder.xmi.writer.transformers.model.DuplicateElementException;
import com.topcoder.xmi.writer.transformers.model.Model2XMITransformer;
import com.topcoder.xmi.writer.transformers.model.UnknownElementTypeException;
import com.topcoder.xmi.writer.transformers.model.XMIDescription;

import junit.framework.TestCase;
/**
 * <p>
 * Unit test cases for Model2XMITransformer.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Model2XMITransformerTests extends TestCase {
    /**
     * The namespace.
     */
    private static final String NAMESPACE = "com.topcoder.xmi.writer.transformers.model.Model2XMITransformer";
    /**
     * The Model2XMITransformer instance for testing.
     */
    private Model2XMITransformer transformer = null;
    /**
     * The XMIDescription instance.
     */
    private XMIDescription xmiDescription = null;
    /**
     * The XMIWriter instance for testing.
     */
    private XMIWriter writer = null;
    /**
     * The PrintStream instance for testing.
     */
    private PrintStream out = null;
    /**
     * The setUp of the unit test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.clearConfig();
        TestHelper.addConfig();
        Map <TransformerType, XMITransformer> map = new HashMap<TransformerType, XMITransformer>();

        transformer = new Model2XMITransformer(NAMESPACE);
        map.put(TransformerType.Model, transformer);
        map.put(TransformerType.ActivityGraph, transformer);
        map.put(TransformerType.Diagram, transformer);
        //create a XMIWriter instance
        writer = new XMIWriter(new UMLModelManager(), map);
        transformer.setXMIWriter(writer);
        xmiDescription = transformer.getXMIDescription();

        out = new PrintStream(new File("test_files/temp"));
    }
    /**
     * The tear down of the unit test, remove the configuration.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        out.close();
        File file = new File("test_files/temp");
        file.deleteOnExit();
    }
    /**
     * The accuracy test of the constructor with XMIDescription and ignoreUnknownElementType.
     *
     */
    public void test_constructor_accuracy1() {
        assertNotNull("can not create the Model2XMITransformer instance.",
                new Model2XMITransformer(xmiDescription, false));
    }
    /**
     * The accuracy test of the constructor with namespace.
     *
     */
    public void test_constructor_accuracy2() {
        assertNotNull("can not create the Model2XMITransformer instance.", transformer);
    }
    /**
     * The failure test of the constructor with XMIDescription and ignoreUnknownElementType,
     * fail for the XMIDescription is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_constructor_failure1() {
        try {
            new Model2XMITransformer(null, false);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor with namespace,
     * fail for the namespace is null,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure2() throws Exception {
        try {
            new Model2XMITransformer(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor with namespace,
     * fail for the namespace is an empty String,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure3() throws Exception {
        try {
            new Model2XMITransformer(" ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor with namespace,
     * fail for the namespace is unknown,
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure4() throws Exception {
        try {
            new Model2XMITransformer("unknown");
            fail("ConfigurationException should be thrown.");
        } catch (ConfigurationException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor with namespace,
     * fail for the require property 'ignoreUnknownElementType' is missing,
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure5() throws Exception {
        ConfigManager.getInstance().add("badconfig/no_ignoreUnknownElementType.xml");
        try {
            new Model2XMITransformer("Invalid1");
            fail("ConfigurationException should be thrown.");
        } catch (ConfigurationException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor with namespace,
     * fail for the require property 'objectFactory' is missing,
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure6() throws Exception {
        ConfigManager.getInstance().add("badconfig/no_objectFactory.xml");
        try {
            new Model2XMITransformer("Invalid2");
            fail("ConfigurationException should be thrown.");
        } catch (ConfigurationException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor with namespace,
     * fail for the require property 'xmiDescription' is missing,
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure7() throws Exception {
        ConfigManager.getInstance().add("badconfig/no_xmiDescription.xml");
        try {
            new Model2XMITransformer("Invalid3");
            fail("ConfigurationException should be thrown.");
        } catch (ConfigurationException e) {
            //ok
        }
    }
    /**
     * The accuracy test of the method <code>isIgnoreUnknownElementType</code>.
     *
     */
    public void test_isIgnoreUnknownElementType_accuracy() {
        assertTrue("The isIgnoreUnknownElementType is not set or get properly.",
                transformer.isIgnoreUnknownElementType());
    }
    /**
     * The accuracy test of the method <code>setIgnoreUnknownElementType</code>.
     *
     */
    public void test_setIgnoreUnknownElementType_accuracy() {
        transformer.setIgnoreUnknownElementType(false);
        assertFalse("The isIgnoreUnknownElementType is not set or get properly.",
                transformer.isIgnoreUnknownElementType());
    }
    /**
     * The accuracy test of the method <code>getXMIDescription</code>.
     *
     */
    public void test_getXMIDescription_accuracy() {
        assertNotNull("The getXMIDescription is not set or get properly.",
                transformer.getXMIDescription());
    }
    /**
     * The failure test of the method <code>transform</code>,
     * fail for the element is null,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_transform_failure1() throws Exception {
        try {
            transformer.transform(null, out);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The failure test of the method <code>transform</code>,
     * fail for the PrintStream is null,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_transform_failure2() throws Exception {
        try {
            transformer.transform(new Object(), null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The failure test of the method <code>transform</code>,
     * fail for no XMIElementDescription can be retrieved for the element,
     * UnknownElementTypeException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_transform_failure3() throws Exception {
        transformer.setIgnoreUnknownElementType(false);
        try {
            transformer.transform(new Object(), out);
            fail("UnknownElementTypeException should be thrown.");
        } catch (UnknownElementTypeException e) {
            //ok
        }
    }
    /**
     * The failure test of the method <code>transform</code>,
     * fail for no Element contains duplicate child element,
     * DuplicateElementException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_transform_failure4() throws Exception {
        transformer.setIgnoreUnknownElementType(false);
        try {
            transformer.transform(new Implement2(new InnerBean()), out);
            fail("DuplicateElementException should be thrown.");
        } catch (DuplicateElementException e) {
            //ok
        }
    }
    /**
     * The accuracy test of the constructor,
     * the element is transformed to a XMI successfully.
     *
     * @throws Exception to JUnit
     */
    public void test_transform_accuracy1() throws Exception {
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(stream);
        transformer.transform(new Implement1(), printStream);

        String result = stream.toString();
        assertTrue(result.indexOf("UML:Interface1") >= 0);
        assertTrue(result.indexOf("UML:Interface1.child") >= 0);
        assertTrue(result.indexOf("UML:Interface1.namespace") >= 0);
        assertTrue(result.indexOf("UML:Interface1.innerBean") >= 0);
        assertTrue(result.indexOf("xmi.idref") >= 0);
        assertTrue(result.indexOf("UML:Interface1.reference") >= 0);
        assertTrue(result.indexOf("UML:InnerBeanInterface") >= 0);
    }
}
