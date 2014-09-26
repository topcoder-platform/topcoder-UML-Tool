/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.datatypes.expressions;

/**
 * <p>
 * This interface extends Expression interface. In the metamodel, BooleanExpression defines a
 * statement that will evaluate to an instance of Boolean when it is evaluated.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.
 * </p>
 *
 * @author argolite, Achilles_2005
 * @version 1.0
 */
public interface BooleanExpression extends Expression {
}
