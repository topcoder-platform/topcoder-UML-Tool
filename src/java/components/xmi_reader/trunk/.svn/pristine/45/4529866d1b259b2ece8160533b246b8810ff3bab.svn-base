/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader;

import junit.framework.TestCase;


/**
 * <p>
 * Unit test cases for class ReaderHelper.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ReaderHelperUnitTests extends TestCase {
    /**
     * Test of method validateNotNull with not Null object. All works well.
     */
    public void testValidateNotNullWithNotNullObject() {
        Object obj = new Object();
        assertEquals("Failed to implement validateNotNull.", obj,
            ReaderHelper.validateNotNull(obj, "test"));
    }

    /**
     * Test of method ValidateNotNull with Null object. IllegalArgumentException is expected.
     */
    public void testValidateNotNullWithNullObject() {
        try {
            ReaderHelper.validateNotNull(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of method validateEmpty with normal string. All works well.
     */
    public void testValidateEmptyWithNormalStrimg() {
        ReaderHelper.validateEmpty("123", "test");
    }

    /**
     * Test of method validateEmpty with null. All works well.
     */
    public void testValidateEmptyWithNull() {
        ReaderHelper.validateEmpty(null, "test");
    }

    /**
     * Test of method validateEmpty with empty string. IllegalArgumentException is expected.
     */
    public void testValidateEmptyWithEmptyString() {
        try {
            ReaderHelper.validateEmpty("", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of method validateEmpty with trimmed empty string. IllegalArgumentException is
     * expected.
     */
    public void testValidateEmptyWithTrimmedEmptyString() {
        try {
            ReaderHelper.validateEmpty("  ", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateString with normal string.
     */
    public void testValidateStringWithNormalString() {
        assertEquals("Failed to implement validateString.", "test",
            ReaderHelper.validateString("test", "test"));
    }

    /**
     * Test of validateString with empty string. IllegalArgumentException is expected.
     */
    public void testValidateStringWithEmptyString() {
        try {
            ReaderHelper.validateString("", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateString with trimmed empty string. IllegalArgumentException is expected.
     */
    public void testValidateStringWithTrimmedEmptyString() {
        try {
            ReaderHelper.validateString("  ", "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateString with null string. IllegalArgumentException is expected.
     */
    public void testValidateStringWithNullString() {
        try {
            ReaderHelper.validateString(null, "test");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with normal inputs. Expect returning qname.
     */
    public void testValidateLocalnameAndQnameWithNormalInputs() {
        assertEquals("Failed to implement validateLocalnameAndQname.", "2",
            ReaderHelper.validateLocalnameAndQname("1", "2"));
    }

    /**
     * Test of validateLocalnameAndQname with null localName. Expect returning qname.
     */
    public void testValidateLocalnameAndQnameWithNullLocalName() {
        assertEquals("Failed to implement validateLocalnameAndQname.", "2",
            ReaderHelper.validateLocalnameAndQname(null, "2"));
    }

    /**
     * Test of validateLocalnameAndQname with empty localName. Expect returning qname.
     */
    public void testValidateLocalnameAndQnameWithEmptyLocalName() {
        assertEquals("Failed to implement validateLocalnameAndQname.", "2",
            ReaderHelper.validateLocalnameAndQname("", "2"));
    }

    /**
     * Test of validateLocalnameAndQname with trimmed empty localName. Expect returning qname.
     */
    public void testValidateLocalnameAndQnameWithTrimmedEmptyLocalName() {
        assertEquals("Failed to implement validateLocalnameAndQname.", "2",
            ReaderHelper.validateLocalnameAndQname("  ", "2"));
    }

    /**
     * Test of validateLocalnameAndQname with null localName. Expect returning localName.
     */
    public void testValidateLocalnameAndQnameWithNullQname() {
        assertEquals("Failed to implement validateLocalnameAndQname.", "2",
            ReaderHelper.validateLocalnameAndQname("2", null));
    }

    /**
     * Test of validateLocalnameAndQname with empty localName. Expect returning localName.
     */
    public void testValidateLocalnameAndQnameWithEmptyQname() {
        assertEquals("Failed to implement validateLocalnameAndQname.", "2",
            ReaderHelper.validateLocalnameAndQname("2", ""));
    }

    /**
     * Test of validateLocalnameAndQname with trimmed empty localName. Expect returning localName.
     */
    public void testValidateLocalnameAndQnameWithTrimmedEmptyQname() {
        assertEquals("Failed to implement validateLocalnameAndQname.", "2",
            ReaderHelper.validateLocalnameAndQname("2", "  "));
    }

    /**
     * Test of validateLocalnameAndQname with Both name null. IllegalArgumentException is expected.
     */
    public void testValidateLocalnameAndQnameWithBothNamesNull() {
        try {
            ReaderHelper.validateLocalnameAndQname(null, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with localName null and qname empty.
     * IllegalArgumentException is expected.
     */
    public void testValidateLocalnameAndQnameWithNullLocalNameAndEmptyQname() {
        try {
            ReaderHelper.validateLocalnameAndQname(null, "");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with localName null and qname trimmed empty.
     * IllegalArgumentException is expected.
     */
    public void testValidateLocalnameAndQnameWithNullLocalNameAndTrimmedEmptyQname() {
        try {
            ReaderHelper.validateLocalnameAndQname(null, "  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with Both name empty. IllegalArgumentException is
     * expected.
     */
    public void testValidateLocalnameAndQnameWithBothNamesEmpty() {
        try {
            ReaderHelper.validateLocalnameAndQname("", "");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with localName empty and qname null.
     * IllegalArgumentException is expected.
     */
    public void testValidateLocalnameAndQnameWithEmptyLocalNameAndEmptyQname() {
        try {
            ReaderHelper.validateLocalnameAndQname("", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with localName empty and qname trimmed empty.
     * IllegalArgumentException is expected.
     */
    public void testValidateLocalnameAndQnameWithEmptyLocalNameAndTrimmedEmptyQname() {
        try {
            ReaderHelper.validateLocalnameAndQname("", "  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with Both name trimmed empty. IllegalArgumentException is
     * expected.
     */
    public void testValidateLocalnameAndQnameWithBothNamesTrimmedEmpty() {
        try {
            ReaderHelper.validateLocalnameAndQname("  ", "  ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with local name trimmed empty and qname empty.
     * IllegalArgumentException is expected.
     */
    public void testValidateLocalnameAndQnameWithLocalNameTrimmedEmptyAndQnameEmpty() {
        try {
            ReaderHelper.validateLocalnameAndQname("  ", "");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validateLocalnameAndQname with local name trimmed empty and qname null.
     * IllegalArgumentException is expected.
     */
    public void testValidateLocalnameAndQnameWithLocalNameTrimmedEmptyAndQnameNull() {
        try {
            ReaderHelper.validateLocalnameAndQname("  ", null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validaChaArrayAndBoundArgument with valid inputs. All works well.
     */
    public void testValidaChaArrayAndBoundArgumentWithValidInputs() {
        ReaderHelper.validaChaArrayAndBoundArgument(new char[10], 0, 10);
    }

    /**
     * Test of validaChaArrayAndBoundArgument with null ch. IllegalArgumentException is expected.
     */
    public void testValidaChaArrayAndBoundArgumentWithNullCh() {
        try {
            ReaderHelper.validaChaArrayAndBoundArgument(null, 0, 10);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validaChaArrayAndBoundArgument with negative start. IllegalArgumentException is
     * expected.
     */
    public void testValidaChaArrayAndBoundArgumentWithNegativeStart() {
        try {
            ReaderHelper.validaChaArrayAndBoundArgument(new char[10], -1, 10);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validaChaArrayAndBoundArgument with negative length. IllegalArgumentException is
     * expected.
     */
    public void testValidaChaArrayAndBoundArgumentWithNegativeLength() {
        try {
            ReaderHelper.validaChaArrayAndBoundArgument(new char[10], 0, -1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }

    /**
     * Test of validaChaArrayAndBoundArgument with invalid bound. IllegalArgumentException is
     * expected.
     */
    public void testValidaChaArrayAndBoundArgumentWithInvalidBound() {
        try {
            ReaderHelper.validaChaArrayAndBoundArgument(new char[10], 7, 5);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // good
        }
    }
}
