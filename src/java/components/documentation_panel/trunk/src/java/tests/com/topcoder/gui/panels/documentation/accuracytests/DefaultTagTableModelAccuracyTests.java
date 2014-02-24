/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * @ DefaultTagTableModelAccuracyTests.java
 */
package com.topcoder.gui.panels.documentation.accuracytests;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditor;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagTableModel;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.OperationImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * The <code>DefaultTagTableModel</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>DefaultTagTableModel</code> class.
 * </p>
 *
 * @author still
 * @version 1.0
 */
public class DefaultTagTableModelAccuracyTests extends TestCase {
  /**
     * <p>
     * Represents the config file used for test by the ConfigManager.
     * </p>
     */
    private static final String CONFIG_FILE = "accuracytests/tagEditor.xml";;

  /**
     * <p>
     * Represents the property <code>namespace</code> of DefaultTagEditor.
     * It is used for getting the value under the <code>namespace</code> by the ConfigManager.
     * </p>
     */
    private static final String NAMESPACE = "defaultTagEditor";

    /**
     * <p>
     * Default column names if not configuration.
     * </p>
     */
    private static final String[] DEFAULT_COLUMN_NAMES = {"Tag", "Documentation"};

    /**
     * <p>
     * Default new tag prompt if not configuration.
     * </p>
     */
    private static final String DEFAULT_TAG_PROMPT = "Insert new tag...";


    /**
     * <p>
     * Default new value prompt if not configuration.
     * </p>
     */
    private static final String DEFAULT_VALUE_PROMPT = "new value";

    /**
     * <p>
     * The instance of <code>DefaultTagTableModel</code> for test.
     * </p>
     */
    private DefaultTagTableModel tagTable = null;

    /**
     * <p>
     * The instance of <code>DefaultTagEditor</code> for test.
     * </p>
     */
    private DefaultTagEditor parent = null;
    /**
     * <p>
     * The instance of <code>ModelElement</code> for test.
     * </p>
     */
    private ModelElement element = null;

    /**
     * <p>
     * The instance of <code>ConfigManager</code> for test.
     * </p>
     */
    private ConfigManager cm = null;

    /**
     * <p>
     * Test suite of <code>DefaultTagTableModelAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>DefaultTagTableModelAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(DefaultTagTableModelAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.clearConfig();
        cm = ConfigManager.getInstance();

        // load XML file used to creat TagOptionManager.
        cm.add(CONFIG_FILE);
        parent = new DefaultTagEditor(NAMESPACE);
        element = new OperationImpl();
        parent.setTarget(element);
        tagTable = new DefaultTagTableModel(parent);
    }

    /**
     * <p>
     * Accuracy Test of the <code>DefaultTagTableModel(DefaultTagEditor)</code> constructor.
     * </p>
     */
    public void testconstructor_Simple() {
        tagTable = new DefaultTagTableModel(parent);

        // creat a new instance.
        assertNotNull("Constructor should work well.", tagTable);

        // get the first col name to check the constructor.
        assertEquals("The col name expected to be equal", DEFAULT_COLUMN_NAMES[0],
            tagTable.getColumnName(0));

        // get the second col name to check the constructor.
        assertEquals("The col name expected to be equal", DEFAULT_COLUMN_NAMES[1],
            tagTable.getColumnName(1));
    }

    /**
     * <p>
     * Accuracy Test of the <code>DefaultTagTableModel(DefaultTagEditor, String[], String, String)</code> constructor.
     * </p>
     */
    public void testconstructor_Complex() {
        String [] cols = new String []{"tag", "value"};

        tagTable = new DefaultTagTableModel(parent, cols, null, null);

        // creat a new instance.
        assertNotNull("Constructor should work well.", tagTable);

        // get the first col name to check the constructor.
        assertEquals("The col name expected to be equal", cols[0],
            tagTable.getColumnName(0));

        // get the second col name to check the constructor.
        assertEquals("The col name expected to be equal", cols[1],
            tagTable.getColumnName(1));
    }
    /**
     * <p>
     * Accuracy Test of the <code>getColumnCount()</code> method.
     * </p>
     */
    public void testgetColumnCount() {
      // get the col number to check the method.
        assertEquals("The col number expected to be 2", 2,
            tagTable.getColumnCount());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getRowCount()</code> method.
     * </p>
     */
    public void testgetRowCount() {
      // get the row number to check the method.
        assertEquals("The col number expected to be 1", 1,
            tagTable.getRowCount());
        // creat a new vlaues.
        List<String> row = new ArrayList<String>();
        row.add("col1");
        row.add("col2");
        List<List<String>> values = new ArrayList<List<String>>();
        for (int i = 0; i < 4; i++) {
            values.add(row);
        }

        // create a new value objects
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue>();
        for (int i = 0; i < 4; i++) {
            valueObjects.add(taggedObject);
        }

        // update the new values.
        tagTable.updateValues(values, valueObjects);
        //  get the row number to check the method.
        assertEquals("The col number expected to be 5", 5,
            tagTable.getRowCount());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getColumnName(int)</code> method.
     * </p>
     */
    public void testgetColumnName() {
      // get the first col name to check the method.
        assertEquals("The col name expected to be equal", DEFAULT_COLUMN_NAMES[0],
            tagTable.getColumnName(0));

        // get the second col name to check the method.
        assertEquals("The col name expected to be equal", DEFAULT_COLUMN_NAMES[1],
            tagTable.getColumnName(1));

        //  get the out range col name to check the method.
        assertNull("The col name expected to be null", tagTable.getColumnName(3));

        // creat a new col names.
        String [] cols = new String []{"new tag", "new value"};

        tagTable = new DefaultTagTableModel(parent, cols, null, null);

        // get the first col name to check the constructor.
        assertEquals("The col name expected to be equal", cols[0],
            tagTable.getColumnName(0));

        // get the second col name to check the constructor.
        assertEquals("The col name expected to be equal", cols[1],
            tagTable.getColumnName(1));
        // get the out range col name to check the method.
        assertNull("The col name expected to be null", tagTable.getColumnName(-1));
    }

    /**
     * <p>
     * Accuracy Test of the <code>getColumnClass(int)</code> method.
     * </p>
     */
    public void testgetColumnClass() {
      // get the first col class to check the method.
        assertEquals("The col class expected to be equal", String.class,
            tagTable.getColumnClass(0));

        // get the second col class to check the method.
        assertEquals("The col class expected to be equal", String.class,
            tagTable.getColumnClass(1));

        //  get the out range col class to check the method.
        assertNull("The col class expected to be null", tagTable.getColumnClass(3));

        // get the out range col class to check the method.
        assertNull("The col class expected to be null", tagTable.getColumnClass(-1));
    }

    /**
     * <p>
     * Accuracy Test of the <code>isCellEditable(int, int)</code> method.
     * </p>
     */
    public void testisCellEditable() {
      // get the cell (0, 0) to check the method.
        assertTrue("The cell expected to be editable", tagTable.isCellEditable(0, 0));
        //  get the cell (0, 1) to check the method.
        assertFalse("The cell expected to be not editable", tagTable.isCellEditable(0, 1));

      // creat a new vlaues.
        List<String> row = new ArrayList<String>();
        row.add("col1");
        row.add("col2");
        List<List<String>> values = new ArrayList<List<String>>();
        for (int i = 0; i < 4; i++) {
            values.add(row);
        }

        // create a new value objects
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue>();
        for (int i = 0; i < 4; i++) {
            valueObjects.add(taggedObject);
        }

        // update the new values.
        tagTable.updateValues(values, valueObjects);
      // get the cell (3, 1) to check the method.
        assertTrue("The cell expected to be editable", tagTable.isCellEditable(3, 1));
        // get the cell (3, 0) to check the method.
        assertFalse("The cell expected to be not editable", tagTable.isCellEditable(3, 0));
        // get the cell (4, 0) to check the method.
        assertTrue("The cell expected to be editable", tagTable.isCellEditable(4, 0));
        // get the cell (4, 1) to check the method.
        assertFalse("The cell expected to be not editable", tagTable.isCellEditable(4, 1));
    }

    /**
     * <p>
     * Accuracy Test of the <code>getValueAt(int, int)</code> method.
     * </p>
     */
    public void testgetValueAt() {
      // creat a new vlaues.
        List<String> row = new ArrayList<String>();
        row.add("col1");
        row.add("col2");
        List<List<String>> values = new ArrayList<List<String>>();
        for (int i = 0; i < 4; i++) {
            values.add(row);
        }

        // create a new value objects
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue>();
        for (int i = 0; i < 4; i++) {
            valueObjects.add(taggedObject);
        }

        // update the new values.
        tagTable.updateValues(values, valueObjects);
      // get the cell (3, 1) to check the method.
        assertEquals("The value expected to be equal", "col2",
            tagTable.getValueAt(3, 1));
        // get the cell (2, 0) to check the method.
        assertEquals("The value expected to be equal", "col1",
            tagTable.getValueAt(2, 0));
        // get the cell (4, 0) to check the method.
        assertEquals("The value expected to be equal", DEFAULT_TAG_PROMPT,
            tagTable.getValueAt(4, 0));
        // get the cell (4, 1) to check the method.
        assertEquals("The value expected to be equal", "",
            tagTable.getValueAt(4, 1));
        //get the cell out of range to check the method.
        assertNull("The value expected to be null", tagTable.getValueAt(10, 0));
    }

    /**
     * <p>
     * Accuracy Test of the <code>setValueAt(Objectint, int)</code> method.
     * </p>
     */
    public void testsetValueAt() {
      // creat a new vlaues.
        List<String> row = new ArrayList<String>();
        row.add("col1");
        row.add("col2");
        List<List<String>> values = new ArrayList<List<String>>();
        for (int i = 0; i < 4; i++) {
            values.add(row);
        }

        // create a new value objects
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue>();
        for (int i = 0; i < 4; i++) {
            valueObjects.add(taggedObject);
        }

        // update the new values.
        tagTable.updateValues(values, valueObjects);
        // get the row number to check the method.
        assertEquals("The value expected to be equal", 5,
            tagTable.getRowCount());

        // delete the row 3
        tagTable.setValueAt("", 2, 1);
      // get the row number to check the method.
        assertEquals("The value expected to be equal", 4,
            tagTable.getRowCount());

        // update the row 2;
        tagTable.setValueAt("my", 1, 1);
        // get the cell (2, 0) to check the method.
        assertEquals("The value expected to be equal", "my",
            tagTable.getValueAt(1, 1));

        // creat a new row
        tagTable.setValueAt("new Row", 3, 0);
        // get the cell (3, 0) to check the method.
        assertTrue("The value expected to be equal", tagTable.getValueAt(3, 0).toString().endsWith("new Row"));
        //  get the cell (3, 0) to check the method.
        assertEquals("The value expected to be equal", DEFAULT_VALUE_PROMPT,
            tagTable.getValueAt(3, 1));
    }

}
