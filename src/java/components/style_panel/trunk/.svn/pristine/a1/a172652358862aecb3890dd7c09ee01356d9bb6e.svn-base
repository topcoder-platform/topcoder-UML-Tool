/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.macosx;

import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.KeyStroke;
import javax.swing.InputMap;
import javax.swing.UIDefaults;
import javax.swing.UIManager;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.JTextComponent;
import javax.swing.text.Keymap;

/**
 * <p> Utility class containing a static method setDefaultInputMap which
 * re-maps the key bindings to a mac-like style.
 * </p>
 * @author L0s7man
 * @version 1.0
 */

public class MacInputMap {

	/**
	 * <p> Utility method which remaps the bindings to a mac-like style. </p>
	 * @param defaults the UIDefaults objects for a given component
	 *
	 */
	public static void setDefaultInputMap(UIDefaults defaults) {
		java.util.Enumeration keys = defaults.keys();

		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			Object value = UIManager.get(key);

			if (value instanceof InputMap) {
				// get the input map to be altered
				InputMap map = (InputMap) value;

				// next word action
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,
						InputEvent.ALT_MASK), DefaultEditorKit.nextWordAction);
				// dummy action for ctrl right
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,
						InputEvent.CTRL_MASK), "");
				// make cmd right jump to end of line
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, Toolkit
						.getDefaultToolkit().getMenuShortcutKeyMask()),
						DefaultEditorKit.endLineAction);

				// previous word action
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,
						InputEvent.ALT_MASK),
						DefaultEditorKit.previousWordAction);
				// dummy action for ctrl left
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,
						InputEvent.CTRL_MASK), "");
				// make cmd left jump to the begining of the line
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, Toolkit
						.getDefaultToolkit().getMenuShortcutKeyMask()),
						DefaultEditorKit.beginLineAction);

				// create cut action
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_X, Toolkit
						.getDefaultToolkit().getMenuShortcutKeyMask()),
						DefaultEditorKit.cutAction);
				// dummy action for ctrl x
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_X,
						InputEvent.CTRL_MASK), "");

				// create paste action
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_C, Toolkit
						.getDefaultToolkit().getMenuShortcutKeyMask()),
						DefaultEditorKit.copyAction);
				// dummy action for ctrl c
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_C,
						InputEvent.CTRL_MASK), "");

				// create copy action
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V, Toolkit
						.getDefaultToolkit().getMenuShortcutKeyMask()),
						DefaultEditorKit.pasteAction);
				// dummy action for ctrl v
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_V,
						InputEvent.CTRL_MASK), "");

				// select next word
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,
						InputEvent.ALT_MASK | InputEvent.SHIFT_MASK),
						DefaultEditorKit.selectionNextWordAction);
				// dummy action for ctrl - shift right
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,
						InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK), "");

				// select previous word
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,
						InputEvent.ALT_MASK | InputEvent.SHIFT_MASK),
						DefaultEditorKit.selectionPreviousWordAction);
				// dummy action for ctrl - shift left
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,
						InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK), "");

				// select to the end of line
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, Toolkit
						.getDefaultToolkit().getMenuShortcutKeyMask()
						| InputEvent.SHIFT_MASK),
						DefaultEditorKit.selectionEndLineAction);

				// select to the begining of line
				map.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, Toolkit
						.getDefaultToolkit().getMenuShortcutKeyMask()
						| InputEvent.SHIFT_MASK),
						DefaultEditorKit.selectionBeginLineAction);
			}
		}
	}
}
