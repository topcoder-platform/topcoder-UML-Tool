/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.Clipboard;

import javax.swing.undo.UndoableEdit;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.util.actionmanager.CompoundUndoableAction;
import com.topcoder.util.actionmanager.TransientUndoableAction;

/**
 * <P>
 * <code>CutDiagramElementAction</code> will perform cut i.e. copy and remove
 * on the specified <code>DiagramElement</code> at the specified
 * <code>Diagram</code> into the specified <code>Clipboard</code>.
 * </p>
 * <P>
 * The <code>DiagramElement</code>, the <code>Diagram</code> and the
 * <code>Clipboard</code> is specified in the constructor. After the instance
 * is created it can't be changed any more. To change any of them the customer
 * should create a new instance.
 * </P>
 * <p>
 * This class is immutable so it's thread safe. But it's still expected to be
 * used by single thread.
 * </p>
 *
 * @author pindut, TCSDEVELOPER
 * @version 1.0
 *
 */
public class CutDiagramElementAction extends CompoundUndoableAction {

	/**
	 * <P>
	 * The presentation name of this class.
	 * </P>
	 */
	private static final String PRESENTATION_NAME = "CompoundedCopyAndRemoveAction";

	/**
	 * <P>
	 * The message for the <code>UnsupportedOperationException</code>s.
	 * </P>
	 */
	private static final String UNSUPPORTED_OPERATION_MESSAGE = "this method is not supported";

	/**
	 * <p>
	 * Creates an instance of <code>CutDiagramElementAction</code>. The
	 * <code>DiagramElement</code> to be cut and the <code>Diagram</code> to
	 * cut from should be given in this constructor. The <code>Clipboard</code>
	 * is optional. It represents the <code>Clipboard</code> to save the cut
	 * <code>DiagramElement</code>. If the <code>Clipboard</code> is
	 * <code>null</code> the system clipboard will be used.
	 * </p>
	 *
	 * @param element
	 *            the <code>DiagramElement</code> to be cut
	 * @param diagram
	 *            the <code>Diagram</code> where the
	 *            <code>DiagramElement</code> is located
	 * @param clipboard
	 *            the target <code>Clipboard</code> to save the cut
	 *            <code>DiagramElement</code>
	 * @throws ElementCloneException
	 *             if clone operation failed
	 * @throws IllegalArgumentException
	 *             if the element or the diagram is <code>null</code>
	 */
	public CutDiagramElementAction(DiagramElement element, Diagram diagram,
			Clipboard clipboard) throws ElementCloneException {
		super(PRESENTATION_NAME);

		addCopyDiagramElementAction(element, clipboard);
		addRemoveDiagramElementAction(element, diagram);
	}

	/**
	 * <P>
	 * No <code>UndoableEdit</code> can be added to this. This request will be
	 * refused by return false.
	 * </P>
	 *
	 * @return always false
	 */
	public boolean addEdit() {
		return false;
	}

	/**
	 * <P>
	 * This action never replaces other <code>UndoableEdit</code>. False will
	 * be returned to refuse this.
	 * </P>
	 *
	 * @param anEdit
	 *            the <code>UndoableEdit</code> to be replaced
	 *
	 * @return always false
	 */
	public boolean replaceEdit(UndoableEdit anEdit) {
		return false;
	}

	/**
	 * <P>
	 * This method is not supported. It will simply throw
	 * <code>UnsuppoortedOpertationException</code>.
	 * </P>
	 *
	 * @return if the action can be undone now
	 *
	 * @throws UnsupportedOperationException
	 *             this method always throws this exception
	 *
	 */
	public boolean canUndo() {
		throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
	}

	/**
	 * <P>
	 * This method is not supported. It will simply throw
	 * <code>UnsuppoortedOpertationException</code>.
	 * </P>
	 *
	 * @return if the action can be redone now
	 *
	 * @throws UnsupportedOperationException
	 *             this method always throws this exception
	 */
	public boolean canRedo() {
		throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
	}

	/**
	 * <P>
	 * This method is not supported. It will simply throw
	 * <code>UnsuppoortedOpertationException</code>.
	 * </P>
	 *
	 * @throws UnsupportedOperationException
	 *             this method always throws this exception
	 */
	public void die() {
		throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
	}

	/**
	 * <P>
	 * Checks if this action is significant to undo/redo or not. This method
	 * always returns true since this action is significant to that.
	 * </P>
	 *
	 * @return always true
	 */
	public boolean isSignificant() {
		return true;
	}

	/**
	 * <P>
	 * Creates a <code>CopyDiagramElement</code> instance and adds it to the
	 * compoundEdit in the super class. The <code>CopyDiagramElement</code>
	 * will be a part of the cut action.
	 * </P>
	 * <P>
	 * The clipboard argument can be null. If so, the system clipboard will be
	 * used instead.
	 * </P>
	 *
	 * @param element
	 *            the element to be copied
	 * @param clipboard
	 *            the clipboard to save the element
	 * @throws ElementCloneException
	 *             if clone operation failed
	 * @throws IllegalArgumentException
	 *             if the element is <code>null</code>
	 */
	private void addCopyDiagramElementAction(DiagramElement element,
			Clipboard clipboard) throws ElementCloneException {
		CopyDiagramElementAction copyDiagramElementAction = new CopyDiagramElementAction(
				element, clipboard);
		TransientUndoableAction undoableCopyAction = new TransientUndoableAction(
				copyDiagramElementAction, "CopyDiagramElementAction");
		super.addEdit(undoableCopyAction);
	}

	/**
	 * <P>
	 * Creates a <code>RemoveDiagramElementAction</code> instance and adds it
	 * to the compoundEdit in the super class. The remove action will be a part
	 * of the cut action. It will be executed after the copy action.
	 * </P>
	 *
	 * @param element
	 *            the element to be removed
	 * @param diagram
	 *            the diagram to remove the element from
	 * @throws IllegalArgumentException
	 *             if the element or the diagram is <code>null</code>
	 */
	private void addRemoveDiagramElementAction(DiagramElement element,
			Diagram diagram) {
		RemoveDiagramElementAction removeDiagramElementAction = new RemoveDiagramElementAction(
				element, diagram);
		super.addEdit(removeDiagramElementAction);
	}
}
