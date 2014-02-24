/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.ArrayList;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;
/**
 * The accuracy test of the class <code>PseudostateImpl</code>.
 *
 * @author hfx
 * @version 1.0
 */
public class PseudostateImplAccuracyTests extends TestCase {
    /**
     * The PseudostateImpl instance for testing.
     */
    private PseudostateImpl pseudostateImpl = null;
    /**
     * The setUp, create the instance for testing.
     */
    protected void setUp() {
        pseudostateImpl = new PseudostateImpl();
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("can not create the PseudostateImpl.", new PseudostateImpl());
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy2() {
        assertNotNull("can not create the PseudostateImpl.",
                new PseudostateImpl(new CompositeStateImpl(), new ArrayList<Transition>(),
                        new ArrayList<Transition>(), PseudostateKind.CHOICE));
    }
    /**
     * The accuracy test of the method getKind and setKind.
     *
     */
    public void test_setKindAndGetKind() {
        pseudostateImpl.setKind(PseudostateKind.CHOICE);
        assertTrue("The kind is not set correctly.", PseudostateKind.CHOICE == pseudostateImpl.getKind());
    }
}
