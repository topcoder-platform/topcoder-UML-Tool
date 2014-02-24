/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.Classifier;


/**
 * <p>This interface extends Classifier interface. The Classifier interface comes form the Core
 * Requirements component. An interface is a named set of operations that characterize the behavior
 * of an element. In the metamodel, an Interface contains a set of Operations that together
 * define a service offered by a Classifier realizing the Interface. A Classifier may offer
 * several services, which means that it may realize several Interfaces, and several Classifiers
 * may realize the same Interface.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface Interface extends Classifier {
}
