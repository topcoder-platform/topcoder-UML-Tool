/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.DocumentationListener;

import com.topcoder.uml.model.core.ModelElement;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


/**
 * <p>
 *  <strong>Usage:</strong>
 *  <br/>
 *  A <code>DocumentationEditor</code> is a <code>JPanel</code> which gives
 *  the user the ability to modify the documentation attached to a <code>
 *  ModelElement</code> within a UML model.
 * </p>
 *
 * <p>
 *  <strong>Definition:</strong>
 *  <br/>
 *  This abstract superclass defines all methods required for a documentation
 *  editor to be used within a <code>DocumentationPanel</code>. It also stores
 *  the target element, and manages all listener classes that are waiting for
 *  notifications when then documentation is edited.
 * </p>
 *
 * <p>
 *  <strong>Restriction:</strong>
 *  <br/>
 *  All extending subclasses must have constructors which take a single String
 *  as parameter, to allow simple construction via reflection by a <code>
 *  DocumentationPanel</code>.
 * </p>
 *
 * <p>
 *  <strong>Thread Safety:</strong>
 *  <br/>
 *  This class is not thread safe. The listeners can be read and modified by
 *  concurrent threads without any read/write protection. And all extending
 *  subclasses should not actually modify the documentation of their target
 *  in any way, only firing events when the user wants changes.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public abstract class DocumentationEditor extends JPanel {
    /**
     * <p>
     * List of documentation listeners attached to this object. This is
     * initially an empty <code>ArrayList</code>, and the list instance
     * does not change after creation.
     * </p>
     *
     * <p>
     * Its contents can be added and removed and obtained via:
     *  <ul>
     *   <li><code>addDocumentationListener()</code></li>
     *   <li><code>removeDocumentationListener()</code></li>
     *  </ul>
     * The element within this list will never be null.
     * </p>
     */
    private final List < DocumentationListener > listeners =
        new ArrayList < DocumentationListener >();

    /**
     * <p>
     * The element represents whose documentation is being managed.
     * </p>
     *
     * <p>
     * This is modified through calling <code>setTarget()</code> to
     * any non-null <code>ModelElement</code>, and is added to the
     * events when they are fired to listeners.
     * </p>
     */
    private ModelElement target;

   /**
    * <p>
    * Default, no-arg constructor, nothing happens within the body of this method.
    * </p>
    */
    protected DocumentationEditor() {
    }

    /**
     * <p>
     * Get current target managed.
     * </p>
     *
     * @return current target managed. Maybe null.
     */
    protected ModelElement getTarget() {
        return target;
    }

    /**
     * <p>
     * sets the target member, to the given (non-null) <code>ModelElement</code>.
     * </p>
     *
     * @param element The new <code>ModelElement</code> to manage.
     *
     * @throws IllegalArgumentException if the parameter is null.
     * @throws UnknownElementTypeException may be thrown by subclasses
     *         by this method.
     */
    public void setTarget(ModelElement element) throws UnknownElementTypeException {
        DocumentPanelHelper.validateNotNull(element, "ModelElement whose documentation to be managed");
        this.target = element;
    }

    /**
     * <p>
     * Adds a <code>DocumentationListener</code> to the list of classes
     * listening for documentation edits.
     * </p>
     *
     * <p>
     * The parameter cannot be null, but may be a duplicate of a listener
     * already added.
     * </p>
     *
     * @param listener listener to attach to the object, cannot be null.
     *
     * @throws IllegalArgumentException if the parameter is null
     */
    public void addDocumentationListener(DocumentationListener listener) {
        DocumentPanelHelper.validateNotNull(listener, "DocumentationListener to be attached");
        this.listeners.add(listener);
    }

    /**
     * <p>
     * Removes a listener from the list of attached objects. This
     * removes the first matching instance from the list.
     * </p>
     *
     * <p>
     * If the parameter is null or not in the list, then nothing happens,
     * and no exception is thrown.
     * </p>
     *
     * @param listener listener to detach to the object, can be null
     */
    public void removeDocumentationListener(DocumentationListener listener) {
        if (listener == null || !this.listeners.contains(listener)) {
            return;
        }
        this.listeners.remove(listener);
    }

    /**
     * <p>
     * Returns a shallow copy of the list of all listeners currently
     * listening to documentation edits by this editor.
     * </p>
     *
     * <p>
     * Never returns null, but may be an empty list.
     * </p>
     *
     * @return A shallow copy of all attached listeners
     */
    public List < DocumentationListener > getDocumentationListeners() {
        return new ArrayList < DocumentationListener >(this.listeners);
    }

    /**
     * <p>
     * Notify all listeners that documentation is ready to be added to
     * the target.
     * </p>
     *
     * <p>
     * <code>documentationCreated()</code> is fired on each attached listener
     * with a passed in <code>DocumentationEvent</code>.
     * </p>
     *
     * @param current the current documentation text which is to be attached to
     *        the model element.
     *
     * @throws IllegalArgumentException if the parameter is empty(trimmed) or null
     */
    protected void fireDocumentationCreated(String current) {
        DocumentPanelHelper.validateString(current, "Current documentation being created");
        DocumentationEvent event = new DocumentationEvent(this.target, null, current);
        for (DocumentationListener listener : this.listeners) {
            listener.documentationCreated(event);
        }
    }

    /**
     * <p>
     * Notify all listeners that the target's documentation is ready to
     * be modified.
     * </p>
     *
     * <p>
     * <code>documentationUpdated()</code> is fired on each attached listener
     * with a passed in <code>DocumentationEvent</code>.
     * </p>
     *
     * @param previous The previous documentation that is attached to the
     *        element
     * @param current The new documentation text that should be stored on the
     *        element.
     *
     * @throws IllegalArgumentException if any parameter is empty(trimmed) or null
     */
    protected void fireDocumentationUpdated(String previous, String current) {
        DocumentPanelHelper.validateString(previous, "Previous documentation being updated");
        DocumentPanelHelper.validateString(current, "Current documentation being updated");
        DocumentationEvent event = new DocumentationEvent(this.target, previous, current);
        for (DocumentationListener listener : this.listeners) {
            listener.documentationUpdated(event);
        }
    }

    /**
     * <p>
     * Notify all listeners that the target's documentation is ready for
     * removal.
     * </p>
     *
     * <p>
     * <code>documentationDeleted()</code> is fired on each attached listener
     * with a passed in <code>DocumentationEvent</code>.
     * </p>
     *
     * @param previous The documentation that is to be removed from the
     *        element.
     *
     * @throws IllegalArgumentException if the parameter is empty(trimmed) or null
     */
    protected void fireDocumentationDeleted(String previous) {
        DocumentPanelHelper.validateString(previous, "Previous documentation being deleted");
        DocumentationEvent event = new DocumentationEvent(this.target, previous, null);
        for (DocumentationListener listener : this.listeners) {
            listener.documentationDeleted(event);
        }
    }
}
