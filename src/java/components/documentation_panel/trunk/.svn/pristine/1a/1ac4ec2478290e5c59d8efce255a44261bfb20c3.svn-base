/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.gui.panels.documentation.event.DocumentationListener;
import com.topcoder.gui.panels.documentation.event.TagListener;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;
import com.topcoder.util.objectfactory.InvalidClassSpecificationException;
import com.topcoder.util.objectfactory.ObjectFactory;
import com.topcoder.util.objectfactory.impl.ConfigManagerSpecificationFactory;
import com.topcoder.util.objectfactory.impl.IllegalReferenceException;
import com.topcoder.util.objectfactory.impl.SpecificationConfigurationException;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JSplitPane;


/**
 * <p>
 * A <code>DocumentationPanel</code> is responsible for providing a SWING
 * <code>JPanel</code>, allowing a user two ways to edit the documentation
 * attached to a <code>ModelElement</code> within a UML Model:
 *  <ul>
 *   <li>by editing the main documentation attached
 *       directly to the element;</li>
 *   <li>or by editing the "tags" (name-value pairs)
 *       that have been attached.</li>
 *  </ul>
 * In addition, operation elements can have their parameter documentations
 * edited along with their tags. The current target <code>ModelElement</code>
 * whose documentation being managed can be changed.
 * </p>
 *
 * <p>
 * The panel does this by initializing a <code>JSplitPane</code>, then
 * initializing a <code>DocumentationEditor</code> plugin on the left and a
 * <code>TagEditor</code> plugin on the right. But these 2 plugins are
 * invisible initially. They are visible after calling <code>setTarget()</code>.<br/>
 * <strong>UI look:</strong>
 * <pre>
 *  --------------------------------------
 *  | JPanel                             |
 *  |------------------------------------|
 *  |               JSpiltPane           |
 *  | DocumentationEditor  | TagEditor   |
 *  | (JTextArea)          | (JTable)    |
 *  |----------------------|-------------|
 * </pre>
 * The panel also provides two ways to hide sections of the editor when
 * they are not needed.
 * </p>
 *
 * <p>
 *  <strong>Interaction:</strong>
 *  Interaction is possible by adding listeners which have methods called
 *  whenever documentation is created/updated/deleted.
 * </p>
 *
 * <p>
 * The plugins are set on construction using configuration data:
 * <br/>
 *  <strong>Sample Configuration:</strong>
 *  <pre>
 *   &lt;!-- configuration for the overall panel --&gt;
 *    &lt;Config name="docPanelNamespace"&gt;
 *        &lt;!-- required construction parameters
 *             for use with the object factory --&gt;
 *        &lt;Property name="objectFactoryNamespace"&gt;
 *            &lt;Value&gt;documentationPanel.objectFactory&lt;/Value&gt;
 *        &lt;/Property&gt;
 *        &lt;Property name="documentEditorKey"&gt;
 *            &lt;Value&gt;documentEditor&lt;/Value&gt;
 *        &lt;/Property&gt;
 *        &lt;Property name="tagEditorKey"&gt;
 *            &lt;Value&gt;tagEditor&lt;/Value&gt;
 *        &lt;/Property&gt;
 *    &lt;/Config&gt;
 *  </pre>
 * </p>
 *
 * <p>
 *  <strong>Thread Safety:</strong>
 *  Through its GUI nature, and as it contains two non thread safe members
 *  which it does not treat specially, this class is not thread safe.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class DocumentationPanel extends JPanel {

    /**
     * <p>
     * Serial Version UID.
     * </p>
     */
    private static final long serialVersionUID = 7422830951238992958L;

    /**
     * <p>
     * Property name of namespace for object factory.
     * </p>
     */
    private static final String OBJECTFACTORY_NS = "objectFactoryNamespace";

    /**
     * <p>
     * Property name of key of object factory for document editor.
     * </p>
     */
    private static final String DOC_EDITOR_KEY = "documentEditorKey";

    /**
     * <p>
     * Property name of key of object factory for tag editor.
     * </p>
     */
    private static final String TAG_EDITOR_KEY = "tagEditorKey";

    /**
     * <p>
     * Weight specifies how to distribute extra space when the size of the
     * split pane changes.
     * </p>
     */
    private static final Double RESIZE_WEIGHT = 0.5;

    /**
     * <p>
     * The editor for the documentation of the target element.
     * It is delegated any setTarget and listener methods called.
     * </p>
     *
     * <p>
     * This is constructed via the object factory during initialization,
     * and immutable afterwards. This can never be null, even when hidden.
     * </p>
     */
    private final DocumentationEditor docEditor;

    /**
     * <p>
     * The editor for the tags of the target element.
     * It is delegated any setTarget and listener methods called.
     * </p>
     *
     * <p>
     * This is obtained on construction from an Object factory and
     * immutable afterwards. This can never be null, even when hidden.
     * </p>
     */
    private final TagEditor tagEditor;

    /**
     * <p>
     * Storage of where the divider was before the tag editor was hidden.
     * </p>
     *
     * <p>
     * This value can be -1 to indicate that the divider is currently
     * displayed, and is this initially.
     * </p>
     *
     * <p>
     * The value of this is changed whenever <code>showTagEditor()</code>
     * is called.
     * </p>
     */
    private int dividerLocation = -1;

/**
 * <p>
 * Constructs a new panel for documentation, taking parameters from configuration.
 * <br/>
 *  <strong>Required properties:</strong>
 *  <ul>
 *   <li>"objectFactoryNamespace": represents the namespace for object factory.</li>
 *   <li>"documentEditorKey": represents the key of document editor object within
 *       object factory.</li>
 *   <li>"tagEditorKey": represents the key of tag editor object within object
 *       factory.</li>
 *  </ul>
 * </p>
 *
 * <p>
 * The <code>DocumentationPanel</code> starts with panel invisible. The whole panel
 * is visible after calling <code>setTarget()</code>.
 * </p>
 *
 * <p>
 * If there are problems reading these from configuration or getting editor through
 * <code>ObjectFactory</code>, then a <code>DocumentationPanelConfigurationException
 * </code> is to be thrown.
 * </p>
 *
 * @param namespace Location in configuration to read parameters from.
 *
 * @throws DocumentationPanelConfigurationException if there are problems
 *         constructing from configuration.
 */
    public DocumentationPanel(String namespace)
        throws DocumentationPanelConfigurationException {
        try {
            //Get namespace for object factory
            ConfigManager configManager = ConfigManager.getInstance();
            String ofNS = configManager.getString(namespace, OBJECTFACTORY_NS);

            //Initialize ObjectFactory
            ConfigManagerSpecificationFactory cmsf = new ConfigManagerSpecificationFactory(ofNS);
            ObjectFactory objectFactory = new ObjectFactory(cmsf);

            //Create document editor
            String docKey = configManager.getString(namespace, DOC_EDITOR_KEY);
            this.docEditor = (DocumentationEditor) objectFactory.createObject(docKey);

            //Create tag editor
            String tagKey = configManager.getString(namespace, TAG_EDITOR_KEY);
            this.tagEditor = (TagEditor) objectFactory.createObject(tagKey);

            initUI();
        } catch (NullPointerException e) {
            throw new DocumentationPanelConfigurationException(
                    "The given namespace is null", e);
        } catch (UnknownNamespaceException e) {
            throw new DocumentationPanelConfigurationException(
                  "The given namespace is unknown", e);
        } catch (SpecificationConfigurationException e) {
            throw new DocumentationPanelConfigurationException(
                    "Error occurs while getting ObjectFactory", e);
        } catch (IllegalReferenceException e) {
            throw new DocumentationPanelConfigurationException(
                    "Error occurs while getting ObjectFactory", e);
        } catch (IllegalArgumentException e) {
            throw new DocumentationPanelConfigurationException(
                    "Error occurs while getting ObjectFactory or creating object", e);
        } catch (InvalidClassSpecificationException e) {
            throw new DocumentationPanelConfigurationException(
                    "Error occurs while creating object through ObjectFactory", e);
        } catch (ClassCastException e) {
            throw new DocumentationPanelConfigurationException(
                    "Error occurs while creating editor through ObjectFactory", e);
        }
    }

/**
 * <p>
 * Constructs a new panel for documentation, by taking concrete editors that it
 * will use to display its two editor halves (documentation and tags).
 * </p>
 *
 * <p>
 * This simply sets the two object members to their corresponding parameters,
 * making sure the parameters are not null. Otherwise, and exception is thrown.
 * </p>
 *
 * <p>
 * The <code>DocumentationPanel</code> starts with panel invisible. The whole panel
 * is visible after calling <code>setTarget()</code>.
 * </p>
 *
 * @param docEditor editor to use to display documentation data
 * @param tagEditor editor to use to display tag data
 *
 * @throws DocumentationPanelConfigurationException if either parameter is null
 */
    public DocumentationPanel(DocumentationEditor docEditor, TagEditor tagEditor)
        throws DocumentationPanelConfigurationException {
        validateEditor(docEditor, "Document editor");
        validateEditor(tagEditor, "Tag editor");
        this.docEditor = docEditor;
        this.tagEditor = tagEditor;
        initUI();
    }

    /**
     * <p>
     * Initialize <code>JSplitPane</code> to hold the document editor and tag
     * editor. Called by constructors.
     * </p>
     */
    private void initUI() {
        setLayout(new BorderLayout());
        //add the two sections
        //Left is document editor, right is tag editor
        JSplitPane divider = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true,
                                                        this.docEditor, this.tagEditor);
        divider.setResizeWeight(RESIZE_WEIGHT);
        divider.setDividerLocation(divider.getPreferredSize().width / 2);
        add(divider);
        //Start with invisible
        this.visibleEditors(false);
    }
    /**
     * <p>
     * Set visible of the editors.
     * </p>
     *
     * @param enable indicate visible or not
     */
    private void visibleEditors(boolean enable) {
        this.docEditor.setVisible(enable);
        this.tagEditor.setVisible(enable);
    }
    /**
     * <p>
     * Validate editor is not null.
     * </p>
     *
     * <p>
     *  <strong>Called by:</strong>
     *   <ul>
     *    <li><code>DocumentationPanel()</code></li>
     *   </ul>
     * </p>
     *
     * @param editor <code>DocumentationEditor</code> or <code>TagEditor</code>
     * @param editorName name of editor
     *
     * @throws DocumentationPanelConfigurationException if editor is null
     */
    private void validateEditor(Object editor, String editorName)
        throws DocumentationPanelConfigurationException {
        if (editor == null) {
            throw new DocumentationPanelConfigurationException(
                     editorName + " should not be null.");
        }
    }
    /**
     * <p>
     * Sets the element whose documentation is to be handled by this panel.
     * This simply delegates the call to the methods of the same name methods
     * of <code>DocumentationEditor</code> and <code>TagEditor</code>.
     * </p>
     *
     * <p>
     * After target be set, the whole panel is enabled.
     * </p>
     *
     * <p>
     *  <strong>Note:</strong>
     *  This does not throw exceptions: if there are any problems calling the
     *  documentation editor's <code>setTarget()</code>, then entire panel is
     *  hidden; Otherwise, if there are problems calling the tag editor's <code>
     *  setTarget()</code>(including <code>UnknownElementTypeException)</code>
     *  then only the tag editor panel is hidden.
     * </p>
     *
     * @see <code>DocumentationEditor.setTarget()</code>
     * @see <code>TagEditor.setTarget()</code>
     * @see <code>showWholeEditor()</code>
     * @see <code>showTagEditor()</code>
     *
     * @param element <code>ModelElement</code> whose documentation is
     *        to be displayed on this panel.
     */
    public void setTarget(ModelElement element) {
    	// UML-558: Documentation panel is not updating
    	if (element == this.docEditor.getTarget()) {
    		return;
    	}
        boolean docTargetSetted = false;
        try {
            this.docEditor.setTarget(element);
            docTargetSetted = true;
            this.tagEditor.setTarget(element);
        } catch (IllegalArgumentException e) {
            hidePanel(docTargetSetted);
            return;
        } catch (UnknownElementTypeException e) {
            hidePanel(docTargetSetted);
            return;
        }
        this.visibleEditors(true);
        this.showWholeEditor(true);
    }

    /**
     * <p>
     * If docTargetSetted is true, hide entire panel;
     * Otherwise only hide tag editor panel.
     * </p>
     *
     * <p>
     *  <strong>Called by:</strong>
     *   <ul>
     *    <li><code>setTarget()</code></li>
     *   </ul>
     * </p>
     *
     * @param docTargetSetted indicate whether the
     *        document editor has set its target.
     */
    private void hidePanel(boolean docTargetSetted) {
        if (docTargetSetted) {
            //Hide only tag editor panel
            this.showTagEditor(false);
        } else {
            //Hide entire panel
            this.showWholeEditor(false);
        }
    }
    /**
     * <p>
     * Allows an application to hide the tag editor pane.
     *  <ul>
     *   <li>If the parameter is true, the tag editor is shown
     *       and the divider location of split panel is restored.
     *   </li>
     *   <li>Otherwise the current divider location is cached,
     *       then tag editor is hidden.
     *   </li>
     *  </ul>
     * </p>
     *
     * <p>
     * If the application calls <code>showTagEditor(false)</code>
     * then <code>showTagEditor(true)</code>, it should return to
     * looking like it was before the calls were made.
     * </p>
     *
     * <p>
     *  <strong>Note:</strong>
     *  When the whole panel is hidden, calling this method dose
     *  not make much sense. The effect calling this method will
     *  not be immediately displayed to users when the whole panel
     *  is hidden.
     * </p>
     *
     * @param show Flag whether the tag panel should be shown.
     */
    public void showTagEditor(boolean show) {
        tagEditor.setVisible(show);

        JSplitPane pane = (JSplitPane) getComponent(0);
        if (show) {
            if (dividerLocation != -1) {
                pane.setDividerLocation(dividerLocation);
                dividerLocation = -1;
            }
        } else {
            if (dividerLocation == -1) {
                dividerLocation = pane.getDividerLocation();
            }
        }

        updateUIAfterShow(pane);
    }

    /**
     * <p>
     * Update UI after show.
     * </p>
     *
     * <p>
     *  <strong>Called by:</strong>
     *   <ul>
     *    <li><code>showTagEditor()</code></li>
     *    <li><code>showWholeEditor()</code></li>
     *   </ul>
     * </p>
     *
     * @param pane <code>JSplitPane</code>
     */
    private void updateUIAfterShow(JSplitPane pane) {
        pane.updateUI();
        docEditor.updateUI();
        tagEditor.updateUI();
    }
    /**
     * <p>
     * Allows an application to hide the entire editor pane.
     *  <ul>
     *   <li>If the parameter is true, the split panel's left
     *       and right components are set to the document editor
     *       and tag editor respectively.
     *   </li>
     *   <li>Otherwise they are set to blank panels.
     *   </li>
     *  </ul>
     * </p>
     *
     * <p>
     * If the application calls <code>showWholeEditor(false)</code>
     * then <code>showWholeEditor(true)</code>, it should return to
     * looking like it was before the calls were made.
     * </p>
     *
     * @param show Flag whether the entire panel should be shown.
     */
    public void showWholeEditor(boolean show) {
        JSplitPane pane = (JSplitPane) getComponent(0);

        tagEditor.setVisible(show);

        if (show) {
            if (dividerLocation != -1) {
                pane.setDividerLocation(dividerLocation);
                dividerLocation = -1;
            }
        } else {
            if (dividerLocation == -1) {
                dividerLocation = pane.getDividerLocation();
            }
        }

        if (show) {
            pane.setLeftComponent(docEditor);
            pane.setRightComponent(tagEditor);
        } else {
            JPanel blank = new JPanel();
            pane.setLeftComponent(blank);
            pane.setRightComponent(blank);
        }

        updateUIAfterShow(pane);
    }

    /**
     * <p>
     * Attaches a new listener, to be sent events triggered by the
     * documentation editor plugin. This delegates the call to the
     * <code>DocumentationEditor</code>'s method of the same name.
     * </p>
     *
     * @param listener listener to attach to the panel
     *
     * @see <code>DocumentationEditor.addDocumentationListener()</code>
     *
     * @throws IllegalArgumentException if the parameter is null
     */
    public void addDocumentationListener(DocumentationListener listener) {
        this.docEditor.addDocumentationListener(listener);
    }

    /**
     * <p>
     * Removes a listener from the panel, or does nothing if it's not
     * attached. Delegate calling to <code>DocumentationEditor</code>'s
     * method of the same name.
     * </p>
     *
     * @see <code>DocumentationEditor.removeDocumentationListener()</code>
     *
     * @param listener Listener to be removed.
     */
    public void removeDocumentationListener(DocumentationListener listener) {
        this.docEditor.removeDocumentationListener(listener);
    }

    /**
     * <p>
     * Returns a list of listening objects. Delegated calling to
     * <code>DocumentationEditor</code>'s method of the same name.
     * </p>
     *
     * <p>
     * Never returns null, but may be empty list.
     * </p>
     *
     * @see <code>DocumentationEditor.getDocumentationListeners()</code>
     *
     * @return list of <code>DocumentationListener</code> attached
     *         to document editor.
     */
    public List < DocumentationListener > getDocumentationListeners() {
        return this.docEditor.getDocumentationListeners();
    }

    /**
     * <p>
     * Attaches a new listener, to be sent events triggered by the tag
     * editor plugin. This delegates the call to the <code>TagEditor
     * </code>'s method of the same name.
     * </p>
     *
     * @param listener listener to attach to the panel
     *
     * @see <code>TagEditor.addTagListener()</code>
     *
     * @throws IllegalArgumentException if the parameter is null
     */
    public void addTagListener(TagListener listener) {
        this.tagEditor.addTagListener(listener);
    }

    /**
     * <p>
     * Removes a listener from the panel, or does nothing if it's not
     * attached. Delegate calling to <code>TagEditor</code>'s method
     * of the same name.
     * </p>
     *
     * @see <code>TagEditor.removeTagListener()</code>
     *
     * @param listener Listener to be removed.
     */
    public void removeTagListener(TagListener listener) {
        this.tagEditor.removeTagListener(listener);
    }

    /**
     * <p>
     * Returns a list of listening objects. Delegate calling
     * to <code>TagEditor</code>'s method of the same name.
     * </p>
     *
     * <p>
     * Never returns null, but may be an empty list.
     * </p>
     *
     * @see <code>TagEditor.getTagListeners()</code>
     *
     * @return list of <code>TagListener</code> attached to
     *         tag editor.
     */
    public List < TagListener > getTagListeners() {
        return this.tagEditor.getTagListeners();
    }
}
