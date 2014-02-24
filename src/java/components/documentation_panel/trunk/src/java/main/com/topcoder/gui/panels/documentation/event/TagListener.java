/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

/**
 * <p>
 * Interface defining the three methods that a tag listener should
 * listen for. Corresponding to tag
 *  <ul>
 *   <li>creation</li>
 *   <li>update</li>
 *   <li>deletion</li>
 *  </ul>
 * Each takes a single <code>TagEvent</code> parameter describing
 * the properties of the event that was fired.
 * </p>
 *
 * <p>
 *  <strong>Thread Safety:</strong>
 *  Implementations are to handle their own thread safety if it is required.
 * </p>
 *
 * @author sql_lall, liuliquan
 * @version 1.0
 */
public interface TagListener {
    /**
     * <p>
     * Listener method called whenever the panel creates a new tag to
     * be attached to the element.
     * </p>
     *
     * @param event Event containing the element, tag name, and its new
     *        documentation.
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void tagCreated(TagEvent event);

    /**
     * <p>
     * Listener method called whenever the panel modifies the
     * documentation for a tag attached to the element.
     * </p>
     *
     * @param event Event containing the element, tag name, and its previous
     *        and new documentation.
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void tagUpdated(TagEvent event);

    /**
     * <p>
     * Listener method called whenever the panel removes a tag, to be
     * removed from the element.
     * </p>
     *
     * @param event Event containing the element, tag name, and its previous
     *        documentation.
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void tagDeleted(TagEvent event);
}
