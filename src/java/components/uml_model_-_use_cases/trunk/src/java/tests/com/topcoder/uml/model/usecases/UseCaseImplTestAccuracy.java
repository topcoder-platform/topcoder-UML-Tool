/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.usecases.accuracytests.MockClassifierImplAccuracy;
import junit.framework.TestCase;

import java.util.Collection;
import java.util.Iterator;


/**
 * Test class for UseCaseImpl.
 * @author radium
 * @version 1.0
 */
public class UseCaseImplTestAccuracy extends TestCase {
    /**
     * Sample Actor for testing.
     */
    private Actor actor = new ActorImpl();
    /**
     * Sample AssociationEnd for testing.
     */
    private AssociationEnd actorEnd = new AssociationEndImpl();

    /**
     * Sample AssociationEnd for testing.
     */
    private AssociationEnd useCaseEnd = new AssociationEndImpl();

    /**
     * Sample Association for testing.
     */
    private Association association = new AssociationImpl();

    /**
     * Sample UseCaseImpl for testing.
     */
    private UseCaseImpl ucl;
    /**
     * Sample Include for testing.
     */
    private Include include;
    /**
     * Sample Extend for testing.
     */
    private Extend extend;
    /**
     * Sample Includer for testing.
     */
    private Include includer;
    /**
     * Sample Extender for testing.
     */
    private Extend extender;
    /**
     * Sample UseCase for testing.
     */
    private UseCase useCase;
    /**
     * Sample Classifier for testing.
     */
    private Classifier classifier;
    /**
     * Setup the environment for testing.
     */
    protected void setUp() throws Exception {
        ucl = new UseCaseImpl();
        include = new IncludeImpl();
        extend = new ExtendImpl();
        includer = new IncludeImpl();
        extender = new ExtendImpl();
        useCase = new UseCaseImpl();
        classifier = new MockClassifierImplAccuracy();
    }

    /**
     * Test method for UseCaseImpl().
     */
    public void testUseCaseImpl() {
        ucl = new UseCaseImpl();
        assertNotNull("Should not be null.", ucl);
    }

    /**
     * Test method for addInclude(Include).
     */
    public void testAddInclude() {
        include.setBase(ucl);
        ucl.addInclude(include);
        ucl.addInclude(include);
        Collection <Include> res = ucl.getIncludes();
        assertEquals("Should be equal.", 2, res.size());
        Iterator<Include> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", include, iter.next());
        }
    }

    /**
     * Test method for removeInclude(Include).
     */
    public void testRemoveInclude() {
        assertFalse("Should be false.", ucl.removeInclude(include));
        include.setBase(ucl);
        ucl.addInclude(include);
        ucl.addInclude(include);
        assertTrue("Should be true.", ucl.removeInclude(include));

        Collection <Include> res = ucl.getIncludes();
        assertEquals("Should be equal.", 1, res.size());
        Iterator<Include> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", include, iter.next());
        }
    }

    /**
     * Test method for clearIncludes().
     */
    public void testClearIncludes() {
        include.setBase(ucl);
        ucl.addInclude(include);
        ucl.addInclude(include);
        ucl.clearIncludes();
        Collection <Include> res = ucl.getIncludes();
        assertEquals("Should be equal.", 0, res.size());
    }


    /**
     * Test method for containsInclude(Include).
     */
    public void testContainsIncludeInclude() {
        assertFalse("Should be false.", ucl.containsInclude(include));
        include.setBase(ucl);
        ucl.addInclude(include);
        assertTrue("Should be true.", ucl.containsInclude(include));
    }

    /**
     * Test method for containsInclude(UseCase).
     */
    public void testContainsIncludeUseCase() {
        include.setBase(ucl);
        ucl.addInclude(include);
        assertFalse("Should be false.", ucl.containsInclude(useCase));

        include.setAddition(useCase);
        assertTrue("Should be true.", ucl.containsInclude(useCase));
    }

    /**
     * Test method for countIncludes().
     */
    public void testCountIncludes() {
        assertEquals("Should be equal.", 0, ucl.countIncludes());
        include.setBase(ucl);
        ucl.addInclude(include);
        ucl.addInclude(include);

        assertEquals("Should be equal.", 2, ucl.countIncludes());
    }

    /**
     * Test method for getIncludedUseCases().
     */
    public void testGetIncludedUseCases() {
        assertEquals("Should be equal.", 0, ucl.getIncludedUseCases().size());

        include.setBase(ucl);
        include.setAddition(useCase);

        ucl.addInclude(include);
        ucl.addInclude(include);

        Collection <UseCase> res = ucl.getIncludedUseCases();
        assertEquals("Should be equal.", 2, res.size());
        Iterator<UseCase> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", useCase, iter.next());
        }

    }

    /**
     * Test method for addIncluder(Include).
     */
    public void testAddIncluder() {
        includer.setAddition(ucl);
        ucl.addIncluder(includer);
        ucl.addIncluder(includer);
        Collection <Include> res = ucl.getIncluders();
        assertEquals("Should be equal.", 2, res.size());
        Iterator<Include> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", includer, iter.next());
        }
    }

    /**
     * Test method for removeIncluder(Include).
     */
    public void testRemoveIncluder() {
        assertFalse("Should be false.", ucl.removeIncluder(includer));
        includer.setAddition(ucl);
        ucl.addIncluder(includer);
        ucl.addIncluder(includer);
        assertTrue("Should be true.", ucl.removeIncluder(includer));

        Collection <Include> res = ucl.getIncluders();
        assertEquals("Should be equal.", 1, res.size());
        Iterator<Include> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", includer, iter.next());
        }
    }

    /**
     * Test method for clearIncluders().
     */
    public void testClearIncluders() {
        includer.setAddition(ucl);
        ucl.addIncluder(includer);
        ucl.addIncluder(includer);
        ucl.clearIncluders();
        Collection <Include> res = ucl.getIncluders();
        assertEquals("Should be equal.", 0, res.size());
    }


    /**
     * Test method for containsIncluder(Include).
     */
    public void testContainsIncluderInclude() {
        assertFalse("Should be false.", ucl.containsIncluder(includer));
        includer.setAddition(ucl);
        ucl.addIncluder(includer);
        assertTrue("Should be true.", ucl.containsIncluder(includer));
    }

    /**
     * Test method for containsIncluder(UseCase).
     */
    public void testContainsIncluderUseCase() {
        includer.setAddition(ucl);
        includer.setAddition(ucl);
        ucl.addIncluder(includer);
        assertFalse("Should be false.", ucl.containsIncluder(useCase));

        includer.setBase(useCase);
        assertTrue("Should be true.", ucl.containsIncluder(useCase));
    }

    /**
     * Test method for countIncluders().
     */
    public void testCountIncluders() {
        assertEquals("Should be equal.", 0, ucl.countIncluders());
        includer.setAddition(ucl);
        ucl.addIncluder(includer);
        ucl.addIncluder(includer);

        assertEquals("Should be equal.", 2, ucl.countIncluders());
    }

    /**
     * Test method for getIncludingUseCases(),
     */
    public void testGetIncludingUseCases() {
        assertEquals("Should be equal.", 0, ucl.getIncludingUseCases().size());

        includer.setBase(useCase);
        includer.setAddition(ucl);
        ucl.addIncluder(includer);
        ucl.addIncluder(includer);

        Collection <UseCase> res = ucl.getIncludingUseCases();
        assertEquals("Should be equal.", 2, res.size());
        Iterator<UseCase> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", useCase, iter.next());
        }
    }

    /**
     * Test method for addExtend(Extend).
     */
    public void testAddExtend() {
        extend.setExtension(ucl);
        ucl.addExtend(extend);
        ucl.addExtend(extend);
        Collection <Extend> res = ucl.getExtends();
        assertEquals("Should be equal.", 2, res.size());
        Iterator<Extend> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", extend, iter.next());
        }
    }

    /**
     * Test method for removeExtend(Extend).
     */
    public void testRemoveExtend() {
        assertFalse("Should be false.", ucl.removeExtend(extend));
        extend.setExtension(ucl);
        ucl.addExtend(extend);
        ucl.addExtend(extend);
        assertTrue("Should be true.", ucl.removeExtend(extend));

        Collection <Extend> res = ucl.getExtends();
        assertEquals("Should be equal.", 1, res.size());
        Iterator<Extend> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", extend, iter.next());
        }
    }

    /**
     * Test method for clearExtends().
     */
    public void testClearExtends() {
        extend.setExtension(ucl);
        ucl.addExtend(extend);
        ucl.addExtend(extend);
        ucl.clearExtends();
        Collection <Extend> res = ucl.getExtends();
        assertEquals("Should be equal.", 0, res.size());
    }

    /**
     * Test method for containsExtend(Extend).
     */
    public void testContainsExtend() {
        assertFalse("Should be false.", ucl.containsExtend(extend));

        extend.setExtension(ucl);
        ucl.addExtend(extend);
        assertTrue("Should be true.", ucl.containsExtend(extend));
    }

    /**
     * Test method for containsExtends(UseCase).
     */
    public void testContainsExtends() {
        extend.setExtension(ucl);
        ucl.addExtend(extend);
        assertFalse("Should be false.", ucl.containsExtend(useCase));

        extend.setBase(useCase);
        assertTrue("Should be true.", ucl.containsExtend(useCase));
    }

    /**
     * Test method for countExtends().
     */
    public void testCountExtends() {
        assertEquals("Should be equal.", 0, ucl.countExtends());
        extend.setExtension(ucl);
        ucl.addExtend(extend);
        ucl.addExtend(extend);

        assertEquals("Should be equal.", 2, ucl.countExtends());
    }

    /**
     * Test method for getBaseUseCases().
     */
    public void testGetBaseUseCases() {
        extend.setBase(useCase);
        extend.setExtension(ucl);
        ucl.addExtend(extend);
        ucl.addExtend(extend);
        Collection <UseCase> res = ucl.getBaseUseCases();
        assertEquals("Should be equal.", 2, res.size());
        Iterator <UseCase> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be true.", useCase, iter.next());
        }
    }

    /**
     * Test method for addExtender(Extend).
     */
    public void testAddExtender() {
        extender.setBase(ucl);
        ucl.addExtender(extender);
        ucl.addExtender(extender);
        Collection <Extend> res = ucl.getExtenders();
        assertEquals("Should be equal.", 2, res.size());
        Iterator<Extend> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", extender, iter.next());
        }
    }

    /**
     * Test method for removeExtender(Extend).
     */
    public void testRemoveExtender() {
        assertFalse("Should be false.", ucl.removeExtender(extender));
        extender.setBase(ucl);
        ucl.addExtender(extender);
        ucl.addExtender(extender);
        assertTrue("Should be true.", ucl.removeExtender(extender));

        Collection <Extend> res = ucl.getExtenders();
        assertEquals("Should be equal.", 1, res.size());
        Iterator<Extend> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", extender, iter.next());
        }
    }

    /**
     * Test method for clearExtenders().
     */
    public void testClearExtenders() {
        extender.setBase(ucl);
        ucl.addExtender(extender);
        ucl.addExtender(extender);
        ucl.clearExtenders();
        Collection <Extend> res = ucl.getExtenders();
        assertEquals("Should be equal.", 0, res.size());
    }


    /**
     * Test method for containsExtender(Extend).
     */
    public void testContainsExtenderExtend() {
        assertFalse("Should be false.", ucl.containsExtend(extender));

        extender.setBase(ucl);
        ucl.addExtender(extender);
        assertTrue("Should be true.", ucl.containsExtender(extender));
    }

    /**
     * Test method for containsExtender(UseCase).
     */
    public void testContainsExtenderUseCase() {
        extender.setBase(ucl);
        ucl.addExtender(extender);
        assertFalse("Should be false.", ucl.containsExtender(useCase));

        extender.setExtension(useCase);
        assertTrue("Should be true.", ucl.containsExtender(useCase));
    }

    /**
     * Test method for countExtenders().
     */
    public void testCountExtenders() {
        assertEquals("Should be equal.", 0, ucl.countExtenders());
        extender.setBase(ucl);
        ucl.addExtender(extender);
        ucl.addExtender(extender);

        assertEquals("Should be equal.", 2, ucl.countExtenders());
    }

    /**
     * Test method for getSubUseCases().
     */
    public void testGetSubUseCases() {
        assertEquals("Should be equal.", 0, ucl.getSubUseCases().size());

        extender.setExtension(useCase);
        extender.setBase(ucl);
        ucl.addExtender(extender);
        ucl.addExtender(extender);

        Collection <UseCase> res = ucl.getSubUseCases();
        assertEquals("Should be equal.", 2, res.size());
        Iterator<UseCase> iter = res.iterator();
        while (iter.hasNext()) {
            assertEquals("Should be equal.", useCase, iter.next());
        }
    }

    /**
     * Test method for getActors().
     */
    public void testGetActors() {

        actorEnd.setParticipant(actor);
        useCaseEnd.setParticipant(useCase);
        actor.addAssociation(actorEnd);
        useCase.addAssociation(useCaseEnd);

        association.addConnection(useCaseEnd);
        association.addConnection(actorEnd);
        actorEnd.setAssociation(association);
        useCaseEnd.setAssociation(association);

        assertTrue("should be true.", UseCaseUtil.findAssociatedEnd(actor,
                                                                    UseCase.class).contains(useCase));
        assertEquals("should be equal.", 1, UseCaseUtil.findAssociatedEnd(actor,
                                                                          UseCase.class).size());

    }

}
