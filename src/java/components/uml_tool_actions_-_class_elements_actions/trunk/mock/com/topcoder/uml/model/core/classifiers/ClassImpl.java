package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class ClassImpl extends ClassifierAbstractImpl implements com.topcoder.uml.model.core.classifiers.Class {

    /**
     * Mock attribute.
     */
    private boolean active;

    /**
     * Gets the boolean active field value.
     *
     * @return active field value
     */
    public boolean isActive() {
        return this.active;
    }

    /**
     * Sets the boolean active field value.
     *
     * @param active
     *            active field value
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public int countBehaviors() {
        return 0;
    }
}