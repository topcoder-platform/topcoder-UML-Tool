/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ Abstraction.java
 */
package com.topcoder.uml.model.core.dependencies;

import com.topcoder.uml.model.datatypes.expressions.MappingExpression;

/**
 * <p>This interface extends Dependency interface. An abstraction is a Dependency relationship that
 * relates two elements or sets of elements that represent the same concept at different levels of
 * abstraction or from different viewpoints. In the metamodel, an Abstraction is a Dependency in which
 * there is a mapping between the supplier and the client. Depending on the specific stereotype of
 * Abstraction, the mapping may be formal or informal, and it may be unidirectional or bidirectional.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 *
 * @author argolite, yinzi
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
     * @param mapping mapping field value
     */
    public void setMapping(MappingExpression mapping);
}


