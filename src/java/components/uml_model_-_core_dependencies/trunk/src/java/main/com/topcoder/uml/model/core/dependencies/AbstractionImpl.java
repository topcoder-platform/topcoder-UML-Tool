/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ AbstractionImpl.java
 */
package com.topcoder.uml.model.core.dependencies;

import com.topcoder.uml.model.datatypes.expressions.MappingExpression;

/**
 * <p>This is a simple concrete implementation of Abstraction interface and extends DependencyImpl.
 * As such, all methods in Abstraction are supported</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public class AbstractionImpl extends DependencyImpl implements Abstraction {
    /**
     * <p>Represents A MappingExpression that states the abstraction relationship between the supplier
     * and the client. In some cases, such as Derivation, it is usually formal and unidirectional; in
     * other cases, such as Trace, it is usually informal and bidirectional. The mapping attribute is
     * optional and may be omitted if the precise relationship between the elements is not specified.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     */
    private MappingExpression mapping = null;

    /**
     * <p>Empty constructor.</p>
     */
    public  AbstractionImpl() {
    }

    /**
     * Gets the MappingExpression mapping field value. Could be null.
     *
     * @return mapping field value
     */
    public MappingExpression getMapping() {
        return mapping;
    }

    /**
     * Sets the MappingExpression mapping field value. Null is allowed.
     *
     * @param mapping mapping field value
     */
    public void setMapping(MappingExpression mapping) {
        this.mapping = mapping;
    }
}
