/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler;
import com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler;
import com.topcoder.xmi.reader.handlers.NoArgumentCtorAbsentdHandler;
import com.topcoder.xmi.reader.handlers.NoArgumentCtorDisabledHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class XMIReader's constructors.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIReaderConstructorsUnitTests extends TestCase {
    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // unLoads configuration
        UnitTestsHelper.unloadConfig();
    }

    /**
     * Clears the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void tearDown() throws Exception {
        UnitTestsHelper.unloadConfig();
    }

    /**
     * <p>
     * This method will make sure the fields or checkedReader: <br>
     * 1) all the inner XMIHandlers contain the checkedReader; <br>
     * 2) foundElements and forwardReferences are empty; <br>
     * 3) currentDelegatingHandler is null. <br>
     * </p>
     *
     * @param checkedReader the XMIReader to check
     * @throws Exception when error occurs
     */
    private void assertForInitialFields(XMIReader checkedReader) throws Exception {
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(checkedReader, "handlers");
        for (Iterator it = handlersMap.values().iterator(); it.hasNext();) {
            assertEquals("Failed to initialize the fields.", checkedReader, ((DefaultXMIHandler) it
                .next()).getXMIReader());
        }
        assertEquals("Failed to initialize the fields.", 0, ((Map<String, Object>) UnitTestsHelper
            .getObjectFieldValue(checkedReader, "foundElements")).size());
        assertEquals("Failed to initialize the fields.", 0,
            ((Map<String, Map<String, List>>) UnitTestsHelper.getObjectFieldValue(checkedReader,
                    "forwardReferences")).size());
        assertNull("Failed to initialize the fields.", UnitTestsHelper.getObjectFieldValue(
            checkedReader, "currentDelegatingHandler"));
    }

    /**
     * Test of constructor: XMIReader() accuracy :the default namespace doesn't exist. XMIReader
     * with no handlers will be created. All the map are empty and currentDelegatingHandler is null.
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy1() throws Exception {
        XMIReader reader = new XMIReader();
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        assertEquals("Failed to initialize the fields.", 0,
            ((Map<String, XMIHandler>) UnitTestsHelper.getObjectFieldValue(reader, "handlers"))
                .size());
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration: (reuse) flag is true--&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *       &lt;Property name=&quot;reuse&quot;&gt;
     *             &lt;Value&gt;true&lt;/Value&gt;
     *        &lt;/Property&gt;
     *        &lt;Property name=&quot;handlers&quot;&gt;
     *              &lt;Property name=&quot;UML:Class&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *              &lt;/Property&gt;
     *              &lt;Property name=&quot;UML:Interface&quot;&gt;
     *                   &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler&lt;/Value&gt;
     *              &lt;/Property&gt;
     *              &lt;!-- since (reuse) is true, it will not instantiate another MockClassCountingXMIHandler. --&gt;
     *                   &lt;Property name=&quot;UML:Stereotype&quot;&gt;
     *               &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *               &lt;/Property&gt;
     *        &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy2() throws Exception {
        UnitTestsHelper.loadConfig("valid1.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);

        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration with (reuse) flag missing, so it will set true--&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *        &lt;Property name=&quot;handlers&quot;&gt;
     *            &lt;Property name=&quot;UML:Class&quot;&gt;
     *                &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *            &lt;Property name=&quot;UML:Interface&quot;&gt;
     *                &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler&lt;/Value&gt;
     *             &lt;/Property&gt;
     *             &lt;!-- since (reuse) is true, it will not instantiate another MockClassCountingXMIHandler. --&gt;
     *             &lt;Property name=&quot;UML:Stereotype&quot;&gt;
     *                &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *              &lt;/Property&gt;
     *         &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy3() throws Exception {
        UnitTestsHelper.loadConfig("valid2.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration with (reuse) flag TrUe --&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *         &lt;Property name=&quot;reuse&quot;&gt;
     *               &lt;Value&gt;TrUe&lt;/Value&gt;
     *         &lt;/Property&gt;
     *         &lt;Property name=&quot;handlers&quot;&gt;
     *             &lt;Property name=&quot;UML:Class&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *             &lt;/Property&gt;
     *             &lt;Property name=&quot;UML:Interface&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler&lt;/Value&gt;
     *             &lt;/Property&gt;
     *             &lt;!-- since (reuse) is true, it will not instantiate another MockClassCountingXMIHandler. --&gt;
     *             &lt;Property name=&quot;UML:Stereotype&quot;&gt;
     *                 &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *             &lt;/Property&gt;
     *          &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy4() throws Exception {
        UnitTestsHelper.loadConfig("valid3.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration with (reuse) flag false--&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *       &lt;Property name=&quot;reuse&quot;&gt;
     *              &lt;Value&gt;false&lt;/Value&gt;
     *       &lt;/Property&gt;
     *       &lt;Property name=&quot;handlers&quot;&gt;
     *            &lt;Property name=&quot;UML:Class&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *            &lt;Property name=&quot;UML:Interface&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *            &lt;!-- since (reuse) is false, it will instantiate another MockClassCountingXMIHandler. --&gt;
     *            &lt;Property name=&quot;UML:Stereotype&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *       &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy5() throws Exception {
        UnitTestsHelper.loadConfig("valid4.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Stereotype").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") != handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration with (reuse) flag is other value--&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *       &lt;Property name=&quot;reuse&quot;&gt;
     *            &lt;Value&gt;other&lt;/Value&gt;
     *       &lt;/Property&gt;
     *       &lt;Property name=&quot;handlers&quot;&gt;
     *            &lt;Property name=&quot;UML:Class&quot;&gt;
     *                 &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *            &lt;Property name=&quot;UML:Interface&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *            &lt;!-- since (reuse) is false, it will instantiate another MockClassCountingXMIHandler. --&gt;
     *            &lt;Property name=&quot;UML:Stereotype&quot;&gt;
     *                  &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *       &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy6() throws Exception {
        UnitTestsHelper.loadConfig("valid5.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Stereotype").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") != handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration: (reuse) misses value--&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *      &lt;Property name=&quot;reuse&quot;&gt;
     *      &lt;/Property&gt;
     *      &lt;Property name=&quot;handlers&quot;&gt;
     *          &lt;Property name=&quot;UML:Class&quot;&gt;
     *              &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *          &lt;/Property&gt;
     *          &lt;Property name=&quot;UML:Interface&quot;&gt;
     *              &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassSimpleXMIHandler&lt;/Value&gt;
     *          &lt;/Property&gt;
     *          &lt;!-- since (reuse) is true, it will not instantiate another MockClassCountingXMIHandler. --&gt;
     *          &lt;Property name=&quot;UML:Stereotype&quot;&gt;
     *              &lt;Value&gt;com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler&lt;/Value&gt;
     *          &lt;/Property&gt;
     *       &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy7() throws Exception {
        UnitTestsHelper.loadConfig("valid6.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration: the handlers property is empty--&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *     &lt;Property name=&quot;reuse&quot;&gt;
     *        &lt;Value&gt;true&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;handlers&quot;&gt;
     *     &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy8() throws Exception {
        UnitTestsHelper.loadConfig("valid7.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 0, handlersMap
            .size());
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *   &lt;!-- This is well formed configuration: the handlers property is absent--&gt;
     *   &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *       &lt;Property name=&quot;reuse&quot;&gt;
     *            &lt;Value&gt;true&lt;/Value&gt;
     *       &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy9() throws Exception {
        UnitTestsHelper.loadConfig("valid8.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 0, handlersMap
            .size());
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *    &lt;!-- This is well formed configuration: all properties is absent--&gt;
     *    &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *    &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy10() throws Exception {
        UnitTestsHelper.loadConfig("valid9.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 0, handlersMap
            .size());
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *  &lt;!-- This is well formed configuration: the XMIhandler only have one-argument(XMIReader) constructor--&gt;
     *  &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *     &lt;Property name=&quot;reuse&quot;&gt;
     *         &lt;Value&gt;true&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;handlers&quot;&gt;
     *          &lt;Property name=&quot;UML:Class&quot;&gt;
     *               &lt;Value&gt;com.topcoder.xmi.reader.handlers.NoArgumentCtorAbsentdHandler&lt;/Value&gt;
     *          &lt;/Property&gt;
     *      &lt;/Property&gt;
     *  &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy11() throws Exception {
        UnitTestsHelper.loadConfig("valid10.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        // only 2 handler but three mapping
        assertEquals("Failed to create handlers from the configuration file.", 1, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == NoArgumentCtorAbsentdHandler.class);
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() accuracy. The default namespace exists:
     *
     * <pre>
     *  &lt;!-- This is well formed configuration: create a handler with no argument constructor diabled--&gt;
     *  &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *       &lt;Property name=&quot;reuse&quot;&gt;
     *           &lt;Value&gt;true&lt;/Value&gt;
     *       &lt;/Property&gt;
     *       &lt;Property name=&quot;handlers&quot;&gt;
     *            &lt;Property name=&quot;UML:Class&quot;&gt;
     *                &lt;Value&gt;com.topcoder.xmi.reader.handlers.NoArgumentCtorDisabledHandler&lt;/Value&gt;
     *            &lt;/Property&gt;
     *       &lt;/Property&gt;
     *  &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1Accuracy12() throws Exception {
        UnitTestsHelper.loadConfig("valid11.xml");
        XMIReader reader = new XMIReader();

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 1, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == NoArgumentCtorDisabledHandler.class);
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader() for failure. The default namespace exists but contains wrong
     * configuration for creating handlers: the handlerClass does not exist.
     * XMIReaderConfigException is expected.
     *
     * <pre>
     *  &lt;!-- This is invalid configuration: one of the class name is invalid--&gt;
     *  &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *     &lt;Property name=&quot;reuse&quot;&gt;
     *         &lt;Value&gt;true&lt;/Value&gt;
     *     &lt;/Property&gt;
     *     &lt;Property name=&quot;handlers&quot;&gt;
     *         &lt;!--No such class--&gt;
     *         &lt;Property name=&quot;UML:Class&quot;&gt;
     *              &lt;Value&gt;com.topcoder.xmi.reader.handlers.NoSuchclass&lt;/Value&gt;
     *          &lt;/Property&gt;
     *     &lt;/Property&gt;
     *  &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1ForFailure1() throws Exception {
        UnitTestsHelper.loadConfig("invalid1.xml");
        try {
            new XMIReader();
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader() for failure. The default namespace exists but contains wrong
     * configuration for creating handlers: the handlerClass has no suitable constructor.
     * XMIReaderConfigException is expected.
     *
     * <pre>
     *  &lt;!-- This is invalid configuration: the handler have not constructor--&gt;
     *  &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *      &lt;Property name=&quot;reuse&quot;&gt;
     *           &lt;Value&gt;true&lt;/Value&gt;
     *      &lt;/Property&gt;
     *      &lt;Property name=&quot;handlers&quot;&gt;
     *           &lt;Property name=&quot;UML:Class&quot;&gt;
     *              &lt;Value&gt;com.topcoder.xmi.reader.handlers.NoSuitableCtorHandler&lt;/Value&gt;
     *           &lt;/Property&gt;
     *     &lt;/Property&gt;
     *  &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1ForFailure2() throws Exception {
        UnitTestsHelper.loadConfig("invalid2.xml");
        try {
            new XMIReader();
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader() for failure. The default namespace exists but contains wrong
     * configuration for creating handlers: the type is not of XMIHandlers. XMIReaderConfigException
     * is expected.
     *
     * <pre>
     *  &lt;!-- This is invalid configuration:The type is not XMIHandler--&gt;
     *  &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *      &lt;Property name=&quot;reuse&quot;&gt;
     *          &lt;Value&gt;true&lt;/Value&gt;
     *      &lt;/Property&gt;
     *      &lt;Property name=&quot;handlers&quot;&gt;
     *          &lt;Property name=&quot;UML:Class&quot;&gt;
     *            &lt;Value&gt;java.lang.String&lt;/Value&gt;
     *       &amp;  lt;/Property&gt;
     *      &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1ForFailure3() throws Exception {
        UnitTestsHelper.loadConfig("invalid3.xml");
        try {
            new XMIReader();
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace exists but contains wrong
     * configuration for creating handlers: the handlerClass have no constructor which can be
     * accessed. XMIReaderConfigException is expected.
     * </p>
     *
     * <pre>
     *  &lt;!-- This is invalid configuration:The constructor of handler can not be accessed--&gt;
     *  &lt;Config name=&quot;com.topcoder.xmi.reader.XMIReader&quot;&gt;
     *      &lt;Property name=&quot;reuse&quot;&gt;
     *          &lt;Value&gt;true&lt;/Value&gt;
     *      &lt;/Property&gt;
     *      &lt;Property name=&quot;handlers&quot;&gt;
     *          &lt;Property name=&quot;UML:Class&quot;&gt;
     *            &lt;Value&gt;com.topcoder.xmi.reader.handlers.CanNotAccessedCtorHandler&lt;/Value&gt;
     *       &amp;  lt;/Property&gt;
     *      &lt;/Property&gt;
     *   &lt;/Config&gt;
     * </pre>
     *
     * @throws Exception when error occurs
     */
    public void testCtor1ForFailure4() throws Exception {
        UnitTestsHelper.loadConfig("invalid4.xml");
        try {
            new XMIReader(XMIReader.DEFAULT_NAMESPACE);
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy2 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy1() throws Exception {
        UnitTestsHelper.loadConfig("valid1.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy3 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy2() throws Exception {
        UnitTestsHelper.loadConfig("valid2.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy4 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy3() throws Exception {
        UnitTestsHelper.loadConfig("valid3.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy5 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy4() throws Exception {
        UnitTestsHelper.loadConfig("valid4.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Stereotype").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") != handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy6 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy5() throws Exception {
        UnitTestsHelper.loadConfig("valid5.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Stereotype").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") != handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy7 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy6() throws Exception {
        UnitTestsHelper.loadConfig("valid6.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 3, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == MockClassCountingXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Interface").getClass() == MockClassSimpleXMIHandler.class);
        assertTrue("Failed to create handlers from the configuration file.", handlersMap
            .get("UML:Stereotype") == handlersMap.get("UML:Class"));
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy8 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy7() throws Exception {
        UnitTestsHelper.loadConfig("valid7.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 0, handlersMap
            .size());
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy9 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy8() throws Exception {
        UnitTestsHelper.loadConfig("valid8.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 0, handlersMap
            .size());
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy10 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy9() throws Exception {
        UnitTestsHelper.loadConfig("valid9.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 0, handlersMap
            .size());
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy11 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy10() throws Exception {
        UnitTestsHelper.loadConfig("valid10.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        // only 2 handler but three mapping
        assertEquals("Failed to create handlers from the configuration file.", 1, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == NoArgumentCtorAbsentdHandler.class);
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for accuracy. See the method document of
     * testCtor1Accuracy12 for the testing configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2Accuracy11() throws Exception {
        UnitTestsHelper.loadConfig("valid11.xml");
        XMIReader reader = new XMIReader(XMIReader.DEFAULT_NAMESPACE);

        // checks creation
        assertNotNull("Failed to create XMIReader.", reader);
        // checks the fields
        Map<String, XMIHandler> handlersMap = (Map<String, XMIHandler>) UnitTestsHelper
            .getObjectFieldValue(reader, "handlers");
        assertEquals("Failed to create handlers from the configuration file.", 1, handlersMap
            .size());
        assertTrue("Failed to create handlers from the configuration file.", handlersMap.get(
            "UML:Class").getClass() == NoArgumentCtorDisabledHandler.class);
        assertForInitialFields(reader);
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace exists but contains wrong
     * configuration for creating handlers: the handlerClass does not exist.
     * XMIReaderConfigException is expected. See the method document of testCtor1ForFailure1 for the
     * configuration.
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure1() throws Exception {
        UnitTestsHelper.loadConfig("invalid1.xml");
        try {
            new XMIReader(XMIReader.DEFAULT_NAMESPACE);
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace exists but contains wrong
     * configuration for creating handlers: the handlerClass have no suitable constructor.
     * XMIReaderConfigException is expected. See the method document of testCtor1ForFailure2 for the
     * configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure2() throws Exception {
        UnitTestsHelper.loadConfig("invalid2.xml");
        try {
            new XMIReader(XMIReader.DEFAULT_NAMESPACE);
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace exists but contains wrong
     * configuration for creating handlers: the type is not of XMIHandlers. XMIReaderConfigException
     * is expected. See the method document of testCtor1ForFailure3 for the configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure3() throws Exception {
        UnitTestsHelper.loadConfig("invalid3.xml");
        try {
            new XMIReader(XMIReader.DEFAULT_NAMESPACE);
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace doesn't exist.
     * XMIReaderConfigException is expected.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure4() throws Exception {
        UnitTestsHelper.unloadConfig();
        try {
            new XMIReader(XMIReader.DEFAULT_NAMESPACE);
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure5() throws Exception {
        try {
            new XMIReader(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace is empty string.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure6() throws Exception {
        try {
            new XMIReader("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace is trimmed empty string.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure7() throws Exception {
        try {
            new XMIReader("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * <p>
     * Test of constructor: XMIReader(String) for failure. The namespace exists but contains wrong
     * configuration for creating handlers: the handlerClass have no constructor which can be
     * accessed. XMIReaderConfigException is expected. See the method document of
     * testCtor1ForFailure4 for the configuration.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor2ForFailure8() throws Exception {
        UnitTestsHelper.loadConfig("invalid4.xml");
        try {
            new XMIReader(XMIReader.DEFAULT_NAMESPACE);
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmie) {
            // good
        }
    }
}
