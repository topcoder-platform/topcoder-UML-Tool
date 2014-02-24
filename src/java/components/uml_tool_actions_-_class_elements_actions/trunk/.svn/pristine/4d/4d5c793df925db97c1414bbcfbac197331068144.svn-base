/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies;

import com.topcoder.uml.model.datatypes.expressions.MappingExpression;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AbstractionImpl extends DependencyImpl implements Abstraction {

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public AbstractionImpl() {
    }

    /**
     * <p>
     * Represents A MappingExpression that states the abstraction relationship
     * between the supplier and the client. In some cases, such as Derivation,
     * it is usually formal and unidirectional; in other cases, such as Trace,
     * it is usually informal and bidirectional. The mapping attribute is
     * optional and may be omitted if the precise relationship between the
     * elements is not specified.
     * </p>
     */
    private MappingExpression mapping;

    /**
     * Gets the MappingExpression mapping field value. Could be null.
     *
     * @return mapping field value
     */
    public MappingExpression getMapping() {
        return this.mapping;
    }

    /**
     * Sets the MappingExpression mapping field value. Null is allowed.
     *
     * @param mapping
     *            mapping field value
     */
    public void setMapping(MappingExpression mapping) {
        this.mapping = mapping;
    }
}