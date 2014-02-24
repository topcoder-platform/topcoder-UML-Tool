/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.ClipboardOwner;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.TransientAction;

/**
 * <p>
 * <code>CopyDiagramElementAction</code> provides an action of copying
 * <code>DiagramElement</code> into a <code>Clipboard</code>. The
 * <code>DiagramElement</code> and the <code>Clipboard</code> is specified
 * in the constructor. Once the instance of <code>CopyDiagramElement</code> is
 * created it will not be changed any more.
 * </p>
 * <p>
 * This class will wrap the <code>DiagramElement</code> into
 * <code>Transferable</code> object with <code>DataFlavor</code> gotten from
 * <code>DiagramElementDataFlavorManager</code>. This
 * <code>Transferable</code> object will be transferred into the
 * <code>Clipboard</code> while executing this action.
 * </p>
 * <p>
 * This class is immutable so it is thread safe. But this class is still
 * expected to be used by single thread, other thread should create its own.
 * </p>
 *
 * @author pindut, TCSDEVELOPER
 * @version 1.0
 */
public class CopyDiagramElementAction implements TransientAction,
		ClipboardOwner {

	/**
	 * <p>
	 * Represents the <code>Clipboard</code> passed by Application. It's the
	 * target to save the given diagram element.
	 * </p>
	 *
	 */
	private final Clipboard clipboard;

	/**
	 * <p>
	 * Represents the <code>Transferable</code> object to be transferred into
	 * the <code>Clipboard</code>. It wraps the <code>DiagramElement</code>
	 * to be pasted along with its <code>DataFlavor</code> which is get from
	 * the <code>DiagramDataFlavorMananger</code>.
	 * </p>
	 *
	 */
	private final CopiedElement copiedElement;

	/**
	 * <p>
	 * Represents whether the <code>CopyDiagramElementAction</code> instance
	 * currently owns the <code>Clipboard</code>. Initial value of this field
	 * is <code>false</code>, set to <code>true</code> after successful
	 * copy transfer and set to <code>false</code> when no longer owns the
	 * <code>Clipboard</code>. Can be used for the future enhancement, if
	 * any.
	 * </p>
	 *
	 */
	private boolean currentlyOwnsClipboard;

	/**
	 * <p>
	 * Constructs <code>CopyDiagramElementAction</code> by given
	 * <code>DiagramElement</code> and <code>Clipboard</code>. While
	 * executing this action the <code>DiagramElement</code> will be wrapped
	 * to <code>CopiedElement</code> and be copied to the
	 * <code>Clipboard</code>.
	 * </p>
	 * <P>
	 * The clipboard argument can be null. If so, the system clipboard will be
	 * used.
	 * </P>
	 *
	 * @param element
	 *            the <code>DiagramElement</code> to be copied
	 * @param clipboard
	 *            target clipboard to copy the <code>DiagramElement</code>
	 * @throws ElementCloneException
	 *             if clone operation failed
	 * @throws IllegalArgumentException
	 *             if the element is <code>null</code>.
	 */
	public CopyDiagramElementAction(DiagramElement element, Clipboard clipboard)
			throws ElementCloneException {
		ArgumentCheckHelper.checkNotNull("element", element);

		// if the clipboard is null then system clipboard will be used.
		if (clipboard == null) {
			this.clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		} else {
			this.clipboard = clipboard;
		}

		// get the dataflavor from the DiagramElementDataFlavorManager
		DiagramElementDataFlavorManager diagramElementDataFlavorManager = new DiagramElementDataFlavorManager();
		DataFlavor copiedElementFlavor = diagramElementDataFlavorManager
				.getDataFlavor(element);

		// wrap the element to be copied with the flavor of the element to
		// CopiedElement
		copiedElement = new CopiedElement(element,
				new DataFlavor[] { copiedElementFlavor });
	}

	/**
	 * <p>
	 * Constructs <code>CopyDiagramElementAction</code> by given the
	 * <code>DiagramElement</code>. The action will copy the
	 * <code>DiagramElement</code> to the system clipboard if executed. The
	 * <code>CopyDiagramElementAction</code> will not be changed any more
	 * after created.
	 * </p>
	 *
	 * @param element
	 *            the <code>DiagramElement</code> to be copied
	 * @throws ElementCloneException
	 *             if clone operation failed
	 * @throws IllegalArgumentException
	 *             if the <code>DiagramElement</code> is <code>null</code>
	 */
	public CopyDiagramElementAction(DiagramElement element)
			throws ElementCloneException {
		this(element, null);
	}

	/**
	 * <p>
	 * Executes this action. <code>The DiagramElement</code> will be copied to
	 * the <code>Clipboard</code>.
	 * </p>
	 *
	 * @throws ActionExecutionException
	 *             if any <code>RuntimeException</code> happened
	 *
	 */
	public void execute() throws ActionExecutionException {
		try {
			clipboard.setContents(copiedElement, this);
			currentlyOwnsClipboard = true;
		} catch (RuntimeException e) {
			throw new ActionExecutionException(
					"failed to execute the copy action", e);
		}
	}

	/**
	 * <p>
	 * This method just flags this action with that it has lost the ownership of
	 * the clipboard. When this action lost the ownership of the clipboard to
	 * copied the diagram element this method should be invoked by the
	 * clipboard.
	 * </p>
	 *
	 * @param clipboard
	 *            the clipboard in which this action lost its ownership
	 * @param contents
	 *            the clipboard contents that was passed by this action and now
	 *            no longer inside the clipboard
	 * @throws IllegalArgumentException
	 *             if the clipboard or the contents is null
	 */
	public void lostOwnership(Clipboard clipboard, Transferable contents) {
		ArgumentCheckHelper.checkNotNull("clipboard", clipboard);
		ArgumentCheckHelper.checkNotNull("contents", contents);
		currentlyOwnsClipboard = false;
	}

	/**
	 * <P>
	 * Checks if this action still owns the clipboard to copy the diagram
	 * element to.
	 * </P>
	 *
	 * @return true if it still owns the clipboard, false otherwise.
	 */
	public boolean getCurrentlyOwnsClipboard() {
		return currentlyOwnsClipboard;
	}
}
