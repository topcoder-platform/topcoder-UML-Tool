/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.documentation.TestHelper;
import com.topcoder.gui.panels.documentation.event.MockTagListener;
import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains accuracy test
 * for <code>DefaultTagTableModel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DefaultTagTableModelTestAcc extends TestCase {
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
     * Tag listener used in this test case.
     * </p>
     */
    private MockTagListener listener = null;
    /**
     * <p>
     * Model element used in this test case.
     * </p>
     */
    private ModelElement target = null;
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
        listener = new MockTagListener();
        target = new OperationImpl();
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        target = null;
        listener = null;
        model = null;
        tagEditor = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Get column names.
     * </p>
     *
     * @return column names
     */
    private String[] getColumnNames() {
        return new String[] {"column1", "column2"};
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagTableModel()</code>.
     * </p>
     */
    public void testDefaultTagTableModel1() {
        assertNotNull("Initialized successfully", this.model);
    }

    /**
     * <p>
     * Test accuracy for method <code>DefaultTagTableModel()</code>.
     * </p>
     *
     * <p>
     * Column names, new tag prompt, new value prompt are allowed to be null.
     * </p>
     */
    public void testDefaultTagTableModel2() {
        this.model = new DefaultTagTableModel(tagEditor, null, null, null);
        assertNotNull("Initialized successfully", this.model);
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagTableModel()</code>.
     * </p>
     *
     * <p>
     * Column names, new value prompt are allowed to be null.
     * </p>
     */
    public void testDefaultTagTableModel3() {
        this.model = new DefaultTagTableModel(tagEditor, null, "new tag", null);
        assertNotNull("Initialized successfully", this.model);
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagTableModel()</code>.
     * </p>
     *
     * <p>
     * Column names are allowed to be null.
     * New tag prompt and new value prompt are provided.
     * </p>
     */
    public void testDefaultTagTableModel4() {
        this.model = new DefaultTagTableModel(tagEditor, null, "new tag", "new value");
        assertNotNull("Initialized successfully", this.model);
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagTableModel()</code>.
     * </p>
     *
     * <p>
     * Column names are provided.
     * New tag prompt and new value prompt are allowed to be null.
     * </p>
     */
    public void testDefaultTagTableModel5() {
        this.model = new DefaultTagTableModel(tagEditor, getColumnNames(), null, null);
        assertNotNull("Initialized successfully", this.model);
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagTableModel()</code>.
     * </p>
     *
     * <p>
     * Column names and New tag prompt are provided.
     * New value prompt is allowed to be null.
     * </p>
     */
    public void testDefaultTagTableModel6() {
        this.model = new DefaultTagTableModel(tagEditor, getColumnNames(), "new tag", null);
        assertNotNull("Initialized successfully", this.model);
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagTableModel()</code>.
     * </p>
     *
     * <p>
     * Column names, new value prompt and new tag prompt are provided.
     * </p>
     */
    public void testDefaultTagTableModel7() {
        this.model = new DefaultTagTableModel(tagEditor, getColumnNames(), "new tag", "new value");
        assertNotNull("Initialized successfully", this.model);
    }
    /**
     * <p>
     * Test accuracy for method <code>isCellEditable()</code>.
     * </p>
     *
     * <p>
     * Column index is not in right range, false is expected.
     * </p>
     */
    public void testIsCellEditable1() {
        assertFalse("Not editable", this.model.isCellEditable(0, 2));
    }
    /**
     * <p>
     * Test accuracy for method <code>isCellEditable()</code>.
     * </p>
     *
     * <p>
     * Column index is not in right range, false is expected.
     * </p>
     */
    public void testIsCellEditable2() {
        assertFalse("Not editable", this.model.isCellEditable(0, -1));
    }
    /**
     * <p>
     * Test accuracy for method <code>isCellEditable()</code>.
     * </p>
     *
     * <p>
     * Current row count is 1, row index is not in range, false is expected.
     * </p>
     */
    public void testIsCellEditable3() {
        assertFalse("Not editable", this.model.isCellEditable(1, 0));
    }
    /**
     * <p>
     * Test accuracy for method <code>isCellEditable()</code>.
     * </p>
     *
     * <p>
     * Current row count is 1, row index is the last row(new tag selector);
     * and column index is 0, true is expected.
     * </p>
     */
    public void testIsCellEditable4() {
        assertTrue("Editable", this.model.isCellEditable(0, 0));
    }
    /**
     * <p>
     * Test accuracy for method <code>isCellEditable()</code>.
     * </p>
     *
     * <p>
     * Current row count is 1, row index is the last row(new tag selector);
     * and column index is 1, false is expected.
     * </p>
     */
    public void testIsCellEditable5() {
        assertFalse("Not editable", this.model.isCellEditable(0, 1));
    }
    /**
     * <p>
     * Update values matrix.
     * The size of matrix is 1 after update.
     * The row count is 2 after update.
     * </p>
     */
    @SuppressWarnings("unchecked")
    private void updateValues() {
        List < List < String > > values = new ArrayList();
        List < String > row = new ArrayList();
        row.add("tagName");
        row.add("tagDoc");
        values.add(row);
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue> ();
        valueObjects.add(taggedObject);
        this.model.updateValues(values, valueObjects);
    }
    /**
     * <p>
     * Test accuracy for method <code>isCellEditable()</code>.
     * </p>
     *
     * <p>
     * Current row count is 2, row index is not the last row(new tag selector);
     * and column index is 0, false is expected.
     * </p>
     */
    public void testIsCellEditable6() {
        updateValues();
        assertFalse("Not editable", this.model.isCellEditable(0, 0));
    }
    /**
     * <p>
     * Test accuracy for method <code>isCellEditable()</code>.
     * </p>
     *
     * <p>
     * Current row count is 2, row index is not the last row(new tag selector);
     * and column index is 1, true is expected.
     * </p>
     */
    public void testIsCellEditable7() {
        updateValues();
        assertTrue("Editable", this.model.isCellEditable(0, 1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnCount()</code>.
     * </p>
     */
    public void testGetColumnCount() {
        assertEquals("Column count should always be 2", this.model.getColumnCount(), 2);
    }

    /**
     * <p>
     * Test accuracy for method <code>getRowCount()</code>.
     * </p>
     *
     * <p>
     * Current values matrix is empty, row count should be 1.
     * </p>
     */
    public void testGetRowCount1() {
        assertEquals("Row count is 1", this.model.getRowCount(), 1);
    }
    /**
     * <p>
     * Test accuracy for method <code>getRowCount()</code>.
     * </p>
     *
     * <p>
     * Current values matrix's size is 1, row count should be 2.
     * </p>
     */
    public void testGetRowCount2() {
        updateValues();
        assertEquals("Row count is 2", this.model.getRowCount(), 2);
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnName()</code>.
     * </p>
     *
     * <p>
     * Name of column 0 should be "Tag".
     * </p>
     */
    public void testGetColumnName1() {
        assertEquals("Tag", this.model.getColumnName(0));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnName()</code>.
     * </p>
     *
     * <p>
     * Name of column 1 should be "Documentation".
     * </p>
     */
    public void testGetColumnName2() {
        assertEquals("Documentation", this.model.getColumnName(1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnName()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, null should be returned.
     * </p>
     */
    public void testGetColumnName3() {
        assertEquals(null, this.model.getColumnName(2));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnName()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, null should be returned.
     * </p>
     */
    public void testGetColumnName4() {
        assertEquals(null, this.model.getColumnName(-1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnName()</code>.
     * </p>
     *
     * <p>
     * Name of column 0 should be "column1".
     * </p>
     */
    public void testGetColumnName5() {
        this.model = new DefaultTagTableModel(tagEditor, getColumnNames(), null, null);
        assertEquals("column1", this.model.getColumnName(0));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnName()</code>.
     * </p>
     *
     * <p>
     * Name of column 1 should be "column2".
     * </p>
     */
    public void testGetColumnName6() {
        this.model = new DefaultTagTableModel(tagEditor, getColumnNames(), null, null);
        assertEquals("column2", this.model.getColumnName(1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Class of column 0 should be String.class.
     * </p>
     */
    public void testGetColumnClass1() {
        assertEquals(String.class, this.model.getColumnClass(0));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Class of column 1 should be String.class.
     * </p>
     */
    public void testGetColumnClass2() {
        assertEquals(String.class, this.model.getColumnClass(1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, null should be returned.
     * </p>
     */
    public void testGetColumnClass3() {
        assertEquals(null, this.model.getColumnClass(2));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, null should be returned.
     * </p>
     */
    public void testGetColumnClass4() {
        assertEquals(null, this.model.getColumnClass(-1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, null should be returned.
     * </p>
     */
    public void testGetValueAt1() {
        assertEquals(null, this.model.getValueAt(0, -1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, null should be returned.
     * </p>
     */
    public void testGetValueAt2() {
        assertEquals(null, this.model.getValueAt(0, 2));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Current row count is 1;
     * Row index is not in range, null should be returned.
     * </p>
     */
    public void testGetValueAt3() {
        assertEquals(null, this.model.getValueAt(1, 0));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Current row count is 1;
     * Row index is last row, column index is 0,
     * "Insert new tag..." should be returned.
     * </p>
     */
    public void testGetValueAt4() {
        assertEquals("Insert new tag...", this.model.getValueAt(0, 0));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Current row count is 1;
     * Row index is last row, column index is 1,
     * "" should be returned.
     * </p>
     */
    public void testGetValueAt5() {
        assertEquals("", this.model.getValueAt(0, 1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Current row count is 2;
     * Row index is 0, column index is 0,
     * "tagName" should be returned.
     * </p>
     */
    public void testGetValueAt6() {
        this.updateValues();
        assertEquals("tagName", this.model.getValueAt(0, 0));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Current row count is 2;
     * Row index is 0, column index is 1,
     * "tagDoc" should be returned.
     * </p>
     */
    public void testGetValueAt7() {
        this.updateValues();
        assertEquals("tagDoc", this.model.getValueAt(0, 1));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Current row count is 2;
     * Row index is last row, column index is 0,
     * "Insert new tag..." should be returned.
     * </p>
     */
    public void testGetValueAt8() {
        this.updateValues();
        assertEquals("Insert new tag...", this.model.getValueAt(1, 0));
    }
    /**
     * <p>
     * Test accuracy for method <code>getColumnClass()</code>.
     * </p>
     *
     * <p>
     * Current row count is 2;
     * Row index is 0, column index is 1,
     * "" should be returned.
     * </p>
     */
    public void testGetValueAt9() {
        this.updateValues();
        assertEquals("", this.model.getValueAt(1, 1));
    }

    /**
     * <p>
     * Set the target model element managed by tag editor,
     * and add a tag event listener.
     * </p>
     *
     * @throws Exception to JUnit
     */
    private void setTargetAndAddListener() throws Exception {
        this.tagEditor.setTarget(this.target);
        this.tagEditor.addTagListener(this.listener);
    }
    /**
     * <p>
     * Assert two <code>TagEvent</code> equals.
     * </p>
     *
     * @param e1 one <code>TagEvent</code>
     * @param e2 another <code>TagEvent</code>
     */
    private void assertTagEvent(TagEvent e1, TagEvent e2) {
        assertEquals(e1.getModelElement(), e2.getModelElement());
        assertEquals(e1.getCurrentDocumentation(), e2.getCurrentDocumentation());
        assertEquals(e1.getPreviousDocumentation(), e2.getPreviousDocumentation());
        assertEquals(e1.getTagName(), e2.getTagName());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Value is null, nothing happen.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt1() throws Exception {
        setTargetAndAddListener();
        this.model.setValueAt(null, 0, 0);
        assertEquals("NO event fired", null, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, nothing happen.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt2() throws Exception {
        setTargetAndAddListener();
        this.model.setValueAt("value", 0, -1);
        assertEquals("NO event fired", null, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Column index is not in range, nothing happen.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt3() throws Exception {
        setTargetAndAddListener();
        this.model.setValueAt("value", 0, 2);
        assertEquals("NO event fired", null, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Current row count is 1;
     * Row index is not in range, nothing happen.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt4() throws Exception {
        setTargetAndAddListener();
        this.model.setValueAt("value", 1, 0);
        assertEquals("NO event fired", null, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Row index equals values matrix's size, create event fired.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt5() throws Exception {
        setTargetAndAddListener();
        this.model.setValueAt("value", 0, 0);
        TagEvent e = new TagEvent(this.target, new TaggedValueImpl(), "value", null, "new value");
        assertEquals("created", this.listener.getEventType());
        assertTagEvent(e, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Value is empty, delete event fired.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt6() throws Exception {
        updateValues();
        setTargetAndAddListener();
        this.model.setValueAt("", 0, 1);
        TagEvent e = new TagEvent(this.target, new TaggedValueImpl(), "tagName", "tagDoc", null);
        assertEquals("deleted", this.listener.getEventType());
        assertTagEvent(e, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Value is not empty, update event fired.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt7() throws Exception {
        updateValues();
        setTargetAndAddListener();
        this.model.setValueAt("newDoc", 0, 1);
        TagEvent e = new TagEvent(this.target, new TaggedValueImpl(), "tagName", "tagDoc", "newDoc");
        assertEquals("updated", this.listener.getEventType());
        assertTagEvent(e, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>setValueAt()</code>.
     * </p>
     *
     * <p>
     * Value is not empty, but column 0 is not editable, nothing happen.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetValueAt8() throws Exception {
        updateValues();
        setTargetAndAddListener();
        this.model.setValueAt("newDoc", 0, 0);
        assertEquals("No event fired", null, this.listener.getFiredEvent());
    }
    /**
     * <p>
     * Test accuracy for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Updated values' size is 1, row count should be 2 after update.
     * </p>
     */
    public void testUpdateValues1() {
        this.updateValues();
        assertEquals("Row count should be 2", 2, this.model.getRowCount());
        assertEquals("tagName", this.model.getValueAt(0, 0));
        assertEquals("tagDoc", this.model.getValueAt(0, 1));
    }
    /**
     * <p>
     * Test accuracy for method <code>updateValues()</code>.
     * </p>
     *
     * <p>
     * Updated values is empty, row count should be 1 after update.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testUpdateValues2() {
        this.model.updateValues(new ArrayList(), new ArrayList());
        assertEquals("Row count should be 1", 1, this.model.getRowCount());
    }
    /**
     * <p>
     * Test accuracy for method <code>getNewValuePrompt()</code>.
     * </p>
     */
    public void testGetNewValuePrompt1() {
        assertEquals("new value", this.model.getNewValuePrompt());
    }
    /**
     * <p>
     * Test accuracy for method <code>getNewValuePrompt()</code>.
     * </p>
     */
    public void testGetNewValuePrompt2() {
        this.model = new DefaultTagTableModel(tagEditor, null, null, "Insert new value");
        assertEquals("Insert new value", this.model.getNewValuePrompt());
    }
    /**
     * <p>
     * Test accuracy for method <code>getNewTagPrompt()</code>.
     * </p>
     */
    public void testGetNewTagPrompt1() {
        assertEquals("Insert new tag...", this.model.getNewTagPrompt());
    }
    /**
     * <p>
     * Test accuracy for method <code>getNewTagPrompt()</code>.
     * </p>
     */
    public void testGetNewTagPrompt2() {
        this.model = new DefaultTagTableModel(tagEditor, null, "new tag", null);
        assertEquals("new tag", this.model.getNewTagPrompt());
    }
}
