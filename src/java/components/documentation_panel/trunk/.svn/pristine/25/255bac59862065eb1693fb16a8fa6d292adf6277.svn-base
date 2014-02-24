/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.util.Collection;

import javax.swing.AbstractAction;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.gui.panels.documentation.DocumentationEditor;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.UnknownElementTypeException;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.util.config.UnknownNamespaceException;

/**
 * <p>
 * A simple, default tag editor panel provided with this component. It is simply a large text box, contained within a
 * scrolling panel where the vertical and bars horizontal appear as needed.
 * </p>
 * <p>
 * <strong>Configuration:</strong> From configuration it is possible to set the text box to wrap or not when the words
 * reach the end of the line.
 * </p>
 * <p>
 * <strong>Sample Configuration:</strong>
 *
 * <pre>
 *        &lt;Config name=&quot;plugins_defaultDocEditor&quot;&gt;
 *            &lt;Property name=&quot;wordwrap&quot;&gt;
 *                &lt;Value&gt;yes&lt;/Value&gt;
 *            &lt;/Property&gt;&gt;
 *        &lt;/Config&gt;
 * </pre>
 *
 * </p>
 * <p>
 * <strong>Event handling:</strong> Whenever focus is lost, the documentation changed is fired to all attached
 * listeners.
 * </p>
 * <p>
 * <strong>Thread Safety:</strong> This class is not thread safe. The focus events are triggered by GUI actions which
 * can occur at any time, for example possibly when the model target is being changed by a <code>setTarget</code>
 * call, which may cause problems.
 * </p>
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class DefaultDocumentationEditor extends DocumentationEditor implements FocusListener {
    /**
     * <p>
     * Serial Version UID.
     * </p>
     */
    private static final long serialVersionUID = -7929790877022483790L;

    /**
     * <p>
     * Standard Element Name for documentation tag which is defined in OMG UML Specification Version 1.5
     * formal/03-03-01.
     * </p>
     */
    private static final String DOCUMENTATION = "documentation";

    /**
     * <p>
     * Property indicate whether text area should wrap lines instead of letting them overflow.
     * </p>
     */
    private static final String WORD_WRAP_PARAM = "wordwrap";

    /**
     * <p>
     * Hard-coded String for "yes", which will be used to compare the value of wordwrap property.
     * </p>
     */
    private static final String YES = "yes";

    /**
     * <p>
     * SWING text area where the documentation is entered. It has its <code>setWrapStyleWord(true)</code> called, as
     * well as <code>
     * addFocusListener(this)</code> to allow for focus changes to be processed. In addition, word
     * wrapping may be applied through a configuration parameter.
     * </p>
     * <p>
     * This is initialized on construction to a non-null instance, added to the scroller, and immutable thereafter.
     * </p>
     */
    private final JTextArea content;

    /**
     * <p>
     * Undo manager for text edit.
     * </p>
     */
    private final UndoManager undo;

    /**
     * <p>
     * Document of text area.
     * </p>
     */
    private final Document doc;

    /**
     * <p>
     * Used to store the documentation that was in the <code>content</code> text area the last time it went out of
     * focus. It is used whenever 'previous' documentation is required, and updated at the end of each
     * <code>focusLost()</code> call.
     * </p>
     * <p>
     * This is never null, but may be empty.
     * </p>
     */
    private String previousDocumentation = "";

    /**
     * <p>
     * Constructs a new documentation editor, taking a namespace for it to use to read parameters from a configuration
     * manager. Initialize a <code>JTextArea</code> to hold the documentation content to be edited.
     * </p>
     * <p>
     * <strong>Configuration:</strong> The parameter available is <code>"wordwrap"</code>, which if
     * <code>"yes"</code> (not case-sensitive) signifies that the text area should wrap lines instead of letting them
     * overflow. Any other value, or no value, results in no wordwrap.
     * </p>
     * <p>
     * <strong>Scroll:</strong> A SWING <code>JScrollPane</code> is wrapped around the text area, allowing vertical
     * and horizontal scrolling as needed.
     * </p>
     * @param namespace
     *            Namespace location to read configuration from.
     * @throws DocumentationPanelConfigurationException
     *             If there are problems using the configuration.
     */
    public DefaultDocumentationEditor(String namespace) throws DocumentationPanelConfigurationException {
        try {
            ConfigManager configManager = ConfigManager.getInstance();
            String wordwrap = configManager.getString(namespace, WORD_WRAP_PARAM);
            boolean wrap = wordwrap != null && wordwrap.equalsIgnoreCase(YES);
            setLayout(new BorderLayout());

            this.content = new JTextArea();
            this.content.setLineWrap(wrap);
            this.content.setWrapStyleWord(true);
            this.content.addFocusListener(this);

            undo = new UndoManager();
            doc = content.getDocument();
            // Listen for undo and redo events
            doc.addUndoableEditListener(new UndoableEditListener() {
                public void undoableEditHappened(UndoableEditEvent evt) {
                    undo.addEdit(evt.getEdit());
                }
            });

            // Create an undo action and add it to the content
            content.getActionMap().put("Undo", new AbstractAction("Undo") {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        if (undo.canUndo()) {
                            undo.undo();
                        }
                    } catch (CannotUndoException e) {
                    }
                }
            });

            // Bind the undo action to ctl-Z
            content.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Z,
				Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Undo");

            // Create a redo action and add it to the content
            content.getActionMap().put("Redo", new AbstractAction("Redo") {
                public void actionPerformed(ActionEvent evt) {
                    try {
                        if (undo.canRedo()) {
                            undo.redo();
                        }
                    } catch (CannotRedoException e) {
                    }
                }
            });

            // Bind the redo action to ctl-Y
			content.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_Y,
				Toolkit.getDefaultToolkit().getMenuShortcutKeyMask()), "Redo");

            JScrollPane scroller = new JScrollPane(this.content, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                    JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

            add(scroller);
        } catch (NullPointerException e) {
            throw new DocumentationPanelConfigurationException("The given namespace is null", e);
        } catch (UnknownNamespaceException e) {
            throw new DocumentationPanelConfigurationException("The given namespace is unknown", e);
        }
    }

    /**
     * <p>
     * Sets the target of the documentation editor.
     * </p>
     * <p>
     * The given element's <strong>"documentation"</strong> tag is found and the actual documentation content is
     * extracted from to initialize the <code>content</code> text area, otherwise the text area begins with an empty
     * string.
     * </p>
     * @param element
     *            <code>ModelElement</code> whose documentation is managed by the editor and also modification events
     *            are to be fired by the editor.
     * @throws IllegalArgumentException
     *             if the parameter is null
     */
    public void setTarget(ModelElement element) {
        try {
            super.setTarget(element);
        } catch (UnknownElementTypeException e) {
            // Do nothing, it's safe here since the super will never throw it
        }
        // Initially empty
        String doc = "";

        Collection<TaggedValue> taggedValues = element.getTaggedValues();

        // See ModelElementAbstractImpl.getTaggedValues(), it never returns null.
        // But in case any extending classes override this method and it possibly
        // return a null value, check whether null here.
        if (taggedValues != null) {
            for (TaggedValue tv : taggedValues) {
                // Check tag type, should equal "documentation"
                if (DocumentPanelHelper.checkTagType(tv, DOCUMENTATION, true)) {
                    doc = tv.getDataValue() == null ? doc : tv.getDataValue();
                    break;
                }
            }
        }
        this.content.setText(doc);
        this.previousDocumentation = doc;
    }

    /**
     * <p>
     * Required method for focus listener. Since we're not interested when focus is gained so this method is left empty.
     * </p>
     * @param e
     *            <code>FocusEvent</code> dispatched when focus is gained.
     */
    public void focusGained(FocusEvent e) {
        // clear undo event
        undo.discardAllEdits();
    }

    /**
     * <p>
     * Required method for focus listener. It is automatically called whenever the focus for the <code>content</code>
     * text area is lost. On each calling, the previous documentation and the current text in the <code>content</code>
     * text area are compared. Depending on what their values are, the relevant fireDocumentationXXX method is called.
     * </p>
     * <p>
     * <strong>Scenario:</strong>
     * <ul>
     * <li>If the previous and current documentation are equal(trimmed), nothing happens.</li>
     * <li>If the previous documentation is empty(trimmed), <code>fireDocumentationCreated()</code> is called.</li>
     * <li>If the current documentation is empty(trimmed), <code>fireDocumentationDeleted()</code> is called.</li>
     * <li>Otherwise <code>fireDocumentationUpdated()</code> is called.</li>
     * </ul>
     * </p>
     * @param e
     *            <code>FocusEvent</code> dispatched when focus is lost.
     * @throws IllegalArgumentException
     *             If no <code>ModelElement</code> currently being managed by this editor.
     */
    public void focusLost(FocusEvent e) {
        if (e.getComponent() == this.content && e.getID() == FocusEvent.FOCUS_LOST) {

            String previous = this.previousDocumentation.trim();
            // JTextArea.getText() method never returns null.
            // If the text area is empty, it returns an empty string "".
            String current = this.content.getText().trim();

            if (previous.equals(current)) {
                return;
            } else if (previous.equals("")) {
                this.fireDocumentationCreated(current);
            } else if (current.equals("")) {
                this.fireDocumentationDeleted(previous);
            } else {
                this.fireDocumentationUpdated(previous, current);
            }
            // this would not be set directly on the element.
            this.previousDocumentation = current;
        }
    }
}
