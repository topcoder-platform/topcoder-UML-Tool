/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies;

import com.topcoder.uml.model.datatypes.expressions.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Abstraction extends Dependency {
    /**
     * Gets the MappingExpression mapping field value. Could be null.
     *
     * @return mapping field value
     */
    public MappingExpression getMapping();

    /**
     * Sets the MappingExpression mapping field value. Null is allowed.
     *
     * @param mapping
     *            mapping field value
     */
    public void setMapping(MappingExpression mapping);
}