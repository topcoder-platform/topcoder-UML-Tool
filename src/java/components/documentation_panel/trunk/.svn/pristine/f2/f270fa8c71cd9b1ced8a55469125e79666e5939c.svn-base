/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;


/**
 * <p>
 * Custom table model class to represent the information stored in a
 * tag table. This is achieved by holding a underlying two dimensional
 * , Nx2 matrix of Strings in the <code>values</code> member.
 * </p>
 *
 * <p>
 *  <strong>Table Model Structure:</strong>
 *  <pre>
 *    ----------------------------
 *    |   | column1  | columns2  |
 *    |row| tag name | tag value |  values[0]
 *    |row| tag name | tag value |  values[1]
 *    |...| ......   | ......    |  ......
 *    |row| tag name | tag value |  values[values.size-1]
 *    |row| new combo| empty     | (extra row)
 *    ----------------------------
 *  </pre>
 *  The first column compromising the names of tags, and the second their
 *  corresponding documentations of tags.
 * </p>
 *
 * <p>
 *   <strong>Note:</strong>
 *   The last row of the table is special, it represents the the new-tag combo
 *   box, and only the tag name is creatable. All other rows only have their
 *   2nd column (documentation) editable.
 * </p>
 *
 * <p>
 *  <strong>Customizable:</strong>
 *  This default tag table model contains some customizable values, to allow
 *  the prompts and column names to be changed based on configuration.
 * </p>
 *
 * <p>
 *  <strong>Default:</strong>
 *   <ul>
 *    <li>Column names default to {"Tag", "Documentation"}.</li>
 *    <li>New tag name prompt defaults to "Insert new tag...".</li>
 *    <li>New tag value prompt defaults to "new value".</li>
 *   </ul>
 * </p>
 *
 * <p>
 *  <strong>Thread Safety:</strong>
 *  This class is not thread safe. There is no protection against concurrent
 *  set/get accesses. Applications using this class must provide their own
 *  thread safe handling.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class DefaultTagTableModel extends AbstractTableModel {
    /**
     * <p>
     * Serial Version UID.
     * </p>
     */
    private static final long serialVersionUID = -3306210247362304961L;

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
    private static final String DEFAULT_NEW_TAG_PROMPT = "Insert new tag...";

    /**
     * <p>
     * Default new value prompt if not configuration.
     * </p>
     */
    private static final String DEFAULT_NEW_VALUE_PROMPT = "new value";

    /**
     * <p>
     * Names of the columns in the table. Defaults to {"Tag",
     * "Documentation"}, but can be changed on construction
     * <code>DefaultTagTableModel(DefaultTagEditor, String[],
     * String, String)</code>. It is immutable.
     * </p>
     */
    private final String[] columnNames;

    /**
     * <p>
     * Prompt to display on dropdown for tag options. Defaults to
     * "Insert new tag...", but can be changed on construction
     * <code>DefaultTagTableModel(DefaultTagEditor, String[],
     * String, String)</code>. It is immutable.
     * </p>
     */
    private final String newTagPrompt;

    /**
     * <p>
     * Prompt to display as documentation on a newly added tag. This
     * defaults to "new value", but can be changed on construction
     * <code>DefaultTagTableModel(DefaultTagEditor, String[],
     * String, String)</code>. It is immutable.
     * </p>
     */
    private final String newValuePrompt;

    /**
     * <p>
     *  <strong>Data Structure:</strong>
     *  <pre>
     *    ----------------------------
     *    |   | column1  | columns2  |
     *    |row| tag name | tag value |  values[0]
     *    |row| tag name | tag value |  values[1]
     *    |...| ......   | ......    |  ......
     *    |row| tag name | tag value |  values[n-1]
     *    |row| new combo| empty     | (extra row, no contained in values)
     *    ----------------------------
     *  </pre>
     *  The Nx2 matrix of values contained within the table.
     *  It is always true that if this is Nx2, then the table with
     *  this as the model will have (N+1) rows and 2 columns, the
     *  extra being for the new-tag combo box (plus possibly one for
     *  the column headers).
     * </p>
     *
     * <p>
     *  <strong>Accessed by:</strong>
     *   <ul>
     *    <li><code>getValueAt()</code></li>
     *    <li><code>setValueAt()</code></li>
     *    <li><code>updateValues()</code></li>
     *   </ul>
     * </p>
     */
    private final List < List < String > > values;

    /**
     * <p>
     * The default editor which this table model's <code>JTable</code>
     * container is being displayed by. This is stored to allow the
     * model to refresh the editor's UI whenever a change is made.
     * </p>
     *
     * <p>
     * It is set on construction, cannot be null, and is immutable.
     * </p>
     */
    private final DefaultTagEditor parent;

    /*
     * BugFix: UML-11417
     * Add this field.
     */
    /**
     * <p>
     * Represents the list of all TaggedValue data objects managed by
     * this table - one for each row in the tag documentation panel.
     * Changes to the values list should be accompanied by a corresponding
     * change if the same type to this list.
     * Initially it is an empty list.
     * When tags are added, a new object is created manually and placed
     * in this list, just with correct model element, tag data and
     * definition type set.
     * When modified, nothing happens to these value objects other than
     * being passed to the event (it is up to the application to update them).
     * When deleted, the objects are simply deleted from the list.
     * </p>
     *
     * <p>
     * It is set on construction, cannot be null, and is immutable.
     * </p>
     */
    private final List<TaggedValue> valueObjects;

    /*
     * BugFix: UML-11417
     * Initialize the value objects list.
     */
/**
 * <p>
 * Constructs a new table model, using default column names/prompts
 * and the given non-null parent.
 * </p>
 *
 * <p>
 *  <strong>Default Values:</strong>
 *   <ul>
 *    <li>Column names are default to {"Tag","Documentation"}.</li>
 *    <li>Tag option prompt is default to "Insert new tag...".</li>
 *    <li>Tag value prompt is default to "new value".</li>
 *   </ul>
 * </p>
 * @param parent The default editor which this table model's JTable
 *        container is being displayed by.
 *
 * @throws IllegalArgumentException if the parent parameter is null
 */
    public DefaultTagTableModel(DefaultTagEditor parent) {
        DocumentPanelHelper.validateNotNull(parent,
             "Tag editor contains this table model");
        this.parent = parent;
        this.values = new ArrayList < List < String > >();
        this.columnNames = getColumnNames(null);
        this.newTagPrompt = getPrompt(null, true);
        this.newValuePrompt = getPrompt(null, false);

        /*
         * BugFix: UML-11417
         * Initialize the value objects list.
         */
        this.valueObjects = new ArrayList <TaggedValue> ();
    }

    /*
     * BugFix: UML-11417
     * Initialize the value objects list.
     */
/**
 * <p>
 * Constructs a new table model, initializing the non-null parent and also
 * setting the customized members if the provided parameters are non-null
 * (otherwise defaults are used).
 * </p>
 *
 * <p>
 *  <strong>Default Values:</strong>
 *   <ul>
 *    <li>If given <code>columnNames</code> is null, default to
 *        {"Tag","Documentation"}.</li>
 *    <li>If given <code>tagPrompt</code> is null, default to
 *        "Insert new tag...".</li>
 *    <li>If given <code>valuePrompt</code> is null, default to
 *        "new value".</li>
 *   </ul>
 * </p>
 * @param parent The default editor which this table model's <code>JTable</code>
 *        container is being displayed by.
 * @param columnNames pair of strings to use as the column names, Tag option
 *        column first then documentation. Possibly null. If not null then it
 *        should be exactly length of 2, and contains non-null column names.
 * @param tagPrompt Prompt given to user to select a new tag type for creation.
 *        Possibly null but should not be empty.
 * @param valuePrompt Prompt given to user to enter in documentation for a newly
 *        created tag. Possibly null but should not be empty.
 *
 * @throws IllegalArgumentException if parent is null, or columnNames
 *         is non-null but does not contain exactly two non-null strings.
 *         Or If passed in value prompt is not null but is empty.
 */
    public DefaultTagTableModel(DefaultTagEditor parent, String[] columnNames,
        String tagPrompt, String valuePrompt) {
        DocumentPanelHelper.validateNotNull(parent,
               "Tag editor contains this table model");
        this.parent = parent;
        this.values = new ArrayList < List < String > >();

        this.columnNames = getColumnNames(columnNames);
        this.newTagPrompt = getPrompt(tagPrompt, true);
        this.newValuePrompt = getPrompt(valuePrompt, false);

        /*
         * BugFix: UML-11417
         * Initialize the value objects list.
         */
        this.valueObjects = new ArrayList <TaggedValue> ();
    }

    /**
     * <p>
     * Get prompt. Called by constructors.
     * </p>
     *
     * @param prompt either null or read from configuration.
     * @param isTagPrompt indicate whether new tag prompt
     *        or new value prompt.
     *
     * @return new tag prompt or new value prompt.
     *
     * @throws IllegalArgumentException If prompt is not null but empty.
     */
    private String getPrompt(String prompt, boolean isTagPrompt) {
        if (prompt == null) {
            return isTagPrompt ? DEFAULT_NEW_TAG_PROMPT : DEFAULT_NEW_VALUE_PROMPT;
        } else {
            //New value prompt and new tag prompt should not be empty.
            DocumentPanelHelper.validateString(prompt,
                    isTagPrompt ? "New tag prompt" : "New value prompt");
            return prompt;
        }
    }
    /**
     * <p>
     * Get column names. Called by constructors.
     * </p>
     *
     * @param names either null or values read from configuration
     *
     * @return column names
     *
     * @throws IllegalArgumentException if names not null but the
     *         length is not 2, or contain null element.
     */
    private String[] getColumnNames(String[] names) {
        if (names != null) {
            if (names.length != 2) {
                throw new IllegalArgumentException(
                        "Column names must contain exactly two non-null strings.");
            }
            DocumentPanelHelper.validateNotNull(names[0],
                    "First column name of tag table");
            DocumentPanelHelper.validateNotNull(names[1],
                    "Second column name of tag table");
            return names;
        } else {
            return DEFAULT_COLUMN_NAMES;
        }
    }

    /**
     * <p>
     * Returns the number of columns in use in the table,
     * always 2 (tag and documentation).
     * </p>
     *
     * @return number of columns in the table, always 2.
     */
    public int getColumnCount() {
        return 2;
    }

    /**
     * <p>
     * Returns the number of rows in the table.
     * This is always one more than the number
     * of rows in the <code>values</code> matrix
     * to allow for the extra add-new-tag row.
     * </p>
     *
     * @return number of rows in table.
     */
    public int getRowCount() {
        return this.values.size() + 1;
    }

    /**
     * <p>
     * Returns the name of the given column.
     * If the column value given is not in the right range,
     * null is returned (SWING should make sure this will
     * not happen).
     * </p>
     *
     * @param col Column whose name is to be obtained.
     *
     * @return return the desired column name; If col is not
     *         in right range, null is returned.
     */
    public String getColumnName(int col) {
        if (!DocumentPanelHelper.checkColumnRange(col)) {
            return null;
        }
        return columnNames[col];
    }

    /**
     * <p>
     * Returns the <code>Class</code> of the given column.
     * If the column value given is not in the right range,
     * null is returned (SWING should make sure this will
     * not happen).
     * </p>
     *
     * @param col Column whose class is to be obtained.
     *
     * @return <code>String</code>'s <code>Class</code> if
     *         col is in right range, otherwise return null.
     */
    @SuppressWarnings("unchecked")
    public Class getColumnClass(int col) {
        if (!DocumentPanelHelper.checkColumnRange(col)) {
            return null;
        }
        return String.class;
    }

    /**
     * <p>
     * Returns whether or not a cell in the table is editable.
     *  <ul>
     *   <li>For the last row column 0(the new tag selector)
     *       is editable.</li>
     *   <li>For the other rows, column 1(the tag value) is
     *       editable.</li>
     *   <li>If the given row or col is out of range, false
     *       is returned.</li>
     *  </ul>
     * </p>
     *
     * <p>
     *  <strong>Row range:</strong>
     *  From 0 to <code>getRowCount()</code>-1 inclusively.
     * </p>
     *
     * <p>
     *  <strong>Column range:</strong>
     *  Either 0 or 1.
     * </p>
     *
     * @param row row of cell to be checked
     * @param col column of cell to be checked
     *
     * @return true If the given cell is editable; false otherwise.
     */
    public boolean isCellEditable(int row, int col) {
        if (!DocumentPanelHelper.checkRowRange(getRowCount(), row)) {
            return false;
        }
        return row == getRowCount() - 1
                ? col == 0  // only drop-down editable in last row
                : col == 1; // only documentation editable in non-last row
    }

    /**
     * <p>
     * returns the value within a given cell in the table.
     * If the row is not the last row, then the corresponding
     * tag value is returned; Otherwise, new tag prompt or
     * empty string is returned for column 0 or 1 respectively.
     * </p>
     *
     * <p>
     * If the cell given is not in the right range, null is
     * returned(SWING should make sure this will not happen).
     * </p>
     *
     * <p>
     *  <strong>Row range:</strong>
     *  From 0 to <code>getRowCount()</code>-1 inclusively.
     * </p>
     *
     * <p>
     *  <strong>Column range:</strong>
     *  Either 0 or 1.
     * </p>
     *
     * @param row row of cell to be obtained
     * @param col column of cell to be obtained
     *
     * @return returns the string to be displayed in the given cell.
     */
    public Object getValueAt(int row, int col) {
        if (!DocumentPanelHelper.checkColumnRange(col)
                || !DocumentPanelHelper.checkRowRange(getRowCount(), row)) {
            return null;
        }
        if (row == getRowCount() - 1) {
            return col == 0 ? this.newTagPrompt : "";
        }
        return values.get(row).get(col);
    }

    /*
     * BugFix: UML-11417
     * Whatever action is taking place (create/update/delete tag),
     * the action must also occur on the relevant valueObjects member
     * (corresponding to which row is being edited).
     */
    /**
     * <p>
     * Sets the value at a given cell.
     *  <ul>
     *   <li>If given <code>row</code> equals the size of current
     *       <code>values</code> of table, the <code>value</code>
     *       represents the tag name of the new tag being created.
     *       A new row is added into <code>values</code> of table,
     *       and corresponding tag created event is fired.
     *       </li>
     *   <li>If the value is length of 0, it means that the tag is
     *       being deleted. The given row is removed from <code>
     *       values</code>, and corresponding tag deleted event is
     *       fired.</li>
     *   <li>Otherwise the tag's documentation is being modified,
     *       the given row in <code>values</code> is changed, and
     *       corresponding tag updated event is fired.</li>
     *  </ul>
     *  Finally, the parent editor is refreshed to reflect the new
     *  table appearance.
     * </p>
     *
     * <p>
     *  <strong>Note:</strong>
     *  If row or col is out of range(SWING should make
     *  sure this will not happen), simply do nothing. If given value is not
     *  type of <code>String</code>, string representation of the object is
     *  used.
     * </p>
     *
     * <p>
     * Fixed:
     * Note that whatever action is taking place (create/update/delete tag),
     * the action must also occur on the relevant valueObjects member
     * (corresponding to which row is being edited). See the "Tag Edit"
     * Sequence Diagram for more details.
     * </p>
     *
     * <p>
     *  <strong>Row range:</strong>
     *  From 0 to <code>getRowCount()</code>-1 inclusively.
     * </p>
     *
     * <p>
     *  <strong>Column range:</strong>
     *  Either 0 or 1.
     * </p>
     *
     * @param value New value used within cell. Possibly null.
     *        If it's null, do nothing.
     * @param row Row of cell being changed
     * @param col Column of cell being changed
     *
     * @throws IllegalArgumentException if the parent tag editor
     *         currently has no target <code>ModelElement</code>
     *         being managed
     */
    public void setValueAt(Object value, int row, int col) {
        if (!isCellEditable(row, col) || value == null) {
            return;
        }

        String message = (value instanceof String
                ? (String) value : value.toString()).trim();

        // CREATE
        if (row == values.size()) {
            ArrayList < String > newRow = new ArrayList < String >();
            newRow.add(DocumentPanelHelper.getTagNameWithPrefix(message));
            newRow.add(this.newValuePrompt);
            values.add(newRow);

            /*
             * BugFix: UML-11417
             * Whatever action is taking place (create/update/delete tag),
             * the action must also occur on the relevant valueObjects member
             * (corresponding to which row is being edited).
             */
            TagDefinition tagDefinition = new TagDefinitionImpl();
            tagDefinition.setTagType("documentation#@" + message);
            TaggedValue taggedObject = new TaggedValueImpl();
            taggedObject.setType(tagDefinition);
            taggedObject.setDataValue(this.newValuePrompt);
            valueObjects.add(taggedObject);
            parent.fireTagCreated(taggedObject, message, this.newValuePrompt);

        // DELETE
        } else if (message.length() == 0) {
            String tagName = values.get(row).get(0);
            String prev = values.get(row).get(1);
            values.remove(row);

            /*
             * BugFix: UML-11417
             * Whatever action is taking place (create/update/delete tag),
             * the action must also occur on the relevant valueObjects member
             * (corresponding to which row is being edited).
             */
            TaggedValue taggedObject = valueObjects.get(row);
            valueObjects.remove(row);
            parent.fireTagDeleted(taggedObject, tagName, prev);

        // UPDATE
        } else {
            String prev = values.get(row).get(1);
            values.get(row).set(1, message);
            /*
             * BugFix: UML-11417
             * Whatever action is taking place (create/update/delete tag),
             * the action must also occur on the relevant valueObjects member
             * (corresponding to which row is being edited).
             */
            parent.fireTagUpdated(valueObjects.get(row) ,
                    values.get(row).get(0), prev, message);
        }
        //Refresh
        parent.refresh();
    }

    /*
     * BugFix: UML-11417
     * Add valueObjects parameter.
     */
    /**
     * <p>
     * Updates the current tags in use, by setting the values matrix.
     * This must be an Nx2 matrix containing no null values. Each element
     * of the matrix represents a row of the tag table.
     * </p>
     *
     * <p>
     * Once the values is set, the parent tag editor is refreshed to reflect
     * any UI changes.
     * </p>
     *
     * @param values Values to use for the table.
     * @param valueObjects Tagged objects to use for the table.
     *
     * @throws IllegalArgumentException if the parameter is null, or contains
     *         null element, or its elements don't have size of 2 or contain
     *         null/empty(trimmed) strings.
     */
    public void updateValues(List < List < String > > values, List < TaggedValue > valueObjects) {
        DocumentPanelHelper.validateNotNull(values, "Values of tag table");
        DocumentPanelHelper.validateNotNull(valueObjects, "Tagged objects of tag table");
        for (List < String > row : values) {
            DocumentPanelHelper.validateNotNull(row, "Row of tag table");
            //Size must be 2
            if (row.size() != 2) {
                throw new IllegalArgumentException(
                        "Each row of tag table must be size of 2.");
            }
            //The Nx2 matrix does not allow null/empty(trimmed) values
            DocumentPanelHelper.validateString(row.get(0), "Tag name");
            DocumentPanelHelper.validateString(row.get(1), "Tag value");
        }
        for (TaggedValue taggedObject : valueObjects) {
            DocumentPanelHelper.validateNotNull(taggedObject, "Tagged object of tag table");
        }

        this.values.clear();
        this.values.addAll(values);
        this.valueObjects.clear();
        this.valueObjects.addAll(valueObjects);
        this.parent.refresh();
    }

    /**
     * <p>
     * Return new value prompt when tag is created.
     * </p>
     *
     * <p>
     * The returned value is never null or empty.
     * </p>
     *
     * @return new value prompt
     */
    public String getNewValuePrompt() {
        return this.newValuePrompt;
    }
    /**
     * <p>
     * Return new tag prompt before user select from combo box.
     * </p>
     *
     * <p>
     * The returned value is never null or empty.
     * </p>
     *
     * @return new value prompt
     */
    public String getNewTagPrompt() {
        return this.newTagPrompt;
    }
}
