/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.event;

/**
 * <p>
 * Interface defining the three methods that a documentation listener
 * should listen for. Corresponding to documentation
 *  <ul>
 *   <li>creation</li>
 *   <li>update</li>
 *   <li>deletion</li>
 *  </ul>
 * Each takes a single <code>DocumentationEvent</code> parameter describing
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
public interface DocumentationListener {
    /**
     * <p>
     * Listener method called whenever the panel creates initial
     * documentation for an element.
     * </p>
     *
     * @param event Event containing the element, and its new documentation.
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void documentationCreated(DocumentationEvent event);

    /**
     * <p>
     * Listener method called whenever the panel modifies the
     * documentation for an element.
     * </p>
     *
     * @param event Event containing the element, and its previous and new
     *        documentation.
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void documentationUpdated(DocumentationEvent event);

    /**
     * <p>
     * Listener method called whenever the panel deletes documentation
     * for an element.
     * </p>
     *
     * @param event Event containing the element, and its previous
     *        documentation.
     *
     * @throws IllegalArgumentException if the event is null
     */
    public void documentationDeleted(DocumentationEvent event);
}
