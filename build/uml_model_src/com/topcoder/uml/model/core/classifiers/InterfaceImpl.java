/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;


/**
 * <p>This is a simple concrete implementation of Interface interface and extends ClassifierAbstractImpl
 * from the Core Requirements component. An interface is a named set of operations that characterize the behavior
 * of an element. In the metamodel, an Interface contains a set of Operations that together
 * define a service offered by a Classifier realizing the Interface. A Classifier may offer
 * several services, which means that it may realize several Interfaces, and several Classifiers
 * may realize the same Interface.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class InterfaceImpl extends ClassifierAbstractImpl implements Interface {
    /**
     * <p>Empty constructor.</p>
     *
     */
    public InterfaceImpl() {
        // empty
    }
}
