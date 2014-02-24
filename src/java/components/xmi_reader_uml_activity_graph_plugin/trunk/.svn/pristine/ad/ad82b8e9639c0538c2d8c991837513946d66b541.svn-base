/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.activitygraph.failuretests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.util.config.ConfigManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.XMIReaderParseException;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.activitygraph.ActivityGraphXMIHandler;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>ActivityGraphXMIHandler </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestActivityGraphXMIHandlerFailure extends TestCase {

    /**
     * Represents the ActivityGraphXMIHandler instance for testing.
     */
    private ActivityGraphXMIHandler handler = null;

    /**
     * Represents the XMIReader instance for testing.
     */
    private XMIReader reader = null;

    /**
     * Represents the ModelElementFactory instance for testing.
     */
    private ModelElementFactory factory = null;

    /**
     * Represents the UMLModelManager instace for testing.
     */
    private UMLModelManager manager = null;

    /**
     * Set up the environment.
     *
     * @throws Exception
     *             to junit.
     */
    public void setUp() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
            cm.removeNamespace((String) iter.next());
        }

        cm.add(new File("test_files/failure/xmi_reader.xml").getAbsolutePath());
        cm.add(new File("test_files/failure/ModelElementFactoryConfig2.xml").getAbsolutePath());

        reader = new XMIReader("xmireader");
        factory = new ModelElementFactory("ModelElementFactory");
        handler = (ActivityGraphXMIHandler) reader.getHandler("UML:StateMachine");

        handler.setModelElementFactory(factory);

        manager = UMLModelManager.getInstance();
    }

    /**
     * Tear down the environment. Clear all the namespaces in the config manager instance.
     *
     * @throws Exception
     *             to junit.
     */
    public void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();

        for (Iterator iter = cm.getAllNamespaces(); iter.hasNext();) {
            cm.removeNamespace((String) iter.next());
        }

        reader = null;
        handler = null;
    }

    /**
     * Test the constructor <code>ActivityGraphXMIHandler(XMIReader reader, ModelElementFactory modelElementFactory,
     * UMLModelManager modelManager) </code>.
     *
     * <p>
     * If the parameter is null, IllegalArgumentException should be raised.
     * </p>
     *
     */
    public void testActivityGraphXMIHandlerXMIReaderModelElementFactoryUMLModelManager_1() {
        try {
            new ActivityGraphXMIHandler(null, factory, manager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test the constructor <code>ActivityGraphXMIHandler(XMIReader reader, ModelElementFactory modelElementFactory,
     * UMLModelManager modelManager) </code>.
     *
     * <p>
     * If the parameter is null, IllegalArgumentException should be raised.
     * </p>
     *
     */
    public void testActivityGraphXMIHandlerXMIReaderModelElementFactoryUMLModelManager_2() {
        try {
            new ActivityGraphXMIHandler(reader, null, manager);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test the constructor <code>ActivityGraphXMIHandler(XMIReader reader, ModelElementFactory modelElementFactory,
     * UMLModelManager modelManager) </code>.
     *
     * <p>
     * If the parameter is null, IllegalArgumentException should be raised.
     * </p>
     *
     */
    public void testActivityGraphXMIHandlerXMIReaderModelElementFactoryUMLModelManager_3() {
        try {
            new ActivityGraphXMIHandler(reader, factory, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // ok.
        }
    }

    /**
     * Test method <code>void setModelElementFactory(ModelElementFactory modelElementFactory) </code>.
     *
     * <p>
     * If the modelElementFactory to be set is null, IllegalArgumentException should be raised.
     * </p>
     *
     */
    public void testSetModelElementFactory() {
        try {
            handler.setModelElementFactory(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // OK.
        }
    }

    /**
     * Test method <code>void setUmlModelManager(UMLModelManager modelManager) </code>.
     *
     * <p>
     * If the modelManager to be set is null, IllegalArgumentException should be raised.
     * </p>
     *
     */
    public void testSetUmlModelManager() {
        try {
            handler.setUmlModelManager(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /*
     * The rest of the test cases are testing the functionality of this component for failure.
     * This is the StateMachine copied from the xmi_example.xmi.
     */
    /*
    <UML:StateMachine xmi.id = 'I10ad419m10729d8da08mm7f50' name = 'StateMachine_1'
        isSpecification = 'false'>
        <UML:StateMachine.context>
          <UML:Class xmi.idref = 'I10ad419m10729d8da08mm7f51'/>
        </UML:StateMachine.context>
        <UML:StateMachine.top>
          <UML:CompositeState xmi.id = 'I10ad419m10729d8da08mm7f4f' name = '' isSpecification = 'false'
            isConcurrent = 'false'>
            <UML:CompositeState.subvertex>
              <UML:SimpleState xmi.id = 'I10ad419m10729d8da08mm7f45' name = 'Simple_State_1'
                visibility = 'public' isSpecification = 'false'>
                <UML:StateVertex.outgoing>
                  <UML:Transition xmi.idref = 'I10ad419m10729d8da08mm7f21'/>
                  <UML:Transition xmi.idref = 'I10ad419m10729d8da08mm7f18'/>
                </UML:StateVertex.outgoing>
              </UML:SimpleState>
              <UML:SimpleState xmi.id = 'I10ad419m10729d8da08mm7f3a' name = 'Simple_State_2'
                visibility = 'public' isSpecification = 'false'>
                <UML:StateVertex.outgoing>
                  <UML:Transition xmi.idref = 'I10ad419m10729d8da08mm7f2a'/>
                </UML:StateVertex.outgoing>
                <UML:StateVertex.incoming>
                  <UML:Transition xmi.idref = 'I10ad419m10729d8da08mm7f18'/>
                </UML:StateVertex.incoming>
              </UML:SimpleState>
              <UML:FinalState xmi.id = 'I10ad419m10729d8da08mm7f2f' name = 'Final_State_1'
                visibility = 'public' isSpecification = 'false'>
                <UML:StateVertex.incoming>
                  <UML:Transition xmi.idref = 'I10ad419m10729d8da08mm7f2a'/>
                  <UML:Transition xmi.idref = 'I10ad419m10729d8da08mm7f21'/>
                </UML:StateVertex.incoming>
              </UML:FinalState>
            </UML:CompositeState.subvertex>
          </UML:CompositeState>
        </UML:StateMachine.top>
        <UML:StateMachine.transitions>
          <UML:Transition xmi.id = 'I10ad419m10729d8da08mm7f2a' isSpecification = 'false'>
            <UML:Transition.guard>
              <UML:Guard xmi.id = 'I10ad419m10729d8da08mm7f05' name = '' visibility = 'public'
                isSpecification = 'false'>
                <UML:Guard.expression>
                  <UML:BooleanExpression xmi.id = 'I10ad419m10729d8da08mm7f04' language = 'java'
                    body = 'x &gt; 20'/>
                </UML:Guard.expression>
              </UML:Guard>
            </UML:Transition.guard>
            <UML:Transition.source>
              <UML:SimpleState xmi.idref = 'I10ad419m10729d8da08mm7f3a'/>
            </UML:Transition.source>
            <UML:Transition.target>
              <UML:FinalState xmi.idref = 'I10ad419m10729d8da08mm7f2f'/>
            </UML:Transition.target>
          </UML:Transition>
          <UML:Transition xmi.id = 'I10ad419m10729d8da08mm7f21' isSpecification = 'false'>
            <UML:Transition.guard>
              <UML:Guard xmi.id = 'I10ad419m10729d8da08mm7f0f' name = '' visibility = 'public'
                isSpecification = 'false'>
                <UML:Guard.expression>
                  <UML:BooleanExpression xmi.id = 'I10ad419m10729d8da08mm7f0e' language = 'java'
                    body = 'x &gt; 20'/>
                </UML:Guard.expression>
              </UML:Guard>
            </UML:Transition.guard>
            <UML:Transition.source>
              <UML:SimpleState xmi.idref = 'I10ad419m10729d8da08mm7f45'/>
            </UML:Transition.source>
            <UML:Transition.target>
              <UML:FinalState xmi.idref = 'I10ad419m10729d8da08mm7f2f'/>
            </UML:Transition.target>
          </UML:Transition>
          <UML:Transition xmi.id = 'I10ad419m10729d8da08mm7f18' isSpecification = 'false'>
            <UML:Transition.source>
              <UML:SimpleState xmi.idref = 'I10ad419m10729d8da08mm7f45'/>
            </UML:Transition.source>
            <UML:Transition.target>
              <UML:SimpleState xmi.idref = 'I10ad419m10729d8da08mm7f3a'/>
            </UML:Transition.target>
          </UML:Transition>
        </UML:StateMachine.transitions>
      </UML:StateMachine>

      */

    /**
     * <p>
     * If no mapping to UML:StateMachine, XMIReaderParseException should be raised.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testInnerException_1() throws Exception {
        try {
            handler.getModelElementFactory().removeMapping("UML:StateMachine");
            reader.parse(new File("test_files/failure/xmi_example.xmi"));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException e) {
            // Ok.
        }
    }

    /**
     * <p>
     * If no mapping to UML:CompositeState, XMIReaderParseException should be raised.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testInnerException_2() throws Exception {
        try {
            handler.getModelElementFactory().removeMapping("UML:CompositeState");
            reader.parse(new File("test_files/failure/xmi_example.xmi"));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException e) {
            // Ok.
        }
    }

    /**
     * <p>
     * If no mapping to UML:SimpleState, XMIReaderParseException should be raised.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testInnerException_3() throws Exception {
        try {
            handler.getModelElementFactory().removeMapping("UML:SimpleState");
            reader.parse(new File("test_files/failure/xmi_example.xmi"));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException e) {
            // Ok.
        }
    }

    /**
     * <p>
     * If no mapping to UML:FinalState, XMIReaderParseException should be raised.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testInnerException_4() throws Exception {
        try {
            handler.getModelElementFactory().removeMapping("UML:FinalState");
            reader.parse(new File("test_files/failure/xmi_example.xmi"));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException e) {
            // Ok.
        }
    }


    /**
     * <p>
     * If no mapping to UML:Transition, XMIReaderParseException should be raised.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testInnerException_5() throws Exception {
        try {
            handler.getModelElementFactory().removeMapping("UML:Transition");
            reader.parse(new File("test_files/failure/xmi_example.xmi"));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException e) {
            // Ok.
        }
    }

    /**
     * <p>
     * If no mapping to UML:Guard, XMIReaderParseException should be raised.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testInnerException_6() throws Exception {
        try {
            handler.getModelElementFactory().removeMapping("UML:Guard");
            reader.parse(new File("test_files/failure/xmi_example.xmi"));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException e) {
            // Ok.
        }
    }

    /**
     * <p>
     * The format is not valid. XMIReaderParseException should be raised.
     * </p>
     *
     * @throws Exception
     *             to junit.
     */
    public void testInnerException_7() throws Exception {
        try {
            reader.parse(new File("test_files/failure/invalidtransition.xmi"));
            fail("XMIReaderParseException is expected.");
        } catch (XMIReaderParseException e) {
            // Ok.
        }
    }
}