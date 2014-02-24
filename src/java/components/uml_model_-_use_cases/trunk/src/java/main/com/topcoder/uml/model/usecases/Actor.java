/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import java.util.Collection;

import com.topcoder.uml.model.core.Classifier;

/**
 * <p>
 * This interface represents an Actor in the UML Modeling tool.
 * </p>
 *
 * <p>
 * Aside from extending the Classifier interface, there is an additional method, getUseCases,
 * which traverses the various relationships attached to the Classifier that this interface
 * extends, to find the UseCases that this Actor can invoke.
 * </p>
 *
 * <p>
 * Thread Safety - Implementations of this interface is not be required to be thread-safe, since thread
 * safety should be handled by the application itself.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public interface Actor extends Classifier {
    /**
     * <p>
     * Return a collection of the UseCases that this Actor can invoke.
     * </p>
     *
     * @return a collection of the UseCases that this Actor can invoke
     */
    public Collection<UseCase> getUseCases();
}
