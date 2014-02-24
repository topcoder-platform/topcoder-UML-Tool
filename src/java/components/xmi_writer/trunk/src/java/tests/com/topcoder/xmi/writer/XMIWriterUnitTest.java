/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.transformers.xmiheader.XMIHeaderTransformer;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for <code>{@link XMIWriter}</code> class.
 * </p>
 *
 * @author FireIce
 * @version 1.0
 */
public class XMIWriterUnitTest extends TestCase {

    /**
     * <p>
     * Represents the output file name.
     * </p>
     */
    private File output = new File("test_files/out.xmi");

    /**
     * <p>
     * Represents the directory name already exist.
     * </p>
     */
    private File dir = new File("test_files/dir");

    /**
     * <p>
     * Represents the directory name already exist.
     * </p>
     */
    private File zipfile = new File("test_files/out.zip");

    /**
     * <p>
     * Represents the <code>{@link XMIWriter}</code> instance used in tests.
     * </p>
     */
    private XMIWriter xmiWriter;

    /**
     * <p>
     * Represents the <code>{@link UMLModelManager}</code> instance used in tests.
     * </p>
     */
    private UMLModelManager manager;

    /**
     * <p>
     * Represents the map of transformers.
     * </p>
     */
    private Map<TransformerType, XMITransformer> transformers;

    /**
     * <p>
     * Set up the testing environment.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    protected void setUp() throws Exception {
        super.setUp();
        manager = UMLModelManager.getInstance();
        transformers = TestHelper.createMandatoryTransformers();
        xmiWriter = new XMIWriter(manager, transformers);

        // create the directory for testing
        dir.mkdir();
    }

    /**
     * <p>
     * tear down the testing environment.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        // delete the temperate files and directory.
        dir.delete();
        output.delete();
        zipfile.delete();
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the manager is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_NullManager() {
        try {
            new XMIWriter(null, transformers);
            fail("If the manager is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_NullTransformers() {
        try {
            new XMIWriter(manager, null);
            fail("If the transformers is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers doesn't contain key for Model type, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_MissingModelType() {
        transformers.remove(TransformerType.Model);

        try {
            new XMIWriter(manager, transformers);
            fail("If the transformers doesn't contain key for Model type, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers doesn't contain key for ActivityGraph type, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_MissingActivityGraphType() {
        transformers.remove(TransformerType.ActivityGraph);

        try {
            new XMIWriter(manager, transformers);
            fail("If transformers doesn't contain key for ActivityGraph type, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers doesn't contain key for Diagram type, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_MissingDiagramType() {
        transformers.remove(TransformerType.Diagram);

        try {
            new XMIWriter(manager, transformers);
            fail("If the transformers doesn't contain key for Diagram type, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_ContainsNullValue1() {
        transformers.put(TransformerType.Model, null);

        try {
            new XMIWriter(manager, transformers);
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_ContainsNullValue2() {
        transformers.put(TransformerType.Diagram, null);

        try {
            new XMIWriter(manager, transformers);
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_ContainsNullValue3() {
        transformers.put(TransformerType.ActivityGraph, null);

        try {
            new XMIWriter(manager, transformers);
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_ContainsNullValue4() {
        transformers.put(TransformerType.Header, null);

        try {
            new XMIWriter(manager, transformers);
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_ContainsNullValue5() {
        transformers.put(null, null);

        try {
            new XMIWriter(manager, transformers);
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map)}</code> constructor.
     * </p>
     * <p>
     * If the manager and transformers parameters are valid, should create the instance.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testCtor_1_Accuracy() throws Exception {
        // verify data.
        assertSame("manager field is not set correctly.", manager, TestHelper.getFieldValue(xmiWriter, "manager"));

        // verify transformers is correctly put.
        Map internalTransformers = (Map) TestHelper.getFieldValue(xmiWriter, "transformers");
        assertEquals("the size is incorrect.", transformers.size(), internalTransformers.size());
        for (Entry<TransformerType, XMITransformer> entry : transformers.entrySet()) {
            assertTrue("type should exist.", internalTransformers.containsKey(entry.getKey()));
            assertEquals("value field is correct.", entry.getValue(), internalTransformers.get(entry.getKey()));
        }

        // verify xmi root attributes is correctly put.
        Map xmiRootAttributes = (Map) TestHelper.getFieldValue(xmiWriter, "xmiRootAttributes");
        assertTrue("the size should be 3.", 3 == xmiRootAttributes.size());
        assertTrue("the attribute does not exist.", xmiRootAttributes.containsKey("xmlns:UML"));
        assertEquals("the corresponding value is incorrect.", "org.omg.xmi.namespace.UML", xmiRootAttributes
                .get("xmlns:UML"));
        assertTrue("the attribute does not exist.", xmiRootAttributes.containsKey("xmlns:UML2"));
        assertEquals("the corresponding value is incorrect.", "org.omg.xmi.namespace.UML2", xmiRootAttributes
                .get("xmlns:UML2"));
        assertTrue("the attribute does not exist.", xmiRootAttributes.containsKey("xmi.version"));
        assertEquals("the corresponding value is incorrect.", "1.5", xmiRootAttributes.get("xmi.version"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the manager is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_NullManager() {
        try {
            new XMIWriter(null, transformers, new HashMap<String, String>());
            fail("If the manager is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_NullTransformers() {
        try {
            new XMIWriter(manager, null, new HashMap<String, String>());
            fail("If the transformers is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers doesn't contain key for Model type, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_MissingModelType() {
        transformers.remove(TransformerType.Model);
        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If the transformers doesn't contain key for Model type, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers doesn't contain key for ActivityGraph type, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_MissingActivityGraphType() {
        transformers.remove(TransformerType.ActivityGraph);

        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If transformers doesn't contain key for ActivityGraph type, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers doesn't contain key for Diagram type, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_MissingDiagramType() {
        transformers.remove(TransformerType.Diagram);

        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If the transformers doesn't contain key for Diagram type, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_ContainsNullValue1() {
        transformers.put(TransformerType.Model, null);

        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_ContainsNullValue2() {
        transformers.put(TransformerType.Diagram, null);

        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_ContainsNullValue3() {
        transformers.put(TransformerType.ActivityGraph, null);

        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_ContainsNullValue4() {
        transformers.put(TransformerType.Header, null);

        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the transformers contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_ContainsNullValue5() {
        transformers.put(null, null);

        try {
            new XMIWriter(manager, transformers, new HashMap<String, String>());
            fail("If the transformers contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the xmiRootAttributes is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_NullXmiRootAttributes() {
        try {
            new XMIWriter(manager, transformers, null);
            fail("If the xmiRootAttributes is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the xmiRootAttributes contains null key, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_XmiRootAttributesContainsNullKey() {
        Map<String, String> map = new HashMap<String, String>();
        map.put(null, "test");

        try {
            new XMIWriter(manager, transformers, map);
            fail("If the xmiRootAttributes contains null key, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the xmiRootAttributes contains empty key, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_XmiRootAttributesContainsEmptyKey() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("", "test");

        try {
            new XMIWriter(manager, transformers, map);
            fail("If the xmiRootAttributes contains empty key, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the xmiRootAttributes contains trimmed empty key, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_XmiRootAttributesContainsTrimmedEmptyKey() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("  ", "test");

        try {
            new XMIWriter(manager, transformers, map);
            fail("If the xmiRootAttributes contains trimmed empty key, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the xmiRootAttributes contains null value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_XmiRootAttributesContainsNullValue() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", null);

        try {
            new XMIWriter(manager, transformers, map);
            fail("If the xmiRootAttributes contains null value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the xmiRootAttributes contains empty value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_XmiRootAttributesContainsEmptyValue() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", "");

        try {
            new XMIWriter(manager, transformers, map);
            fail("If the xmiRootAttributes contains empty value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the xmiRootAttributes contains trimmed empty value, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_2_XmiRootAttributesContainsTrimmedEmptyValue() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("test", "  ");

        try {
            new XMIWriter(manager, transformers, map);
            fail("If the xmiRootAttributes contains trimmed empty value, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#XMIWriter(UMLModelManager, Map, Map)}</code> constructor.
     * </p>
     * <p>
     * If the manager and transformers parameters are valid, should create the instance.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testCtor_2_Accuracy() throws Exception {
        // a map of xmi root attributes.
        Map<String, String> attributes = new HashMap<String, String>();
        attributes.put("xmlns:UML", "org.omg.xmi.namespace.UML");
        attributes.put("xmlns:UML2", "org.omg.xmi.namespace.UML2");
        attributes.put("xmi.version", "1.5");

        // invoke the constructor.
        xmiWriter = new XMIWriter(manager, transformers, attributes);

        // verify data.
        assertSame("manager field is not set correctly.", manager, TestHelper.getFieldValue(xmiWriter, "manager"));

        // verify the transformers is correctly put
        Map internalTransformers = (Map) TestHelper.getFieldValue(xmiWriter, "transformers");
        assertEquals("the size is incorrect.", transformers.size(), internalTransformers.size());
        for (Entry<TransformerType, XMITransformer> entry : transformers.entrySet()) {
            assertTrue("type should exist.", internalTransformers.containsKey(entry.getKey()));
            assertEquals("value field is correct.", entry.getValue(), internalTransformers.get(entry.getKey()));
        }

        // verify the xmi root attributes is correctly put.
        Map xmiRootAttributes = (Map) TestHelper.getFieldValue(xmiWriter, "xmiRootAttributes");
        assertTrue("xmiRootAttributes field is not set correctly.", attributes.size() == xmiRootAttributes.size());
        for (Entry<String, String> entry : attributes.entrySet()) {
            assertTrue("the attribute does not exist.", xmiRootAttributes.containsKey(entry.getKey()));
            assertEquals("the corresponding value is incorrect.", entry.getValue(), xmiRootAttributes.get(entry
                    .getKey()));
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getElementId(Object)}</code> method.
     * </p>
     * <p>
     * If the element parameter is null, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testGetElementId_NullElement() throws Exception {
        try {
            xmiWriter.getElementId(null);
            fail("If the element parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getElementId(Object)}</code> method.
     * </p>
     * <p>
     * if there is no xmiId for the given element, should throw UnknownElementException.
     * </p>
     */
    public void testGetElementId_UnknownElement() {
        try {
            xmiWriter.getElementId(new Object());
            fail("if there is no xmiId for the given element, should throw UnknownElementException.");
        } catch (UnknownElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getElementId(Object)}</code> method.
     * </p>
     * <p>
     * if there exist a xmi id for the given element, should return the xmi id.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testGetElementId_Accuracy() throws Exception {
        Object element = new Object();
        String xmiId = "TopCoder";
        xmiWriter.putElementId(element, xmiId);
        assertEquals("incorrect xmi id returned.", xmiId, xmiWriter.getElementId(element));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putElementId(Object, String)}</code> method.
     * </p>
     * <p>
     * If the element parameter is null, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testPutElementId_NullElement() throws Exception {
        try {
            xmiWriter.putElementId(null, "TopCoder");
            fail("If the element parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putElementId(Object, String)}</code> method.
     * </p>
     * <p>
     * If the xmiId parameter is null, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testPutElementId_NullID() throws Exception {
        try {
            xmiWriter.putElementId(new Object(), null);
            fail("If the xmiId parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putElementId(Object, String)}</code> method.
     * </p>
     * <p>
     * If the xmiId parameter is empty, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testPutElementId_EmptyID() throws Exception {
        try {
            xmiWriter.putElementId(new Object(), "");
            fail("If the xmiId parameter is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putElementId(Object, String)}</code> method.
     * </p>
     * <p>
     * If the xmiId parameter is trimmed empty, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testPutElementId_TrimmedEmptyID() throws Exception {
        try {
            xmiWriter.putElementId(new Object(), "  ");
            fail("If the xmiId parameter is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putElementId(Object, String)}</code> method.
     * </p>
     * <p>
     * If the element already exist, should throw ElementAlreadyExistsException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testPutElementId_ElementAlreadyExist() throws Exception {
        Object element = new Object();
        xmiWriter.putElementId(element, "Test");
        try {
            xmiWriter.putElementId(element, "Test");
            fail("If the element already exist, should throw ElementAlreadyExistsException.");
        } catch (ElementAlreadyExistsException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putElementId(Object, String)}</code> method.
     * </p>
     * <p>
     * If the element does not exist and the xmi id is valid, put the key-value pair to the internal map.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testPutElementId_Accuracy() throws Exception {
        Object element = new Object();
        xmiWriter.putElementId(element, "Test");

        Map elementIds = (Map) TestHelper.getFieldValue(xmiWriter, "elementIds");
        assertTrue("the pair is not added.", elementIds.containsKey(element));
        assertEquals("the pair is not added.", "Test", elementIds.get(element));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putXMIRootAttribute(String, String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testPutXMIRootAttribute_NullKey() {
        try {
            xmiWriter.putXMIRootAttribute(null, "value");
            fail("If the attrKey is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putXMIRootAttribute(String, String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testPutXMIRootAttribute_EmptyKey() {
        try {
            xmiWriter.putXMIRootAttribute("", "value");
            fail("If the attrKey is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putXMIRootAttribute(String, String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testPutXMIRootAttribute_TrimmedEmptyKey() {
        try {
            xmiWriter.putXMIRootAttribute("  ", "value");
            fail("If the attrKey is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putXMIRootAttribute(String, String)}</code> method.
     * </p>
     * <p>
     * If the attrValue is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testPutXMIRootAttribute_NullValue() {
        try {
            xmiWriter.putXMIRootAttribute("key", null);
            fail("If the attrValue is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putXMIRootAttribute(String, String)}</code> method.
     * </p>
     * <p>
     * If the attrValue is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testPutXMIRootAttribute_EmptyValue() {
        try {
            xmiWriter.putXMIRootAttribute("key", "");
            fail("If the attrValue is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putXMIRootAttribute(String, String)}</code> method.
     * </p>
     * <p>
     * If the attrValue is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testPutXMIRootAttribute_TrimmedEmptyValue() {
        try {
            xmiWriter.putXMIRootAttribute("key", "  ");
            fail("If the attrValue is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#putXMIRootAttribute(String, String)}</code> method.
     * </p>
     * <p>
     * if the attrKey and attrValue is valid, should successfully add the key-value pair to the internal map.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testPutXMIRootAttribute_Accuracy() throws Exception {
        xmiWriter.putXMIRootAttribute("key", "value");

        Map xmiRootAttributes = (Map) TestHelper.getFieldValue(xmiWriter, "xmiRootAttributes");
        assertEquals("key-value pair not found.", "value", xmiRootAttributes.get("key"));

        xmiWriter.putXMIRootAttribute("key", "value1");

        assertEquals("key-value pair not found.", "value1", xmiRootAttributes.get("key"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testGetXMIRootAttribute_NullKey() {
        try {
            xmiWriter.getXMIRootAttribute(null);
            fail("If the attrKey is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testGetXMIRootAttribute_EmptyKey() {
        try {
            xmiWriter.getXMIRootAttribute("");
            fail("If the attrKey is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testGetXMIRootAttribute_TrimmedEmptyKey() {
        try {
            xmiWriter.getXMIRootAttribute("  ");
            fail("If the attrKey is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is valid, should return the corresponding value.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testGetXMIRootAttribute_Accuracy() throws Exception {
        assertNull("if not found, should return null.", xmiWriter.getXMIRootAttribute("key"));

        xmiWriter.putXMIRootAttribute("key", "value");
        assertEquals("incorrect value returned.", "value", xmiWriter.getXMIRootAttribute("key"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#removeXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testRemoveXMIRootAttribute_NullKey() {
        try {
            xmiWriter.removeXMIRootAttribute(null);
            fail("If the attrKey is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#removeXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testRemoveXMIRootAttribute_EmptyKey() {
        try {
            xmiWriter.removeXMIRootAttribute("");
            fail("If the attrKey is empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#removeXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is trimmed empty, should throw IllegalArgumentException.
     * </p>
     */
    public void testRemoveXMIRootAttribute_TrimmedEmptyKey() {
        try {
            xmiWriter.removeXMIRootAttribute("  ");
            fail("If the attrKey is trimmed empty, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#removeXMIRootAttribute(String)}</code> method.
     * </p>
     * <p>
     * If the attrKey is valid, should return the corresponding value.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testRemoveXMIRootAttribute_Accuracy() throws Exception {
        xmiWriter.putXMIRootAttribute("key", "value");
        assertEquals("incorrect value returned.", "value", xmiWriter.getXMIRootAttribute("key"));
        xmiWriter.removeXMIRootAttribute("key");
        assertNull("the attribute should be removed.", xmiWriter.getXMIRootAttribute("key"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#clearXMIRootAttributes()}</code> method.
     * </p>
     * <p>
     * all the xmi attributes should be removed.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testClearXMIRootAttributes_Accuracy() throws Exception {
        Map xmiRootAttributes = (Map) TestHelper.getFieldValue(xmiWriter, "xmiRootAttributes");
        assertFalse("the internal xmiRootAttributes map should not be empty.", xmiRootAttributes.isEmpty());

        xmiWriter.clearXMIRootAttributes();
        assertTrue("the internal xmiRootAttributes map should be empty.", xmiRootAttributes.isEmpty());
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getXMIRootAttributeKeys()}</code> method.
     * </p>
     * <p>
     * Should return all xmi root attribute keys as a string array.
     * </p>
     */
    public void testGetXMIRootAttributeKeys_Accuracy() {
        String[] keys = xmiWriter.getXMIRootAttributeKeys();

        assertTrue("there should have 3 keys.", 3 == keys.length);
        for (int i = 0; i < keys.length; i++) {
            assertTrue("incorrect keys.", "xmlns:UML".equals(keys[i]) || "xmlns:UML2".equals(keys[i])
                    || "xmi.version".equals(keys[i]));
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#getUMLModelManager()}</code> method.
     * </p>
     */
    public void testGetUMLModelManager_Accuracy() {
        assertSame("incorrect uml model manger instance.", manager, xmiWriter.getUMLModelManager());
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * If the output stream parameter is null, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_NullOutputStream() throws Exception {
        try {
            xmiWriter.transform((OutputStream) null, false);
            fail("If the output stream parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * If an I/O error occurs, should throw IOException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_IOException() throws Exception {
        OutputStream outputStream = new OutputStream() {
            public void write(int b) throws IOException {
                throw new IOException("test");
            }

        };
        try {
            xmiWriter.transform(outputStream, false);
            fail("If I/O error occurs, should throw IOException.");
        } catch (IOException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw ElementAlreadyExistsException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_ElementAlreadyExistsException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws ElementAlreadyExistsException {
                throw new ElementAlreadyExistsException("test", new Object());
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(new ByteArrayOutputStream(), false);
            fail("If any transformer instance throw ElementAlreadyExistsException, just re-throw it.");
        } catch (ElementAlreadyExistsException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw UnknownElementException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_UnknownElementException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws UnknownElementException {
                throw new UnknownElementException("test", new Object());
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(new ByteArrayOutputStream(), false);
            fail("If any transformer instance throw UnknownElementException, just re-throw it.");
        } catch (UnknownElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw XMITransformException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_XMITransformException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws XMITransformException {
                throw new XMITransformException("test");
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(new ByteArrayOutputStream(), true);
            fail("If any transformer instance throw XMITransformException, just re-throw it.");
        } catch (XMITransformException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_Accuracy1() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());

        try {
            xmiWriter.transform(byteArrayOutputStream, false);

            String result = byteArrayOutputStream.toString();

            assertTrue("model should exist.", result.contains("Model"));
            assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
            assertFalse("diagrams should not exist.", result.contains("Diagram"));
            assertFalse("header should not exist.", result.contains("XMI.header"));
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_Accuracy2() throws Exception {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());

        try {
            xmiWriter.transform(byteArrayOutputStream, true);

            String result = byteArrayOutputStream.toString();

            assertTrue("model should exist.", result.contains("Model"));
            assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
            assertTrue("diagrams should exist.", result.contains("Diagram"));
            assertFalse("header should not exist.", result.contains("XMI.header"));
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(OutputStream, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformOutputStream_Accuracy3() throws Exception {
        transformers.put(TransformerType.Header, new XMIHeaderTransformer("TCUML", "1.0", "1.2"));
        xmiWriter = new XMIWriter(manager, transformers);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());

        try {
            xmiWriter.transform(byteArrayOutputStream, true);

            String result = byteArrayOutputStream.toString();

            assertTrue("model should exist.", result.contains("Model"));
            assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
            assertTrue("diagrams should exist.", result.contains("Diagram"));
            assertTrue("header should exist.", result.contains("XMI.header"));
        } finally {
            byteArrayOutputStream.close();
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * If the file parameter is null, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_NullFile() throws Exception {
        try {
            xmiWriter.transform((File) null, false);
            fail("If the file parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * If I/O error occurs(the file is a directory), should throw IOException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_IOException() throws Exception {
        try {
            xmiWriter.transform(dir, false);
            fail("If I/O error occurs, should throw IOException.");
        } catch (IOException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw ElementAlreadyExistsException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_ElementAlreadyExistsException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws ElementAlreadyExistsException {
                throw new ElementAlreadyExistsException("test", new Object());
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(output, false);
            fail("If any transformer instance throw ElementAlreadyExistsException, just re-throw it.");
        } catch (ElementAlreadyExistsException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw UnknownElementException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_UnknownElementException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws UnknownElementException {
                throw new UnknownElementException("test", new Object());
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(output, false);
            fail("If any transformer instance throw UnknownElementException, just re-throw it.");
        } catch (UnknownElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw XMITransformException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_XMITransformException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws XMITransformException {
                throw new XMITransformException("test");
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(output, true);
            fail("If any transformer instance throw XMITransformException, just re-throw it.");
        } catch (XMITransformException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_Accuracy1() throws Exception {
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transform(output, false);

        // verify the content of the output file.
        String result = TestHelper.readFileAsString(output);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertFalse("diagrams should not exist.", result.contains("Diagram"));
        assertFalse("header should not exist.", result.contains("XMI.header"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_Accuracy2() throws Exception {
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transform(output, true);

        // verify the content of the output file.
        String result = TestHelper.readFileAsString(output);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertTrue("diagrams should exist.", result.contains("Diagram"));
        assertFalse("header should not exist.", result.contains("XMI.header"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_Accuracy3() throws Exception {
        transformers.put(TransformerType.Header, new XMIHeaderTransformer("TCUML", "1.0", "1.2"));
        xmiWriter = new XMIWriter(manager, transformers);
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transform(output, true);

        // verify the content of the output file.
        String result = TestHelper.readFileAsString(output);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertTrue("diagrams should exist.", result.contains("Diagram"));
        assertTrue("header should exist.", result.contains("XMI.header"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transform(File, boolean)}</code> method.
     * </p>
     * <p>
     * If the file already exist, should overwrite the file.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformFile_Accuracy4() throws Exception {
        transformers.put(TransformerType.Header, new XMIHeaderTransformer("TCUML", "1.0", "1.2"));
        xmiWriter = new XMIWriter(manager, transformers);
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transform(output, true);
        // overwrite the exist file.
        xmiWriter.transform(output, true);

        // verify the content of the output file.
        String result = TestHelper.readFileAsString(output);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertTrue("diagrams should exist.", result.contains("Diagram"));
        assertTrue("header should exist.", result.contains("XMI.header"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * If the file parameter is null, should throw IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_NullFile() throws Exception {
        try {
            xmiWriter.transformToZipFile(null, false);
            fail("If the file parameter is null, should throw IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * If I/O error occurs(the file is a directory), should throw IOException.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_IOException() throws Exception {
        try {
            xmiWriter.transform(dir, false);
            fail("If I/O error occurs, should throw IOException.");
        } catch (IOException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw ElementAlreadyExistsException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_ElementAlreadyExistsException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws ElementAlreadyExistsException {
                throw new ElementAlreadyExistsException("test", new Object());
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(output, false);
            fail("If any transformer instance throw ElementAlreadyExistsException, just re-throw it.");
        } catch (ElementAlreadyExistsException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw UnknownElementException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_UnknownElementException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws UnknownElementException {
                throw new UnknownElementException("test", new Object());
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(output, false);
            fail("If any transformer instance throw UnknownElementException, just re-throw it.");
        } catch (UnknownElementException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * If any transformer instance throw XMITransformException, just re-throw it.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_XMITransformException() throws Exception {
        transformers.put(TransformerType.Model, new AbstractXMITransformer() {
            public void transform(Object element, PrintStream out) throws XMITransformException {
                throw new XMITransformException("test");
            }
        });
        xmiWriter = new XMIWriter(manager, transformers);

        try {
            xmiWriter.transform(output, false);
            fail("If any transformer instance throw XMITransformException, just re-throw it.");
        } catch (XMITransformException e) {
            // expected
        }
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_Accuracy1() throws Exception {
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transformToZipFile(zipfile, false);

        // verify the content of the zip file.
        String result = TestHelper.readFromZipFileAsString(zipfile);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertFalse("diagrams should not exist.", result.contains("Diagram"));
        assertFalse("header should not exist.", result.contains("XMI.header"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_Accuracy2() throws Exception {
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transformToZipFile(zipfile, true);

        // verify the content of the zip file.
        String result = TestHelper.readFromZipFileAsString(zipfile);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertTrue("diagrams should exist.", result.contains("Diagram"));
        assertFalse("header should not exist.", result.contains("XMI.header"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * as all is legal, should output the transformed result.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_Accuracy3() throws Exception {
        transformers.put(TransformerType.Header, new XMIHeaderTransformer("TCUML", "1.0", "1.2"));
        xmiWriter = new XMIWriter(manager, transformers);
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transformToZipFile(zipfile, true);

        // verify the content of the zip file.
        String result = TestHelper.readFromZipFileAsString(zipfile);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertTrue("diagrams should exist.", result.contains("Diagram"));
        assertTrue("header should exist.", result.contains("XMI.header"));
    }

    /**
     * <p>
     * Unit test for <code>{@link XMIWriter#transformToZipFile(File, boolean)}</code> method.
     * </p>
     * <p>
     * If the file already exist, should overwrite the zip file.
     * </p>
     *
     * @throws Exception
     *             If any unexpected exception occurs.
     */
    public void testTransformToZipFile_Accuracy4() throws Exception {
        transformers.put(TransformerType.Header, new XMIHeaderTransformer("TCUML", "1.0", "1.2"));
        xmiWriter = new XMIWriter(manager, transformers);
        xmiWriter.getUMLModelManager().addDiagram(new Diagram());
        xmiWriter.getUMLModelManager().addActivityGraph(new ActivityGraphImpl());
        xmiWriter.transformToZipFile(zipfile, true);

        // overwrite the exist file.
        xmiWriter.transformToZipFile(zipfile, true);

        // verify the content of the zip file.
        String result = TestHelper.readFromZipFileAsString(zipfile);
        assertTrue("model should exist.", result.contains("Model"));
        assertTrue("activity graphs should exist.", result.contains("ActivityGraph"));
        assertTrue("diagrams should exist.", result.contains("Diagram"));
        assertTrue("header should exist.", result.contains("XMI.header"));
    }
}
