/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains accuracy tests for
 * <code>DocumentPanelHelper</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DocumentPanelHelperTestAcc extends TestCase {

    /**
     * <p>
     * Test accuracy of method <code>validateNotNull()</code>.
     * </p>
     *
     * <p>
     * Object is null, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidateNotNull1() {
        try {
            DocumentPanelHelper.validateNotNull(null, "test object");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "test object should not be null.");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validateNotNull()</code>.
     * </p>
     *
     * <p>
     * Object is not null, <code>IllegalArgumentException</code> is
     * not expected.
     * </p>
     */
    public void testValidateNotNull2() {
        try {
            DocumentPanelHelper.validateNotNull(new Object(), "test object");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>checkNotEmpty()</code>.
     * </p>
     *
     * <p>
     * String is null, false is expected.
     * </p>
     */
    public void testCheckNotEmpty1() {
        boolean result = DocumentPanelHelper.checkNotEmpty(null);
        assertFalse("String is null", result);
    }

    /**
     * <p>
     * Test accuracy of method <code>checkNotEmpty()</code>.
     * </p>
     *
     * <p>
     * String is empty, false is expected.
     * </p>
     */
    public void testCheckNotEmpty2() {
        boolean result = DocumentPanelHelper.checkNotEmpty("");
        assertFalse("String is empty", result);
    }

    /**
     * <p>
     * Test accuracy of method <code>checkNotEmpty()</code>.
     * </p>
     *
     * <p>
     * String is empty after trimming, false is expected.
     * </p>
     */
    public void testCheckNotEmpty3() {
        boolean result = DocumentPanelHelper.checkNotEmpty(" ");
        assertFalse("String is empty after trimming", result);
    }

    /**
     * <p>
     * Test accuracy of method <code>checkNotEmpty()</code>.
     * </p>
     *
     * <p>
     * String is not empty, true is expected.
     * </p>
     */
    public void testCheckNotEmpty4() {
        boolean result = DocumentPanelHelper.checkNotEmpty("Not empty");
        assertTrue("String is not empty", result);
    }

    /**
     * <p>
     * Test accuracy of method <code>validateString()</code>.
     * </p>
     *
     * <p>
     * String is null, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testValidateString1() {
        try {
            DocumentPanelHelper.validateString(null, "test string");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "test string should not be null.");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validateString()</code>.
     * </p>
     *
     * <p>
     * String is empty, <code>IllegalArgumentException</code> is
     * expected.
     * </p>
     */
    public void testValidateString2() {
        try {
            DocumentPanelHelper.validateString("", "test string");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "test string should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validateString()</code>.
     * </p>
     *
     * <p>
     * String is empty after trimming, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testValidateString3() {
        try {
            DocumentPanelHelper.validateString(" ", "test string");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(), "test string should not be empty (trimmed).");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validateString()</code>.
     * </p>
     *
     * <p>
     * String is not empty after trimming, <code>IllegalArgumentException</code>
     * is not expected.
     * </p>
     */
    public void testValidateString4() {
        try {
            DocumentPanelHelper.validateString("Not empty", "test string");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is null, current doc is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc1() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is null, current doc is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc2() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(null, "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is null, current doc is empty after trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc3() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(null, " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty, current doc is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc4() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc("", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }

    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty after trimming, current doc is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc5() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(" ", null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty, current doc is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc6() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc("", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty after trimming, current doc is empty after trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc7() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(" ", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty, current doc is empty after trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc8() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc("", " ");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty after trimming, current doc is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc9() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(" ", "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Both previous document and current document are not valid(null or trimmed empty).");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is not null/empty(trimmed), current doc is null,
     * <code>IllegalArgumentException</code> is not expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc10() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc("Not empty", null);
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is not null/empty(trimmed), current doc is empty,
     * <code>IllegalArgumentException</code> is not expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc11() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc("Not empty", "");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is not null/empty(trimmed), current doc is empty after trimming,
     * <code>IllegalArgumentException</code> is not expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc12() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc("Not empty", " ");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is null, current doc is not null/empty(trimmed),
     * <code>IllegalArgumentException</code> is not expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc13() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(null, "Not empty");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty, current doc is not null/empty(trimmed),
     * <code>IllegalArgumentException</code> is not expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc14() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc("", "Not empty");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>validatePreDocAndCurrDoc()</code>.
     * </p>
     *
     * <p>
     * Previous doc is empty after trimming, current doc is not null/empty(trimmed),
     * <code>IllegalArgumentException</code> is not expected.
     * </p>
     */
    public void testValidatePreDocAndCurrDoc15() {
        try {
            DocumentPanelHelper.validatePreDocAndCurrDoc(" ", "Not empty");
        } catch (IllegalArgumentException e) {
            fail("IllegalArgumentException is not expected");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>checkRowRange()</code>.
     * </p>
     *
     * <p>
     * Size of rows is negative,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCheckRowRange1() {
        try {
            DocumentPanelHelper.checkRowRange(-1, 9);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Size of rows should not be negative.");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>checkRowRange()</code>.
     * </p>
     *
     * <p>
     * Row index is not in range, false is expected.
     * </p>
     */
    public void testCheckRowRange2() {
        boolean result = DocumentPanelHelper.checkRowRange(2, -1);
        assertFalse("Row index is not in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkRowRange()</code>.
     * </p>
     *
     * <p>
     * Row index is not in range, false is expected.
     * </p>
     */
    public void testCheckRowRange3() {
        boolean result = DocumentPanelHelper.checkRowRange(2, 2);
        assertFalse("Row index is not in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkRowRange()</code>.
     * </p>
     *
     * <p>
     * Row index is in range, true is expected.
     * </p>
     */
    public void testCheckRowRange4() {
        boolean result = DocumentPanelHelper.checkRowRange(2, 0);
        assertTrue("Row index is in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkRowRange()</code>.
     * </p>
     *
     * <p>
     * Row index is in range, true is expected.
     * </p>
     */
    public void testCheckRowRange5() {
        boolean result = DocumentPanelHelper.checkRowRange(2, 1);
        assertTrue("Row index is in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkColumnRange()</code>.
     * </p>
     *
     * <p>
     * Column index is 0, true is expected.
     * </p>
     */
    public void testCheckColumnRange1() {
        boolean result = DocumentPanelHelper.checkColumnRange(0);
        assertTrue("Column index is in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkColumnRange()</code>.
     * </p>
     *
     * <p>
     * Column index is 1, true is expected.
     * </p>
     */
    public void testCheckColumnRange2() {
        boolean result = DocumentPanelHelper.checkColumnRange(1);
        assertTrue("Column index is in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkColumnRange()</code>.
     * </p>
     *
     * <p>
     * Column index is -1, false is expected.
     * </p>
     */
    public void testCheckColumnRange3() {
        boolean result = DocumentPanelHelper.checkColumnRange(-1);
        assertFalse("Column index is not in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkColumnRange()</code>.
     * </p>
     *
     * <p>
     * Column index is 2, false is expected.
     * </p>
     */
    public void testCheckColumnRange4() {
        boolean result = DocumentPanelHelper.checkColumnRange(2);
        assertFalse("Column index is not in range", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Desired tag type is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCheckTagType1() {
        try {
            DocumentPanelHelper.checkTagType(null, null, true);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Desired tag type should not be null.");
        }
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Tagged value is null, false is expected.
     * </p>
     */
    public void testCheckTagType2() {
        boolean result = DocumentPanelHelper.checkTagType(null, "someTagType", true);
        assertFalse("TaggedValue is null", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Tagged value's tag definition is null, false is expected.
     * </p>
     */
    public void testCheckTagType3() {
        TaggedValue tv = TestHelper.getTaggedValueWithNullDefinition();
        boolean result = DocumentPanelHelper.checkTagType(tv, "someTagType", true);
        assertFalse("TaggedValue's tag definition is null", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Tag Definition's tagType is null, false is expected.
     * </p>
     */
    public void testCheckTagType4() {
        TaggedValue tv = TestHelper.getTaggedValueWithNullTagType();
        boolean result = DocumentPanelHelper.checkTagType(tv, "someTagType", false);
        assertFalse("TaggedValue's tag type is null", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Tagged value's tag type is desired, true is expected.
     * </p>
     */
    public void testCheckTagType5() {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType("DesiredTagType#XXX");
        boolean result = DocumentPanelHelper.checkTagType(tv, "DesiredTagType", false);
        assertTrue("TaggedValue's tag type is desired", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Tagged value's tag type is not desired, false is expected.
     * </p>
     */
    public void testCheckTagType6() {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType("YYY#XXX");
        boolean result = DocumentPanelHelper.checkTagType(tv, "DesiredTagType", false);
        assertFalse("TaggedValue's tag type is not desired", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Tagged value's tag type is desired, true is expected.
     * </p>
     */
    public void testCheckTagType7() {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType("DesiredTagType");
        boolean result = DocumentPanelHelper.checkTagType(tv, "DesiredTagType", true);
        assertTrue("TaggedValue's tag type is desired", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>checkTagType()</code>.
     * </p>
     *
     * <p>
     * Tagged value's tag type is not desired, false is expected.
     * </p>
     */
    public void testCheckTagType8() {
        TaggedValue tv = TestHelper.getTaggedValueWithTagType("someTagType");
        boolean result = DocumentPanelHelper.checkTagType(tv, "DesiredTagType", true);
        assertFalse("TaggedValue's tag type is not desired", result);
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagNameWithPrefix()</code>.
     * </p>
     *
     * <p>
     * Tag name is not prefixed with "@", returned value should be
     * prefixed with "@".
     * </p>
     */
    public void testGetTagNameWithPrefix1() {
        String tagName = DocumentPanelHelper.getTagNameWithPrefix("tagName");
        assertEquals(tagName, "@tagName");
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagNameWithPrefix()</code>.
     * </p>
     *
     * <p>
     * Tag name is prefixed with "@", returned value should be
     * prefixed with "@".
     * </p>
     */
    public void testGetTagNameWithPrefix2() {
        String tagName = DocumentPanelHelper.getTagNameWithPrefix("@tagName");
        assertEquals(tagName, "@tagName");
    }
    /**
     * <p>
     * Test accuracy of method <code>getTagNameWithPrefix()</code>.
     * </p>
     *
     * <p>
     * Tag name is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testGetTagNameWithPrefix3() {
        try {
            DocumentPanelHelper.getTagNameWithPrefix(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                  "Tag name should not be null.");
        }
    }
}
