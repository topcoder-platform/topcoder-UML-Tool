/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.style.styleobject;

import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.StyleObject;

/**
 * <p>
 * This is the abstract style object and implements StyleObject interface.
 * </p>
 *
 * <p>
 * This class is provided for convenient implementation of StyleObject.
 * It's suggested that adapter is extending this class rather than
 * implementing the interface directly.
 * </p>
 *
 * <p>
 * Thread safety: This class is NOT thread safe, since there is
 * mutable field. In this component, it's not a big deal since
 * it will only work in event dispatcher thread.
 * </p>
 *
 * @author enefem21, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractStyleObject implements StyleObject {
    /**
     * <p>
     * The style panel where the style object is attached.
     * </p>
     *
     * <p>
     * It is mutable and may be null.
     * </p>
     */
    private StylePanel stylePanel;

    /**
     * <p>
     * Default constructor.
     * </p>
     *
     * <p>
     * Note, it does nothing in the current implementation.
     * </p>
     */
    protected AbstractStyleObject() {
        // empty
    }

    /**
     * <p>
     * Setter for the style panel.
     * </p>
     *
     * @param stylePanel the style panel, may be null
     */
    public void setStylePanel(StylePanel stylePanel) {
        this.stylePanel = stylePanel;
    }

    /**
     * <p>
     * Getter for the style panel.
     * </p>
     *
     * @return stylePanel the style panel, may be null
     */
    public StylePanel getStylePanel() {
        return this.stylePanel;
    }
}
