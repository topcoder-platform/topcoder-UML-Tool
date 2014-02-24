/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;


/**
 * <p>
 * A <code>TagEvent</code> contains all information when a tag's documentation
 * gets modified.
 * </p>
 *
 * <p>
 * The two required attributes are the <code>modelElement</code> whose tag is
 * being changed, as well as the identification name of the tag. Along with this
 * is stored the previous and current documentation of the tag, possibly null if
 * the tag was created/deleted.
 * </p>
 *
 * <p>
 * <strong>Scenario:</strong>
 *  <ul>
 *   <li>If <code>previous</code> is null or empty, then the documentation of the
 *       tag has just been created.</li>
 *   <li>if <code>current</code> is null or empty, then the documentation of the
 *       tag has just been deleted.</li>
 *   <li>If both are not null/empty, then the documentation of the tag has just
 *       been updated.</li>
 *   <li>If both are null, then nothing has happened, there is no need to fire
 *       a <code>TagEvent</code></li>
 *  </ul>
 * </p>
 *
 * <p>
 *  <strong>Thread Safety:</strong>
 *  This class is thread safe - all state values are immutable after construction,
 *  never changed again and only getter methods are provided.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class TagEvent {
    /**
     * <p>
     * The <code>ModelElement</code> owner of the documentation being modified.
     * This member is set on construction to a non-null value, and immutable.
     * </p>
     *
     * <p>
     * <strong>Accessed by:</strong>
     *  <ul>
     *   <li><code>getModelElement()</code></li>
     *  </ul>
     * </p>
     */
    private final ModelElement modelElement;

    /*
     * BugFix: UML-11417
     * Add this field.
     */
    /**
     * <p>
     * The identifier tagged value object of the tag being modified. This member is set
     * on construction to a non-null value, and immutable.
     * </p>
     *
     * <p>
     * <strong>Accessed by:</strong>
     *  <ul>
     *   <li><code>getTagObject()</code></li>
     *  </ul>
     * </p>
     */
    private final TaggedValue tagObject;

    /**
     * <p>
     * The identifier name of the tag being modified. This member is set
     * on construction to a non-null value, and immutable.
     * </p>
     *
     * <p>
     * <strong>Accessed by:</strong>
     *  <ul>
     *   <li><code>getTagName()</code></li>
     *  </ul>
     * </p>
     */
    private final String tagName;

    /**
     * <p>
     * The previous documentation attached to the tag. This member
     * is set on construction, immutable, and can be null unless the
     * <code>current</code> member is null.
     * </p>
     *
     * <p>
     * <strong>Accessed by:</strong>
     *  <ul>
     *   <li><code>getPreviousDocumentation()</code></li>
     *  </ul>
     * </p>
     */
    private final String previous;

    /**
     * <p>
     * The new modified documentation attached to the tag. This member
     * is set on construction, immutable, and can be null unless the
     * <code>previous</code> member is null.
     * </p>
     *
     * <p>
     * <strong>Accessed by:</strong>
     *  <ul>
     *   <li><code>getCurrentDocumentation()</code></li>
     *  </ul>
     * </p>
     */
    private final String current;

    /*
     * BugFix: UML-11417
     * Add tag object parameter.
     */
/**
 * <p>
 * Constructor which initialize the members of the event.
 * </p>
 *
 * <p>
 * The first two parameters cannot be null, and at most one
 * of the last two can be null/empty(trimmed).
 * </p>
 *
 * @param element Represents the <code>ModelElement</code> whose tag
 *        being modified, cannot be null.
 * @param tagObject Represents the value to use for tagObject, cannot be null.
 * @param name Represents the tag name, cannot be null/empty.
 * @param previous Represents the previous tag documentation, can be null/empty
 *        if <code>current</code> is not.
 * @param current Represents the current tag documentation, can be null/empty if
 *        <code>previous</code> is not.
 *
 * @throws IllegalArgumentException is the either of the first two parameters
 *         is null, or both of the last two are null/empty(trimmed).
 */
    public TagEvent(ModelElement element, TaggedValue tagObject, String name, String previous,
        String current) {
        DocumentPanelHelper.validateNotNull(element, "ModelElement whose tag being modified");
        DocumentPanelHelper.validateString(name, "tag name which being modified");
        DocumentPanelHelper.validatePreDocAndCurrDoc(previous, current);
        this.modelElement = element;
        this.tagObject = tagObject;
        this.tagName = name;
        this.previous = previous;
        this.current = current;
    }

    /**
     * <p>
     * Returns the model element whose documentation is being modified.
     * The returned value will never be null.
     * </p>
     *
     * @return <code>modelElement</code>
     */
    public ModelElement getModelElement() {
        return this.modelElement;
    }

    /*
     * BugFix: UML-11417
     * Add this method.
     */
    /**
     * <p>
     * Returns the TaggedValue object being operated on.
     * The returned value will never be null.
     * </p>
     *
     * @return the tag object
     */
    public TaggedValue getTagObject() {
        return this.tagObject;
    }

    /**
     * <p>
     * Returns the ID name of the tag being modified.
     * The returned value will never be null/empty(trimmed).
     * </p>
     *
     * @return <code>tagName</code>
     */
    public String getTagName() {
        return this.tagName;
    }

    /**
     * <p>
     * Returns the previous documentation attached to the tag,
     * possibly null on tag creation.
     * </p>
     *
     * @return <code>previous</code>
     */
    public String getPreviousDocumentation() {
        return this.previous;
    }

    /**
     * <p>
     * Returns the current documentation attached to the tag,
     * possibly null on tag deletion.
     * </p>
     *
     * @return <code>current</code>
     */
    public String getCurrentDocumentation() {
        return this.current;
    }
}
