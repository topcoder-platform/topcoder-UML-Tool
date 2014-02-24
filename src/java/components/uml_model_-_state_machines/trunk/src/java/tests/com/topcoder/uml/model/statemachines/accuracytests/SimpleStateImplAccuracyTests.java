/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.ArrayList;

import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;
/**
 * The accuracy test of the class <code>SimpleStateImpl</code>.
 *
 * @author hfx
 * @version 1.0
 */
public class SimpleStateImplAccuracyTests extends TestCase {
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("can not create the instance.", new SimpleStateImpl());
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_ctor_accuracy2() {
        assertNotNull("can not create the instance.",
                new SimpleStateImpl(new CompositeStateImpl(),
                        new ArrayList<Transition>(), new ArrayList<Transition>(), new StateMachineImpl()));
    }
}
