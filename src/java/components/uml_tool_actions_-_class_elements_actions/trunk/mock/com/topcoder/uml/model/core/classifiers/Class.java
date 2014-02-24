/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.Classifier;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Class extends Classifier {

    /**
     * Mock method.
     *
     * @return
     */
    public boolean isActive();

    /**
     * Mock method.
     *
     * @param active
     */
    public void setActive(boolean active);
}