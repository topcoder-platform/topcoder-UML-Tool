/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JTable;

import com.topcoder.gui.panels.documentation.TestHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.ParameterImpl;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains accuracy test
 * for <code>DefaultTagEditor</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DefaultTagEditorTestAcc extends TestCase {

    /**
     * <p>
     * Default new tag prompt if not configuration.
     * </p>
     */
    private static final String DEFAULT_NEW_TAG_PROMPT = "Insert new tag...";

    /**
     * <p>
     * Default new value prompt if not configuration.
     * </p>
     */
    private static final String DEFAULT_NEW_VALUE_PROMPT = "new value";

    /**
     * <p>
     * Default column names if not configuration.
     * </p>
     */
    private static final String[] DEFAULT_COLUMN_NAMES = {"Tag", "Documentation"};

    /**
     * <p>
     * <code>DefaultTagEditor</code> used in this test case.
     * </p>
     */
    private DefaultTagEditor tagEditor = null;

    /**
     * <p>
     * Operation used in this test case.
     * </p>
     */
    private Operation operation = null;
    /**
     * <p>
     * Model element used in this test case.
     * </p>
     */
    private ModelElement classifier = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    @SuppressWarnings("unchecked")
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/tagEditor.xml");
        TestHelper.addConfig("UnitTest/tagOptions.xml");
        tagEditor = new DefaultTagEditor("defaultTagEditor_1");
        operation = new OperationImpl();
        classifier = new ClassImpl();
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        classifier = null;
        operation = null;
        tagEditor = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }
    /**
     * <p>
     * Get table model contained in tag editor.
     * </p>
     *
     * @return table model
     * @throws Exception to JUnit
     */
    private DefaultTagTableModel getTableModel() throws Exception {
        DefaultTagTableModel model = (DefaultTagTableModel) TestHelper.getField(this.tagEditor, "tagModel");
        return model;
    }
    /**
     * <p>
     * Get <code>JTable</code> contained in tag editor.
     * </p>
     *
     * @return <code>JTable</code>
     * @throws Exception to JUnit
     */
    private JTable getJTable() throws Exception {
        JTable table = (JTable) TestHelper.getField(this.tagEditor, "tagTable");
        return table;
    }
    /**
     * <p>
     * Get <code>JComboBox</code> used in the first column which containing tag options.
     * </p>
     *
     * @return <code>JComboBox</code>
     *
     * @throws Exception to JUnit
     */
    private JComboBox getOptionComboBox() throws Exception {
        DefaultCellEditor cellEditor = (DefaultCellEditor) this.getJTable()
            .getColumnModel().getColumn(0).getCellEditor();
        JComboBox comboBox = (JComboBox) cellEditor.getComponent();
        return comboBox;
    }
    /**
     * <p>
     * Get tag prompt of table model.
     * </p>
     *
     * @param model table model
     *
     * @return tag prompt
     *
     * @throws Exception to JUnit
     */
    private String getTagPrompt(DefaultTagTableModel model) throws Exception {
        String tagPrompt = (String) TestHelper.getField(model, "newTagPrompt");
        return tagPrompt;
    }
    /**
     * <p>
     * Get value prompt of table model.
     * </p>
     *
     * @param model table model
     *
     * @return value prompt
     *
     * @throws Exception to JUnit
     */
    private String getValuePrompt(DefaultTagTableModel model) throws Exception {
        String valuePrompt = model.getNewValuePrompt();
        return valuePrompt;
    }
    /**
     * <p>
     * Get column names of table model.
     * </p>
     *
     * @param model table model
     *
     * @return column names
     *
     * @throws Exception to JUnit
     */
    private String[] getColumnNames(DefaultTagTableModel model) throws Exception {
        String[] names = (String[]) TestHelper.getField(model, "columnNames");
        return names;
    }
    /**
     * <p>
     * Assert given table model containing desired tag prompt, value prompt
     * and column names.
     * </p>
     *
     * @param tagPrompt desired tag prompt
     * @param valuePrompt desired value prompt
     * @param columnNames desired column names
     * @param model table model
     *
     * @throws Exception to JUnit
     */
    private void assertTableModle(String tagPrompt, String valuePrompt,
            String[] columnNames, DefaultTagTableModel model) throws Exception {
        assertEquals(tagPrompt, this.getTagPrompt(model));
        assertEquals(valuePrompt, this.getValuePrompt(model));
        assertEquals(columnNames.length, this.getColumnNames(model).length);
        assertEquals(columnNames[0], this.getColumnNames(model)[0]);
        assertEquals(columnNames[1], this.getColumnNames(model)[1]);
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Column names, tag prompt, value prompt are not configured.
     * Default values should be used.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor1() throws Exception {
        assertNotNull("Initialized successfully", this.tagEditor);
        assertTableModle(DEFAULT_NEW_TAG_PROMPT, DEFAULT_NEW_VALUE_PROMPT,
                DEFAULT_COLUMN_NAMES, this.getTableModel());
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Column names, value prompt are not configured.
     * Default values should be used.
     * Tag prompt is configured as "new tag prompt".
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor2() throws Exception {
        this.tagEditor = new DefaultTagEditor("defaultTagEditor_2");
        assertNotNull("Initialized successfully", this.tagEditor);
        assertTableModle("new tag prompt", DEFAULT_NEW_VALUE_PROMPT,
                DEFAULT_COLUMN_NAMES, this.getTableModel());
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Column names are not configured.
     * Default values should be used.
     * Tag prompt is configured as "new tag prompt".
     * Value prompt is configured as "new Value prompt".
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor3() throws Exception {
        this.tagEditor = new DefaultTagEditor("defaultTagEditor_3");
        assertNotNull("Initialized successfully", this.tagEditor);
        assertTableModle("new tag prompt", "new Value prompt",
                DEFAULT_COLUMN_NAMES, this.getTableModel());
    }
    /**
     * <p>
     * Test accuracy for method <code>DefaultTagEditor()</code>.
     * </p>
     *
     * <p>
     * Column names are configured as {"Tag name", "Tag doc"}.
     * Tag prompt is configured as "new tag prompt".
     * Value prompt is configured as "new Value prompt".
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDefaultTagEditor4() throws Exception {
        this.tagEditor = new DefaultTagEditor("defaultTagEditor_4");
        assertNotNull("Initialized successfully", this.tagEditor);
        String[] columnNames = new String[] {"Tag name", "Tag doc"};
        assertTableModle("new tag prompt", "new Value prompt",
                columnNames, this.getTableModel());
    }
    /**
     * <p>
     * Assert given <code>JComboBox</code> containing desired tag options
     * of <code>OperationImpl</code>.
     * </p>
     *
     * @param comboBox <code>JComboBox</code>
     */
    private void assertOptionsForOperation(JComboBox comboBox) {
        assertEquals("5 options for OperationImpl", 5, comboBox.getItemCount());
        List < String > operationOptions = TestHelper.getOperationOptions();
        for (int i = 0; i < 5; i++) {
            assertTrue(operationOptions.contains(comboBox.getItemAt(i)));
        }
    }
    /**
     * <p>
     * Assert given <code>JComboBox</code> containing desired tag options
     * of <code>ClassImpl</code>.
     * </p>
     *
     * @param comboBox <code>JComboBox</code>
     */
    private void assertOptionsForClass(JComboBox comboBox) {
        assertEquals("5 options for ClassImpl", 5, comboBox.getItemCount());
        List < String > classOptions = TestHelper.getClassOptions();
        for (int i = 0; i < 5; i++) {
            assertTrue(classOptions.contains(comboBox.getItemAt(i)));
        }
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>Operation</code> contains no "documentation#" tag;
     * And contains no <code>Parameter</code>.
     * Nx2 matrix should be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget1() throws Exception {
        this.tagEditor.setTarget(this.operation);
        assertEquals(1, this.getTableModel().getRowCount());
        assertOptionsForOperation(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>ClassImpl</code> contains no "documentation#" tag;
     * Nx2 matrix should be empty.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget2() throws Exception {
        this.tagEditor.setTarget(this.classifier);
        assertEquals(1, this.getTableModel().getRowCount());
        assertOptionsForClass(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>ClassImpl</code> contains 2 "documentation#" tags;
     * Nx2 matrix should be size of 2.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget3() throws Exception {
        TaggedValue tv1 = TestHelper.getTaggedValueWithTagType("documentation#since");
        TaggedValue tv2 = TestHelper.getTaggedValueWithTagType("documentation#version");
        tv1.setDataValue("1.0");
        tv2.setDataValue("2.0");
        this.classifier.addTaggedValue(tv1);
        this.classifier.addTaggedValue(tv2);
        this.tagEditor.setTarget(this.classifier);
        assertEquals(3, this.getTableModel().getRowCount());
        assertOptionsForClass(this.getOptionComboBox());
    }
    /**
     * <p>
     * Add two valid tags to <code>Operation</code>.
     * </p>
     */
    private void addTagsToOperation() {
        TaggedValue tv1 = TestHelper.getTaggedValueWithTagType("documentation#see");
        TaggedValue tv2 = TestHelper.getTaggedValueWithTagType("documentation#since");
        tv1.setDataValue("<code>method</code>");
        tv2.setDataValue("1.0");
        this.operation.addTaggedValue(tv1);
        this.operation.addTaggedValue(tv2);
    }
    /**
     * <p>
     * Get a <code>Parameter</code>.
     * </p>
     *
     * @param tagType type of tag
     * @param tagDoc documentation of tag
     * @param paramName name of <code>Parameter</code>
     *
     * @return <code>Parameter</code>
     */
    private Parameter getParameter(String tagType, String tagDoc, String paramName) {
        TaggedValue tv3 = TestHelper.getTaggedValueWithTagType(tagType);
        tv3.setDataValue(tagDoc);
        ParameterImpl param = new ParameterImpl();
        param.addTaggedValue(tv3);
        param.setName(paramName);
        return param;
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>OperationImpl</code> contains 2 "documentation#" tags;
     * and contains a <code>Parameter</code>.
     * Nx2 matrix should be size of 3.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget4() throws Exception {
        addTagsToOperation();

        Parameter param = getParameter("documentation",
                "parameter document", "parameterName");

        this.operation.addParameter(param);
        this.tagEditor.setTarget(this.operation);
        assertEquals(4, this.getTableModel().getRowCount());
        assertOptionsForOperation(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>OperationImpl</code> contains 2 "documentation#" tags;
     * and contains a <code>Parameter</code> with empty documentation,
     * default NEW_VALUE_PROMPT should be used.
     * Nx2 matrix should be size of 3.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget5() throws Exception {
        addTagsToOperation();

        //Parameter's document is empty, default NEW_VALUE_PROMPT should be used.
        Parameter param = getParameter("documentation",
                "", "parameterName");

        this.operation.addParameter(param);
        this.tagEditor.setTarget(this.operation);
        assertEquals(4, this.getTableModel().getRowCount());
        assertEquals("new value", this.getTableModel().getValueAt(0, 1));
        assertOptionsForOperation(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>OperationImpl</code> contains 2 "documentation#" tags;
     * and contains a <code>Parameter</code> with empty name,
     * it should be ignored.
     * Nx2 matrix should be size of 2.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget6() throws Exception {
        addTagsToOperation();

        //Parameter's name is empty, should be ignored
        Parameter param = getParameter("documentation",
                "parameter documentation", "");

        this.operation.addParameter(param);
        this.tagEditor.setTarget(this.operation);
        assertEquals(3, this.getTableModel().getRowCount());
        assertOptionsForOperation(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>OperationImpl</code> contains 2 "documentation#" tags;
     * and contains a <code>Parameter</code> with null name,
     * it should be ignored.
     * Nx2 matrix should be size of 2.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget7() throws Exception {
        addTagsToOperation();

        //Parameter's name is null, should be ignored
        Parameter param = getParameter("documentation",
                "parameter documentation", null);

        this.operation.addParameter(param);
        this.tagEditor.setTarget(this.operation);
        assertEquals(3, this.getTableModel().getRowCount());
        assertOptionsForOperation(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>OperationImpl</code> contains 2 "documentation#" tags;
     * and contains a <code>Parameter</code> whose tag type is not
     * "documentation", it should use NEW_VALUE_PROMPT as the tag
     * document.
     * Nx2 matrix should be size of 3.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget8() throws Exception {
        addTagsToOperation();

        //tag type of parameter is not "documentation"
        Parameter param = getParameter("NotDesiredType",
                "parameter documentation", "parameterName");

        this.operation.addParameter(param);
        this.tagEditor.setTarget(this.operation);
        assertEquals(4, this.getTableModel().getRowCount());
        assertEquals("new value", this.getTableModel().getValueAt(0, 1));
        assertOptionsForOperation(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>ClassImpl</code> contains 2 "documentation#" tags;
     * but the first one is exactly "documentation#", it will be ignored.
     * Nx2 matrix should be size of 1.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget9() throws Exception {
        TaggedValue tv1 = TestHelper.getTaggedValueWithTagType("documentation#");
        TaggedValue tv2 = TestHelper.getTaggedValueWithTagType("documentation#version");
        tv1.setDataValue("1.0");
        tv2.setDataValue("2.0");
        this.classifier.addTaggedValue(tv1);
        this.classifier.addTaggedValue(tv2);
        this.tagEditor.setTarget(this.classifier);
        assertEquals(2, this.getTableModel().getRowCount());
        assertOptionsForClass(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * <code>ClassImpl</code> contains 2 "documentation#" tags;
     * but the second one's document is empty, default value will be used.
     * Nx2 matrix should be size of 2.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget10() throws Exception {
        TaggedValue tv1 = TestHelper.getTaggedValueWithTagType("documentation#since");
        TaggedValue tv2 = TestHelper.getTaggedValueWithTagType("documentation#version");
        tv1.setDataValue("1.0");
        tv2.setDataValue("");
        this.classifier.addTaggedValue(tv1);
        this.classifier.addTaggedValue(tv2);
        this.tagEditor.setTarget(this.classifier);
        assertEquals(3, this.getTableModel().getRowCount());
        assertEquals("new value", this.getTableModel().getValueAt(1, 1));
        assertOptionsForClass(this.getOptionComboBox());
    }
    /**
     * <p>
     * Test accuracy for method <code>refresh()</code>.
     * </p>
     */
    @SuppressWarnings("unchecked")
    public void testRefresh() {
        try {
            this.tagEditor.setTarget(this.classifier);

            List < String > row = new ArrayList();
            row.add("tagName");
            row.add("tagDoc");

            List < List < String > > values = (List < List < String > >) TestHelper
            .getField(this.getTableModel(), "values");
            values.add(row);


            this.tagEditor.refresh();
        } catch (Exception e) {
            fail("refresh failed");
        }

    }
}
