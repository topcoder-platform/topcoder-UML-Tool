/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.NoSuchElementException;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <P>
 * The <code>PasteDiagramElementAction</code> will perform an action of
 * pasting the <code>DiagramElement</code> into the specified
 * <code>Diagram</code>. The <code>DiagramElement</code> to be pasted and
 * the <code>Diagram</code> should be given in the constructor. While invoking
 * the execute method the <code>DiagramElement</code> will be pasted to the
 * <code>Diagram</code>. The action can be undo or redo.
 * </P>
 * <p>
 * This class is immutable so it's thread safe. But this class is still expected
 * to be used by single thread, other thread should create its own.
 * </p>
 *
 * @author pindut, TCSDEVELOPER
 * @version 1.0
 *
 */
public class PasteDiagramElementAction implements UndoableAction {

	/**
	 * <P>
	 * The presentation name of this class.
	 * </P>
	 */
	private static final String PRESENTATION_NAME = "PasteDiagramElementAction";

	/**
	 * <P>
	 * The message for <code>UnsupportedOperationException</code>s.
	 * </P>
	 */
	private static final String UNSUPPORTED_OPERATION_MESSAGE = "this method is not supported";

	/**
	 * <p>
	 * The target <code>Diagram</code> to perform pasting action.
	 * </p>
	 *
	 */
	private final Diagram diagram;

	/**
	 * <p>
	 * Represents the diagram element to be pasted into the diagram.
	 * </p>
	 *
	 */
	private final DiagramElement toBePasted;

	/**
	 * <p>
	 * Represents the container of element. It may be modified after execution.
	 * </p>
	 */
	private GraphElement container;

	/**
	 * <P>
	 * The flag shows whether the action has been executed. If the action has
	 * been executed once this field will be true. Otherwise will be false.
	 * </P>
	 */
	private boolean executed;

	/**
	 * <P>
	 * The flag shows whether the action has been undone. After invoking undo
	 * method this field will be true.
	 * </P>
	 */
	private boolean undone;

	/**
	 * <p>
	 * Creates an instance of <code>PasteDiagramElementAction</code>. The
	 * <code>DiagramElement</code> to be pasted and the <code>Diagram</code>
	 * to paste should be given in the constructor. The
	 * <code>DiagramElement</code> should be given by wrapped to an instance
	 * of <code>CopiedElement</code>.
	 * </p>
	 * <p>
	 * Once the instance of <code>PasteDiagramElementAction</code> is created,
	 * it is constant. Its diagram element and diagram can't be changed to other
	 * instance.
	 * </p>
	 *
	 * @param clipboardContent
	 *            the <code>Transferable</code> that its content is to be
	 *            pasted into the diagram. The <code>Transferable</code> must
	 *            be an instance of <code>CopiedElement</code>
	 * @param diagram
	 *            The target diagram to paste the <code>DiagramElement</code>
	 * @throws IllegalArgumentException
	 *             if the clipboardContent or the diagram is <code>null</code>
	 *             or the clipboardContent isn't an instance of
	 *             <code>CopiedElement</code>
	 */
	public PasteDiagramElementAction(Transferable clipboardContent,
			Diagram diagram) {
		ArgumentCheckHelper.checkNotNull("clipboardContent", clipboardContent);
		if (!(clipboardContent instanceof CopiedElement)) {
			throw new IllegalArgumentException(
					"clipboardContent must be an instance of CopiedElement");
		}
		CopiedElement copiedElement = (CopiedElement) clipboardContent;
		this.diagram = (Diagram) ArgumentCheckHelper.checkNotNull("diagram",
				diagram);
		DataFlavor dataFlavor = copiedElement.getTransferDataFlavors()[0];
		toBePasted = (DiagramElement) copiedElement.getTransferData(dataFlavor);
	}

	/**
	 * <p>
	 * Pastes the <code>DiagramElement</code> into the <code>Diagram</code>.
	 * This will send <code>addContained</code> to the <code>Diagram</code>.
	 * The <code>DiagramElement</code> should be added to the end of the
	 * <code>DiagramElement</code> list in the <code>Diagram</code> even
	 * there is a duplicate one. But the exactly behavior depends on
	 * <code>Diagram</code> class. Please see <code>Diagram</code> class for
	 * details.
	 * </p>
	 * <P>
	 * This method can be invoked more than one time. It will just paste the
	 * element into the diagram again.
	 * </P>
	 *
	 * @throws ActionExecutionException
	 *             if any <code>RuntimeException</code> happened while
	 *             executing the action.
	 *
	 */
	public void execute() throws ActionExecutionException {
		diagram.addContained(toBePasted);
		toBePasted.setContainer(diagram);
		
//		if (toBePasted instanceof GraphNode) {
//			GraphNode target = (GraphNode) toBePasted;
//			for (DiagramElement	el : diagram.getContaineds()) {
//				if (el instanceof GraphNode) {
//					GraphNode source = (GraphNode) el;
//					if (source.getPosition().equals(target.getPosition()) && source.getSize().equals(target.getSize())) {
//						CopyPasteCutUtil.addPastedOffset(target);
//					}
//				}
//			}
//		}
		executed = true;
	}

	/**
	 * <p>
	 * Undoes the action. This method will remove the pasted
	 * <code>DiagramElemet</code> from the <code>Diagram</code>. If the
	 * action hasn't been executed this method can't be invoked. If the
	 * <code>DiagramElement</code> isn't in the <code>Diagram</code> a
	 * <code>CannotUndoException</code> would be thrown.
	 * </p>
	 *
	 * @throws CannotUndoException
	 *             if the action hasn't been executed
	 * @throws NoSuchElementException
	 *             if the <code>Diagram</code> doesn't contain this element
	 *
	 */
	public void undo() {
		if (!executed) {
			throw new CannotUndoException();
		}

		container = toBePasted.getContainer();

		if (!container.removeContained(toBePasted)) {
			throw new NoSuchElementException(
					"the element doesn't exist in the diagram");
		}

		undone = true;
	}

	/**
	 * <p>
	 * Redoes the action. This method will just remove the effect of undo. The
	 * <code>DiagramElement</code> will be pasted to the <code>Diagram</code>
	 * again. If the action hasn't been undone this method can't be invoked.
	 * </p>
	 *
	 * @throws CannotRedoException
	 *             if the action hasn't been undone.
	 *
	 */
	public void redo() {
		if (!undone) {
			throw new CannotRedoException();
		}

		container.addContained(toBePasted);
		toBePasted.setContainer(container);
	}

	/**
	 * <p>
	 * This method always return false. Since no <code>UndoableEdit</code> can
	 * be added to this action.
	 * </p>
	 *
	 * @param anEdit
	 *            The <code>UndoableEdit</code> to be added
	 * @return always false
	 */
	public boolean addEdit(UndoableEdit anEdit) {
		return false;
	}

	/**
	 * <p>
	 * This method is no longer supported it will only throw
	 * <code>UnsupportedOperationException</code>.
	 * </p>
	 *
	 * @return if the action can be undone now
	 * @throws UnsupportedOperationException
	 *             this method always throws this exception
	 */
	public boolean canUndo() {
		throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
	}

	/**
	 * <p>
	 * This method is no longer supported it will only throw
	 * <code>UnsupportedOperationException</code>.
	 * </p>
	 *
	 * @return if the action can be redone now
	 * @throws UnsupportedOperationException
	 *             this method always throws this exception
	 */
	public boolean canRedo() {
		throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
	}

	/**
	 * <p>
	 * This method is no longer supported now it will only throw
	 * <code>UnsupportedOperationException</code>.
	 * </p>
	 *
	 * @throws UnsupportedOperationException
	 *             this method always throws this exception
	 */
	public void die() {
		throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
	}

	/**
	 * <p>
	 * Gets the presentation name.
	 * </p>
	 *
	 * @return the presentation name
	 */
	public String getPresentationName() {
		return PRESENTATION_NAME;
	}

	/**
	 * <p>
	 * Gets the undo presentation name.
	 * </p>
	 *
	 * @return the undo presentation name
	 */
	public String getUndoPresentationName() {
		return "Undo" + PRESENTATION_NAME;
	}

	/**
	 * <p>
	 * Gets the redo presentation name.
	 * </p>
	 *
	 * @return the redo presentation name.
	 */
	public String getRedoPresentationName() {
		return "Redo" + PRESENTATION_NAME;
	}

	/**
	 * <P>
	 * This action is significant to undo/redo so always return true.
	 * </P>
	 *
	 * @return whether this action is significant to undo/redo
	 */
	public boolean isSignificant() {
		return true;
	}

	/**
	 * <p>
	 * This method always return false. Since this action never replace other
	 * <code>UndoableEdit</code>.
	 * </p>
	 *
	 * @param anEdit
	 *            the <code>UndoableEdit</code> to be replaced
	 * @return always false
	 */
	public boolean replaceEdit(UndoableEdit anEdit) {
		return false;
	}
}
