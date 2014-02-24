/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.accuracytests;

import java.util.ArrayList;

import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;
/**
 * The accuracy test of the class <code>FinalStateImpl</code>.
 *
 * @author hfx
 * @version 1.0
 */
public class FinalStateImplAccuracyTests extends TestCase {
    /**
     * The accuracy test of the default ctor.
     *
     */
    public void test_default_ctor() {
        assertNotNull("can not create the instance.", new FinalStateImpl());
    }
    /**
     * The accuracy test of the default ctor.
     *
     */
    public void test_ctor_withParameters() {
        assertNotNull("can not create the instance.",
                new FinalStateImpl(new CompositeStateImpl(), new ArrayList<Transition>(),
                        new ArrayList<Transition>(), new StateMachineImpl()));
    }
}
