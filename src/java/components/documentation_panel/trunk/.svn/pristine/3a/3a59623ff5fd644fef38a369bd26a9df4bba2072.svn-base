/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.documentation.TestHelper;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains exception test
 * for <code>DefaultTagTableModel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DefaultTagTableModelTestExp extends TestCase {

    /**
     * <p>
     * <code>DefaultTagEditor</code> used in this test case.
     * </p>
     */
    private DefaultTagEditor tagEditor = null;

    /**
     * <p>
     * <code>DefaultTagTableModel</code> used in this test case.
     * </p>
     */
    private DefaultTagTableModel model = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/tagEditor.xml");
        TestHelper.addConfig("UnitTest/tagOptions.xml");
        tagEditor = new DefaultTagEditor("defaultTagEditor_1");
        model = new DefaultTagTableModel(tagEditor);
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        model = null;
        tagEditor = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Test exception for method <code>DefaultTagTableModel(DefaultTagEditor)</code>.
     * </p>
     *
     * <p>
     * Passed in tag editor is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testDefaultTagTableModel() {
        try {
            new DefaultTagTableModel(null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag editor contains this table model should not be null.");
        }
    }

    /**
     * <p>
     * Test exception for method <code>DefaultTagTableModel(DefaultTagEditor, String[], String, String)</code>.
     * </p>
     *
     * <p>
     * Passed in tag editor is null, <code>IllegalArgumentException</code>
     * is expected.
     * </p>
     */
    public void testDefaultTagTableModel1() {
        try {
            new DefaultTagTableModel(null, null, null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag editor contains this table model should not be null.");
        }
    }

    /**
     * <p>
     * Test exception for method <code>DefaultTagTableModel(DefaultTagEditor, String[], String, String)</code>.
     * </p>
     *
     * <p>
     * Passed in column names is not null and its size is not 2,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDefaultTagTableModel2() {
        try {
            String[] columnNames = new String[] {};
            new DefaultTagTableModel(this.tagEditor, columnNames, null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Column names must contain exactly two non-null strings.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagTableModel(DefaultTagEditor, String[], String, String)</code>.
     * </p>
     *
     * <p>
     * First column name is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDefaultTagTableModel3() {
        try {
            String[] columnNames = new String[] {null, null};
            new DefaultTagTableModel(this.tagEditor, columnNames, null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "First column name of tag table should not be null.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagTableModel(DefaultTagEditor, String[], String, String)</code>.
     * </p>
     *
     * <p>
     * Second column name is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDefaultTagTableModel4() {
        try {
            String[] columnNames = new String[] {"", null};
            new DefaultTagTableModel(this.tagEditor, columnNames, null, null);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Second column name of tag table should not be null.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagTableModel(DefaultTagEditor, String[], String, String)</code>.
     * </p>
     *
     * <p>
     * New value prompt is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDefaultTagTableModel5() {
        try {
            new DefaultTagTableModel(this.tagEditor, null, null, "");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "New value prompt should not be empty (trimmed).");
        }
    }
    /**
     * <p>
     * Test exception for method <code>DefaultTagTableModel(DefaultTagEditor, String[], String, String)</code>.
     * </p>
     *
     * <p>
     * New tag prompt is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testDefaultTagTableModel6() {
        try {
            new DefaultTagTableModel(this.tagEditor, null, "", "new value");
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "New tag prompt should not be empty (trimmed).");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testUpdateValues1() {
        try {
            this.model.updateValues(null, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Values of tag table should not be null.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value contains a row whose size is not 2,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues2() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add("1");
            row.add("2");
            row.add("3");
            values.add(row);
            this.model.updateValues(values, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Each row of tag table must be size of 2.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value contains a row whose first element is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues3() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add(null);
            row.add("2");
            values.add(row);
            this.model.updateValues(values, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name should not be null.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value contains a row whose first element is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues4() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add("");
            row.add("2");
            values.add(row);
            this.model.updateValues(values, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name should not be empty (trimmed).");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value contains a row whose first element is empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues5() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add(" ");
            row.add("2");
            values.add(row);
            this.model.updateValues(values, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag name should not be empty (trimmed).");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value contains a row whose second element is null,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues6() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add("1");
            row.add(null);
            values.add(row);
            this.model.updateValues(values, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag value should not be null.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value contains a row whose second element is empty,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues7() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add("1");
            row.add("");
            values.add(row);
            this.model.updateValues(values, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag value should not be empty (trimmed).");
        }
    }
    /**
     * <p>
     * Test exception for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Passed in value contains a row whose first second is empty on trimming,
     * <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues8() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add("1");
            row.add(" ");
            values.add(row);
            this.model.updateValues(values, new ArrayList < TaggedValue > ());
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "Tag value should not be empty (trimmed).");
        }
    }
    /**
     * <p>
     * Test exception for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Parent tag editor currently has no target <code>ModelElement</code> managed,
     * <code>IllegalArgumentException</code> is expected when fireTagCreated.
     * </p>
     */
    public void testSetValueAt1() {
        try {
            this.model.setValueAt("value", 0, 0);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose tag being modified should not be null.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Parent tag editor currently has no target <code>ModelElement</code> managed,
     * <code>IllegalArgumentException</code> is expected when fireTagUpdated.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testSetValueAt2() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add("1");
            row.add("2");
            values.add(row);
            TaggedValue taggedObject = new TaggedValueImpl();
            List < TaggedValue > valueObjects = new ArrayList < TaggedValue > ();
            valueObjects.add(taggedObject);
            this.model.updateValues(values, valueObjects);
            this.model.setValueAt("value", 0, 1);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose tag being modified should not be null.");
        }
    }
    /**
     * <p>
     * Test exception for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Parent tag editor currently has no target <code>ModelElement</code> managed,
     * <code>IllegalArgumentException</code> is expected when fireTagDeleted.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testSetValueAt3() {
        try {
            List < List < String > > values = new ArrayList();
            List < String > row = new ArrayList();
            row.add("1");
            row.add("2");
            values.add(row);
            TaggedValue taggedObject = new TaggedValueImpl();
            List < TaggedValue > valueObjects = new ArrayList < TaggedValue > ();
            valueObjects.add(taggedObject);
            this.model.updateValues(values, valueObjects);
            this.model.setValueAt("", 0, 1);
            fail("IllegalArgumentException is expected");
        } catch (IllegalArgumentException e) {
            assertEquals(e.getMessage(),
                    "ModelElement whose tag being modified should not be null.");
        }
    }
}
