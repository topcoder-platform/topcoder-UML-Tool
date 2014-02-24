/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.activitygraph.accuracytests;

import java.io.File;

import org.xml.sax.Locator;
import org.xml.sax.helpers.LocatorImpl;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.DefaultXMIHandler;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test for <code>{@link ActivityGraphXMIHandler}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class ActivityGraphXMIHandlerAccuracyTests extends TestCase {

    /**
     * <p>
     * Represents the <code>ActivityGraphXMIHandler</code> instance used in tests.
     * </p>
     */
    private ActivityGraphXMIHandler activityGraphXMIHandler;

    /**
     * <p>
     * Represents the <code>XMIReader</code> instance used in tests.
     * </p>
     */
    private XMIReader xmiReader;

    /**
     * <p>
     * Represents the <code>ModelElementFactory</code> instance used in tests.
     * </p>
     */
    private ModelElementFactory modelElementFactory;

    /**
     * <p>
     * Represents the <code>UMLModelManager</code> instance used in tests.
     * </p>
     */
    private UMLModelManager modelManager;

    /**
     * <p>
     * Set up the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();

        AccuracyTestHelper.loadNamespaces();

        xmiReader = new XMIReader();
        modelElementFactory = new ModelElementFactory(
            "com.topcoder.xmi.reader.handlers.uml.activitygraph.accuracytests.ModelElementFactory.accurate");
        modelManager = new UMLModelManager();
        activityGraphXMIHandler = new ActivityGraphXMIHandler(xmiReader, modelElementFactory, modelManager);
        ((ActivityGraphXMIHandler) xmiReader.getHandler("UML:StateMachine"))
            .setModelElementFactory(modelElementFactory);
    }

    /**
     * <p>
     * Teardown the testing environment.
     * </p>
     * @throws Exception
     *             pass any unexpected exception to JUnit.
     */
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
        AccuracyTestHelper.clearNamespaces();
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ActivityGraphXMIHandler#ActivityGraphXMIHandler()}</code> method.
     * </p>
     */
    public void testActivityGraphXMIHandlerAccuracy() {
        activityGraphXMIHandler = new ActivityGraphXMIHandler();
        assertNull("The XMIReader should be null.", AccuracyTestHelper.getPrivateField(DefaultXMIHandler.class,
            activityGraphXMIHandler, "reader"));
        assertNotNull("The ModelElementFactory instance should not be null.", AccuracyTestHelper.getPrivateField(
            ActivityGraphXMIHandler.class, activityGraphXMIHandler, "modelElementFactory"));
        assertNotNull("The UMLModelManager instance should not be null.", AccuracyTestHelper.getPrivateField(
            ActivityGraphXMIHandler.class, activityGraphXMIHandler, "modelManager"));
    }

    /**
     * <p>
     * Accuracy test for
     * <code>{@link ActivityGraphXMIHandler#ActivityGraphXMIHandler(XMIReader, ModelElementFactory, UMLModelManager)</code> method.
     * </p>
     */
    public void testActivityGraphXMIHandlerAccuracy2() {
        activityGraphXMIHandler = new ActivityGraphXMIHandler(xmiReader, modelElementFactory, modelManager);

        assertSame("The XMIReader should be null.", xmiReader, AccuracyTestHelper.getPrivateField(
            DefaultXMIHandler.class, activityGraphXMIHandler, "reader"));
        assertSame("The ModelElementFactory instance should not be null.", modelElementFactory, AccuracyTestHelper
            .getPrivateField(ActivityGraphXMIHandler.class, activityGraphXMIHandler, "modelElementFactory"));
        assertSame("The UMLModelManager instance should not be null.", modelManager, AccuracyTestHelper
            .getPrivateField(ActivityGraphXMIHandler.class, activityGraphXMIHandler, "modelManager"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ActivityGraphXMIHandler#setModelElementFactory(ModelElementFactory)}</code>
     * method.
     * </p>
     */
    public void testSetModelElementFactoryAccuracy() {
        modelElementFactory = new ModelElementFactory();
        activityGraphXMIHandler.setModelElementFactory(modelElementFactory);
        assertSame("The ModelElementFactory instance is incorrect.", modelElementFactory, AccuracyTestHelper
            .getPrivateField(ActivityGraphXMIHandler.class, activityGraphXMIHandler, "modelElementFactory"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ActivityGraphXMIHandler#getModelElementFactory()}</code> method.
     * </p>
     */
    public void testGetModelElementFactoryAccuracy() {
        modelElementFactory = new ModelElementFactory();
        activityGraphXMIHandler.setModelElementFactory(modelElementFactory);
        assertSame("The ModelElementFactory instance is incorrect.", modelElementFactory, activityGraphXMIHandler
            .getModelElementFactory());
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ActivityGraphXMIHandler#setDocumentLocator(Locator)}</code> method.
     * </p>
     */
    public void testSetDocumentLocatorAccuracy() {
        Locator locator = new LocatorImpl();
        activityGraphXMIHandler.setDocumentLocator(locator);
        assertSame("The Locator instance is incorrect.", locator, AccuracyTestHelper.getPrivateField(
            ActivityGraphXMIHandler.class, activityGraphXMIHandler, "locator"));

        activityGraphXMIHandler.setDocumentLocator(null);
        assertNull("the Locator instance should be null.", AccuracyTestHelper.getPrivateField(
            ActivityGraphXMIHandler.class, activityGraphXMIHandler, "locator"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ActivityGraphXMIHandler#setUmlModelManager(UMLModelManager)}</code> method.
     * </p>
     */
    public void testSetUmlModelManagerAccuracy() {
        modelManager = new UMLModelManager();
        activityGraphXMIHandler.setUmlModelManager(modelManager);
        assertSame("The UMLModelManager instance is incorrect.", modelManager, AccuracyTestHelper.getPrivateField(
            ActivityGraphXMIHandler.class, activityGraphXMIHandler, "modelManager"));
    }

    /**
     * <p>
     * Accuracy test for <code>{@link ActivityGraphXMIHandler#getUmlModelManager()}</code> method.
     * </p>
     */
    public void testGetUmlModelManagerAccuracy() {
        modelManager = new UMLModelManager();
        activityGraphXMIHandler.setUmlModelManager(modelManager);
        assertSame("The UMLModelManager instance is incorrect.", modelManager, activityGraphXMIHandler
            .getUmlModelManager());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) } and
     * {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     * <p>
     * Verify : the UML:SimpleState element is parsed correctly.
     * </p>
     * @throws Exception
     *             to JUnit.
     */
    public void testSimpleState() throws Exception {
        xmiReader.parse(new File("test_files" + File.separator + "accuracytests" + File.separator
            + "SimpleStateMachine.xmi"));

        Object obj = xmiReader.getElement("-64--88-1-100--12c6026f:10fa54f7a34:-8000:0000000000000801");

        // verify the type
        assertTrue("Expects SimpleState instance.", obj != null && obj instanceof SimpleState);

        SimpleState state = (SimpleState) obj;

        // verify the SimpleState properties
        assertFalse("The isSpecification property should be false.", state.isSpecification());
        assertEquals("Expects one outgoing transition.", 1, state.getOutgoingTransitions().size());
        assertNotNull("Expects the outgoing transition is set.", state.getOutgoingTransitions().iterator().next());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) } and
     * {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     * <p>
     * Verify : the UML:SimpleState element is parsed correctly.
     * </p>
     * @throws Exception
     *             to JUnit.
     */
    public void testComplexState() throws Exception {
        xmiReader.parse(new File("test_files" + File.separator + "accuracytests" + File.separator
            + "ComplexStateMachine.xmi"));
        activityGraphXMIHandler = ((ActivityGraphXMIHandler) xmiReader.getHandler("UML:StateMachine"));

        // Activity Graph
        Object obj = xmiReader.getElement("-64--88-1-100--6086d5ca:10fa572c9b1:-8000:000000000000077C");

        // verify the type
        assertTrue("Expects ActivityGraph instance.", obj instanceof ActivityGraph);

        ActivityGraph activityGraph = (ActivityGraph) obj;

        // verify the ActivityGraph properties
        assertFalse("The isSpecification property should be false.", activityGraph.isSpecification());
        assertNotNull("The top property should be set.", activityGraph.getTop());
        assertTrue("The top property should be of CompositeState type.",
            activityGraph.getTop() instanceof CompositeState);

        // verify the ActivyGraph instance is added to the uml model manager
        assertTrue("The ActivyGraph instance should be added to the uml model manager.", activityGraphXMIHandler
            .getUmlModelManager().containsActivityGraph(activityGraph));

        // Composite State
        obj = xmiReader.getElement("-64--88-1-100--6086d5ca:10fa572c9b1:-8000:000000000000077D");

        // verify the type
        assertTrue("Expects CompositeState instance.", obj != null && obj instanceof CompositeState);

        CompositeState state = (CompositeState) obj;

        // verify the CompositeState properties
        assertFalse("The isSpecification property should be false.", state.isSpecification());
        assertFalse("The isConcurrent property should be false.", state.isConcurrent());
        assertEquals("The name should be top.", "top", state.getName());

        assertEquals("Expects two subvertexs.", 13, state.getSubVertexes().size());

        // Final State
        obj = xmiReader.getElement("-64--88-1-100--6086d5ca:10fa572c9b1:-8000:000000000000079A");

        // verify the type
        assertTrue("Expects FinalState instance.", obj != null && obj instanceof FinalState);

        FinalState finalState = (FinalState) obj;

        // verify the FinalState properties
        assertFalse("The isSpecification property should be false.", finalState.isSpecification());
        assertEquals("Expects one incoming transition.", 1, finalState.getIncomingTransitions().size());
        assertNotNull("Expects the incoming transition is set.", finalState.getIncomingTransitions().iterator().next());
        
        // Pseudostate
        obj = xmiReader.getElement("-64--88-1-100--6086d5ca:10fa572c9b1:-8000:00000000000008F9");

        // verify the type
        assertTrue("Expects Pseudostate instance.", obj != null && obj instanceof Pseudostate);

        Pseudostate  pseudostate = (Pseudostate) obj;

        // verify the Pseudostate properties
        assertFalse("The isSpecification property should be false.", pseudostate.isSpecification());
        assertEquals("Expects the kind property is set to FORK.", PseudostateKind.FORK, pseudostate.getKind());
        assertEquals("Expects one incoming transition.", 1, pseudostate.getIncomingTransitions().size());
        assertNotNull("Expects the incoming transition is set.", pseudostate.getIncomingTransitions().iterator().next());
        assertEquals("Expects two outgoing transitions.", 2, pseudostate.getOutgoingTransitions().size());
        
        // Object Flow State
        obj = xmiReader.getElement("-64--88-1-100--6086d5ca:10fa572c9b1:-8000:00000000000009D5");

        // verify the type
        assertTrue("Expects ObjectFlowState instance.", obj != null && obj instanceof ObjectFlowState);

        ObjectFlowState objectFlowState = (ObjectFlowState) obj;

        // verify the ObjectFlowState properties
        assertFalse("The isSpecification property should be false.", objectFlowState.isSpecification());
        assertFalse("The isSync property should be false.", objectFlowState.isSynch());
        assertEquals("Expects one outgoing transition.", 1, objectFlowState.getOutgoingTransitions().size());
        assertNotNull("Expects the outgoing transition is set.", objectFlowState.getOutgoingTransitions().iterator().next());
    }
}
