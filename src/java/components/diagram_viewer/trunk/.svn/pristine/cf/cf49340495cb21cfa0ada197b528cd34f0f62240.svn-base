/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.event;

import java.awt.FontMetrics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Dimension;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.topcoder.gui.diagramviewer.TextInputBox;

/**
 * <p>
 * This is an event listener which listens to key event for the TextInputBox.
 * When the user is typing in the TextInputBox, this listener will resize the
 * box when needed (if the text in the box is longer than the box's width), and
 * trigger TextInputEvent when key "Enter" or "Esc" is typed. This event
 * listener will be registered to the TextInputBox in this component
 * automatically.
 * </p>
 * <p>
 * Thread safety: This class is immutable, and thread-safe.
 * </p>
 *
 * @author kakarotto, TCSDEVELOPER
 * @version 1.0
 */
public class TextInputBoxKeyHandler extends KeyAdapter {

    /**
     * <p>
     * Default empty constructor.
     * </p>
     */
    public TextInputBoxKeyHandler() {
        // your code here
    }

    
   /**
     * <p>
     * Measures size of given text.
     * The method is used to calculate the bounds for the input box.
     * </p>
     *
     * @return the size of given text.
     *
     * @param text - the text to be measured.
     * @param fontMetrics - the fontmetrics to use.
     */
    private Dimension measureText(String text, FontMetrics fontMetrics) {
        // If the text is null or empty.
        if (text == null || text.length() == 0) {
            return new Dimension(0, 0);
        }

        // calculates the size of the text.
        int width = 0;
        String[] parts = text.split("\n");
        for (String part : parts) {
            int d = fontMetrics.stringWidth(part) + fontMetrics.getMaxAdvance();
            if (d > width) {
                width = d;
            }
        }
        return new Dimension(width, parts.length * fontMetrics.getHeight());
    }
    
    /**
     * <p>
     * Resize the TextInputBox along with the text inside. If the TextInputBox
     * support new lines (checked by method isNewLineAccepted), generate new
     * line when key "Ctrl + Enter" typed. If key "Enter" typed, trigger a text
     * entered event.
     * </p>
     *
     * @param event the key event (ignore null)
     */
    public void keyTyped(KeyEvent event) {
        // Obtain the TextInputBox:
        JTextArea textArea = (JTextArea) event.getSource();
        TextInputBox box = (TextInputBox) textArea.getParent();
        /*
		 * BugFix: BUGID UML-7799
		 * Description:
		 * The text input tool does not resize properly, according to the text that is
		 * inserted by the user.
		 * Solution:
		 * Resize automatically when a character is typed.
		 */
        FontMetrics fm = textArea.getFontMetrics(textArea.getFont());
        //int width = SwingUtilities.computeStringWidth(fm, textArea.getText());
        // Leave 3 pixels space for cursor and border
        //box.setPopupSize(width + fm.charWidth(event.getKeyChar()) + 3, box.getHeight());
        
        // Process "Ctrl + Enter":
        /* 
         * BugFix: BUGR-69/70
         * Use of Ctrl+Enter, getKeyCode should not be used, it should instead be getKeyChar.
         */
        // old code
        // if (box.isNewLineAccepted() && event.isControlDown() && event.getKeyCode() == KeyEvent.VK_ENTER) {
        if (box.isNewLineAccepted() && event.isControlDown() && event.getKeyChar() == KeyEvent.VK_ENTER) {
            // old code
            //textArea.setText(box.getText() + "\n");
            // Insert the newline where the caret is.
            String text = box.getText();
            int index = textArea.getCaretPosition();
            text = text.substring(0, index) + "\n" + text.substring(index);
            textArea.setText(text);
            // Restore the caret position.
            textArea.setCaretPosition(index + 1);
        }
        /*
		 * BugFix: BUGID UML-7161
		 * Description:
		 * getKeyCode should not be used,it should instead be getKeyChar.
		 */
        // old code
//        if (event.getKeyCode() == KeyEvent.VK_ENTER) {
        else if (event.getKeyChar() == KeyEvent.VK_ENTER) {
            // BugFix: BUGR-69/70: Only the last newline entered newline should
            // be removed.
            String text = textArea.getText();
            int index = textArea.getCaretPosition()-1;
            // old code
            //int index = text.indexOf('\n');
            text = text.substring(0, index) + text.substring(index + 1);
            textArea.setText(text);
            box.fireTextEntered();
            box.setVisible(false);
        } 

        // Make sure the size of the box is at least the preferred size.
        Dimension dim = measureText(textArea.getText(), fm);
        Dimension preferredSize = textArea.getPreferredSize(); 
        dim.width += 3;
        dim.height += 5;
        if (preferredSize.width+5 > dim.width) {
           dim.width = preferredSize.width+5;
        }
        if (preferredSize.height+5 > dim.height) {
           dim.height = preferredSize.height+5;
        }
        box.setPopupSize( dim.width, dim.height );
        
        textArea.requestFocus();
    }

    /**
     * <p>
     * If key is "Esc", trigger a text cancelled event.
     * </p>
     *
     * @param event the key event (ignore null)
     */
    public void keyPressed(KeyEvent event) {
        // Obtain the TextInputBox:
        JTextArea textArea = (JTextArea) event.getSource();
        TextInputBox box = (TextInputBox) textArea.getParent();
        /*
		 * BugFix: BUGID UML-7161
		 * Description:
		 * getKeyCode should not be used, it should instead be getKeyChar.
		 */
        // old code
//        if (event.getKeyCode() == KeyEvent.VK_ESCAPE) {
        if (event.getKeyChar() == KeyEvent.VK_ESCAPE) {
            box.fireTextCancelled();
        }
    }
}
