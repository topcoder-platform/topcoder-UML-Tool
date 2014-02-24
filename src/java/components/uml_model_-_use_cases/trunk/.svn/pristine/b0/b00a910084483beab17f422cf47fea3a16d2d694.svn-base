/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.usecases;

import java.util.Collection;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

/**
 * <p>
 * The component demonstration class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * <p>
     * Used in the demo for showing the Include/Includer/Extend/Extender relationship.
     * </p>
     */
    private UseCase base;

    /**
     * <p>
     * Used in the demo for showing the Include/Includer relationship.
     * </p>
     */
    private UseCase addition2;

    /**
     * <p>
     * Used in the demo for showing the Include/Includer relationship.
     * </p>
     */
    private UseCase addition;

    /**
     * <p>
     * Used in the demo for showing the Include/Includer relationship.
     * </p>
     */
    private Include include;

    /**
     * <p>
     * Used in the demo for showing the Include/Includer relationship.
     * </p>
     */
    private Include include2;

    /**
     * <p>
     * Used in the demo for showing the Extend/Extender relationship.
     * </p>
     */
    private UseCase extension;

    /**
     * <p>
     * Used in the demo for showing the Extend/Extender relationship.
     * </p>
     */
    private UseCase extension2;

    /**
     * <p>
     * Used in the demo for showing the Extend/Extender relationship.
     * </p>
     */
    private Extend extend;

    /**
     * <p>
     * Used in the demo for showing the Extend/Extender relationship.
     * </p>
     */
    private Extend extend2;

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(Demo.class);
    }

    /**
     * <p>
     * This method shows the actors management functionality.
     * </p>
     */
    public void testActorsMangementDemo() {
        // Create an empty actor
        Actor actor = new ActorImpl();
        // This is a method in the ModelElement interface, which is one of the base
        // interfaces of Actor
        actor.setName("Application");
        System.out.println(actor.getName());

        // Should be empty initially
        Collection<UseCase> associated = actor.getUseCases();

        // Add a UseCase related to the Actor 每 notice how many steps it takes
        // set up the use-case side of the association
        UseCase useCase1 = new UseCaseImpl();
        useCase1.setName("Manage Actors");
        AssociationEnd useCaseEnd = new AssociationEndImpl();
        useCaseEnd.setParticipant(useCase1);
        actor.addAssociation(useCaseEnd);

        // set up the actor side of the association
        AssociationEnd actorEnd = new AssociationEndImpl();
        actorEnd.setParticipant(actor);
        useCase1.addAssociation(actorEnd);

        // connect the ends up in an Association
        Association assoc = new AssociationImpl();
        assoc.addConnection(useCaseEnd);
        assoc.addConnection(actorEnd);
        useCaseEnd.setAssociation(assoc);
        actorEnd.setAssociation(assoc);

        // Should have the UseCase we added through the lengthy process above (useCase1)
        Collection<UseCase> useCases = actor.getUseCases();
        System.out.println(useCases);

    }

    /**
     * <p>
     * This method shows the use cases management functionality.
     * </p>
     */
    public void testUseCasesManagementDemo() {
        UseCase useCase2 = new UseCaseImpl();
        // This is a method in the ModelElement interface, which is one of the base
        // interfaces of UseCase
        useCase2.setName("Manage Use Cases");
        System.out.println(useCase2.getName());

        // Should be empty initially
        Collection<Actor> associated = useCase2.getActors();

        // Add an Actor related to the UseCase 每 notice how many steps it takes
        // set up the use-case side of the association
        Association assoc = new AssociationImpl();
        AssociationEnd useCaseEnd = new AssociationEndImpl();
        useCaseEnd.setParticipant(useCase2);

        // set up the actor side of the association
        Actor actor = new ActorImpl();
        actor.addAssociation(useCaseEnd);
        actor.setName("Application");
        AssociationEnd actorEnd = new AssociationEndImpl();
        actorEnd.setParticipant(actor);
        useCase2.addAssociation(actorEnd);

        assoc.addConnection(useCaseEnd);
        assoc.addConnection(actorEnd);
        useCaseEnd.setAssociation(assoc);
        actorEnd.setAssociation(assoc);

        // Should include the Actor we added through the lengthy process above.
        Collection<Actor> actors = useCase2.getActors();
        System.out.println(actors);

    }

    /**
     * <p>
     * This method shows the include relationship creation functionality.
     * </p>
     */
    public void testIncludeCreationDemo() {
        base = new UseCaseImpl();
        base.setName("Manage Include relationships of a UseCase");
        addition = new UseCaseImpl();
        addition.setName("Do something more");

        include = new IncludeImpl(base, addition);
        // we can get the base and addition
        System.out.println(include.getBase());
        System.out.println(include.getAddition());

        addition2 = new UseCaseImpl();
        addition2.setName("Do something else");

        include2 = new IncludeImpl();
        include2.setBase(base);
        include2.setAddition(addition2);
    }

    /**
     * <p>
     * This method shows the include relationship management functionality.
     * </p>
     */
    public void testIncludeRelatonshipDemo() {
        // create the variables firstly
        testIncludeCreationDemo();

        // should have zero includes initially
        System.out.println(base.countIncludes());

        // add the includes
        base.addInclude(include);
        base.addInclude(include2);

        // see if it included the first include object
        System.out.println(base.containsInclude(include));
        //         another way to do it 每 use the UseCase
        System.out.println(base.containsInclude(addition2));

        // get the include objects 每 should have include and include2
        Collection<Include> includes = base.getIncludes();
        //         another way to get included use cases 每 should have addition and addition2
        Collection<UseCase> included = base.getIncludedUseCases();

        // should have two includes
        System.out.println(base.countIncludes());

        // remove one (should return true)
        base.removeInclude(include);
        // should be one now
        System.out.println(base.countIncludes());
        // try to remove it again (should return false and do nothing else)
        base.removeInclude(include);
        // should still be one
        System.out.println(base.countIncludes());

        // remove "all" of them
        base.clearIncludes();
        // should have none
        System.out.println(base.countIncludes());

    }

    /**
     * <p>
     * This method shows the includer relationship management functionality.
     * </p>
     */
    public void testIncluderRelationshipDemo() {
        // create the variables firstly
        testIncludeCreationDemo();

        // should have zero initially
        System.out.println(base.countIncluders());

        // add the include
        addition.addIncluder(include);

        // see if it included the include object
        System.out.println(addition.containsIncluder(include));
        // another way to do it 每 use the UseCase
        System.out.println(addition.containsIncluder(base));

        // get the include objects
        Collection<Include> includers = addition.getIncluders();
        // another way to get including use cases
        Collection<UseCase> including = addition.getIncludingUseCases();

        // should have one includer
        System.out.println(base.countIncluders());

        // remove it
        addition.removeIncluder(include);
        // should be none now
        System.out.println(addition.countIncluders());

        // add the include again, for testing purposes
        addition.addIncluder(include);
        addition.clearIncluders();
        // should have none
        System.out.println(addition.countIncluders());
    }

    /**
     * <p>
     * This method shows the extension relationship creation functionality.
     * </p>
     */
    public void testExtensionCreationDemo() {
        base = new UseCaseImpl();
        base.setName("Create relationship");
        base.setAbstract(true);

        extension = new UseCaseImpl();
        extension.setName("Create Extend relationships");

        extend = new ExtendImpl(base, extension);
        System.out.println(extend.getBase());
        System.out.println(extend.getExtension());

        extension2 = new UseCaseImpl();
        extension2.setName("Create Include relationships");
        extend2 = new ExtendImpl();
        extend2.setBase(base);
        extend2.setExtension(extension2);

    }

    /**
     * <p>
     * This method shows the extend relationship management functionality.
     * </p>
     */
    public void testExtendRelationShip() {
        // create the variables firstly
        testExtensionCreationDemo();

        // should have zero initially
        System.out.println(extension.countExtends());

        // add the extension
        extension.addExtend(extend);

        // should have one extends
        System.out.println(extension.countExtends());

        // see if it contains the extension using the Extend object
        System.out.println(extension.containsExtend(extend));
        // another way to do it 每 use the UseCase
        System.out.println(extension.containsExtend(base));

        // get the extend objects
        Collection<Extend> extendObjects = extension.getExtends();
        // another way to get extended use cases
        Collection<UseCase> bases = extension.getBaseUseCases();

        // remove the extension
        extension.removeExtend(extend);
        // should be none now
        System.out.println(extension.countExtends());

        // re-add the extension
        extension.addExtend(extend);
        extension.clearExtends();
        // should have none
        System.out.println(extension.countExtends());

    }

    /**
     * <p>
     * This method shows the extender relationship management functionality.
     * </p>
     */
    public void testExtenderRelationShip() {
        // create the variables firstly
        testExtensionCreationDemo();

        // should have zero initially
        System.out.println(base.countExtenders());

        // add the extenders
        base.addExtender(extend);
        base.addExtender(extend2);

        // see if it includes the first extend object
        System.out.println(base.containsExtender(extend));
        System.out.println(base.containsExtender(extend2));
        // another way to do it 每 use the UseCase
        System.out.println(base.containsExtender(extension));
        System.out.println(base.containsExtender(extension2));

        // get the extend objects 每 should be 2
        Collection<Extend> extenders = base.getExtenders();
        // another way to get extension use cases 每 should be the 2 use cases
        Collection<UseCase> subUseCases = base.getSubUseCases();

        // should have two extenders
        System.out.println(base.countExtenders());

        // remove one
        base.removeExtender(extend);
        // should be one now
        System.out.println(base.countExtenders());

        base.clearExtenders();
        // should have none
        System.out.println(base.countExtenders());

    }

}
