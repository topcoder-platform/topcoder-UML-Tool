/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;


/**
 * <p>This is a simple concrete implementation of Object interface and extends InstanceAbstractImpl.
 * An object is an instance that originates from a
 * class. In the metamodel, Object is a subclass of Instance and it originates from at least one
 * Class. The set of Classes may be modified dynamically, which means that the set of features of
 * the Object may change during its life-time. As such, all methods in Object are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class ObjectImpl extends InstanceAbstractImpl implements Object {
    /**
     * <p>Empty constructor.</p>
     *
     */
    public ObjectImpl() {
        // empty
    }
}
