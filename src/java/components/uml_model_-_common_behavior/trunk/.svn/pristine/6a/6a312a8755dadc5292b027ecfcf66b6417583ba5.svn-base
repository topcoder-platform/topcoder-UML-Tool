/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.accuracytests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.actions.Action;
import com.topcoder.uml.model.actions.ActionAbstractImpl;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.procedure.ProcedureImpl;
import com.topcoder.uml.model.core.Method;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;

import junit.framework.TestCase;

/**
 * AccuracyTest for ProcedureImpl class.
 *
 * @author iamajia
 * @version 1.0
 */
public class ProcedureImplAccuracyTest extends TestCase {
    /**
     * This inctance is used in the test.
     */
    private ProcedureImpl procedure = new ProcedureImpl();
    /**
     * This instance is used in the test.
     */
    private Stimulus stimulus1 = new StimulusImpl();
    /**
     * This instance is used in the test.
     */
    private Stimulus stimulus2 = new StimulusImpl();
    /**
     * This instance is used in the test.
     */
    private Collection<Stimulus> stimuli = new ArrayList<Stimulus>();

    /**
     * Accuracy test of <code>ProcedureImpl()</code> constructor.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testProcedureImplAccuracy() throws Exception {
        assertNotNull("instance should be created.", procedure);
        assertNull("initial value should be null.", procedure.getAction());
        assertNull("initial value should be null.", procedure.getBody());
        assertNull("initial value should be null.", procedure.getExpression());
        assertNull("initial value should be null.", procedure.getLanguage());
        assertNull("initial value should be null.", procedure.getMethod());
        assertFalse("initial value should be false.", procedure.isList());
        assertEquals("count should be 0.", 0, procedure.countStimuli());
    }

    /**
     * Accuracy test of <code>getLanguage()</code> and <code>setLanguage(String language)</code> methods.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetLanguageAccuracy() throws Exception {
        procedure.setLanguage("java");
        assertEquals("language is incorrect.", "java", procedure.getLanguage());
        procedure.setLanguage(null);
        assertNull("language should be null.", procedure.getLanguage());
    }


    /**
     * Accuracy test of <code>getBody()</code> and <code>setBody(String body)</code> methods.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetBodyAccuracy() throws Exception {
        procedure.setBody("test");
        assertEquals("body should be 'test'", "test", procedure.getBody());
        procedure.setBody(null);
        assertNull("body should be null.", procedure.getBody());
    }

    /**
     * Accuracy test of <code>isList()</code> and <code>setList(boolean list)</code> methods.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testIsSetListAccuracy() throws Exception {
        procedure.setList(true);
        assertTrue("list should be true.", procedure.isList());
        procedure.setList(false);
        assertFalse("list should be false", procedure.isList());
    }

    /**
     * Accuracy test of <code>getExpression()</code> and <code>setExpression(Expression expression)</code> methods.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetExpressionAccuracy() throws Exception {
        Expression expression = new ExpressionImpl();
        procedure.setExpression(expression);
        assertEquals("expression is incorrect.", expression, procedure.getExpression());
        procedure.setExpression(null);
        assertNull("expression should be null.", procedure.getExpression());
    }

    /**
     * Accuracy test of <code>getMethod()</code> and <code>setMethod(Method method)</code> methods.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetMethodAccuracy() throws Exception {
        Method method = new MethodImpl();
        procedure.setMethod(method);
        assertEquals("method is incorrect.", method, procedure.getMethod());
        procedure.setMethod(null);
        assertNull("method should be null.", procedure.getMethod());
    }

    /**
     * Accuracy test of <code>addStimulus(Stimulus stimulus)</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddStimulusAccuracy() throws Exception {
        procedure.addStimulus(stimulus1);
        assertEquals("count should 1.", 1, procedure.countStimuli());
    }

    /**
     * Accuracy test of <code>addStimuli(Collection&lt;Stimulus&gt; stimuli)</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testAddStimuliAccuracy() throws Exception {
        stimuli.add(stimulus1);
        stimuli.add(stimulus2);
        procedure.addStimuli(stimuli);
        assertEquals("stimuli is incorrect.", stimuli, procedure.getStimuli());
    }

    /**
     * Accuracy test of <code>removeStimulus(Stimulus stimulus)</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveStimulusAccuracy() throws Exception {
        procedure.addStimulus(stimulus1);
        assertTrue("result is incorrect.", procedure.removeStimulus(stimulus1));
        assertFalse("result is incorrect.", procedure.removeStimulus(stimulus1));
    }

    /**
     * Accuracy test of <code>removeStimuli(Collection&lt;Stimulus&gt; stimuli)</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testRemoveStimuliAccuracy() throws Exception {
        procedure.addStimulus(stimulus1);
        procedure.addStimulus(stimulus1);
        procedure.addStimulus(stimulus2);
        stimuli.add(stimulus1);
        stimuli.add(stimulus2);
        procedure.removeStimuli(stimuli);
        assertEquals("result is incorrect.", 1, procedure.countStimuli());
    }

    /**
     * Accuracy test of <code>clearStimuli()</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testClearStimuliAccuracy() throws Exception {
        procedure.addStimulus(stimulus1);
        procedure.clearStimuli();
        assertEquals("count should 0.", 0, procedure.countStimuli());
    }

    /**
     * Accuracy test of <code>getStimuli()</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetStimuliAccuracy() throws Exception {
        Collection<Stimulus> expectStimuli = new ArrayList<Stimulus>();
        expectStimuli.add(stimulus1);
        expectStimuli.add(stimulus2);
        procedure.addStimuli(expectStimuli);
        assertEquals("stimuli is incorrect.", expectStimuli, procedure.getStimuli());
        procedure.getStimuli().clear();
        assertEquals("stimuli is incorrect.", expectStimuli, procedure.getStimuli());
    }

    /**
     * Accuracy test of <code>containsStimulus(Stimulus stimulus)</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testContainsStimulusAccuracy() throws Exception {
        procedure.addStimulus(stimulus1);
        assertTrue("it should be true.", procedure.containsStimulus(stimulus1));
    }

    /**
     * Accuracy test of <code>countStimuli()</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testCountStimuliAccuracy() throws Exception {
        procedure.addStimulus(stimulus1);
        assertEquals("count should 1.", 1, procedure.countStimuli());
    }

    /**
     * Accuracy test of <code>getAction()</code> method.
     *
     *
     * @throws Exception
     *             to junit.
     */
    public void testGetSetActionAccuracy() throws Exception {
        Action action = new ActionAbstractImpl() {
        };
        procedure.setAction(action);
        assertEquals("action is incorrect.", action, procedure.getAction());
        procedure.setAction(null);
        assertNull("action should be null.", procedure.getAction());
    }
}
