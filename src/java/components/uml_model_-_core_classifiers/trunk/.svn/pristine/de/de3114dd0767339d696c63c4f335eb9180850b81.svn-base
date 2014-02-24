/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.classifiers;

import com.topcoder.uml.model.core.ClassifierAbstractImpl;


/**
 * <p>This is a simple concrete implementation of Class interface and extends ClassifierAbstractImpl
 * from the Core Requirements component. A class is a description of a set of objects that share the same
 * attributes, operations, methods, relationships, and semantics. A class may use a set of
 * interfaces to specify collections of operations it provides to its environment. In the
 * metamodel, a Class describes a set of Objects sharing a collection of Features, including
 * Operations, Attributes, and Methods that are common to the set of Objects. Furthermore, a
 * Class may realize zero or more Interfaces; this means that its full descriptor must contain
 * every Operation from every realized Interface (it may contain additional operations as well).</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class ClassImpl extends ClassifierAbstractImpl implements Class {
    /**
     * <p>Specifies whether an Object of the Class maintains its own thread of control. If true,
     * then an Object has its own thread of control and runs concurrently with other active Objects.
     * Such a class is informally called an active class. If false, then Operations run in the
     * address space and under the control of the active Object that controls the caller. Such a
     * class is informally called a passive class.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter.</p>
     *
     */
    private boolean active = false;

    /**
     * <p>Empty constructor.</p>
     * <p>Initializes member variable as default value.</p>
     *
     */
    public ClassImpl() {
        // empty
    }

    /**
     * Gets the boolean active field value.
     *
     *
     * @return active field value
     */
    public boolean isActive() {
        return active;
    }

    /**
     * Sets the boolean active field value.
     *
     *
     * @param active active field value
     */
    public void setActive(boolean active) {
        this.active = active;
    }
}
