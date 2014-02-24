/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import java.io.File;
import java.util.List;
import java.util.Map;

import org.xml.sax.SAXException;

import com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler;
import com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class XMIReader's simple methods. It will test all the addXXX, removeXXX,
 * getXXX and putXXX.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIReaderSimleMethodsUnitTests extends TestCase {
    /** The sample xmi file. */
    private static final String XMI_FILE = "test_files" + File.separator + "sample.xmi";

    /**
     * XMIReader instance for testing. Created in setUp method with no handler inside.
     */
    private XMIReader reader;

    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        reader = new XMIReader();
    }

    /**
     * Test of addHandler for accuracy. Add 10 Object and check whether adding succeeds.
     *
     * @throws Exception when error occurs
     */
    public void testAddHandlerAccuracy1() throws Exception {
        XMIHandler[] handlers = new XMIHandler[10];
        // calls addHandler
        for (int idx = 0; idx < 10; idx++) {
            handlers[idx] = new MockClassSimpleXMIHandler();
            reader.addHandler("" + idx, handlers[idx]);
        }
        // checks result
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to implement addHandler.", 10, handlersMap.size());
        for (int idx = 0; idx < 10; idx++) {
            assertTrue("Failed to implement addHandler.", handlers[idx] == handlersMap
                .get("" + idx));
        }
    }

    /**
     * Test of addHandler for accuracy. The later overWrites the former.
     *
     * @throws Exception when error occurs
     */
    public void testAddHandlerAccuracy2() throws Exception {
        // calls addHandler
        reader.addHandler("test", new MockClassSimpleXMIHandler());
        XMIHandler handler = new MockClassSimpleXMIHandler();
        // calls again
        reader.addHandler("test", handler);
        // checks result
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to implement addHandler.", 1, handlersMap.size());
        assertTrue("Failed to implement addHandler.", handler == handlersMap.get("test"));
    }

    /**
     * Test of addHandler with null type. IllegalArgumentException is expected.
     */
    public void testAddHandlerWithNullType() {
        try {
            reader.addHandler(null, new MockClassSimpleXMIHandler());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of addHandler with empty type. IllegalArgumentException is expected.
     */
    public void testAddHandlerWithEmptyType() {
        try {
            reader.addHandler("", new MockClassSimpleXMIHandler());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of addHandler with trimmed empty type. IllegalArgumentException is expected.
     */
    public void testAddHandlerWithTrimmedEmptyType() {
        try {
            reader.addHandler("  ", new MockClassSimpleXMIHandler());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of addHandler with null handler. IllegalArgumentException is expected.
     */
    public void testAddHandlerWithNullHandler() {
        try {
            reader.addHandler("test", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of addHandler for failure: calls it while parsing is in progress. IllegalStateException
     * is expected.
     *
     * @throws Exception when error occurs
     */
    public void testAddHandlerWhileParsing() throws Exception {
        // here is the anonymous class as the subclass of MockClassCountingXMIHandler
        // when parsing start, the method startDocument will be called.
        MockClassCountingXMIHandler handler = new MockClassCountingXMIHandler() {
            /**
             * Mock the startDocument method to call addHandler while parsing.
             *
             * @throws SAXException when exceptionFlag_startDocument is true
             */
            public void startDocument() throws SAXException {
                try {
                    this.getXMIReader().addHandler("test", this);
                    fail("IllegalStateException is expected.");
                } catch (IllegalStateException ise) {
                    // good
                    super.startDocument();
                }
            }
        };
        // sets reader
        handler.setXMIReader(reader);
        // adds handler
        reader.addHandler("UML:Class", handler);
        // calls parse
        reader.parse(new File(XMI_FILE));
        // sees whether checking is done.
        assertEquals("Failed to test AddHandler for IllegalStateException.", 1,
            handler.count_startDocument);
    }

    /**
     * Test of removeHandler for accuracy. Removes the handler one by one.
     *
     * @throws Exception when error occurs
     */
    public void testRemoveHandlerAccuracy1() throws Exception {
        // adds one by one
        for (int idx = 0; idx < 10; idx++) {
            reader.addHandler("" + idx, new MockClassSimpleXMIHandler());
        }
        // removes one by one
        for (int idx = 9; idx >= 0; idx--) {
            reader.removeHandler("" + idx);
            Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
                .getObjectFieldValue(reader, "handlers");
            assertEquals("Failed to implement removeHandler.", idx, handlersMap.size());
            assertNull("Failed to implement removeHandler.", handlersMap.get("" + idx));
        }
    }

    /**
     * Test of removeHandler for accuracy. Removes the handler which does not exist, nothing will
     * happen.
     *
     * @throws Exception when error occurs
     */
    public void testRemoveHandlerAccuracy2() throws Exception {
        // adds one by one
        for (int idx = 0; idx < 10; idx++) {
            reader.addHandler("" + idx, new MockClassSimpleXMIHandler());
        }
        // no key "10"
        reader.removeHandler("10");
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to implement removeHandler.", 10, handlersMap.size());
    }

    /**
     * Test of removeHandler with null type. IllegalArgumentException is expected.
     */
    public void testRemoveHandlerWithNullType() {
        try {
            reader.removeHandler(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of removeHandler with empty type. IllegalArgumentException is expected.
     */
    public void testRemoveHandlerWithEmptyType() {
        try {
            reader.removeHandler("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of removeHandler with trimmed empty type. IllegalArgumentException is expected.
     */
    public void testRemoveHandlerWithTrimmedEmptyType() {
        try {
            reader.removeHandler("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of removeHandler for failure: calls it while parsing is in progress.
     * IllegalStateException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testRemoveHandlerWhileParsing() throws Exception {
        // here is the anonymous class as the subclass of MockClassCountingXMIHandler
        // when parsing start, the method startDocument will be called.
        MockClassCountingXMIHandler handler = new MockClassCountingXMIHandler() {
            /**
             * Mock the startDocument method to call removeHandler while parsing.
             *
             * @throws SAXException when exceptionFlag_startDocument is true
             */
            public void startDocument() throws SAXException {
                try {
                    this.getXMIReader().removeHandler("test");
                    fail("IllegalStateException is expected.");
                } catch (IllegalStateException ise) {
                    // good
                    super.startDocument();
                }
            }
        };
        // sets reader
        handler.setXMIReader(reader);
        // adds handler
        reader.addHandler("UML:Class", handler);
        // calls parse
        reader.parse(new File(XMI_FILE));
        // sees whether checking is done.
        assertEquals("Failed to test removeHandler for IllegalStateException.", 1,
            handler.count_startDocument);
    }

    /**
     * Test of getHandler for accuracy. Get the handler one by one.
     */
    public void testGetHandlerAccuracy1() {
        XMIHandler[] handlers = new XMIHandler[10];
        // adds one by one
        for (int idx = 0; idx < 10; idx++) {
            handlers[idx] = new MockClassSimpleXMIHandler();
            reader.addHandler("" + idx, handlers[idx]);
        }
        // calls getHandler
        for (int idx = 0; idx < 10; idx++) {
            assertEquals("Failed to get handler.", handlers[idx], reader.getHandler("" + idx));
        }
    }

    /**
     * Test of getHandler for accuracy. No handler associated with the given type.
     */
    public void testGetHandlerAccuracy2() {
        assertNull("Failed to get handler.", reader.getHandler("123"));
    }

    /**
     * Test of getHandler with null type. IllegalArgumentException is expected.
     */
    public void testGetHandlerWithNullType() {
        try {
            reader.getHandler(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getHandler with empty type. IllegalArgumentException is expected.
     */
    public void testGetHandlerWithEmptyType() {
        try {
            reader.getHandler("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getHandler with trimmed empty type. IllegalArgumentException is expected.
     */
    public void testGetHandlerWithTrimmedEmptyType() {
        try {
            reader.getHandler("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElement for accuracy. Adds 10 elements and check whether adding succeeds.
     *
     * @throws Exception when error occurs
     */
    public void testPutElementAccuracy1() throws Exception {
        Object[] objects = new Object[10];
        // calls putElement
        for (int idx = 0; idx < 10; idx++) {
            objects[idx] = new Object();
            reader.putElement("" + idx, objects[idx]);
        }
        // checks result
        Map<String, Object> foundElements = (Map<String, Object>) UnitTestsHelper
            .getObjectFieldValue(reader, "foundElements");
        assertEquals("Failed to implement putElement.", 10, foundElements.size());
        for (int idx = 0; idx < 10; idx++) {
            assertTrue("Failed to implement putElement.", objects[idx] == foundElements.get(""
                + idx));
        }
    }

    /**
     * Test of putElement for accuracy. The later overWrites the former.
     *
     * @throws Exception when error occurs
     */
    public void testPutElementAccuracy2() throws Exception {
        // calls putElement
        reader.putElement("test", new Object());
        Object newObject = new Object();
        // calls again
        reader.putElement("test", newObject);
        // checks result
        Map<String, Object> foundElements = (Map<String, Object>) UnitTestsHelper
            .getObjectFieldValue(reader, "foundElements");
        assertEquals("Failed to implement putElement.", 1, foundElements.size());
        assertTrue("Failed to implement putElement.", newObject == foundElements.get("test"));
    }

    /**
     * Test of putElement with null type. IllegalArgumentException is expected.
     */
    public void testPutElementWithNullType() {
        try {
            reader.putElement(null, new Object());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElement with empty type. IllegalArgumentException is expected.
     */
    public void testPutElementWithEmptyType() {
        try {
            reader.putElement("", new Object());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElement with trimmed empty type. IllegalArgumentException is expected.
     */
    public void testPutElementWithTrimmedEmptyType() {
        try {
            reader.putElement("  ", new Object());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElement with null handler. IllegalArgumentException is expected.
     */
    public void testPutElementWithNullHandler() {
        try {
            reader.putElement("test", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElement for failure: xmiId in foundElements map. IllegalStateException is
     * expected.
     */
    public void testPutElementWithXMIIdInFoundElementsMaps() {
        reader.putElement("test", new Object());
        try {
            reader.putElementProperty("test", "test2", new Object());
            fail("IllegalStateException is expected.");
        } catch (IllegalStateException ise) {
            // good
        }
    }

    /**
     * Test of removeElement for accuracy. Removes the element one by one.
     *
     * @throws Exception when error occurs
     */
    public void testRemoveElementAccuracy1() throws Exception {
        // adds one by one
        for (int idx = 0; idx < 10; idx++) {
            reader.putElement("" + idx, new Object());
        }
        // removes one by one
        for (int idx = 9; idx >= 0; idx--) {
            reader.removeElement("" + idx);
            Map<String, Object> foundElements = (Map<String, Object>) UnitTestsHelper
                .getObjectFieldValue(reader, "foundElements");
            assertEquals("Failed to implement removeElement.", idx, foundElements.size());
            assertNull("Failed to implement removeElement.", foundElements.get("" + idx));
        }
    }

    /**
     * Test of removeElement for accuracy. Removes the element which does not exist, nothing will
     * happen.
     *
     * @throws Exception when error occurs
     */
    public void testRemoveElementAccuracy2() throws Exception {
        // adds one by one
        for (int idx = 0; idx < 10; idx++) {
            reader.putElement("" + idx, new Object());
        }
        // no key "10"
        reader.removeElement("10");
        Map<String, Object> foundElements = (Map<String, Object>) UnitTestsHelper
            .getObjectFieldValue(reader, "foundElements");
        assertEquals("Failed to implement removeElement.", 10, foundElements.size());
    }

    /**
     * Test of removeElement with null type. IllegalArgumentException is expected.
     */
    public void testRemoveElementWithNullType() {
        try {
            reader.removeElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of removeElement with empty type. IllegalArgumentException is expected.
     */
    public void testRemoveElementWithEmptyType() {
        try {
            reader.removeElement("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of removeElement with trimmed empty type. IllegalArgumentException is expected.
     */
    public void testRemoveElementWithTrimmedEmptyType() {
        try {
            reader.removeElement("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getElement for accuracy. Gets the element one by one.
     */
    public void testGetElementAccuracy1() {
        Object[] elements = new Object[10];
        // adds one by one
        for (int idx = 0; idx < 10; idx++) {
            elements[idx] = new Object();
            reader.putElement("" + idx, elements[idx]);
        }
        // calls getElement
        for (int idx = 0; idx < 10; idx++) {
            assertEquals("Failed to get element.", elements[idx], reader.getElement("" + idx));
        }
    }

    /**
     * Test of getElement for accuracy. No element associated with the given type.
     */
    public void testGetElementAccuracy2() {
        assertNull("Failed to get element.", reader.getElement("123"));
    }

    /**
     * Test of getElement with null type. IllegalArgumentException is expected.
     */
    public void testGetElementWithNullType() {
        try {
            reader.getElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getElement with empty type. IllegalArgumentException is expected.
     */
    public void testGetElementWithEmptyType() {
        try {
            reader.getElement("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getElement with trimmed empty type. IllegalArgumentException is expected.
     */
    public void testGetElementWithTrimmedEmptyType() {
        try {
            reader.getElement("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElementProperty for accuracy. Adds 5 xmiIDs each with 5 properties, each of which has
     * 5 refObjects.
     *
     * @throws Exception when error occurs
     */
    public void testPutElementPropertyAccuracy1() throws Exception {
        // adding
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    reader.putElementProperty("" + i, "" + j, "" + k);
                }
            }
        }
        // check result
        Map<String, Map<String, List>> forwardReferences = (Map<String, Map<String, List>>) UnitTestsHelper
            .getObjectFieldValue(reader, "forwardReferences");
        assertEquals("Failed to implement putElementProperty.", 5, forwardReferences.size());
        for (int i = 0; i < 5; i++) {
            Map<String, List> refs = forwardReferences.get("" + i);
            assertEquals("Failed to implement putElementProperty.", 5, refs.size());
            for (int j = 0; j < 5; j++) {
                List list = refs.get("" + j);
                assertEquals("Failed to implement putElementProperty.", 5, list.size());
                for (int k = 0; k < 5; k++) {
                    assertEquals("Failed to implement putElementProperty.", "" + k, list.get(k));
                }
            }
        }
    }

    /**
     * Test of putElementProperty for accuracy. Adds 5 xmiIDs each with 5 properties, each of which has
     * 5 refObjects. But all the refObject are the same.
     *
     * @throws Exception when error occurs
     */
    public void testPutElementPropertyAccuracy2() throws Exception {
        // adding
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    reader.putElementProperty("" + i, "" + j, "test");
                }
            }
        }
        // check result
        Map<String, Map<String, List>> forwardReferences = (Map<String, Map<String, List>>) UnitTestsHelper
            .getObjectFieldValue(reader, "forwardReferences");
        assertEquals("Failed to implement putElementProperty.", 5, forwardReferences.size());
        for (int i = 0; i < 5; i++) {
            Map<String, List> refs = forwardReferences.get("" + i);
            assertEquals("Failed to implement putElementProperty.", 5, refs.size());
            for (int j = 0; j < 5; j++) {
                List list = refs.get("" + j);
                assertEquals("Failed to implement putElementProperty.", 5, list.size());
                for (int k = 0; k < 5; k++) {
                    assertEquals("Failed to implement putElementProperty.", "test", list.get(k));
                }
            }
        }
    }

    /**
     * Test of putElementProperty with null xmiId. IllegalArgumentException is expected.
     */
    public void testPutElementPropertyWithNullXmiId() {
        try {
            reader.putElementProperty(null, "1", "2");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElementProperty with empty xmiId. IllegalArgumentException is expected.
     */
    public void testPutElementPropertyWithEmptyXmiId() {
        try {
            reader.putElementProperty("", "1", "2");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElementProperty with trimmed empty xmiId. IllegalArgumentException is expected.
     */
    public void testPutElementPropertyWithTrimmedEmptyXmiId() {
        try {
            reader.putElementProperty("  ", "1", "2");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElementProperty with null property. IllegalArgumentException is expected.
     */
    public void testPutElementPropertyWithNullProperty() {
        try {
            reader.putElementProperty("1", null, "2");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElementProperty with empty property. IllegalArgumentException is expected.
     */
    public void testPutElementPropertyWithEmptyProperty() {
        try {
            reader.putElementProperty("1", "", "2");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElementProperty with trimmed empty property. IllegalArgumentException is expected.
     */
    public void testPutElementPropertyWithTrimmedEmptyProperty() {
        try {
            reader.putElementProperty("1", "  ", "2");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of putElementProperty with null refObject. IllegalArgumentException is expected.
     */
    public void testPutElementPropertyWithNullRefObject() {
        try {
            reader.putElementProperty("1", "2", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getElementProperties for accuracy. Gets element-property one by one.
     */
    public void testGetElementPropertyAccuracy1() {
        // adding
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    reader.putElementProperty("" + i, "" + j, "" + k);
                }
            }
        }
        // gets and checks result
        for (int i = 0; i < 5; i++) {
            Map<String, List> refs = reader.getElementProperties("" + i);
            assertEquals("Failed to implement getElementProperties.", 5, refs.size());
            for (int j = 0; j < 5; j++) {
                List list = refs.get("" + j);
                assertEquals("Failed to implement getElementProperties.", 5, list.size());
                for (int k = 0; k < 5; k++) {
                    assertEquals("Failed to implement getElementProperties.", "" + k, list.get(k));
                }
            }
        }
    }

    /**
     * Test of getElementProperties for accuracy. Gets no such element-property.
     */
    public void testGetElementPropertyAccuracy2() {
        assertNull("Failed to implement getElementProperties.", reader.getElementProperties("test"));
    }

    /**
     * Test of getElementProperties with null xmiId. IllegalArgumentException is expected.
     */
    public void testGetElementPropertyWithNullXmiId() {
        try {
            reader.getElementProperties(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getElementProperties with empty xmiId. IllegalArgumentException is expected.
     */
    public void testGetElementPropertyWithEmptyXmiId() {
        try {
            reader.getElementProperties("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getElementProperties with trimmed empty xmiId. IllegalArgumentException is expected.
     */
    public void testGetElementPropertyWithTrimmedEmptyXmiId() {
        try {
            reader.getElementProperties("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of getActiveHandlers for accuracy: parsing is in occurring. get the getActiveHandlers.
     *
     * @exception when error occurs
     */
    public void testGetActiveHandlersAccuracy() throws Exception {
        // here is the anonymous class as the subclass of MockClassCountingXMIHandler
        // when parsing start, the method startDocument will be called.
        MockClassCountingXMIHandler handler = new MockClassCountingXMIHandler() {
            /**
             * Mock the startDocument method to call getActiveHandlers while parsing.
             *
             * @throws SAXException when exceptionFlag_startDocument is true
             */
            public void startDocument() throws SAXException {
                // calls getActiveHandlers
                List<XMIHandler> handlers = this.getXMIReader().getActiveHandlers();
                // checks result
                assertEquals("Failed to implement getActiveHandlers.", 0, handlers.size());
                super.startDocument();
            }
        };
        // sets reader
        handler.setXMIReader(reader);
        // adds handler
        reader.addHandler("UML:Class", handler);
        // calls parse
        reader.parse(new File(XMI_FILE));
        // sees whether checking is done.
        assertEquals("Failed to test getActiveHandlers.", 1, handler.count_startDocument);
    }

    /**
     * Test of getActiveHandlers for failure : parsing is not currently occurring.
     * IllegalStateException is expected.
     */
    public void testGetActiveHandlersFailure() {
        try {
            reader.getActiveHandlers();
            fail("IllegalStateException is expected.");
        } catch (IllegalStateException ise) {
            // good
        }
    }

}
