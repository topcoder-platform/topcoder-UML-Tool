/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import com.topcoder.xmi.reader.XMIReader.DelegatingHandler;
import com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler;

import junit.framework.TestCase;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;


/**
 * <p>
 * Unit test cases for inner class DelegatingHandler.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DelegatingHandlerUnitTests extends TestCase {
    /** DelegatingHandler instance for testing. It will be created in setUp method. */
    private DelegatingHandler delegatingHandler;

    /**
     * XMIReader instance for testing. It will be created in setUp method and act as the enclosing
     * instance for delegatingHandler.
     */
    private XMIReader reader;

    /** Attributes instance for testing. Created in setUp method. */
    private Attributes attr;

    /**
     * MockClassCountingXMIHandler instances array for testing. The value will be initialized in
     * setUp method. The instances will act as the inner XMIHandlers in XMIReader and used by
     * DelegatingHandler. In XMIReader, the type of the handlers will be the index of them in this
     * array. For example, "0" is for handlers[0].
     */
    private MockClassCountingXMIHandler[] handlers = new MockClassCountingXMIHandler[10];

    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // unLoads configuration in order to create a XMIReader with no handlers
        UnitTestsHelper.unloadConfig();
        reader = new XMIReader();

        delegatingHandler = reader.new DelegatingHandler();

        for (int i = 0; i < 10; i++) {
            handlers[i] = new MockClassCountingXMIHandler();
            reader.addHandler("" + i, handlers[i]);
        }

        attr = new MockClassAttributes();
    }

    /**
     * Test of constructor DelegatingHandler() for accuracy. The object is created successfully and
     * also all the properties are initialized correctly.
     *
     * @throws Exception when error occurs
     */
    public void testCtorAccuracy() throws Exception {
        // uses the DelegatingHandler instance created in setUp method
        // tests creation
        assertNotNull("Failed to create DelegatingHandler instance.", delegatingHandler);

        // tests properties
        assertNull("Failed to initialize DelegatingHandler instance.",
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
        assertEquals("Failed to initialize DelegatingHandler instance.", 0,
            delegatingHandler.getActiveHandlers().size());
    }

    /**
     * Test of startDocument for accuracy. All the handlers of enclosing XMIReader all called.
     *
     * @throws Exception when error occurs
     */
    public void testStartDocumentAccuracy() throws Exception {
        // calls the method
        delegatingHandler.startDocument();

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            assertEquals("Failed to implement startDocument.", 1, handlers[idx].count_startDocument);
        }
    }

    /**
     * Test of startDocument for failure. SAXException is thrown by a handler of the enclosing
     * XMIReader.
     */
    public void testStartDocumentFailure() {
        // change the exception flag to make the exception throw
        handlers[5].exceptionFlag_startDocument = true;

        try {
            delegatingHandler.startDocument();
            fail("SAXException is expected.");
        } catch (SAXException saxe) {
            // good
        }
    }

    /**
     * Test of startElement for accuracy. The handlers[4] will be pushed into the top of the stack
     * and currentHandler is set to handlers[4]. Uses qname to get the handler.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy1() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", "5", "4", attr);

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            if (idx != 4) {
                assertEquals("Failed to implement startElement.", 0,
                    handlers[idx].count_startElement);
            } else {
                assertEquals("Failed to implement startElement.", 1,
                    handlers[idx].count_startElement);
            }
        }

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[4],
            delegatingHandler.getActiveHandlers().get(0));
        assertEquals("Failed to implement startElement.", handlers[4],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. The handlers[4] will be pushed into the top of the stack
     * and currentHandler is set to handlers[4]. Uses qname to get the handler and localName is
     * null.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy2() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", null, "4", attr);

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            if (idx != 4) {
                assertEquals("Failed to implement startElement.", 0,
                    handlers[idx].count_startElement);
            } else {
                assertEquals("Failed to implement startElement.", 1,
                    handlers[idx].count_startElement);
            }
        }

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[4],
            delegatingHandler.getActiveHandlers().get(0));
        assertEquals("Failed to implement startElement.", handlers[4],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. The handlers[4] will be pushed into the top of the stack
     * and currentHandler is set to handlers[4]. Uses qname to get the handler and localName is
     * empty.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy3() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", "", "4", attr);

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            if (idx != 4) {
                assertEquals("Failed to implement startElement.", 0,
                    handlers[idx].count_startElement);
            } else {
                assertEquals("Failed to implement startElement.", 1,
                    handlers[idx].count_startElement);
            }
        }

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[4],
            delegatingHandler.getActiveHandlers().get(0));
        assertEquals("Failed to implement startElement.", handlers[4],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. The handlers[4] will be pushed into the top of the stack
     * and currentHandler is set to handlers[4]. Uses qname to get the handler and localName is
     * trimmed empty.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy4() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", "  ", "4", attr);

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            if (idx != 4) {
                assertEquals("Failed to implement startElement.", 0,
                    handlers[idx].count_startElement);
            } else {
                assertEquals("Failed to implement startElement.", 1,
                    handlers[idx].count_startElement);
            }
        }

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[4],
            delegatingHandler.getActiveHandlers().get(0));
        assertEquals("Failed to implement startElement.", handlers[4],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. The handlers[5] will be pushed into the top of the stack
     * and currentHandler is set to handlers[5]. Uses localName to get the handler and qname is
     * empty.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy5() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", "5", "", attr);

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            if (idx != 5) {
                assertEquals("Failed to implement startElement.", 0,
                    handlers[idx].count_startElement);
            } else {
                assertEquals("Failed to implement startElement.", 1,
                    handlers[idx].count_startElement);
            }
        }

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[5],
            delegatingHandler.getActiveHandlers().get(0));
        assertEquals("Failed to implement startElement.", handlers[5],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. The handlers[5] will be pushed into the top of the stack
     * and currentHandler is set to handlers[5]. Uses localName to get the handler and qname is
     * trimmed empty.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy6() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", "5", "  ", attr);

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            if (idx != 5) {
                assertEquals("Failed to implement startElement.", 0,
                    handlers[idx].count_startElement);
            } else {
                assertEquals("Failed to implement startElement.", 1,
                    handlers[idx].count_startElement);
            }
        }

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[5],
            delegatingHandler.getActiveHandlers().get(0));
        assertEquals("Failed to implement startElement.", handlers[5],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. The handlers[5] will be pushed into the top of the stack
     * and currentHandler is set to handlers[5]. Uses localName to get the handler and qname is
     * null.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy7() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", "5", null, attr);

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            if (idx != 5) {
                assertEquals("Failed to implement startElement.", 0,
                    handlers[idx].count_startElement);
            } else {
                assertEquals("Failed to implement startElement.", 1,
                    handlers[idx].count_startElement);
            }
        }

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[5],
            delegatingHandler.getActiveHandlers().get(0));
        assertEquals("Failed to implement startElement.", handlers[5],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. Not matching handler is found and the stack is empty.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy8() throws Exception {
        // calls the method
        delegatingHandler.startElement("test", "12", "11", attr);

        assertEquals("Failed to implement startElement.", 0,
            delegatingHandler.getActiveHandlers().size());
        assertNull("Failed to implement startElement.",
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for accuracy. The stack is not empty but no handler is found.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementAccuracy9() throws Exception {
        // call it and the stack is not empty.
        delegatingHandler.startElement("test", "4", "5", attr);

        // calls the method
        delegatingHandler.startElement("test", "12", "11", attr);

        assertEquals("Failed to implement startElement.", 1,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement startElement.", handlers[5],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
    }

    /**
     * Test of startElement for Stress. complex calling is used.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementStress() throws Exception {
        // in the inner loop:
        // first 10 calls will add handler to stack
        // last 10 calls will add nothings.
        for (int i = 0; i < 10; i++) {
            // matching handler will be found
            for (int j = 0; j < 10; j++) {
                delegatingHandler.startElement("test", "" + j, "" + j, attr);
                assertEquals("Failed to implement startElement.", (i * 10) + j + 1,
                    delegatingHandler.getActiveHandlers().size());
                assertEquals("Failed to implement startElement.", handlers[j],
                    delegatingHandler.getActiveHandlers().get((i * 10) + j));
                assertEquals("Failed to implement startElement.", handlers[j],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }

            // matching handler will not be found
            for (int j = 0; j < 10; j++) {
                delegatingHandler.startElement("test", "1" + j, "1" + j, attr);
                assertEquals("Failed to implement startElement.", (i * 10) + 10,
                    delegatingHandler.getActiveHandlers().size());
                assertEquals("Failed to implement startElement.", handlers[9],
                    delegatingHandler.getActiveHandlers().get((i * 10) + 9));
                assertEquals("Failed to implement startElement.", handlers[9],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
                assertEquals("Failed to implement startElement.", (i * 11) + 2 + j,
                    handlers[9].count_startElement);
            }
        }
    }

    /**
     * Test of startElement with both localName and qname null. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithBothNameNull() throws Exception {
        try {
            delegatingHandler.startElement("test", null, null, attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with null localName and empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithNullLocalNameAndEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", null, "", attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with null localName and trimmed empty qname. IllegalArgumentException
     * is expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithNullLocalNameAndTrimmedEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", null, "  ", attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with empty localName and null qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithEmptyLocalNameAndNullQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", "", null, attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with empty localName and empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithEmptyLocalNameAndEmptyQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", "", "", attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with empty localName and trimmed empty qname. IllegalArgumentException
     * is expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithEmptyLocalNameAndTrimmedEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", "", "  ", attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with trimmed empty localName and null qname. IllegalArgumentException
     * is expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithTrimmedEmptyLocalNameAndNullQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", "  ", null, attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with empty localName and empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithTrimmedEmptyLocalNameAndEmptyQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", "  ", "", attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with empty localName and trimmed empty qname. IllegalArgumentException
     * is expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithTrimmedEmptyLocalNameAndTrimmedEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.startElement("test", "  ", "  ", attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with null uri. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithNullURI() throws Exception {
        try {
            delegatingHandler.startElement(null, "4", "5", attr);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of startElement with empty uri. All works well.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithEmptylURI() throws Exception {
        delegatingHandler.startElement("", "4", "5", attr);
    }

    /**
     * Test of startElement with trimmed empty uri. All works well.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithTrimmedEmptylURI()
        throws Exception {
        delegatingHandler.startElement("  ", "4", "5", attr);
    }

    /**
     * Test of startElement with null Attributes. All works well.
     *
     * @throws Exception when error occurs
     */
    public void testStartElementWithNullAttributes() throws Exception {
        delegatingHandler.startElement("test", "4", "5", null);
    }

    /**
     * Test of startElement for failure. SAXException is thrown by a handler of the enclosing
     * XMIReader.
     */
    public void testStartElementForSAXException() {
        // change the exception flag to make the exception throw
        handlers[5].exceptionFlag_startElement = true;

        try {
            delegatingHandler.startElement("test", "4", "5", attr);
            fail("SAXException is expected.");
        } catch (SAXException saxe) {
            // good
        }
    }

    /**
     * Test of endElement for accuracy. qname will be used for popping.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy1() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 10; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        // remove the handlers from stack
        for (int i = 9; i >= 0; i--) {
            delegatingHandler.endElement("test", "2", "" + i);

            // checks the result
            for (int j = 9; j >= i; j--) {
                assertEquals("Failed to implement endElement.", 1, handlers[j].count_endElement);
            }

            assertEquals("Failed to implement endElement.", i,
                delegatingHandler.getActiveHandlers().size());

            if (i != 0) {
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    delegatingHandler.getActiveHandlers().get(i - 1));
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            } else {
                assertNull("Failed to implement endElement.",
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }
        }
    }

    /**
     * Test of endElement for accuracy. qname will be used for popping. localName is null.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy2() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 10; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        // remove the handlers from stack
        for (int i = 9; i >= 0; i--) {
            delegatingHandler.endElement("test", null, "" + i);

            // checks the result
            for (int j = 9; j >= i; j--) {
                assertEquals("Failed to implement endElement.", 1, handlers[j].count_endElement);
            }

            assertEquals("Failed to implement endElement.", i,
                delegatingHandler.getActiveHandlers().size());

            if (i != 0) {
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    delegatingHandler.getActiveHandlers().get(i - 1));
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            } else {
                assertNull("Failed to implement endElement.",
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }
        }
    }

    /**
     * Test of endElement for accuracy. qname will be used for popping. localName is empty.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy3() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 10; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        // remove the handlers from stack
        for (int i = 9; i >= 0; i--) {
            delegatingHandler.endElement("test", "", "" + i);

            // checks the result
            for (int j = 9; j >= i; j--) {
                assertEquals("Failed to implement endElement.", 1, handlers[j].count_endElement);
            }

            assertEquals("Failed to implement endElement.", i,
                delegatingHandler.getActiveHandlers().size());

            if (i != 0) {
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    delegatingHandler.getActiveHandlers().get(i - 1));
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            } else {
                assertNull("Failed to implement endElement.",
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }
        }
    }

    /**
     * Test of endElement for accuracy. qname will be used for popping. localName is trimmed empty.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy4() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 10; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        // remove the handlers from stack
        for (int i = 9; i >= 0; i--) {
            delegatingHandler.endElement("test", "  ", "" + i);

            // checks the result
            for (int j = 9; j >= i; j--) {
                assertEquals("Failed to implement endElement.", 1, handlers[j].count_endElement);
            }

            assertEquals("Failed to implement endElement.", i,
                delegatingHandler.getActiveHandlers().size());

            if (i != 0) {
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    delegatingHandler.getActiveHandlers().get(i - 1));
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            } else {
                assertNull("Failed to implement endElement.",
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }
        }
    }

    /**
     * Test of endElement for accuracy. localName will be used for popping. qname is null.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy5() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 10; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        // remove the handlers from stack
        for (int i = 9; i >= 0; i--) {
            delegatingHandler.endElement("test", "" + i, null);

            // checks the result
            for (int j = 9; j >= i; j--) {
                assertEquals("Failed to implement endElement.", 1, handlers[j].count_endElement);
            }

            assertEquals("Failed to implement endElement.", i,
                delegatingHandler.getActiveHandlers().size());

            if (i != 0) {
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    delegatingHandler.getActiveHandlers().get(i - 1));
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            } else {
                assertNull("Failed to implement endElement.",
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }
        }
    }

    /**
     * Test of endElement for accuracy. localName will be used for popping. qname is empty.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy6() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 10; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        // remove the handlers from stack
        for (int i = 9; i >= 0; i--) {
            delegatingHandler.endElement("test", "" + i, "");

            // checks the result
            for (int j = 9; j >= i; j--) {
                assertEquals("Failed to implement endElement.", 1, handlers[j].count_endElement);
            }

            assertEquals("Failed to implement endElement.", i,
                delegatingHandler.getActiveHandlers().size());

            if (i != 0) {
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    delegatingHandler.getActiveHandlers().get(i - 1));
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            } else {
                assertNull("Failed to implement endElement.",
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }
        }
    }

    /**
     * Test of endElement for accuracy. localName will be used for popping. qname is trimmed empty.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy7() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 10; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        // remove the handlers from stack
        for (int i = 9; i >= 0; i--) {
            delegatingHandler.endElement("test", "" + i, "  ");

            // checks the result
            for (int j = 9; j >= i; j--) {
                assertEquals("Failed to implement endElement.", 1, handlers[j].count_endElement);
            }

            assertEquals("Failed to implement endElement.", i,
                delegatingHandler.getActiveHandlers().size());

            if (i != 0) {
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    delegatingHandler.getActiveHandlers().get(i - 1));
                assertEquals("Failed to implement endElement.", handlers[i - 1],
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            } else {
                assertNull("Failed to implement endElement.",
                    UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
            }
        }
    }

    /**
     * Test of endElement for accuracy. No matching handler is found. The top handler in stack will
     * be call but will not be popped. The currentHandler will not changed.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementAccuracy8() throws Exception {
        // adds the handlers to stack
        for (int idx = 0; idx < 5; idx++) {
            delegatingHandler.startElement("test", "11", "" + idx, attr);
        }

        delegatingHandler.endElement("test", "1", "10");
        assertEquals("Failed to implement endElement.", 5,
            delegatingHandler.getActiveHandlers().size());
        assertEquals("Failed to implement endElement.", handlers[4],
            delegatingHandler.getActiveHandlers().get(4));
        assertEquals("Failed to implement endElement.", handlers[4],
            UnitTestsHelper.getObjectFieldValue(delegatingHandler, "currentHandler"));
        assertEquals("Failed to implement endElement.", 1, handlers[4].count_endElement);
    }

    /**
     * Test of endElement with both localName and qname null. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithBothNameNull() throws Exception {
        try {
            delegatingHandler.endElement("test", null, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with null localName and empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithNullLocalNameAndEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", null, "");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with null localName and trimmed empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithNullLocalNameAndTrimmedEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", null, "  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with empty localName and null qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithEmptyLocalNameAndNullQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", "", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with empty localName and empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithEmptyLocalNameAndEmptyQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", "", "");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with empty localName and trimmed empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithEmptyLocalNameAndTrimmedEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", "", "  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with trimmed empty localName and null qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithTrimmedEmptyLocalNameAndNullQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", "  ", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with empty localName and empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithTrimmedEmptyLocalNameAndEmptyQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", "  ", "");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with empty localName and trimmed empty qname. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithTrimmedEmptyLocalNameAndTrimmedEmtpyQname()
        throws Exception {
        try {
            delegatingHandler.endElement("test", "  ", "  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with null uri. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithNullURI() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);

        try {
            delegatingHandler.endElement(null, "4", "5");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of endElement with empty uri. All works well.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithEmptylURI() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.endElement("", "4", "5");
    }

    /**
     * Test of endElement with trimmed empty uri. All works well.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementWithTrimmedEmptylURI() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.endElement("  ", "4", "5");
    }

    /**
     * Test of endElement for failure. SAXException is thrown by a handler of the enclosing
     * XMIReader.
     *
     * @throws Exception when error occurs
     */
    public void testEndElementForSAXException() throws Exception {
        // change the exception flag to make the exception throw
        handlers[5].exceptionFlag_endElement = true;
        delegatingHandler.startElement("test", "4", "5", attr);

        try {
            delegatingHandler.endElement("test", "4", "5");
            fail("SAXException is expected.");
        } catch (SAXException saxe) {
            // good
        }
    }

    /**
     * Test of ignorableWhitespace for accuracy. The currentHandler#ignorableWhitespace will be
     * call.
     *
     * @throws Exception when error occurs
     */
    public void testIgnorableWhitespaceAccuracy1() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.ignorableWhitespace(new char[10], 0, 10);
        assertEquals("Failed to implement ignorableWhitespace.", 1,
            handlers[5].count_ignorableWhitespace);
    }

    /**
     * Test of ignorableWhitespace for accuracy. The currentHandler is null, nothing will happen.
     *
     * @throws Exception when error occurs
     */
    public void testIgnorableWhitespaceAccuracy2() throws Exception {
        delegatingHandler.ignorableWhitespace(new char[10], 0, 10);
    }

    /**
     * Test of ignorableWhitespace with null ch. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testIgnorableWhitespaceWithNullCh() throws Exception {
        try {
            delegatingHandler.ignorableWhitespace(null, 0, 10);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of ignorableWhitespace with negative start. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testIgnorableWhitespaceWithNegativeStart()
        throws Exception {
        try {
            delegatingHandler.ignorableWhitespace(new char[10], -1, 10);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of ignorableWhitespace with negative length. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testIgnorableWhitespaceWithNegativeLength()
        throws Exception {
        try {
            delegatingHandler.ignorableWhitespace(new char[10], 0, -1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of ignorableWhitespace with invalid start and length. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testIgnorableWhitespaceWithInvalidStartAndLength()
        throws Exception {
        try {
            // out of bound
            delegatingHandler.ignorableWhitespace(new char[10], 5, 6);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of ignorableWhitespace for failure. SAXException is thrown by a handler of the
     * enclosing XMIReader.
     *
     * @throws Exception when error occurs
     */
    public void testIgnorableWhitespaceForSAXException()
        throws Exception {
        // change the exception flag to make the exception throw
        handlers[5].exceptionFlag_ignorableWhitespace = true;
        delegatingHandler.startElement("test", "4", "5", attr);

        try {
            delegatingHandler.ignorableWhitespace(new char[10], 5, 3);
            fail("SAXException is expected.");
        } catch (SAXException saxe) {
            // good
        }
    }

    /**
     * Test of characters for accuracy. The currentHandler#characters will be call.
     *
     * @throws Exception when error occurs
     */
    public void testCharactersAccuracy1() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.characters(new char[10], 0, 10);
        assertEquals("Failed to implement characters.", 1, handlers[5].count_characters);
    }

    /**
     * Test of characters for accuracy. The currentHandler is null, nothing will happen.
     *
     * @throws Exception when error occurs
     */
    public void testCharactersAccuracy2() throws Exception {
        delegatingHandler.characters(new char[10], 0, 10);
    }

    /**
     * Test of characters with null ch. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testCharactersWithNullCh() throws Exception {
        try {
            delegatingHandler.characters(null, 0, 10);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of characters with negative start. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testCharactersWithNegativeStart() throws Exception {
        try {
            delegatingHandler.characters(new char[10], -1, 10);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of characters with negative length. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testCharactersWithNegativeLength() throws Exception {
        try {
            delegatingHandler.characters(new char[10], 0, -1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of characters with invalid start and length. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testCharactersWithInvalidStartAndLength()
        throws Exception {
        try {
            // out of bound
            delegatingHandler.characters(new char[10], 5, 6);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of characters for failure. SAXException is thrown by a handler of the enclosing
     * XMIReader.
     *
     * @throws Exception when error occurs
     */
    public void testCharactersForSAXException() throws Exception {
        // change the exception flag to make the exception throw
        handlers[5].exceptionFlag_characters = true;
        delegatingHandler.startElement("test", "4", "5", attr);

        try {
            delegatingHandler.characters(new char[10], 5, 3);
            fail("SAXException is expected.");
        } catch (SAXException saxe) {
            // good
        }
    }

    /**
     * Test of endDocument for accuracy. All the handlers of enclosing XMIReader all called.
     *
     * @throws Exception when error occurs
     */
    public void testEndDocumentAccuracy() throws Exception {
        // calls the method
        delegatingHandler.endDocument();

        // checks the result
        for (int idx = 0; idx < 10; idx++) {
            assertEquals("Failed to implement endDocument.", 1, handlers[idx].count_endDocument);
        }
    }

    /**
     * Test of endDocument for failure. SAXException is thrown by a handler of the enclosing
     * XMIReader.
     */
    public void testEndDocumentFailure() {
        // change the exception flag to make the exception throw
        handlers[5].exceptionFlag_endDocument = true;

        try {
            delegatingHandler.endDocument();
            fail("SAXException is expected.");
        } catch (SAXException saxe) {
            // good
        }
    }

    /**
     * Test of processingInstruction for accuracy. The currentHandler#processingInstruction will be
     * call.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionAccuracy1() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.processingInstruction("good", "test");
        assertEquals("Failed to implement ignorableWhitespace.", 1,
            handlers[5].count_processingInstruction);
    }

    /**
     * Test of processingInstruction for accuracy. The currentHandler is null, nothing will happen.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionAccuracy2() throws Exception {
        delegatingHandler.processingInstruction("good", "test");
    }

    /**
     * Test of processingInstruction for accuracy. The target is empty but the
     * currentHandler#processingInstruction will be call.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionAccuracy3() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.processingInstruction("", "test");
        assertEquals("Failed to implement ignorableWhitespace.", 1,
            handlers[5].count_processingInstruction);
    }

    /**
     * Test of processingInstruction for accuracy. The target is trimmed empty but the
     * currentHandler#processingInstruction will be call.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionAccuracy4() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.processingInstruction("", "test");
        assertEquals("Failed to implement ignorableWhitespace.", 1,
            handlers[5].count_processingInstruction);
    }

    /**
     * Test of processingInstruction for accuracy. The data is empty but the
     * currentHandler#processingInstruction will be call.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionAccuracy5() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.processingInstruction("good", "");
        assertEquals("Failed to implement ignorableWhitespace.", 1,
            handlers[5].count_processingInstruction);
    }

    /**
     * Test of processingInstruction for accuracy. The data is trimmed empty but the
     * currentHandler#processingInstruction will be call.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionAccuracy6() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.processingInstruction("good", "  ");
        assertEquals("Failed to implement ignorableWhitespace.", 1,
            handlers[5].count_processingInstruction);
    }

    /**
     * Test of processingInstruction for accuracy. The data is null but the
     * currentHandler#processingInstruction will be call.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionAccuracy7() throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        delegatingHandler.processingInstruction("good", null);
        assertEquals("Failed to implement ignorableWhitespace.", 1,
            handlers[5].count_processingInstruction);
    }

    /**
     * Test of processingInstruction with null target. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionWithNullTarget()
        throws Exception {
        try {
            delegatingHandler.processingInstruction(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of processingInstruction for failure. SAXException is thrown by a handler of the
     * enclosing XMIReader.
     *
     * @throws Exception when error occurs
     */
    public void testProcessingInstructionForSAXException()
        throws Exception {
        delegatingHandler.startElement("test", "4", "5", attr);
        handlers[5].exceptionFlag_processingInstruction = true;

        try {
            delegatingHandler.processingInstruction("good", "test");
            fail("SAXException is expected.");
        } catch (SAXException saxe) {
            // good
        }
    }

    /**
     * Test of getActiveHandlers accuracy.
     *
     * @throws Exception when error occurs
     */
    public void testGetActiveHandlersAccuracy() throws Exception {
        // adds handlers to stack
        for (int i = 0; i < 10; i++) {
            delegatingHandler.startElement("test", "4", "" + i, attr);
        }

        assertEquals("Failed to get ActiveHandlers.", 10,
            delegatingHandler.getActiveHandlers().size());

        for (int i = 0; i < 10; i++) {
            assertEquals("Failed to get ActiveHandlers.", handlers[i],
                delegatingHandler.getActiveHandlers().get(i));
        }
    }
}
