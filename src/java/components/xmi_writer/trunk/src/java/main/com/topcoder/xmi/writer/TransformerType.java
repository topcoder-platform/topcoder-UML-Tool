/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer;

/**
 * <p>
 * This enumeration class defines the transformer types supported in this component.
 * </p>
 * <p>
 * Currently 4 types are supported:
 * <ul>
 * <li>Model</li>
 * <li>ActivityGraph</li>
 * <li>Diagram</li>
 * <li>Header</li>
 * </ul>
 * each type corresponds to an <code>{@link XMITransformer}</code> object in the <code>{@link XMIWriter}</code> to
 * transform the corresponding data.
 * </p>
 * <p>
 * <strong>Thread-safety:</strong> enum class is thread-safe.
 * </p>
 *
 * @author Standlove, FireIce
 * @version 1.0
 */
public enum TransformerType {

    /**
     * <p>
     * Represents the model transformer type.
     * </p>
     */
    Model,

    /**
     * <p>
     * Represents the activity graph transformer type.
     * </p>
     */
    ActivityGraph,

    /**
     * <p>
     * Represents the diagram transformer type.
     * </p>
     */
    Diagram,

    /**
     * <p>
     * Represents the header transformer type.
     * </p>
     */
    Header
}
