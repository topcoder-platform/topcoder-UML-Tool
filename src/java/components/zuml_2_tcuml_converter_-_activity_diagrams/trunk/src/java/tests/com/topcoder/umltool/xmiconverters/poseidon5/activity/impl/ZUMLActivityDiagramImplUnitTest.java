/*
 * Copyright (C) 2007-2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.auxiliaryelements.CommentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateArgumentImpl;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameter;
import com.topcoder.uml.model.core.auxiliaryelements.TemplateParameterImpl;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.ElementImportImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityDiagram;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;


/**
 * <p>
 * Unit tests for <code>ZUMLActivityDiagramImpl</code> class.
 * </p>
 *
 * <p>
 * <strong>Change Note:</strong> As the return instance of <code>convertToTCUML()</code> is changed
 * from <code>StateMachineImpl</code> to <code>ActivityGraphImpl</code>, in this test case, the only
 * place to be changed is <code>testConvertToTCUML1()</code>, to let it verify that return instance
 * is a <code>ActivityGraphImpl</code> instance.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 * @author TCSDEVELOPER
 * @version 1.1
 */
public class ZUMLActivityDiagramImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(ZUMLActivityDiagramImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>ZUMLActivityDiagramImpl()</code>.
     * </p>
     *
     * <p>
     * The constructor is a trivial one, just test whether the instance can be created.
     * </p>
     */
    public void testCtor() {
        ZUMLActivityDiagram diagram = new ZUMLActivityDiagramImpl();
        assertNotNull("Unable to create ZUMLActivityDiagramImpl instance.",
            diagram);
    }

    /**
     * <p>
     * Creates a ActivityDiagram for testing. It will contain 4 nodes and 4 edges.
     * And another isolated node.
     * </p>
     *
     * @return a AcitivityDiagram for testing.
     */
    private AbstractZUMLActivityDiagram createDiagramForTest() {
        AbstractZUMLActivityDiagram diagram = new ZUMLActivityDiagramImpl();

        ZUMLActivityNode start = new ZUMLInitialNodeImpl();
        diagram.addNode(start);

        ZUMLActivityNode node1 = new ZUMLCallActionImpl();
        diagram.addNode(node1);

        ZUMLActivityNode node2 = new ZUMLCallActionImpl();
        diagram.addNode(node2);

        ZUMLActivityNode end = new ZUMLActivityFinalNodeImpl();
        diagram.addNode(end);

        AbstractZUMLActivityEdge edge1 = new ZUMLActivityEdgeImpl();
        edge1.setSource(start);
        edge1.setTarget(node1);
        diagram.addEdge(edge1);

        AbstractZUMLActivityEdge edge2 = new ZUMLActivityEdgeImpl();
        edge2.setSource(node1);
        edge2.setTarget(node2);
        diagram.addEdge(edge2);

        AbstractZUMLActivityEdge edge3 = new ZUMLActivityEdgeImpl();
        edge3.setSource(node2);
        edge3.setTarget(end);
        diagram.addEdge(edge3);

        AbstractZUMLActivityEdge edge4 = new ZUMLActivityEdgeImpl();
        edge4.setSource(start);
        edge4.setTarget(node2);
        diagram.addEdge(edge4);

        //A ioslated node.
        diagram.addNode(new ZUMLActivityFinalNodeImpl());

        return diagram;
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the returned ModelElement is instance of <code>ActivityGraphImpl</code>,
     * and its edges and node should be converted too. And verify simple attributes are copied
     * to the converted instance.
     * </p>
     *
     * <p>
     * <strong>Change note:</strong> Verify that the return value is instance of <code>ActivityGraphImpl
     * </code>.
     * </p>
     *
     * @since 1.1
     */
    public void testConvertToTCUML1() {
        AbstractZUMLActivityDiagram diagram = createDiagramForTest();

        // Set its simple attributes
        diagram.setName("edge");

        Namespace namespace = new CollaborationImpl();
        diagram.setNamespace(namespace);

        diagram.setVisibility(null);
        diagram.setSpecification(true);

        ModelElement element = diagram.convertToTCUML();

        //In version 1.1, it should return a ActivityGraphImpl instance.
        assertTrue("The activity diagram should be converted a ActivityGraphImpl instance.",
            element instanceof ActivityGraphImpl);

        StateMachine sm = (StateMachine) element;

        assertNotNull("There should be 1 CompositeState.", sm.getTop());
        assertTrue("The top should be CompositeState.",
            sm.getTop() instanceof CompositeState);

        CompositeState state = (CompositeState) sm.getTop();
        assertEquals("The state should have 4 subvertexes.", 4,
            state.getSubVertexes().size());
        assertEquals("The statemachine should have 4 transition.", 4,
            sm.getTransitions().size());

        //Verify its simple attributes
        assertEquals("The name should match.", "edge", element.getName());
        assertEquals("The namespace should match.", namespace,
            element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.",
            element.isSpecification());
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that the common attribute from ModelElement is copied to the converted instance.
     * Complex attributes are verified in this test case. Simple attributes are verified in
     * the previous test case.
     * </p>
     */
    public void testConvertToTCUML2() {
        AbstractZUMLActivityDiagram diagram = new ZUMLActivityDiagramImpl();

        diagram.addStereotype(new StereotypeImpl());
        diagram.addTaggedValue(new TaggedValueImpl());
        diagram.addReferenceTag(new TaggedValueImpl());
        diagram.addSupplierDependency(new DependencyImpl());
        diagram.addClientDependency(new DependencyImpl());
        diagram.addComment(new CommentImpl());

        TemplateParameter tp = new TemplateParameterImpl();
        diagram.setParameterTemplate(tp);

        diagram.addDefaultParameter(new TemplateParameterImpl());
        diagram.addTemplateParameter(new TemplateParameterImpl());
        diagram.addTemplateArgument(new TemplateArgumentImpl());
        diagram.addElementImport(new ElementImportImpl());
        diagram.addBehavior(new StateMachineImpl());

        ModelElement element = diagram.convertToTCUML();

        assertEquals("There should be 1 stereotype.", 1,
            element.getStereotypes().size());
        assertEquals("There should be 0 taggedValue.", 0,
            element.getTaggedValues().size());
        assertEquals("There should be 1 referenceTag.", 1,
            element.getReferenceTags().size());
        assertEquals("There should be 1 supplierDependency.", 1,
            element.getSupplierDependencies().size());
        assertEquals("There should be 1 clientDependency.", 1,
            element.getClientDependencies().size());
        assertEquals("There should be 1 comment.", 1,
            element.getComments().size());
        assertEquals("The parameterTemplate should match.", tp,
            element.getParameterTemplate());
        assertEquals("There should be 1 defaultParameter.", 1,
            element.getDefaultParameters().size());
        assertEquals("There should be 1 templateParameter.", 1,
            element.getTemplateParameters().size());
        assertEquals("There should be 1 templateArgument.", 1,
            element.getTemplateArguments().size());
        assertEquals("There should be 1 elementImport.", 1,
            element.getElementImports().size());
        assertEquals("There should be 1 behavior.", 1,
            element.getBehaviors().size());
    }

    /**
     * <p>
     * Accuracy test for <code>convertToTCUML()</code>.
     * </p>
     *
     * <p>
     * Verify that convertToTCUML() always returns the same instance.
     * </p>
     */
    public void testConvertToTCUML3() {
        AbstractZUMLActivityDiagram diagram = new ZUMLActivityDiagramImpl();

        assertEquals("The convertToTCUML() should always return the same instance.",
            diagram.convertToTCUML(), diagram.convertToTCUML());
    }
}
