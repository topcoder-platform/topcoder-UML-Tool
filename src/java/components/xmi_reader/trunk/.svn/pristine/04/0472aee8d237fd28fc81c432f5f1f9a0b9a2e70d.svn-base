/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import com.topcoder.xmi.reader.handlers.MockClassCountingXMIHandler;

import junit.framework.TestCase;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

import org.xml.sax.SAXException;

/**
 * <p>
 * Unit test cases for class XMIReader's parse methods. When testing the IllegalStateException, a
 * mock implementation of XMIHandler is used.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class XMIReaderParseMethodsUnitTests extends TestCase {
    /** The sample xmi file. */
    private static final String XMI_FILE = "test_files" + File.separator + "sample.xmi";

    /** The zipFile. */
    private static final String ZIP_FILE = "test_files" + File.separator + "sample.zuml";

    /** File uri prefix. */
    private static final String FILE_URI_PREFIX = "file:///";

    /** XMIReader instance for testing. Created in setUp method with no handler inside. */
    private XMIReader reader;

    /**
     * The MockClassCountingXMIHandler for testing.  Created in setUp method.
     */
    private MockClassCountingXMIHandler handler;

    /**
     * Sets up testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        reader = new XMIReader();
        handler = new MockClassCountingXMIHandler();
    }

    /**
     * Test of parse with file argument for accuracy. See the test_files/sample.xmi for more detail.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithFileArgumentAccuracy1() throws Exception {
        reader.addHandler("UML:Class", handler);

        // only two properties with qName "UML:Class" in test_files/sample.xmi
        // the handler will be called twice for endElement and startElement.
        reader.parse(new File(XMI_FILE));
        validateResultOfCountingXMIHandlerForXMIFILE(handler);
    }

    /**
     * <p>
     * Test of parse with file argument for accuracy: the foundElements and forwardReferences will
     * be cleared when the parse is call. currentDelegatingHandler will be set to null too.
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testParseWithFileArgumentAccuracy2() throws Exception {
        reader.addHandler("UML:Class", handler);
        reader.putElement("1", new Object());
        reader.putElementProperty("2", "2", new Object());

        // only two properties with qName "UML:Class" in test_files/sample.xmi
        // the handler will be called twice for endElement and startElement.
        reader.parse(new File(XMI_FILE));
        // checks the foundElements and forwardReferences
        assertEquals("Failed to implement parse with file argument.", 0,
            ((Map<String, Object>) UnitTestsHelper.getObjectFieldValue(reader, "foundElements"))
                .size());
        assertEquals("Failed to implement parse with file argument.", 0,
            ((Map<String, Map<String, List>>) UnitTestsHelper.getObjectFieldValue(reader,
                    "forwardReferences")).size());
        assertNull("Failed to implement parse with file argument.", UnitTestsHelper
            .getObjectFieldValue(reader, "currentDelegatingHandler"));
    }

    /**
     * Test of parse with file for failure: null input. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithFileArgumentWithNullInput() throws Exception {
        try {
            reader.parse((File) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parse with file for failure: file does not exist. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithFileArgumentWithNonExistingFile() throws Exception {
        try {
            reader.parse(new File("NoSuchFile"));
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parse with file for failure: input is directory. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithFileArgumentWithDirectory() throws Exception {
        try {
            reader.parse(new File("test_files" + File.separator + "empty_direcory"));
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parse with file for failure: Parsing fails. XMIReaderParseException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithFileArgumentWithParstingFail() throws Exception {
        reader.addHandler("UML:Class", handler);
        handler.exceptionFlag_startDocument = true;

        try {
            reader.parse(new File(XMI_FILE));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException xmie) {
            // good
        }
    }

    /**
     * Test of parse with file for failure: calls it while parsing is in progress.
     * IllegalStateException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithFileArgumentWithParstingInProgress() throws Exception {
        // here is the anonymous class as the subclass of MockClassCountingXMIHandler
        // when parsing start, the method startDocument will be called.
        handler = new MockClassCountingXMIHandler() {
            /**
             * Mock the startDocument method to call parse with file argument while parsing.
             *
             * @throws SAXException when exceptionFlag_startDocument is true
             */
            public void startDocument() throws SAXException {
                try {
                    this.getXMIReader().parse(new File(XMI_FILE));
                    fail("IllegalStateException is expected.");
                } catch (Exception e) {
                    // the Exception is IllegalStateException
                    assertTrue("IllegalStateException is expected.",
                        e.getClass() == IllegalStateException.class);
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
        assertEquals("Failed to test parse with file argument for IllegalStateException.", 1,
            handler.count_startDocument);
    }

    /**
     * Test of parse with InputStream argument for accuracy. See the test_files/sample.xmi for more
     * detail.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithInputStreamArgumentAccuracy1() throws Exception {
        reader.addHandler("UML:Class", handler);

        // only two properties with qName "UML:Class" in test_files/sample.xmi
        // the handler will be called twice for endElement and startElement.
        reader.parse(new FileInputStream(new File(XMI_FILE)));
        validateResultOfCountingXMIHandlerForXMIFILE(handler);
    }

    /**
     * Test of parse with InputStream argument for accuracy: the foundElements and forwardReferences
     * are cleared. currentDelegatingHandler will be set to null too.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithInputStreamArgumentAccuracy2() throws Exception {
        reader.addHandler("UML:Class", handler);
        reader.putElement("1", new Object());
        reader.putElementProperty("2", "2", new Object());

        // only two properties with qName "UML:Class" in test_files/sample.xmi
        // the handler will be called twice for endElement and startElement.
        reader.parse(new FileInputStream(new File(XMI_FILE)));
        // checks the foundElements and forwardReferences
        assertEquals("Failed to implement parse with InputStream argument.", 0,
            ((Map<String, Object>) UnitTestsHelper.getObjectFieldValue(reader, "foundElements"))
                .size());
        assertEquals("Failed to implement parse with InputStream argument.", 0,
            ((Map<String, Map<String, List>>) UnitTestsHelper.getObjectFieldValue(reader,
                    "forwardReferences")).size());
        assertNull("Failed to implement parse with InputStream argument.", UnitTestsHelper
            .getObjectFieldValue(reader, "currentDelegatingHandler"));
    }

    /**
     * Test of parse with inputStream for failure: null inputStream. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithInputStreamArgumentWithNullInput() throws Exception {
        try {
            reader.parse((FileInputStream) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parse with inputStream for failure: the input stream is closed.
     * XMIReaderParseException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithInputStreamArgumentWithInputStringClosed() throws Exception {
        FileInputStream stream = new FileInputStream(new File(XMI_FILE));
        stream.close();

        try {
            reader.parse(stream);
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException xmirpe) {
            // good
        }
    }

    /**
     * Test of parse with inputStream for failure: the parsing fails. XMIReaderParseException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithInputStreamArgumentWithParsingFail() throws Exception {
        reader.addHandler("UML:Class", handler);
        handler.exceptionFlag_startDocument = true;

        try {
            reader.parse(new FileInputStream(new File(XMI_FILE)));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException xmirpe) {
            // good
        }
    }

    /**
     * Test of parse with inputStream for failure: calls it while parsing is in progress.
     * IllegalStateException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithInputStreamArgumentWithParsingInProgress() throws Exception {
        // here is the anonymous class as the subclass of MockClassCountingXMIHandler
        // when parsing start, the method startDocument will be called.
        handler = new MockClassCountingXMIHandler() {
            /**
             * Mock the startDocument method to call parse with inputStream argument while parsing.
             *
             * @throws SAXException when exceptionFlag_startDocument is true
             */
            public void startDocument() throws SAXException {
                try {
                    this.getXMIReader().parse(new FileInputStream(new File(XMI_FILE)));
                    fail("IllegalStateException is expected.");
                } catch (Exception e) {
                    // the Exception is IllegalStateException
                    assertTrue("IllegalStateException is expected.",
                        e.getClass() == IllegalStateException.class);
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
        assertEquals("Failed to test parse with inputStream argument for IllegalStateException.",
            1, handler.count_startDocument);
    }

    /**
     * Test of parseZipFile for accuracy. See the test_files/sample.zuml for more detail.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileAccuracy1() throws Exception {
        reader.addHandler("UML:Class", handler);

        // only two properties with qName "UML:Class" in test_files/sample.zuml/sample.xmi
        // the handler will be called twice for endElement and startElement.
        reader.parseZipFile(ZIP_FILE);
        validateResultOfCountingXMIHandlerForXMIFILE(handler);
    }

    /**
     * Test of parseZipFile for accuracy: two xmi file in zip file. Only one will be parsed. See the
     * test_files/two.zmul for more detail.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileAccuracy2() throws Exception {
        reader.addHandler("UML:Class", handler);

        // only two properties with qName "UML:Class" in test_files/two.zuml/sample.xmi
        // and test_files/two.zuml/other.xmi. But only one will be parsed
        // the handler will be called twice for endElement and startElement.
        reader.parseZipFile("test_files" + File.separator + "two.zuml");
        validateResultOfCountingXMIHandlerForXMIFILE(handler);
    }

    /**
     * Test of parseZipFile for accuracy: the foundElements and forwardReferences will be cleared.
     * currentDelegatingHandler will be set to null too.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileAccuracy3() throws Exception {
        reader.addHandler("UML:Class", handler);
        reader.putElement("1", new Object());
        reader.putElementProperty("2", "2", new Object());

        // only two properties with qName "UML:Class" in test_files/two.zuml/sample.xmi
        // and test_files/two.zuml/other.xmi. But only one will be parsed
        // the handler will be called twice for endElement and startElement.
        reader.parseZipFile("test_files" + File.separator + "two.zuml");
        // checks the foundElements and forwardReferences
        assertEquals("Failed to implement parseZipFile.", 0, ((Map<String, Object>) UnitTestsHelper
            .getObjectFieldValue(reader, "foundElements")).size());
        assertEquals("Failed to implement parseZipFile.", 0,
            ((Map<String, Map<String, List>>) UnitTestsHelper.getObjectFieldValue(reader,
                    "forwardReferences")).size());
        assertNull("Failed to implement parseZipFile.", UnitTestsHelper.getObjectFieldValue(reader,
            "currentDelegatingHandler"));

    }

    /**
     * Test of parseZipFilefor for failure: null input. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithNullInput() throws Exception {
        try {
            reader.parseZipFile(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: empty string input. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithEmptyStringInput() throws Exception {
        try {
            reader.parseZipFile("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: trimmed empty string input. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithTrimmedEmptyStringInput() throws Exception {
        try {
            reader.parseZipFile("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: No such file. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithNoSuchFile() throws Exception {
        try {
            reader.parseZipFile("NoSuchFile");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: input is directory. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithDirectory() throws Exception {
        try {
            reader.parseZipFile("test_files" + File.separator + "empty_direcory");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: file can not be unZipped. XMIReaderIOException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithFileUnZippedFail() throws Exception {
        try {
            reader.parseZipFile("test_files" + File.separator + "empty");
            fail("XMIReaderIOException is expected.");
        } catch (XMIReaderIOException xmirioe) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: the parsing fails. XMIReaderParseException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithParsingFail() throws Exception {
        reader.addHandler("UML:Class", handler);
        handler.exceptionFlag_startDocument = true;

        try {
            reader.parseZipFile(ZIP_FILE);
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException xmirpe) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: zip File contain no xmi file. XMIReaderParseException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithNoXMIFile() throws Exception {
        reader.addHandler("UML:Class", handler);
        try {
            reader.parseZipFile("test_files" + File.separator + "empty.zuml");
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException xmirpe) {
            // good
        }
    }

    /**
     * Test of parseZipFile for failure: calls it while parsing is in progress.
     * IllegalStateException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseZipFileWithParstingInProgress() throws Exception {
        // here is the anonymous class as the subclass of MockClassCountingXMIHandler
        // when parsing start, the method startDocument will be called.
        handler = new MockClassCountingXMIHandler() {
            /**
             * Mock the startDocument method to call parseZipFile while parsing.
             *
             * @throws SAXException when exceptionFlag_startDocument is true
             */
            public void startDocument() throws SAXException {
                try {
                    this.getXMIReader().parseZipFile(ZIP_FILE);
                    fail("IllegalStateException is expected.");
                } catch (Exception e) {
                    // the Exception is IllegalStateException
                    assertTrue("IllegalStateException is expected.",
                        e.getClass() == IllegalStateException.class);
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
        assertEquals("Failed to test parseZipFile for IllegalStateException.", 1,
            handler.count_startDocument);
    }

    /**
     * Test of parse with uri argument for accuracy. See the test_files/sample.xmi for more detail.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentAccuracy1() throws Exception {
        reader.addHandler("UML:Class", handler);

        String uri = FILE_URI_PREFIX + new File(XMI_FILE).getAbsolutePath();

        // only two properties with qName "UML:Class" in test_files/sample.xmi
        // the handler will be called twice for endElement and startElement.
        reader.parse(uri);
        validateResultOfCountingXMIHandlerForXMIFILE(handler);
    }

    /**
     * Test of parse with uri argument for accuracy: the foundElements and forwardReferences will be
     * cleared. currentDelegatingHandler will be set to null to.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentAccuracy2() throws Exception {
        reader.addHandler("UML:Class", handler);
        reader.putElement("1", new Object());
        reader.putElementProperty("2", "2", new Object());

        String uri = FILE_URI_PREFIX + new File(XMI_FILE).getAbsolutePath();

        // only two properties with qName "UML:Class" in test_files/sample.xmi
        // the handler will be called twice for endElement and startElement.
        reader.parse(uri);
        // checks the foundElements and forwardReferences
        assertEquals("Failed to implement parse with uri argument.", 0,
            ((Map<String, Object>) UnitTestsHelper.getObjectFieldValue(reader, "foundElements"))
                .size());
        assertEquals("Failed to implement parse with uri argument.", 0,
            ((Map<String, Map<String, List>>) UnitTestsHelper.getObjectFieldValue(reader,
                    "forwardReferences")).size());
        assertNull("Failed to implement parse with uri argument.", UnitTestsHelper
            .getObjectFieldValue(reader, "currentDelegatingHandler"));
    }

    /**
     * Test of parse with uri for failure: null input. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentWithNullInput() throws Exception {
        try {
            reader.parse((String) null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parse with uri for failure: empty string input. IllegalArgumentException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentWithEmptyStringInput() throws Exception {
        try {
            reader.parse("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parse with uri for failure: trimmed empty string input. IllegalArgumentException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentWithTrimmedEmptyStringInput() throws Exception {
        try {
            reader.parse("  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of parse with uri for failure: The uri is not a valid one. XMIReaderConfigException is
     * expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentWithInvalidUri() throws Exception {
        try {
            reader.parse("invalid");
            fail("XMIReaderConfigException is expected.");
        } catch (XMIReaderConfigException xmirce) {
            // good
        }
    }

    /**
     * Test of parse with uri for failure: the parsing fails. XMIReaderParseException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentWithParsingFail() throws Exception {
        reader.addHandler("UML:Class", handler);
        handler.exceptionFlag_startDocument = true;

        try {
            reader.parse(FILE_URI_PREFIX + new File(XMI_FILE).getAbsolutePath());
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException xmirpe) {
            // good
        }
    }

    /**
     * Test of parse with uri for failure: calls it while parsing is in progress.
     * IllegalStateException is expected.
     *
     * @throws Exception when error occurs
     */
    public void testParseWithUriArgumentWithParstingInProgress() throws Exception {
        // here is the anonymous class as the subclass of MockClassCountingXMIHandler
        // when parsing start, the method startDocument will be called.
        handler = new MockClassCountingXMIHandler() {
            /**
             * Mock the startDocument method to call parse with uri argument while parsing.
             *
             * @throws SAXException when exceptionFlag_startDocument is true
             */
            public void startDocument() throws SAXException {
                try {
                    this.getXMIReader().parse(
                        FILE_URI_PREFIX + new File(XMI_FILE).getAbsolutePath());
                    fail("IllegalStateException is expected.");
                } catch (Exception e) {
                    // the Exception is IllegalStateException
                    assertTrue("IllegalStateException is expected.",
                        e.getClass() == IllegalStateException.class);
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
        assertEquals("Failed to test parse with uri argument for IllegalStateException.", 1,
            handler.count_startDocument);
    }

    /**
     * This is the method to check the result of parsing test_files/sample.xmi or
     * test_files/sample.zuml/sample.xmi for MockClassCountingXMIHandler instance with key
     * "UML:Class".
     *
     * @param handler the handler to check
     */
    private void validateResultOfCountingXMIHandlerForXMIFILE(MockClassCountingXMIHandler handler) {
        assertEquals("Failed to parse.", 1, handler.count_startDocument);
        assertEquals("Failed to parse.", 1, handler.count_endDocument);

        assertEquals("Failed to parse.", 2, handler.count_startElement);
        assertEquals("Failed to parse.", 2, handler.count_endElement);

        assertEquals("Failed to parse.", 0, handler.count_characters);
        assertEquals("Failed to parse.", 0, handler.count_ignorableWhitespace);
        assertEquals("Failed to parse.", 0, handler.count_processingInstruction);
    }
}
