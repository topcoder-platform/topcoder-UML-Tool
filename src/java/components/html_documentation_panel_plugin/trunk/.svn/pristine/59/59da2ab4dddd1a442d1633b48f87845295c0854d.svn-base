/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * HTMLDocumentationEditor.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import java.awt.BorderLayout;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.text.html.HTMLEditorKit;
import javax.xml.transform.sax.SAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import com.topcoder.configuration.ConfigurationAccessException;
import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.configuration.persistence.ConfigurationFileManager;
import com.topcoder.configuration.persistence.ConfigurationParserException;
import com.topcoder.configuration.persistence.NamespaceConflictException;
import com.topcoder.configuration.persistence.UnrecognizedFileTypeException;
import com.topcoder.configuration.persistence.UnrecognizedNamespaceException;
import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.gui.panels.documentation.DocumentationEditor;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;


/**
 * <p>
 * This is the main class of the component. It's a <strong>HTML</strong> editor panel provided with this
 * component. It has a <code>JEditorPane</code> instance as the text box, contained within a scrolling panel where the
 * bars appear as needed from configuration. It is also possible to set the text box to wrap when the words reach the
 * end of the line. Then, whenever focus is lost, the documentation changed is fired to all listeners. With the help
 * of a toolBar, the editor can bold, italic, underline selected texts, and can choose font size and font name of the
 * selected texts. It also can undo and re-do the edits. It also provides keyboard shortcuts for bold, italic,
 * underline, undo and re-do actions.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is not thread safe since the class is mutable, and the focus events are triggered by GUI
 * actions which can occur at any time, for example possibly when the model target is being changed by a
 * <code>setTarget</code> call, which may cause problems. It can also change the <strong>ToolBar</strong>
 * attached to the editor.
 * </p>
 *
 * <p>Examples of usage of <code>HTMLDocumentationEditor</code> :
 *   <pre>
 *     //First, prepare the configuration
 *     ConfigurationFileManager configManager = new ConfigurationFileManager();
 *     ConfigurationObject config = configManager.getConfiguration(namespace);
 *
 *     //Then, create the editor. This will get a HTML editor with a tool bar.
 *     HTMLDocumentationEditor editor = new HTMLDocumentationEditor(config);
 *
 *     //Or create the editor with namespace as parameter.
 *     HTMLDocumentationEditor editor = new HTMLDocumentationEditor(namespace);
 *
 *     //If the user wants to add some button corresponding to some action,
 *     //like StyledEditorKit.AlignmentAction, he can do it like this:
 *     //Add a the left align action button
 *     editor.getToolBar()
 *         .addToolBarButton(new ImageIcon(&quot;test_files/leftAlign.gif&quot;),
 *         new StyledEditorKit.AlignmentAction(&quot;leftAlign&quot;, 0), 'L',
 *         &quot;Left align the text&quot;);
 *
 *     //If the user wants to change the tool bar, he can do it like this
 *     //Initialize another tool bar
 *     HTMLDocumentationEditorToolBar toolbar = ...
 *
 *     //set the tool bar to the other tool bar inherited from HTMLDocumentationEditorToolBar
 *     //editor.setToolBar(toolbar);
 *
 *     //Set input to the editor
 *     editor.setTarget(modelElement);
 *
 *     //Get output from the editor
 *     editor.getContentText();
 *
 *     //the output can also get from #focusLost
 *     //by the classes which are interested in FocusEvent
 *     FocusEvent event = new FocusEvent(editor, FocusEvent.FOCUS_GAINED);
 *     editor.focusLost(event);
 *
 *   </pre>
 * </p>
 * @author morehappiness, TCSDEVELOPER
 * @version 1.0
 */
@SuppressWarnings("serial")
public class HTMLDocumentationEditor extends DocumentationEditor implements FocusListener {
    /**
     * <p>Constant for content type "text/html".</p>
     */
    private static final String CONTENT_TYPE_TEXT_HTML = "text/html";

    /**
     * <p>Constant for content type "text/plain".</p>
     */
    private static final String CONTENT_TYPE_TEXT_PLAIN = "text/plain";

    /**
     * <p>Constant for content 'vsbPolicy' field.</p>
     */
    private static final String VSB_POLICY = "vsbPolicy";

    /**
     * <p>Default value for 'vsbPolicy' field.</p>
     */
    private static final int DEFAULT_VSB_POLICY = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;

    /**
     * <p>Constant for content 'hsbPolicy' field.</p>
     */
    private static final String HSB_POLICY = "hsbPolicy";

    /**
     * <p>Default value for 'hsbPolicy' field.</p>
     */
    private static final int DEFAULT_HSB_POLICY = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;

    /**
     * <p>Constant for content 'toolBarClass' field.</p>
     */
    private static final String TOOLBAR_CLASS = "toolBarClass";

    /**
     * <p>Default value for 'toolBarClass' field.</p>
     */
    private static final String DEFAULT_TOOLBAR_CLASS =
        "com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBar";

    /**
     * <p>Constant for content 'toolBarConfig' field.</p>
     */
    private static final String TOOLBAR_CONFIG = "toolBarConfig";

    /**
     * <p>Constant for content 'XSDPath' field.</p>
     */
    private static final String XSD_PATH = "XSDPath";

    /**
     * <p>Standard Element Name for documentation tag which is defined in OMG UML Specification Version 1.5
     * formal/03-03-01.</p>
     */
    private static final String DOCUMENTATION = "documentation";

    /**
     * <p>SWING text area where the documentation is entered. it has its setWrapStyleWord(true) called, as well
     * as addFocusListener(this) to allow for focus changes to be processed. In addition, word wrapping may be applied
     * through a configuration parameter.</p>
     *  <p>This is initialized with a non-null <code>JEditorPane</code> instance, added to the scrolling
     * component, and immutable thereafter.</p>
     *  <p>Use related getter methods to retrieve this field value.</p>
     */
    private final JEditorPane content = new JEditorPane();

    /**
     * <p>Used to store the documentation that was in the content panel the last time it went out of focus.</p>
     *  <p>This is never null, but may be empty.</p>
     *  <p>It is used whenever 'previous' documentation is required, and updated at the end of each focusLost
     * call with the documentation inside content.</p>
     */
    private String previousDocumentation = "";

    /**
     * <p>This is the tool bar for the editor. The tool bar can do some styles to the text of the content.</p>
     *  <p>Default is null. Can be initialized in constructor with configuration as parameters.</p>
     *  <p>Use related getter/setter methods to retrieve this field value or to mutate its data.</p>
     */
    private HTMLDocumentationEditorToolBar toolBar = null;

    /**
     * <p>Represents the XSD file path of XHTML used to validate the input.</p>
     *  <p>Can not be null/empty, must be a valid path.</p>
     *  <p>Initialized in constructor. After that, can not be changed.</p>
     *  <p>It is used in <code>validateInput</code>.</p>
     */
    private String xsdPath;

    /**
     * <p>Constructs a new documentation editor, taking a namespace for it to use to read parameters
     * from a configuration file manager.</p>
     *
     * @param namespace the namespace location to read configuration from.
     *
     * @throws DocumentationPanelConfigurationException if there are problems using the configuration
     * @throws IllegalArgumentException if namespace is null
     * @throws HTMLDocumentationEditorException if there exists other errors
     */
    public HTMLDocumentationEditor(String namespace)
        throws DocumentationPanelConfigurationException, HTMLDocumentationEditorException {
        if (namespace == null) {
            throw new IllegalArgumentException("The parameter 'namespace ' should not be null.");
        }

        try {
            //Get the ConfigurationFileManager instance
            ConfigurationFileManager configManager = new ConfigurationFileManager();

            //Get the ConfigurationObject instance for tool bar from configure file manager
            ConfigurationObject config = configManager.getConfiguration(namespace);

            //Create the tool bar, and set it to toolBar
            createEditor(config);
        } catch (ConfigurationParserException e) {
            throw new DocumentationPanelConfigurationException("Error occurs while parsing configuration file.", e);
        } catch (NamespaceConflictException e) {
            throw new DocumentationPanelConfigurationException("Error occurs since namespace conflict occurs", e);
        } catch (UnrecognizedFileTypeException e) {
            throw new DocumentationPanelConfigurationException("Error occurs for unrecognized file type.", e);
        } catch (IOException e) {
            throw new DocumentationPanelConfigurationException("IO exception occurs while parsing configuration file.",
                e);
        } catch (UnrecognizedNamespaceException e) {
            throw new DocumentationPanelConfigurationException(
                "Unrecognized namespace exception occurs while parsing configuration file.", e);
        }
    }

    /**
     * <p>Constructs a new documentation editor, reading parameters from configuration.
     * This will create the toolBar.</p>
     *
     * @param config  the configuration object for the constructor. Can not be null.
     *
     * @throws IllegalArgumentException if configuration object is null
     * @throws HTMLDocumentationEditorException
     *     if there are problems reading configuration or the configuration has invalid properties.
     */
    public HTMLDocumentationEditor(ConfigurationObject config)
        throws HTMLDocumentationEditorException {
        createEditor(config);
    }

    /**
     * <p>Sets the target of the documentation panel. This method will display valid XHTML input as normal web
     * pages. It should display the whole input as plain text if the input XHTML is invalid.</p>
     *
     * @param element Element whose documentation modification events are to be fired by this panel.
     *
     * @throws IllegalArgumentException if the parameter is null
     */
    public void setTarget(ModelElement element) {
        try {
            super.setTarget(element);
        } catch (UnknownElementTypeException e) {
            //Do nothing, it's safe here since the super will never throw it
        }

        //Initially empty
        String doc = "";

        Collection<TaggedValue> taggedValues = element.getTaggedValues();

        //See ModelElementAbstractImpl.getTaggedValues(), it never returns null.
        //But in case any extending classes override this method and it possibly
        //return a null value, check whether null here.
        if (taggedValues != null) {
            for (TaggedValue tv : taggedValues) {
                //Check tag type, should equal "documentation"
                if (DocumentPanelHelper.checkTagType(tv, DOCUMENTATION, true)) {
                    doc = (tv.getDataValue() == null) ? doc : tv.getDataValue();

                    break;
                }
            }
        }

        //validate document
        try {
            validateInput(doc);
        } catch (HTMLDocumentationEditorException e) {
            e.printStackTrace();
            doc = "";
        }

        content.setText(doc);
        previousDocumentation = doc;
    }

    /**
     * <p>Required method for focus listener.</p>
     *
     * @param e FocusEvent dispatched when focus is gained.
     */
    public void focusGained(FocusEvent e) {
        //do nothing
    }

    /**
     * <p>Required method for focus listener. This is called whenever the focus for the content pane is lost.</p>
     *
     * @param e FocusEvent dispatched when focus is lost.
     */
    public void focusLost(FocusEvent e) {
        //check previous documentation and the current text in the content panel are need to compare.
        if (content.equals(e.getComponent()) && (e.getID() == FocusEvent.FOCUS_LOST)) {
            //get previous document
            String previous = previousDocumentation;

            //get current document
            String current = content.getText().trim();

            //Depending on what their values are, the relevant fireDocumentationXXX method is called.
            if (previous.equals(current)) {
                return;
            } else if ("".equals(previous)) {
                fireDocumentationCreated(current);
            } else if ("".equals(current)) {
                fireDocumentationDeleted(previous);
            } else {
                fireDocumentationUpdated(previous, current);
            }

            //update the current documentation
            previousDocumentation = current;
        }
    }

    /**
     * <p>Get the tool bar.</p>
     *
     * @return the tool bar.
     */
    public HTMLDocumentationEditorToolBar getToolBar() {
        return toolBar;
    }

    /**
     * <p>Set the tool bar.Note that the added tool bar should associated with the specified editor.</p>
     *
     * @param toolBar the new tool bar to set.
     *
     * @throws IllegalArgumentException if the parameter is null
     */
    public void setToolBar(HTMLDocumentationEditorToolBar toolBar) {
        if (toolBar == null) {
            throw new IllegalArgumentException("The parameter 'toolBar ' should not be null.");
        }

        //remove the old toolBar
        remove(this.toolBar);

        this.toolBar = toolBar;

        //add new tool bar to JPanel
        add(toolBar, BorderLayout.NORTH);
    }

    /**
     * <p>Get the content.</p>
     *
     * @return the content of the editor.
     */
    JEditorPane getContent() {
        return content;
    }

    /**
     * <p>This method is used to check the input for showing invalid text as raw data.</p>
     *
     * @param input the input to check
     *
     * @throws HTMLDocumentationEditorException if there are problems while validating
     */
    private void validateInput(String input) throws HTMLDocumentationEditorException {
        //Get the factory for the W3C XML Schema language
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");

        //Compile the schema by using the XHTML XSD like http://www.w3.org/2002/08/xhtml/xhtml1-strict.xsd
        //we assume it's local path is xsdPath
        try {
            File file = new File(xsdPath);

            if (!file.exists()) {
                throw new HTMLDocumentationEditorException("xsd path is invalid.");
            }

            Schema schema = factory.newSchema(file);

            //Get the validate from the schema
            Validator validator = schema.newValidator();

            //create an input source
            InputSource inputSrc = new InputSource(new ByteArrayInputStream(input.getBytes()));

            //create the SAX source
            SAXSource saxSource = new SAXSource(inputSrc);

            //Try to validate the input
            validator.validate(saxSource);

            //If not exception occurs, the input is a valid XHTML
            return;
        } catch (SAXException e) {
            content.setEditorKitForContentType(CONTENT_TYPE_TEXT_PLAIN, new HTMLEditorKit());
        } catch (IOException e) {
            throw new HTMLDocumentationEditorException("IO exception occurs while validating.");
        }
    }

    /**
     * <p>Used to get the text from content.</p>
     *
     * @return the content text of the content.
     */
    public String getContentText() {
        return content.getText();
    }

    /**
     * <p>Create ToolBar object with the configuration.</p>
     *
     * @param config the configuration object
     * @param toolBarClassName the toolBar class name
     *
     * @throws HTMLDocumentationEditorException
     *     if there are problems reading configuration or the configuration has invalid properties.
     */
    private void createToolBar(ConfigurationObject config, String toolBarClassName)
        throws HTMLDocumentationEditorException {
        try {
            Class<?> toolbarClass = Class.forName(toolBarClassName);
            Constructor<?> ctor =
                toolbarClass.getConstructor(ConfigurationObject.class, HTMLDocumentationEditor.class);
            Object toolbarObject = ctor.newInstance(config, this);
            toolBar = (HTMLDocumentationEditorToolBar) toolbarObject;
        } catch (ClassNotFoundException e) {
            throw new HTMLDocumentationEditorException("Specified class for toolbar is not found.", e);
        } catch (InstantiationException e) {
            throw new HTMLDocumentationEditorException("Error occurs while creating the instance.", e);
        } catch (IllegalAccessException e) {
            throw new HTMLDocumentationEditorException("Illegal access occurs in reflection.", e);
        } catch (ClassCastException e) {
            throw new HTMLDocumentationEditorException("Error occurs while casting to toolbar object.", e);
        } catch (SecurityException e) {
            throw new HTMLDocumentationEditorException("Security exception occurs in reflection.", e);
        } catch (NoSuchMethodException e) {
            throw new HTMLDocumentationEditorException("No such method exception occurs in reflection.", e);
        } catch (IllegalArgumentException e) {
            throw new HTMLDocumentationEditorException("Illegal argument exception occurs in reflection.", e);
        } catch (InvocationTargetException e) {
            throw new HTMLDocumentationEditorException("Invocation target exception occurs in reflection.", e);
        }
    }

    /**
     * <p>Create the editor with the configuration.</p>
     *
     * @param config the configuration object
     *
     * @throws HTMLDocumentationEditorException if there are problems reading configuration or the configuration has
     *         invalid properties.
     * @throws IllegalArgumentException if configuration object is null
     */
    private void createEditor(ConfigurationObject config)
        throws HTMLDocumentationEditorException {
        if (config == null) {
            throw new IllegalArgumentException("The parameter 'config ' should not be null.");
        }

        ConfigurationObject defaultConfig = null;

        try {
            defaultConfig = config.getChild("default");
        } catch (ConfigurationAccessException e) {
            throw new HTMLDocumentationEditorException("Error occurs while getting child configuration.");
        }

        if (defaultConfig == null) {
            throw new HTMLDocumentationEditorException("No default config exists.");
        }

        //set properties of content
        content.setEditorKitForContentType(CONTENT_TYPE_TEXT_HTML, new HTMLEditorKit());
        content.addFocusListener(this);
        content.setContentType(CONTENT_TYPE_TEXT_HTML);

        //add content to scroll pane
        //get the vertical scrolling policy
        int vsbPolicy = Helper.getPropInt(defaultConfig, VSB_POLICY, false, DEFAULT_VSB_POLICY);

        if ((vsbPolicy != ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS)
            && (vsbPolicy != ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER)
            && (vsbPolicy != ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED)) {
            throw new HTMLDocumentationEditorException("vsbPolicy configuration value is not valid.");
        }

        //get the horizontal scrolling policy
        int hsbPolicy = Helper.getPropInt(defaultConfig, HSB_POLICY, false, DEFAULT_HSB_POLICY);

        if ((hsbPolicy != ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS)
            && (hsbPolicy != ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER)
            && (hsbPolicy != ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED)) {
            throw new HTMLDocumentationEditorException("hsbPolicy configuration value is not valid.");
        }

        JScrollPane scroller = new JScrollPane(content, vsbPolicy, hsbPolicy);

        //get "toolBarClass" from configuration
        String toolBarClassName = Helper.getPropString(defaultConfig, TOOLBAR_CLASS, false, DEFAULT_TOOLBAR_CLASS);

        //get "toolBarConfig" from configuration
        ConfigurationObject toolBarConfig = Helper.getPropConfigObject(config, TOOLBAR_CONFIG);

        //create the 'toolbar' through reflection(pass the toolBarConfig as the parameters), and set it to toolBar.
        createToolBar(toolBarConfig, toolBarClassName);

        //set layout to border layout
        setLayout(new BorderLayout());

        //add toolBar to north of the editor
        add(toolBar, BorderLayout.NORTH);

        //add content to center of the editor
        add(scroller, BorderLayout.CENTER);

        //read XSD file path
        xsdPath = Helper.getPropString(defaultConfig, XSD_PATH, true, null);
    }
}
