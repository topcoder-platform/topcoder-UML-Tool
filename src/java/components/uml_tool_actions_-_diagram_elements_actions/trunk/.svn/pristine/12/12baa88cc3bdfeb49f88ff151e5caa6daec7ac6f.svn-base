/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoableEdit;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.UndoableAction;

/**
 * <P>
 * <code>RemoveDiagramElementAction</code> will provide action of removing
 * <code>DiagramElement</code> from <code>Diagram</code> that are specified
 * by the Application. The <code>DiagramElement</code> and the
 * <code>Diagram</code> should be given while creating the
 * <code>RemoveDiagramElementAction</code>. Once it created it can't be
 * changed anymore. The action can be undone or redone.
 * </p>
 * <p>
 * This class is immutable but still is expected to be used by single thread,
 * other thread should create its own.
 * </p>
 *
 * @author pindut, TCSDEVELOPER
 * @version 1.0
 *
 */
public class RemoveDiagramElementAction implements UndoableAction {

    /**
     * <P>
     * The presentation name of this class.
     * </P>
     *
     */
    private static final String PRESENTATION_NAME = "RemoveDiagramElementAction";

    /**
     * <P>
     * The message for the <code>UnsupportedOperationException</code>s.
     * </P>
     */

    private static final String UNSUPPORTED_OPERATION_MESSAGE = "this method is not supported by this action";
    /**
     * <p>
     * Represents the <code>DiagramElement</code> to be deleted. The diagram
     * element is kept using this attribute for undo purpose.
     * </p>
     *
     */
    private final DiagramElement element;

    /**
     * <p>
     * Represents the diagram in which the specified diagram element located.
     * </p>
     *
     */
    private final Diagram diagram;

    /**
     * <P>
     * The flag shows whether the action is executed.
     * </P>
     *
     */
    private boolean executed;

    /**
     * <P>
     * The flag shows whether the action is undone.
     * </P>
     *
     */
    private boolean undone;

    /**
     * <p>
     * Creates an instance of <code>RemoveDiagramElementAction</code>. The
     * <code>DiagramElement</code> to be removed and the <code>Diagram</code>
     * to remove from should be given. Once the
     * <code>RemoveDiagramElementAction</code> object is created it is
     * constant the element and the diagram can't be changed to other instance.
     * </p>
     *
     * @param element
     *            the <code>DiagramElement</code> to be removed
     * @param diagram
     *            the <code>Diagram</code> where the
     *            <code>DiagramElement</code> is located
     * @throws IllegalArgumentException
     *             if the element or the diagram is <code>null</code>
     *
     */
    public RemoveDiagramElementAction(DiagramElement element, Diagram diagram) {
        this.element = (DiagramElement) ArgumentCheckHelper.checkNotNull(
                "element", element);
        this.diagram = (Diagram) ArgumentCheckHelper.checkNotNull("diagram",
                diagram);
    }

    /**
     * <p>
     * Removes the specified <code>DiagramElement</code> from the given
     * <code>Diagram</code>. If the <code>Diagram</code> doesn't contain
     * this element an <code>ActionExecutionException</code> will be thrown. If
     * the <code>Diagram</code> contains multiple this element the first one
     * will be removed. The exactly behavior depends on <code>Diagram</code>.
     * Please see <code>Diagram</code> for details.
     * </p>
     *
     * @throws ActionExecutionException
     *             if any <code>RuntimeException</code> happened while removing the element
     *             or the <code>Diagram</code> doesn't contain the element
     */
    public void execute() throws ActionExecutionException {

        if (!diagram.removeContained(element)) {
            throw new ActionExecutionException("the element doesn't exist in this diagram");
        }

        executed = true;
    }

    /**
     * <p>
     * Undoes the action. Puts back the element removed to the <code>Diagram</code>. If the method
     * hasn't been executed it can't be undone again. Otherwise, a <code>CannotUndoException</code>
     * would be thrown.
     * </p>
     *
     * @throws CannotUndoException
     *             if the action hasn't been executed
     */
    public void undo() {
        if (!executed) {
            throw new CannotUndoException();
        }

        diagram.addContained(element);
        undone = true;
    }

    /**
     * <p>
     * Redoes the action. Removes the specified diagram element again. If the
     * action hasn't been undone, the redo method can't be invoked. Otherwise, a
     * <code>CannotRedoException</code> will be thrown. The diagram doesn't
     * contain the element also will cause a <code>CannotRedoException</code>.
     * </p>
     *
     * @throws CannotRedoException
     *             if the action isn't undone or the diagram doesn't contain the
     *             element.
     *
     */
    public void redo() {
        if (!undone || !diagram.removeContained(element)) {
            throw new CannotRedoException();
        }

    }

    /**
     * <p>
     * This action never accept other edit to be added to this. So this method will
     * just return false.
     * </p>
     *
     * @param anEdit
     *            The <code>UndoableEdit</code> to be added
     * @return always false
     *
     */
    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * <p>
     * This method is no longer supported now. This will just throw
     * <code>UnsupportedOperationException</code>.
     * </p>
     *
     * @return true if it can undo now, false otherwise
     *
     * @throws UnsupportedOperationException
     *             this method always throws this exception
     */
    public boolean canUndo() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    /**
     * <p>
     * This method is no longer supported now. This will just throw
     * <code>UnsupportedOperationException</code>.
     * </p>
     *
     * @return true if it can redo now, false otherwise
     *
     * @throws UnsupportedOperationException
     *             this method always throw this exception
     */
    public boolean canRedo() {
        throw new UnsupportedOperationException(UNSUPPORTED_OPERATION_MESSAGE);
    }

    /**
     * <p>
     * This method is no longer supported now. This will just throw
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
     * Get the redo presentation name.
     * </p>
     *
     * @return the redo presentation name
     */
    public String getRedoPresentationName() {
        return "Redo" + PRESENTATION_NAME;
    }

    /**
     * <p>
     * Checks if this action is significant to undo/redo.
     * </p>
     *
     * @return always return true
     */
    public boolean isSignificant() {
        return true;
    }

    /**
     * <p>
     * This action doesn't support replace another <code>UndoableEdit</code>.
     * So this method always returns false.
     * </p>
     *
     * @param anEdit
     *            the <code>UnableEdit</code> to be replaced
     * @return always return false
     */
    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }
}
