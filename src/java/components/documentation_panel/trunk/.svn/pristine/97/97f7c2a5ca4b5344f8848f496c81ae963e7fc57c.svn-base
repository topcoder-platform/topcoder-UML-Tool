/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import com.topcoder.gui.panels.documentation.event.TagEvent;
import com.topcoder.gui.panels.documentation.event.TagListener;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;


/**
 * <p>
 *  <strong>Usage:</strong>
 *  <br/>
 *  A <code>TagEditor</code> is a <code>JPanel</code> which gives the user
 *  the ability to modify the tag's [name,documentation] pairs that are attached
 *  to a <code>ModelElement</code> within a UML model.
 * </p>
 *
 * <p>
 *  <strong>Definition:</strong>
 *  <br/>
 *  This abstract superclass defines all methods required for an editor of
 *  tags that is to be used within a <code>DocumentationPanel</code>. It also
 *  stores the target element, and manages all listener classes that are waiting
 *  for notifications of when element tags are edited.
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
 *  subclasses, should not actually modify the documentation of their target
 *  element's tags in any way, only firing events when the user wants changes.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public abstract class TagEditor extends JPanel {
    /**
     * List of tag listeners attached to this object. This is initially
     * an empty ArrayList TagListener , its contents can be added and removed
     * and obtained via the xxxTagListener methods. Its contents will never be
     * null, and the list instance does not change after creation.
     */
    private final List < TagListener > listeners = new ArrayList < TagListener >();

    /**
     * The element whose documentation is being managed. This is
     * modified through calling setTarget to any non-null ModelElement, and is
     * added to the events when they are fired to listeners.
     */
    private ModelElement target;

/**
 * <p>
 * Default, no-arg constructor, nothing happens within the body of this method.
 * </p>
 */
    protected TagEditor() {
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
     * sets the <code>target</code> member to the given (non-null)
     * <code>ModelElement</code>.
     * </p>
     *
     * @param element The new <code>ModelElement</code> to use
     *
     * @throws IllegalArgumentException if the parameter is null
     * @throws UnknownElementTypeException may be thrown by subclasses by this
     *         method
     */
    public void setTarget(ModelElement element) throws UnknownElementTypeException {
        DocumentPanelHelper.validateNotNull(element, "ModelElement whose tag to be managed");
        this.target = element;
    }

    /**
     * <p>
     * Adds a <code>TagListener</code> to the list of classes listening
     * for tag edits.
     * </p>
     *
     * <p>
     * The parameter cannot be null, but may be a duplicate of a
     * listener already added.
     * </p>
     *
     * @param listener listener to attach to the object, cannot be null.
     *
     * @throws IllegalArgumentException if the parameter is null
     */
    public void addTagListener(TagListener listener) {
        DocumentPanelHelper.validateNotNull(listener, "TagListener to be attached");
        this.listeners.add(listener);
    }

    /**
     * <p>
     * Removes a listener from the list of attached objects.
     * This removes the first matching instance from the list.
     * </p>
     *
     * <p>
     * If the parameter is null or not in the list, then nothing
     * happens, and no exception is thrown.
     * </p>
     *
     * @param listener listener to detach to the object, can be null
     */
    public void removeTagListener(TagListener listener) {
        if (listener == null || !this.listeners.contains(listener)) {
            return;
        }
        this.listeners.remove(listener);
    }

    /**
     * <p>
     * Returns a shallow copy of the list of all listeners currently
     * listening to tag edits by this editor.
     * </p>
     *
     * <p>
     * Never returns null, but may be an empty list.
     * </p>
     *
     * @return A shallow copy of all attached listeners
     */
    public List < TagListener > getTagListeners() {
        return new ArrayList < TagListener >(this.listeners);
    }

    /*
     * BugFix: UML-11417
     * Add the tag object parameter.
     */
    /**
     * <p>
     * Notify all listeners that a tag, with documentation, is ready to
     * be added to the target.
     * </p>
     *
     * <p>
     * <code>tagCreated()</code> is fired on each attached listener with
     * a passed in <code>TagEvent</code>.
     * </p>
     *
     * @param tagObject The object to be created
     * @param tagName The identifying name of the type of tag
     * @param current The new documentation to be attached on the tag
     *
     * @throws IllegalArgumentException if either parameter is empty(trimmed) or null
     */
    public void fireTagCreated(TaggedValue tagObject, String tagName, String current) {
        DocumentPanelHelper.validateNotNull(tagObject, "Tag object to be created");
        DocumentPanelHelper.validateString(tagName, "Tag name being created");
        DocumentPanelHelper.validateString(current, "Current tag documentation being created");
        TagEvent event = new TagEvent(this.target, tagObject, tagName, null, current);
        for (TagListener listener : this.listeners) {
            listener.tagCreated(event);
        }
    }

    /*
     * BugFix: UML-11417
     * Add the tag object parameter.
     */
    /**
     * <p>
     * Notify all listeners that documentation attached to a tag in the
     * element is ready to be modified.
     * </p>
     *
     * <p>
     * <code>tagUpdated()</code> is fired on each attached listener with
     * a passed in <code>TagEvent</code>.
     * </p>
     *
     * @param tagObject The object to be updated
     * @param tagName The identifying name of the type of tag
     * @param previous The previous documentation on the tag
     * @param current The new documentation to be attached on the tag
     *
     * @throws IllegalArgumentException if any parameter is empty(trimmed) or null
     */
    public void fireTagUpdated(TaggedValue tagObject, String tagName, String previous,
        String current) {
        DocumentPanelHelper.validateNotNull(tagObject, "Tag object to be updated");
        DocumentPanelHelper.validateString(tagName, "Tag name being updated");
        DocumentPanelHelper.validateString(previous, "Previous tag documentation being updated");
        DocumentPanelHelper.validateString(current, "Current tag documentation being updated");
        TagEvent event = new TagEvent(this.target, tagObject, tagName, previous, current);
        for (TagListener listener : this.listeners) {
            listener.tagUpdated(event);
        }
    }

    /*
     * BugFix: UML-11417
     * Add the tag object parameter.
     */
    /**
     * <p>
     * Notify all listeners that a tag and its documentation is ready
     * for removal from the element.
     * </p>
     *
     * <p>
     * <code>tagDeleted()</code> is fired on each attached listener with
     * a passed in <code>TagEvent</code>.
     * </p>
     *
     * @param tagObject The object to be deleted
     * @param tagName The identifying name of the type of tag
     * @param previous The previous documentation on the tag
     *
     * @throws IllegalArgumentException if either parameter is empty(trimmed) or null
     */
    public void fireTagDeleted(TaggedValue tagObject, String tagName, String previous) {
        DocumentPanelHelper.validateNotNull(tagObject, "Tag object to be deleted");
        DocumentPanelHelper.validateString(tagName, "Tag name being deleted");
        DocumentPanelHelper.validateString(previous, "Previous tag documentation being deleted");
        TagEvent event = new TagEvent(this.target, tagObject, tagName, previous, null);
        for (TagListener listener : this.listeners) {
            listener.tagDeleted(event);
        }
    }
}
