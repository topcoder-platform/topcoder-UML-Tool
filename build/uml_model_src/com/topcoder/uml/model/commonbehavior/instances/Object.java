/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;


/**
 * <p>This interface extends Instance interface. An object is an instance that originates from a
 * class. In the metamodel, Object is a subclass of Instance and it originates from at least one
 * Class. The set of Classes may be modified dynamically, which means that the set of features of
 * the Object may change during its life-time.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface Object extends Instance {
}
