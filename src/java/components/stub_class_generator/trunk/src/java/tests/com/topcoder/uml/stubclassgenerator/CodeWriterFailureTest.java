/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import junit.framework.TestCase;

/**
 * Failure test for the <code>CodeWriter</code> class.
 *
 * @author vividmxx
 * @version 1.0
 */
public class CodeWriterFailureTest extends TestCase {

    /**
     * Represents the <code>CodeWriter</code> instance used to test against.
     */
    private CodeWriter codeWriter = null;

    /**
     * Sets up the test environment.
     */
    protected void setUp() {
        codeWriter = new CodeWriter();
    }

    /**
     * Test the method <code>existDirectory(String)</code> with null location. IllegalArgumentException should be
     * thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testExistDirectoryWithNullLocation() throws Exception {
        try {
            codeWriter.existDirectory(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>existDirectory(String)</code> with empty location. IllegalArgumentException should be
     * thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testExistDirectoryWithEmptyLocation() throws Exception {
        try {
            codeWriter.existDirectory("  ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>createDirectory(String, String)</code> with null location. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testCreateDirectoryWithNullLocation() throws Exception {
        try {
            codeWriter.createDirectory(null, "com.topcoder");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>createDirectory(String, String)</code> with empty location. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testCreateDirectoryWithEmptyLocation() throws Exception {
        try {
            codeWriter.createDirectory("  ", "com.topcoder");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>createDirectory(String, String)</code> with null path. IllegalArgumentException should be
     * thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testCreateDirectoryWithNullPath() throws Exception {
        try {
            codeWriter.createDirectory("src", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>deleteDirectory(String, boolean)</code> with null location. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testDeleteDirectoryWithNullLocation() throws Exception {
        try {
            codeWriter.deleteDirectory(null, true);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>deleteDirectory(String, boolean)</code> with empty location. IllegalArgumentException
     * should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testDeleteDirectoryWithEmptyLocation() throws Exception {
        try {
            codeWriter.deleteDirectory("  ", true);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>writeFile(String, String, String, String)</code> with null location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testWriteFileWithNullLocation() throws Exception {
        try {
            codeWriter.writeFile(null, "com.topcoder", "Program.cs", "void main(){}");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>writeFile(String, String, String, String)</code> with empty location.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testWriteFileWithEmptyLocation() throws Exception {
        try {
            codeWriter.writeFile("  ", "com.topcoder", "Program.cs", "void main(){}");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>writeFile(String, String, String, String)</code> with null packageName.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testWriteFileWithNullPackageName() throws Exception {
        try {
            codeWriter.writeFile("src", null, "Program.cs", "void main(){}");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>writeFile(String, String, String, String)</code> with null fileName.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testWriteFileWithNullFileName() throws Exception {
        try {
            codeWriter.writeFile("src", "com.topcoder", null, "void main(){}");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>writeFile(String, String, String, String)</code> with empty fileName.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testWriteFileWithEmptyFileName() throws Exception {
        try {
            codeWriter.writeFile("src", "com.topcoder", "  ", "void main(){}");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>writeFile(String, String, String, String)</code> with null content.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testWriteFileWithNullContent() throws Exception {
        try {
            codeWriter.writeFile("src", "com.topcoder", "Program.cs", null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test the method <code>writeFile(String, String, String, String)</code> with empty content.
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception
     *             throws to JUnit
     */
    public void testWriteFileWithEmptyContent() throws Exception {
        try {
            codeWriter.writeFile("src", "com.topcoder", "Program.cs", "  ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
