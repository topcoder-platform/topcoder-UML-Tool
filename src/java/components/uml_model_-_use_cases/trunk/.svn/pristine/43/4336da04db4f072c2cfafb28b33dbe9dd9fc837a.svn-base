/**
 * Copyright (C) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.model.usecases.stresstests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.uml.model.usecases.UseCaseImpl;

/**
 * <p>This test case aggregates all Stress test cases.</p>
 *
 * @author mgmg
 * @version 1.0
 */
public class StressTests extends TestCase {
	/**
     * Aggregate all stress test cases.
	 */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        
        suite.addTestSuite(StressTests.class);
        
        return suite;
    }
    
    /**
     * Stress test for UseCaseUtil.findAssociatedEnd.
     */
    public void testUserCaseUtil() {
    	Actor actor = new ActorImpl();

        for (int i = 0; i < 1000; i++) {
	    	AssociationEnd actorEnd = new AssociationEndImpl();
    		UseCase useCase = new UseCaseImpl();
    		AssociationEnd useCaseEnd = new AssociationEndImpl();
	    	Association assoc = new AssociationImpl();
    	
    	    actorEnd.setParticipant(actor);
        	useCaseEnd.setParticipant(useCase);
	        actor.addAssociation(actorEnd);
    	    useCase.addAssociation(useCaseEnd);
        	assoc.addConnection(useCaseEnd);
	        assoc.addConnection(actorEnd);
    	    actorEnd.setAssociation(assoc);
        	useCaseEnd.setAssociation(assoc);
        }
        
        StressTestHelper.startTimer();
        
        for (int i = 0; i < 1000; i++) {
        	actor.getUseCases().size();
        }
        
        StressTestHelper.printTime("ActorImpl.getUserCases", 1000);
    }
}
