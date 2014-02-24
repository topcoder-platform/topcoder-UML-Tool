/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.activitygraph;

import java.io.File;
import java.util.Iterator;

import org.xml.sax.helpers.LocatorImpl;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.activitygraphs.CallState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.XMIReaderParseException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

/**
 * <p>
 * Unit test cases for ActivityGraphXMIHandler.
 * </p>
 *
 * <p>
 * Note, because this component is a plugin of XMIReader component, the startElement()
 * and endElemnet() can not be tested separately. So the two methods are tested using
 * the XMIReader component. The two methods are invoked indirectly via the XMIReader instance.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ActivityGraphXMIHandlerTests extends TestCase {
    /**
     * <p>
     * ActivityGraphXMIHandler instance for testing.
     * </p>
     */
    private ActivityGraphXMIHandler handler;

    /**
     * <p>
     * XMIReader instance for helping testing.
     * </p>
     */
    private XMIReader reader;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.loadSingleXMLConfig(XMIReader.class.getName(), "test_files" + File.separator + "reader_config.xml");
        TestHelper.loadSingleXMLConfig(ModelElementFactory.class.getName(), "test_files" + File.separator
            + "ModelElementFactoryConfig.xml");
        reader = new XMIReader();

        handler = (ActivityGraphXMIHandler) reader.getHandler("UML:StateMachine");
        handler.setModelElementFactory(new ModelElementFactory(ModelElementFactory.class.getName()));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfigFile(XMIReader.class.getName());
        TestHelper.clearConfigFile(ModelElementFactory.class.getName());

        reader = null;
        handler = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(ActivityGraphXMIHandlerTests.class);
    }

    /**
     * <p>
     * Tests ctor ActivityGraphXMIHandler#ActivityGraphXMIHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created ActivityGraphXMIHandler should not be null.
     * </p>
     */
    public void testCtor1() {
        assertNotNull("Failed to created a new ActivityGraphXMIHandler instance.", new ActivityGraphXMIHandler(reader,
            new ModelElementFactory(), UMLModelManager.getInstance()));
    }

    /**
     * <p>
     * Tests ctor ActivityGraphXMIHandler#ActivityGraphXMIHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when reader is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullReader() {
        try {
            new ActivityGraphXMIHandler(null, new ModelElementFactory(), UMLModelManager.getInstance());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ActivityGraphXMIHandler#ActivityGraphXMIHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElementFactory is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullModelElementFactory() {
        try {
            new ActivityGraphXMIHandler(reader, null, UMLModelManager.getInstance());
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ActivityGraphXMIHandler#ActivityGraphXMIHandler(XMIReader,ModelElementFactory,
     * UMLModelManager) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testCtor1_NullModelManager() {
        try {
            new ActivityGraphXMIHandler(reader, new ModelElementFactory(), null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ctor ActivityGraphXMIHandler#ActivityGraphXMIHandler() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The newly created ActivityGraphXMIHandler should not be null.
     * </p>
     */
    public void testCtor2() {
        ActivityGraphXMIHandler activityHandler = new ActivityGraphXMIHandler();
        assertNotNull("Failed to created a new ActivityGraphXMIHandler instance.", activityHandler);

        assertNull("The XMIReader should be null.", activityHandler.getXMIReader());
        assertNotNull("The ModelElementFactory instance should not be null.", activityHandler.getModelElementFactory());
        assertNotNull("The UMLModelManager instance should not be null.", activityHandler.getUmlModelManager());
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#setModelElementFactory(ModelElementFactory) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The ModelElementFactory instance should be set correctly.
     * </p>
     */
    public void testSetModelElementFactory() {
        ModelElementFactory factory = new ModelElementFactory();
        handler.setModelElementFactory(factory);

        assertSame("The ModelElementFactory instance should be set correctly.", factory,
            handler.getModelElementFactory());
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#setModelElementFactory(ModelElementFactory) for failure.
     * </p>
     *
     * <p>
     * It tests the case that when modelElementFactory is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetModelElementFactory_NullModelElementFactory() {
        try {
            handler.setModelElementFactory(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#getModelElementFactory() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The model element factory should be returned correctly.
     * </p>
     */
    public void testGetModelElementFactory() {
        ModelElementFactory factory = new ModelElementFactory();
        ActivityGraphXMIHandler activityHandler = new ActivityGraphXMIHandler(reader, factory,
            UMLModelManager.getInstance());

        assertSame("The model element factory should be returned correctly.", factory,
            activityHandler.getModelElementFactory());
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#setUmlModelManager(UMLModelManager) for accuracy.
     * </p>
     *
     * <p>
     * Verify : The uml model manager should be set correctly.
     * </p>
     */
    public void testSetUmlModelManager() {
        UMLModelManager manager = UMLModelManager.getInstance();
        handler.setUmlModelManager(manager);

        assertSame("The uml model manager should be set correctly.", manager, handler.getUmlModelManager());
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#setUmlModelManager(UMLModelManager) for failure.
     * It tests the case that when modelManager is null and expects IllegalArgumentException.
     * </p>
     */
    public void testSetUmlModelManager_NullModelManager() {
        try {
            handler.setUmlModelManager(null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            //good
        }
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#getUmlModelManager() for accuracy.
     * </p>
     *
     * <p>
     * Verify : The uml model manager should be returned correctly.
     * </p>
     */
    public void testGetUmlModelManager() {
        UMLModelManager manager = UMLModelManager.getInstance();
        ActivityGraphXMIHandler activityHandler = new ActivityGraphXMIHandler(reader, new ModelElementFactory(),
            manager);

        assertSame("The uml model manager should be returned correctly.",
            manager, activityHandler.getUmlModelManager());
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#setDocumentLocator(Locator) for accuracy.
     * </p>
     *
     * <p>
     * Verify : setDocumentLocator() is invoked successfully and no exception.
     * </p>
     */
    public void testSetDocumentLocator() {
        // no validation here because the locator is not used in current implementation.
        handler.setDocumentLocator(new LocatorImpl());
    }

    /**
     * <p>
     * Tests ActivityGraphXMIHandler#setDocumentLocator(Locator) for accuracy.
     * </p>
     *
     * <p>
     * It tests the case that when locator is null and expects success.
     * </p>
     */
    public void testSetDocumentLocator_NullLocator() {
        // except no exception
        handler.setDocumentLocator(null);
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:ActionState element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testActionState() throws Exception {
        reader.parse(new File("test_files" + File.separator + "ActionState.xmi"));

        Object obj = reader.getElement("-64--88-1-88--330f1536:10f79802023:-8000:000000000000097F");

        // verify the type
        assertTrue("Expects ActionState instance.", obj != null && obj instanceof ActionState);

        ActionState actionState = (ActionState) obj;

        // verify the ActionState properties
        assertFalse("The isSpecification property should be false.", actionState.isSpecification());
        assertEquals("The outgoing transitions should contain one element.", 1,
            actionState.getOutgoingTransitions().size());

        Transition transition = actionState.getOutgoingTransitions().iterator().next();
        assertNotNull("The transition should be set.", transition);
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:ActivityGraph element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testActivityGraph() throws Exception {
        reader.parse(new File("test_files" + File.separator + "ActivityGraph.xmi"));

        Object obj = reader.getElement("-64--88-1-88--330f1536:10f79802023:-8000:000000000000097D");

        // verify the type
        assertTrue("Expects ActivityGraph instance.", obj instanceof ActivityGraph);

        ActivityGraph activityGraph = (ActivityGraph) obj;

        // verify the ActivityGraph properties
        assertFalse("The isSpecification property should be false.", activityGraph.isSpecification());
        assertNotNull("The top property should be set.", activityGraph.getTop());
        assertTrue("The top property should be of CompositeState type.",
            activityGraph.getTop() instanceof CompositeState);

        // verify the ActivyGraph instance is added to the uml model manager
        assertTrue("The ActivyGraph instance should be added to the uml model manager.",
            handler.getUmlModelManager().containsActivityGraph(activityGraph));
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:CallState element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCallState() throws Exception {
        reader.parse(new File("test_files" + File.separator + "CallState.xmi"));

        Object obj = reader.getElement("-64--88-1-88--330f1536:10f79802023:-8000:00000000000009E5");

        // verify the type
        assertTrue("Expects CallState instance.", obj != null && obj instanceof CallState);

        CallState state = (CallState) obj;

        // verify the CallState properties
        assertFalse("The isSpecification property should be false.", state.isSpecification());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:CompositeState element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testCompositeState() throws Exception {
        reader.parse(new File("test_files" + File.separator + "CompositeState.xmi"));

        Object obj = reader.getElement("-64--88-1-88-1fd7ced0:10f775db6e9:-8000:000000000000077D");

        // verify the type
        assertTrue("Expects CompositeState instance.", obj != null && obj instanceof CompositeState);

        CompositeState state = (CompositeState) obj;

        // verify the CompositeState properties
        assertFalse("The isSpecification property should be false.", state.isSpecification());
        assertFalse("The isConcurrent property should be false.", state.isConcurrent());
        assertEquals("The name should be top.", "top", state.getName());

        assertEquals("Expects two subvertexs.", 2, state.getSubVertexes().size());

        Iterator it = state.getSubVertexes().iterator();
        StateVertex vertex1 = (StateVertex) it.next();
        StateVertex vertex2 = (StateVertex) it.next();

        // verify the type of the two state vertex.
        if (vertex1 instanceof CompositeState) {
            assertTrue("Expects SimpleState instance.", vertex2 instanceof SimpleState);
        } else {
            assertTrue("Expects SimpleState instance.", vertex1 instanceof SimpleState);
            assertTrue("Expects CompositeState instance.", vertex2 instanceof CompositeState);
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:FinalState element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testFinalState() throws Exception {
        reader.parse(new File("test_files" + File.separator + "FinalState.xmi"));

        Object obj = reader.getElement("-64--88-1-88--330f1536:10f79802023:-8000:000000000000091A");

        // verify the type
        assertTrue("Expects FinalState instance.", obj != null && obj instanceof FinalState);

        FinalState state = (FinalState) obj;

        // verify the FinalState properties
        assertFalse("The isSpecification property should be false.", state.isSpecification());
        assertEquals("Expects one incoming transition.", 1, state.getIncomingTransitions().size());
        assertNotNull("Expects the incoming transition is set.", state.getIncomingTransitions().iterator().next());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Guard element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testGuard() throws Exception {
        reader.parse(new File("test_files" + File.separator + "Guard.xmi"));

        Object obj = reader.getElement("-64--88-1-88--7780ee65:10f7765ac05:-8000:00000000000007EC");

        // verify the type
        assertTrue("Expects Guard instance.", obj != null && obj instanceof Guard);

        Guard guard = (Guard) obj;

        // verify the FinalState properties
        assertFalse("The isSpecification property should be false.", guard.isSpecification());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:ObjectFlowState element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testObjectFlowState() throws Exception {
        reader.parse(new File("test_files" + File.separator + "ObjectFlowState.xmi"));

        Object obj = reader.getElement("-64--88-1-88--330f1536:10f79802023:-8000:0000000000000A4B");

        // verify the type
        assertTrue("Expects ObjectFlowState instance.", obj != null && obj instanceof ObjectFlowState);

        ObjectFlowState state = (ObjectFlowState) obj;

        // verify the ObjectFlowState properties
        assertFalse("The isSpecification property should be false.", state.isSpecification());
        assertFalse("The isSync property should be false.", state.isSynch());
        assertEquals("Expects one outgoing transition.", 1, state.getOutgoingTransitions().size());
        assertNotNull("Expects the outgoing transition is set.", state.getOutgoingTransitions().iterator().next());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Pseudostate element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testPseudostate() throws Exception {
        reader.parse(new File("test_files" + File.separator + "Pseudostate.xmi"));

        Object obj = reader.getElement("-64--88-1-88--330f1536:10f79802023:-8000:0000000000000B20");

        // verify the type
        assertTrue("Expects Pseudostate instance.", obj != null && obj instanceof Pseudostate);

        Pseudostate state = (Pseudostate) obj;

        // verify the Pseudostate properties
        assertFalse("The isSpecification property should be false.", state.isSpecification());
        assertEquals("Expects the kind property is set to JUNCTION.", PseudostateKind.JUNCTION, state.getKind());
        assertEquals("Expects one incoming transition.", 1, state.getIncomingTransitions().size());
        assertNotNull("Expects the incoming transition is set.", state.getIncomingTransitions().iterator().next());
        assertEquals("Expects two outgoing transitions.", 2, state.getOutgoingTransitions().size());
        Iterator it = state.getOutgoingTransitions().iterator();
        assertNotNull("Expects the outgoing transition is set.", it.next());
        assertNotNull("Expects the outgoing transition is set.", it.next());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:SimpleState element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testSimpleState() throws Exception {
        reader.parse(new File("test_files" + File.separator + "SimpleState.xmi"));

        Object obj = reader.getElement("-64--88-1-88--330f1536:10f79802023:-8000:00000000000008AF");

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
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:StateMachine element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testStateMachine() throws Exception {
        reader.parse(new File("test_files" + File.separator + "statemachine.xmi"));

        Object obj = reader.getElement("-64--88-1-88-1fd7ced0:10f775db6e9:-8000:000000000000077C");

        // verify the type
        assertTrue("Expects StateMachine instance.", obj != null && obj instanceof StateMachine);

        StateMachine stateMachine = (StateMachine) obj;

        // verify the StateMachine properties
        assertFalse("The isSpecification property should be false.", stateMachine.isSpecification());
        State state = stateMachine.getTop();
        assertTrue("Expects CompositeState instance.", state != null && state instanceof CompositeState);
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for accuracy.
     * </p>
     *
     * <p>
     * Verify : the UML:Transition element is parsed correctly.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testTransition() throws Exception {
        reader.parse(new File("test_files" + File.separator + "transition.xmi"));

        Object obj = reader.getElement("-64--88-1-88-1fd7ced0:10f775db6e9:-8000:000000000000077F");

        // verify the type
        assertTrue("Expects Transition instance.", obj != null && obj instanceof Transition);

        Transition transition = (Transition) obj;

        // verify the Transition properties
        assertFalse("The isSpecification property should be false.", transition.isSpecification());
        assertNotNull("Expects the source property be set.", transition.getSource());
        assertNotNull("Expects the target property be set.", transition.getTarget());
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when the xmi reader is null for the activityHandler during parsing
     * and expects IllegalStateException.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNullXMIReader() throws Exception {
        ActivityGraphXMIHandler activityHandler = new ActivityGraphXMIHandler();
        reader.addHandler("UML:Transition", activityHandler);

        try {
            reader.parse(new File("test_files" + File.separator + "transition.xmi"));
            fail("IllegalStateException expected.");
        } catch (IllegalStateException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:StateMachine in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForStatementMachine() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:StateMachine");

        try {
            reader.parse(new File("test_files" + File.separator + "statemachine_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Transition in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForTransition() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Transition");

        try {
            reader.parse(new File("test_files" + File.separator + "statemachine_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Guard in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForGuard() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Guard");

        try {
            reader.parse(new File("test_files" + File.separator + "statemachine_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:Pseudostate in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForPseudostate() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:Pseudostate");

        try {
            reader.parse(new File("test_files" + File.separator + "Pseudostate.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:CompositeState in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForCompositeState() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:CompositeState");

        try {
            reader.parse(new File("test_files" + File.separator + "statemachine_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:SimpleState in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForSimpleState() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:SimpleState");

        try {
            reader.parse(new File("test_files" + File.separator + "statemachine_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:FinalState in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForFinalState() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:FinalState");

        try {
            reader.parse(new File("test_files" + File.separator + "statemachine_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:ActivityGraph in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForActivityGraph() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:ActivityGraph");

        try {
            reader.parse(new File("test_files" + File.separator + "activitygraph_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:ActionState in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForActionState() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:ActionState");

        try {
            reader.parse(new File("test_files" + File.separator + "activitygraph_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:CallState in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForCallState() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:CallState");

        try {
            reader.parse(new File("test_files" + File.separator + "activitygraph_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }

    /**
     * <p>
     * Tests {@link ActivityGraphXMIHandler#startElement(String, String, String, org.xml.sax.Attributes) }
     * and {@link ActivityGraphXMIHandler#endElement(String, String, String) } for failure.
     * </p>
     *
     * <p>
     * It tests the case when no mapping for UML:ObjectFlowState in ModelElementFactory and expects
     * XMIReaderParseException.
     * XMIReaderParseException is caused by the SAXException thrown by the ActivityGraphXMIHandler.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNoModelElementForObjectFlowState() throws Exception {
        handler.getModelElementFactory().removeMapping("UML:ObjectFlowState");

        try {
            reader.parse(new File("test_files" + File.separator + "activitygraph_sample.xmi"));
            fail("XMIReaderParseException expected.");
        } catch (XMIReaderParseException e) {
            // good
        }
    }
}