/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * DemoTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.configuration.persistence.ConfigurationFileManager;

import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Dimension;
import java.awt.event.FocusEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.text.StyledEditorKit;


/**
 * <p>Demo class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTest extends TestCase {
    /**
     * <p>Constant for namesapce.</p>
     */
    private static final String namespace = "html_documentation_editor";

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(DemoTest.class);
    }

    /**
     * <p>Demo test.</p>
     *
     * @throws Exception to JUnit
     */
    public void testDemo() throws Exception {
        //First, prepare the configuration as described in Section 3.2
        ConfigurationFileManager configManager = new ConfigurationFileManager();
        ConfigurationObject config = configManager.getConfiguration(namespace);

        //Then, create the editor. This will get a HTML editor with a tool bar.
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(config);

        //Or create the editor with namespace as parameter.
        //namespace is used with ConfigManager
        //HTMLDocumentationEditor editor1 = new HTMLDocumentationEditor(namespace);

        //If the user wants to add some button corresponding to some action,
        //like StyledEditorKit.AlignmentAction, he can do it like this:
        //Add a the left align action button
        editor.getToolBar()
              .addToolBarButton(new ImageIcon("test_files/leftAlign.gif"),
            new StyledEditorKit.AlignmentAction("leftAlign", 0), 'L', "Left align the text");

        //If the user wants to change the tool bar, he can do it like this
        //Initialize another tool bar
        //HTMLDocumentationEditorToolBar toolbar = TestHelper.genToolBar(namespace);

        //set the tool bar to the other tool bar inherited from HTMLDocumentationEditorToolBar
        //editor.setToolBar(toolbar);
        ModelElement modelElement = new AttributeImpl();

        TaggedValue tv = new TaggedValueImpl();
        TagDefinition tg = new TagDefinitionImpl();
        tv.setType(tg);
        modelElement.addTaggedValue(tv);

        //Set input to the editor
        editor.setTarget(modelElement);

        //Get output from the editor
        editor.getContentText();

        //the output can also get from #focusLost
        //by the classes which are interested in FocusEvent
        editor.focusLost(new FocusEvent(editor, FocusEvent.FOCUS_LOST));

        //Then, add the editor to a frame.
        showFrame(editor);
    }

    /**
     * <p>HTML editor demo test.</p>
     */
    public void testEditorDemo() {
    }

    /**
     * Demo main.
     *
     * @param args the arguments
     *
     * @throws Exception to outer
     */
    public static void main(String[] args) throws Exception {
        //First, prepare the configuration as described in Section 3.2
        ConfigurationFileManager configManager = new ConfigurationFileManager();
        ConfigurationObject config = configManager.getConfiguration(namespace);

        //Then, create the editor. This will get a HTML editor with a tool bar.
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(config);

        //Or create the editor with namespace as parameter.
        //namespace is used with ConfigManager
        //HTMLDocumentationEditor editor1 = new HTMLDocumentationEditor(namespace);

        //If the user wants to add some button corresponding to some action,
        //like StyledEditorKit.AlignmentAction, he can do it like this:
        //Add a the left align action button
        editor.getToolBar()
              .addToolBarButton(new ImageIcon("test_files/leftAlign.gif"),
            new StyledEditorKit.AlignmentAction("leftAlign", 0), 'L', "Left align the text");

        //If the user wants to change the tool bar, he can do it like this
        //Initialize another tool bar
        //HTMLDocumentationEditorToolBar toolbar = TestHelper.genToolBar(namespace);

        //set the tool bar to the other tool bar inherited from HTMLDocumentationEditorToolBar
        //editor.setToolBar(toolbar);
        ModelElement modelElement = new AttributeImpl();

        TaggedValue tv = new TaggedValueImpl();
        TagDefinition tg = new TagDefinitionImpl();
        tv.setType(tg);
        modelElement.addTaggedValue(tv);

        //Set input to the editor
        editor.setTarget(modelElement);

        //Get output from the editor
        editor.getContentText();

        //the output can also get from #focusLost
        //by the classes which are interested in FocusEvent
        editor.focusLost(new FocusEvent(editor, FocusEvent.FOCUS_LOST));

        showFrame(editor);
    }

    /**
     * <p>Show frame.</p>
     *
     * @param editor the editor
     */
    private static void showFrame(HTMLDocumentationEditor editor) {
        //Then, add the editor to a frame.
        JFrame testFrame = new JFrame("Test");
        testFrame.setPreferredSize(new Dimension(800, 600));
        testFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        testFrame.add(editor);
        testFrame.pack();
        testFrame.setVisible(true);
    }
}
