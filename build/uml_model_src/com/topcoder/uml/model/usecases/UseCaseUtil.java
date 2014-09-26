/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.AssociationEnd;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This utility class provides the ¡°findAssociatedEnd¡± method used by both the ActorImpl
 * and UseCaseImpl classes. They use this to find their corresponding ¡±associated end¡±
 * (Actor can find UseCases and UseCase can find Actors.)
 * </p>
 *
 * <p>
 * This class is package-private since its only method is
 * only used internally by the ActorImpl and UseCaseImpl classes.
 * </p>
 *
 * <p>
 * Thread Safety - This class is thread-safe since there are no instance variables in the class.
 * </p>
 *
 * @author dplass, TCSDEVELOPER
 * @version 1.0
 */
class UseCaseUtil {
    /**
     * <p>
     * Hide the default constructor of this utility class.
     * </p>
     */
    private UseCaseUtil() {
        // empty
    }

    /**
     * <p>
     * Finds the "other side" of the association ends attached to the given classifier,
     * which have the given type.
     * </p>
     *
     * <p>
     * For example, for Actors, these are UseCases, and vice versa.
     * </p>
     *
     * @return a Collection of Classification objects of the given endType which are on the other
     * side of the associations with the source Classifier
     * @param source the source of the association
     * @param endType the type of the Classifier on the other side of the association
     * (the other participant in the association)
     * @throws IllegalArgumentException if either parameter is null or if endType is not a sub-interface
     * of Classifier
     */
    public static final Collection<Classifier> findAssociatedEnd(Classifier source, Class endType) {
        if (source == null) {
            throw new IllegalArgumentException("source is null.");
        }
        if (endType == null) {
            throw new IllegalArgumentException("endType is null.");
        }
        if (!Classifier.class.isAssignableFrom(endType)) {
            throw new IllegalArgumentException("endType is not a sub-interface of Classifier, its type is " + endType.getName());
        }

        // This collection is used to record all the associated ends
        Collection<Classifier> classifiers = new ArrayList<Classifier>();

        Collection<AssociationEnd> inputEnds = source.getAssociations();
        for (AssociationEnd e : inputEnds) {
            // note, connections is a collection of type AssociationEnd
            Collection<AssociationEnd> connections = e.getAssociation().getConnections();

            for (AssociationEnd end : connections) {
                // Get the Participant instance
                Classifier p = end.getParticipant();

                // the other participant in the association should be of endType type or its sub-type.
                if (endType.isAssignableFrom(p.getClass())) {
                    classifiers.add(p);
                }
            }
        }

        return classifiers;
    }
}
