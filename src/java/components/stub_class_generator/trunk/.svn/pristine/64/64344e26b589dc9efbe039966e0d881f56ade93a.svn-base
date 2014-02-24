/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.stubclassgenerator;

import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;


/**
 * Unit tests for the class {@link CodeWriter}.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestCodeWriter extends TestCase {
    /**
     * The unit under test.
     */
    private CodeWriter uut;

    /**
     * Set up the fixture.
     *
     * @throws Exception
     *             to JUnit.
     */
    protected void setUp() throws Exception {
        super.setUp();
        this.uut = new CodeWriter();
    }

    /**
     * <b>Failure test</b> for method existDirectory(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testexistDirectoryStringFailureNullLocation()
        throws Exception {
        String location = null;

        try {
            this.uut.existDirectory(location);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method existDirectory(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;  &quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testexistDirectoryStringFailureEmptyLocation()
        throws Exception {
        String location = "  ";

        try {
            this.uut.existDirectory(location);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method existDirectory(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a directory
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testexistDirectoryStringAccuracyWithDir()
        throws Exception {
        assertTrue("should be directory", this.uut.existDirectory(TestHelper.createTempDir().getAbsolutePath()));
    }

    /**
     * <b>Accuracy test</b> for method existDirectory(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a file
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  false
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testexistDirectoryStringAccuracyWithFile()
        throws Exception {
        assertFalse("shouldn't be directory", this.uut.existDirectory(TestHelper.createTempFile().getAbsolutePath()));
    }

    /**
     * <b>Accuracy test</b> for method existDirectory(String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = non existing file
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  false
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testexistDirectoryStringAccuracyWithNonExisting()
        throws Exception {
        File f = TestHelper.createTempDir();
        f.delete();
        assertFalse("shouldn't be directory", this.uut.existDirectory(f.getAbsolutePath()));
    }

    /**
     * <b>Failure test</b> for method createDirectory(String, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = null
     *  packageName = &quot;com.topcoder&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateDirectoryStringStringFailureNullLocation()
        throws Exception {
        String location = null;
        String packageName = "com.topcoder";

        try {
            this.uut.createDirectory(location, packageName);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method createDirectory(String, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;  &quot;
     *  packageName = &quot;com.topcoder&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateDirectoryStringStringFailureEmptyLocation()
        throws Exception {
        String location = "  ";
        String packageName = "com.topcoder";

        try {
            this.uut.createDirectory(location, packageName);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method createDirectory(String, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;/home/tcs&quot;
     *  packageName = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateDirectoryStringStringFailureNullPackage()
        throws Exception {
        String location = "/home/tcs";
        String packageName = null;

        try {
            this.uut.createDirectory(location, packageName);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method createDirectory(String, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory
     *  packageName = &quot;com&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  tmp/com is created
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateDirectoryStringStringAccuracyValidOnePackage()
        throws Exception {
        File f = TestHelper.createTempDir();
        String location = f.getAbsolutePath();
        String packageName = "com";

        assertTrue("directory not created", this.uut.createDirectory(location, packageName));

        File com = new File(f, "com");
        assertTrue("com missing", com.isDirectory());

        com.delete();
    }

    /**
     * <b>Accuracy test</b> for method createDirectory(String, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory
     *  packageName = &quot;com.topcoder&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  tmp/com/topcoder is created
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateDirectoryStringStringAccuracyValidTwoPackages()
        throws Exception {
        File f = TestHelper.createTempDir();
        String location = f.getAbsolutePath();
        String packageName = "com.topcoder";

        assertTrue("directory not created", this.uut.createDirectory(location, packageName));

        File com = new File(f, "com");
        File topcoder = new File(com, "topcoder");
        assertTrue("com missing", com.isDirectory());
        assertTrue("topcoder missing", topcoder.isDirectory());

        topcoder.delete();
        com.delete();
    }

    /**
     * <b>Accuracy test</b> for method createDirectory(String, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a nen existing directory
     *  packageName = &quot;com.topcoder&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  tmp/com/topcoder is not created
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateDirectoryStringStringAccuracyMissingLocation()
        throws Exception {
        File f = TestHelper.createTempDir();
        String location = f.getAbsolutePath();
        String packageName = "com.topcoder";

        f.delete();

        assertFalse("directory created", this.uut.createDirectory(location, packageName));

        File com = new File(f, "com");
        File topcoder = new File(com, "topcoder");
        assertFalse("com created", com.isDirectory());
        assertFalse("topcoder created", topcoder.isDirectory());

        topcoder.delete();
        com.delete();
    }

    /**
     * <b>Failure test</b> for method createDirectory(String, String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory
     *  packageName = &quot;  &quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  no directories created
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testcreateDirectoryStringStringFailureEmptyPackage()
        throws Exception {
        File d = TestHelper.createTempDir();
        String location = d.getAbsolutePath();
        String packageName = "  ";

        assertFalse("directory created", this.uut.createDirectory(location, packageName));

        assertEquals("empty", 0, d.list().length);
    }

    /**
     * <b>Failure test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = null
     *  deleteCurrent = false
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanFailureNullLocation()
        throws Exception {
        String location = null;
        boolean deleteCurrent = false;

        try {
            this.uut.deleteDirectory(location, deleteCurrent);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;   &quot;
     *  deleteCurrent = false
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanFailureEmptyLocation()
        throws Exception {
        String location = "   ";
        boolean deleteCurrent = false;

        try {
            this.uut.deleteDirectory(location, deleteCurrent);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Accuracy test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory
     *  deleteCurrent = false
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanAccuracyEmptyLocation()
        throws Exception {
        File f = TestHelper.createTempDir();
        String location = f.getAbsolutePath();
        boolean deleteCurrent = false;
        assertTrue("not deleted", this.uut.deleteDirectory(location, deleteCurrent));
        assertTrue("location deleted", f.isDirectory());
    }

    /**
     * <b>Accuracy test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory containing one file
     *  deleteCurrent = false
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanAccuracyOneFile()
        throws Exception {
        File d = TestHelper.createTempDir();
        String location = d.getAbsolutePath();
        File f = TestHelper.createFileInDir(d, "myFile");

        assertTrue("f does not exist", f.exists());

        boolean deleteCurrent = false;
        assertTrue("not deleted", this.uut.deleteDirectory(location, deleteCurrent));
        assertFalse("f not deleted", f.exists());
        assertTrue("location deleted", d.isDirectory());
    }

    /**
     * <b>Accuracy test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory containing one file in sub directory
     *  deleteCurrent = false
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanAccuracyOneFileInSub()
        throws Exception {
        File locDir = TestHelper.createTempDir();
        String location = locDir.getAbsolutePath();
        File subDir = TestHelper.createDirectoryInDir(locDir, "subDir");
        File f = TestHelper.createFileInDir(subDir, "myFile");

        assertTrue("sub dir does not exist", subDir.isDirectory());
        assertTrue("f does not exist", f.exists());

        boolean deleteCurrent = false;
        assertTrue("not deleted", this.uut.deleteDirectory(location, deleteCurrent));
        assertFalse("sub dir not deleted", subDir.exists());
        assertFalse("f not deleted", f.exists());
        assertTrue("location deleted", locDir.isDirectory());
    }

    /**
     * <b>Accuracy test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory
     *  deleteCurrent = true
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanAccuracyDelLocEmptyLocation()
        throws Exception {
        File f = TestHelper.createTempDir();
        String location = f.getAbsolutePath();
        boolean deleteCurrent = true;
        assertTrue("not deleted", this.uut.deleteDirectory(location, deleteCurrent));
        assertFalse("location not deleted", f.exists());
    }

    /**
     * <b>Accuracy test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory containing one file
     *  deleteCurrent = true
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanAccuracyDelLocOneFile()
        throws Exception {
        File d = TestHelper.createTempDir();
        String location = d.getAbsolutePath();
        File f = TestHelper.createFileInDir(d, "myFile");

        assertTrue("f does not exist", f.exists());

        boolean deleteCurrent = true;
        assertTrue("not deleted", this.uut.deleteDirectory(location, deleteCurrent));
        assertFalse("f not deleted", f.exists());
        assertFalse("location not deleted", d.exists());
    }

    /**
     * <b>Accuracy test</b> for method deleteDirectory(String, boolean).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory containing one file in sub directory
     *  deleteCurrent = true
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  true
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testdeleteDirectoryStringBooleanAccuracyDelLocOneFileInSub()
        throws Exception {
        File locDir = TestHelper.createTempDir();
        String location = locDir.getAbsolutePath();
        File subDir = TestHelper.createDirectoryInDir(locDir, "subDir");
        File f = TestHelper.createFileInDir(subDir, "myFile");

        assertTrue("sub dir does not exist", subDir.isDirectory());
        assertTrue("f does not exist", f.exists());

        boolean deleteCurrent = true;
        assertTrue("not deleted", this.uut.deleteDirectory(location, deleteCurrent));
        assertFalse("sub dir not deleted", subDir.exists());
        assertFalse("f not deleted", f.exists());
        assertFalse("location not deleted", locDir.exists());
    }

    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = null
     *  packageName = &quot;com.topcoder&quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureNullLocation()
        throws Exception {
        String location = null;
        String packageName = "com.topcoder";
        String fileName = "Foo.java";
        String content = "class Foo{}";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;   &quot;
     *  packageName = &quot;com.topcoder&quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureEmptyLocation()
        throws Exception {
        String location = "   ";
        String packageName = "com.topcoder";
        String fileName = "Foo.java";
        String content = "class Foo{}";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;home/tcs&quot;
     *  packageName = &quot;com.topcoder&quot;
     *  fileName = null
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureNullFile()
        throws Exception {
        String location = "home/tcs";
        String packageName = "com.topcoder";
        String fileName = null;
        String content = "class Foo{}";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;home/tcs&quot;
     *  packageName = &quot;com.topcoder&quot;
     *  fileName = &quot;   &quot;
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureEmptyFile()
        throws Exception {
        String location = "home/tcs";
        String packageName = "com.topcoder";
        String fileName = "   ";
        String content = "class Foo{}";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;home/tcs&quot;
     *  packageName = &quot;com.topcoder&quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = null
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureNullContent()
        throws Exception {
        String location = "home/tcs";
        String packageName = "com.topcoder";
        String fileName = "Foo.java";
        String content = null;

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = &quot;home/tcs&quot;
     *  packageName = &quot;com.topcoder&quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = &quot;   &quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IllegalArgumentException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureEmptyContent()
        throws Exception {
        String location = "home/tcs";
        String packageName = "com.topcoder";
        String fileName = "Foo.java";
        String content = "   ";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IllegalArgumentException expected");
        } catch (IllegalArgumentException e) {
            // OK
        }
    }

    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = name of a directory
     *  packageName = &quot;com.topcoder&quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IOException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureFileIsDirectory()
        throws Exception {
        File dir = TestHelper.createTempDir();
        File file = TestHelper.createFileInDir(dir, "someFile");
        String location = dir.getAbsolutePath();
        String packageName = "com.topcoder";
        String fileName = "Foo.java";
        String content = "class Foo{}";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IOException expected");
        } catch (IOException e) {
            // OK
        }

        file.delete();
    }
    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = name of a directory
     *  packageName = &quot;    &quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IOException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureEmptyPackage()
        throws Exception {
        File dir = TestHelper.createTempDir();
        File file = TestHelper.createFileInDir(dir, "someFile");
        String location = dir.getAbsolutePath();
        String packageName = "   ";
        String fileName = "Foo.java";
        String content = "class Foo{}";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IOException expected");
        } catch (IOException e) {
            // OK
        }

        file.delete();
    }
    /**
     * <b>Failure test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  **************************** Faulty input **********************************
     *  ****************************************************************************
     *  location = name of a directory
     *  packageName = &quot;tc..topcoder&quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected behaviour *****************************
     *  ****************************************************************************
     *  * IOException should be thrown
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringFailureInvalidPackage()
        throws Exception {
        File dir = TestHelper.createTempDir();
        File file = TestHelper.createFileInDir(dir, "someFile");
        String location = dir.getAbsolutePath();
        String packageName = "tc..topcoder";
        String fileName = "Foo.java";
        String content = "class Foo{}";

        try {
            this.uut.writeFile(location, packageName, fileName, content);
            fail("IOException expected");
        } catch (IOException e) {
            // OK
        }

        file.delete();
    }

    /**
     * <b>Accuracy test</b> for method writeFile(String, String, String,
     * String).<br>
     *
     * <pre>
     *  ****************************************************************************
     *  ******************************* input **************************************
     *  ****************************************************************************
     *  location = a temporary directory
     *  packageName = &quot;com&quot;
     *  fileName = &quot;Foo.java&quot;
     *  content = &quot;class Foo{}&quot;
     *
     *  ****************************************************************************
     *  *************************** Expected output ********************************
     *  ****************************************************************************
     *  content is written to file
     * </pre>
     *
     * @throws Exception
     *             to JUnit.
     */
    public void testwriteFileStringStringStringStringAccuracyOnePackage()
        throws Exception {
        String location = TestHelper.createTempDir().getAbsolutePath();
        String packageName = "com";
        String fileName = "Foo.java";
        String content = "class Foo{}";

        this.uut.createDirectory(location, packageName);
        this.uut.writeFile(location, packageName, fileName, content);

        File com = new File(location, "com");
        File file = new File(com, fileName);
        String fileContent = TestHelper.readFile(file);
        assertEquals("content", content + TestHelper.LINE_SEPARATOR, fileContent);

        file.delete();
        com.delete();
    }
}
