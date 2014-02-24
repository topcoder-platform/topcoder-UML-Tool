/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.failuretests;

import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditor;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagTableModel;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;


/**
 * Test cases for the class DefaultTagTableModel.
 *
 * @author waits
 * @version 1.0
 */
public class DefaultTagTableModelTests extends TestCase {
    /** DefaultTagTableModel instance to test against. */
    private DefaultTagTableModel tagTableModel = null;

    /** DefaultTagEditor instance to test against. */
    private DefaultTagEditor editor = null;

    /**
     * create instances for testing.
     *
     * @throws Exception into JUnit
     */
    protected void setUp() throws Exception {
        Helper.clearConfiguration();
        Helper.addConfigFile(Helper.TAG_EDITOR_CONFIG_FILE);
        Helper.addConfigFile(Helper.TAG_OPTION_MANAGER_CONFIG_FILE);
        this.editor = new DefaultTagEditor(Helper.TAG_EDITOR_NAMESPACE_PREFIX + "valid");

        this.tagTableModel = new DefaultTagTableModel(editor);
    }

    /**
     * Test DefaultTagTableModel's ctor with null tagEditor, iae expected.
     */
    public void testCtor_nullTagEditor() {
        try {
            new DefaultTagTableModel(null);
            fail("The parent is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test DefaultTagTableModel's ctor with null tagEditor, iae expected.
     */
    public void testCtor_nullTagEditor2() {
        try {
            new DefaultTagTableModel(null, null, null, null);
            fail("The parent is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test DefaultTagTableModel's ctor with invalid column names, iae expected.
     */
    public void testCtor_invalidColumnNames() {
        try {
            new DefaultTagTableModel(this.editor, new String[]{"Name" }, null, null);
            fail("The column names is invalid.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test DefaultTagTableModel's ctor with invalid ValuePrompt, iae expected.
     */
    public void testCtor_invalidValuePrompt() {
        try {
            new DefaultTagTableModel(this.editor, new String[] {"Name", "Value" }, null, " ");
            fail("The ValuePrompt is empty.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test the updateValues, the values is null. iae expected.
     */
    public void testUpdateValues_nullList() {
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue> ();
        valueObjects.add(taggedObject);
        try {
            this.tagTableModel.updateValues(null, valueObjects);
            fail("The values is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test the updateValues, the values is null. iae expected.
     */
    public void testUpdateValues_nullElement() {
        List<List<String>> values = new ArrayList<List<String>>();
        values.add(null);
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue> ();
        valueObjects.add(taggedObject);
        try {
            this.tagTableModel.updateValues(values, valueObjects);
            fail("The values is null.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * Test the updateValues, the values is null. iae expected.
     */
    public void testUpdateValues_notRightSize() {
        List<List<String>> values = new ArrayList<List<String>>();
        List<String> value = new ArrayList<String>();
        value.add("Name");
        values.add(value);
        TaggedValue taggedObject = new TaggedValueImpl();
        List<TaggedValue> valueObjects = new ArrayList<TaggedValue> ();
        valueObjects.add(taggedObject);

        try {
            this.tagTableModel.updateValues(values, valueObjects);
            fail("The value size is invalid.");
        } catch (IllegalArgumentException e) {
            //good
        }
    }

    /**
     * clear the environment.
     *
     * @throws Exception into Junit
     */
    protected void tearDown() throws Exception {
        Helper.clearConfiguration();
    }
}
