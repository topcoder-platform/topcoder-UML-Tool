/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager;

import com.topcoder.util.log.Level;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for Util.
 * </p>
 *
 * @author biotrail
 * @version 1.0
 */
public class UtilTests extends TestCase {
    /**
     * <p>
     * MyLogger instance for testing.
     * </p>
     */
    private MyLogger logger;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     */
    protected void setUp() {
        logger = new MyLogger("MyLogger");
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     */
    protected void tearDown() {
        logger = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(UtilTests.class);
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) method.
     * It test the case when a not null object is passed in and expects success.
     * </p>
     */
    public void testCheckNull_NotNullObject() {
        Util.checkNull("", "test");
    }

    /**
     * <p>
     * Tests Util#checkNull(Object,String) method.
     * It test the case when a null object is passed in and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckNull_NullObject() {
        try {
            Util.checkNull(null, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) method.
     * It test the case when a not null and not empty string is passed in and expects success.
     * </p>
     */
    public void testCheckString_NotNullNotEmptyString() {
        Util.checkString("test", "test");
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) method.
     * It test the case when a null string is passed in and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_NullString() {
        try {
            Util.checkString(null, "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#checkString(String,String) method.
     * It test the case when an empty string is passed in and expects IllegalArgumentException.
     * </p>
     */
    public void testCheckString_EmptyString() {
        try {
            Util.checkString("", "test");
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String,boolean) method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGetString() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        try {
            String value = Util.getString(TestHelper.LOG_NAMESPACE, "logClass", true);

            assertEquals("Failed to get correct property value from configuration manager.",
                "com.topcoder.util.log.basic.BasicLog", value);
        } finally {

            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String,boolean) for failure.
     * It tests the case that property is missing and it's optional.
     * </p>
     *
     * @throws Exception to JUit.
     */
    public void testGetString_OptionalProperty() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        try {
            String value = Util.getString(TestHelper.LOG_NAMESPACE, "NotExistProperty", false);

            assertNull("Expects null property value.", value);
        } finally {

            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests Util#getString(String,String,boolean) for failure.
     * It tests the case that property is missing but it's required, expects ConfigManagerException.
     * </p>
     *
     * @throws Exception to JUit.
     */
    public void testGetString_RequiredProperty() throws Exception {
        TestHelper.loadSingleXMLConfig(TestHelper.LOG_NAMESPACE, TestHelper.LOG_CONFIGFILE);

        try {
            Util.getString(TestHelper.LOG_NAMESPACE, "NotExistProperty", true);
            fail("ConfigManagerException expected.");
        } catch (ActionManagerConfigurationException e) {
            //good
        } finally {
            TestHelper.clearConfigFile(TestHelper.LOG_NAMESPACE);
        }
    }

    /**
     * <p>
     * Tests the method Util#logErrorMsg(Log,Level,Exception).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is OFF and expects no message be logged in ERROR level.
     * </p>
     */
    public void testLogErrorMsgInOffLoggingLevel() {
        Util.logErrorMsg(logger, Level.OFF, new IllegalArgumentException("exception"));

        assertEquals("Expects no log information in ERROR level.", 0, logger.getErrorMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logErrorMsg(Log,Level,Exception).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is ERRO and expects the message be logged in ERROR level.
     * </p>
     */
    public void testLogErrorMsgInErrorLoggingLevel() {
        Util.logErrorMsg(logger, Level.ERROR, new IllegalArgumentException("exception"));

        assertFalse("Expects error message is logged in ERROR level.", logger.getErrorMsgs().isEmpty());
    }

    /**
     * <p>
     * Tests the method Util#logErrorMsg(Log,Level,Exception).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is WARN and expects the message be logged in ERROR level.
     * </p>
     */
    public void testLogErrorMsgInWarnLoggingLevel() {
        Util.logErrorMsg(logger, Level.WARN, new IllegalArgumentException("exception"));

        assertFalse("Expects error message is logged in ERROR level.", logger.getErrorMsgs().isEmpty());
    }

    /**
     * <p>
     * Tests the method Util#logErrorMsg(Log,Level,Exception).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is INFO and expects the message be logged in ERROR level.
     * </p>
     */
    public void testLogErrorMsgInInfoLoggingLevel() {
        Util.logErrorMsg(logger, Level.INFO, new IllegalArgumentException("exception"));

        assertFalse("Expects error message is logged in ERROR level.", logger.getErrorMsgs().isEmpty());
    }

    /**
     * <p>
     * Tests the method Util#logErrorMsg(Log,Level,Exception).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is DEBUG and expects the message be logged in ERROR level.
     * </p>
     */
    public void testLogErrorMsgInDebugLoggingLevel() {
        Util.logErrorMsg(logger, Level.DEBUG, new IllegalArgumentException("exception"));

        assertFalse("Expects error message is logged in ERROR level.", logger.getErrorMsgs().isEmpty());
    }

    /**
     * <p>
     * Tests the method Util#logErrorMsg(Log,Level,Exception).
     * </p>
     *
     * <p>
     * It tests the logger is null and expects no exception be thrown.
     * </p>
     */
    public void testLogErrorMsgWithNullLogger() {
        Util.logErrorMsg(null, Level.ERROR, new IllegalArgumentException("exception"));

        // no exception should be thrown
    }

    /**
     * <p>
     * Tests the method Util#logWarnMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is OFF and expects no message be logged in WARN level.
     * </p>
     */
    public void testLogWarnMsgInOffLoggingLevel() {
        Util.logWarnMsg(logger, Level.OFF, "message");

        assertEquals("Expects no log information in WARN level.", 0, logger.getWarnMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logWarnMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is ERROR and expects no message be logged in WARN level.
     * </p>
     */
    public void testLogWarnMsgInErrorLoggingLevel() {
        Util.logWarnMsg(logger, Level.ERROR, "message");

        assertEquals("Expects no log information in WARN level.", 0, logger.getWarnMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logWarnMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is WARN and expects the message be logged in WARN level.
     * </p>
     */
    public void testLogWarnMsgInWarnLoggingLevel() {
        Util.logWarnMsg(logger, Level.WARN, "message");

        assertEquals("Expects message is logged in WARN level.", 1, logger.getWarnMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logWarnMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is INFO and expects the message be logged in WARN level.
     * </p>
     */
    public void testLogWarnMsgInInfoLoggingLevel() {
        Util.logWarnMsg(logger, Level.INFO, "message");

        assertEquals("Expects message is logged in WARN level.", 1, logger.getWarnMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logWarnMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is DEBUG and expects the message be logged in WARN level.
     * </p>
     */
    public void testLogWarnMsgInDebugLoggingLevel() {
        Util.logWarnMsg(logger, Level.DEBUG, "message");

        assertEquals("Expects message is logged in WARN level.", 1, logger.getWarnMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logWarnMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the logger is null and expects no exception be thrown.
     * </p>
     */
    public void testLogWarnMsgWithNullLogger() {
        Util.logWarnMsg(null, Level.WARN, "message");

        // no exception should be thrown
    }

    /**
     * <p>
     * Tests the method Util#logInfoMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is OFF and expects no message be logged in INFO level.
     * </p>
     */
    public void testLogInfoMsgInOffLoggingLevel() {
        Util.logInfoMsg(logger, Level.OFF, "message");

        assertEquals("Expects no log information in INFO level.", 0, logger.getInfoMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logInfoMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is ERROR and expects no message be logged in INFO level.
     * </p>
     */
    public void testLogInfoMsgInErrorLoggingLevel() {
        Util.logInfoMsg(logger, Level.ERROR, "message");

        assertEquals("Expects no log information in INFO level.", 0, logger.getInfoMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logInfoMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is WARN and expects no message be logged in INFO level.
     * </p>
     */
    public void testLogInfoMsgInWarnLoggingLevel() {
        Util.logInfoMsg(logger, Level.WARN, "message");

        assertEquals("Expects no log information in INFO level.", 0, logger.getInfoMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logInfoMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is INFO and expects the message be logged in INFO level.
     * </p>
     */
    public void testLogInfoMsgInInfoLoggingLevel() {
        Util.logInfoMsg(logger, Level.INFO, "message");

        assertEquals("Expects the message is logged in INFO level.", 1, logger.getInfoMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logInfoMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is DEBUG and expects the message be logged in INFO level.
     * </p>
     */
    public void testLogInfoMsgInDebugLoggingLevel() {
        Util.logInfoMsg(logger, Level.DEBUG, "message");

        assertEquals("Expects the message is logged in INFO level.", 1, logger.getInfoMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logInfoMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the logger is null and expects no exception be thrown.
     * </p>
     */
    public void testLogInfoMsgWithNullLogger() {
        Util.logInfoMsg(null, Level.INFO, "message");

        // no exception should be thrown
    }

    /**
     * <p>
     * Tests the method Util#logDebugMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is OFF and expects no message be logged in DEBUG level.
     * </p>
     */
    public void testLogDebugMsgInOffLoggingLevel() {
        Util.logDebugMsg(logger, Level.OFF, "message");

        assertEquals("Expects no log information in DEBUG level.", 0, logger.getDebugMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logDebugMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is ERROR and expects no message be logged in DEBUG level.
     * </p>
     */
    public void testLogDebugMsgInErrorLoggingLevel() {
        Util.logDebugMsg(logger, Level.ERROR, "message");

        assertEquals("Expects no log information in DEBUG level.", 0, logger.getDebugMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logDebugMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is WARN and expects no message be logged in DEBUG level.
     * </p>
     */
    public void testLogDebugMsgInWarnLoggingLevel() {
        Util.logDebugMsg(logger, Level.WARN, "message");

        assertEquals("Expects no log information in DEBUG level.", 0, logger.getDebugMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logDebugMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is INFO and expects no message be logged in DEBUG level.
     * </p>
     */
    public void testLogDebugMsgInInfoLoggingLevel() {
        Util.logDebugMsg(logger, Level.INFO, "message");

        assertEquals("Expects no log information in DEBUG level.", 0, logger.getDebugMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logDebugMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the loggingLevel is DEBUG and expects the message be logged in DEBUG level.
     * </p>
     */
    public void testLogDebugMsgInDebugLoggingLevel() {
        Util.logDebugMsg(logger, Level.DEBUG, "message");

        assertEquals("Expects the message is logged in DEBUG level.", 1, logger.getDebugMsgs().size());
    }

    /**
     * <p>
     * Tests the method Util#logDebugMsg(Log,Level,String).
     * </p>
     *
     * <p>
     * It tests the logger is null and expects no exception be thrown.
     * </p>
     */
    public void testLogDebugMsgWithNullLogger() {
        Util.logDebugMsg(null, Level.DEBUG, "message");

        // no exception should be thrown
    }
}