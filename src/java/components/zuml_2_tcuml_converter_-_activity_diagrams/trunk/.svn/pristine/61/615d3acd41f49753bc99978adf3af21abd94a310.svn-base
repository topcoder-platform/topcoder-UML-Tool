/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.AbstractZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityDiagramImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityFinalNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLCallActionImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;


/**
 * The accuracy tests for the class ZUMLActivityDiagramImpl.
 *
 * @author KLW
 * @author bbskill
 * @version 1.0
 * @version 1.1
 */
public class ZUMLActivityDiagramImplAccuracyTests extends TestCase {
    /**
     * the accuracy tests for the method {@link ZUMLActivityDiagramImpl#convertToTCUML()}.
     *
     */
    public void testConvertToTCUML() {
        ZUMLActivityDiagramImpl instance = new ZUMLActivityDiagramImpl();
        ZUMLActivityNode start = new ZUMLInitialNodeImpl();
        instance.addNode(start);

        ZUMLActivityNode node1 = new ZUMLCallActionImpl();
        instance.addNode(node1);

        ZUMLActivityNode node2 = new ZUMLCallActionImpl();
        instance.addNode(node2);

        ZUMLActivityNode end = new ZUMLActivityFinalNodeImpl();
        instance.addNode(end);

        AbstractZUMLActivityEdge edge1 = new ZUMLActivityEdgeImpl();
        edge1.setSource(start);
        edge1.setTarget(node1);
        instance.addEdge(edge1);

        AbstractZUMLActivityEdge edge2 = new ZUMLActivityEdgeImpl();
        edge2.setSource(node1);
        edge2.setTarget(node2);
        instance.addEdge(edge2);

        AbstractZUMLActivityEdge edge3 = new ZUMLActivityEdgeImpl();
        edge3.setSource(node2);
        edge3.setTarget(end);
        instance.addEdge(edge3);

        AbstractZUMLActivityEdge edge4 = new ZUMLActivityEdgeImpl();
        edge4.setSource(start);
        edge4.setTarget(node2);
        instance.addEdge(edge4);

        instance.addNode(new ZUMLActivityFinalNodeImpl());
        instance.setName("edge");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();
        assertNotNull(element);
        assertTrue("The element should be of ActivityGraphImpl", element instanceof ActivityGraphImpl);

        ActivityGraphImpl sm = (ActivityGraphImpl) element;

        assertNotNull("The ActivityGraphImpl's top state should not be null.", sm.getTop());
        assertTrue("The ActivityGraphImpl's top state should be of CompositeState", sm.getTop() instanceof CompositeState);
    }
}
