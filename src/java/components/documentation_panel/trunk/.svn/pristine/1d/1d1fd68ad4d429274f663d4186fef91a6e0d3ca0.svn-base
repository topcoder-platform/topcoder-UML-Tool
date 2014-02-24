/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.TagEditor;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * <p>
 * A simple, default tag editor panel provided with this component. It contains a two-column table, where tags can
 * be edited from a drown-down combo-box on the left, then have their documentation modified on the right.
 * </p>
 *
 * <p>
 * This is obtained by controlling a custom table model which is instance of <code>DefaultTagTableModel</code>, as
 * well as an object to manage all the tag options available which is instance of <code>TagOptionManager
 * </code>.
 * </p>
 *
 * <p>
 * <strong>Sample Configuration:</strong>
 *
 * <pre>
 *  &lt;Config name=&quot;plugins_defaultTagEditor&quot;&gt;
 *    &lt;!-- set up the new tag prompt Value here if desired --&gt;
 *    &lt;Property name=&quot;tagprompt&quot;&gt;
 *       &lt;Value&gt;Insert new tag...&lt;/Value&gt;
 *    &lt;/Property&gt;
 *
 *    &lt;!-- set up the new tag documentation string here if desired --&gt;
 *    &lt;Property name=&quot;valueprompt&gt;
 *        &lt;Value&gt;new Value&lt;/Value&gt;
 *    &lt;/Property&gt;
 *
 *    &lt;!-- set up the two column names here if desired--&gt;
 *    &lt;Property name=&quot;columnnames&quot;&gt;
 *        &lt;Value&gt;Tag&lt;/Value&gt;
 *        &lt;Value&gt;Documentation&lt;/Value&gt;
 *    &lt;/Property&gt;
 *
 *    &lt;!-- required parameter, option manager namespace --&gt;
 *    &lt;Property Value=&quot;tagoptionNamespace&quot;&gt;
 *        &lt;Value&gt;plugins_defaultTagOptions&lt;/Value&gt;
 *    &lt;/Property&gt;
 *   &lt;/Config&gt;
 * </pre>
 *
 * </p>
 *
 * <p>
 * <strong>Thread Safety:</strong> This class is not thread safe. The table model is triggered by user GUI actions
 * which can occur at any time, for example possibly when the model target is being changed by a
 * <code>setTarget()</code> call, which may cause problems.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class DefaultTagEditor extends TagEditor {

    /**
     * <p>
     * Serial Version UID.
     * </p>
     */
    private static final long serialVersionUID = 8350117442642219001L;

    /**
     * <p>
     * The prefix of tag name for <code>Parameter</code>.
     * </p>
     */
    private static final String PARAM_PREFIX = "@param ";

    /**
     * <p>
     * Property name of the new tag prompt.
     * This property is optional.
     * </p>
     */
    private static final String TAG_PROMPT = "tagprompt";

    /**
     * <p>
     * Property name of the new tag value prompt.
     * This property is optional.
     * </p>
     */
    private static final String VALUE_PROMPT = "valueprompt";

    /**
     * <p>
     * Property name of the column names.
     * This property is optional.
     * </p>
     */
    private static final String COLUMN_NAMES = "columnnames";

    /**
     * <p>
     * Property name of the namespace for <code>TagOptionManager</code>.
     * This property is required.
     * </p>
     */
    private static final String TAG_OPTION_NS = "tagoptionNamespace";

    /**
     * <p>
     * Standard Element Name for documentation tag which is defined in
     * OMG UML Specification Version 1.5 formal/03-03-01.
     * </p>
     */
    private static final String DOCUMENTATION = "documentation";

    /**
     * <p>
     * SWING component contained that displays the tag table of
     * documentation. The table is driven by its model, contained as the
     * <code>tagModel</code> instance.
     * </p>
     *
     * <p>
     * It has two columns, with configurable titles defaulting to "Tag"
     * and "Documentation", the left editable by combo box, the right by
     * simple text-box, which cannot be reordered. In addition, only one
     * cell is to be selectable at a time.
     * </p>
     *
     * <p>
     * This is set to a non-null object on construction, attached to the
     * model and configured appropriately, then immutable.
     * </p>
     */
    private final JTable tagTable;

    /**
     * <p>
     * Reference to the underlying model which stores information
     * within and about the tag table.
     * </p>
     *
     * <p>
     * This is set at construction to a new <code>DefaultTagTableModel</code>
     * instance, possibly using parameters from configuration. This member is
     * immutable, and non-null.
     * </p>
     */
    private final DefaultTagTableModel tagModel;

    /**
     * <p>
     * Reference to the manager in charge of loading and presenting the
     * tag name options for each element type.
     * </p>
     *
     * <p>
     * This is immutable, set at construction to a non-null instance.
     * </p>
     */
    private final TagOptionManager optionManager;

/**
 * <p>
 * Constructs a new default tag editor by reading in configuration details,
 * including namespace for the <code>TagOptionManager</code>, and any
 * customizable table options (column names, default prompt values).
 * </p>
 *
 * <p>
 *  <strong>UI:</strong>
 *  The <code>JScrollPane</code> wrapped around the <code>JTable</code> element
 *  allowing vertical scrolling only when it is needed (but not horizontal).
 * </p>
 *
 * <p>
 *  <strong>This constructor initialize:</strong>
 *  <ul>
 *   <li>A <code>DefaultTagTableModel</code> as a model in MVC pattern
 *       to store the values within a Nx2 matrix.</li>
 *   <li>A <code>TagOptionManager</code> to manage the tag options
 *       for given <code>ModelElement</code>.</li>
 *  </ul>
 * </p>
 *
 * @see <code>DefaultTagTableModel</code>
 * @see <code>TagOptionManager</code>
 *
 * @param namespace Namespace in configuration to load from.
 *
 * @throws DocumentationPanelConfigurationException if there are problems
 *         loading from configuration.
 */
    public DefaultTagEditor(String namespace)
        throws DocumentationPanelConfigurationException {
        try {
            ConfigManager configManager = ConfigManager.getInstance();
            String tagPrompt = configManager.getString(namespace, TAG_PROMPT);
            String valuePrompt = configManager.getString(namespace, VALUE_PROMPT);
            String[] columnNames = configManager.getStringArray(namespace, COLUMN_NAMES);

            setLayout(new BorderLayout());

            //Create table model
            this.tagModel = new DefaultTagTableModel(this, columnNames, tagPrompt, valuePrompt);

            //Create table
            this.tagTable = new JTable(this.tagModel);
            this.tagTable.getTableHeader().setReorderingAllowed(false);
            this.tagTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

            //Create tag options manager
            String optionNS = configManager.getString(namespace, TAG_OPTION_NS);
            this.optionManager = new TagOptionManager(optionNS);

            JScrollPane scroller = new JScrollPane(tagTable,
                    JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            add(scroller);
        } catch (NullPointerException e) {
            throw new DocumentationPanelConfigurationException(
                    "The given namespace is null", e);
        } catch (UnknownNamespaceException e) {
            throw new DocumentationPanelConfigurationException(
                  "The given namespace is unknown", e);
        } catch (IllegalArgumentException e) {
            throw new DocumentationPanelConfigurationException(
                  "The configured properties for table model contain invalid values", e);
        }
    }

    /*
     * BugFix: UML-11417
     * Update table with value objects parameter.
     */
    /**
     * <p>
     * Set the <code>ModelElement</code> whose tags are to be displayed
     * and editable. If the <code>ModelElement</code> is instance of
     * <code>Operation</code>, the tags of each <code>Parameter</code> of
     * the <code>Operation</code> are also displayed.
     * </p>
     *
     * <p>
     *  <strong>Explain of tags of given <code>ModelElement</code>:</strong>
     *   <ul>
     *    <li>Tag type: The tag type of <code>TaggedValue</code> should start
     *        with "documentation#". For <code>Parameter</code>, the tag type
     *        should equal "documentation".
     *    </li>
     *    <li>Tag name: Given tag type starts with "documentation#", the stuff
     *        after the # is tag's name. For <code>Parameter</code>, the tag's
     *        name is the <code>Parameter</code>'s name.
     *    </li>
     *    <li>Tag documentation: The documentation of a tag is <code>TaggedValue</code>
     *        's dataValue. If the documentation of tag is empty or null, default
     *        value is used.
     *    </li>
     *  </ul>
     *  <strong>Note for tag name:</strong><br/>
     *   <ul>
     *    <li>If the retrieved tag name is null or empty(trimmed), the tag
     *        is ignored.</li>
     *    <li>If the retrieved tag name is not prefixed with "@", prefix "@" before
     *        tag name.</li>
     *    <li>For <code>Parameter</code>, the tag name is prefixed with "@param"
     *        before <code>Parameter</code>'s name.</li>
     *   </ul>
     * </p>
     *
     * <p>
     * This changes the <code>DefaultTagTableModel</code> to reflect the tags
     * currently attached to the new element, and also changes the edit mode
     * of the first column, using a combo-box of options obtained from the
     * <code>TagOptionManager</code>.
     * </p>
     *
     * <p>
     * If no options are stored, an <code> UnknownElementTypeException</code>
     * is thrown, and the table is cleared.
     * </p>
     *
     * @param element The new <code>ModelElement</code> whose tags are to be
     *        displayed.
     *
     * @throws IllegalArgumentException if the given element is null
     * @throws UnknownElementTypeException if the type of element passed has no
     *         tag options
     */
    @SuppressWarnings("unchecked")
    public void setTarget(ModelElement element) throws UnknownElementTypeException {
        // UML-558: Documentation panel is not updating
        if (tagTable.getCellEditor() != null) {
            if (tagTable.getEditorComponent() instanceof JComboBox) {
                tagTable.getCellEditor().cancelCellEditing();
            } else {
                tagTable.getCellEditor().stopCellEditing();
            }
        }

        super.setTarget(element);

        List < List < String > > tableValues =
            new ArrayList();

        List < TaggedValue > valueObjects =
            new ArrayList();

        //Get tag options
        List < String > opts = null;
        try {
            opts =
                 this.optionManager.getTagOptions(element.getClass().getName());
        } catch (UnknownElementTypeException e) {
            //Clear table
            this.tagModel.updateValues(tableValues, valueObjects);
            throw e;
        }

        //If ModelElement instance of Operation
        if (element instanceof Operation) {
            List < Parameter > parameters = ((Operation) element).getParameters();
            //See BehavioralFeatureAbstractImpl.getParameters(), it never returns null.
            //But in case any extending classes override this method and it possibly
            //return a null value, check whether null here.
            if (parameters != null) {
                //For each Parameter
                for (Parameter p : parameters) {
                    //See BehavioralFeatureAbstractImpl, this class ensure the parameter
                    //list will never contain null value, but in case any extending
                    //classes change this behavior, check whether null here.
                    if (p != null) {
                       //Tag type should equal "documentation"
                        populateTableValues(tableValues, valueObjects, p, DOCUMENTATION, true);
                    }
                }
            }
        } //End for Operation

        //Tag type should start with "documentation#"
        populateTableValues(tableValues, valueObjects, element, DOCUMENTATION + "#", false);

        /*
         * BugFix: UML-11417
         * Update table with value objects parameter.
         */
        // Get tagged values from model element
        valueObjects.addAll(element.getTaggedValues());

        /*
         * BugFix: UML-11417
         * Update table with value objects parameter.
         */
        //Update tag model
        this.tagModel.updateValues(tableValues, valueObjects);

        //Set cell editor of column 0
        JComboBox comboBox = new JComboBox();
        for (String opt : opts) {
            comboBox.addItem(opt);
        }
        //Cancel cell editing
        TableCellEditor previousCellEditor = this.tagTable.getColumnModel().getColumn(0).getCellEditor();
        if (previousCellEditor != null) {
            previousCellEditor.cancelCellEditing();
        }
        this.tagTable.getColumnModel().getColumn(0).setCellEditor(
                new DefaultCellEditor(comboBox));
    }

    /*
     * BugFix: UML-11417
     * Add code to populate value objects.
     */
    /**
     * <p>
     * Populate table values which is the Nx2 matrix with given
     * <code>ModelElement</code> and desired tag type.
     * </p>
     *
     * <p>
     *  <strong>Called by:</strong>
     *   <ul>
     *    <li><code>setTarget()</code></li>
     *   </ul>
     * </p>
     *
     * @param tableValues table values which is the Nx2 matrix to populate
     * @param valueObjects value objects to populate
     * @param element <code>ModelElement</code> to get tag name and tag
     *        documentation
     * @param type desired tag type. Either be "documentation" or begin with
     *        "documentation#"
     * @param isParameter indicate whether the passed in element is instance
     *        of <code>Parameter</code>. If true tag type should equal the
     *        given type; otherwise tag type should start with it.
     */
    private void populateTableValues(List < List < String > > tableValues,
            List < TaggedValue > valueObjects,
            ModelElement element, String type, boolean isParameter) {
        Collection < TaggedValue > taggedValues = element.getTaggedValues();

        boolean parameterDocFound = false;

        //See ModelElementAbstractImpl.getTaggedValues(), it never returns null.
        //But in case any extending classes override this method and it possibly
        //return a null value, check it here.
        if (taggedValues != null) {

            for (TaggedValue tv : taggedValues) {
                //Check tag type, for Parameter should equal "documentation",
                //otherwise should start with "documentation#"
                if (DocumentPanelHelper.checkTagType(tv, type, isParameter)) {
                    addToTableValues(element, tableValues, valueObjects, tv, isParameter);
                    //For Parameter, just use the first tag whose type
                    //matching "documentation"
                    if (isParameter) {
                        parameterDocFound = true;
                        break;
                    }
                }
            }
        }

        //For Parameter which does not have a "documentation" tag found
        if (isParameter && !parameterDocFound) {
            addToTableValues(element, tableValues, valueObjects, null, true);
        }
    }

    /*
     * BugFix: UML-11417
     * Add code to populate value objects.
     */
    /**
     * <p>
     * Add {name, doc} of given <code>ModelElement</code> element to Nx2 matrix.
     * </p>
     *
     * @param element <code>ModelElement</code>
     * @param tableValues tableValues table values which is the Nx2 matrix to populate
     * @param valueObjects value objects to populate
     * @param tv <code>TaggedValue</code> to get tag name and tag doc
     * @param isParameter Indicate whether passed in element
     *        is instance of <code>Parameter</code>.
     *
     * @return true If passed in isParameter is true and <code>ModelElement</code> element
     *         contains valid tag name and tag documentation. Otherwise return false.
     */
    @SuppressWarnings("unchecked")
    private boolean addToTableValues(ModelElement element,
            List < List < String > > tableValues, List < TaggedValue > valueObjects,
            TaggedValue tv, boolean isParameter) {
        //Get tag name
        String tagName = this.getTagName(element, tv, isParameter);
        //Get tag documentation
        String tagDoc = this.getTagDoc(tv);

        //Nx2 matrix does not allow empty value;
        //Check tag name is not empty;
        //getTagDoc() always return a non-null and non-empty value,
        //so no need to check tag documentation.
        if (DocumentPanelHelper.checkNotEmpty(tagName)) {
            //For Parameter, prefix "@param " before the tag name
            if (isParameter) {
                tagName = PARAM_PREFIX + tagName;
                /*
                 * BugFix: UML-11417
                 * Add code to populate value objects.
                 */
                if (tv == null) {
                    TagDefinition tagDefinition = new TagDefinitionImpl();
                    tagDefinition.setTagType(DocumentPanelHelper.getTagNameWithPrefix(tagName));
                    tv = new TaggedValueImpl();
                    tv.setType(tagDefinition);
                    tv.setDataValue(tagDoc);
                }
            }
            List < String > row = new ArrayList();
            row.add(DocumentPanelHelper.getTagNameWithPrefix(tagName));
            row.add(tagDoc);
            tableValues.add(row);
            /*
             * BugFix: UML-11417
             * Add code to populate value objects.
             */
            valueObjects.add(tv);
            return isParameter;
        }
        return false;
    }
    /**
     * <p>
     * Get tag name of <code>TaggedValue</code>.
     * </p>
     *
     * <p>
     * Called by <code>addToTableValues()</code>.
     * </p>
     *
     * @param element <code>ModelElement</code>. If it's
     *        instance of <code>Parameter</code>, the passed
     *        in isParameter should be true.
     * @param tv <code>TaggedValue</code> to get tag name.
     *        Possibly null for <code>Parameter</code>.
     * @param isParameter Indicate whether passed in element
     *        is instance of <code>Parameter</code>.
     *
     * @return tag name
     */
    private String getTagName(ModelElement element, TaggedValue tv, boolean isParameter) {
        if (!isParameter) {
            //Tag type has been check by DocumentPanelHelper.checkTagType()
            //It's safe here, without possible NPE
            String tagType = tv.getType().getTagType();
            //Stuff after "documentation#" is the tag's name
            //If the stuff after "documentation#" is empty, the tag will be ignored
            return tagType.substring(tagType.indexOf("#") + 1);
        }
        //For Parameter, parameter's name is the tag's name.
        //If the name is empty or null, the Parameter will be ignored.
        return element.getName();
    }
    /**
     * <p>
     * Get tag documentation of <code>TaggedValue</code>.
     * </p>
     *
     * <p>
     * Called by <code>addToTableValues()</code>.
     * </p>
     *
     * @param tv <code>TaggedValue</code> to get tag doc.
     *        Possibly null for <code>Parameter</code>.
     *
     * @return tag documentation never null, never empty.
     */
    private String getTagDoc(TaggedValue tv) {
        //If documentation is null or empty,
        //use NEW_VALUE_PROMPT instead
        String doc = tv == null ? null : tv.getDataValue();
        String newValuePrompt = tagModel.getNewValuePrompt();
        doc = DocumentPanelHelper.checkNotEmpty(doc) ? doc
                    : newValuePrompt;
        return doc;
    }
    /**
     * <p>
     * Refresh the UI of tag table.
     * </p>
     *
     * <p>
     * This is required as the tag model may be altered substantially
     * by the user (e.g. have rows added or deleted) which require a
     * UI update before the changes can be seen.
     * </p>
     */
    public void refresh() {
        super.updateUI();
    }
}
