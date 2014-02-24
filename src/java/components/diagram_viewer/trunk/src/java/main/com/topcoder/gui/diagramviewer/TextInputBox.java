/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import java.awt.Dimension;

import javax.swing.JPopupMenu;
import javax.swing.JTextArea;
import javax.swing.event.PopupMenuEvent;
import javax.swing.event.PopupMenuListener;

import com.topcoder.gui.diagramviewer.event.TextInputBoxKeyHandler;
import com.topcoder.gui.diagramviewer.event.TextInputEvent;
import com.topcoder.gui.diagramviewer.event.TextInputListener;

/**
 * <p>
 * This is a text input tool that is displayed as a popup, it appears as a text
 * area that can accept user's input, and reacts the "enter" key to accept the
 * text inputted into it and triggers an event. It will be used in the
 * DiagramView to receive user's input content. It extends the JPopupMenu to
 * obtain the popup feature, and it contains a JTextArea to get the input from
 * the user.
 * </p>
 * <p>
 * It can be used as a single line text field, or automatically generate new
 * line when "Ctrl + Enter" typed, this feature depends on the value of field
 * newLineAccepted.
 * </p>
 * <p>
 * Thread safety: this class is mutable so not thread safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class TextInputBox extends JPopupMenu {

    /**
     * <p>
     * A JTextArea to provide the functionality to receive input from the user.
     * </p>
     * <p>
     * Initialized in ctor to a new JTextArea and never changed later. Can not
     * be null.
     * </p>
     */
    private final JTextArea textArea;

    /**
     * <p>
     * Represents a flag that whether accept new line if the "Ctrl" + "Enter"
     * keys are pressed.
     * </p>
     * <p>
     * Initialized in ctor, can be accessed by getter and setter.
     * </p>
     */
    private boolean newLineAccepted = false;

    /**
     * <p>
     * Constructor, initialize the text area, and register TextInputKeyHandler
     * as a key listener.
     * </p>
     */
    public TextInputBox() {
        textArea = new JTextArea(1, 10);
        textArea.addKeyListener(new TextInputBoxKeyHandler());
        add(textArea);

        /*
		 * BugFix: BUGID UML-7072
		 * Description:
		 * In the text input box that
		 * extends from PopupMenu, when the popup is showing, a mouse click
		 * outside of the popup will cancel or finish the text input. No finish
		 * or cancel event is sent in this situation, but this is needed to
		 * properly handle user input.
		 * Solution:
		 * Add a popup menu handler to handle the cancel event.
		 */
		this.addPopupMenuListener(new PopupMenuHandler());
    }

    /**
     * <p>
     * Setter of newLineAccepted, see field doc for explanation.
     * </p>
     *
     * @param newLineAccepted whether accept Ctrl + Enter as new line signal
     */
    public void setNewLineAccepted(boolean newLineAccepted) {
        this.newLineAccepted = newLineAccepted;
    }

    /**
     * <p>
     * Getter of newLineAccepted, see field doc for explanation.
     * </p>
     *
     * @return true if Ctrl + Enter will be regarded as new line signal
     */
    public boolean isNewLineAccepted() {
        return newLineAccepted;
    }

    /**
     * <p>
     * Registers a TextInputListener to the listener list. Null will be
     * processed by the listenerList#add method.
     * </p>
     *
     * @param listener the listener to be registered
     */
    public void addTextInputListener(TextInputListener listener) {
        listenerList.add(TextInputListener.class, listener);
    }

    /**
     * <p>
     * Removes a TextInputListener from the listener list. Null will be
     * processed by the listenerList#add method.
     * </p>
     *
     * @param listener the listener to be removed
     */
    public void removeTextInputListener(TextInputListener listener) {
        listenerList.remove(TextInputListener.class, listener);
    }

    /**
     * <p>
     * Create a TextInputEvent (entering) and notify all listeners registered
     * interest for TextInputEvent.
     * </p>
     */
    public void fireTextEntered() {
        TextInputEvent event = new TextInputEvent(this, getText());
        for (TextInputListener listener : listenerList.getListeners(TextInputListener.class)) {
            listener.textEntered(event);
        }
    }

    /**
     * <p>
     * Create a TextInputEvent (cancelling) and notify all listeners registered
     * interest for TextInputEvent.
     * </p>
     */
    public void fireTextCancelled() {
        TextInputEvent event = new TextInputEvent(this, getText());
        for (TextInputListener listener : listenerList.getListeners(TextInputListener.class)) {
            listener.textCancelled(event);
        }
    }

    /**
     * <p>
     * Clear the text in the textArea.
     * </p>
     */
    public void clearText() {
        textArea.setText("");
    }

    /**
     * <p>
     * Get text from the inner text area.
     * </p>
     *
     * @return the text in this box
     */
    public String getText() {
        return textArea.getText();
    }

    /**
     * <p>
     * Set text for the inner text area.
     * </p>
     *
     * @param text the new text
     * @throws IllegalArgumentException if the arg is null or empty
     */
    public void setText(String text) {
        DVHelper.validateString(text, "text");
        textArea.setText(text);
        // get the new size and reset this size.
        Dimension preferredSize = textArea.getPreferredSize();
        this.setPopupSize(preferredSize.width + 5, preferredSize.height + 5);
    }

    /**
	 * <p>
	 * Implementation of <code>PopupMenuListener</code> to handle popup menu
	 * cancelling.
	 * </p>
	 *
	 * @author TCSDEVELOPER
	 * @version 1.0
	 */
	class PopupMenuHandler implements PopupMenuListener {
		/**
		 * This method is called before the popup menu becomes visible
		 */
		public void popupMenuWillBecomeVisible(PopupMenuEvent e) {
		}

		/**
		 * This method is called before the popup menu becomes invisible Note
		 * that a JPopupMenu can become invisible any time
		 */
		public void popupMenuWillBecomeInvisible(PopupMenuEvent e) {
		}

		/**
		 * This method is called when the popup menu is canceled
		 */
		public void popupMenuCanceled(PopupMenuEvent e) {
            /*
             * BugFix: UML-10093
             * When popup menu is cancelled, accept the input text.
             */
            // old code
//			fireTextCancelled();
            fireTextEntered();
		}
	}
}
