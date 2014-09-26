/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.modelmanagement;

/**
 * <p>
 * This interface extends Package interface. A model captures a view of a
 * physical system. It is an abstraction of the physical system, with a certain
 * purpose. This purpose determines what is to be included in the model and what
 * is irrelevant. Thus the model completely describes those aspects of the
 * physical system that are relevant to the purpose of the model, at the
 * appropriate level of detail.
 * </p>
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * Implementations do not have to be thread-safe. In fact, method
 * synchronization is discouraged. Thread safety will be provided by the
 * application using these implementations.
 * </p>
 * @author argolite, vilain
 * @version 1.0
 */
public interface Model extends Package {
}