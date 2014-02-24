/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * HTMLDocumentationEditorToolBar.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JEditorPane;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.KeyStroke;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.StyledEditorKit;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

import com.topcoder.configuration.ConfigurationObject;


/**
 * <p>
 * This abstract class lays the basic contracts of a tool bar for HTML documentation editor. It contains the
 * following basic commands: cut, copy, paste, bold, italic, underline, undo and re-do. It also contains keyboard
 * shortcuts for the commands.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is not thread safe since the class in mutable and it¡¯s a SWING class.
 * </p>
 *
 * @author morehappiness, TCSDEVELOPER
 * @version 1.0
 */
@SuppressWarnings("serial")
public abstract class HTMLDocumentationEditorToolBar extends JToolBar {
    /**
     * <p>Manager of undo edit and re-do edit.</p>
     *  <p>It's initialized as a <code>UndoManager</code> instance, and immutable thereafter.</p>
     *  <p>Used by three inner classes.</p>
     */
    private final UndoManager undoManager = new UndoManager();

    /**
     * <p>The action to undo the previous edit.</p>
     *  <p>Default is a new <code>UndoAction</code> instance and immutable thereafter.</p>
     *  <p>Used by three inner class.</p>
     */
    private final UndoAction undoAction = new UndoAction();

    /**
     * <p>The action to re-do the last canceled edit.</p>
     *  <p>Default is a new <code>RedoAction</code> instance and immutable thereafter.</p>
     *  <p>Used by three inner class.</p>
     */
    private final RedoAction redoAction = new RedoAction();

    /**
     * <p>Listener for the edits on the current document.</p>
     *  <p>Default is a new UndoHandler instance,and immutable thereafter.</p>
     *  <p>Used by the constructor.</p>
     */
    private final UndoableEditListener undoHandler = new UndoHandler();

    /**
     * <p>Represents the HTML editor.</p>
     */
    private final HTMLDocumentationEditor editor;

    /**
     * <p>Construct the tool bar.</p>
     * <p>It will read the properties from configuration file.</p>
     * <p>Then, create the action buttons and add them to tool bar.</p>
     *
     * @param config the configuration object for the constructor, can not be null.
     * @param editor the editor which the tool bar belongs to.
     *
     * @throws IllegalArgumentException if config or editor is null.
     * @throws HTMLDocumentationEditorException
     *     if there are problems reading configuration or the configuration has invalid properties.
     */
    protected HTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)
        throws HTMLDocumentationEditorException {
        //call super constructor
        super();

        //throw IAE if 'config' parameter is null
        if (config == null) {
            throw new IllegalArgumentException("The parameter 'config' should not be null.");
        }

        //throw IAE if 'editor' parameter is null
        if (editor == null) {
            throw new IllegalArgumentException("The parameter 'editor' should not be null.");
        }

        this.editor = editor;

        //get the editor pane
        JEditorPane editorPane = editor.getContent();

        //Add this as a listener for undo-able edits
        editorPane.getDocument().addUndoableEditListener(undoHandler);

        //Read the corresponding properties to the actions: cut, copy, paste, undo, re-do, bold, italic, and underline,
        //and creates the buttons, add them to tool bar.

        //create 'cut' action
        createAction(config, "cutImage", "cutShortKey", "X", "cutTooltip", "cut the text",
            new StyledEditorKit.CutAction());

        //create 'copy' action
        createAction(config, "copyImage", "copyShortKey", "C", "copyTooltip", "copy the text",
            new StyledEditorKit.CopyAction());

        //create 'paste' action
        createAction(config, "pasteImage", "pasteShortKey", "V", "pasteTooltip", "paste the text",
            new StyledEditorKit.PasteAction());

        //create 'undo' action
        createAction(config, "undoImage", "undoShortKey", "Z", "undoTooltip", "undo the edit",
            undoAction);

        //create 're-do' action
        createAction(config, "redoImage", "redoShortKey", "Y", "redoTooltip", "redo the edit",
            redoAction);

        //create 'bold' action
        createAction(config, "boldImage", "boldShortKey", "B", "boldTooltip", "bold the text",
            new StyledEditorKit.BoldAction());

        //create 'italic' action
        createAction(config, "italicImage", "italicShortKey", "I", "italicTooltip", "italic the text",
            new StyledEditorKit.ItalicAction());

        //create 'underlineImage' action
        createAction(config, "underlineImage", "underlineShortKey", "U", "underlineTooltip", "underline the text",
            new StyledEditorKit.UnderlineAction());
    }

    /**
     * <p>Resets the undo manager.</p>
     */
    protected void resetUndoManager() {
        undoManager.discardAllEdits();
        undoAction.update();
        redoAction.update();
    }

    /**
     * <p>Creates a new <code>JToogleButton</code> with the specified icon, action command, key short, and
     * toolTip.</p>
     *
     * @param icon the icon attached to the button, can not be null.
     * @param action the action command to use, can not be null.
     * @param key the keyboard shortcut.
     * @param tip the tool tip, can be null/empty which means no tool tip.
     *
     * @return the created button
     *
     * @throws IllegalArgumentException if icon or action is null
     */
    private JToggleButton createToolbarButton(Icon icon, Action action, Character key, String tip) {
        //throw IAE if 'icon' parameter is null
        if (icon == null) {
            throw new IllegalArgumentException("The parameter 'icon' should not be null.");
        }

        //throw IAE if 'action' parameter is null
        if (action == null) {
            throw new IllegalArgumentException("The parameter 'action' should not be null.");
        }

        //create the button
        JToggleButton button = new JToggleButton();

        //set the keyboard shortcut to the action, depends on the OS
        //get the input map
        InputMap inputMap = editor.getContent().getInputMap();

        //get OS
        String os = System.getProperty("os.name");

        KeyStroke keyStroke = null;

        //get key stroke for shortcuts, combine with CTRL(on windows/linux), or Command(on Macintosh)
        if (os != null) {
            os = os.trim().toLowerCase();

            if (os.startsWith("windows") || os.startsWith("linux") || os.startsWith("unix")) {
                keyStroke = KeyStroke.getKeyStroke(key.charValue(), Event.CTRL_MASK);
            } else if (os.startsWith("macintosh")) {
                keyStroke = KeyStroke.getKeyStroke(key.charValue(),
                    Toolkit.getDefaultToolkit().getMenuShortcutKeyMask());
            }
        }

        //put the key stroke for action
        inputMap.put(keyStroke, action);

        //set the action to the button
        button.setAction(action);

        //set the tool tip
        button.setToolTipText(tip);

        //set the icon to button
        button.setIcon(icon);

        //set the text to button
        button.setText("");

        return button;
    }

    /**
     * <p>Add the created button to the tool bar. The created button will have the specified icon, action
     * command, key short, and toolTip.</p>
     *
     * @param icon the icon attached to the button, can not be null.
     * @param action the action command to use, can not be null.
     * @param key the keyboard shortcut.
     * @param tip the tool tip can be null/empty which means no tool tip.
     *
     * @throws IllegalArgumentException if icon or action is null
     */
    public void addToolBarButton(Icon icon, Action action, Character key, String tip) {
        //create the button with the specified arguments, and add it to the tool bar.
        add(createToolbarButton(icon, action, key, tip));
    }

    /**
     * <p>Create all the actions and add it to the toolBar.</p>
     *
     * @param config the configuration object
     * @param image the image configuration field name
     * @param shortKey the short key configuration field name
     * @param defaultShortKey the default short key
     * @param tooltip the toolTip configuration field name
     * @param defaultTooltip the default toolTip
     * @param action the action
     *
     * @throws HTMLDocumentationEditorException if error occurs while getting property value
     */
    private void createAction(ConfigurationObject config, String image, String shortKey, String defaultShortKey,
        String tooltip, String defaultTooltip, Action action)
        throws HTMLDocumentationEditorException {

        //create the icon, note that the imageUrl will not be null/empty
        ImageIcon icon = new ImageIcon(Helper.getPropString(config, image, true, null));

        //get the keyboard shortcut
        String shortCutStr = Helper.getPropString(config, shortKey, false, defaultShortKey);

        //here short cut string will not be null/empty string
        if (shortCutStr.length() > 1) {
            throw new HTMLDocumentationEditorException("The shoftCut valus is not a character.");
        }

        Character shortCut = shortCutStr.charAt(0);

        //get the tool tip
        String tip = Helper.getPropString(config, tooltip, false, defaultTooltip);

        //creates and add the corresponding button to the bar
        addToolBarButton(icon, action, shortCut, tip);
    }

    /**
     * <p>
     * This class inherited from <code>AbstractAction</code> is used to manage the re-do action. It will
     * re-do the previous canceled edit. It is an inner class of <code>HTMLDocumentationEditorToolBar</code>.
     * </p>
     *
     * <p>
     * <strong>Thread safety:</strong>
     * This class is not thread safe since the super class is not thread safe.
     * </p>
     *
     * @author morehappiness, TCSDEVELOPER
     * @version 1.0
     */
    protected class RedoAction extends AbstractAction {
        /**
         * <p>Construct the action.</p>
         */
        public RedoAction() {
            super("Redo");
            setEnabled(false);
        }

        /**
         * <p>Implementation of AbstractAction#actionPerformed. Used to re-do the previous action.</p>
         *
         * @param event the action event dispatched when re-do required.
         *
         * @throws IllegalArgumentException if event is null
         */
        public void actionPerformed(ActionEvent event) {
            //throw IAE if 'event' parameter is null
            if (event == null) {
                throw new IllegalArgumentException("The parameter 'event' should not be null.");
            }

            try {
                undoManager.redo();
            } catch (CannotRedoException ex) {
                System.out.println("Unable to redo: " + ex);
                ex.printStackTrace();
            }

            update();
            undoAction.update();
        }

        /**
         * <p>Used to update the state of the action.</p>
         */
        protected void update() {
            if (undoManager.canRedo()) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }

    /**
     * <p>
     * This class inherited from <code>AbstractAction</code> is used to manage the undo action. It will undo
     * the previous edit. It¡¯s an inner class of <code>HTMLDocumentationEditorToolBar</code>.
     * </p>
     *
     * <p>
     * <strong>Thread safety:</strong>
     * This class is not thread safe since the super class is not thread safe.
     * </p>
     *
     * @author morehappiness, TCSDEVELOPER
     * @version 1.0
     */
    protected class UndoAction extends AbstractAction {
        /**
         * <p>Construct the action.</p>
         */
        public UndoAction() {
            super("Undo");
            setEnabled(false);
        }

        /**
         * <p>Implementation of AbstractAction#actionPerformed. Used to undo the previous action.</p>
         *
         * @param event the action event dispatched when undo required.
         *
         * @throws IllegalArgumentException if event is null
         */
        public void actionPerformed(ActionEvent event) {
            //throw IAE if 'event' parameter is null
            if (event == null) {
                throw new IllegalArgumentException("The parameter 'event' should not be null.");
            }

            try {
                undoManager.undo();
            } catch (CannotUndoException ex) {
                System.out.println("Unable to undo: " + ex);
                ex.printStackTrace();
            }

            update();
            redoAction.update();
        }

        /**
         * <p>Used to update the state of the action.</p>
         */
        protected void update() {
            if (undoManager.canUndo()) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }

    /**
     * <p>
     * This class implementing the interface <code>UndoableEditListener</code> is used to manage the
     * undo-able edit. It will do the management by listening and handling the UndoableEditEvent through method
     * <code>undoableEditHappened</code>.It¡¯s an inner class of <code>HTMLDocumentationEditorToolBar</code>.
     * </p>
     *
     * <p>
     * <strong>Thread safety:</strong>This class is thread safe since it is immutable.
     * </p>
     *
     * @author morehappiness, TCSDEVELOPER
     * @version 1.0
     */
    protected class UndoHandler implements UndoableEditListener {
        /**
         * <p>Parameter-less constructor.</p>
         */
        public UndoHandler() {
            //do nothing
        }

        /**
         * <p>An undo-able edit happened.Manage the undo-able edit.</p>
         *
         * @param event UndoableEditEvent dispatched when undo-able edit occurs.
         *
         * @throws IllegalArgumentException if event is null
         */
        public void undoableEditHappened(UndoableEditEvent event) {
            //throw IAE if 'event' parameter is null
            if (event == null) {
                throw new IllegalArgumentException("The parameter 'event' should not be null.");
            }

            undoManager.addEdit(event.getEdit());
            undoAction.update();
            redoAction.update();
        }
    }
}
