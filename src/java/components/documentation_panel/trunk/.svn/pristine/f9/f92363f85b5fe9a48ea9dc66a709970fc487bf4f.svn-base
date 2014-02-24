/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

import com.topcoder.gui.panels.documentation.DocumentPanelHelper;
import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * A <code>DocumentationEvent</code> contains all information when a
 * <code>ModelElement</code>'s documentation gets modified.
 * </p>
 *
 * <p>
 * It has a required attribute, the <code>modelElement</code> whose
 * documentation is being changed. Along with this is stored the
 * previous and current documentation, possibly null if the documentation
 * was created/deleted.
 * </p>
 *
 * <p>
 * <strong>Scenario:</strong>
 *  <ul>
 *   <li>If <code>previous</code> is null or empty, then the documentation has
 *       just been created.</li>
 *   <li>if <code>current</code> is null or empty, then the documentation has
 *       just been deleted.</li>
 *   <li>If both are not null/empty, then the documentation has just been updated.</li>
 *   <li>If both are null, then nothing has happened, there is no need to fire
 *       a <code>DocumentationEvent</code></li>
 *  </ul>
 * </p>
 *
 * <p>
 *  <strong>Thread Safety:</strong>
 *  This class is thread safe - all state values are immutable after construction
 *  , never changed again and only getter methods are provided.
 * </p>
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public class DocumentationEvent {
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

    /**
     * <p>
     * The previous documentation attached to the element. This member
     * is set on construction, immutable, and can be null/empty(trimmed)
     * unless the <code>current</code> member is null/empty(trimmed).
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
     * The new modified documentation attached to the element. This
     * member is set on construction, immutable, and can be null/empty(trimmed)
     * unless the <code>previous</code> member is null/empty(trimmed).
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

/**
 * <p>
 * Constructor which initialize the members of the event.
 * </p>
 *
 * <p>
 * The first parameter cannot be null, and at most one of
 * the last two can be null/empty(trimmed).
 * </p>
 *
 * @param element Represents the <code>ModelElement</code> whose documentation
 *        being modified, cannot be null.
 * @param previous Represents the previous documentation attached to the
 *        <code>ModelElement</code>, can be null/empty(trimmed) if
 *        <code>current</code> is not.
 * @param current Represents the previous documentation attached to the
 *        <code>ModelElement</code>, can be null/empty(trimmed) if
 *        <code>previous</code> is not.
 *
 * @throws IllegalArgumentException is the first parameter is null, or both of
 *         the last two are null/empty(trimmed)
 */
    public DocumentationEvent(ModelElement element, String previous,
        String current) {
        DocumentPanelHelper.validateNotNull(element, "ModelElement whose documentation being modified");
        DocumentPanelHelper.validatePreDocAndCurrDoc(previous, current);
        this.modelElement = element;
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

    /**
     * <p>
     * Returns the previous documentation attached to the element,
     * possibly null on documentation creation.
     * </p>
     *
     * @return <code>previous</code>
     */
    public String getPreviousDocumentation() {
        return this.previous;
    }

    /**
     * <p>
     * Returns the current documentation attached to the element,
     * possibly null on documentation deletion.
     * </p>
     *
     * @return <code>current</code>
     */
    public String getCurrentDocumentation() {
        return this.current;
    }
}
