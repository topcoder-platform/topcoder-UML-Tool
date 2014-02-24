/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ Demo.java
 */
package com.topcoder.uml.model.collaborations;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.collaborations.collaborationroles.Message;
import com.topcoder.uml.model.collaborations.collaborationroles.MessageImpl;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.MockInstance;
import com.topcoder.uml.model.commonbehavior.instances.MockStimulus;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.MockLink;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.MockClassifier;
import com.topcoder.uml.model.core.MockModelElement;
import com.topcoder.uml.model.core.MockOperation;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;

import junit.framework.TestCase;

/**
 * <p> The demo will demonstrate the usage of these beans. It will show them being instantiated,
 * then used via their interface. This will be the typical usage of such simple entities under
 * any scenario. This demo will focus on showing how a simple and collection attribute is managed,
 * with the understanding that all other attributes are managed in exactly the same manner, and
 * therefore not shown here. </p>
 *
 * @author yinzi
 * @version 1.0
 */
public class Demo extends TestCase {

    /**
     * Create an instance of sample entity: Message. All other concrete entities are instantiated
     * in this manner and are not shown here.
     */
    public void testInstantiationDemo() {
        // Create an instance of sample entity
        Message message = new MessageImpl();

        // Create sample entity with a simple attribute to manage
        Stimulus conformingStimulus = new MockStimulus();

        // Use setter
        message.setConformingStimulus(conformingStimulus);
        // Use getter
        Stimulus retrievedConformingStimulus = message.getConformingStimulus();
    }

    /**
     * Manage a collection attribute: CollaborationInstanceSet. participatingLinks. All other collection
     * attributes are managed in this manner and are not shown here.
     */
    public void testInstanceSetDemo() {
        // Create sample entity with a collection attribute to manage
        CollaborationInstanceSet collaborationInstanceSet = new CollaborationInstanceSetImpl();

        // Create sample entity with a simple attribute to manage
        Collaboration collaboration = new CollaborationImpl();

        // Use setter
        collaborationInstanceSet.setCollaboration(collaboration);
        // Use getter
        Collaboration retrievedCollaboration = collaborationInstanceSet.getCollaboration();

        // Use single-entity add method
        Instance instance1 = new MockInstance();
        collaborationInstanceSet.addParticipatingInstance(instance1);
        // There is now one supplier in the collection
        // Use multiple-entity add method
        Collection<Instance> col1 = new ArrayList<Instance>();
        Instance instance2 = new MockInstance();
        Instance instance3 = new MockInstance();

        // collection with 3 valid suppliers
        col1.add(instance1);
        col1.add(instance2);
        col1.add(instance3);
        collaborationInstanceSet.addParticipatingInstances(col1);

        // There will now be 4 suppliers in the collection
        // Use contains method to check for supplier presence
        // This will be true
        boolean present1 = collaborationInstanceSet.containsParticipatingInstance(instance1);
        boolean present2 = collaborationInstanceSet.containsParticipatingInstance(instance2);
        boolean present3 = collaborationInstanceSet.containsParticipatingInstance(instance3);

        // Use count method to get the number of suppliers
        // The count will be 4
        int count = collaborationInstanceSet.countParticipatingInstances();

        // Get the Collection
        Collection<Instance> collection1 = collaborationInstanceSet.getParticipatingInstances();

        // Use single-entity remove method
        // This will be true, and the collection size is 3
        boolean removed = collaborationInstanceSet.removeParticipatingInstance(instance1);


        // if instance1 has duplicates in this collection.
        // Use multiple-entity remove method
        Collection<Instance> col2 = new ArrayList<Instance>();
        col2.add(instance2);
        col2.add(instance3);

        // This will be true, and the collection size is 1
        boolean altered = collaborationInstanceSet.removeParticipatingInstances(col2);

        // Use clear method
        // The collection size is 0 and contains no suppliers
        collaborationInstanceSet.clearParticipatingInstances();


        // Use single-entity add method
        Link client1 = new MockLink();
        collaborationInstanceSet.addParticipatingLink(client1);
        // There is now one supplier in the collection
        // Use multiple-entity add method
        Collection<Link> col3 = new ArrayList<Link>();
        Link client2 = new MockLink();
        Link client3 = new MockLink();

        // collection with 3 valid suppliers
        col3.add(client1);
        col3.add(client2);
        col3.add(client3);
        collaborationInstanceSet.addParticipatingLinks(col3);

        // There will now be 4 suppliers in the collection
        // Use contains method to check for supplier presence
        // This will be true
        present1 = collaborationInstanceSet.containsParticipatingLink(client1);
        present2 = collaborationInstanceSet.containsParticipatingLink(client2);
        present3 = collaborationInstanceSet.containsParticipatingLink(client3);

        // Use count method to get the number of suppliers
        // The count will be 4
        count = collaborationInstanceSet.countParticipatingLinks();

        // Get the Collection
        Collection<Link> collection2 = collaborationInstanceSet.getParticipatingLinks();

        // Use single-entity remove method
        // This will be true, and the collection size is 3
        removed = collaborationInstanceSet.removeParticipatingLink(client1);


        // if client1 has duplicates in this collection.
        // Use multiple-entity remove method
        Collection<Link> col4 = new ArrayList<Link>();
        col4.add(client2);
        col4.add(client3);

        // This will be true, and the collection size is 1
        altered = collaborationInstanceSet.removeParticipatingLinks(col4);

        // Use clear method
        // The collection size is 0 and contains no suppliers
        collaborationInstanceSet.clearParticipatingLinks();
    }

    /**
     * Manage a collection attribute: Collaboration. All other collection attributes are managed in
     * this manner and are not shown here.
     */
    public void testCollaborationDemo() {
        // Create sample entity with a collection attribute to manage
        Collaboration collaboration = new CollaborationImpl();

        // Use single-entity add method
        CollaborationInstanceSet collaborationInstanceSet1 = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet1);
        // There is now one supplier in the collection
        // Use multiple-entity add method
        Collection<CollaborationInstanceSet> col1 = new ArrayList<CollaborationInstanceSet>();
        CollaborationInstanceSet collaborationInstanceSet2 = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet collaborationInstanceSet3 = new CollaborationInstanceSetImpl();

        // collection with 3 valid suppliers
        col1.add(collaborationInstanceSet1);
        col1.add(collaborationInstanceSet2);
        col1.add(collaborationInstanceSet3);
        collaboration.addCollaborationInstanceSets(col1);

        // There will now be 4 suppliers in the collection
        // Use contains method to check for supplier presence
        // This will be true
        boolean present1 = collaboration.containsCollaborationInstanceSet(collaborationInstanceSet1);
        boolean present2 = collaboration.containsCollaborationInstanceSet(collaborationInstanceSet2);
        boolean present3 = collaboration.containsCollaborationInstanceSet(collaborationInstanceSet3);

        // Use count method to get the number of suppliers
        // The count will be 4
        int count = collaboration.countCollaborationInstanceSets();

        // Get the Collection
        Collection<CollaborationInstanceSet> collection1 = collaboration.getCollaborationInstanceSets();

        // Use single-entity remove method
        // This will be true, and the collection size is 3
        boolean removed = collaboration.removeCollaborationInstanceSet(collaborationInstanceSet1);


        // if collaborationInstanceSet1 has duplicates in this collection.
        // Use multiple-entity remove method
        Collection<CollaborationInstanceSet> col2 = new ArrayList<CollaborationInstanceSet>();
        col2.add(collaborationInstanceSet2);
        col2.add(collaborationInstanceSet3);

        // This will be true, and the collection size is 1
        boolean altered = collaboration.removeCollaborationInstanceSets(col2);

        // Use clear method
        // The collection size is 0 and contains no suppliers
        collaboration.clearCollaborationInstanceSets();

        // Create sample entity with a simple attribute to manage
        Classifier classifier = new MockClassifier();

        // Use setter
        collaboration.setRepresentedClassifier(classifier);
        // Use getter
        Classifier retrievedClassifier = collaboration.getRepresentedClassifier();


        // Create sample entity with a simple attribute to manage
        Operation operation = new MockOperation();

        // Use setter
        collaboration.setRepresentedOperation(operation);
        // Use getter
        Operation retrievedOperation = collaboration.getRepresentedOperation();

        // Create sample entity with a collection attribute to manage
        CollaborationImpl collaborationImpl = new CollaborationImpl();

        // Use single-entity add method
        ModelElement modelElement1 = new MockModelElement();
        ModelElement modelElement2 = new MockModelElement();
        ModelElement modelElement3 = new MockModelElement();
        // There is now one ModelElement in the collection
        collaborationImpl.addOwnedElement(modelElement1);
        collaborationImpl.addOwnedElement(modelElement2);
        // Use contains method to check for supplier presence
        // This will be true
        present1 = collaborationImpl.containsOwnedElement(modelElement1);
        present2 = collaborationImpl.containsOwnedElement(modelElement2);
        present3 = collaborationImpl.containsOwnedElement(modelElement3);

        // Use count method to get the number of suppliers
        // The count will be 4
        count = collaborationImpl.countOwnedElements();

        // Get the Collection
        Collection<ModelElement> collection4 = collaborationImpl.getOwnedElements();

        // Use single-entity remove method
        // This will be true, and the collection size is 3
        removed = collaborationImpl.removeOwnedElement(modelElement1);

        // Use clear method
        // The collection size is 0 and contains no suppliers
        collaborationImpl.clearOwnedElements();
    }
}
