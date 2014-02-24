/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;

/**
 * <p>
 * This concrete class implements the Actor interface.
 * </p>
 *
 * <p>
 * Aside from extending the ClassifierAbstractImpl class, there is an additional method, getUseCases,
 * which traverses the various relationships attached to the Classifier that this interface extends,
 * to find the UseCases that this Actor can invoke.
 * </p>
 *
 * <p>
 * This class is required to be not thread-safe, since thread safety is required to be handled
 * by the application itself.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
public class ActorImpl extends ClassifierAbstractImpl implements Actor {
    /**
     * <p>
     * Default constructor. Does nothing.
     * </p>
     */
    public ActorImpl() {
        // empty
    }

    /**
     * <p>
     * Return a collection of the UseCases that this Actor can invoke.
     * </p>
     *
     * @return a collection of the UseCases that this Actor can invoke
     */
    public Collection<UseCase> getUseCases() {
        Collection<Classifier> classfiers = UseCaseUtil.findAssociatedEnd(this, UseCase.class);

        // convert the Classifier collction to its UseCase collection, cast operation is used
        Collection<UseCase> useCases = new ArrayList<UseCase>();
        for (Classifier classfier : classfiers) {
            useCases.add((UseCase) classfier);
        }
        return useCases;
    }
}
