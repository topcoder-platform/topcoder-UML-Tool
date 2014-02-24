/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

/**
 * <p>
 * Unit Test Helper class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * private constructor.
     * </p>
     */
    private TestHelper() {
        // empty
    }

    /**
     * <p>
     * Set up the connection between the given Actor and UseCase instances.
     * </p>
     *
     * @param actor The Actor instance
     * @param useCase The UseCase instance
     */
    public static void setupConnection(Actor actor, UseCase useCase) {
        AssociationEnd actorEnd = new AssociationEndImpl();
        actorEnd.setParticipant(actor);
        actor.addAssociation(actorEnd);

        AssociationEnd useCaseEnd = new AssociationEndImpl();
        useCaseEnd.setParticipant(useCase);
        useCase.addAssociation(useCaseEnd);

        Association assoc = new AssociationImpl();
        assoc.addConnection(actorEnd);
        assoc.addConnection(useCaseEnd);
        actorEnd.setAssociation(assoc);
        useCaseEnd.setAssociation(assoc);

        return;
    }
}
