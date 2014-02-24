/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document;

/**
 * <p>
 * This class is an enum that enumerates the different possible types of document tree views.
 * </p>
 *
 * <p>
 * Currently <b>diagram_centric</b>, <b>package_centric</b> and <b>class_centric</b> types are enumerated.
 * </p>
 *
 * <p>
 * Thread Safety: This class is thread safe as it has no state.
 * </p>
 *
 * @author humblefool, biotrail
 * @version 1.0
 */
public enum DocumentTreeViewType {
    /**
     * <p>
     * This enum instance represents a view type of <b>diagram_centric</b>.
     * </p>
     */
    DIAGRAM_CENTRIC,

    /**
     * <p>
     * This enum instance represents a view type of <b>package_centric</b>.
     * </p>
     */
    PACKAGE_CENTRIC,

    /**
     * <p>
     * This enum instance represents a view type of <b>class_centric</b>.
     * </p>
     */
    CLASS_CENTRIC
}
